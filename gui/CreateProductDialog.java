package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ProductController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.ProductContainer;
import model.Product;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CreateProductDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductContainer productContainer;
	private ProductController productController;
	private Product product;
	private JTextField productIDTextField;
	private JTextField productNameTextField;
	private JTextField productDescriptionTextField;
	private JTextField productPriceTextField;
	private String productID;
	private String productName;
	private String productDescription;
	private double productPrice;
	private JLabel errorLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateProductDialog dialog = new CreateProductDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateProductDialog() {
		ProductController productController = new ProductController();
		this.productController = productController;
		setModal(true);
		createGUI();
	}

	/*
	 * Method to add the new product to the product controller. 
	 */
	private void addProductFeature() {
		boolean validInput = isValidInput();
		if (validInput) {
			productController.createNewProduct(productID, productName, productDescription, productPrice);
			dispose();
		} else {

		}
	}

	/*
	 * Get the text from the text fields and adds them to their respective fields. 
	 */
	private void setProductInfo() {
		productID = productIDTextField.getText();
		productName = productNameTextField.getText();
		productDescription = productDescriptionTextField.getText();
		try {
			productPrice = Double.parseDouble(productPriceTextField.getText());
		} catch (Exception e) {
		}
	}

	/*
	 * Method to dispose the current window for the cancel button. 
	 */
	private void cancelButtonFeature()
	{
		dispose();
	}

	/*
	 * Method to check if written input is valid and not empty. 
	 */
	private boolean isValidInput() {
		String errorMessage = "Fejl: feltet for produkt ";

		boolean error = false;

		if (productID.isEmpty()) {
			error = true;
			errorMessage += "ID ";
		}

		if (productName.isEmpty()) {
			error = true;
			errorMessage += "navnet ";
		}

		if (productDescription.isEmpty()) {
			error = true;
			errorMessage += "beskrivelsen ";
		}

		if (productPriceTextField.getText().isEmpty()) {
			error = true;
			errorMessage += "prisen ";
		}

		if (error) {
			errorLabel.setText(errorMessage + "er tomt. ");
		}
		return !error;
	}
	
	/*
	 * Gets run when the add button gets pressed. 
	 */
	private void addButton() {
		setProductInfo();
		addProductFeature();
	}
	
	/*
	 * Gets run when the cancel button gets pressed. 
	 */
	private void cancelButton() {
		cancelButtonFeature();
	}

	private void createGUI() {
		setBounds(100, 100, 464, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 141, 0, 88, 80, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 21, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel headLineLabel = new JLabel("Oprettelse af et nyt coli produkt");
			headLineLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			GridBagConstraints gbc_headLineLabel = new GridBagConstraints();
			gbc_headLineLabel.gridwidth = 5;
			gbc_headLineLabel.insets = new Insets(0, 0, 5, 0);
			gbc_headLineLabel.gridx = 0;
			gbc_headLineLabel.gridy = 1;
			contentPanel.add(headLineLabel, gbc_headLineLabel);
		}
		{
			JLabel productIDLabel = new JLabel("Produkt ID:");
			GridBagConstraints gbc_productIDLabel = new GridBagConstraints();
			gbc_productIDLabel.insets = new Insets(0, 0, 5, 5);
			gbc_productIDLabel.gridx = 1;
			gbc_productIDLabel.gridy = 5;
			contentPanel.add(productIDLabel, gbc_productIDLabel);
		}
		{
			productIDTextField = new JTextField();
			GridBagConstraints gbc_productIDTextField = new GridBagConstraints();
			gbc_productIDTextField.insets = new Insets(0, 0, 5, 5);
			gbc_productIDTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productIDTextField.gridx = 2;
			gbc_productIDTextField.gridy = 5;
			contentPanel.add(productIDTextField, gbc_productIDTextField);
			productIDTextField.setColumns(10);
		}
		{
			JLabel productNameLabel = new JLabel("Produkt navn: ");
			GridBagConstraints gbc_productNameLabel = new GridBagConstraints();
			gbc_productNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_productNameLabel.gridx = 1;
			gbc_productNameLabel.gridy = 6;
			contentPanel.add(productNameLabel, gbc_productNameLabel);
		}
		{
			productNameTextField = new JTextField();
			productNameTextField.setColumns(10);
			GridBagConstraints gbc_productNameTextField = new GridBagConstraints();
			gbc_productNameTextField.insets = new Insets(0, 0, 5, 5);
			gbc_productNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productNameTextField.gridx = 2;
			gbc_productNameTextField.gridy = 6;
			contentPanel.add(productNameTextField, gbc_productNameTextField);
		}
		{
			JLabel productDescriptionLabel = new JLabel("Beskrivelse:");
			GridBagConstraints gbc_productDescriptionLabel = new GridBagConstraints();
			gbc_productDescriptionLabel.insets = new Insets(0, 0, 5, 5);
			gbc_productDescriptionLabel.gridx = 1;
			gbc_productDescriptionLabel.gridy = 7;
			contentPanel.add(productDescriptionLabel, gbc_productDescriptionLabel);
		}
		{
			productDescriptionTextField = new JTextField();
			productDescriptionTextField.setColumns(10);
			GridBagConstraints gbc_productDescriptionTextField = new GridBagConstraints();
			gbc_productDescriptionTextField.gridwidth = 2;
			gbc_productDescriptionTextField.insets = new Insets(0, 0, 5, 5);
			gbc_productDescriptionTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productDescriptionTextField.gridx = 2;
			gbc_productDescriptionTextField.gridy = 7;
			contentPanel.add(productDescriptionTextField, gbc_productDescriptionTextField);
		}
		{
			JLabel productPriceLabel = new JLabel("Pris:");
			GridBagConstraints gbc_productPriceLabel = new GridBagConstraints();
			gbc_productPriceLabel.insets = new Insets(0, 0, 5, 5);
			gbc_productPriceLabel.gridx = 1;
			gbc_productPriceLabel.gridy = 8;
			contentPanel.add(productPriceLabel, gbc_productPriceLabel);
		}
		{
			productPriceTextField = new JTextField();
			GridBagConstraints gbc_productPriceTextField = new GridBagConstraints();
			gbc_productPriceTextField.insets = new Insets(0, 0, 5, 5);
			gbc_productPriceTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productPriceTextField.gridx = 2;
			gbc_productPriceTextField.gridy = 8;
			contentPanel.add(productPriceTextField, gbc_productPriceTextField);
			productPriceTextField.setColumns(10);
		}
		{
			errorLabel = new JLabel("");
			errorLabel.setForeground(Color.RED);
			GridBagConstraints gbc_errorLabel = new GridBagConstraints();
			gbc_errorLabel.gridwidth = 3;
			gbc_errorLabel.insets = new Insets(0, 0, 0, 5);
			gbc_errorLabel.gridx = 1;
			gbc_errorLabel.gridy = 9;
			contentPanel.add(errorLabel, gbc_errorLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addButton = new JButton("Tilføj produkt");
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addButton();

					}
				});
				addButton.setActionCommand("OK");
				buttonPane.add(addButton);
				getRootPane().setDefaultButton(addButton);
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

}
