package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.PaymentTransaction;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class RefundWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PaymentTransaction calculateRefund;
	private JTextPane txtRefund;
	private double totalRefund;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RefundWindow dialog = new RefundWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public void calRefund()
	{
		calculateRefund = new PaymentTransaction();
		totalRefund = calculateRefund.customerRefund();
		txtRefund.setText(totalRefund);
	}
	*/

	/**
	 * Create the dialog.
	 */
	public RefundWindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("127px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("24px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "2, 2, 3, 1, fill, top");
			{
				JLabel lblRefundHeadline = new JLabel("Kunden skal have penge tilbage");
				panel.add(lblRefundHeadline);
			}
		}
		{
			JLabel lblRefundAmount = new JLabel("Bel\u00F8bet som skal gives retur til kunden: ");
			lblRefundAmount.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblRefundAmount, "2, 6");
		}
		{
			txtRefund = new JTextPane();
			contentPanel.add(txtRefund, "3, 6, 2, 1, fill, fill");
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "2, 14, 3, 1, fill, fill");
			{
				JLabel lblConfirmation = new JLabel("Bekr\u00E6ft med OK-knappen n\u00E5r det overskydende bel\u00F8b er givet tilbage. ");
				panel.add(lblConfirmation);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
