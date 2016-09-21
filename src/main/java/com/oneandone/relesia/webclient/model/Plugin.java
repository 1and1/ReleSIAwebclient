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

package com.oneandone.relesia.webclient.model;

import java.util.Set;

public class Plugin extends AbstractWebClientEntity {

	private String name;
	private String type;
	private String className;
	private Set<PluginProperty> properties;

	public Plugin() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<PluginProperty> getProperties() {
		return properties;
	}

	public void setProperties(Set<PluginProperty> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Plugin [id=" + this.getId() + ", name=" + name + ", type=" + type + ", className=" + className + ", properties="
				+ properties + "]";
	}
}