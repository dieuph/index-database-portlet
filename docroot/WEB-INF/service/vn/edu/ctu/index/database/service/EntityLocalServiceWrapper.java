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

package vn.edu.ctu.index.database.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EntityLocalService}.
 *
 * @author
 * @see EntityLocalService
 * @generated
 */
public class EntityLocalServiceWrapper implements EntityLocalService,
	ServiceWrapper<EntityLocalService> {
	public EntityLocalServiceWrapper(EntityLocalService entityLocalService) {
		_entityLocalService = entityLocalService;
	}

	/**
	* Adds the entity to the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity
	* @return the entity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity addEntity(
		vn.edu.ctu.index.database.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.addEntity(entity);
	}

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity createEntity(long entityId) {
		return _entityLocalService.createEntity(entityId);
	}

	/**
	* Deletes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity
	* @return the entity that was removed
	* @throws PortalException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity deleteEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.deleteEntity(entityId);
	}

	/**
	* Deletes the entity from the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity
	* @return the entity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity deleteEntity(
		vn.edu.ctu.index.database.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.deleteEntity(entity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _entityLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.edu.ctu.index.database.model.impl.EntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.edu.ctu.index.database.model.impl.EntityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.edu.ctu.index.database.model.Entity fetchEntity(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.fetchEntity(entityId);
	}

	/**
	* Returns the entity with the primary key.
	*
	* @param entityId the primary key of the entity
	* @return the entity
	* @throws PortalException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity getEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getEntity(entityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.edu.ctu.index.database.model.Entity> getEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getEntities(start, end);
	}

	/**
	* Returns the number of entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getEntitiesCount();
	}

	/**
	* Updates the entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param entity the entity
	* @return the entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity updateEntity(
		vn.edu.ctu.index.database.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.updateEntity(entity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _entityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_entityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _entityLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Find by entity name.
	*
	* @param entityName the entity name
	* @return the entity or null if SystemException, NoSuchEntityException occurs
	*/
	@Override
	public vn.edu.ctu.index.database.model.Entity findByEntityName(
		java.lang.String entityName) {
		return _entityLocalService.findByEntityName(entityName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EntityLocalService getWrappedEntityLocalService() {
		return _entityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEntityLocalService(
		EntityLocalService entityLocalService) {
		_entityLocalService = entityLocalService;
	}

	@Override
	public EntityLocalService getWrappedService() {
		return _entityLocalService;
	}

	@Override
	public void setWrappedService(EntityLocalService entityLocalService) {
		_entityLocalService = entityLocalService;
	}

	private EntityLocalService _entityLocalService;
}