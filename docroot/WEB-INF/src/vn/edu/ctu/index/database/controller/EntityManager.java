package vn.edu.ctu.index.database.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import vn.edu.ctu.index.database.action.util.ActionUtils;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class EntityManager
 */
public class EntityManager extends MVCPortlet {
 
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		//super.serveResource(resourceRequest, resourceResponse);
		String packagePath = ParamUtil.getString(resourceRequest, "packagePath"),
				className = ParamUtil.getString(resourceRequest, "className");
		// (ex: ctu.edu.vn.qlcd.model.impl.XXXModelImpl)
		String fullClassName = packagePath + ".model.impl." + className + "ModelImpl";
		try {
			HashMap<String, String> fields =  ActionUtils.getFields(fullClassName);
			System.out.println(fields);
			Iterator<Entry<String, String>> it = fields.entrySet().iterator();
			while (it.hasNext()){
				Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
				System.out.println(entry.getKey() + "-----------" + entry.getValue());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
