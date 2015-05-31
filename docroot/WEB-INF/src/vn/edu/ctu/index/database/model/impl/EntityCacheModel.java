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

package vn.edu.ctu.index.database.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.edu.ctu.index.database.model.Entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Entity in entity cache.
 *
 * @author
 * @see Entity
 * @generated
 */
public class EntityCacheModel implements CacheModel<Entity>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{entityId=");
		sb.append(entityId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", packagePath=");
		sb.append(packagePath);
		sb.append(", entityName=");
		sb.append(entityName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Entity toEntityModel() {
		EntityImpl entityImpl = new EntityImpl();

		entityImpl.setEntityId(entityId);
		entityImpl.setClassNameId(classNameId);

		if (packagePath == null) {
			entityImpl.setPackagePath(StringPool.BLANK);
		}
		else {
			entityImpl.setPackagePath(packagePath);
		}

		if (entityName == null) {
			entityImpl.setEntityName(StringPool.BLANK);
		}
		else {
			entityImpl.setEntityName(entityName);
		}

		entityImpl.resetOriginalValues();

		return entityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		entityId = objectInput.readLong();
		classNameId = objectInput.readLong();
		packagePath = objectInput.readUTF();
		entityName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(entityId);
		objectOutput.writeLong(classNameId);

		if (packagePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(packagePath);
		}

		if (entityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityName);
		}
	}

	public long entityId;
	public long classNameId;
	public String packagePath;
	public String entityName;
}