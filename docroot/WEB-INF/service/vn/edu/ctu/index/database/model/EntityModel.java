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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.TypedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Entity service. Represents a row in the &quot;IDXDB_Entity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.edu.ctu.index.database.model.impl.EntityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.edu.ctu.index.database.model.impl.EntityImpl}.
 * </p>
 *
 * @author
 * @see Entity
 * @see vn.edu.ctu.index.database.model.impl.EntityImpl
 * @see vn.edu.ctu.index.database.model.impl.EntityModelImpl
 * @generated
 */
public interface EntityModel extends BaseModel<Entity>, TypedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a entity model instance should use the {@link Entity} interface instead.
	 */

	/**
	 * Returns the primary key of this entity.
	 *
	 * @return the primary key of this entity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this entity.
	 *
	 * @param primaryKey the primary key of this entity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the entity ID of this entity.
	 *
	 * @return the entity ID of this entity
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this entity.
	 *
	 * @param entityId the entity ID of this entity
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the fully qualified class name of this entity.
	 *
	 * @return the fully qualified class name of this entity
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this entity.
	 *
	 * @return the class name ID of this entity
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this entity.
	 *
	 * @param classNameId the class name ID of this entity
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the package path of this entity.
	 *
	 * @return the package path of this entity
	 */
	@AutoEscape
	public String getPackagePath();

	/**
	 * Sets the package path of this entity.
	 *
	 * @param packagePath the package path of this entity
	 */
	public void setPackagePath(String packagePath);

	/**
	 * Returns the entity name of this entity.
	 *
	 * @return the entity name of this entity
	 */
	@AutoEscape
	public String getEntityName();

	/**
	 * Sets the entity name of this entity.
	 *
	 * @param entityName the entity name of this entity
	 */
	public void setEntityName(String entityName);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Entity entity);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Entity> toCacheModel();

	@Override
	public Entity toEscapedModel();

	@Override
	public Entity toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}