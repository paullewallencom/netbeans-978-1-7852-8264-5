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
package com.davidsalter.kb.data;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author David Salter <david@developinjava.com>
 */
public class MongoSettingsTest {

    @Test
    public void whenAPortIsSetThenItShouldBeRetrievable() {
        MongoSettings settings = new MongoSettings();

        int port = 12345;
        settings.setPort(port);
        int returnedPort = settings.getPort();

        assertEquals("Port is not set/retrieved correctly.", port, returnedPort);
    }

    @Test
    public void whenAHostIsSetThenItShouldBeRetrievable() {
        MongoSettings settings = new MongoSettings();

        String host = "localhost";
        settings.setHost(host);
        String returnedHost = settings.getHost();

        assertEquals("Host is not set/retrieved correctly.", host, returnedHost);
    }

    @Test
    public void whenPortAndHostIsSetThenItShouldBeRetrievable() {

        String host = "localhost";
        int port = 12345;
        MongoSettings settings = new MongoSettings(port, host);

        String returnedHost = settings.getHost();
        int returnedPort = settings.getPort();

        assertEquals("Host is not set/retrieved correctly.", host, returnedHost);
        assertEquals("Port is not set/retrieved correctly.", port, returnedPort);
    }

}
