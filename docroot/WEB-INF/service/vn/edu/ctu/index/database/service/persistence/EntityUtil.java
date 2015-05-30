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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.edu.ctu.index.database.model.Entity;

import java.util.List;

/**
 * The persistence utility for the entity service. This utility wraps {@link EntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see EntityPersistence
 * @see EntityPersistenceImpl
 * @generated
 */
public class EntityUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Entity entity) {
		getPersistence().clearCache(entity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Entity> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Entity> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Entity> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Entity update(Entity entity) throws SystemException {
		return getPersistence().update(entity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Entity update(Entity entity, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(entity, serviceContext);
	}

	/**
	* Returns the entity where entityName = &#63; or throws a {@link vn.edu.ctu.index.database.NoSuchEntityException} if it could not be found.
	*
	* @param entityName the entity name
	* @return the matching entity
	* @throws vn.edu.ctu.index.database.NoSuchEntityException if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity findByEntityName(
		java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException {
		return getPersistence().findByEntityName(entityName);
	}

	/**
	* Returns the entity where entityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param entityName the entity name
	* @return the matching entity, or <code>null</code> if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity fetchByEntityName(
		java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntityName(entityName);
	}

	/**
	* Returns the entity where entityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param entityName the entity name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching entity, or <code>null</code> if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity fetchByEntityName(
		java.lang.String entityName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEntityName(entityName, retrieveFromCache);
	}

	/**
	* Removes the entity where entityName = &#63; from the database.
	*
	* @param entityName the entity name
	* @return the entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity removeByEntityName(
		java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException {
		return getPersistence().removeByEntityName(entityName);
	}

	/**
	* Returns the number of entities where entityName = &#63;.
	*
	* @param entityName the entity name
	* @return the number of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEntityName(java.lang.String entityName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEntityName(entityName);
	}

	/**
	* Caches the entity in the entity cache if it is enabled.
	*
	* @param entity the entity
	*/
	public static void cacheResult(
		vn.edu.ctu.index.database.model.Entity entity) {
		getPersistence().cacheResult(entity);
	}

	/**
	* Caches the entities in the entity cache if it is enabled.
	*
	* @param entities the entities
	*/
	public static void cacheResult(
		java.util.List<vn.edu.ctu.index.database.model.Entity> entities) {
		getPersistence().cacheResult(entities);
	}

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	public static vn.edu.ctu.index.database.model.Entity create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	* Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity
	* @return the entity that was removed
	* @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity remove(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException {
		return getPersistence().remove(entityId);
	}

	public static vn.edu.ctu.index.database.model.Entity updateImpl(
		vn.edu.ctu.index.database.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(entity);
	}

	/**
	* Returns the entity with the primary key or throws a {@link vn.edu.ctu.index.database.NoSuchEntityException} if it could not be found.
	*
	* @param entityId the primary key of the entity
	* @return the entity
	* @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity findByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.edu.ctu.index.database.NoSuchEntityException {
		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	* Returns the entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the entity
	* @return the entity, or <code>null</code> if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.edu.ctu.index.database.model.Entity fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	* Returns all the entities.
	*
	* @return the entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.edu.ctu.index.database.model.Entity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.edu.ctu.index.database.model.Entity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.edu.ctu.index.database.model.Entity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EntityPersistence)PortletBeanLocatorUtil.locate(vn.edu.ctu.index.database.service.ClpSerializer.getServletContextName(),
					EntityPersistence.class.getName());

			ReferenceRegistry.registerReference(EntityUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EntityPersistence persistence) {
	}

	private static EntityPersistence _persistence;
}