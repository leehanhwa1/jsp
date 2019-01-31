<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null; // �������� select�� ��쿡 �ʿ���.
	
	try {
		
		Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
		
		
		// 1. ����̹� �ε� => ��� ����
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
	
		// 2. DB�� ����(Connection��ü ����)
		//String url 		= "jdbc:oracle:thin:@localhost:1521/xe";
		//String userId 	= "PC09_PC";
		//String password = "java";
		//conn = DriverManager.getConnection(url, userId, password);
		
		conn = ds.getConnection();
		
		// 3. Statement��ü ���� => Connection��ü�� �̿��Ѵ�.
		stmt = conn.createStatement();
	
		// 4. SQL���� Statement��ü�� �̿��Ͽ� �����ϰ� �������� ResultSet��ü�� �����Ѵ�.
		String sql = "select * from lprod"; // ������ SQL��
		rs = stmt.executeQuery(sql); // SQL���� select�� ��쿡�� executeQuery()�޼��带 ����ϰ�
									 // insert, update, delete�� ��쿡�� executeUpdate()�޼��� �����.
	
		// 5. ResultSet��ü�� ����Ǿ� �ִ� �ڷḦ �ݺ����� next()�޼��带 �̿��Ͽ� ���ʷ� �о�� ó���Ѵ�.
		System.out.println("������ ������ : " + sql);
		System.out.println("---������ ���� ���---");
	
		// rs.next() => ResultSet��ü�� �����͸� ����Ű�� �����͸� ���� ���ڵ�� �̵���Ű��
		// �װ��� �ڷᰡ ������ true, ������ false�� ��ȯ�Ѵ�.
		while (rs.next()) {
			// �÷��� �ڷḦ �������� ���
			// ��� 1) rs.get�ڷ����̸�("�÷���")
			// ��� 2) rs.get�ڷ����̸�(�÷���ȣ) => �÷���ȣ�� 1���� ����
			out.write("lprod_id : " + rs.getInt("lprod_id")+"<br>");
			out.write("lprod_gu : " + rs.getString("lprod_gu")+"<br>");
			out.write("lprod_nm : " + rs.getString("lprod_nm")+"<br>");
			out.write("---------------------------"+"<br>");
		}
	
		System.out.println("��� ��");
	} catch (Exception e) {
		e.printStackTrace();
	} /*catch (ClassNotFoundException e) {
		e.printStackTrace();
	}*/ finally {
		// 6. ����(����ߴ� �ڿ��� ��� �ݳ��Ѵ�.)
		if (rs != null)	try {rs.close();} catch (SQLException e2) {}
		if (stmt != null) try {stmt.close();} catch (SQLException e2) {}
		if (conn != null) try {conn.close();} catch (SQLException e2) {}
	}
	// localhost/connection/jdbc.jsp
%>

</body>
</html>