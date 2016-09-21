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

public class Application extends AbstractWebClientEntity {

	private String name;
	private Product product;
	private String sourcePath;
	private SCM scm;
	private ProgrammingLanguage language;
	private BuildType buildType;
	private ReleaseRepo releaseRepo;
	private String releaseLocation;
	private String snapshotLocation;

	public Application() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public SCM getScm() {
		return scm;
	}

	public void setScm(SCM scm) {
		this.scm = scm;
	}

	public ProgrammingLanguage getLanguage() {
		return language;
	}

	public void setLanguage(ProgrammingLanguage language) {
		this.language = language;
	}

	public BuildType getBuildType() {
		return buildType;
	}

	public void setBuildType(BuildType buildType) {
		this.buildType = buildType;
	}

	public ReleaseRepo getReleaseRepo() {
		return releaseRepo;
	}

	public void setReleaseRepo(ReleaseRepo releaseRepo) {
		this.releaseRepo = releaseRepo;
	}

	public String getReleaseLocation() {
		return releaseLocation;
	}

	public void setReleaseLocation(String releaseLocation) {
		this.releaseLocation = releaseLocation;
	}

	public String getSnapshotLocation() {
		return snapshotLocation;
	}

	public void setSnapshotLocation(String snapshotLocation) {
		this.snapshotLocation = snapshotLocation;
	}

	@Override
	public String toString() {
		return "Application [id=" + this.getId() + ", name=" + name + ", product=" + product + ", sourcePath=" + sourcePath
				+ ", scm=" + scm + ", language=" + language + ", buildType=" + buildType + ", releaseRepo="
				+ releaseRepo + ", releaseLocation=" + releaseLocation + ", snapshotLocation="
				+ snapshotLocation + "]";
	}
}
