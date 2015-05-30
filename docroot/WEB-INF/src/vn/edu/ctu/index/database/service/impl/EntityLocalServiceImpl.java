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

package vn.edu.ctu.index.database.service.impl;

import vn.edu.ctu.index.database.model.Entity;
import vn.edu.ctu.index.database.service.base.EntityLocalServiceBaseImpl;

/**
 * The implementation of the entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.edu.ctu.index.database.service.EntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author
 * @see vn.edu.ctu.index.database.service.base.EntityLocalServiceBaseImpl
 * @see vn.edu.ctu.index.database.service.EntityLocalServiceUtil
 */
public class EntityLocalServiceImpl extends EntityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.edu.ctu.index.database.service.EntityLocalServiceUtil} to access the entity local service.
	 */
	
	/**
	 * Find by entity name.
	 *
	 * @param entityName the entity name
	 * @return the entity or null if SystemException, NoSuchEntityException occurs
	 */
	public Entity findByEntityName(String entityName) {
		Entity entity = null;
		try {
			entity = entityPersistence.findByEntityName(entityName);
		} catch (Exception e) {
			
		}
		return entity;
	}
}