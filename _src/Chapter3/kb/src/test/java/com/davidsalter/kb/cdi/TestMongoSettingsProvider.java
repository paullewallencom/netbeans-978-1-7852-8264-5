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
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author <a href="mailto:david@developinjava.com>David Salter</a>
 */
@ApplicationScoped
public class TestMongoSettingsProvider implements Serializable {
    
    @Produces
    public MongoSettings getMongoSettings() {
        MongoSettings mongoSettings = new MongoSettings(37017, "localhost");
        return mongoSettings;
    }
}
