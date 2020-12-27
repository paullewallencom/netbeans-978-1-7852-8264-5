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
package com.davidsalter.kb.web;

import com.davidsalter.kb.data.MongoArticleRepository;
import com.davidsalter.kb.entity.Article;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;
import org.bson.types.ObjectId;

/**
 *
 * @author <a href="mailto:david@developinjava.com">David Salter</a>
 */
@Named
@SessionScoped
public class ArticleBean implements Serializable {

    public ArticleBean() {
    }
    
    @ManagedProperty("#{param.id}")
    private ObjectId id;

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    private Article article;

    @Inject
    private MongoArticleRepository mongoArticleRepository;

    public List<Article> getArticles() {
        return mongoArticleRepository.findAll();
    }

    public Article getArticle() {
        if (article == null) {
            article = new Article();
        }
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String create() {
        article = new Article();
        return "article_new.xhtml";
    }

    public String delete() {
        System.out.println("Deleting:"+article.getName());
        mongoArticleRepository.deleteArticle(article);
        return "articles.xhtml";
    }

    public String edit() {
        article = mongoArticleRepository.getArticle(id);
        return "article_edit.xhtml";
    }

    public String update() {
        System.out.println("Updating:"+article.getName());
        mongoArticleRepository.editArticle(article);
        return "articles.xhtml";
    }

    public String persist() {
        mongoArticleRepository.addArticle(article);
        return "articles.xhtml";
    }
}
