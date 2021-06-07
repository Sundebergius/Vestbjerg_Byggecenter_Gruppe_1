package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class AddCustomerToSaleDialog extends JDialog {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCustomerToSaleDialog dialog = new AddCustomerToSaleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCustomerToSaleDialog() {
		setTitle("Tilføj kunde til salget");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Tilføj Kunde");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel InfoPane = new JPanel();
			getContentPane().add(InfoPane, BorderLayout.CENTER);
			GridBagLayout gbl_InfoPane = new GridBagLayout();
			gbl_InfoPane.columnWidths = new int[]{30, 90, 0, 30, 0};
			gbl_InfoPane.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0};
			gbl_InfoPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_InfoPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			InfoPane.setLayout(gbl_InfoPane);
			{
				JLabel lblNewLabel_1 = new JLabel("Kunde Navn");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 1;
				InfoPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 1;
				InfoPane.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Adresse");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 2;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setColumns(10);
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 2;
				gbc_textField_2.gridy = 2;
				InfoPane.add(textField_2, gbc_textField_2);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Postnummer");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 3;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.setColumns(10);
				GridBagConstraints gbc_textField_3 = new GridBagConstraints();
				gbc_textField_3.insets = new Insets(0, 0, 5, 5);
				gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_3.gridx = 2;
				gbc_textField_3.gridy = 3;
				InfoPane.add(textField_3, gbc_textField_3);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("By");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 4;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				textField_4 = new JTextField();
				textField_4.setEditable(false);
				textField_4.setColumns(10);
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.insets = new Insets(0, 0, 5, 5);
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 2;
				gbc_textField_4.gridy = 4;
				InfoPane.add(textField_4, gbc_textField_4);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Telefon Nummer");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 5;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				textField_5 = new JTextField();
				textField_5.setEditable(false);
				textField_5.setColumns(10);
				GridBagConstraints gbc_textField_5 = new GridBagConstraints();
				gbc_textField_5.insets = new Insets(0, 0, 0, 5);
				gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_5.gridx = 2;
				gbc_textField_5.gridy = 5;
				InfoPane.add(textField_5, gbc_textField_5);
			}
		}
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.NORTH);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{30, 90, 0, 0, 30, 0};
			gbl_contentPanel.rowHeights = new int[]{15, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lblNewLabel = new JLabel("Indtast Kunde ID");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.insets = new Insets(0, 0, 0, 5);
				gbc_textField.gridx = 2;
				gbc_textField.gridy = 1;
				contentPanel.add(textField, gbc_textField);
			}
			{
				JButton btnNewButton = new JButton("Søg");
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
				gbc_btnNewButton.gridx = 3;
				gbc_btnNewButton.gridy = 1;
				contentPanel.add(btnNewButton, gbc_btnNewButton);
			}
		}
	}

}
