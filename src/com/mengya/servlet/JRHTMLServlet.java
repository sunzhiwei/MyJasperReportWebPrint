package com.mengya.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;

import com.mengya.JRDataSource.PersonDataSource;

public class JRHTMLServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = this.getServletConfig().getServletContext();
		File jasperFile = new File(context.getRealPath("/jasper/preson.jasper"));
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "武汉XX科技有限公司");
		JasperPrint jasperPrint = null;
		response.setCharacterEncoding("utf-8");
		try {
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(jasperFile);
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					new PersonDataSource());
		} catch (JRException e) {
			e.printStackTrace();
		}
		if(null != jasperPrint){
			JRHtmlExporter exporter = new JRHtmlExporter();
			request.getSession().setAttribute(ImageServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE,jasperPrint);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
			exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,"image?image=");
			try {
				exporter.exportReport();
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}

}
