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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Entity}.
 * </p>
 *
 * @author
 * @see Entity
 * @generated
 */
public class EntityWrapper implements Entity, ModelWrapper<Entity> {
	public EntityWrapper(Entity entity) {
		_entity = entity;
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

	/**
	* Returns the primary key of this entity.
	*
	* @return the primary key of this entity
	*/
	@Override
	public long getPrimaryKey() {
		return _entity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this entity.
	*
	* @param primaryKey the primary key of this entity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_entity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the entity ID of this entity.
	*
	* @return the entity ID of this entity
	*/
	@Override
	public long getEntityId() {
		return _entity.getEntityId();
	}

	/**
	* Sets the entity ID of this entity.
	*
	* @param entityId the entity ID of this entity
	*/
	@Override
	public void setEntityId(long entityId) {
		_entity.setEntityId(entityId);
	}

	/**
	* Returns the package path of this entity.
	*
	* @return the package path of this entity
	*/
	@Override
	public java.lang.String getPackagePath() {
		return _entity.getPackagePath();
	}

	/**
	* Sets the package path of this entity.
	*
	* @param packagePath the package path of this entity
	*/
	@Override
	public void setPackagePath(java.lang.String packagePath) {
		_entity.setPackagePath(packagePath);
	}

	/**
	* Returns the entity name of this entity.
	*
	* @return the entity name of this entity
	*/
	@Override
	public java.lang.String getEntityName() {
		return _entity.getEntityName();
	}

	/**
	* Sets the entity name of this entity.
	*
	* @param entityName the entity name of this entity
	*/
	@Override
	public void setEntityName(java.lang.String entityName) {
		_entity.setEntityName(entityName);
	}

	@Override
	public boolean isNew() {
		return _entity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_entity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _entity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_entity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _entity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _entity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_entity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _entity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_entity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_entity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_entity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EntityWrapper((Entity)_entity.clone());
	}

	@Override
	public int compareTo(vn.edu.ctu.index.database.model.Entity entity) {
		return _entity.compareTo(entity);
	}

	@Override
	public int hashCode() {
		return _entity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.edu.ctu.index.database.model.Entity> toCacheModel() {
		return _entity.toCacheModel();
	}

	@Override
	public vn.edu.ctu.index.database.model.Entity toEscapedModel() {
		return new EntityWrapper(_entity.toEscapedModel());
	}

	@Override
	public vn.edu.ctu.index.database.model.Entity toUnescapedModel() {
		return new EntityWrapper(_entity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _entity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _entity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_entity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntityWrapper)) {
			return false;
		}

		EntityWrapper entityWrapper = (EntityWrapper)obj;

		if (Validator.equals(_entity, entityWrapper._entity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Entity getWrappedEntity() {
		return _entity;
	}

	@Override
	public Entity getWrappedModel() {
		return _entity;
	}

	@Override
	public void resetOriginalValues() {
		_entity.resetOriginalValues();
	}

	private Entity _entity;
}