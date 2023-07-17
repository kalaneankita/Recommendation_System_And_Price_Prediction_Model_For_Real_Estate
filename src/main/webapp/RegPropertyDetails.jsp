 
<%@page import="models.States"%>
<%@page import="models.GetStateNCities"%>
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>

<script language="Javascript" type="text/javascript">
 

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
   // st=document.frm.state.value;
   
    http.open('get', 'Cities?state=' + st);
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('cities').innerHTML = response;
    }
}
 
</script>

<script language="Javascript" type="text/javascript">
 

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

function makeGetRequest1(st) {
   // st=document.frm.state.value;
   
    http.open('get', 'Areas?city=' + st);
    http.onreadystatechange = processResponse1;
    http.send(null);
}

function processResponse1() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('areas').innerHTML = response;
    }
}
 
</script>
</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<%  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);%>
<div class="container">
<div class="row">
<div class="col-md-12">

<center><h2>Register Property Details</h2></center><br/>
 		
<form   action="propRegDetails" method="post" >
<div class="row">
<div class="col-md-6">
<table class="tblform">
 <tr><td>Title/Description</td>
                <td><textarea  class="form-control"  name="title"   required><%=request.getParameter("title") %></textarea></td></tr>
    <tr><td>Total Rooms</td>
                <td><textarea  class="form-control"  name="rooms"    required></textarea></td></tr>
      <tr><td>Floor No</td>
                <td><input type="text"  class="form-control"  name="floorNo"    required/></td></tr>
              						   
		         						   
				  						   
				 		  
                <tr>
									 <td>House Condition
									 </td>
									 <td>    <input type="hidden" name="propId" value="<%=request.getParameter("propId").trim() %>"/>
               
									 <select required name="proptype" class="form-control" >
									 <option value=""><--select--></option>
										 
									 <option value="old">Old</option>
									 <option value="new">New</option>
									 <option value="renovated">Renovated</option>
									  </select>
									 </td>
									 </tr>  
				<tr>
									 <td>House Furnished or Not
									 </td>
									 <td> 
									 <select required name="furniture" class="form-control" >
									 <option value=""><--select--></option>
										 
									 <option value="Furnished">Furnished</option>
									 <option value="NA">Not Furnished</option>
									  
									  </select>
									 </td>
									 </tr> 
				<tr>
									 <td>City Type
									 </td>
									 <td> 
									 <select required name="city" class="form-control" >
									 <option value=""><--select--></option>
										 
									 <option value="Metro">Metro</option>
									 <option value="Non Metro">Non Metro</option>
									  
									  </select>
									 </td>
									 </tr>  
		<tr> <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/>
		  </td></tr>
		  </table>
</div>
<div class="col-md-6">
 			 			 
	</div>	</div> 
		  </form>
</div>
</div>

</div>

</div>
</body>
</html>