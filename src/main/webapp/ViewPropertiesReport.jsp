<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">

<title></title>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<%

String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));
if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60);
 
%>
<h2>My Properties Report</h2>
<hr>

<table class="table table-bordered">
<tr style="background-color:seashell">
<th>UserId</th>
<th>Title</th>
<th>Area</th>
<th>Address</th>
<th>City</th> 
<th>State</th>
 
<th>Property type</th>
 <th>Bus Stand Distance</th>
 <th>Evaluated Cost(in Rs.)
</tr>


<soham:forEach items="${std}" var="rec">

<tr>
<td>${rec.userid}</td>
<td>${rec.title}</td>
<td>${rec.area}</td>
<td>${rec.addr}</td>
<td>${rec.city}</td> 
<td>${rec.state}</td>
 
<td>${rec.proptype}</td>
<td>${rec.busStandDist} meter</td>  
<td>
${rec.evalcost2}
</td>
<td>
<a href="UploadPhotos.jsp?propId=${rec.propId}">Upload Photos</a>
</td>
<td>
<a href="ViewPhotos.jsp?propId=${rec.propId}">view Photos</a>
</td>
<td>
<!-- <a href="http://localhost:80/OnlinePropertyValuationPython/PropertyValuation.py?propId=${rec.propId}">Calculate Cost</a>
-->
<a class="btn btn-primary" href="http://localhost:80/OnlineHousePricePredictionPython/PropertyValuation.py?searchText=viewProperties&propId=${rec.propId}&propType=${rec.proptype}">Calculate Cost</a>
 
</td>
</tr>

</soham:forEach>
</table>

<%
if(usertype.equals("admin")){
%> 
<%
}
else{	%>
	 
<%
	}
	
}
else{
	%>
	<h2>Invalid Session...Login again</h2>
	<br>
	<a href="index.jsp">Login</a>
	
	<%
}

%>
</body>
</html>