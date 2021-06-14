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
	private JLabel employeeLabel;
	private Employee currentEmployee;

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
		LoginDialog loginDialog = new LoginDialog(this);
		loginDialog.setVisible(true);	

	}
	
	public void setCurrentEmployee(Employee employee)
	{
		currentEmployee = employee;
		employeeLabel.setText(currentEmployee.getName());
		setVisible(true);
	}
	
	private void startSaleButton() {
		CreateSaleFrame createSaleFrame = new CreateSaleFrame(currentEmployee);
		createSaleFrame.setVisible(true);
	}
	
	private void logoutButton() {
		currentEmployee = null;
		setVisible(false);
		LoginDialog loginDialog = new LoginDialog(this);
		loginDialog.setVisible(true);
		
	}
		

	private void createGUI() {
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

		JButton createSaleButton = new JButton("Opret et salg");
		createSaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSaleButton();
			}

		});
		buttonPanel.add(createSaleButton);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutButton();
			}
		});
		buttonPanel.add(logoutButton);

		JLabel mainMenuLabel = new JLabel("Main Menu");
		mainMenuLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		mainMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mainMenuLabel, BorderLayout.NORTH);

		JPanel bodyPanel = new JPanel();
		contentPane.add(bodyPanel, BorderLayout.CENTER);
		GridBagLayout gbl_bodyPanel = new GridBagLayout();
		gbl_bodyPanel.columnWidths = new int[] { 0, 28, 0, 439, 0, 0 };
		gbl_bodyPanel.rowHeights = new int[] { 30, 30, 27, 30, 30, 30, 0, 0 };
		gbl_bodyPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_bodyPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		bodyPanel.setLayout(gbl_bodyPanel);

		JPanel welcomePanel = new JPanel();
		GridBagConstraints gbc_welcomePanel = new GridBagConstraints();
		gbc_welcomePanel.gridwidth = 5;
		gbc_welcomePanel.insets = new Insets(0, 0, 5, 0);
		gbc_welcomePanel.fill = GridBagConstraints.BOTH;
		gbc_welcomePanel.gridx = 0;
		gbc_welcomePanel.gridy = 2;
		bodyPanel.add(welcomePanel, gbc_welcomePanel);

		JLabel welcomeLabel = new JLabel("Velkommen til Vestbjerg Byggecenter A/S");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		welcomePanel.add(welcomeLabel);

		JPanel guidePanel = new JPanel();
		GridBagConstraints gbc_guidePanel = new GridBagConstraints();
		gbc_guidePanel.gridwidth = 4;
		gbc_guidePanel.insets = new Insets(0, 0, 5, 5);
		gbc_guidePanel.fill = GridBagConstraints.BOTH;
		gbc_guidePanel.gridx = 0;
		gbc_guidePanel.gridy = 4;
		bodyPanel.add(guidePanel, gbc_guidePanel);
		
		JLabel employeeInfoLabel = new JLabel("Du er logget ind som: ");
		employeeInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		guidePanel.add(employeeInfoLabel);
				
				employeeLabel = new JLabel("");
				employeeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
				GridBagConstraints gbc_employeeLabel = new GridBagConstraints();
				gbc_employeeLabel.insets = new Insets(0, 0, 5, 0);
				gbc_employeeLabel.gridx = 4;
				gbc_employeeLabel.gridy = 4;
				bodyPanel.add(employeeLabel, gbc_employeeLabel);
		
				JLabel guideLabel = new JLabel(
						"P\u00E5begynd et nyt salg ved at trykke p\u00E5 \"Opret et salg\" nedenunder. ");
				GridBagConstraints gbc_guideLabel = new GridBagConstraints();
				gbc_guideLabel.gridwidth = 5;
				gbc_guideLabel.gridx = 0;
				gbc_guideLabel.gridy = 6;
				bodyPanel.add(guideLabel, gbc_guideLabel);
				guideLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	}

	
}
