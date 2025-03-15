<%@page import="java.io.OutputStream"%>
<%@page  contentType="application/pdf" %>

<%@page trimDirectiveWhitespaces="true"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>

<head>

<title>Stocks Rapport</title>
</head>
<body>
	<%
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/g_stock", "root", "");
			JasperReport jasperReport = null;
			String report = "C:\\Users\\kawtar\\Documents\\eclpse\\gStoc\\src\\main\\webapp\\articles_stock.jrxml";
            
			
			JasperReport jasperreport = JasperCompileManager
					.compileReport(report);
			
			Map<String, Object> data = new HashMap<String, Object>();
			
			//data.put("Image", this.getServletContext().getRealPath("/")+"/images/asteroids.jpg");
			//data.put("Image", this.getServletContext().getRealPath("/")+"/images/green-goblin.png");
			
			JasperPrint jp = JasperFillManager.fillReport(jasperreport,
					data, conn);
			
			JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (Exception e) {
			out.println(e);
		}

	%>
</body>