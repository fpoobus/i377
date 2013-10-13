<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>

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

		<form method="get" action="Search">
	  		<input name="searchString" id="searchStringBox" value=""/>
	 		<input type="submit" id="filterButton" value="Filtreeri" />
		  
			<br /><br />
			
			<table border="0" class="listTable" id="listTable">
			    <thead>
			      	<tr>
			          <th scope="col">Nimi</th>
			          <th scope="col">Kood</th>
			          <th scope="col"></th>
			        </tr>
			    </thead>
			    <tbody>
			    	<c:forEach items="${itemlist}" var="listitem">
						<tr>
							<td>
								<div id="row_<c:out value="${listitem.code}"/>">
									<c:out value="${listitem.name}" />
								</div>
							</td>
							<td>${listitem.code}</td>
							<td><a href="?do=delete&id=${listitem.id}">Kustuta</a></td>
						</tr>
					</c:forEach>
			    </tbody>
			</table>
		</form>
		
	</div>
	
	
</body>
</html>