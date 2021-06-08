package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.border.EtchedBorder;

public class CreateSaleFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		saleConfirmationPanel.add(startPaymentButton);
		
		JButton cancelButton = new JButton("Annuller salg");
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
		
		JLabel lblNewLabel_4 = new JLabel("Subtotal");
		productContentPanel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		productContentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel productButtonPanel = new JPanel();
		FlowLayout fl_productButtonPanel = (FlowLayout) productButtonPanel.getLayout();
		fl_productButtonPanel.setAlignment(FlowLayout.RIGHT);
		productControlPanel.add(productButtonPanel, BorderLayout.SOUTH);
		
		JButton removeProductButton = new JButton("Fjern varer");
		productButtonPanel.add(removeProductButton);
		
		JButton addProductButton = new JButton("Tilføj varer");
		productButtonPanel.add(addProductButton);
		
		JScrollPane productListPanel = new JScrollPane();
		productPanel.add(productListPanel, BorderLayout.CENTER);
		
		JList productList = new JList();
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
		customerButtonPanel.add(addCustomerButton);
		
		JPanel customerContentPanel = new JPanel();
		FlowLayout fl_customerContentPanel = (FlowLayout) customerContentPanel.getLayout();
		fl_customerContentPanel.setAlignment(FlowLayout.LEFT);
		customerPanel.add(customerContentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Kunde ID");
		customerContentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		customerContentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Navn");
		customerContentPanel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		customerContentPanel.add(textField_1);
		textField_1.setColumns(10);
		
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
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		deliveryContentPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		deliveryContentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 1;
		deliveryContentPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("By");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 1;
		deliveryContentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 1;
		deliveryContentPanel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Postnummer");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 1;
		deliveryContentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 1;
		deliveryContentPanel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
	}

}
