package gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.SaleController;
import gui.LoginDialog;
import model.Employee;

public class MainMenuFrame extends JFrame {

	private JPanel contentPane;
	private Employee currentEmployee;
	private JLabel employeeLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuFrame frame = new MainMenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenuFrame() {
		new TryMe();
		createGUI();
		startLoginDialog();

	}

	/*
	 * method to open main menu frame by using setVisiable, and set it to true.
	 */
	public void openMainMenuFrame() {
		setVisible(true);
	}

	/*
	 * A set method to show the employee
	 */
	public void setCurrentEmployee(Employee employee) {
		currentEmployee = employee;
		employeeLabel.setText(currentEmployee.getName());
		setVisible(true);
	}

	/*
	 * method shows a new window
	 */
	private void startLoginDialog() {
		currentEmployee = null;
		setVisible(false);
		LoginDialog loginDialog = new LoginDialog();
		loginDialog.setVisible(true);

		currentEmployee = loginDialog.getLoginEmployee();

		if (currentEmployee == null) {
			dispose();
		}
	}

	/*
	 * Begins the create sale process and opens a CreateSaleFrame
	 */

	private void startSale() {
		CreateSaleFrame createSaleFrame = new CreateSaleFrame(currentEmployee, this);
		createSaleFrame.setVisible(true);
		setVisible(false);
	}

	/*
	 * Gets run when the logout button is pressed
	 */
	private void logoutButton() {

		startLoginDialog();
	}

	/*
	 * Gets run when the start sale button is pressed
	 */
	private void startSaleButton() {
		startSale();
	}

	private void createGUI() {
		setTitle("Hovedmenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel buttonPanel = new JPanel();
		FlowLayout fl_buttonPanel = (FlowLayout) buttonPanel.getLayout();
		fl_buttonPanel.setAlignment(FlowLayout.RIGHT);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton createSaleButton = new JButton("Opret salg");
		createSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSaleButton();
			}

		});

		JButton createProductButton = new JButton("Opret et produkt");
		createProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateProductDialog createProductDialog = new CreateProductDialog();
				createProductDialog.setVisible(true);
			}
		});
		buttonPanel.add(createProductButton);
		buttonPanel.add(createSaleButton);

		JPanel bodyPanel = new JPanel();
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		GridBagLayout gbl_bodyPanel = new GridBagLayout();
		gbl_bodyPanel.columnWidths = new int[] { 0, 28, 0, 439, 0, 0, 0 };
		gbl_bodyPanel.rowHeights = new int[] { 30, 30, 27, 30, 98, 0, 0 };
		gbl_bodyPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_bodyPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		bodyPanel.setLayout(gbl_bodyPanel);

		JPanel guidePanel = new JPanel();
		GridBagConstraints gbc_guidePanel = new GridBagConstraints();
		gbc_guidePanel.insets = new Insets(0, 0, 5, 5);
		gbc_guidePanel.fill = GridBagConstraints.BOTH;
		gbc_guidePanel.gridx = 3;
		gbc_guidePanel.gridy = 0;
		bodyPanel.add(guidePanel, gbc_guidePanel);

		JLabel employeeInfoLabel = new JLabel("Du er logget ind som: ");
		employeeInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		guidePanel.add(employeeInfoLabel);

		employeeLabel = new JLabel("");
		employeeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_employeeLabel = new GridBagConstraints();
		gbc_employeeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_employeeLabel.gridx = 4;
		gbc_employeeLabel.gridy = 0;
		bodyPanel.add(employeeLabel, gbc_employeeLabel);

		JButton logoutButton = new JButton("Log af");
		GridBagConstraints gbc_logoutButton = new GridBagConstraints();
		gbc_logoutButton.insets = new Insets(0, 0, 5, 0);
		gbc_logoutButton.gridx = 5;
		gbc_logoutButton.gridy = 0;
		bodyPanel.add(logoutButton, gbc_logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutButton();
			}
		});

		JPanel welcomePanel = new JPanel();
		GridBagConstraints gbc_welcomePanel = new GridBagConstraints();
		gbc_welcomePanel.gridwidth = 6;
		gbc_welcomePanel.insets = new Insets(0, 0, 5, 0);
		gbc_welcomePanel.fill = GridBagConstraints.BOTH;
		gbc_welcomePanel.gridx = 0;
		gbc_welcomePanel.gridy = 2;
		bodyPanel.add(welcomePanel, gbc_welcomePanel);

		JLabel welcomeLabel = new JLabel("Velkommen til Vestbjerg Byggecenter A/S");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		welcomePanel.add(welcomeLabel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 9;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		bodyPanel.add(panel, gbc_panel);

		JPanel logoVestbjergPanel = new JPanel();
		panel.add(logoVestbjergPanel);
	}

}
