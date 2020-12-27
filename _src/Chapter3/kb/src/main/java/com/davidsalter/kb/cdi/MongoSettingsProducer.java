/*
 * Copyright 2014 <a href="mailto:david@developinjava.com>David Salter</a>.
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
import java.io.Serializable;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author <a href="mailto:david@developinjava.com>David Salter</a>
 */
@SessionScoped
public class MongoSettingsProducer implements Serializable {

    @Resource(lookup = "hostName")
    private String address;
        
    @Produces
    @MongoConnection
    public MongoSettings getMongoSettings() {

        System.out.println("REsource Lookup:"+address);
        
        MongoSettings mongoSettings = new MongoSettings(27017, "localhost");

        return mongoSettings;
    }
}
