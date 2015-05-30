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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.edu.ctu.index.database.service.ClpSerializer;
import vn.edu.ctu.index.database.service.EntityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author $author$
 */
public class EntityClp extends BaseModelImpl<Entity> implements Entity {
	public EntityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Entity.class;
	}

	@Override
	public String getModelClassName() {
		return Entity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _entityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entityId", getEntityId());
		attributes.put("packagePath", getPackagePath());
		attributes.put("entityName", getEntityName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String packagePath = (String)attributes.get("packagePath");

		if (packagePath != null) {
			setPackagePath(packagePath);
		}

		String entityName = (String)attributes.get("entityName");

		if (entityName != null) {
			setEntityName(entityName);
		}
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_entityRemoteModel != null) {
			try {
				Class<?> clazz = _entityRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_entityRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPackagePath() {
		return _packagePath;
	}

	@Override
	public void setPackagePath(String packagePath) {
		_packagePath = packagePath;

		if (_entityRemoteModel != null) {
			try {
				Class<?> clazz = _entityRemoteModel.getClass();

				Method method = clazz.getMethod("setPackagePath", String.class);

				method.invoke(_entityRemoteModel, packagePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityName() {
		return _entityName;
	}

	@Override
	public void setEntityName(String entityName) {
		_entityName = entityName;

		if (_entityRemoteModel != null) {
			try {
				Class<?> clazz = _entityRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityName", String.class);

				method.invoke(_entityRemoteModel, entityName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEntityRemoteModel() {
		return _entityRemoteModel;
	}

	public void setEntityRemoteModel(BaseModel<?> entityRemoteModel) {
		_entityRemoteModel = entityRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _entityRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_entityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EntityLocalServiceUtil.addEntity(this);
		}
		else {
			EntityLocalServiceUtil.updateEntity(this);
		}
	}

	@Override
	public Entity toEscapedModel() {
		return (Entity)ProxyUtil.newProxyInstance(Entity.class.getClassLoader(),
			new Class[] { Entity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EntityClp clone = new EntityClp();

		clone.setEntityId(getEntityId());
		clone.setPackagePath(getPackagePath());
		clone.setEntityName(getEntityName());

		return clone;
	}

	@Override
	public int compareTo(Entity entity) {
		long primaryKey = entity.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntityClp)) {
			return false;
		}

		EntityClp entity = (EntityClp)obj;

		long primaryKey = entity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{entityId=");
		sb.append(getEntityId());
		sb.append(", packagePath=");
		sb.append(getPackagePath());
		sb.append(", entityName=");
		sb.append(getEntityName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("vn.edu.ctu.index.database.model.Entity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packagePath</column-name><column-value><![CDATA[");
		sb.append(getPackagePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityName</column-name><column-value><![CDATA[");
		sb.append(getEntityName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entityId;
	private String _packagePath;
	private String _entityName;
	private BaseModel<?> _entityRemoteModel;
}