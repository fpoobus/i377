<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>

<style>
body {
	text-align:center;	
}

.content {
	width: 800px;
	margin-left: auto;
	margin-right: auto;
}

.menu_link {
	display: inline;
	text-decoration: none;
	padding:10px;
	border: 1px solid black;
}

</style>

</head>
<body>

	<div class="content">
	
		<ul id="menu">
		    <li class="menu_link"><a href="Search" id="menu_Search">Otsi</a></li>
		    <li class="menu_link"><a href="Add" id="menu_Add">Lisa</a></li>
		    <li class="menu_link"><a href="Admin?do=clear_data" id="menu_ClearData">Tühjenda</a></li>
		</ul>
		

		<c:forEach items="${itemlist}" var="listitem">
		    <table class="formTable" id="formTable">
		      <tbody>
		        <tr>
		          <td>Nimi:</td>
		          <td><input name="name" id="nameBox" disabled='disabled' value="<c:out value="${listitem.name}"/>"/></td>
		        </tr>
		        <tr>
		          <td>Kood:</td>
		          <td><input name="code" id="codeBox" disabled='disabled' value="<c:out value="${listitem.code}"/>"/></td>
		        </tr>
		        <tr>
		        	<td>Ülemüksus:</td>
		        	<td>
			        	<select disabled='disabled' id="superUnitCode" name="superUnitCode">
		        			<c:forEach items="${parentlist}" var="parentlist">
		        				<option selected='selected' value="<c:out value="${parentlist.code}"/>"><c:out value="${parentlist.name}"/></option>
		        			</c:forEach>
	        			</select>
        			</td>
		        </tr>
		        <tr>
		        	<td>Alamüksus:</td>
		        	<td>
	        			<c:forEach items="${childlist}" var="childlist">
	        				<span id="sub_<c:out value="${childlist.code}"/>"><c:out value="${childlist.code}"/></span><br/>
	        			</c:forEach>
        			</td>
		        </tr>
		        <tr>
		          <td colspan="2" align="right"><br/>
		            <a href="Search">Tagasi</a>
		          </td>
		        </tr>
		      </tbody>
		    </table>
	    </c:forEach>

		
	</div>
	
	
</body>
</html>