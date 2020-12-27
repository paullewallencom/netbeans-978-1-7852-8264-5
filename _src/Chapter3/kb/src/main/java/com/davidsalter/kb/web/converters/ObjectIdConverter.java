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
package com.davidsalter.kb.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.bson.types.ObjectId;

/**
 * JSF converter responsible for converting between string ids and Mongo ObjectId.
 * 
 * @author <a href="mailto:david@developinjava.com">David Salter</a>
 */
@FacesConverter("com.davidsalter.kb.web.converters.ObjectIdConverter")
public class ObjectIdConverter implements Converter {

    /**
     * Convert a String id into a Mongo ObjectId
     * @param context The Faces context
     * @param component The UIComponent
     * @param value The string id being converted
     * @return The id as an {@link org.bson.types.ObjectId ObjectId}, null if the <code>value</code> is empty.
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        } else {
            ObjectId id = new ObjectId(value);
            return id;
        }
    }

    /**
     * Convert a Mongo ObjectId into a String id.
     * @param context The Faces context
     * @param component The UIComponent
     * @param value The ObjectId being converted
     * @return The id as a String.
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((ObjectId) value).toString();
    }

}
