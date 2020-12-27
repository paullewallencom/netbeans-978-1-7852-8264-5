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
import java.util.ArrayList;
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
public class QueryBean implements Serializable {

    @Inject
    private MongoArticleRepository mongoArticleRepository;

    private String query;

    private ArrayList<Article> articles = new ArrayList<Article>();

    public QueryBean() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public String performQuery() {
        int maxResults = 10;

        articles = mongoArticleRepository.findInBody(query, maxResults);
        return "";
    }
    

}
