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
package com.davidsalter.kb.cdi.mock;

import com.davidsalter.kb.data.ArticleRepository;
import com.davidsalter.kb.data.mock.MockArticleRepository;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author David Salter david@developinjava.com
 */
@ApplicationScoped
public class MockArticleRepositoryProducer implements Serializable{
    
    @Produces
    public ArticleRepository getArticleRepository() {
        return new MockArticleRepository();
    }
}
