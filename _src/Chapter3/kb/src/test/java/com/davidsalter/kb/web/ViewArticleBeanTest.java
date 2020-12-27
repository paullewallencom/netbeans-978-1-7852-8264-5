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
package com.davidsalter.kb.web;

import com.davidsalter.kb.entity.Article;
import org.bson.types.ObjectId;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Salter david@developinjava.com
 */
public class ViewArticleBeanTest {
    
    public ViewArticleBeanTest() {
    }

    @Test
    public void whenIViewAnArticleIExpectToBeDirectedToTheViewArticlePage() {
        ViewArticleBean bean = new ViewArticleBean();
        
        String page = bean.viewArticle();
        
        assertEquals("Incorrect page when viewing article.", "viewArticle.xhtml", page);
    }
    
    @Test
    public void whenISetAnArticleIExpectToBeAbleToGetTheArticle() {
        ViewArticleBean bean = new ViewArticleBean();
        Article article = new Article();
        article.setId(new ObjectId("54591a560364f33f00c522f3"));
        
        bean.setArticle(article);
        Article retrievedArticle = bean.getArticle();
        
        assertEquals("Article is not set/retrieved correctly.", article, retrievedArticle);
    }
}
