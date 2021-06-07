package gui;

import java.awt.BorderLayout;
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
import gui.PaymentTransactionError;

public class PaymentTransaction extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldSubtotal;
	private JTextField textFieldIndbetalt;
	private boolean validTransaction;
	private double subtotal;
	private double indbetalt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PaymentTransaction dialog = new PaymentTransaction();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkValidTransaction()
	{
		validTransaction = false;
		if(subtotal >= indbetalt)
		{
			validTransaction = true;
		}
		else
		{
			
		}
		return validTransaction;
	}
	
	public void transaction()
	{
		checkValidTransaction();
	}

	/**
	 * Create the dialog.
	 */
	public PaymentTransaction() {
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
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 20, 0, 20, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				JLabel lblOutput = new JLabel("Skriv den indbetalte sum foroven");
				GridBagConstraints gbc_lblOutput = new GridBagConstraints();
				gbc_lblOutput.insets = new Insets(0, 0, 0, 5);
				gbc_lblOutput.gridx = 3;
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
				payButton.setActionCommand("OK");
				buttonPane.add(payButton);
				getRootPane().setDefaultButton(payButton);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
