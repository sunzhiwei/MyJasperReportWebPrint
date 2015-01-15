import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.util.JRLoader;

public class JRViewApplet extends javax.swing.JApplet {
	private URL url = null;

	private JasperPrint jasperPrint = null;

	public JRViewApplet() {

	}

	public void init() {
		String strUrl = getParameter("REPORT_URL");
		if (strUrl != null) {
			try {
				url = new URL(getCodeBase(), strUrl);
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

	@Override
	public void start() {
		// initComponents();
		if (url != null) {
			try {
				if (jasperPrint == null) {
					jasperPrint = (JasperPrint) JRLoader.loadObject(url);
				}
				if (jasperPrint != null) {
					ViewerFrame viewerFrame = new ViewerFrame(this
							.getAppletContext(), jasperPrint);
					viewerFrame.show();
				} else {
					JOptionPane.showMessageDialog(this, "空报表！");
				}
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

	private void initComponents() {
		pnlMain = new javax.swing.JPanel();
		btnPrint = new javax.swing.JButton();
		btnView = new javax.swing.JButton();

		// btnPrint.setText("打印报表");
		// btnPrint.addActionListener(new java.awt.event.ActionListener() {
		// public void actionPerformed(java.awt.event.ActionEvent evt) {
		// btnPrintActionPerformed(evt);
		// }
		// });

		// pnlMain.add(btnPrint);

		btnView.setText("预览报表");
		btnView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnViewActionPerformed(evt);
			}
		});

		pnlMain.add(btnView);

		getContentPane().add(pnlMain, java.awt.BorderLayout.WEST);

	}

	/**
	 * 预览报表
	 * 
	 * @param evt
	 */
	protected void btnViewActionPerformed(java.awt.event.ActionEvent evt) {
		if (url != null) {
			try {
				if (jasperPrint == null) {
					jasperPrint = (JasperPrint) JRLoader.loadObject(url);
				}
				if (jasperPrint != null) {
					ViewerFrame viewerFrame = new ViewerFrame(this
							.getAppletContext(), jasperPrint);
					viewerFrame.show();
				} else {
					JOptionPane.showMessageDialog(this, "空报表！");
				}
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

	/**
	 * 打印报表
	 * 
	 * @param evt
	 */
	protected void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {
		if (url != null) {
			if (jasperPrint == null) {
				try {
					jasperPrint = (JasperPrint) JRLoader.loadObject(url);
				} catch (Exception e) {
					StringWriter swriter = new StringWriter();
					PrintWriter pwriter = new PrintWriter(swriter);
					e.printStackTrace(pwriter);
					JOptionPane.showMessageDialog(this, swriter.toString());
				}
			}
			if (jasperPrint != null) {
				final JasperPrint print = jasperPrint;

				Thread thread = new Thread(new Runnable() {
					public void run() {
						try {
							JasperPrintManager.printReport(print, true);
						} catch (Exception e) {
							StringWriter swriter = new StringWriter();
							PrintWriter pwriter = new PrintWriter(swriter);
							e.printStackTrace(pwriter);
							JOptionPane.showMessageDialog(null, swriter
									.toString());
						}
					}
				});

				thread.start();
			} else {
				JOptionPane.showMessageDialog(this, "空报表！");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Source URL not specified");
		}
	}

	private javax.swing.JPanel pnlMain;

	private javax.swing.JButton btnView;

	private javax.swing.JButton btnPrint;

}
