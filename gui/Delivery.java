package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.SaleController;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delivery extends JDialog {
	private SaleController saleController;

	private final JButton closeButton = new JButton("Luk");
	private JTextField addressField;
	private JTextField nameField;
	private JTextField postalField;
	private JTextField cityField;
	private JPanel panel;
	private JButton addButton;
	private JPanel panel_1;
	private JLabel phoneNumberLabel;
	private JTextField MobileNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			Delivery dialog = new Delivery(new SaleController());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Delivery(SaleController saleController) {
		this.saleController = saleController;
		createUI();
	}

	private void createUI() {
		setTitle("Tilf\u00F8j leverings addresse");
		setBounds(100, 100, 395, 257);

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		addButton = new JButton("Tilf\u00F8j");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(addButton);
		closeButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(closeButton);

		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 35, 127, 120, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel nameLabel = new JLabel("Navn :");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 0;
		panel_1.add(nameLabel, gbc_nameLabel);

		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.SOUTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 0;
		panel_1.add(nameField, gbc_nameField);
		nameField.setColumns(10);

		JLabel addressLabel = new JLabel("Adresse :");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.WEST;
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 1;
		gbc_addressLabel.gridy = 1;
		panel_1.add(addressLabel, gbc_addressLabel);

		addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.anchor = GridBagConstraints.SOUTH;
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 2;
		gbc_addressField.gridy = 1;
		panel_1.add(addressField, gbc_addressField);
		addressField.setColumns(10);

		JLabel postalLabel = new JLabel("Postnummer :");
		postalLabel.setVerticalAlignment(SwingConstants.TOP);
		postalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_postalLabel = new GridBagConstraints();
		gbc_postalLabel.anchor = GridBagConstraints.WEST;
		gbc_postalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_postalLabel.gridx = 1;
		gbc_postalLabel.gridy = 2;
		panel_1.add(postalLabel, gbc_postalLabel);

		postalField = new JTextField();
		GridBagConstraints gbc_postalField = new GridBagConstraints();
		gbc_postalField.anchor = GridBagConstraints.SOUTH;
		gbc_postalField.insets = new Insets(0, 0, 5, 5);
		gbc_postalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_postalField.gridx = 2;
		gbc_postalField.gridy = 2;
		panel_1.add(postalField, gbc_postalField);
		postalField.setColumns(10);
				
				phoneNumberLabel = new JLabel("Telefon nummer :");
				GridBagConstraints gbc_phoneNumberLabel = new GridBagConstraints();
				gbc_phoneNumberLabel.anchor = GridBagConstraints.WEST;
				gbc_phoneNumberLabel.insets = new Insets(0, 0, 5, 5);
				gbc_phoneNumberLabel.gridx = 1;
				gbc_phoneNumberLabel.gridy = 3;
				panel_1.add(phoneNumberLabel, gbc_phoneNumberLabel);
				
				MobileNumber = new JTextField();
				GridBagConstraints gbc_MobileNumber = new GridBagConstraints();
				gbc_MobileNumber.insets = new Insets(0, 0, 5, 5);
				gbc_MobileNumber.fill = GridBagConstraints.HORIZONTAL;
				gbc_MobileNumber.gridx = 2;
				gbc_MobileNumber.gridy = 3;
				panel_1.add(MobileNumber, gbc_MobileNumber);
				MobileNumber.setColumns(10);
		
				JLabel cityLabel = new JLabel("By :");
				GridBagConstraints gbc_cityLabel = new GridBagConstraints();
				gbc_cityLabel.anchor = GridBagConstraints.WEST;
				gbc_cityLabel.insets = new Insets(0, 0, 0, 5);
				gbc_cityLabel.gridx = 1;
				gbc_cityLabel.gridy = 4;
				panel_1.add(cityLabel, gbc_cityLabel);
		
				cityField = new JTextField();
				GridBagConstraints gbc_cityField = new GridBagConstraints();
				gbc_cityField.anchor = GridBagConstraints.SOUTH;
				gbc_cityField.insets = new Insets(0, 0, 0, 5);
				gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
				gbc_cityField.gridx = 2;
				gbc_cityField.gridy = 4;
				panel_1.add(cityField, gbc_cityField);
				cityField.setColumns(10);
	}

}
