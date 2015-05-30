package vn.edu.ctu.index.database.action.util;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ctu.index.database.model.Entity;
import vn.edu.ctu.index.database.service.EntityLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class EntityUtils {
	private static final Log _log = LogFactoryUtil.getLog(EntityUtils.class);
	
	/**
	 * Get the entity.
	 *
	 * @param entityId the entity id
	 * @return the entity or null if PortalException, SystemException occurs
	 */
	public static Entity getEntity(long entityId) {
		Entity entity = null;
		try {
			entity = EntityLocalServiceUtil.getEntity(entityId);
		} catch (Exception e) {
			_log.error("Get the entity has failed, getEntity = " + entityId);
		}
		return entity; 
	}
	
	/**
	 * Get the total of entity.
	 *
	 * @return the total of entity or null if SystemException occurs
	 */
	public static int getEntitiesCount() {
		int total = 0;
		try {
			total = EntityLocalServiceUtil.getEntitiesCount();
		} catch (Exception e) {
			_log.error("Get the total of entity has failed");
		}
		return total;
	}
	
	/**
	 * Get the list of entity.
	 *
	 * @param start the start
	 * @param end the end
	 * @return the list of entity or empty list if SystemException occurs
	 */
	public static List<Entity> getEntities(int start, int end) {
		List<Entity> entities = null;
		try {
			entities = EntityLocalServiceUtil.getEntities(start, end);
		} catch (Exception e) {
		    entities = new ArrayList<Entity>();
		    _log.error("Get the list of entity has failed");
		}
		return entities;
	}
	
	/**
	 * Add the entity.
	 *
	 * @param packagePath the package path
	 * @param entityName the entity name
	 * @return the entity or null if PortalException, SystemException occurs
	 */
	public static Entity addEntity(String packagePath, String entityName) {
		Entity createdEntity = null;
		try {
			long entityId = CounterLocalServiceUtil.increment(Entity.class.getName());
			Entity entity = EntityLocalServiceUtil.createEntity(entityId);
			
			entity.setPackagePath(packagePath);
			entity.setEntityName(entityName);
			
			createdEntity = EntityLocalServiceUtil.addEntity(entity);
		} catch (Exception e) {
			createdEntity = null;
			_log.error("Add the entity has failed");
		}
		return createdEntity;
	}
	
	/**
	 * Update entity.
	 *
	 * @param entityId the entity id
	 * @param packagePath the package path
	 * @param entityName the entity name
	 * @return the entity or null if PortalException, SystemException occurs
	 */
	public static Entity updateEntity(long entityId, String packagePath, String entityName) {
		Entity updatedEntity = null;
		try {
			Entity entity = EntityLocalServiceUtil.getEntity(entityId);
			
			entity.setPackagePath(packagePath);
			entity.setEntityName(entityName);
			
			updatedEntity = EntityLocalServiceUtil.updateEntity(entity);
		} catch (Exception e) {
			updatedEntity = null;
			_log.error("Update entity has failed");
		}
		return updatedEntity; 
	}
	
	/**
	 * Delete entity.
	 *
	 * @param entityId the entity id
	 * @return the entity or null if PortalException, SystemException occurs
	 */
	public static Entity deleteEntity(long entityId) {
		Entity deletedEntity = null;
		try {
			deletedEntity = EntityLocalServiceUtil.deleteEntity(entityId);
		} catch (Exception e) {
			_log.error("Delete entity has failed, entityId = " + entityId);
		}
		return deletedEntity;
	}
}
