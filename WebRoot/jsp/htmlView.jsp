<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.util.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="net.sf.jasperreports.j2ee.servlets.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.mengya.JRDataSource.PersonDataSource" %>
<%
	File reportFile = new File(application.getRealPath("/jasper/preson.jasper"));
    if (!reportFile.exists()){
		throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
	}
	JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());

	Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "武汉XX科技有限公司");
				
	JasperPrint jasperPrint = 
		JasperFillManager.fillReport(
			jasperReport, 
			parameters, 
			new PersonDataSource()
			);
				
	JRHtmlExporter exporter = new JRHtmlExporter();

	session.setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);
	exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, out);
	exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, "../image?image=");
	
	exporter.exportReport();
%>