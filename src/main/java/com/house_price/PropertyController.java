package com.house_price;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import models.CheckUser; 
import models.JavaFuns;
 
import models.Properties;
 
import models.Users;
import services.Base64Decoder;
import services.Mail;
 

@Controller
public class PropertyController implements ErrorController {
	@RequestMapping("/error")
    public String handleError() {
        //do something like logging
		return "home";
    }
	@RequestMapping("/home")
	public String home()
	{
		return "index.jsp";
	}
	@RequestMapping("regproperty")
	public String regproperty()
	{
		return "RegProperty.jsp";
	}
	@RequestMapping("/uploadDataset")
	public String uploadDataset()
	{
		return "RegDataset.jsp";
	}
	
	 @RequestMapping("/datasetInsrtPython")
		public ModelAndView datasetInsrtPython(HttpServletRequest request) {
			ModelAndView mv=new ModelAndView();
		 	String sts=request.getParameter("sts").toString().trim() ;
			if(sts.equals("success"))
				 mv.setViewName("Success.jsp?type=datasetInsrt");
			else
				 mv.setViewName("Failure.jsp?type=datasetInsrt");
			mv.addObject("activity","datasetReg");
			 return mv;
		}
	@RequestMapping("/registeruser")
	public ModelAndView registeruser(Users stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/Uploads/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
			  
			 String fileName=stu.getUserid()+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setPath(fileName);
			 String st=stu.addNewUser();
				if(st.equals("success"))
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","UserReg");
		 return mv;
		
	}
	@RequestMapping("/propRegDetails")
	public ModelAndView propRegDetails(Properties stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 
		  
		 try {
				JavaFuns jf=new JavaFuns();
				Vector v=jf.getValue("select (ifnull(max(did),1000)+1) as mxid from propertyDetails",1);
				int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
			
				 stu.setDid(String.valueOf(mxid));
			  String st=stu.addNewPropertyDetails();
				if(st.equals("success"))
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		} 
		 mv.addObject("activity","PropRegDetails");
		 return mv;
		
	}
	@RequestMapping("/propReg")
	public ModelAndView propReg(Properties stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/Uploads/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
				JavaFuns jf=new JavaFuns();
				Vector v=jf.getValue("select (ifnull(max(propId),1000)+1) as mxid from properties",1);
				int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
			
			 String fileName=mxid+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setPath(fileName);
			 String st=stu.addNewProperty();
				if(st.equals("success"))
				{
					if(stu.getProptype().equals("Flat")||stu.getProptype().equals("Bungalow")||stu.getProptype().equals("House")||stu.getProptype().equals("Duplex"))
					{
						mv.setViewName("RegPropertyDetails.jsp?title="+stu.getTitle()+"&propId="+stu.getPropId());
					}
					else
					mv.setViewName("Success.jsp");
				}
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","PropReg");
		 return mv;
		
	}
	 
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin.jsp";
	}
	@RequestMapping("/user")
	public String user()
	{
		return "user.jsp";
	}
	@RequestMapping("/")
	public String home1()
	{
		return "index.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
        session.invalidate();
		return "Logout.jsp";
	}
	@RequestMapping("/SubmitLiking")
	public ModelAndView submitLiking(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		JavaFuns jf=new JavaFuns();
		System.out.println("qr="+"update properties set likes=likes+1 where propId="+request.getParameter("propId").trim());
		if(jf.execute("update properties set likes=likes+1 where propId="+request.getParameter("propId").trim())) {}
		String qr="insert into userlikings(propId,userid) values("+request.getParameter("propId").trim()+",'"+ses.getAttribute("userid").toString().trim()+"')";
		
		if(jf.execute(qr)) {}
		mv.setViewName("GetProperties1?searchText="+ses.getAttribute("searchText").toString().trim());
		  
		return mv;
	 
	}
	@RequestMapping("/SubmitDisLiking")
	public ModelAndView SubmitDisLiking(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		JavaFuns jf=new JavaFuns();
		System.out.println("qr="+"update properties set dislikes=dislikes+1 where propId="+request.getParameter("propId").trim());
		if(jf.execute("update properties set dislikes=dislikes+1 where propId="+request.getParameter("propId").trim())) {}
		//String qr="insert into userlikings(propId,userid) values("+request.getParameter("propId").trim()+",'"+ses.getAttribute("userid").toString().trim()+"')";
		
		//if(jf.execute(qr)) {}
		mv.setViewName("GetProperties1?searchText="+ses.getAttribute("searchText").toString().trim());
		  
		return mv;
	 
	}
	@RequestMapping("/GetProperties")
	public ModelAndView GetUsers(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		Properties obj=new Properties();
		  List<Properties> lst=obj.getPropSearch( request.getParameter("searchText").toString().trim()  );
		 ses.setAttribute("searchText",  request.getParameter("searchText").toString().trim()  );
		 
		mv.setViewName("GetProps.jsp");
		mv.addObject("lst",lst); 
		return mv;
	 
	}
	@RequestMapping("/GetContentFilteringProps")
	public ModelAndView GetContentFilteringProps(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		Properties obj=new Properties();
		  List<Properties> lst=obj.getPropSearch2( ses.getAttribute("userid").toString().trim()  );
		 //ses.setAttribute("searchText",  request.getParameter("searchText").toString().trim()  );
		  ses.setAttribute("searchText", "GetContentFilteringProps");
		mv.setViewName("GetLikedProps.jsp");
		mv.addObject("lst",lst); 
		return mv;
	 
	}
	@RequestMapping("/GetCollaborativeFilteringProps")
	public ModelAndView GetCollaborativeFilteringProps(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		Properties obj=new Properties();
		  List<Properties> lst=obj.getPropSearch3( ses.getAttribute("userid").toString().trim()  );
		 //ses.setAttribute("searchText",  request.getParameter("searchText").toString().trim()  );
		  ses.setAttribute("searchText", "GetCollaborativeFilteringProps");
		mv.setViewName("GetLikedProps.jsp");
		mv.addObject("lst",lst); 
		return mv;
	 
	}
	@RequestMapping("/GetLikedProps")
	public ModelAndView GetLikedProps(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		Properties obj=new Properties();
		  List<Properties> lst=obj.getPropSearch1( ses.getAttribute("userid").toString().trim()  );
		 //ses.setAttribute("searchText",  request.getParameter("searchText").toString().trim()  );
		  ses.setAttribute("searchText", "GetLikedProps");
		mv.setViewName("GetLikedProps.jsp");
		mv.addObject("lst",lst); 
		return mv;
	 
	}
	@RequestMapping("/GetProperties1")
	public ModelAndView GetUsers1(HttpServletRequest request,HttpSession ses)
	{
		 
		ModelAndView mv = new ModelAndView();
		Properties obj=new Properties();
		  List<Properties> lst=obj.getPropSearch( request.getParameter("searchText").toString().trim()  );
		 ses.setAttribute("searchText",  request.getParameter("searchText").toString().trim()  );
		 
		mv.setViewName("GetProps2.jsp");
		mv.addObject("lst",lst); 
		return mv;
	 
	}
	@RequestMapping("/UploadPhotosPython")
	public ModelAndView UploadPhotosPython()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Success.jsp");
		mv.addObject("activity","photos");
		return mv;
	}
	@RequestMapping("/FromPython")
	public ModelAndView FromPython(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		//mv.setViewName("Success.jsp");
		mv.addObject("activity","propreg");
		mv.addObject("searchText",request.getParameter("searchText").toString().trim());
		if(request.getParameter("searchText").toString().trim().equals("viewProperties"))
		{
			mv.setViewName("viewProperties");
		}
		else if(request.getParameter("searchText").toString().trim().equals("GetLikedProps"))
		{
			mv.setViewName("GetLikedProps");
		}
		else if(request.getParameter("searchText").toString().trim().equals("GetCollaborativeFilteringProps"))
		{
			mv.setViewName("GetCollaborativeFilteringProps");
		}
		else if(request.getParameter("searchText").toString().trim().equals("GetContentFilteringProps"))
		{
			mv.setViewName("GetContentFilteringProps");
		}
		else
		mv.setViewName("GetProperties1?searchText="+request.getParameter("searchText").toString().trim());
		
		return mv;
	}
	@RequestMapping("/Cities")
	public String cities()
	{
		return "Cities.jsp";
	}
	@RequestMapping("/Areas")
	public String Areas()
	{
		return "Areas.jsp";
	}
	@RequestMapping("/registration")
	public String registration()
	{
		return "Registration.jsp";
	}
	@RequestMapping("/viewUsers")
	@SessionScope
	public ModelAndView viewUsers() {
		
		List<Users> lst = new ArrayList<Users>();
		Users vs = new Users();
		lst=vs.getStudentReport();
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewUsersReport.jsp");
		return mv;
	}
	
	@RequestMapping("/viewProperties")
	@SessionScope
	public ModelAndView viewProperties(HttpSession ses) {
		
		List<Properties> lst = new ArrayList<Properties>();
		Properties vs = new Properties();
		lst=vs.getMyPropsReport(ses.getAttribute("userid").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPropertiesReport.jsp");
		return mv;
	}
	@RequestMapping("/adminHome")
	public String adminHome()
	{
		return "admin.jsp";
	}
	@RequestMapping("/decisionTreeOutput")
	public ModelAndView decisionTreeOutput(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		Base64Decoder decoder=new Base64Decoder();
		String str=new String(decoder.decode(request.getParameter("param").toString().trim()));
		System.out.println("output"+str);
		String userid=str.split("\\|")[0];
		String requserid=str.split("\\|")[1];
		String output=str.split("\\|")[2];
		output=output.replace("[", "");
		output=output.replace("]", "");
		System.out.println("output="+output);
		String access="failure";
		if(output.trim().equals("1"))
		{
			access="success";
		}
		 
		return mv;
	}
	@RequestMapping("/OTPAuth")
	public ModelAndView OTPAuth(CheckUser user,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
		try {
			if(user.getSentOTP().equals(user.getOTP()))
			{
				 mv.setViewName(ses.getAttribute("utype").toString().trim());
			}
			else
			{
				mv.setViewName("LoginFailure.jsp?type=Auth");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	    return mv;
	}
	@RequestMapping("/check")
	public ModelAndView check(CheckUser cu,HttpServletRequest request) {
		String userid=request.getParameter("userid").toString().trim();
		String pswd=request.getParameter("pswd").toString().trim();
		cu.setUserid(userid);
		cu.setPswd(pswd);
		String st=cu.checkUser(request);
		 String otp=models.RandomString.getAlphaNumericString(4);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName(st);
		 if(st.equals("user"))
		 {
		    mv.setViewName("OTPAuth.jsp");
		    mv.addObject("userid",cu.getUserid());
		    mv.addObject("otp",otp);
		    JavaFuns jf=new JavaFuns();
		    Vector v=jf.getValue("select usernm,emailid from  userdetails where userid='"+cu.getUserid()+"'" , 2);
		    mv.addObject("email",v.elementAt(1).toString().trim());
		    Mail mail=new Mail();
		    String msg="Dear "+v.elementAt(0).toString().trim()+" \n Your one time password is "+otp;
		    System.out.println("otp="+otp);
		    try
		    {
		    	if(mail.sendMail(msg,v.elementAt(1).toString().trim(), "One Time Password"))
		    	{
		    		System.out.println("email sent");
		    	}
		    }
		    catch (Exception e) {
				// TODO: handle exception
		    	System.out.println("err in mail="+e.getMessage());
			}
		 }
		System.out.println(st);
		return mv;
	}
}
