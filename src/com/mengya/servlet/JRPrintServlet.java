package com.mengya.servlet;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mengya.JRDataSource.PersonDataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class JRPrintServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = this.getServletConfig().getServletContext();
		File reportFile = new File(context.getRealPath("/jasper/preson.jasper"));
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("year", "2009");
		parameters.put("unit_mc", "武汉XX科技有限公司");
		JasperPrint jasperPrint = null;
		try {
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
			jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, new PersonDataSource());
		} catch (JRException e) {
			e.printStackTrace();
		}
		if (jasperPrint != null) {
			response.setContentType("application/octet-stream");
			ServletOutputStream ouputStream = response.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
			oos.writeObject(jasperPrint);
			oos.flush();
			oos.close();
			ouputStream.flush();
			ouputStream.close();
		}
	}

}
