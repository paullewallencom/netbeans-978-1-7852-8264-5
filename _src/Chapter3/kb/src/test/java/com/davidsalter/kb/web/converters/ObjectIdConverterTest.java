/*
 * Copyright 2014 David Salter <david@developinjava.com>.
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
package com.davidsalter.kb.web.converters;

import com.davidsalter.kb.web.ViewArticleBeanArquillianTest;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Salter david@developinjava.com
 */
public class ObjectIdConverterTest {

    public ObjectIdConverterTest() {
    }

    @Test
    public void whenIConvertAnObjectIdToAStringIExpectAValidString() {
        ObjectIdConverter converter = new ObjectIdConverter();
        ObjectId objectId = new ObjectId("54591a560364f33f00c522f3");

        String stringId = converter.getAsString(null, null, objectId);

        assertEquals("ObjectId converted incorrectly into a String.", "54591a560364f33f00c522f3", stringId);
    }

    @Test
    public void whenIConvertAStringIntoAnObjectIdIExpectAValidObjectId() {
        ObjectIdConverter converter = new ObjectIdConverter();
        String stringId = "54591a560364f33f00c522f3";

        ObjectId objectId = (ObjectId) converter.getAsObject(null, null, stringId);

        assertEquals("String converted incorrectly into an ObjectId.", stringId, objectId.toString());
    }

    @Test
    public void whenIConvertAnEmptyStringIExpectToGetANullObjectReturned() {
        ObjectIdConverter converter = new ObjectIdConverter();

        ObjectId objectId = (ObjectId) converter.getAsObject(null, null, "");

        assertNull("Empty string incorrectly converted to ObjectId.", objectId);
    }

}
