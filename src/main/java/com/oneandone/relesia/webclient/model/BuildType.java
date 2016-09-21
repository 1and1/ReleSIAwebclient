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

public class BuildType extends AbstractWebClientEntity {

	private String toolName;
	private String version;
	private boolean supportsDependency;
	private boolean supportsBuild;
	private boolean supportsStaging;
	private boolean supportsRelease;
	private boolean supportsAuth;

	public BuildType() {
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isSupportsDependency() {
		return supportsDependency;
	}

	public void setSupportsDependency(boolean supportsDependency) {
		this.supportsDependency = supportsDependency;
	}

	public boolean isSupportsBuild() {
		return supportsBuild;
	}

	public void setSupportsBuild(boolean supportsBuild) {
		this.supportsBuild = supportsBuild;
	}

	public boolean isSupportsStaging() {
		return supportsStaging;
	}

	public void setSupportsStaging(boolean supportsStaging) {
		this.supportsStaging = supportsStaging;
	}

	public boolean isSupportsRelease() {
		return supportsRelease;
	}

	public void setSupportsRelease(boolean supportsRelease) {
		this.supportsRelease = supportsRelease;
	}

	public boolean isSupportsAuth() {
		return supportsAuth;
	}

	public void setSupportsAuth(boolean supportsAuth) {
		this.supportsAuth = supportsAuth;
	}

	@Override
	public String toString() {
		return "BuildType [" + toolName + ": " + version + "; supportsDependency=" + supportsDependency
				+ ", supportsBuild=" + supportsBuild + ", supportsStaging=" + supportsStaging + ", supportsRelease="
				+ supportsRelease + ", supportsAuth=" + supportsAuth + "]";
	}
}
