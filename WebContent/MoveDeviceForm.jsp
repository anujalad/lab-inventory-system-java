<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Style.css" type="text/css">
<title>Insert title here</title>
</head>
<body  bgcolor='#FCF3CF'>
<div id="page">
<header id="header">
				<div id="header-inner">	
					<h2>Edit Device Details :</h2>
			   </div>                       
			</header>
			</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<%ArrayList<String> labnames= (ArrayList<String>)request.getAttribute("labs"); %>

<form action="MoveDevice" method="post">
 
<p> <label>Device Id: </label> <input name="device_id" type="text" value="${myBean.deviceId}"/> <input name="button" type="submit" value="Get Device Details" /></p>
 
<p> <label>From Lab: </label> <input name="labs" type="text" value="<%=(request.getAttribute("labName") != null) ? request.getAttribute("labName") : "" %>">
<!--  <select  name="lab_selection" size="1">
<% if(labnames != null) { %>
<% for(int j=0;j<labnames.size();j++){ %>
<option > <%=labnames.get(j) %></option>
<%} }%>
</select> -->

</p>

<p> <label> Date: </label><input name="date" type="text" placeholder="yyyy-MM-dd" /> </p>

<p> <label> To Lab:</label> 
<select  name="lab_selection" size="1">
<% if(labnames != null) { %>

<% for(int j=0;j<labnames.size();j++){ %>
<option > <%=labnames.get(j) %></option>
<% }} %>
</select>
</p>

<p> <input name="move" type="submit" value="Move Device" />  </p>


</form>
<% String res=(String)request.getAttribute("message");
if (res!=null && "success".equals(res) ) {%>
     <br> Device Moved
     <% }else if(res!=null && "failure".equals(res)){ %>
     <br> Device not moved
     <%} %>
</body>
</html>