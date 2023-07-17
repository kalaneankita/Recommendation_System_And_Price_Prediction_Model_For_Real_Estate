
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">
 <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/jquery-ui.min.js" type="text/javascript"></script>
      <!--// plugin-specific resources //-->
        <script src='rating/jquery.js' type="text/javascript"></script>
	<script src='rating/jquery.MetaData.js' type="text/javascript" language="javascript"></script>
 <script src='rating/jquery.rating.js' type="text/javascript" language="javascript"></script>
 <link href='rating/jquery.rating.css' type="text/css" rel="stylesheet"/>
 <!--// documentation resources //-->
 <!--<script src="http://code.jquery.com/jquery-migrate-1.1.1.js" type="text/javascript"></script>-->
 
<script language="Javascript" type="text/javascript">
<!--

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequest(st) {
    
    http.open('get', 'GetProperties?searchText=' + st+'&groupName=NA');
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('users').innerHTML = response;
    }
}
-->
</script>
</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<% try{ response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%>
<div class="container-fluid">
   

       
<div class="row">
 
<div class="col-md-12">
     <form method="post" name="frmSearch" >
<table class="tblform">
<tr>
<td>Search Properties</td>
<td>
 
 <input type="text" name="txtname" class="form-control" onkeyup="makeGetRequest(this.value)" required/>
</td>
</tr>
</table></form>
 <div id="users">
 
  
<h2> Matching Properties Report</h2>
<hr>

<div class="row">
 
<soham:forEach items="${lst}" var="rec">
<div class="col-md-4" >
<div style="background-image:url('Uploads/${rec.path}');background-size: contain;background-repeat:no-repeat;min-height:150px;border:2px solid purple">

</div>
<table class="table table-bordered tblreport" style="border:2px solid purple">
<tr>
<th>UserId</th><td>${rec.userid}</td></tr><tr>

<th>Title</th><td>${rec.title}</td></tr><tr>
<th>Area</th><td>${rec.area}</td></tr><tr>
<th>Address</th><td>${rec.addr}</td></tr><tr>
<th>City</th> <td>${rec.city}</td> </tr><tr>
<th>State</th><td>${rec.state}</td></tr><tr>
 
<th>Property type</th><td>${rec.proptype}</td></tr><tr>
 <th>Bus Stand Distance</th><td>${rec.busStandDist} meter</td></tr><tr>
 <th>Evaluated Cost(in Rs.)</th> 
 <td>
${rec.evalcost2}
</td></tr><tr>
<td colspan="2">
<a class="btn btn-primary" href="http://localhost:80/OnlineHousePricePredictionPython/PropertyValuation.py?propId=${rec.propId}&propType=${rec.proptype}&searchText=<%=session.getAttribute("searchText").toString().trim() %>">Calculate Cost</a>
 
 
<a  class="btn btn-primary" href="ViewPhotos.jsp?propId=${rec.propId}" target="_blank">View Photos</a>
</td>
</tr>
<tr>
<td colspan="2">
 <a href="SubmitLiking?propId=${rec.propId}"><img src="assets/img/like.png" width="25px">${rec.likes} </a>
 
 <a href="SubmitDisLiking?propId=${rec.propId}"><img src="assets/img/dislike.jpg" width="25px">${rec.dislikes} </a>
 
<!-- 
 <div style="min-width:100px;border:1px solid black;min-height: 20px;font-size: 12px"> <div style="float:left;min-height:20px;width:${userdsc.avgrating }%;background-color:green;border:1px solid black;color:white">${userdsc.avgrating } %</div></div>
	 	
<form method="post" action="SubmitRating">
		 <div class="Clear">
    <input class="star" type="radio" name="docrate" value="40"/>
    <input class="star" type="radio" name="docrate" value="60" />
    <input class="star" type="radio" name="docrate" value="80"/>
    <input class="star" type="radio" name="docrate" value="100"/>
    <input type="hidden" name="propId" value="${userdsc.propId}"/>
    <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
    <input type="hidden" name="username" value="<%=session.getAttribute("username").toString().trim() %>"/>
    </div><br/>
    <input type="submit" value="Submit" class="btn btn-primary"/>
		 </form>-->
</td></tr>
 </table>
</div>
</soham:forEach>
</div>
 </div>
<%
}
catch(Exception ex)
{
	
} 
 %>  
</div>
</div>
 


</div>
</body>
</html>