import javax.swing.JButton;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class JRViewerPlus extends JRViewer {

	protected JButton btnPlus = new javax.swing.JButton();

	public JRViewerPlus(JasperPrint jrPrint) throws JRException {
		super(jrPrint);

		tlbToolBar.remove(btnSave);
		tlbToolBar.remove(btnReload);

		btnPlus = new javax.swing.JButton();
		btnPlus.setToolTipText("Plus...");
		btnPlus.setText("Plus...");
		btnPlus.setPreferredSize(new java.awt.Dimension(80, 23));
		btnPlus.setMaximumSize(new java.awt.Dimension(80, 23));
		btnPlus.setMinimumSize(new java.awt.Dimension(80, 23));
		btnPlus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPlusActionPerformed(evt);
			}
		});
		tlbToolBar.add(btnPlus, 0);
	}

	protected void setZooms() {
		this.zooms = new int[] { 33, 66, 100, 133, 166, 200, 233 };
		this.defaultZoomIndex = 2;
	}

	protected void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane
				.showMessageDialog(
						this,
						"I just wanted to let you know that you can extend the JRViewer to customize it.\n The button you have pushed was added this way.");
	}

}
