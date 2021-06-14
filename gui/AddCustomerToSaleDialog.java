package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.PersonController;
import control.SaleController;
import model.Customer;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddCustomerToSaleDialog extends JDialog {

	private SaleController saleController;
	private PersonController personController;
	private Customer foundCustomer;

	private JTextField customerNameField;
	private JTextField customerAddressField;
	private JTextField customerZipcodeField;
	private JTextField customerCityField;
	private JTextField customerPhoneNoField;
	private JTextField customerIDInputField;
	private JLabel errorInfoLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			new TryMe();

			AddCustomerToSaleDialog dialog = new AddCustomerToSaleDialog(new SaleController());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCustomerToSaleDialog(SaleController saleController) {
		this.saleController = saleController;
		personController = new PersonController();
		createGUI();
	}

	private void searchButton() {
		String customerID = customerIDInputField.getText();
		foundCustomer = personController.findCustomerByCustomerID(customerID);

		if (foundCustomer != null) {
			errorInfoLabel.setText("");
			customerNameField.setText(foundCustomer.getName());
			customerAddressField.setText(foundCustomer.getAddress());
			customerZipcodeField.setText("" + foundCustomer.getPostalCode());
			customerCityField.setText(foundCustomer.getCity());
			customerPhoneNoField.setText(foundCustomer.getMobileNo());

		} else {
			errorInfoLabel.setText("Fejl der blev ikke fundet nogen kunde med denne ID");
		}

	}

	private void addCustomerButton() {
		if (foundCustomer != null) {
			saleController.addCustomerToSale(foundCustomer.getCustomerID());
			dispose();
		} else {
			errorInfoLabel.setText("Fejl der er ikke blevet fundet en kunde endnu");
		}
	}

	private void cancelButton() {
		dispose();
	}

	private void customerIDInputFieldAction() {

		searchButton();
	}

	private void customerIDInputFieldKeyAction() {
		errorInfoLabel.setText("");
		customerIDInputField.grabFocus();
	}

	private void createGUI() {
		setTitle("Tilføj kunde til salget");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addCustomerButton = new JButton("Tilføj Kunde");
				addCustomerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addCustomerButton();
					}
				});
				addCustomerButton.setActionCommand("OK");
				buttonPane.add(addCustomerButton);
				getRootPane().setDefaultButton(addCustomerButton);
			}
			{
				JButton cancelButton = new JButton("Annuller");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelButton();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel InfoPane = new JPanel();
			getContentPane().add(InfoPane, BorderLayout.CENTER);
			GridBagLayout gbl_InfoPane = new GridBagLayout();
			gbl_InfoPane.columnWidths = new int[] { 30, 90, 0, 30, 0 };
			gbl_InfoPane.rowHeights = new int[] { 25, 0, 0, 0, 0, 0, 0 };
			gbl_InfoPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_InfoPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			InfoPane.setLayout(gbl_InfoPane);
			{
				errorInfoLabel = new JLabel("");
				errorInfoLabel.setForeground(UIManager.getColor("OptionPane.errorDialog.border.background"));
				GridBagConstraints gbc_errorInfoLabel = new GridBagConstraints();
				gbc_errorInfoLabel.anchor = GridBagConstraints.NORTH;
				gbc_errorInfoLabel.gridwidth = 2;
				gbc_errorInfoLabel.insets = new Insets(0, 0, 5, 5);
				gbc_errorInfoLabel.gridx = 1;
				gbc_errorInfoLabel.gridy = 0;
				InfoPane.add(errorInfoLabel, gbc_errorInfoLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Navn :");
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 1;
				InfoPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				customerNameField = new JTextField();
				customerNameField.setEditable(false);
				GridBagConstraints gbc_customerNameField = new GridBagConstraints();
				gbc_customerNameField.insets = new Insets(0, 0, 5, 5);
				gbc_customerNameField.fill = GridBagConstraints.HORIZONTAL;
				gbc_customerNameField.gridx = 2;
				gbc_customerNameField.gridy = 1;
				InfoPane.add(customerNameField, gbc_customerNameField);
				customerNameField.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Adresse :");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 2;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				customerAddressField = new JTextField();
				customerAddressField.setEditable(false);
				customerAddressField.setColumns(10);
				GridBagConstraints gbc_customerAddressField = new GridBagConstraints();
				gbc_customerAddressField.insets = new Insets(0, 0, 5, 5);
				gbc_customerAddressField.fill = GridBagConstraints.HORIZONTAL;
				gbc_customerAddressField.gridx = 2;
				gbc_customerAddressField.gridy = 2;
				InfoPane.add(customerAddressField, gbc_customerAddressField);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Postnummer :");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 3;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				customerZipcodeField = new JTextField();
				customerZipcodeField.setEditable(false);
				customerZipcodeField.setColumns(10);
				GridBagConstraints gbc_customerZipcodeField = new GridBagConstraints();
				gbc_customerZipcodeField.insets = new Insets(0, 0, 5, 5);
				gbc_customerZipcodeField.fill = GridBagConstraints.HORIZONTAL;
				gbc_customerZipcodeField.gridx = 2;
				gbc_customerZipcodeField.gridy = 3;
				InfoPane.add(customerZipcodeField, gbc_customerZipcodeField);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("By :");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 4;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				customerCityField = new JTextField();
				customerCityField.setEditable(false);
				customerCityField.setColumns(10);
				GridBagConstraints gbc_customerCityField = new GridBagConstraints();
				gbc_customerCityField.insets = new Insets(0, 0, 5, 5);
				gbc_customerCityField.fill = GridBagConstraints.HORIZONTAL;
				gbc_customerCityField.gridx = 2;
				gbc_customerCityField.gridy = 4;
				InfoPane.add(customerCityField, gbc_customerCityField);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Telefonnummer :");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 5;
				InfoPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				customerPhoneNoField = new JTextField();
				customerPhoneNoField.setEditable(false);
				customerPhoneNoField.setColumns(10);
				GridBagConstraints gbc_customerPhoneNoField = new GridBagConstraints();
				gbc_customerPhoneNoField.insets = new Insets(0, 0, 0, 5);
				gbc_customerPhoneNoField.fill = GridBagConstraints.HORIZONTAL;
				gbc_customerPhoneNoField.gridx = 2;
				gbc_customerPhoneNoField.gridy = 5;
				InfoPane.add(customerPhoneNoField, gbc_customerPhoneNoField);
			}
		}
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			getContentPane().add(contentPanel, BorderLayout.NORTH);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[] { 30, 90, 0, 0, 30, 0 };
			gbl_contentPanel.rowHeights = new int[] { 15, 0, 0 };
			gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			contentPanel.setLayout(gbl_contentPanel);
			{
				JLabel lblNewLabel = new JLabel("Kunde ID:");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				customerIDInputField = new JTextField();
				customerIDInputField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() != KeyEvent.VK_ENTER) {
							customerIDInputFieldKeyAction();
						} else {
							customerIDInputFieldAction();
						}
					}
				});

				customerIDInputField.setColumns(10);
				GridBagConstraints gbc_customerIDInputField = new GridBagConstraints();
				gbc_customerIDInputField.fill = GridBagConstraints.HORIZONTAL;
				gbc_customerIDInputField.insets = new Insets(0, 0, 0, 5);
				gbc_customerIDInputField.gridx = 2;
				gbc_customerIDInputField.gridy = 1;
				contentPanel.add(customerIDInputField, gbc_customerIDInputField);
			}
			{
				JButton searchButton = new JButton("Søg");
				searchButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						searchButton();
					}
				});
				GridBagConstraints gbc_searchButton = new GridBagConstraints();
				gbc_searchButton.insets = new Insets(0, 0, 0, 5);
				gbc_searchButton.gridx = 3;
				gbc_searchButton.gridy = 1;
				contentPanel.add(searchButton, gbc_searchButton);
			}
		}
	}

}
