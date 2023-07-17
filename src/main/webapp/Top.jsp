<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title> House Price Prediction
  </title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

</head>

<body>

  <!-- ======= Header/Navbar ======= -->
  <nav class="navbar navbar-default navbar-trans navbar-expand-lg fixed-top">
    <div class="container-fluid">
      <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDefault" aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
  <a class="logotxt" href="home">Recommendation System and 

<span class="color-b">House Price Prediction Model for Real Estate</span></a>
<br/>
      <div class="navbar-collapse collapse justify-content-center" id="navbarDefault">
        <ul class="navbar-nav">
           <li class="nav-item">
            <a class="nav-link active" href="<%=session.getAttribute("utype") %>">Home</a>
          </li>
 <%if(session.getAttribute("usertype").toString().trim().equals("admin"))
							{%>
							<li class="nav-item">
            <a class="nav-link " href="viewUsers"> View Users </a></li>
            <li class="nav-item">
            <a class="nav-link " href="uploadDataset"> Upload Dataset </a></li>
							<%} else if(session.getAttribute("utype").toString().trim().equals("user"))
							{%>
							  
							 <li class="nav-item">
            <a class="nav-link " href="regproperty"> Register Property</a></li>
							
							 <li class="nav-item">
            <a class="nav-link " href="GetLikedProps">Liked Properties</a>
			
			 <li class="nav-item">
            <a class="nav-link " href="GetContentFilteringProps">Preference wise Recommendation </a>
		 <li class="nav-item">
            <a class="nav-link " href="GetCollaborativeFilteringProps">Similarity Users Recommendation </a>
		
							 <li class="nav-item">
            <a class="nav-link " href="viewProperties">My Properties</a>
							   			<%} %>
						
					 
         

          <li class="nav-item">
            <a class="nav-link " href="logout">Logout</a>
          </li>

          
<!-- 
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Pages</a>
            <div class="dropdown-menu">
              <a class="dropdown-item " href="property-single.html">Property Single</a>
              <a class="dropdown-item " href="blog-single.html">Blog Single</a>
              <a class="dropdown-item " href="agents-grid.html">Agents Grid</a>
              <a class="dropdown-item " href="agent-single.html">Agent Single</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="contact.html">Contact</a>
          </li> -->
        </ul>
      </div>
 

    </div>
  </nav><!-- End Header/Navbar -->

   <div class="container-fluid">
   <div class="col-md-12 innerbanner"  >
    
   </div>
   </div>
    <div class="container">

 <%
try
{  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%>
  
        
	  <p class="para">
            Logged in as <%=session.getAttribute("userid").toString() %>( <%=session.getAttribute("usertype").toString() %>)
            </p>
        
    <!--// end-smoth-scrolling -->
    <%}catch(Exception ex)
{
    	System.out.println("err="+ex.getMessage());
    	 
}%>
<div id="preloader"></div>
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>