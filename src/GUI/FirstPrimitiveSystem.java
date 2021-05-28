package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Constant.SystemConstant;

public class FirstPrimitiveSystem extends JFrame {

	private JPanel contentPane;
	private JTextField txtSignIn;
	private JTextArea txtIntro;
	private JSeparator separator;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPrimitiveSystem frame = new FirstPrimitiveSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FirstPrimitiveSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 215, 0));
		panel.setBorder(new TitledBorder(null, "Introduction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 620, 428);
		contentPane.add(panel);
		panel.setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(508, 187, 80, 13);
		panel.add(separator);
		
		txtIntro = new JTextArea();
		txtIntro.setForeground(new Color(0, 0, 0));
		txtIntro.setBackground(SystemColor.activeCaption);
		txtIntro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtIntro.setBounds(10, 193, 600, 225);
		txtIntro.setText(SystemConstant.introduction.toString());
		panel.add(txtIntro);
		
		txtSignIn = new JTextField();
		txtSignIn.setForeground(new Color(0, 0, 205));
		txtSignIn.setBounds(518, 164, 70, 19);
		panel.add(txtSignIn);
		txtSignIn.setBorder(null);
		txtSignIn.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 18));
		txtSignIn.setText("Sign in");
		txtSignIn.setBackground(SystemColor.activeCaption);
		txtSignIn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
			
		});
		txtSignIn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 21, 600, 143);
		lblNewLabel.setIcon(new ImageIcon(SystemConstant.img_loginfirst));
		panel.add(lblNewLabel);
	}
}
