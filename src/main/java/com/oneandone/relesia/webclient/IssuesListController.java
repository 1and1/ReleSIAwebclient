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
import com.oneandone.relesia.webclient.model.Application;
import com.oneandone.relesia.webclient.model.Issue;

@ManagedBean(name = "issueListController", eager = true)
@SessionScoped
public class IssuesListController extends AbstractEntityListController implements Serializable {

	private static final long serialVersionUID = 5859913707990972228L;

	private Application application;
	private String subject;
	private String description;
	private String refferencePath;
	private String issueType;
	private String assignee;
	private String status;

	@Override
	protected String getBackendEndpoint() {
		return getRootBackendEndpoint() + "/issues";
	}

	@Override
	protected Class<? extends AbstractWebClientEntity> getTargetClass() {
		return Issue.class;
	}

	@Override
	protected AbstractWebClientEntity createNewEntity() {
		Issue newIssue = new Issue();
		newIssue.setApplication(new Application());
		return newIssue;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRefferencePath() {
		return refferencePath;
	}

	public void setRefferencePath(String refferencePath) {
		this.refferencePath = refferencePath;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
