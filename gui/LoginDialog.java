package gui;

import java.awt.BorderLayout;

import gui.MainMenuFrame;
import model.Employee;
import control.PersonController;
import control.SaleController;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField employeeIDField;
	private JPasswordField passwordField;
	private MainMenuFrame mainMenu;
	private PersonController personController;
	private JLabel errorLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MainMenuFrame dialog = new MainMenuFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loginButton() {
		PersonController personController = new PersonController();
		Employee employee = personController.findEmployeeByEmployeeID(employeeIDField.getText());
		if(employee != null){
			mainMenu.setCurrentEmployee(employee);
			dispose();
		}else {
			errorLabel.setText("Denne medarbejder findes ikke i systemet. Pr�v igen. ");
		}
	}

	private void cancelButton() {
		dispose();
		mainMenu.dispose();
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog(MainMenuFrame mainMenu) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		createGUI();
		this.mainMenu = mainMenu;

	}

	private void createGUI() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JLabel headlineLabel = new JLabel("Medarbejder Login");
		headlineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headlineLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPanel.add(headlineLabel, BorderLayout.NORTH);

		JPanel bodyPanel = new JPanel();
		contentPanel.add(bodyPanel, BorderLayout.CENTER);
		GridBagLayout gbl_bodyPanel = new GridBagLayout();
		gbl_bodyPanel.columnWidths = new int[] { 20, 0, 0, 20, 0 };
		gbl_bodyPanel.rowHeights = new int[] { 20, 0, 20, 0, 0, 0 };
		gbl_bodyPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_bodyPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		bodyPanel.setLayout(gbl_bodyPanel);

		JLabel employeeIDLabel = new JLabel("Medarbejder ID:");
		GridBagConstraints gbc_employeeIDLabel = new GridBagConstraints();
		gbc_employeeIDLabel.anchor = GridBagConstraints.EAST;
		gbc_employeeIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_employeeIDLabel.gridx = 1;
		gbc_employeeIDLabel.gridy = 1;
		bodyPanel.add(employeeIDLabel, gbc_employeeIDLabel);

		employeeIDField = new JTextField();
		employeeIDField.setColumns(10);
		GridBagConstraints gbc_employeeIDField = new GridBagConstraints();
		gbc_employeeIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_employeeIDField.insets = new Insets(0, 0, 5, 5);
		gbc_employeeIDField.gridx = 2;
		gbc_employeeIDField.gridy = 1;
		bodyPanel.add(employeeIDField, gbc_employeeIDField);

		JLabel passwordLabel = new JLabel("Kodeord:");
		passwordLabel.setEnabled(false);
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 1;
		gbc_passwordLabel.gridy = 3;
		bodyPanel.add(passwordLabel, gbc_passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setEnabled(false);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		bodyPanel.add(passwordField, gbc_passwordField);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.gridwidth = 4;
		gbc_errorLabel.insets = new Insets(0, 0, 0, 5);
		gbc_errorLabel.gridx = 0;
		gbc_errorLabel.gridy = 4;
		bodyPanel.add(errorLabel, gbc_errorLabel);

		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 20, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 0;
		panel_1.add(buttonPanel, gbc_buttonPanel);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton();
			}
		});
		buttonPanel.add(btnNewButton);

		JButton btnCacel = new JButton("Cancel");
		btnCacel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelButton();
			}
		});
		buttonPanel.add(btnCacel);

	}

}
