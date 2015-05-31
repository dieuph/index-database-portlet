/*
 * Classname: ActionUtils
 *
 * Version information: 1.0
 *
 * Date: 31-May-2015
 *
 * Copyright notice
 *
 * Modification Logs:
 * DATE          AUTHOR          DESCRIPTION
 * --------------------------------------------------------
 * 31-May-2015   dieuph          Create the first version
 */
package vn.edu.ctu.index.database.action.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import vn.edu.ctu.index.database.model.Entity;
import vn.edu.ctu.index.database.service.EntityLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.spring.aop.Skip;
import com.liferay.portal.model.ClassName;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

/**
 * The Class ActionUtils.
 * 
 * @author dieuph
 */
public class ActionUtils {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(ActionUtils.class);
	
	/**
	 * Get the class name id.
	 *
	 * @param clazz the clazz
	 * @return the class name id
	 * @throws SystemException the system exception
	 */
	public static long getClassNameId(Class<?> clazz) throws SystemException {
		return ClassNameLocalServiceUtil.getClassName(clazz.getName()).getClassNameId();
	}
	
	/**
	 * Get the class.
	 *
	 * @param classNameId the class name id
	 * @return the class
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public static Class<?> getClass(long classNameId) throws PortalException, SystemException, ClassNotFoundException {
		String className = ClassNameLocalServiceUtil.getClassName(classNameId).getValue();
		return Class.forName(className);
	}
	
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
	 * Get the class name.
	 * (ex: vn.edu.ctu.model.XXX)
	 *
	 * @param packagePath the package path
	 * @param extendPath the extend path
	 * @param entityName the entity name
	 * @return the class name or null if SystemException occurs
	 */
	@Skip public static ClassName getClassName(String packagePath, String extendPath, String entityName) {
		ClassName className = null;
		try {
			String value = packagePath + extendPath + entityName;
			long id = getClassNameId(Class.forName(value));
			
			className = ClassNameLocalServiceUtil.getClassName(id);
		} catch (Exception e) {
			className = null;
			_log.error("Get the class name has failed.");
		}
		return className;
	}
	
	/**
	 * Get the total of entity.
	 *
	 * @return the total of entity or 0 if SystemException occurs
	 */
	public static int getEntitiesCount() {
		int total = 0;
		try {
			total = EntityLocalServiceUtil.getEntitiesCount();
		} catch (Exception e) {
			total = 0;
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
	 * Get the class name value.
	 *
	 * @param classNameId the class name id
	 * @return the class name value or null if PortalException, SystemException occurs
	 */
	public static String getClassNameValue(long classNameId) {
		String entityName = null;
		try {
			entityName = ClassNameLocalServiceUtil.getClassName(classNameId).getValue();
		} catch (Exception e) {
			_log.error("Get the class name value has failed, classNameId = " + classNameId);
		}
		return entityName;
	}
	
	/**
	 * Add the entity.
	 *
	 * @param classNameId the class name id
	 * @param packagePath the package path
	 * @param entityName the entity name
	 * @return the entity or null if PortalException, SystemException occurs
	 */
	public static Entity addEntity(long classNameId, String packagePath, String entityName) {
		Entity createdEntity = null;
		try {
			long entityId = CounterLocalServiceUtil.increment(Entity.class.getName());
			Entity entity = EntityLocalServiceUtil.createEntity(entityId);
			
			entity.setClassNameId(classNameId);
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
	 * @param classNameId the class name id
	 * @param packagePath the package path
	 * @param entityName the entity name
	 * @return the entity or null if PortalException, SystemException occurs
	 */
	public static Entity updateEntity(long entityId, long classNameId, String packagePath, String entityName) {
		Entity updatedEntity = null;
		try {
			Entity entity = EntityLocalServiceUtil.getEntity(entityId);
			
			entity.setClassNameId(classNameId);
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
	
	/**
	 * Find all entity.
	 *
	 * @return the list of entity or empty list
	 */
	public static List<Entity> findAll() {
		List<Entity> entities = null;
		entities = EntityLocalServiceUtil.findAll();
		
		if (entities == null) {
			_log.error("Find all entity has failed");
		}
		return entities;
	}
	
	/**
	 * Gets the fields of class.
	 *
	 * @param <T> the generic type
	 * @param clazz the clazz
	 * @return the fields
	 */
	public static <T> HashMap<String, String> getFields(Class<T> clazz) {
		HashMap<String, String> results = new HashMap<String, String>();
		Field[] fields = clazz.getDeclaredFields();
		
		results.put("length", String.valueOf(fields.length));
        for (Field field : fields) {
        	results.put(field.getName(), field.getType().getSimpleName());
        }
		return results;
	}
	
	/**
	 * Maps to json.
	 *
	 * @param <K> the key type
	 * @param <V> the value type
	 * @param maps the maps
	 * @return the JSON object
	 */
	public static <K, V> JSONObject mapsToJson(HashMap<K, V> maps) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		Iterator<Entry<K, V>> it = maps.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
			jsonObject.put(entry.getKey().toString(), entry.getValue().toString());
		}
		return jsonObject;
	}
}
