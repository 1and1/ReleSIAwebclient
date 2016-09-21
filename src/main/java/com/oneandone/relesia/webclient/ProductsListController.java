/*
 * 
 * Copyright (c) 2016 1&1 Internet SE.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.oneandone.relesia.webclient;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.oneandone.relesia.webclient.model.AbstractWebClientEntity;
import com.oneandone.relesia.webclient.model.Product;

@ManagedBean(name = "productListController", eager = true)
@SessionScoped
public class ProductsListController extends AbstractEntityListController implements Serializable {

	private static final long serialVersionUID = 3374652835711643245L;

	private String productName;

	@Override
	protected String getBackendEndpoint() {
		return getRootBackendEndpoint() + "/products";
	}

	@Override
	protected Class<? extends AbstractWebClientEntity> getTargetClass() {
		return Product.class;
	}

	@Override
	protected AbstractWebClientEntity createNewEntity() {
		return new Product();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String name) {
		this.productName = name;
	}
}
