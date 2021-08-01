package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Constant.SystemConstant;

public class FirstPrimitiveSystem extends JFrame {

	private JPanel contentPane;
	private JTextArea txtIntro;

	
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
		setBounds(100, 100, 656, 482);
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
		
		txtIntro = new JTextArea();
		txtIntro.setForeground(new Color(0, 0, 0));
		txtIntro.setBackground(SystemColor.activeCaption);
		txtIntro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtIntro.setBounds(10, 203, 600, 225);
		txtIntro.setText(SystemConstant.introduction.toString());
		panel.add(txtIntro);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 21, 600, 143);
		lblNewLabel.setIcon(new ImageIcon(SystemConstant.img_loginfirst));
		panel.add(lblNewLabel);
		
		JButton txtSignIn = new JButton("Sign in");
		txtSignIn.setBorder(null);
		txtSignIn.setBackground(new Color(153, 204, 255));
		txtSignIn.setForeground(new Color(0, 51, 153));
		txtSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		txtSignIn.setOpaque(false);
		txtSignIn.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		txtSignIn.setBounds(497, 174, 85, 21);
		panel.add(txtSignIn);
	}
}
