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
package com.davidsalter.kb.web;

import com.davidsalter.kb.data.MongoArticleRepository;
import com.davidsalter.kb.entity.Article;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author <a href="mailto:david@developinjava.com>David Salter</a>
 */
@Named
@SessionScoped
public class RecentArticlesBean implements Serializable {
    
    @Inject
    private MongoArticleRepository mongoArticleRepository;

    private List<Article> articles = new ArrayList<Article>();

    public RecentArticlesBean() {
    }

    public List<Article> getArticles() {

        articles = mongoArticleRepository.findLatest(5);
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
