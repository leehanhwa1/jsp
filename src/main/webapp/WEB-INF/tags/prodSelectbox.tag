<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<%@ attribute name="prod_lgu" type="java.lang.String" required="true" %>

prod_lgu : ${prod_lgu } <br>

<%
	
	String prod_lgu = (String)jspContext.getAttribute("prod_lgu");
	
	final String driver = "oracle.jdbc.driver.OracleDriver";
	final String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	final String user	= "PC09_PC";
	final String pass	= "java";
	
	Connection conn 	  = null;
	PreparedStatement pst = null;
	ResultSet rs 		  = null;
	
	
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		pst  = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu = ? ");
		pst.setString(1, prod_lgu);

		
		rs = pst.executeQuery();


		out.write("<select>");
		while (rs.next()) 
			out.write("<option value = \"" + rs.getString("prod_id") + "prod_name : \">" + rs.getString("prod_name") + "</option>");
		out.write("</select>");
		

		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
%>