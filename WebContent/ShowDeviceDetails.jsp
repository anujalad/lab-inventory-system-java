<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="claases.Device" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor='#FCF3CF'>
<table border="1" cellpadding="4" cellspacing="2">
            <caption><h3>Device Details</h3></caption>
            
            <tr>
                <th>Device Id</th>
                <th>Device Type </th>
                <th>Lab Id</th>
                <th>User Id</th>
                <th>Date </th>
                <th>Model Name</th>
                <th>Status</th>
             </tr>
             <%ArrayList<Device> d= (ArrayList<Device>)request.getAttribute("all_devices");
            for(int j=0;j<d.size();j++)
            {
             %>
             <tr>
              <td> <%= d.get(j).getDeviceId() %></td>
           
             <td> <%=d.get(j).getDeviceType() %></td>
             <td> <%=d.get(j).getLabId() %></td>
              <td> <%=d.get(j).getUserId() %></td>
              <td> <%=d.get(j).getStartDate() %></td>
              <td> <%=d.get(j).getModelName() %></td>
              <td> <%=d.get(j).getStatus() %></td>
             </tr>
            <% } %>
             
</table>
</body>
</html>