package gui;

import java.awt.BorderLayout;
import control.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.SaleLineItem;

public class PaySaleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField subtotalTextField;
	private JTextField payAmountTextField;
	private JLabel lblOutput;

	
	private SaleController saleController;
	private JLabel lblIndbetalt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PaySaleDialog dialog = new PaySaleDialog(new SaleController());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PaySaleDialog(SaleController saleController) {
		this.saleController = saleController;
		createGUI();		
		showRemainingPayment();
	}


	
	public void showRemainingPayment() {
		double remainingPayment = saleController.getCurrentSale().getRemainingPayment();
		String remainingPaymentString = String.format("%.2f", remainingPayment);
		subtotalTextField.setText(remainingPaymentString);
	}
	
	private void payButton() {
		
		double amountPayed = Double.parseDouble(payAmountTextField.getText());
		double remainingPayment = saleController.pay(amountPayed);
		
		if(remainingPayment > 0) {
			showRemainingPayment();
			
			String amountPayedString = String.format("%.2f", amountPayed);
			String remainingPaymentString = String.format("%.2f", saleController.getCurrentSale().getRemainingPayment());			
			
			lblOutput.setText(amountPayedString + " DKK blev tilføjet til salget, der mangler stadig " + remainingPaymentString + " DKK");
			
		}else if(remainingPayment == 0) {
			//open receipt dialog box
			System.out.println("Transaction is complete");
			dispose();
			
		}else if(remainingPayment < 0){
			RefundPaymentDialog refundPaymentDialog = new RefundPaymentDialog(saleController);
			refundPaymentDialog.setVisible(true);
		}
		
	
	}
	
	private void createGUI() {

		setTitle("Betalings vindue");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 20, 0, 20, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblSubtotal = new JLabel("Subtotal");
				GridBagConstraints gbc_lblSubtotal = new GridBagConstraints();
				gbc_lblSubtotal.fill = GridBagConstraints.VERTICAL;
				gbc_lblSubtotal.insets = new Insets(0, 0, 5, 5);
				gbc_lblSubtotal.gridx = 1;
				gbc_lblSubtotal.gridy = 2;
				panel.add(lblSubtotal, gbc_lblSubtotal);
			}
			{
				subtotalTextField = new JTextField();
				subtotalTextField.setEditable(false);
				subtotalTextField.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_subtotalTextField = new GridBagConstraints();
				gbc_subtotalTextField.insets = new Insets(0, 0, 5, 5);
				gbc_subtotalTextField.fill = GridBagConstraints.BOTH;
				gbc_subtotalTextField.gridx = 3;
				gbc_subtotalTextField.gridy = 2;
				panel.add(subtotalTextField, gbc_subtotalTextField);
				subtotalTextField.setColumns(10);
			}
			{
				lblIndbetalt = new JLabel("Indbetalt");
				GridBagConstraints gbc_lblIndbetalt = new GridBagConstraints();
				gbc_lblIndbetalt.insets = new Insets(0, 0, 5, 5);
				gbc_lblIndbetalt.gridx = 1;
				gbc_lblIndbetalt.gridy = 4;
				panel.add(lblIndbetalt, gbc_lblIndbetalt);
			}
			{
				payAmountTextField = new JTextField();
				GridBagConstraints gbc_payAmountTextField = new GridBagConstraints();
				gbc_payAmountTextField.insets = new Insets(0, 0, 5, 5);
				gbc_payAmountTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_payAmountTextField.gridx = 3;
				gbc_payAmountTextField.gridy = 4;
				panel.add(payAmountTextField, gbc_payAmountTextField);
				payAmountTextField.setColumns(10);
			}
			{
				lblOutput = new JLabel("Skriv den indbetalte sum foroven");
				GridBagConstraints gbc_lblOutput = new GridBagConstraints();
				gbc_lblOutput.gridwidth = 4;
				gbc_lblOutput.insets = new Insets(0, 0, 0, 5);
				gbc_lblOutput.gridx = 0;
				gbc_lblOutput.gridy = 6;
				panel.add(lblOutput, gbc_lblOutput);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton payButton = new JButton("Indbetal");
				payButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						payButton();
					}
				});
				payButton.setActionCommand("OK");
				buttonPane.add(payButton);
				getRootPane().setDefaultButton(payButton);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

				/**
				 * Create the dialog.
				 */

			}
		}
	}

}
