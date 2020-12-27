/*
 * Copyright 2014 David Salter david@developinjava.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.davidsalter.kb.test;

import com.davidsalter.kb.data.MongoSettings;
import com.davidsalter.kb.entity.Article;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author David Salter david@developinjava.com
 */
public class TestInMemoryMongo {

    @Inject
    MongoSettings mongoSettings;
    
    MongodExecutable mongodExecutable = null;

    @Before
    public void setup() throws Exception {
        MongodStarter starter = MongodStarter.getDefaultInstance();

        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(mongoSettings.getPort(), Network.localhostIsIPv6()))
                .build();

        mongodExecutable = starter.prepare(mongodConfig);
        MongodProcess mongod = mongodExecutable.start();

        // Add a sample document to the Article collection;
        MongoClient mongo = new MongoClient(mongoSettings.getHost(), mongoSettings.getPort());
        Morphia morphia = new Morphia();
        
        Datastore datastore = morphia.createDatastore(mongo, "kb");
        Article article = new Article();
        article.setBody("this is the body of the article");
        article.setName("name");
        article.setId(new ObjectId("54591a560364f33f00c522f3"));
        datastore.save(article);
    }

    @After
    public void teardown() throws Exception {
        if (mongodExecutable != null) {
            mongodExecutable.stop();
        }
    }

}
