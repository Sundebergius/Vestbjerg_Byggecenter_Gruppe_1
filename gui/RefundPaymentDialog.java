package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import control.SaleController;
import gui.PaySaleDialog;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.PaySaleDialog;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RefundPaymentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private PaySaleDialog calculateRefund;
	private double totalRefund;
	private JTextField refundTextField;
	private SaleController saleController;
	private PaySaleDialog paySaleDialog;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RefundPaymentDialog dialog = new RefundPaymentDialog(new SaleController());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cancelButton() {
		dispose();
	}

	private void okButton() {		
		setVisible(false);
		
		SaleReceiptDialog receiptDialog = new SaleReceiptDialog(saleController);
		receiptDialog.setVisible(true);
		

	}

	private void calRefund() {
		totalRefund = saleController.getCurrentSale().getRemainingPayment();
		totalRefund = Math.abs(totalRefund);
		if (totalRefund > 0) {
			refundTextField.setText("" + totalRefund);
		}
	}

	private void createGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 271, 149, 0 };
		gbl_contentPanel.rowHeights = new int[] { 24, 31, 37, 81, 40, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.anchor = GridBagConstraints.NORTH;
			gbc_panel.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridwidth = 2;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblRefundHeadline = new JLabel("Kunden skal have penge tilbage");
				panel.add(lblRefundHeadline);
			}
		}
		{
			JLabel lblRefundAmount = new JLabel("Bel\u00F8bet som skal gives retur til kunden: ");
			lblRefundAmount.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblRefundAmount = new GridBagConstraints();
			gbc_lblRefundAmount.anchor = GridBagConstraints.EAST;
			gbc_lblRefundAmount.insets = new Insets(0, 0, 5, 5);
			gbc_lblRefundAmount.gridx = 0;
			gbc_lblRefundAmount.gridy = 2;
			contentPanel.add(lblRefundAmount, gbc_lblRefundAmount);
		}
		{
			refundTextField = new JTextField();
			refundTextField.setEditable(false);
			GridBagConstraints gbc_refundTextField = new GridBagConstraints();
			gbc_refundTextField.insets = new Insets(0, 0, 5, 0);
			gbc_refundTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_refundTextField.gridx = 1;
			gbc_refundTextField.gridy = 2;
			contentPanel.add(refundTextField, gbc_refundTextField);
			refundTextField.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.fill = GridBagConstraints.BOTH;
			gbc_panel.gridwidth = 2;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 4;
			contentPanel.add(panel, gbc_panel);
			{
				JLabel lblConfirmation = new JLabel(
						"Bekr\u00E6ft med OK-knappen n\u00E5r det overskydende bel\u00F8b er givet tilbage. ");
				panel.add(lblConfirmation);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButton();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						cancelButton();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/*
	 * public void calRefund() { calculateRefund = new PaymentTransaction();
	 * totalRefund = calculateRefund.customerRefund();
	 * txtRefund.setText(totalRefund); }
	 */

	/**
	 * Create the dialog.
	 */
	public RefundPaymentDialog(SaleController saleController) {
		createGUI();
		this.saleController = saleController;
		calRefund();
	}

}
