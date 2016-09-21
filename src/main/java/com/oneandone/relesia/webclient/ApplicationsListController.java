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
import com.oneandone.relesia.webclient.model.Application;
import com.oneandone.relesia.webclient.model.BuildType;
import com.oneandone.relesia.webclient.model.Product;
import com.oneandone.relesia.webclient.model.ProgrammingLanguage;
import com.oneandone.relesia.webclient.model.ReleaseRepo;
import com.oneandone.relesia.webclient.model.SCM;

@ManagedBean(name = "applicationListController", eager = true)
@ViewScoped
public class ApplicationsListController extends AbstractEntityListController implements Serializable {

	private static final long serialVersionUID = -2167830041237311154L;

	private String applicationName;
	private Product product;
	private String sourcePath;
	private SCM scm;
	private ProgrammingLanguage language;
	private BuildType buildType;
	private ReleaseRepo releaseRepo;
	private String releaseLocation;
	private String snapshotLocation;

	@Override
	protected String getBackendEndpoint() {
		return getRootBackendEndpoint() + "/applications";
	}

	@Override
	protected Class<? extends AbstractWebClientEntity> getTargetClass() {
		return Application.class;
	}

	@Override
	protected AbstractWebClientEntity createNewEntity() {
		Application newApp = new Application();
		newApp.setProduct(new Product());
		newApp.setScm(new SCM());
		newApp.setLanguage(new ProgrammingLanguage());
		newApp.setBuildType(new BuildType());
		newApp.setReleaseRepo(new ReleaseRepo());
		
		return newApp;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String name) {
		this.applicationName = name;
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
}
