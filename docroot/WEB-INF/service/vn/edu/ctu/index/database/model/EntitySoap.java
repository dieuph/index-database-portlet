/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.edu.ctu.index.database.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.edu.ctu.index.database.service.http.EntityServiceSoap}.
 *
 * @author
 * @see vn.edu.ctu.index.database.service.http.EntityServiceSoap
 * @generated
 */
public class EntitySoap implements Serializable {
	public static EntitySoap toSoapModel(Entity model) {
		EntitySoap soapModel = new EntitySoap();

		soapModel.setEntityId(model.getEntityId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setPackagePath(model.getPackagePath());
		soapModel.setEntityName(model.getEntityName());

		return soapModel;
	}

	public static EntitySoap[] toSoapModels(Entity[] models) {
		EntitySoap[] soapModels = new EntitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EntitySoap[][] toSoapModels(Entity[][] models) {
		EntitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EntitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EntitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EntitySoap[] toSoapModels(List<Entity> models) {
		List<EntitySoap> soapModels = new ArrayList<EntitySoap>(models.size());

		for (Entity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EntitySoap[soapModels.size()]);
	}

	public EntitySoap() {
	}

	public long getPrimaryKey() {
		return _entityId;
	}

	public void setPrimaryKey(long pk) {
		setEntityId(pk);
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public String getPackagePath() {
		return _packagePath;
	}

	public void setPackagePath(String packagePath) {
		_packagePath = packagePath;
	}

	public String getEntityName() {
		return _entityName;
	}

	public void setEntityName(String entityName) {
		_entityName = entityName;
	}

	private long _entityId;
	private long _classNameId;
	private String _packagePath;
	private String _entityName;
}