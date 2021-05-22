package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Constant.SystemConstant;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtPassword;
	private JSeparator separator_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(255, 240, 245));
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		txtUsername.setForeground(new Color(192, 192, 192));
		txtUsername.setText("Enter username");
		txtUsername.setOpaque(false);
		txtUsername.setBounds(73, 142, 310, 30);
		txtUsername.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsername.setText("");
			}
			
		});
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		lblNewLabel_1.setBounds(48, 91, 200, 41);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 128));
		separator.setForeground(new Color(105, 105, 105));
		separator.setBounds(73, 168, 346, 24);
		contentPane.add(separator);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setBounds(48, 213, 200, 41);
		contentPane.add(lblNewLabel_2);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		txtPassword.setBorder(null);
		txtPassword.setOpaque(false);
		txtPassword.setForeground(new Color(192, 192, 192));
		txtPassword.setText("Enter password");
		txtPassword.setBounds(73, 253, 310, 30);
		txtPassword.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText("");
			}
			
		});
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.controlDkShadow);
		separator_1.setBackground(new Color(0, 0, 128));
		separator_1.setBounds(73, 280, 349, 48);
		contentPane.add(separator_1);
		
		btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(289, 346, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(135, 206, 235));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel.setBounds(0, 10, 451, 400);
		lblNewLabel.setIcon(new ImageIcon(SystemConstant.img_background));
		contentPane.add(lblNewLabel);
	}
}
