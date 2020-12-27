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

import com.davidsalter.kb.test.TestInMemoryMongo;
import com.davidsalter.kb.cdi.DatastoreProducer;
import com.davidsalter.kb.cdi.TestMongoSettingsProvider;
import com.davidsalter.kb.data.ArticleRepository;
import com.davidsalter.kb.data.MongoArticleRepository;
import com.davidsalter.kb.data.MongoSettings;
import com.davidsalter.kb.entity.Article;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author <a href="mailto:david@developinjava.com>David Salter</a>
 */
@RunWith(Arquillian.class)
public class ViewArticleBeanArquillianTest extends TestInMemoryMongo {

    public ViewArticleBeanArquillianTest() {
    }

    @Deployment
    public static Archive<?> createDeployment() {
        
        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClass(TestInMemoryMongo.class)
                .addAsWebInfResource(new StringAsset("<web-app></web-app>"), "web.xml")
                .addPackage(Article.class.getPackage())
                .addClass(DatastoreProducer.class)
                .addClass(ViewArticleBean.class)
                .addClass(MongoArticleRepository.class)
                .addClass(TestMongoSettingsProvider.class)
                .addClass(MongoSettings.class)
                .addClass(ArticleRepository.class);
        
        File[] mongo = null;
        File[] mongoJava = null;
        File[] morphia = null;
        
        try {
            mongo = Maven.resolver().resolve("de.flapdoodle.embed:de.flapdoodle.embed.mongo:jar:1.46.1").withTransitivity().as(File.class);
            mongoJava = Maven.resolver().resolve("org.mongodb:mongo-java-driver:jar:2.12.2").withTransitivity().as(File.class);
            morphia = Maven.resolver().resolve("org.mongodb.morphia:morphia:jar:0.108").withTransitivity().as(File.class);
            
            archive.addAsLibraries(mongo);
            archive.addAsLibraries(mongoJava);
            archive.addAsLibraries(morphia);
        } catch (Exception e) {
            System.out.println("Failed to load Maven dependencies");
        }

        return archive;
    }

    @Inject
    ViewArticleBean bean;


    @Test
    public void whenIRequestToViewAnArticleIExpectTheArticleToBeRetrievedFromTheDatabase() {

        String id = "54591a560364f33f00c522f3";
        bean.setId(id);

        assertEquals("Article is not retrieved correectly from database", "this is the body of the article", bean.getArticle().getBody());
        
        assertEquals("Article Id is not retained correctly.", "54591a560364f33f00c522f3", bean.getId());
    }

    @Test
    public void stub() {

        assertTrue(true);
    }
}
