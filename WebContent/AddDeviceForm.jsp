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
					
			   </div>
			</header>
			</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<%ArrayList<String> labnames= (ArrayList<String>)request.getAttribute("labs"); %>

<form action="AddNewDevice" method="post">
<h2>Enter Device Details :</h2>

<label>Device Id:</label><input name="device_id" type="text" /></p>

<label>Device Type :</label><input name="device_type" type="text" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </p>

<label>Lab :</label><select name="lab_selection" size="1">
<%if(labnames!=null){%>
<% for(int i=0;i<labnames.size();i++){%>
	<option ><%=labnames.get(i) %></option>
	<%}} %> 
</select>	</p> 

<label>User Id:</label><input name="user_id" type="text" /></p> 

<label>Date:</label><input name="date" type="text" placeholder="yyyy-MM-dd"/></p> 

<label>Model Name of a Device:</label><input name="model_name" type="text" /></p>

<label>Status:</label><input name="status" type="text" /></p>

<p><input name="add_device" type="submit" value="Add Device"  />
			

</form>
<%
	String res = (String)request.getAttribute("message");
	if(res != null && "success".equals(res)) { %>
		<br> Device Added
	<%} else if(res != null && "failure".equals(res)) { %>
		<br> Not added
		
<%	}
%>


</body>
</html>