package gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.SaleLineItem;

public class SaleLineItemCellRenderer implements ListCellRenderer<SaleLineItem> {

	@Override
	public Component getListCellRendererComponent(JList<? extends SaleLineItem> list, SaleLineItem value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		JLabel text = new JLabel();
		
		text.setText(value.getProduct().getName() + " x " + value.getQuantity()); 
		
		
	
		return text;
	}

}
