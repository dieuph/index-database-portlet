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

package vn.edu.ctu.index.database.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import vn.edu.ctu.index.database.model.Entity;

/**
 * The persistence interface for the entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see EntityPersistenceImpl
 * @see EntityUtil
 * @generated
 */
public interface EntityPersistence extends BasePersistence<Entity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntityUtil} to access the entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the entity where entityName = &#63; or throws a {@link vn.edu.ctu.index.database.NoSuchEntityException} if it could not be found.
	*
	* @param entityName the entity name
	* @return the matching entity
	* @throws vn.edu.ctu.index.database.NoSuchEntityException if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity findByEntityName(
		java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException;

	/**
	* Returns the entity where entityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityName the entity name
	* @return the matching entity, or <code>null</code> if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity fetchByEntityName(
		java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the entity where entityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entityName the entity name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching entity, or <code>null</code> if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity fetchByEntityName(
		java.lang.String entityName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the entity where entityName = &#63; from the database.
	*
	* @param entityName the entity name
	* @return the entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity removeByEntityName(
		java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException;

	/**
	* Returns the number of entities where entityName = &#63;.
	*
	* @param entityName the entity name
	* @return the number of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByEntityName(java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the entity in the entity cache if it is enabled.
	*
	* @param entity the entity
	*/
	public void cacheResult(vn.edu.ctu.index.database.model.Entity entity);

	/**
	* Caches the entities in the entity cache if it is enabled.
	*
	* @param entities the entities
	*/
	public void cacheResult(
		java.util.List<vn.edu.ctu.index.database.model.Entity> entities);

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	public vn.edu.ctu.index.database.model.Entity create(long entityId);

	/**
	* Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity
	* @return the entity that was removed
	* @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity remove(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException;

	public vn.edu.ctu.index.database.model.Entity updateImpl(
		vn.edu.ctu.index.database.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the entity with the primary key or throws a {@link vn.edu.ctu.index.database.NoSuchEntityException} if it could not be found.
	*
	* @param entityId the primary key of the entity
	* @return the entity
	* @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity findByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException;

	/**
	* Returns the entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the entity
	* @return the entity, or <code>null</code> if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.edu.ctu.index.database.model.Entity fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the entities.
	*
	* @return the entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.edu.ctu.index.database.model.Entity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.edu.ctu.index.database.model.impl.EntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entities
	* @param end the upper bound of the range of entities (not inclusive)
	* @return the range of entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.edu.ctu.index.database.model.Entity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.edu.ctu.index.database.model.impl.EntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entities
	* @param end the upper bound of the range of entities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.edu.ctu.index.database.model.Entity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}