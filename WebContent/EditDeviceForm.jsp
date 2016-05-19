<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Style.css" type="text/css">

<title>Edit device form</title>
</head>
<body bgcolor='#FCF3CF'>
<div id="page">
<header id="header">
				<div id="header-inner">	
					<h2>Edit Device Details :</h2>
			   </div>
			</header>
			</div>
<p>&nbsp;</p>
<p>&nbsp;</p>

<form action="EditDevice" method="post">


<label>Device Id:</label><input name="device_id" type="text" value= "${myBean.deviceId}" /> 
<input name="button" type="submit" value="Get Device Details" /></p>

<label>Device Type :</label><input name="device_type" type="text" value= "${myBean.deviceType }" 
/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </p>

<label>User Id:</label><input name="user_id" type="text" value= "${myBean.userId}" 
/></p> 

<label>Date:</label><input name="date" type="text" placeholder="yyyy-MM-dd" value= "<%=(request.getAttribute("date") != null) ? request.getAttribute("date") : "" %>"
/></p> 

<label>Model Name of a Device:</label><input name="model_name" type="text" value= "${myBean.modelName}"
/></p>
<label>Status:</label><input name="status" type="text" value= "${myBean.status}"
/></p>

<p><input name="button" type="submit" value="Edit Device"  />     <input name="button" type="submit" value="Delete Device" />  </p>


</form>
<%
	String res = (String)request.getAttribute("message");
	//String msg=(String) request.getAttribute("DeleteMsg");
	if(res != null && "success".equals(res)) { %>
		<br> Device Edited
	<%}  if(res != null && "failure".equals(res)) { %>
		<br> Not Edited
		
<%	}  else if (res!=null && "deleted".equals(res)){ %>
        <br> Device Deleted
        <% }%>
</body>
</html>