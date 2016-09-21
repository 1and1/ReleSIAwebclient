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
import javax.faces.bean.ViewScoped;

import com.oneandone.relesia.webclient.model.AbstractWebClientEntity;
import com.oneandone.relesia.webclient.model.ProgrammingLanguage;

@ManagedBean(name = "languageListController", eager = true)
@ViewScoped
public class ProgrammingLanguageListController extends AbstractEntityListController implements Serializable {

	private static final long serialVersionUID = -3684631904929029413L;

	private String name;
	private String version;


	@Override
	protected String getBackendEndpoint() {
		return getRootBackendEndpoint() + "/prlangs";
	}

	@Override
	protected Class<? extends AbstractWebClientEntity> getTargetClass() {
		return ProgrammingLanguage.class;
	}

	@Override
	protected AbstractWebClientEntity createNewEntity() {
		return new ProgrammingLanguage();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
