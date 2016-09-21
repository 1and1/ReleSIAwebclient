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

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneandone.relesia.util.properties.AppProperties;
import com.oneandone.relesia.webclient.model.AbstractWebClientEntity;

public abstract class AbstractEntityListController {

	protected String state;
	protected String stateMessage = null;

	protected boolean modified;
	protected boolean initialized = false;

	protected ArrayList<AbstractWebClientEntity> entities = null;

	protected abstract String getBackendEndpoint();

	protected abstract Class<? extends AbstractWebClientEntity> getTargetClass();

	protected abstract AbstractWebClientEntity createNewEntity();

	protected String getRootBackendEndpoint() {
		return AppProperties.getProperty("backend.endpoint", "http://localhost:8080");
	}

	public ArrayList<AbstractWebClientEntity> getAll() {
		if (!initialized) {
			loadListFromService();
			modified = false;
		}

		return entities;
	}

	public String addNew() {
		AbstractWebClientEntity newEntity = this.createNewEntity();
		newEntity.setEditable(true);
		newEntity.setNewCreated(true);
		entities.add(newEntity);
		modified = true;
		return null;
	}

	public String edit(AbstractWebClientEntity entity) {
		entity.setEditable(true);
		entity.setDirty(true);
		modified = true;
		return null;
	}

	public String save(AbstractWebClientEntity entity) {
		if (entity.isNewCreated()) {
			updateToBackend(entity);
		} else {
			if (entity.isDirty()) {
				saveNewToBackend(entity);
			}
		}
		entity.setEditable(false);
		entity.setDirty(false);
		entity.setNewCreated(false);
		return null;
	}

	public String saveAll() {
		for (AbstractWebClientEntity entity : entities) {
			this.save(entity);
			entity.setEditable(false);
		}

		return null;
	}

	private void loadListFromService() {
		Client restClient = ClientBuilder.newClient();
		WebTarget target = restClient.target(getBackendEndpoint()).path("list");

		String data = target.request(MediaType.APPLICATION_JSON).get(String.class);

		ObjectMapper mapper = new ObjectMapper();

		try {
			entities = mapper.readValue(data,
					mapper.getTypeFactory().constructCollectionType(ArrayList.class, getTargetClass()));
		} catch (JsonProcessingException e) {
			entities = null;
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.clearState();
		initialized = true;
	}

	public String cancelChanges() {
		loadListFromService();
		modified = false;
		return null;
	}

	public String delete(AbstractWebClientEntity entity) {
		deleteFromBackend(entity.getId());

		entities.remove(entity);
		return null;
	}

	protected String deleteFromBackend(long id) {
		Client restClient = ClientBuilder.newClient();
		WebTarget target = restClient.target(getBackendEndpoint()).path("" + id);

		Response response = target.request().delete();

		this.setState("" + response.getStatus());
		this.setStateMessage(response.readEntity(String.class));

		return null;
	}

	private String saveNewToBackend(AbstractWebClientEntity entity) {
		Client restClient = ClientBuilder.newClient();
		WebTarget target = restClient.target(getBackendEndpoint());

		ObjectMapper mapper = new ObjectMapper();
		String jsonEntity = null;
		try {
			jsonEntity = mapper.writeValueAsString(entity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(jsonEntity, MediaType.APPLICATION_JSON));

		String responseData = response.readEntity(String.class);
		
		AbstractWebClientEntity updatedEntity = null;
		
		try {
			updatedEntity = mapper.readValue(responseData, getTargetClass());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entities.remove(entity);
		entities.add(updatedEntity);
		this.setState("" + response.getStatus());
		this.setStateMessage(response.getStatusInfo().getReasonPhrase());

		return null;
	}

	private String updateToBackend(AbstractWebClientEntity entity) {
		Client restClient = ClientBuilder.newClient();
		WebTarget target = restClient.target(getBackendEndpoint());

		ObjectMapper mapper = new ObjectMapper();
		String jsonEntity = null;
		try {
			jsonEntity = mapper.writeValueAsString(entity);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(jsonEntity, MediaType.APPLICATION_JSON));

		this.setState("" + response.getStatus());
		this.setStateMessage(response.readEntity(String.class));

		return null;
	}

	public boolean isDirtyList() {
		for (AbstractWebClientEntity entity : entities) {
			if (entity.isDirty()) {
				return true;
			}
		}
		return false;
	}

	public void clearState() {
		setState(null);
		setStateMessage(null);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateMessage() {
		return stateMessage;
	}

	public void setStateMessage(String stateMessage) {
		this.stateMessage = stateMessage;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
}
