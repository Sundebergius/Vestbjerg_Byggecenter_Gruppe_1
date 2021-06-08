package gui;

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
import javax.swing.JList;

public class ProductWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStregkode;
	private JTextField txtAntal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductWindow dialog = new ProductWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductWindow() {
		setTitle("Vare vindue");
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
			JLabel lblNewLabel = new JLabel("Stregkode:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtStregkode = new JTextField();
			GridBagConstraints gbc_txtStregkode = new GridBagConstraints();
			gbc_txtStregkode.insets = new Insets(0, 0, 5, 5);
			gbc_txtStregkode.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStregkode.gridx = 1;
			gbc_txtStregkode.gridy = 1;
			contentPanel.add(txtStregkode, gbc_txtStregkode);
			txtStregkode.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("S\u00F8g");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 1;
			contentPanel.add(btnNewButton, gbc_btnNewButton);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Antal:");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 2;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			txtAntal = new JTextField();
			GridBagConstraints gbc_txtAntal = new GridBagConstraints();
			gbc_txtAntal.insets = new Insets(0, 0, 5, 5);
			gbc_txtAntal.anchor = GridBagConstraints.ABOVE_BASELINE;
			gbc_txtAntal.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAntal.gridx = 1;
			gbc_txtAntal.gridy = 2;
			contentPanel.add(txtAntal, gbc_txtAntal);
			txtAntal.setColumns(10);
		}
		{
			JList list = new JList();
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 0, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 1;
			gbc_list.gridy = 3;
			contentPanel.add(list, gbc_list);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Tilf\u00F8j vare");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("F\u00E6rdig");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
