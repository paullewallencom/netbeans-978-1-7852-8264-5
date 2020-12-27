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
package com.davidsalter.kb.data;

import com.davidsalter.kb.entity.Article;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author <a href="mailto:david@developinjava.com">David Salter</a>
 */
@Named("mongoArticleRepository")
@Dependent
public class MongoArticleRepository implements Serializable, ArticleRepository {
    
    public MongoArticleRepository() {
    }
    
    @Inject
    private Datastore ds;
    
    @Override
    public List<Article> findAll() {
        return ds.find(Article.class).asList();
    }

    @Override
    public List<Article> findLatest(int count) {
        Query query = ds.createQuery(Article.class).order("-dateCreated").limit(count);
        
        List<Article> results = query.asList();
        
        return results;
    }
            
    @Override
    public void deleteArticle(Article article) {
        ds.delete(article);
    }

    @Override
    public Article getArticle(ObjectId id) {
        System.out.println("Asking for document: " + id);
        
        return ds.get(Article.class, id);
    }

    @Override
    public void editArticle(Article article) {
        ds.save(article);
    }

    @Override
    public void addArticle(Article article) {
        article.setDateCreated(new Date());
        ds.save(article);
    }

    @Override
    public ArrayList<Article> findInBody(String query, int maxResults) {
        
        ArrayList<Article> articles = new ArrayList<Article>();

        DBCollection articleCollection = ds.getDB().getCollection("Article");
        BasicDBObject search = new BasicDBObject("$search", query);
        BasicDBObject textSearch = new BasicDBObject("$text", search);
        DBCursor cursor = articleCollection.find(textSearch).limit(maxResults);
        
        while (cursor.hasNext()) {
            DBObject obj = cursor.next();
            Article article = new Article();
            article.setId((ObjectId) obj.get("_id"));
            article.setName((String) obj.get("name"));
            
            articles.add(article);
        }
        
        return articles;
    }
    
}
