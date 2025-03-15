<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint" %>
<%@ page import="net.sf.jasperreports.engine.JasperExportManager" %>
<%@ page import="net.sf.jasperreports.engine.JasperFillManager" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/g_stock", "root", "");
			
			String report = "C:\\Users\\kawtar\\Documents\\eclpse\\gStoc\\src\\main\\webapp\\articles_stock.jrxml";
		
			
			JasperReport jasperreport = JasperCompileManager
					.compileReport(report);
			
			Map<String, Object> data = new HashMap<String, Object>();
			
			
			JasperPrint jp = JasperFillManager.fillReport(jasperreport,
					data, conn);
		
			JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (Exception e) {
			out.println(e);
		}
	%>

