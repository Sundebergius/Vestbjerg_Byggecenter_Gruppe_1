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
	private JTextField textFieldSubtotal;
	private JTextField textFieldIndbetalt;
	private boolean validTransaction;
	private double subtotal;
	private double indbetalt;
	private JLabel lblOutput;
	
	private SaleController saleController;

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
	}

	private boolean checkValidTransaction() {
		subtotal = getSubtotal();
		indbetalt = Double.parseDouble(textFieldIndbetalt.getText());
		validTransaction = false;
		if (indbetalt > subtotal) {
			validTransaction = true;
			lblOutput.setText("Betalingen er gennemf�rt. Kunden skal havde " + customerRefund() + " DKK tilbage. ");
		} else if (indbetalt == subtotal) {
			validTransaction = true;
			lblOutput.setText("Betalingen er gennemf�rt. ");
		} else if (indbetalt < subtotal) {
			lblOutput.setText(
					"Betalingen er ikke gennemf�rt. Der skal tilf�jes " + remainingTransaction() + " DKK til k�bet. ");
		}
		return validTransaction;
	}

	private double remainingTransaction() {
		this.subtotal = subtotal - indbetalt;
		return this.subtotal;
	}

	private double customerRefund() {
		this.indbetalt = indbetalt - subtotal;
		return this.indbetalt;
	}

	private double getSubtotal() {
		double totalPrice;
		totalPrice = saleController.getCurrentSale().calculateTotalPrice();
		//totalPrice = Double.parseDouble(textFieldSubtotal.setText(totalPrice));
		String subtotalPrice = String.valueOf(totalPrice);
		textFieldSubtotal.setText(subtotalPrice);
		return totalPrice;
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
				textFieldSubtotal = new JTextField();
				textFieldSubtotal.setEditable(false);
				textFieldSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_textFieldSubtotal = new GridBagConstraints();
				gbc_textFieldSubtotal.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldSubtotal.fill = GridBagConstraints.BOTH;
				gbc_textFieldSubtotal.gridx = 3;
				gbc_textFieldSubtotal.gridy = 2;
				panel.add(textFieldSubtotal, gbc_textFieldSubtotal);
				textFieldSubtotal.setColumns(10);
			}
			{
				JLabel lblIndbetalt = new JLabel("Indbetalt");
				GridBagConstraints gbc_lblIndbetalt = new GridBagConstraints();
				gbc_lblIndbetalt.insets = new Insets(0, 0, 5, 5);
				gbc_lblIndbetalt.gridx = 1;
				gbc_lblIndbetalt.gridy = 4;
				panel.add(lblIndbetalt, gbc_lblIndbetalt);
			}
			{
				textFieldIndbetalt = new JTextField();
				GridBagConstraints gbc_textFieldIndbetalt = new GridBagConstraints();
				gbc_textFieldIndbetalt.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldIndbetalt.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldIndbetalt.gridx = 3;
				gbc_textFieldIndbetalt.gridy = 4;
				panel.add(textFieldIndbetalt, gbc_textFieldIndbetalt);
				textFieldIndbetalt.setColumns(10);
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
						checkValidTransaction();
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
