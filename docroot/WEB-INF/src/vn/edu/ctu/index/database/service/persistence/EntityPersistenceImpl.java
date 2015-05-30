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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.edu.ctu.index.database.NoSuchEntityException;
import vn.edu.ctu.index.database.model.Entity;
import vn.edu.ctu.index.database.model.impl.EntityImpl;
import vn.edu.ctu.index.database.model.impl.EntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author
 * @see EntityPersistence
 * @see EntityUtil
 * @generated
 */
public class EntityPersistenceImpl extends BasePersistenceImpl<Entity>
	implements EntityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EntityUtil} to access the entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, EntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, EntityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ENTITYNAME = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, EntityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEntityName",
			new String[] { String.class.getName() },
			EntityModelImpl.ENTITYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENTITYNAME = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEntityName",
			new String[] { String.class.getName() });

	/**
	 * Returns the entity where entityName = &#63; or throws a {@link vn.edu.ctu.index.database.NoSuchEntityException} if it could not be found.
	 *
	 * @param entityName the entity name
	 * @return the matching entity
	 * @throws vn.edu.ctu.index.database.NoSuchEntityException if a matching entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity findByEntityName(String entityName)
		throws NoSuchEntityException, SystemException {
		Entity entity = fetchByEntityName(entityName);

		if (entity == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("entityName=");
			msg.append(entityName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEntityException(msg.toString());
		}

		return entity;
	}

	/**
	 * Returns the entity where entityName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param entityName the entity name
	 * @return the matching entity, or <code>null</code> if a matching entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity fetchByEntityName(String entityName)
		throws SystemException {
		return fetchByEntityName(entityName, true);
	}

	/**
	 * Returns the entity where entityName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param entityName the entity name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching entity, or <code>null</code> if a matching entity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity fetchByEntityName(String entityName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { entityName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ENTITYNAME,
					finderArgs, this);
		}

		if (result instanceof Entity) {
			Entity entity = (Entity)result;

			if (!Validator.equals(entityName, entity.getEntityName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ENTITY_WHERE);

			boolean bindEntityName = false;

			if (entityName == null) {
				query.append(_FINDER_COLUMN_ENTITYNAME_ENTITYNAME_1);
			}
			else if (entityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTITYNAME_ENTITYNAME_3);
			}
			else {
				bindEntityName = true;

				query.append(_FINDER_COLUMN_ENTITYNAME_ENTITYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEntityName) {
					qPos.add(entityName);
				}

				List<Entity> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EntityPersistenceImpl.fetchByEntityName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Entity entity = list.get(0);

					result = entity;

					cacheResult(entity);

					if ((entity.getEntityName() == null) ||
							!entity.getEntityName().equals(entityName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYNAME,
							finderArgs, entity);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Entity)result;
		}
	}

	/**
	 * Removes the entity where entityName = &#63; from the database.
	 *
	 * @param entityName the entity name
	 * @return the entity that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity removeByEntityName(String entityName)
		throws NoSuchEntityException, SystemException {
		Entity entity = findByEntityName(entityName);

		return remove(entity);
	}

	/**
	 * Returns the number of entities where entityName = &#63;.
	 *
	 * @param entityName the entity name
	 * @return the number of matching entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEntityName(String entityName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENTITYNAME;

		Object[] finderArgs = new Object[] { entityName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITY_WHERE);

			boolean bindEntityName = false;

			if (entityName == null) {
				query.append(_FINDER_COLUMN_ENTITYNAME_ENTITYNAME_1);
			}
			else if (entityName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ENTITYNAME_ENTITYNAME_3);
			}
			else {
				bindEntityName = true;

				query.append(_FINDER_COLUMN_ENTITYNAME_ENTITYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEntityName) {
					qPos.add(entityName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENTITYNAME_ENTITYNAME_1 = "entity.entityName IS NULL";
	private static final String _FINDER_COLUMN_ENTITYNAME_ENTITYNAME_2 = "entity.entityName = ?";
	private static final String _FINDER_COLUMN_ENTITYNAME_ENTITYNAME_3 = "(entity.entityName IS NULL OR entity.entityName = '')";

	public EntityPersistenceImpl() {
		setModelClass(Entity.class);
	}

	/**
	 * Caches the entity in the entity cache if it is enabled.
	 *
	 * @param entity the entity
	 */
	@Override
	public void cacheResult(Entity entity) {
		EntityCacheUtil.putResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey(), entity);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYNAME,
			new Object[] { entity.getEntityName() }, entity);

		entity.resetOriginalValues();
	}

	/**
	 * Caches the entities in the entity cache if it is enabled.
	 *
	 * @param entities the entities
	 */
	@Override
	public void cacheResult(List<Entity> entities) {
		for (Entity entity : entities) {
			if (EntityCacheUtil.getResult(
						EntityModelImpl.ENTITY_CACHE_ENABLED, EntityImpl.class,
						entity.getPrimaryKey()) == null) {
				cacheResult(entity);
			}
			else {
				entity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EntityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EntityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Entity entity) {
		EntityCacheUtil.removeResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(entity);
	}

	@Override
	public void clearCache(List<Entity> entities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Entity entity : entities) {
			EntityCacheUtil.removeResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
				EntityImpl.class, entity.getPrimaryKey());

			clearUniqueFindersCache(entity);
		}
	}

	protected void cacheUniqueFindersCache(Entity entity) {
		if (entity.isNew()) {
			Object[] args = new Object[] { entity.getEntityName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYNAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYNAME, args,
				entity);
		}
		else {
			EntityModelImpl entityModelImpl = (EntityModelImpl)entity;

			if ((entityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ENTITYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { entity.getEntityName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ENTITYNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ENTITYNAME,
					args, entity);
			}
		}
	}

	protected void clearUniqueFindersCache(Entity entity) {
		EntityModelImpl entityModelImpl = (EntityModelImpl)entity;

		Object[] args = new Object[] { entity.getEntityName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYNAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYNAME, args);

		if ((entityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ENTITYNAME.getColumnBitmask()) != 0) {
			args = new Object[] { entityModelImpl.getOriginalEntityName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENTITYNAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ENTITYNAME, args);
		}
	}

	/**
	 * Creates a new entity with the primary key. Does not add the entity to the database.
	 *
	 * @param entityId the primary key for the new entity
	 * @return the new entity
	 */
	@Override
	public Entity create(long entityId) {
		Entity entity = new EntityImpl();

		entity.setNew(true);
		entity.setPrimaryKey(entityId);

		return entity;
	}

	/**
	 * Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the entity
	 * @return the entity that was removed
	 * @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity remove(long entityId)
		throws NoSuchEntityException, SystemException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entity
	 * @return the entity that was removed
	 * @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity remove(Serializable primaryKey)
		throws NoSuchEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Entity entity = (Entity)session.get(EntityImpl.class, primaryKey);

			if (entity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(entity);
		}
		catch (NoSuchEntityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Entity removeImpl(Entity entity) throws SystemException {
		entity = toUnwrappedModel(entity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(entity)) {
				entity = (Entity)session.get(EntityImpl.class,
						entity.getPrimaryKeyObj());
			}

			if (entity != null) {
				session.delete(entity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (entity != null) {
			clearCache(entity);
		}

		return entity;
	}

	@Override
	public Entity updateImpl(vn.edu.ctu.index.database.model.Entity entity)
		throws SystemException {
		entity = toUnwrappedModel(entity);

		boolean isNew = entity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (entity.isNew()) {
				session.save(entity);

				entity.setNew(false);
			}
			else {
				session.merge(entity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EntityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey(), entity);

		clearUniqueFindersCache(entity);
		cacheUniqueFindersCache(entity);

		return entity;
	}

	protected Entity toUnwrappedModel(Entity entity) {
		if (entity instanceof EntityImpl) {
			return entity;
		}

		EntityImpl entityImpl = new EntityImpl();

		entityImpl.setNew(entity.isNew());
		entityImpl.setPrimaryKey(entity.getPrimaryKey());

		entityImpl.setEntityId(entity.getEntityId());
		entityImpl.setPackagePath(entity.getPackagePath());
		entityImpl.setEntityName(entity.getEntityName());

		return entityImpl;
	}

	/**
	 * Returns the entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity
	 * @return the entity
	 * @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntityException, SystemException {
		Entity entity = fetchByPrimaryKey(primaryKey);

		if (entity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return entity;
	}

	/**
	 * Returns the entity with the primary key or throws a {@link vn.edu.ctu.index.database.NoSuchEntityException} if it could not be found.
	 *
	 * @param entityId the primary key of the entity
	 * @return the entity
	 * @throws vn.edu.ctu.index.database.NoSuchEntityException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity findByPrimaryKey(long entityId)
		throws NoSuchEntityException, SystemException {
		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity
	 * @return the entity, or <code>null</code> if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Entity entity = (Entity)EntityCacheUtil.getResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
				EntityImpl.class, primaryKey);

		if (entity == _nullEntity) {
			return null;
		}

		if (entity == null) {
			Session session = null;

			try {
				session = openSession();

				entity = (Entity)session.get(EntityImpl.class, primaryKey);

				if (entity != null) {
					cacheResult(entity);
				}
				else {
					EntityCacheUtil.putResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
						EntityImpl.class, primaryKey, _nullEntity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
					EntityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return entity;
	}

	/**
	 * Returns the entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the entity
	 * @return the entity, or <code>null</code> if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Entity fetchByPrimaryKey(long entityId) throws SystemException {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the entities.
	 *
	 * @return the entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Entity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Entity> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Entity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Entity> list = (List<Entity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTITY;

				if (pagination) {
					sql = sql.concat(EntityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Entity>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Entity>(list);
				}
				else {
					list = (List<Entity>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Entity entity : findAll()) {
			remove(entity);
		}
	}

	/**
	 * Returns the number of entities.
	 *
	 * @return the number of entities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENTITY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.edu.ctu.index.database.model.Entity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Entity>> listenersList = new ArrayList<ModelListener<Entity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Entity>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ENTITY = "SELECT entity FROM Entity entity";
	private static final String _SQL_SELECT_ENTITY_WHERE = "SELECT entity FROM Entity entity WHERE ";
	private static final String _SQL_COUNT_ENTITY = "SELECT COUNT(entity) FROM Entity entity";
	private static final String _SQL_COUNT_ENTITY_WHERE = "SELECT COUNT(entity) FROM Entity entity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "entity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Entity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Entity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EntityPersistenceImpl.class);
	private static Entity _nullEntity = new EntityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Entity> toCacheModel() {
				return _nullEntityCacheModel;
			}
		};

	private static CacheModel<Entity> _nullEntityCacheModel = new CacheModel<Entity>() {
			@Override
			public Entity toEntityModel() {
				return _nullEntity;
			}
		};
}