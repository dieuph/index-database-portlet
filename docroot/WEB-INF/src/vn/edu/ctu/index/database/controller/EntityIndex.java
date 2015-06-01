/*
 * Classname: EntityIndex
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
package vn.edu.ctu.index.database.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import vn.edu.ctu.index.database.action.util.ActionUtils;
import vn.edu.ctu.index.database.action.util.ConstantUtils;
import vn.edu.ctu.index.database.model.Entity;
import vn.edu.ctu.index.database.service.EntityLocalServiceUtil;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ClassName;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EntityIndex.
 * 
 * @author dieuph
 */
public class EntityIndex extends MVCPortlet {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(EntityIndex.class);
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
			throws IOException, PortletException {
		
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);
		if (!cmd.equals("")) {
			if (cmd.equals("addEntity")) {
				addEntity(resourceRequest, resourceResponse);
			}
			
			if (cmd.equals("removeEntity")) {
				removeEntity(resourceRequest, resourceResponse);
			}
		}
	}
	
	/**
	 * Adds the entity.
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws PortletException the portlet exception
	 */
	public void addEntity(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		JSONObject entityJsonObject = JSONFactoryUtil.createJSONObject();
		entityJsonObject.put("success", "false");
		entityJsonObject.put("message", "Thêm entity không thành công. Xin vui lòng thử lại.");
		entityJsonObject.put("className", "");
		entityJsonObject.put("packagePath", "");
		entityJsonObject.put("entityName", "");
		entityJsonObject.put("entityId", "");
		
		try {
			// get param from request
			String packagePath = ParamUtil.getString(resourceRequest, "packagePath");
			String entityName = ParamUtil.getString(resourceRequest, "entityName");
			
			Entity entity = null;
			Entity existsEntity = null;
			
			ClassName className = ActionUtils.getClassName(packagePath, ConstantUtils.PP_MODEL, entityName);
			existsEntity = EntityLocalServiceUtil.findByEntityName(entityName);
			
			if (className != null && existsEntity == null) {
				entity = ActionUtils.addEntity(className.getClassNameId(), packagePath, entityName);
			}
			
			if (entity != null) {
				entityJsonObject.put("success", "true");
				entityJsonObject.put("message", "Thêm entity thành công");
				entityJsonObject.put("className", className.getValue());
				entityJsonObject.put("packagePath", packagePath);
				entityJsonObject.put("entityName", entityName);
				entityJsonObject.put("entityId", entity.getEntityId());
				
				_log.info("Entity " + className.getValue() + " have been added successfully");
			} else {
				_log.error("There is an error in adding Entity");
			}
			
			
		} catch (Exception e) {
			_log.error("There is an error in adding Entity");
		}
		
		_log.info(entityJsonObject);
		
		try {
			HashMap<String, String> maps = ActionUtils.getFields("ctu.edu.vn.qlcd.model.impl.CongDoanVienModelImpl");
			System.out.print(ActionUtils.mapsToJson(maps).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter writer = resourceResponse.getWriter();
		writer.println(entityJsonObject.toString());
		writer.flush();
		writer.close();
	}

	/**
	 * Remove the entity.
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws PortletException the portlet exception
	 */
	public void removeEntity(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		JSONObject entityJsonObject = JSONFactoryUtil.createJSONObject();
		entityJsonObject.put("success", "false");
		
		try {
			// get param from request
			long entityId = ParamUtil.getLong(resourceRequest, "entityId");
			System.out.println("entityId=" + entityId);
			
			Entity entity = ActionUtils.getEntity(entityId);
			Entity deletedEntity = null;
			if (entity != null) {
				deletedEntity = ActionUtils.deleteEntity(entity.getEntityId());
			}
			
			if (deletedEntity != null) {
				entityJsonObject.put("success", "true");
				entityJsonObject.put("message", "Xóa Entity " + deletedEntity.getEntityName() + " thành công");
				
				_log.info("Entity " + deletedEntity.getEntityName() + " have been deleted successfully");
			} else {
				_log.error("There is an error in deleting Entity");
			}
		} catch (Exception e) {
			_log.error("There is an error in deleting Entity");
		}
		
		_log.info(entityJsonObject);
		
		PrintWriter writer = resourceResponse.getWriter();
		writer.println(entityJsonObject.toString());
		writer.flush();
		writer.close();
	}
	
}
