package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import control.SaleController;
import model.SaleLineItem;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class CreateSaleFrame extends JFrame {

	private JPanel contentPane;
	private SaleController saleController;
	private JList<SaleLineItem> productList;
	private DefaultListModel<SaleLineItem> listRepresentation;
	
	private JTextField customerIDField;
	private JTextField customerNameField;
	private JTextField subtotalField;
	private JTextField recieverField;
	private JTextField deliveryAddressField;
	private JTextField deliveryCityField;
	private JTextField deliveryZipCodeField;	
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateSaleFrame frame = new CreateSaleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateSaleFrame() {
		createGUI();
		saleController = new SaleController();
		
	}
	
	private void addProductButton() {
		AddProductToSaleDialog productToSaleDialog = new AddProductToSaleDialog();
		productToSaleDialog.setVisible(true);
	
	}
	
	private void addCustomerButton() {
		AddCustomerToSaleDialog customerToSaleDialog = new AddCustomerToSaleDialog();
		customerToSaleDialog.setVisible(true);
	
	}
	
	private void addDeliveryButton() {
		AddDeliveryToSaleDialog deliveryToSaleDialog = new AddDeliveryToSaleDialog();
		deliveryToSaleDialog.setVisible(true);
		
	}
	
	private void payButton() {
		PaySaleDialog paySaleDialog = new PaySaleDialog();
		paySaleDialog.setVisible(true);
		
	}
	
	private void cancelButton() {
		//ask for confirmation
		dispose();		
	}
	
	private void removeProductButton() {
		System.out.println("Not implemented yet");
	
	}
	
	private void updateProductList() {
		listRepresentation = new DefaultListModel<SaleLineItem>();
		ArrayList<SaleLineItem> saleLineItemList = new ArrayList<>();
		saleLineItemList.addAll(Arrays.asList(saleController.getCurrentSale().getSaleLineItems()));
		
		for (SaleLineItem saleLineItem : saleLineItemList) {
			listRepresentation.addElement(saleLineItem);
		}
		productList.setModel(listRepresentation);
	}
	
	
	
	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 1083);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel saleConfirmationPanel = new JPanel();
		contentPane.add(saleConfirmationPanel, BorderLayout.SOUTH);
		saleConfirmationPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton startPaymentButton = new JButton("Betal");
		startPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payButton();
			}
		});
		saleConfirmationPanel.add(startPaymentButton);
		
		JButton cancelButton = new JButton("Annuller salg");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelButton();
			}
		});
		saleConfirmationPanel.add(cancelButton);
		
		JPanel contentPanels = new JPanel();
		contentPane.add(contentPanels, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanels = new GridBagLayout();
		gbl_contentPanels.columnWidths = new int[]{0, 0};
		gbl_contentPanels.rowHeights = new int[]{300, 0, 0, 0};
		gbl_contentPanels.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanels.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanels.setLayout(gbl_contentPanels);
		
		JPanel productPanel = new JPanel();
		productPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Varer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_productPanel = new GridBagConstraints();
		gbc_productPanel.insets = new Insets(0, 0, 5, 0);
		gbc_productPanel.fill = GridBagConstraints.BOTH;
		gbc_productPanel.gridx = 0;
		gbc_productPanel.gridy = 0;
		contentPanels.add(productPanel, gbc_productPanel);
		productPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel productControlPanel = new JPanel();
		productPanel.add(productControlPanel, BorderLayout.SOUTH);
		productControlPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel productContentPanel = new JPanel();
		FlowLayout fl_productContentPanel = (FlowLayout) productContentPanel.getLayout();
		fl_productContentPanel.setAlignment(FlowLayout.RIGHT);
		productControlPanel.add(productContentPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_7 = new JLabel("Moms");
		productContentPanel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		productContentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Subtotal");
		productContentPanel.add(lblNewLabel_4);
		
		subtotalField = new JTextField();
		subtotalField.setEditable(false);
		productContentPanel.add(subtotalField);
		subtotalField.setColumns(10);
		
		JPanel productButtonPanel = new JPanel();
		FlowLayout fl_productButtonPanel = (FlowLayout) productButtonPanel.getLayout();
		fl_productButtonPanel.setAlignment(FlowLayout.RIGHT);
		productControlPanel.add(productButtonPanel, BorderLayout.SOUTH);
		
		JButton removeProductButton = new JButton("Fjern varer");
		removeProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeProductButton();
			}
		});
		productButtonPanel.add(removeProductButton);
		
		JButton addProductButton = new JButton("Tilføj varer");
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProductButton();
			}
		});
		productButtonPanel.add(addProductButton);
		
		JScrollPane productListPanel = new JScrollPane();
		productPanel.add(productListPanel, BorderLayout.CENTER);
		
		productList = new JList();
		productListPanel.setViewportView(productList);
		
		JPanel customerPanel = new JPanel();
		customerPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Kunde", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_customerPanel = new GridBagConstraints();
		gbc_customerPanel.insets = new Insets(0, 0, 5, 0);
		gbc_customerPanel.fill = GridBagConstraints.BOTH;
		gbc_customerPanel.gridx = 0;
		gbc_customerPanel.gridy = 1;
		contentPanels.add(customerPanel, gbc_customerPanel);
		customerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel customerButtonPanel = new JPanel();
		FlowLayout fl_customerButtonPanel = (FlowLayout) customerButtonPanel.getLayout();
		fl_customerButtonPanel.setAlignment(FlowLayout.RIGHT);
		customerPanel.add(customerButtonPanel, BorderLayout.SOUTH);
		
		JButton addCustomerButton = new JButton("Tilføj kunde");
		addCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerButton();
			}
		});
		customerButtonPanel.add(addCustomerButton);
		
		JPanel customerContentPanel = new JPanel();
		FlowLayout fl_customerContentPanel = (FlowLayout) customerContentPanel.getLayout();
		fl_customerContentPanel.setAlignment(FlowLayout.LEFT);
		customerPanel.add(customerContentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Kunde ID");
		customerContentPanel.add(lblNewLabel);
		
		customerIDField = new JTextField();
		customerIDField.setEditable(false);
		customerContentPanel.add(customerIDField);
		customerIDField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Navn");
		customerContentPanel.add(lblNewLabel_1);
		
		customerNameField = new JTextField();
		customerNameField.setEditable(false);
		customerContentPanel.add(customerNameField);
		customerNameField.setColumns(10);
		
		JPanel deliveryPanel = new JPanel();
		deliveryPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Levering", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_deliveryPanel = new GridBagConstraints();
		gbc_deliveryPanel.fill = GridBagConstraints.BOTH;
		gbc_deliveryPanel.gridx = 0;
		gbc_deliveryPanel.gridy = 2;
		contentPanels.add(deliveryPanel, gbc_deliveryPanel);
		deliveryPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel deliveryButtonPanel = new JPanel();
		FlowLayout fl_deliveryButtonPanel = (FlowLayout) deliveryButtonPanel.getLayout();
		fl_deliveryButtonPanel.setAlignment(FlowLayout.RIGHT);
		deliveryPanel.add(deliveryButtonPanel, BorderLayout.SOUTH);
		
		JButton addDeliveryButton = new JButton("Tilføj levering");
		addDeliveryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDeliveryButton();
			}
		});
		deliveryButtonPanel.add(addDeliveryButton);
		
		JPanel deliveryContentPanel = new JPanel();
		deliveryPanel.add(deliveryContentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_deliveryContentPanel = new GridBagLayout();
		gbl_deliveryContentPanel.columnWidths = new int[]{0, 0, 0, 80, 0, 40, 0};
		gbl_deliveryContentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_deliveryContentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_deliveryContentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		deliveryContentPanel.setLayout(gbl_deliveryContentPanel);
		
		JLabel lblNewLabel_2 = new JLabel("Modtager");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		deliveryContentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		recieverField = new JTextField();
		recieverField.setEditable(false);
		GridBagConstraints gbc_recieverField = new GridBagConstraints();
		gbc_recieverField.gridwidth = 5;
		gbc_recieverField.insets = new Insets(0, 0, 5, 0);
		gbc_recieverField.fill = GridBagConstraints.HORIZONTAL;
		gbc_recieverField.gridx = 1;
		gbc_recieverField.gridy = 0;
		deliveryContentPanel.add(recieverField, gbc_recieverField);
		recieverField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		deliveryContentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		deliveryAddressField = new JTextField();
		deliveryAddressField.setEditable(false);
		GridBagConstraints gbc_deliveryAddressField = new GridBagConstraints();
		gbc_deliveryAddressField.insets = new Insets(0, 0, 0, 5);
		gbc_deliveryAddressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_deliveryAddressField.gridx = 1;
		gbc_deliveryAddressField.gridy = 1;
		deliveryContentPanel.add(deliveryAddressField, gbc_deliveryAddressField);
		deliveryAddressField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("By");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 1;
		deliveryContentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		deliveryCityField = new JTextField();
		deliveryCityField.setEditable(false);
		GridBagConstraints gbc_deliveryCityField = new GridBagConstraints();
		gbc_deliveryCityField.insets = new Insets(0, 0, 0, 5);
		gbc_deliveryCityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_deliveryCityField.gridx = 3;
		gbc_deliveryCityField.gridy = 1;
		deliveryContentPanel.add(deliveryCityField, gbc_deliveryCityField);
		deliveryCityField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Postnummer");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 1;
		deliveryContentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		deliveryZipCodeField = new JTextField();
		deliveryZipCodeField.setEditable(false);
		GridBagConstraints gbc_deliveryZipCodeField = new GridBagConstraints();
		gbc_deliveryZipCodeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_deliveryZipCodeField.gridx = 5;
		gbc_deliveryZipCodeField.gridy = 1;
		deliveryContentPanel.add(deliveryZipCodeField, gbc_deliveryZipCodeField);
		deliveryZipCodeField.setColumns(10);
	
	}
	

}