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
import java.awt.Font;

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
	
	/**
	 * Create the dialog.
	 */
	public RefundPaymentDialog(SaleController saleController) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		createGUI();
		this.saleController = saleController;
		calRefund();
	}

	/*
	 * Method to be run within the okButton method. 
	 * opens the receipt dialog window, disposes the current window. 
	 */
	private void okButtonFeature() {
		setVisible(false);

		SaleReceiptDialog receiptDialog = new SaleReceiptDialog(saleController);
		receiptDialog.setVisible(true);
		dispose();
	}

	/**
	 * The method that calculates refund If tolalRefund is higher than zero
	 * totalRefund is set in the refund text field
	 */
	private void calRefund() {
		totalRefund = saleController.getCurrentSale().getRemainingPayment();
		totalRefund = Math.abs(totalRefund);
		String totalRefundString = String.format("%.2f", totalRefund);
		if (totalRefund > 0) {
			refundTextField.setText(totalRefundString);
		}
	}
	
	/**
	 * The done button When pressed the receipt window opens and the payment windows
	 * is closed
	 */
	private void okButton() {
		okButtonFeature();

	}

	private void createGUI() {
		setTitle("Retur ");
		setModal(true);
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
				lblRefundHeadline.setFont(new Font("Tahoma", Font.PLAIN, 25));
				panel.add(lblRefundHeadline);
			}
		}
		{
			JLabel lblRefundAmount = new JLabel("Retur beløb: ");
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
						"Bekræft med Færdig-knappen når det overskydende beløb er givet tilbage. ");
				panel.add(lblConfirmation);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton doneButton = new JButton("Færdig");
				doneButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okButton();
					}
				});
				doneButton.setActionCommand("OK");
				buttonPane.add(doneButton);
				getRootPane().setDefaultButton(doneButton);
			}
		}
	}
}
