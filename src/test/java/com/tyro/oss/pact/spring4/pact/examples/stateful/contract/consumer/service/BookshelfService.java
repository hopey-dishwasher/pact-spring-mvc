/*
 * #%L
 * pact-spring-mvc
 * %%
 * Copyright (C) 2016 Tyro Payments Pty Ltd
 * %%
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
 * #L%
 */
package com.tyro.oss.pact.spring4.pact.examples.stateful.contract.consumer.service;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.tyro.oss.pact.rest.RestRequestDescriptor;
import com.tyro.oss.pact.spring4.pact.examples.RestRequestInvoker;
import com.tyro.oss.pact.spring4.pact.examples.stateful.contract.api.BookCollectionDTO;

public class BookshelfService {

    private RestRequestInvoker restRequestInvoker;

    public BookshelfService(RestTemplate restTemplate) {
        this.restRequestInvoker = new RestRequestInvoker(restTemplate);
    }

    public BookCollectionDTO getBooksOwned() {
        return restRequestInvoker.forDescriptor(new RestRequestDescriptor<>("/shelf", HttpMethod.GET, null, BookCollectionDTO.class));
    }

    public BookCollectionDTO getBooksRead() {
        return restRequestInvoker.forDescriptor(new RestRequestDescriptor<>("/read", HttpMethod.GET, null, BookCollectionDTO.class));
    }
}
