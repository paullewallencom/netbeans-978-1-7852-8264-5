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
package com.davidsalter.kb.web;

import com.davidsalter.kb.data.ArticleRepository;
import com.davidsalter.kb.entity.Article;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.bson.types.ObjectId;

/**
 * JSF CDI bean responsible for managing the viewing of articles.
 * 
 * @author <a href="mailto:david@developinjava.com">David Salter</a>
 */
@Named
@SessionScoped
public class ViewArticleBean implements Serializable {
    
    private String id;

    @Inject
    ArticleRepository mongoArticleRepository;

    private Article article = new Article();

    /**
     * Default constructor for the class.
     */
    public ViewArticleBean() {
    }

    /**
     * Stores the id of the article to view and retrieves the article from the database.
     * @param id The id of the article to view.
     */
    public void setId(String id) {
        
        this.id = id;

        article = mongoArticleRepository.getArticle(new ObjectId(this.id));
    }

    /**
     * Retrieves the id of the article currently being viewed.
     * @return Document id
     */
    public String getId() {
        return id;
    }

    /**
     * Return the article for use as el in a JSF page.
     * @return The article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Store the article being viewed.
     * @param article The article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * JSF action method returning the view to be displayed for viewing an article.
     * @return The JSF view
     */
    public String viewArticle() {
        return "viewArticle.xhtml";
    }
}
