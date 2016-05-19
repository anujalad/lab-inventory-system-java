<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Style.css" type="text/css">
<title>Insert title here</title>
</head>
<body bgcolor='#FCF3CF'>

<div id="page">
<header id="header">
				<div id="header-inner">	
					<div id="logo">
						<h1><a href="#">Lab<span>Inventory</span></a></h1>
					</div>
					<h3><p style="text-align: center;"><strong>Welcome to Lab Inventory System</strong>&nbsp; &nbsp;&nbsp;</p></h3>
					</div>
			</header>
			</div>

<p>&nbsp; </p> 
<p>&nbsp; </p> 
<p>&nbsp; </p> 
<p>View Devices:</p>
<%ArrayList<String> labnames= (ArrayList<String>)request.getAttribute("labs"); %>
<form action="SearchDevice" method="post">
<p>Lab:<select name="lab_selection" size="1">
<% if(labnames != null) { %>
<% for(int i=0;i<labnames.size();i++){%>
	<option ><%=labnames.get(i) %></option>
	<%}} %> 
</select>
<input name="search_button" type="submit" value="Search" /></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</form>

<form action="LoginAuthenticator" method="post">
<p>Admin Login:</p>

<p>Username:<input name="username" type="text" /></p>

<p>Password:<input name="password" type="password" /></p>

<p><input name="login" type="submit" value="Login" /></p>
<% if("Error".equals(request.getAttribute("ErrorMsg"))) {%>
<h2 style="font-style:italic;"><span style="color:#FF0000;"><b>Incorrect password.</b></span></h2>
<% } %>
</form>

</body>
</html>