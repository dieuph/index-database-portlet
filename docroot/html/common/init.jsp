<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List" %> 
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Collections" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.service.persistence.ListTypeUtil"%>
<%@page import="com.liferay.portal.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.model.ListType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.Math"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>