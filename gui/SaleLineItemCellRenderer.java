package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet.ColorAttribute;

import model.SaleLineItem;

public class SaleLineItemCellRenderer implements ListCellRenderer<SaleLineItem> {

	@Override
	public Component getListCellRendererComponent(JList<? extends SaleLineItem> list, SaleLineItem value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel productNameLabel = new JLabel(value.getProduct().getName());
		panel.add(productNameLabel);
		
		JLabel productBarcodeLabel = new JLabel(value.getProduct().getBarcode());
		panel.add(productBarcodeLabel);
		
		JLabel amountAndPriceLabel = new JLabel(value.getQuantity() + " x DKK " + String.format("%.2f", value.getProduct().getPrice()));
		amountAndPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		amountAndPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(amountAndPriceLabel);
		
		JLabel totalPriceLabel = new JLabel("DKK " + String.format("%.2f", value.calculateLinePrice()));
		totalPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(totalPriceLabel);
		
		if(isSelected) {
			panel.setBackground(Color.BLUE);
			productNameLabel.setForeground(Color.WHITE);
			productBarcodeLabel.setForeground(Color.WHITE);
			amountAndPriceLabel.setForeground(Color.WHITE);
			
		}
		
	
		return panel;
	}

}
