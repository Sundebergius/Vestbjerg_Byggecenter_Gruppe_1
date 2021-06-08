package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Delivery extends JDialog {
	private final JButton closeButton = new JButton("Luk");
	private JTextField addressField;
	private JTextField nameField;
	private JTextField postalField;
	private JTextField cityField;
	private JPanel panel;
	private JButton addButton;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Delivery dialog = new Delivery();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Delivery() {
		setTitle("Tilf\u00F8j leverings addresse");
		setBounds(100, 100, 395, 257);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		addButton = new JButton("Tilf\u00F8j");
		panel.add(addButton);
		closeButton.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(closeButton);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {35, 127, 120, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Navn :             ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.anchor = GridBagConstraints.SOUTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 0;
		panel_1.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Adresse :          ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.anchor = GridBagConstraints.SOUTH;
		gbc_addressField.insets = new Insets(0, 0, 5, 5);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 2;
		gbc_addressField.gridy = 1;
		panel_1.add(addressField, gbc_addressField);
		addressField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Postnummer :   ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		postalField = new JTextField();
		GridBagConstraints gbc_postalField = new GridBagConstraints();
		gbc_postalField.anchor = GridBagConstraints.SOUTH;
		gbc_postalField.insets = new Insets(0, 0, 5, 5);
		gbc_postalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_postalField.gridx = 2;
		gbc_postalField.gridy = 2;
		panel_1.add(postalField, gbc_postalField);
		postalField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("By :                   ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		cityField = new JTextField();
		GridBagConstraints gbc_cityField = new GridBagConstraints();
		gbc_cityField.anchor = GridBagConstraints.SOUTH;
		gbc_cityField.insets = new Insets(0, 0, 0, 5);
		gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cityField.gridx = 2;
		gbc_cityField.gridy = 3;
		panel_1.add(cityField, gbc_cityField);
		cityField.setColumns(10);
	}

}
