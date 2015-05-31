<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/common/message.jsp" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
    String popupId = ParamUtil.getString(request, "popupId");
%>

<%-- URLs --%>
<portlet:renderURL var="mainURL">
</portlet:renderURL>

<portlet:resourceURL var="addEntity">
    <portlet:param name="<%=Constants.CMD%>" value="addEntity"/>
</portlet:resourceURL>

<%-- BODY --%>

<%-- PORTLET HEADER --%>
<aui:fieldset cssClass="cimarit-portlet-header">
    <liferay-ui:breadcrumb />
</aui:fieldset>

<aui:form name="addNewEntityForm" cssClass="cimarit-form">
    <%-- PORTLET BODY --%>
    <aui:fieldset cssClass="cimarit-portlet-body" label="Thêm entity">        
        <aui:fieldset cssClass="cimarit-input-grid">
            <aui:input name="packagePath" label="Package path" />
            <aui:input name="entityName" label="Entity name" />
        </aui:fieldset>
    </aui:fieldset>
    
    <%-- PORTLET FOOTER --%>
    <aui:fieldset cssClass="cimarit-portlet-footer">        
        <aui:button-row cssClass="cimarit-button-row">
            <aui:button name="add" value="Thêm" cssClass="btn btn-primary" />
            <aui:button name="cancel" value="Hủy" /> 
        </aui:button-row>
    </aui:fieldset>
</aui:form>

<aui:script>
YUI().use('node', 'aui-base', 'aui-io-request-deprecated', 'aui-io-deprecated', function(Y) {
    Y.one('#<portlet:namespace/>add').on('click', function() {
        var packagePath = Y.one('#<portlet:namespace/>packagePath').get('value');
        var entityName = Y.one('#<portlet:namespace/>entityName').get('value');
        
        var data = '';
        
        Y.io.request('<%=addEntity.toString()%>', {
            dataType: 'json',
            method: 'GET',
            data: {
                <portlet:namespace/>packagePath: packagePath,
                <portlet:namespace/>entityName: entityName
            },
            on: {
                success: function() {
                    var data = this.get('responseData');
                    console.log(data);
                    
                    if (data != null) {
                        data = '{' 
                        	+ '"success": "' + data.success + '",'
                        	+ '"message": "' + data.message + '",' 
                        	+ '"className": "' + data.className + '",'
                        	+ '"packagePath": "' + data.packagePath + '",'
                        	+ '"entityName": "' + data.entityName + '",'
                        	+ '"entityId": "' + data.entityId + '"'
                        + '}';
                        
                        console.log(data);
                    }
                    
                    Liferay.Util.getOpener().<portlet:namespace/>closePopup('<%=popupId%>', data);
                }
            }
        });
        
    });
    
    Y.one('#<portlet:namespace/>cancel').on('click', function() {
        Liferay.Util.getOpener().<portlet:namespace/>closePopup('<%=popupId%>', '');
    });
});
</aui:script>