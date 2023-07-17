package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.mail.search.SearchTerm;

import org.springframework.web.multipart.MultipartFile;

import services.DBConnector;

 

public class Properties {
	private String userid,propId,did,rooms,floorNo,furniture;
	private long evalcost2;
	private String evalcost1;
	private String city;
	private String state;
	private String usernm;
	private String village;
	private String title;
	private String proptype;
	private String area;
	private String country;
	private String propcondition;
	private String busStandDist;
	private String autoStandDist;
	private String pincode,addr;
	private MultipartFile file;
	private String path;
	private String nearbyHosp,propType,nearbyColg,nearbySchools,nearbyShops,nearbyMall,purchaseDt,propunit; 
	private float propsize,evalcost,mainRoadDist;
	private int likes,dislikes;
  
	
	
public long getEvalcost2() {
		return evalcost2;
	}

	public void setEvalcost2(long evalcost2) {
		this.evalcost2 = evalcost2;
	}

	public String getEvalcost1() {
		return evalcost1;
	}

	public void setEvalcost1(String evalcost1) {
		this.evalcost1 = evalcost1;
	}

public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getFurniture() {
		return furniture;
	}

	public void setFurniture(String furniture) {
		this.furniture = furniture;
	}

public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

public String getPropId() {
		return propId;
	}

	public void setPropId(String propId) {
		this.propId = propId;
	}

public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

public float getMainRoadDist() {
		return mainRoadDist;
	}

	public void setMainRoadDist(float mainRoadDist) {
		this.mainRoadDist = mainRoadDist;
	}

public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProptype() {
		return proptype;
	}

	public void setProptype(String proptype) {
		this.proptype = proptype;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPropcondition() {
		return propcondition;
	}

	public void setPropcondition(String propcondition) {
		this.propcondition = propcondition;
	}

	public String getBusStandDist() {
		return busStandDist;
	}

	public void setBusStandDist(String busStandDist) {
		this.busStandDist = busStandDist;
	}

	public String getAutoStandDist() {
		return autoStandDist;
	}

	public void setAutoStandDist(String autoStandDist) {
		this.autoStandDist = autoStandDist;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNearbyHosp() {
		return nearbyHosp;
	}

	public void setNearbyHosp(String nearbyHosp) {
		this.nearbyHosp = nearbyHosp;
	}

	public String getNearbyColg() {
		return nearbyColg;
	}

	public void setNearbyColg(String nearbyColg) {
		this.nearbyColg = nearbyColg;
	}

	public String getNearbySchools() {
		return nearbySchools;
	}

	public void setNearbySchools(String nearbySchools) {
		this.nearbySchools = nearbySchools;
	}

	public String getNearbyShops() {
		return nearbyShops;
	}

	public void setNearbyShops(String nearbyShops) {
		this.nearbyShops = nearbyShops;
	}

	public String getNearbyMall() {
		return nearbyMall;
	}

	public void setNearbyMall(String nearbyMall) {
		this.nearbyMall = nearbyMall;
	}

	public String getPurchaseDt() {
		return purchaseDt;
	}

	public void setPurchaseDt(String purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	public String getPropunit() {
		return propunit;
	}

	public void setPropunit(String propunit) {
		this.propunit = propunit;
	}

	public float getPropsize() {
		return propsize;
	}

	public void setPropsize(float propsize) {
		this.propsize = propsize;
	}

	public float getEvalcost() {
		return evalcost;
	}

	public void setEvalcost(float evalcost) {
		this.evalcost = evalcost;
	}
	
public List<Properties> getPropSearch(String prop){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<Properties> lst = new ArrayList<Properties>();
		System.out.println("txt="+prop);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		String qr="select * from properties where propType like '%"+prop+"%' or area like '%"+prop+"%' or city like '%"+prop+"%' or state like '%"+prop+"%' or propcondition like '%"+prop+"%' or addr like '%"+prop+"%' or pincode like '%"+prop+"%'";
		System.out.println(qr);
		rs=st.executeQuery(qr);
		Properties vs;
		 
		while(rs.next()) {
			
			vs= new Properties();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getString("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setPropType(rs.getString("propType"));
			vs.setArea(rs.getString("area"));
			vs.setCity(rs.getString("city"));
			vs.setState(rs.getString("state"));
			vs.setProptype(rs.getString("proptype"));
			 
			vs.setPincode(rs.getString("pincode"));
			vs.setVillage(rs.getString("village"));
			 
			vs.setCountry(rs.getString("country"));
			vs.setPropcondition(rs.getString("propcondition"));
			vs.setBusStandDist(rs.getString("busStandDist"));
			vs.setAutoStandDist(rs.getString("autoStandDist"));
			vs.setNearbyHosp(rs.getString("nearbyHosp"));
			vs.setNearbyShops(rs.getString("nearbyShops"));
			vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
			vs.setNearbySchools(rs.getString("nearBySchools"));
			vs.setNearbyColg(rs.getString("nearByColg"));
			vs.setNearbyMall(rs.getString("shoppingMall"));
			vs.setUserid(rs.getString("userid"));
			vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
			vs.setPropsize(rs.getFloat("propsize"));
			vs.setPropunit(rs.getString("propUnit"));
			vs.setPath(rs.getString("photo"));
			vs.setEvalcost(rs.getFloat("evalCost"));
			vs.setEvalcost1(String.valueOf(rs.getFloat("evalCost")));
			 evalcost2=(long)rs.getFloat("evalCost");
			 vs.setEvalcost2(evalcost2);
			vs.setAddr(rs.getString("addr"));
			vs.setLikes(rs.getInt("likes"));
			vs.setDislikes(rs.getInt("dislikes"));
			
			lst.add(vs);
		}
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return(lst);
	}
public List<Properties> getPropSearch1(String uid){
	
	DBConnector gc = new DBConnector();
	Connection con;
	List<Properties> lst = new ArrayList<Properties>();
	System.out.println("txt="+uid);
	ResultSet rs;
	
	try {
	
	con= gc.connect();
	Statement st=con.createStatement();
	String qr="select * from properties where propId in (select distinct(propId) from userlikings where userid='"+uid.trim()+"')";
	System.out.println(qr);
	rs=st.executeQuery(qr);
	Properties vs;
	 
	while(rs.next()) {
		
		vs= new Properties();
		vs.setUserid(rs.getString("userid"));
		vs.setPropId(rs.getString("propId"));
		vs.setTitle(rs.getString("title"));
		vs.setPropType(rs.getString("propType"));
		vs.setArea(rs.getString("area"));
		vs.setCity(rs.getString("city"));
		vs.setState(rs.getString("state"));
		vs.setProptype(rs.getString("proptype"));
		 
		vs.setPincode(rs.getString("pincode"));
		vs.setVillage(rs.getString("village"));
		 
		vs.setCountry(rs.getString("country"));
		vs.setPropcondition(rs.getString("propcondition"));
		vs.setBusStandDist(rs.getString("busStandDist"));
		vs.setAutoStandDist(rs.getString("autoStandDist"));
		vs.setNearbyHosp(rs.getString("nearbyHosp"));
		vs.setNearbyShops(rs.getString("nearbyShops"));
		vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
		vs.setNearbySchools(rs.getString("nearBySchools"));
		vs.setNearbyColg(rs.getString("nearByColg"));
		vs.setNearbyMall(rs.getString("shoppingMall"));
		vs.setUserid(rs.getString("userid"));
		vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
		vs.setPropsize(rs.getFloat("propsize"));
		vs.setPropunit(rs.getString("propUnit"));
		vs.setPath(rs.getString("photo"));
		vs.setEvalcost(rs.getFloat("evalCost"));
		vs.setAddr(rs.getString("addr"));
		vs.setLikes(rs.getInt("likes"));
		vs.setDislikes(rs.getInt("dislikes"));
		evalcost2=(long)rs.getFloat("evalCost");
		 vs.setEvalcost2(evalcost2);
		lst.add(vs);
	}
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	return(lst);
}
public List<Properties> getPropSearch2(String uid){
	
	DBConnector gc = new DBConnector();
	Connection con;
	List<Properties> lst = new ArrayList<Properties>();
	System.out.println("txt="+uid);
	ResultSet rs;
	
	try {
	
	con= gc.connect();
	Statement st=con.createStatement();
	String qr=" select * from properties where propType in ";
			qr+=" ( select propType from properties where propId in (select distinct(propId) from userlikings where userid='"+uid.trim()+"'))";
			qr+="  and city in  ( select city from properties where propId in (select distinct(propId) from userlikings where userid='"+uid.trim()+"'))";
			qr+="  and area in  ( select area from properties where propId in (select distinct(propId) from userlikings where userid='"+uid.trim()+"'))";
			qr+=" and propId not in (select distinct(propId) from userlikings where userid='"+uid.trim()+"')";
	System.out.println(qr);
	rs=st.executeQuery(qr);
	
	 
	
	Properties vs;
	 
	while(rs.next()) {
		
		vs= new Properties();
		vs.setUserid(rs.getString("userid"));
		vs.setPropId(rs.getString("propId"));
		vs.setTitle(rs.getString("title"));
		vs.setPropType(rs.getString("propType"));
		vs.setArea(rs.getString("area"));
		vs.setCity(rs.getString("city"));
		vs.setState(rs.getString("state"));
		vs.setProptype(rs.getString("proptype"));
		 
		vs.setPincode(rs.getString("pincode"));
		vs.setVillage(rs.getString("village"));
		 
		vs.setCountry(rs.getString("country"));
		vs.setPropcondition(rs.getString("propcondition"));
		vs.setBusStandDist(rs.getString("busStandDist"));
		vs.setAutoStandDist(rs.getString("autoStandDist"));
		vs.setNearbyHosp(rs.getString("nearbyHosp"));
		vs.setNearbyShops(rs.getString("nearbyShops"));
		vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
		vs.setNearbySchools(rs.getString("nearBySchools"));
		vs.setNearbyColg(rs.getString("nearByColg"));
		vs.setNearbyMall(rs.getString("shoppingMall"));
		vs.setUserid(rs.getString("userid"));
		vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
		vs.setPropsize(rs.getFloat("propsize"));
		vs.setPropunit(rs.getString("propUnit"));
		vs.setPath(rs.getString("photo"));
		vs.setEvalcost(rs.getFloat("evalCost"));
		vs.setAddr(rs.getString("addr"));
		vs.setLikes(rs.getInt("likes"));
		vs.setDislikes(rs.getInt("dislikes"));
		evalcost2=(long)rs.getFloat("evalCost");
		 vs.setEvalcost2(evalcost2);
		lst.add(vs);
	}
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	return(lst);
}
public List<Properties> getPropSearch3(String uid){
	
	DBConnector gc = new DBConnector();
	Connection con;
	List<Properties> lst = new ArrayList<Properties>();
	System.out.println("txt="+uid);
	ResultSet rs;
	
	try { 
	con= gc.connect();
	Statement st=con.createStatement();
	String qr=" select * from properties where propId in (select propId from userlikings where userid in "; 
	 qr+="(select u.userid from userlikings u inner join properties p on p.propId=u.propId where u.userid<>'"+uid+"' and  p.propType in ";
	qr+=" (select propType from properties where propId in (select distinct(propId) from userlikings where userid='"+uid+"'))))";
	System.out.println(qr);
	rs=st.executeQuery(qr);
	 
	
	Properties vs;
	 
	while(rs.next()) {
		
		vs= new Properties();
		vs.setUserid(rs.getString("userid"));
		vs.setPropId(rs.getString("propId"));
		vs.setTitle(rs.getString("title"));
		vs.setPropType(rs.getString("propType"));
		vs.setArea(rs.getString("area"));
		vs.setCity(rs.getString("city"));
		vs.setState(rs.getString("state"));
		vs.setProptype(rs.getString("proptype"));
		 
		vs.setPincode(rs.getString("pincode"));
		vs.setVillage(rs.getString("village"));
		 
		vs.setCountry(rs.getString("country"));
		vs.setPropcondition(rs.getString("propcondition"));
		vs.setBusStandDist(rs.getString("busStandDist"));
		vs.setAutoStandDist(rs.getString("autoStandDist"));
		vs.setNearbyHosp(rs.getString("nearbyHosp"));
		vs.setNearbyShops(rs.getString("nearbyShops"));
		vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
		vs.setNearbySchools(rs.getString("nearBySchools"));
		vs.setNearbyColg(rs.getString("nearByColg"));
		vs.setNearbyMall(rs.getString("shoppingMall"));
		vs.setUserid(rs.getString("userid"));
		vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
		vs.setPropsize(rs.getFloat("propsize"));
		vs.setPropunit(rs.getString("propUnit"));
		vs.setPath(rs.getString("photo"));
		vs.setEvalcost(rs.getFloat("evalCost"));
		vs.setAddr(rs.getString("addr"));
		vs.setLikes(rs.getInt("likes"));
		vs.setDislikes(rs.getInt("dislikes"));
		evalcost2=(long)rs.getFloat("evalCost");
		 vs.setEvalcost2(evalcost2);
		lst.add(vs);
	}
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	return(lst);
}
 
public List<Properties> getMyPropsReport(String userid1){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<Properties> lst = new ArrayList<Properties>();
		System.out.println("userid="+userid1);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from properties where userid='"+userid1+"'");
		Properties vs;
		 
		while(rs.next()) {
			
			vs= new Properties();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getString("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setPropType(rs.getString("propType"));
			vs.setArea(rs.getString("area"));
			vs.setCity(rs.getString("city"));
			vs.setState(rs.getString("state"));
			vs.setProptype(rs.getString("proptype"));
			 
			vs.setPincode(rs.getString("pincode"));
			vs.setVillage(rs.getString("village"));
			 
			vs.setCountry(rs.getString("country"));
			vs.setPropcondition(rs.getString("propcondition"));
			vs.setBusStandDist(rs.getString("busStandDist"));
			vs.setAutoStandDist(rs.getString("autoStandDist"));
			vs.setNearbyHosp(rs.getString("nearbyHosp"));
			vs.setNearbyShops(rs.getString("nearbyShops"));
			vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
			vs.setNearbySchools(rs.getString("nearBySchools"));
			vs.setNearbyColg(rs.getString("nearByColg"));
			vs.setNearbyMall(rs.getString("shoppingMall"));
			vs.setUserid(rs.getString("userid"));
			vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
			vs.setPropsize(rs.getFloat("propsize"));
			vs.setPropunit(rs.getString("propUnit"));
			vs.setPath(rs.getString("photo"));
			vs.setEvalcost(rs.getFloat("evalCost"));
			evalcost2=(long)rs.getFloat("evalCost");
			 vs.setEvalcost2(evalcost2);
			vs.setAddr(rs.getString("addr"));
			lst.add(vs);
		}
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return(lst);
	}
	
public String addNewPropertyDetails()
{
	DBConnector gc = new DBConnector();
	int y=0;
	
	Connection con;
	String st="";
	try {
	con=gc.connect();
	PreparedStatement pst;
	JavaFuns jf=new JavaFuns();
	pst=con.prepareStatement("insert into propertydetails values(?,?,?,?,?,?,?,?,?);");
	 
	pst.setInt(1,Integer.parseInt(did.trim()));
	pst.setInt(2,Integer.parseInt(propId.trim()));
	pst.setString(3,userid);
	pst.setInt(4,Integer.parseInt(rooms.trim()));
	pst.setString(5,proptype);
	pst.setInt(6,Integer.parseInt(floorNo.trim()));
	pst.setString(7,city);
	pst.setString(8,proptype);
	pst.setString(9,furniture); 
	int x=pst.executeUpdate();
	
	if(x>0) {
		st="success";
		 
	}
	else
		st="failure"; 
		
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	return st;
	
	
}

	public String addNewProperty()
	{
		DBConnector gc = new DBConnector();
		int y=0;
		
		Connection con;
		String st="";
		try {
		con=gc.connect();
		PreparedStatement pst;
		JavaFuns jf=new JavaFuns();
		Vector v=jf.getValue("select (ifnull(max(propId),1000)+1) as mxid from properties",1);
		int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
		pst=con.prepareStatement("insert into properties values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		System.out.println("bus="+busStandDist);
		propId=String.valueOf(mxid);
		pst.setInt(1,mxid);
		pst.setString(2,title);
		pst.setString(3,proptype);
		pst.setString(4,area);
		pst.setString(5,city);
		pst.setString(6,village);
		pst.setString(7,state);
		pst.setString(8,"India");
		pst.setString(9,pincode);
		pst.setString(10,propcondition);
		pst.setString(11,busStandDist);
		pst.setString(12,autoStandDist);
		if(nearbyHosp==null)
			nearbyHosp="No";
		else
			nearbyHosp="Yes";	
		if(nearbyShops==null)
			nearbyShops="No";
		else
			nearbyShops="Yes";
		if(nearbySchools==null)
			nearbySchools="No";
		else
			nearbySchools="Yes";
		if(nearbyColg==null)
			nearbyColg="No";
		else
			nearbyColg="Yes";
		if(nearbyMall==null)
			nearbyMall="No";
		else
			nearbyMall="Yes";
		pst.setString(13,nearbyHosp);
		pst.setString(14,nearbyShops);
		pst.setFloat(15,mainRoadDist);
		pst.setString(16,nearbySchools);
		pst.setString(17,nearbyColg);
		pst.setString(18,nearbyMall);
		pst.setString(19,userid);
		pst.setString(20,purchaseDt);
		pst.setFloat(21,propsize);
		pst.setString(22,propunit);
		pst.setString(23,path);
		pst.setFloat(24,0);
		pst.setString(25,addr);
		pst.setInt(26,0);
		pst.setInt(27,0);
		pst.setInt(28,0);
		int x=pst.executeUpdate();
		
		if(x>0) {
			st="success";
			 
		}
		else
			st="failure"; 
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return st;
		
		
	}
	 
}
