<%@page import="java.io.*,sun.misc.*"%>
<%@page import="com.wetogether.common.hibernate.pojos.*"%>
<%@page import="com.wetogether.common.util.*"%>


<%
String pic=request.getParameter("pic");
String pic1=request.getParameter("pic1");
String pic2=request.getParameter("pic2");
String pic3=request.getParameter("pic3");
User sessionUser = (User)request.getSession().getAttribute(CodeCst.SESSION_USER_NAME);

//一份存本地一份存服务器
String basePath = request.getSession().getServletContext().getRealPath("/")+"\\web\\img\\photo\\user";
String basePathLocal = "A:\\Workspaces\\MyEclipse 8.6\\WeTogether\\WebContent\\web\\img\\photo\\user";
//原图
String pathName0 = basePath+sessionUser.getUserId()+"_0.png";
String localPath0 = basePathLocal+sessionUser.getUserId()+"_0.png";
File file = new File(pathName0);
File filelocal = new File(localPath0);
FileOutputStream fout = null;
fout = new FileOutputStream(file);
fout.write(new BASE64Decoder().decodeBuffer(pic));
fout.close();
fout = new FileOutputStream(filelocal);
fout.write(new BASE64Decoder().decodeBuffer(pic));
fout.close();


//图1

String pathName1 = basePath+sessionUser.getUserId()+"_1.png";
String localPath1 = basePathLocal+sessionUser.getUserId()+"_1.png";
File file1 = new File(pathName1);
File filelocal1 = new File(localPath1);
FileOutputStream fout1 = null;
fout1 = new FileOutputStream(file1);
fout1.write(new BASE64Decoder().decodeBuffer(pic1));
fout1.close();
fout1 = new FileOutputStream(filelocal1);
fout1.write(new BASE64Decoder().decodeBuffer(pic1));
fout1.close();


//图2
String pathName2 = basePath+sessionUser.getUserId()+"_2.png";
String localPath2 = basePathLocal+sessionUser.getUserId()+"_2.png";
File file2 = new File(pathName2);
File filelocal2 = new File(localPath2);
FileOutputStream fout2 = null;
fout2 = new FileOutputStream(file2);
fout2.write(new BASE64Decoder().decodeBuffer(pic2));
fout2.close();
fout2 = new FileOutputStream(filelocal2);
fout2.write(new BASE64Decoder().decodeBuffer(pic2));
fout2.close();

//图3
String pathName3 = basePath+sessionUser.getUserId()+"_3.png";
String localPath3 = basePathLocal+sessionUser.getUserId()+"_3.png";
File file3 = new File(pathName3);
File filelocal3 = new File(localPath3);
FileOutputStream fout3 = null;
fout3 = new FileOutputStream(file3);
fout3.write(new BASE64Decoder().decodeBuffer(pic3));
fout3.close();
fout3 = new FileOutputStream(filelocal3);
fout3.write(new BASE64Decoder().decodeBuffer(pic3));
fout3.close();

out.println("{\"status\":1}");
%>