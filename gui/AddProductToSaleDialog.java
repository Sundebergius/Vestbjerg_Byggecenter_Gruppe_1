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
import java.awt.event.ActionEvent;

public class AddProductToSaleDialog extends JDialog {
	
	private SaleController saleController;
	private ProductController productController;

	private final JPanel contentPanel = new JPanel();
	private JTextField barcodeField;
	private JTextField quantityField;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	
	
	
	
	
	

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
		nameLabel.setText(product.getName());
		descriptionLabel.setText(product.getDescription());
		
	}
	

	
	private void addProductByBarcodeAndQuantity() {
		
		String parseText = quantityField.getText();
		int intParse = Integer.parseInt(parseText);
		saleController.addProductToSale(barcodeField.getText(), intParse);
	}
	
	private void createGUI() {
		
		setTitle("Varer");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{53, 269, 57, 0};
		gbl_contentPanel.rowHeights = new int[]{35, 23, 20, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_barcodeField.gridx = 1;
			gbc_barcodeField.gridy = 1;
			contentPanel.add(barcodeField, gbc_barcodeField);
			barcodeField.setColumns(10);
		}
		{
			JButton searchButton = new JButton("Soeg");
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					findProductByBarcode();
				}
			});
			GridBagConstraints gbc_searchButton = new GridBagConstraints();
			gbc_searchButton.insets = new Insets(0, 0, 5, 0);
			gbc_searchButton.gridx = 2;
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
			gbc_quantityField.gridx = 1;
			gbc_quantityField.gridy = 2;
			contentPanel.add(quantityField, gbc_quantityField);
			quantityField.setColumns(10);
		}
		{
			nameLabel = new JLabel("");
			GridBagConstraints gbc_nameLabel = new GridBagConstraints();
			gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_nameLabel.gridx = 1;
			gbc_nameLabel.gridy = 3;
			contentPanel.add(nameLabel, gbc_nameLabel);
		}
		{
			descriptionLabel = new JLabel("");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 4;
			contentPanel.add(descriptionLabel, gbc_lblNewLabel_1);
		}
	
	
			
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addButton = new JButton("Tilfoej");
				addButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						addProductByBarcodeAndQuantity();
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
						dispose();
					}
				
				});
				doneButton.setActionCommand("Cancel");
				buttonPane.add(doneButton);
			}		
		}
	}
    
}
