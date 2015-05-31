<%@page import="vn.edu.ctu.index.database.model.Entity"%>
<%@page import="vn.edu.ctu.index.database.action.util.ActionUtils"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/message.jsp" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
    String addEntityPopupDialog = "addEntityPopupDialog";
%>

<%-- URLs --%>
<portlet:renderURL var="mainURL">
</portlet:renderURL>

<portlet:renderURL var="addEntity" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="mvcPath" value="/html/entityindex/addnew.jsp" />
    <portlet:param name="popupId" value="<%=addEntityPopupDialog%>" />
</portlet:renderURL>

<portlet:resourceURL var="removeEntity">
    <portlet:param name="<%=Constants.CMD%>" value="removeEntity"/>
</portlet:resourceURL>

<%-- BODY --%>
<%-- PORTLET HEADER --%>
<aui:fieldset cssClass="cimarit-portlet-header">
    <liferay-ui:breadcrumb />
</aui:fieldset>

<%-- PORTLET BODY --%>
<div id="message"></div>
<aui:fieldset cssClass="cimarit-portlet-body" label="Entity Index">
        
    <aui:button-row cssClass="cimarit-button-row button-left">
        <aui:button cssClass="btn btn-primary" icon="icon-plus" value="Add new" 
            onClick="showAddEntityPopupDialog(this);" />
    </aui:button-row>
    
    <ul id="entities">
        
    <%
        List<Entity> entities = ActionUtils.findAll();
        for (Entity entity : entities) {
    %>
        <li>
            <a title="<%=ActionUtils.getClassNameValue(entity.getClassNameId())%>"
                packagepath="<%=entity.getPackagePath()%>"
                entityname="<%=entity.getEntityName()%>">
                <%=entity.getEntityName()%>
            </a>
            &nbsp;
            <aui:button icon="icon-remove" title="Xóa" onClick="removeEntity(this);" entityid="<%=entity.getEntityId()%>" />
        </li>
        
    <%      
        }
    %>   
    </ul>
</aui:fieldset>

<%-- PORTLET FOOTER --%>
<aui:fieldset cssClass="cimarit-portlet-footer" />

<aui:script>
YUI().use('node', 'io', 'event', 'animation', 'aui-form-validator', 'aui-io-request-deprecated', 'aui-io-deprecated', function(Y) {
	window.removeEntity = function(node) {
		var entityId = node.getAttribute('entityid');
		
		Y.io.request('<%=removeEntity.toString()%>', {
            dataType: 'json',
            method: 'GET',
            data: {
                <portlet:namespace/>entityId: entityId
            },
            on: {
                success: function() {
                    var data = this.get('responseData');
                    console.log(data);
                    
                    if (data != null) {
                        var messageNode = Y.one("#message");
                        console.log(messageNode);
                        
                    	if (data.success == 'true') {
                    		messageNode.addClass('alert alert-success');
                    	}
                    	
                    	if (data.success == 'false') {
                    		messageNode.addClass('alert alert-error');
                        }
                    	
                    	messageNode.set('text', data.message);
                    	
                    	var deletedNode = Y.one(node).get('parentNode');
                    	
                    	console.log(deletedNode);
                    	deletedNode.remove(true);
                    }
                    
                }
            }
        });
	}
	
    window.showAddEntityPopupDialog = function(node) {
        var url = '<%=addEntity.toString()%>';
        
        YUI().use('aui-io-deprecated', 'liferay-util-window', function(Y) {
            Liferay.Util.openWindow({
                dialog: {
                    centered: true,
                    destroyOnClose: true,
                    destroyOnHide: true,
                    cache: false,
                    width: 800,
                    height: 400,
                    modal: true
                },
                title: 'Thêm entity',
                id: '<%=addEntityPopupDialog%>',
                uri: url
            });
    
            Liferay.provide(window, '<portlet:namespace/>closePopup', function(popupIdToClose, dataReceive) {
                console.log("popupIdToClose: " + popupIdToClose);
                console.log("dataReceive: " + dataReceive);
                
                var popupDialog = Liferay.Util.Window.getById(popupIdToClose);
                
                if (dataReceive != "") {
                    dataReceive = JSON.parse(dataReceive);
                    console.log(dataReceive);
                    
                    var success = dataReceive[Object.keys(dataReceive)[0]];
                    var message = dataReceive[Object.keys(dataReceive)[1]];
                    var className = dataReceive[Object.keys(dataReceive)[2]];
                    var packagePath = dataReceive[Object.keys(dataReceive)[3]];
                    var entityName = dataReceive[Object.keys(dataReceive)[4]];
                    var entityId = dataReceive[Object.keys(dataReceive)[5]];
                    
                    if (success != "") {
                    	var messageNode = Y.one("#message");
                        
                        if (success == 'true') {
                            messageNode.addClass('alert alert-success');
                            
                            var entityList = Y.one('#entities');
                            console.log(entityList);
                            
                            entityList.insert('<li>'
                                + '<a title="' + className + '" packagepath="' + packagePath +'" entityName="' + entityName + '">'
                                    + entityName
                                + '</a>'
                                + '&nbsp;&nbsp;'
                                + '<button class="btn" onClick="removeEntity(this);" type="button" title="Xóa" entityid="' + entityId + '">'
                                    + '<i class="icon-remove"></i>'
                                + '</button>'
                            + '</li>');
                        }
                        if (success == 'false') {
                            messageNode.addClass('alert alert-error');
                        }
                        messageNode.set('text', message);
                    }
                }
                
                popupDialog.destroy();
            }, [ 'liferay-util-window' ]);
        });
    }
});
</aui:script>
