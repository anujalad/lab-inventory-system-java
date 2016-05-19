<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
   <%@ page import="java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Style.css" type="text/css">
<title>Welcome Admin</title>
</head>
<body bgcolor='#FCF3CF'>

<div id="page">
<header id="header">
				<div id="header-inner">	
					<div id="logo">
						<h1><a href="#">Lab<span>Inventory</span></a></h1>
					</div>
					<div id="top-nav">
						<ul>
						<li><a href="#">Device</a>
							  <ul> 
							  <li><a href="PopulateLabs">Move Device</a><li>
							  <li><a href="AddDeviceLabs">Add Device</a><li>
							   <li><a href="EditDeviceForm.jsp">Edit Device Details</a><li>
							   <li><a href="EditDeviceForm.jsp">Delete Device</a><li>
							   </ul>
						 </li>
						
						
						<li><a href="WelcomeServlet">Logout</a></li>
						</ul>
					</div>
					<div class="clr"></div>
				</div>
			</header>
Admin home! Welcome
<%=request.getAttribute("user_name") %>

</div>

<%ArrayList<String> labnames= (ArrayList<String>)request.getAttribute("labs"); %>
<p>View Devices:</p>
<form action="SearchDevice" method="post">
<p>Lab:<select name="lab_selection" size="1">
<%if(labnames!=null){%>
<% for(int i=0;i<labnames.size();i++){%>
	<option ><%=labnames.get(i) %></option>
	<%}} %> 
</select>	
<input name="search_button" type="submit" value="Search" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>


</body>
</html>