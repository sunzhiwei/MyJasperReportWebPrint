import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class JRPrinterApplet extends javax.swing.JApplet {
	private URL url = null;
	public void init() {
		String strUrl = getParameter("REPORT_URL");
		if (strUrl != null) {
			try {
				url = new URL(getCodeBase(), strUrl);// 从获得html参数中获得报表URL
				// System.out.println("url=" + url.toURI());//要是servlet的路径
			} catch (Exception e) {
				StringWriter swriter = new StringWriter();
				PrintWriter pwriter = new PrintWriter(swriter);
				e.printStackTrace(pwriter);
				JOptionPane.showMessageDialog(this, swriter.toString());
			}
		} else {
			JOptionPane.showMessageDialog(this, "Source URL not specified");
		}
	}
	
	public void start() {
		if (url != null) {
			try {
				Object obj = JRLoader.loadObject(url);// 发送对象请求，获得JasperPrint对象
				JasperPrintManager.printReport((JasperPrint) obj, true);// 调用方法打印所获得的JasperPrint对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
