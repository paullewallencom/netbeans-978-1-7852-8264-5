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
package com.davidsalter.kb.entity;

import java.util.Date;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Salter david@developinjava.com
 */
public class ArticleTest {
    
    public ArticleTest() {
    }

    @Test
    public void whenAnIdPropertyIsSetThenItShouldBeRetrievable() {
        Article article = new Article();
        ObjectId objectId = new ObjectId("54591a560364f33f00c522f3");
        
        article.setId(objectId);
        ObjectId returnedId = article.getId();
        
        assertEquals("ObjectId is not set/retrieved correctly.", objectId, returnedId);
    }
    
    @Test
    public void whenANamePropertyIsSetThenItShouldBeRetrievable() {
        Article article = new Article();
        String name = "A random name";
        
        article.setName(name);
        String returnedName = article.getName();
        
        assertEquals("Name is not set/retrieved correctly.", name, returnedName);
    }
    
    @Test
    public void whenABodyPropertyIsSetThenItShouldBeRetrievable() {
        Article article = new Article();
        String body = "Some text contents";
        
        article.setBody(body);
        String returnedBody = article.getBody();
        
        assertEquals("Body is not set/retrieved correctly.", body, returnedBody);
    }
    
    @Test
    public void whenADateCreatedPropertyIsSetThenItShouldBeRetrievable() {
        Article article = new Article();
        Date date = new Date();
        
        article.setDateCreated(date);
        Date returnedDate = article.getDateCreated();
        
        assertEquals("Date is not set/retrieved correctly.", date, returnedDate);
    }
    
    @Test
    public void whenAViewsPropertyIsSetThenItShouldBeRetrievable() {
        Article article = new Article();
        
        int views = 1234;
        article.setViews(views);
        int returnedViews = article.getViews();
        
        assertEquals("Views is not set/retrieved correctly.", views, returnedViews);
    }
    
    @Test
    public void whenAnArticleIsCreatedIExpectItToHaveNoHashCodeIfTheIdIsNotSet() {
        Article article = new Article();
        
        int hashCode = article.hashCode();
        
        assertEquals("Invalid hash code generated.", hashCode, 0);
    }
    
    @Test
    public void whenAnArticleIsCreatedIExpectItToHaveAHashCodeIfTheIdIsSet() {
        Article article = new Article();
        ObjectId objectId = new ObjectId("54591a560364f33f00c522f3");
        article.setId(objectId);
        
        int hashCode = article.hashCode();
        
        assertNotEquals("Invalid hash code generated.", hashCode, 0);
    }
    
    @Test
    public void whenAnArticleIsCreatedIExpectItToHaveAToStringMethod() {
        Article article = new Article();
        ObjectId objectId = new ObjectId("54591a560364f33f00c522f3");
        article.setId(objectId);
        
        String stringRepresentation = article.toString();
        
        assertTrue("toString does not contain class name.", stringRepresentation.contains("com.davidsalter.kb.entity.Article"));
        assertTrue("toString does not contain id property.", stringRepresentation.contains("54591a560364f33f00c522f3"));
    }
    
    @Test
    public void whenAnArticleIsComparedToAnInstanceOfADifferentClassIExpectThemToBeDifferent() {
        Article article = new Article();
        
        String randomString = "abc";
        boolean areEqual = article.equals(randomString);
        
        assertFalse("Article incorrectly equates to object of a different type.", areEqual);
    }
    
    @Test
    public void whenTwoArticlesAreComparedWithDifferentIdsIExpectThemToBeDifferent() {
        Article article1 = new Article();
        Article article2 = new Article();
        article1.setId(new ObjectId("54591a560364f33f00c522f3"));
        article2.setId(new ObjectId("54591a560364f33f00c522f4"));        
        
        boolean areEqual = article1.equals(article2);
        
        assertFalse("Article incorrectly equates to article with different id.", areEqual);
    }
    
    @Test
    public void whenTwoArticlesAreComparedWithSameIdsIExpectThemToBeTheSame() {
        Article article1 = new Article();
        Article article2 = new Article();
        article1.setId(new ObjectId("54591a560364f33f00c522f3"));
        article2.setId(new ObjectId("54591a560364f33f00c522f3"));        
        
        boolean areEqual = article1.equals(article2);
        
        assertTrue("Article incorrectly differs to article with same id.", areEqual);
    }
}
