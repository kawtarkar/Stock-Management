package Beans;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@ManagedBean
@RequestScoped
public class ReportBean {
    public void generateReport() throws IOException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/g_stock", "root", "");

            String report = "C:\\Users\\kawtar\\Documents\\eclpse\\gStoc\\src\\main\\webapp\\articles_stock.jrxml";

            JasperReport jasperreport = JasperCompileManager.compileReport(report);

            Map<String, Object> data = new HashMap<String, Object>();

            JasperPrint jp = JasperFillManager.fillReport(jasperreport, data, conn);

            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
                    .getResponse();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment;filename=report.pdf");

            OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, outStream);

            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}