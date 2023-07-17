
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <div id="users"></div>
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