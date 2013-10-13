<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add</title>

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
		    <li class="menu_link"><a href="Admin?do=insert_data" id="menu_InsertData">Sisesta näidisandmed</a></li>
		</ul>

		<form method="post" action="Add">
		
		    <table class="formTable" id="formTable">
		      <tbody>
		        <tr>
		          <td>Nimi:</td>
		          <td><input name="name" id="nameBox" /></td>
		        </tr>
		        <tr>
		          <td>Kood:</td>
		          <td><input name="code" id="codeBox"/></td>
		        </tr>
		        <tr>
		          <td colspan="2" align="right"><br/>
		            <input type="submit" value="Lisa" id="addButton"/>
		          </td>
		        </tr>
		      </tbody>
		    </table>
	 	</form>
		
	</div>
	
	
</body>
</html>