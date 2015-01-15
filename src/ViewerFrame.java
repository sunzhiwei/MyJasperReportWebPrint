import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

import java.awt.BorderLayout;
import java.applet.AppletContext;
import java.net.*;
import javax.swing.JOptionPane;

public class ViewerFrame extends javax.swing.JFrame implements
		JRHyperlinkListener {
	private AppletContext appletContext = null;

	public ViewerFrame(AppletContext appletContext, JasperPrint jasperPrint)
			throws JRException {
		initComponents();

		this.appletContext = appletContext;

		JRViewerPlus viewer = new JRViewerPlus(jasperPrint);
		viewer.addHyperlinkListener(this);
		this.pnlMain.add(viewer, BorderLayout.CENTER);
	}
	public void gotoHyperlink(JRPrintHyperlink hyperlink) {
		switch (hyperlink.getHyperlinkType()) {
		case JRHyperlink.HYPERLINK_TYPE_REFERENCE: {
			try {
				this.appletContext.showDocument(new URL(hyperlink
						.getHyperlinkReference()), "_blank");
			} catch (MalformedURLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			break;
		}
		case JRHyperlink.HYPERLINK_TYPE_LOCAL_ANCHOR:
		case JRHyperlink.HYPERLINK_TYPE_LOCAL_PAGE: {
			break;
		}
		case JRHyperlink.HYPERLINK_TYPE_REMOTE_ANCHOR:
		case JRHyperlink.HYPERLINK_TYPE_REMOTE_PAGE: {
			JOptionPane
					.showMessageDialog(this,
							"Implement your own JRHyperlinkListener to manage this type of event.");
			break;
		}
		case JRHyperlink.HYPERLINK_TYPE_NONE:
		default: {
			break;
		}
		}
	}

	private void initComponents() {
		pnlMain = new javax.swing.JPanel();

		setTitle("JasperViewer");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		pnlMain.setLayout(new java.awt.BorderLayout());

		getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

		pack();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setSize(new java.awt.Dimension(400, 300));
		setLocation((screenSize.width - 400) / 2, (screenSize.height - 300) / 2);
	}

	private javax.swing.JPanel pnlMain;

}
