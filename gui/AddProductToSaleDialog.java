package gui;

import control.ProductController;
import control.SaleController;
import model.Product;

import java.awt.BorderLayout; 
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class AddProductToSaleDialog extends JDialog {
	
	private SaleController saleController;
	private ProductController productController;

	private final JPanel contentPanel = new JPanel();
	private JTextField barcodeField;
	private JTextField quantityField;
	private JLabel nameLabel2;
	private JLabel descriptionLabel2;
	private JLabel errorLabel;
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			new TryMe();
			AddProductToSaleDialog dialog = new AddProductToSaleDialog(new SaleController());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddProductToSaleDialog(SaleController saleController) {
		setModal(true);
		this.saleController = saleController;
		productController  = new ProductController();
		createGUI();
		
	}
	
	private void findProductByBarcode() {
		
		Product product = productController.findProductByBarcode(barcodeField.getText());
		if (product != null) {
			
			nameLabel2.setText(product.getName());
			descriptionLabel2.setText(product.getDescription());
			errorLabel.setText("");
		}
		else {
			errorLabel.setText("Fejl der blev ikke fundet nogen produkter med denne stregkode");
		}
		
	}
	

	
	private void addProductByBarcodeAndQuantity() {
		  
		String parseText = quantityField.getText();
		
		
		if  (parseText.isEmpty()) {
			
			errorLabel.setText("Fejl der blev ikke fundet et antal");
			
			}
		else {
			int intParsed = Integer.parseInt(parseText);
			saleController.addProductToSale(barcodeField.getText(), intParsed);
			errorLabel.setText("Vare er blevet tilføjet");
			
		}
	}
	
	private void addButton() {
		addProductByBarcodeAndQuantity();	
	}
	
	private void finishedButton() {
		dispose();
	}
	
	private void searchButton() {
		findProductByBarcode();
	}
	
	private void createGUI() {
		
		setTitle("Varer");
		setBounds(100, 100, 450, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{53, 0, 269, 57, 0};
		gbl_contentPanel.rowHeights = new int[]{35, 23, 20, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel barcodeLabel = new JLabel("Stregkode:");
			GridBagConstraints gbc_barcodeLabel = new GridBagConstraints();
			gbc_barcodeLabel.anchor = GridBagConstraints.EAST;
			gbc_barcodeLabel.insets = new Insets(0, 0, 5, 5);
			gbc_barcodeLabel.gridx = 0;
			gbc_barcodeLabel.gridy = 1;
			contentPanel.add(barcodeLabel, gbc_barcodeLabel);
		}
		{
			barcodeField = new JTextField();
			GridBagConstraints gbc_barcodeField = new GridBagConstraints();
			gbc_barcodeField.fill = GridBagConstraints.HORIZONTAL;
			gbc_barcodeField.insets = new Insets(0, 0, 5, 5);
			gbc_barcodeField.gridx = 2;
			gbc_barcodeField.gridy = 1;
			contentPanel.add(barcodeField, gbc_barcodeField);
			barcodeField.setColumns(10);
		}
		{
			JButton searchButton = new JButton("Soeg");
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					searchButton();
				}
			});
			GridBagConstraints gbc_searchButton = new GridBagConstraints();
			gbc_searchButton.insets = new Insets(0, 0, 5, 0);
			gbc_searchButton.gridx = 3;
			gbc_searchButton.gridy = 1;
			contentPanel.add(searchButton, gbc_searchButton);
		}
		{
			JLabel quantityLabel = new JLabel("Antal:");
			GridBagConstraints gbc_quantityLabel = new GridBagConstraints();
			gbc_quantityLabel.anchor = GridBagConstraints.EAST;
			gbc_quantityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_quantityLabel.gridx = 0;
			gbc_quantityLabel.gridy = 2;
			contentPanel.add(quantityLabel, gbc_quantityLabel);
		}
		
		
		
		{
			quantityField = new JTextField();
			GridBagConstraints gbc_quantityField = new GridBagConstraints();
			gbc_quantityField.anchor = GridBagConstraints.NORTH;
			gbc_quantityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_quantityField.insets = new Insets(0, 0, 5, 5);
			gbc_quantityField.gridx = 2;
			gbc_quantityField.gridy = 2;
			contentPanel.add(quantityField, gbc_quantityField);
			quantityField.setColumns(10);
			// Method that removes character if it's not a digit
			quantityField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e)
			{
					char c = e.getKeyChar();
					if (!Character.isDigit(c))
					{
						e.consume();
					}
			}
			});
		}
		{
			errorLabel = new JLabel("");
			GridBagConstraints gbc_errorLabel = new GridBagConstraints();
			gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
			gbc_errorLabel.gridx = 2;
			gbc_errorLabel.gridy = 3;
			contentPanel.add(errorLabel, gbc_errorLabel);
		}
		{
			JLabel nameLabel1 = new JLabel("Name:");
			GridBagConstraints gbc_nameLabel1 = new GridBagConstraints();
			gbc_nameLabel1.insets = new Insets(0, 0, 5, 5);
			gbc_nameLabel1.gridx = 0;
			gbc_nameLabel1.gridy = 4;
			contentPanel.add(nameLabel1, gbc_nameLabel1);
		}
		{
			nameLabel2 = new JLabel("");
			GridBagConstraints gbc_nameLabel2 = new GridBagConstraints();
			gbc_nameLabel2.insets = new Insets(0, 0, 5, 5);
			gbc_nameLabel2.gridx = 2;
			gbc_nameLabel2.gridy = 4;
			contentPanel.add(nameLabel2, gbc_nameLabel2);
		}
		{
			JLabel descriptionLabel1 = new JLabel("Description:");
			GridBagConstraints gbc_descriptionLabel1 = new GridBagConstraints();
			gbc_descriptionLabel1.insets = new Insets(0, 0, 0, 5);
			gbc_descriptionLabel1.gridx = 0;
			gbc_descriptionLabel1.gridy = 5;
			contentPanel.add(descriptionLabel1, gbc_descriptionLabel1);
		}
		{
			descriptionLabel2 = new JLabel("");
			GridBagConstraints gbc_descriptionLabel2 = new GridBagConstraints();
			gbc_descriptionLabel2.insets = new Insets(0, 0, 0, 5);
			gbc_descriptionLabel2.gridx = 2;
			gbc_descriptionLabel2.gridy = 5;
			contentPanel.add(descriptionLabel2, gbc_descriptionLabel2);
		}
	
	
			
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addButton = new JButton("Tilfoej");
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
				JButton doneButton = new JButton("Faerdig");
				doneButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finishedButton();
						
					}
				
				});
				doneButton.setActionCommand("Cancel");
				buttonPane.add(doneButton);
			}		
		}
	}
    
}
