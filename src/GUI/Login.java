package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import BUS.implement.StaffBUS;
import Constant.SystemConstant;
import DTO.Staff;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JSeparator separator_1;
	private JButton btnNewButton;
	private StaffBUS staff = new StaffBUS();
	private JPasswordField txtPassword;
	private JLabel lblNewLabel ;
	private JLabel lbnotice;


	
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

	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(255, 240, 245));
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		txtUsername.setForeground(SystemColor.controlDkShadow);
		txtUsername.setText("Enter username");
		txtUsername.setOpaque(false);
		txtUsername.setBounds(73, 142, 310, 30);
		txtUsername.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsername.setText("");
				lbnotice.setText("");

				
			}
			
		});
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(new Color(211, 211, 211));
		txtPassword.setEchoChar('*');
		txtPassword.setBorder(null);
		txtPassword.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		txtPassword.setForeground(new Color(230, 230, 250));
		txtPassword.setOpaque(false);
		txtPassword.setBounds(73, 253, 346, 24);
		txtPassword.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setText("");
				lbnotice.setText("");
			}
			
		});
		
		txtPassword.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER)
				authen();
			}

		});
		
		lbnotice = new JLabel("");
		lbnotice.setInheritsPopupMenu(false);
		lbnotice.setForeground(new Color(255, 255, 0));
		lbnotice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbnotice.setBounds(70, 303, 349, 25);
		contentPane.add(lbnotice);
		
		lblNewLabel = new JLabel("Enter the password");
		lblNewLabel.setForeground(UIManager.getColor("CheckBox.highlight"));
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lblNewLabel.setBounds(73, 253, 346, 29);
		contentPane.add(lblNewLabel);
		contentPane.add(txtPassword);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.controlDkShadow);
		separator_1.setBackground(new Color(0, 0, 128));
		separator_1.setBounds(73, 280, 310, 48);
		contentPane.add(separator_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setBounds(48, 213, 200, 41);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 128));
		separator.setForeground(new Color(105, 105, 105));
		separator.setBounds(73, 168, 323, 24);
		contentPane.add(separator);
		
		lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 17));
		lblNewLabel_1.setBounds(48, 91, 200, 41);
		contentPane.add(lblNewLabel_1);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		btnNewButton = new JButton("Sign in");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(new LineBorder(new Color(230, 230, 250), 2, true));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				authen();
			}	
		});
		
		btnNewButton.setBounds(298, 338, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(70, 31, 266, 41);
		contentPane.add(lblNewLabel_3);
		
		JLabel Enter = new JLabel("");
		Enter.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		Enter.setForeground(new Color(230, 230, 250));
		Enter.setBorder(new LineBorder(new Color(240, 248, 255), 1, true));
		Enter.setBounds(0, 10, 412, 400);
		Enter.setIcon(new ImageIcon(SystemConstant.img_background));
		contentPane.add(Enter);

	}
	
	public void authen() {
		String user = txtUsername.getText();
		String pass = txtPassword.getText();
		Staff s = staff.searchByUserNameAndPassword(user, pass);
		SystemConstant.staff = s;
		if (s!=null) {
		MainSystem frame = new MainSystem(SystemConstant.staff);
		frame.setVisible(true);
		dispose();
		} else 
		{
			lbnotice.setText("Account don't exits. Please enter account again!!");
			txtPassword.setText("");
			txtUsername.setText("");
			
		}
	}
}
