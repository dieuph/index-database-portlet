<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>

<portlet:defineObjects />
<portlet:resourceURL var="myresources"></portlet:resourceURL>
<div id="table-details">
</div>

<div id="mainForm_viewDetails">
	<div id="mainForm"></div>
	<div id="viewDetails"></div>
</div>

<aui:script>
jQuery(document).on('ready', function(){
	updateMainTable("ctu.edu.vn.qlcd", "CongDoanVien");
});
//ham xu ly ve data table
function updateMainTable (packagePath, className){
	
	YUI().use('json-parse', 'json-stringify', 'node', 'io', function(Y){
		var tableContent = Y.one('div#table-details');
		Y.io('<%=myresources.toString()%>', {
			data: {
				<portlet:namespace/>packagePath: packagePath,
				<portlet:namespace/>className: className
			}, 
			on: {
				success: function(tx, r){
					try {
						var data = Y.JSON.parse(r.responseText);
					}
					catch (e) {
					    alert("Du lieu tra ve khong phai json!");
					}
					/* var table = Y.Node.create('<table></table>');
					for (var i=0; i<data.columnCount; i++){
					}
						
					tableContent.append(table); */
					var tableHtml = '<table>';
					for (i in data.columns){
						var key = i;
						console.log(key);
					}
				}
			}
		});
	});
}

function addJsonToClassObj (json, arrNode){
	YUI().use('node', function(Y){
		var i = 0;
		arrNode.each(function(node){
			if (node.get('tagName')=='INPUT' || node.get('tagName')=='SELECT'){
				node.set('value', json[i]);
			}
			if (node.get('tagName')=='DIV' || node.get('tagName')=='SPAN' || node.get('tagName')=='P'){
				//alert(node.all('input').length);
				if (node.one('input')!=null) 
					node.one('input').set('value', json[i]);
				else
					node.setHTML(json[i]);
			}
			i++;
		});
		NProgress.done();
	});
}
</aui:script>
