package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.SaleController;
import model.Employee;
import model.Sale;
import model.SaleLineItem;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaleReceiptDialog extends JDialog {

	private SaleController saleController;
	private JList<SaleLineItem> productList;
	private DefaultListModel<SaleLineItem> listRepresentation;
	private JLabel returnedLabel;
	private JLabel totalWithoutTaxLabel;
	private JLabel taxLabel;
	private JLabel totalLabel;
	private JLabel receivedLabel;
	private JLabel saleIDLabel;
	private JLabel saleTimeLabel;
	private JLabel saleDateLabel;
	private JLabel saleEmployeeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaleController saleController = new SaleController();
			saleController.createSale(new Employee("", "", "", "", 1, "", ""));

			SaleReceiptDialog dialog = new SaleReceiptDialog(saleController);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateProductList() {
		SaleLineItemCellRenderer cellRenderer = new SaleLineItemCellRenderer();
		productList.setCellRenderer(cellRenderer);

		listRepresentation = new DefaultListModel<SaleLineItem>();
		ArrayList<SaleLineItem> saleLineItemList = new ArrayList<>();
		saleLineItemList.addAll(Arrays.asList(saleController.getCurrentSale().getSaleLineItems()));

		for (SaleLineItem saleLineItem : saleLineItemList) {
			listRepresentation.addElement(saleLineItem);
		}
		productList.setModel(listRepresentation);
	}

	@SuppressWarnings("deprecation")
	private void fillReceipt() {
		Sale currentSale = saleController.getCurrentSale();
		
		double totalRefund = saleController.getCurrentSale().getRemainingPayment();
		totalRefund = Math.abs(totalRefund);
		returnedLabel.setText(String.format("%.2f", totalRefund));
		
		totalWithoutTaxLabel.setText(String.format("%.2f", currentSale.calculateTotalPrice() * 0.75));
		
		taxLabel.setText(String.format("%.2f", currentSale.calculateTotalPrice() * 0.25));
		
		totalLabel.setText(String.format("%.2f", currentSale.calculateTotalPrice()));
		
		receivedLabel.setText(String.format("%.2f", currentSale.getMoneyReceived()));
		
		saleIDLabel.setText(currentSale.getSaleID());
		
		Date saleDate = currentSale.getSaleDate();		
		saleTimeLabel.setText(saleDate.getHours() + ":" + saleDate.getMinutes());;		
		saleDateLabel.setText((saleDate.getYear() + 1900) + "-" + (saleDate.getMonth() + 1) + "-" + saleDate.getDate());
		
		saleEmployeeLabel.setText(currentSale.getEmployee().getName());
	
	}
	
	public void printButton()
	{
		dispose();
	}
	
	public void cancelButton()
	{
		dispose();
	}

	/**
	 * Create the dialog.
	 */
	public SaleReceiptDialog(SaleController saleController) {
		this.saleController = saleController;
		createGUI();
		updateProductList();
		fillReceipt();
	}

	private void createGUI() {
		setModal(true);
		setBounds(100, 100, 645, 1002);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton printReceiptButton = new JButton("Print");
				printReceiptButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						printButton();
					}
				});
				printReceiptButton.setActionCommand("OK");
				buttonPane.add(printReceiptButton);
				getRootPane().setDefaultButton(printReceiptButton);
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
		{
			JPanel ReceiptTopPane = new JPanel();
			getContentPane().add(ReceiptTopPane, BorderLayout.CENTER);
			GridBagLayout gbl_ReceiptTopPane = new GridBagLayout();
			gbl_ReceiptTopPane.columnWidths = new int[] { 0, 0 };
			gbl_ReceiptTopPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_ReceiptTopPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_ReceiptTopPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
			ReceiptTopPane.setLayout(gbl_ReceiptTopPane);
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 0;
				ReceiptTopPane.add(panel, gbc_panel);
				{
					JLabel lblNewLabel = new JLabel("Vestbjerg Byggecenter A/S");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
					panel.add(lblNewLabel);
				}
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 1;
				ReceiptTopPane.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 20, 0, 0, 0, 0, 20, 0 };
				gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
				panel.setLayout(gbl_panel);
				{
					JLabel lblNewLabel_1 = new JLabel("Sælger");
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
					gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_1.gridx = 1;
					gbc_lblNewLabel_1.gridy = 0;
					panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
				}
				{
					saleEmployeeLabel = new JLabel("New label");
					saleEmployeeLabel.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_saleEmployeeLabel = new GridBagConstraints();
					gbc_saleEmployeeLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_saleEmployeeLabel.insets = new Insets(0, 0, 5, 5);
					gbc_saleEmployeeLabel.gridx = 2;
					gbc_saleEmployeeLabel.gridy = 0;
					panel.add(saleEmployeeLabel, gbc_saleEmployeeLabel);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("Salgs ID");
					lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
					gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_3.gridx = 3;
					gbc_lblNewLabel_3.gridy = 0;
					panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
				}
				{
					saleIDLabel = new JLabel("New label");
					saleIDLabel.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_saleIDLabel = new GridBagConstraints();
					gbc_saleIDLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_saleIDLabel.insets = new Insets(0, 0, 5, 5);
					gbc_saleIDLabel.gridx = 4;
					gbc_saleIDLabel.gridy = 0;
					panel.add(saleIDLabel, gbc_saleIDLabel);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Dato");
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
					gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_2.gridx = 1;
					gbc_lblNewLabel_2.gridy = 1;
					panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
				}
				{
					saleDateLabel = new JLabel("New label");
					saleDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_saleDateLabel = new GridBagConstraints();
					gbc_saleDateLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_saleDateLabel.insets = new Insets(0, 0, 5, 5);
					gbc_saleDateLabel.gridx = 2;
					gbc_saleDateLabel.gridy = 1;
					panel.add(saleDateLabel, gbc_saleDateLabel);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Tidspunkt");
					lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
					gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_4.gridx = 3;
					gbc_lblNewLabel_4.gridy = 1;
					panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
				}
				{
					saleTimeLabel = new JLabel("New label");
					saleTimeLabel.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_saleTimeLabel = new GridBagConstraints();
					gbc_saleTimeLabel.insets = new Insets(0, 0, 5, 5);
					gbc_saleTimeLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_saleTimeLabel.gridx = 4;
					gbc_saleTimeLabel.gridy = 1;
					panel.add(saleTimeLabel, gbc_saleTimeLabel);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 2;
				ReceiptTopPane.add(scrollPane, gbc_scrollPane);
				{
					productList = new JList();
					scrollPane.setViewportView(productList);
				}
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 3;
				ReceiptTopPane.add(panel, gbc_panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[] { 20, 0, 0, 20, 0 };
				gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
				gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
				gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				panel.setLayout(gbl_panel);
				{
					JLabel lblNewLabel_5 = new JLabel("Total ex. moms");
					lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
					gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_5.gridx = 1;
					gbc_lblNewLabel_5.gridy = 0;
					panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
				}
				{
					totalWithoutTaxLabel = new JLabel("New label");
					totalWithoutTaxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
					GridBagConstraints gbc_totalWithoutTaxLabel = new GridBagConstraints();
					gbc_totalWithoutTaxLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_totalWithoutTaxLabel.insets = new Insets(0, 0, 5, 5);
					gbc_totalWithoutTaxLabel.gridx = 2;
					gbc_totalWithoutTaxLabel.gridy = 0;
					panel.add(totalWithoutTaxLabel, gbc_totalWithoutTaxLabel);
				}
				{
					JLabel lblNewLabel_6 = new JLabel("Moms 25 %");
					lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
					gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_6.gridx = 1;
					gbc_lblNewLabel_6.gridy = 1;
					panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
				}
				{
					taxLabel = new JLabel("New label");
					taxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
					GridBagConstraints gbc_taxLabel = new GridBagConstraints();
					gbc_taxLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_taxLabel.insets = new Insets(0, 0, 5, 5);
					gbc_taxLabel.gridx = 2;
					gbc_taxLabel.gridy = 1;
					panel.add(taxLabel, gbc_taxLabel);
				}
				{
					JLabel lblNewLabel_7 = new JLabel("Total");
					lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
					gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_7.gridx = 1;
					gbc_lblNewLabel_7.gridy = 2;
					panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
				}
				{
					totalLabel = new JLabel("New label");
					totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
					GridBagConstraints gbc_totalLabel = new GridBagConstraints();
					gbc_totalLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_totalLabel.insets = new Insets(0, 0, 5, 5);
					gbc_totalLabel.gridx = 2;
					gbc_totalLabel.gridy = 2;
					panel.add(totalLabel, gbc_totalLabel);
				}
				{
					JLabel lblNewLabel_11 = new JLabel("Modtaget");
					lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
					gbc_lblNewLabel_11.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_11.gridx = 1;
					gbc_lblNewLabel_11.gridy = 4;
					panel.add(lblNewLabel_11, gbc_lblNewLabel_11);
				}
				{
					receivedLabel = new JLabel("New label");
					receivedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
					GridBagConstraints gbc_receivedLabel = new GridBagConstraints();
					gbc_receivedLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_receivedLabel.insets = new Insets(0, 0, 5, 5);
					gbc_receivedLabel.gridx = 2;
					gbc_receivedLabel.gridy = 4;
					panel.add(receivedLabel, gbc_receivedLabel);
				}
				{
					JLabel lblNewLabel_13 = new JLabel("Tilbage");
					lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
					GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
					gbc_lblNewLabel_13.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
					gbc_lblNewLabel_13.gridx = 1;
					gbc_lblNewLabel_13.gridy = 5;
					panel.add(lblNewLabel_13, gbc_lblNewLabel_13);
				}
				{
					returnedLabel = new JLabel("New label");
					returnedLabel.setHorizontalAlignment(SwingConstants.RIGHT);
					GridBagConstraints gbc_returnedLabel = new GridBagConstraints();
					gbc_returnedLabel.insets = new Insets(0, 0, 0, 5);
					gbc_returnedLabel.fill = GridBagConstraints.HORIZONTAL;
					gbc_returnedLabel.gridx = 2;
					gbc_returnedLabel.gridy = 5;
					panel.add(returnedLabel, gbc_returnedLabel);
				}
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 4;
				ReceiptTopPane.add(panel, gbc_panel);
				{
					JLabel lblNewLabel_8 = new JLabel("Tak fordi du handlede hos os");
					panel.add(lblNewLabel_8);
				}
			}
		}
	}

}
