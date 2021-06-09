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
import javax.swing.JTextArea;

public class AddProductToSaleDialog extends JDialog {
	
	private SaleController saleController;
	private ProductController productController;

	private final JPanel contentPanel = new JPanel();
	private JTextField barcodeField;
	private JTextField quantityField;
	private JTextArea textArea;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
		this.saleController = saleController;
		productController  = new ProductController();
		createGUI();
		
	}
	
	private void findProductByBarcode() {
		
		Product product = productController.findProductByBarcode(barcodeField.getText());
		 textArea.setText(product.getName());
	}
	

	
	private void addProductByBarcodeAndQuantity() {
		
		String parseText = quantityField.getText();
		int quantityParse = Integer.parseInt(parseText);
		saleController.addProductToSale(barcodeField.getText(), quantityParse);
	}
	
	private void createGUI() {
		
		setTitle("Varer");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel barcodeLabel = new JLabel("Stregkode:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(barcodeLabel, gbc_lblNewLabel);
		}
		{
			barcodeField = new JTextField();
			GridBagConstraints gbc_txtStregkode = new GridBagConstraints();
			gbc_txtStregkode.insets = new Insets(0, 0, 5, 5);
			gbc_txtStregkode.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStregkode.gridx = 1;
			gbc_txtStregkode.gridy = 1;
			contentPanel.add(barcodeField, gbc_txtStregkode);
			barcodeField.setColumns(10);
		}
		{
			JButton searchButton = new JButton("Soeg");
			searchButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					findProductByBarcode();
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 1;
			contentPanel.add(searchButton, gbc_btnNewButton);
		}
		{
			JLabel quantityLabel = new JLabel("Antal:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(quantityLabel , gbc_lblNewLabel_1);
		}
		{
			quantityField = new JTextField();
			GridBagConstraints gbc_txtAntal = new GridBagConstraints();
			gbc_txtAntal.insets = new Insets(0, 0, 5, 5);
			gbc_txtAntal.anchor = GridBagConstraints.ABOVE_BASELINE;
			gbc_txtAntal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAntal.gridx = 1;
			gbc_txtAntal.gridy = 2;
			contentPanel.add(quantityField, gbc_txtAntal);
			quantityField.setColumns(10);
		}
		{
			JTextArea textArea = new JTextArea();
			GridBagConstraints gbc_textArea = new GridBagConstraints();
			gbc_textArea.insets = new Insets(0, 0, 0, 5);
			gbc_textArea.fill = GridBagConstraints.BOTH;
			gbc_textArea.gridx = 1;
			gbc_textArea.gridy = 3;
			contentPanel.add(textArea, gbc_textArea);
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
