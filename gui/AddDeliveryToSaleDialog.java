package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import control.SaleController;

import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Insets;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddDeliveryToSaleDialog extends JDialog {
	private SaleController saleController;

	private final JButton closeButton = new JButton("Annuller");
	private JTextField addressField;
	private JTextField nameField;
	private JTextField postalField;
	private JTextField cityField;
	private JButton addButton;
	private JTextField mobileNumber;
	private String name;
	private String address;
	private int postal;
	private String city;
	private String phoneNumber;
	private JLabel contryLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			AddDeliveryToSaleDialog dialog = new AddDeliveryToSaleDialog(new SaleController());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddDeliveryToSaleDialog(SaleController saleController) {
		setModal(true);
		this.saleController = saleController;
		createUI();
	}

	private void getInput() {
		name = nameField.getText();

		address = addressField.getText();

		postal = Integer.parseInt(postalField.getText());

		city = cityField.getText();

		phoneNumber = mobileNumber.getText();
	}

	private void addAddressButton() {
		getInput();

		boolean validInput = isValidInput();

		if (validInput) {
			addDeliveryInformationToSale();
			dispose();
		}
	}

	private boolean isValidInput() {

		boolean error = false;

		if (name.isEmpty()) {
			error = true;
		}

		if (address.isEmpty()) {
			error = true;
		}

		if (postal == 0) {
			error = true;
		}

		if (city.isEmpty()) {
			error = true;
		}

		if (phoneNumber.isEmpty()) {
			error = true;
		}

		return !error;
	}

	private void addDeliveryInformationToSale() {

		saleController.addDeliveryAddressToSale(address);
		saleController.addDeliveryNameToSale(name);
		saleController.addPostalToSale(postal);
		saleController.addPhoneNumberToSale("+45" + phoneNumber);
		saleController.addDeliveryCityToSale(city);
	}

	private void cancelButton() {
		dispose();
	}

	private void createUI() {
		setTitle("Tilf\u00F8j leverings addresse");
		setBounds(100, 100, 395, 257);

		JPanel panel = new JPanel();
		FlowLayout fl_panel = (FlowLayout) panel.getLayout();
		fl_panel.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.SOUTH);

		addButton = new JButton("Tilf\u00F8j");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAddressButton();
			}
		});
		panel.add(addButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelButton();
			}
		});
		closeButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(closeButton);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 35, 0, 24, 120, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel nameLabel = new JLabel("Navn :");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 0;
		panel_1.add(nameLabel, gbc_nameLabel);

		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.SOUTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 3;
		gbc_nameField.gridy = 0;
		panel_1.add(nameField, gbc_nameField);
		nameField.setColumns(10);

		JLabel addressLabel = new JLabel("Adresse :");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.EAST;
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 1;
		gbc_addressLabel.gridy = 1;
		panel_1.add(addressLabel, gbc_addressLabel);

		addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.anchor = GridBagConstraints.SOUTH;
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 3;
		gbc_addressField.gridy = 1;
		panel_1.add(addressField, gbc_addressField);
		addressField.setColumns(10);

		JLabel postalLabel = new JLabel("Postnummer :");
		postalLabel.setVerticalAlignment(SwingConstants.TOP);
		postalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_postalLabel = new GridBagConstraints();
		gbc_postalLabel.anchor = GridBagConstraints.EAST;
		gbc_postalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_postalLabel.gridx = 1;
		gbc_postalLabel.gridy = 2;
		panel_1.add(postalLabel, gbc_postalLabel);

		postalField = new JTextField();
		postalField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_postalField = new GridBagConstraints();
		gbc_postalField.anchor = GridBagConstraints.SOUTH;
		gbc_postalField.insets = new Insets(0, 0, 5, 5);
		gbc_postalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_postalField.gridx = 3;
		gbc_postalField.gridy = 2;
		panel_1.add(postalField, gbc_postalField);
		postalField.setColumns(10);

		JLabel mobileNumberLabel = new JLabel("Telefon nummer :");
		GridBagConstraints gbc_mobileNumberLabel = new GridBagConstraints();
		gbc_mobileNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_mobileNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mobileNumberLabel.gridx = 1;
		gbc_mobileNumberLabel.gridy = 3;
		panel_1.add(mobileNumberLabel, gbc_mobileNumberLabel);

		contryLabel = new JLabel("+45");
		GridBagConstraints gbc_contryLabel = new GridBagConstraints();
		gbc_contryLabel.insets = new Insets(0, 0, 5, 5);
		gbc_contryLabel.anchor = GridBagConstraints.EAST;
		gbc_contryLabel.gridx = 2;
		gbc_contryLabel.gridy = 3;
		panel_1.add(contryLabel, gbc_contryLabel);

		mobileNumber = new JTextField();
		mobileNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		GridBagConstraints gbc_MobileNumber = new GridBagConstraints();
		gbc_MobileNumber.insets = new Insets(0, 0, 5, 5);
		gbc_MobileNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_MobileNumber.gridx = 3;
		gbc_MobileNumber.gridy = 3;
		panel_1.add(mobileNumber, gbc_MobileNumber);
		mobileNumber.setColumns(10);

		JLabel cityLabel = new JLabel("By :");
		GridBagConstraints gbc_cityLabel = new GridBagConstraints();
		gbc_cityLabel.anchor = GridBagConstraints.EAST;
		gbc_cityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cityLabel.gridx = 1;
		gbc_cityLabel.gridy = 4;
		panel_1.add(cityLabel, gbc_cityLabel);

		cityField = new JTextField();
		GridBagConstraints gbc_cityField = new GridBagConstraints();
		gbc_cityField.anchor = GridBagConstraints.SOUTH;
		gbc_cityField.insets = new Insets(0, 0, 5, 5);
		gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cityField.gridx = 3;
		gbc_cityField.gridy = 4;
		panel_1.add(cityField, gbc_cityField);
		cityField.setColumns(10);
	}

}
