 /*
 * Copyright 2014-2015 David Salter <david@developinjava.com>.
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
package com.davidsalter.kb.cdi;

import com.davidsalter.kb.data.MongoSettings;
import com.davidsalter.kb.entity.Article;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author <a href="mailto:david@developinjava.com">David Salter</a>
 */
@ApplicationScoped
@Named
public class DatastoreProducer implements Serializable {
    
    private Datastore datastore = null;

    @Inject
    @MongoConnection
    MongoSettings mongoSettings;
        
    @PostConstruct
    public void init() {
        
        MongoClient mongoClient;
        try {
            System.out.println("About to connect to mongo."+mongoSettings.getHost()+":"+mongoSettings.getPort());
            mongoClient = new MongoClient(mongoSettings.getHost(), mongoSettings.getPort());
            System.out.println("Connected to mongo.");
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatastoreProducer.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Could not connect to mongo.");
        }
        
        Morphia morphia = new Morphia();
        morphia.map(Article.class);
        
        datastore = morphia.createDatastore(mongoClient, "kb");
        datastore.ensureIndexes();
        
        DB db = mongoClient.getDB("kb");
        
        DBCollection articleCollection = db.getCollection("Article");
        articleCollection.createIndex(new BasicDBObject("body", "text"));

    }
    
    
    @Produces
    public Datastore getDatastore() {
        return datastore;
    }
}
