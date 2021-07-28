package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import BUS.implement.StaffBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Staff;

public class PanelChangeAccountSort extends JPanel {
	private JTextField txtNewUser;
	private JPasswordField txtPass;
	private JPasswordField txtNewPass;
	private JPasswordField txtConfirmPass;
	private JLabel lblNewLabel_2_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lbNotice;
	private StaffBUS staffBus = new StaffBUS();
	boolean checkUser = false;
	boolean checkPass = false;




	
	public PanelChangeAccountSort() {
		setSize(950, 405);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Account");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.ITALIC, 26));
		lblNewLabel.setBounds(217, 34, 223, 41);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fullname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(131, 85, 171, 23);
		add(lblNewLabel_1);
		
		JLabel lbName = new JLabel("");
		lbName.setForeground(new Color(0, 51, 153));
		lbName.setBounds(328, 83, 522, 25);
		lbName.setText(SystemConstant.staff.getFullname());
		add(lbName);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(131, 131, 162, 25);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setBounds(328, 131, 522, 25);
		lblNewLabel_3.setText(SystemConstant.staff.getUsername());
		add(lblNewLabel_3);
		
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(900, 131, 40, 25);
		btnNewButton_1.setIcon(new ImageIcon(SystemConstant.img_edit2));
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2_1.setEnabled(false);
				txtNewUser.setEnabled(false);
				btnNewButton_1.setEnabled(false);
				btnNewButton.setEnabled(true);

			}
			
		});
		add(btnNewButton_1);
		
		txtNewUser = new JTextField();
		txtNewUser.setForeground(new Color(0, 51, 102));
		txtNewUser.setBounds(328, 171, 522, 25);
		add(txtNewUser);
		txtNewUser.setEnabled(false);
		txtNewUser.setColumns(10);
		
		lblNewLabel_2_1 = new JLabel("New Username");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setEnabled(false);
		lblNewLabel_2_1.setBounds(131, 171, 166, 25);
		add(lblNewLabel_2_1);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(900, 131, 40, 25);
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_edit2));
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_2_1.setEnabled(true);
				txtNewUser.setEnabled(true);
				btnNewButton.setEnabled(false);
				btnNewButton_1.setEnabled(true);

			}

		});
		add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(131, 211, 152, 25);
		add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtPass.getText().equals(SystemConstant.staff.getPassword())) {
					lblNewLabel_2_1_1.setEnabled(true);
					lblNewLabel_2_1_1_1.setEnabled(true);
					txtNewPass.setEnabled(true);
					txtConfirmPass.setEnabled(true);
				} else 
					{lbNotice.setText("Password is not right");
					txtPass.setText("");
			}
			}
		});
		btnNewButton_2.setBounds(900, 211, 40, 25);
		btnNewButton_2.setIcon(new ImageIcon(SystemConstant.img_edit2));
		add(btnNewButton_2);
		
		lblNewLabel_2_1_1 = new JLabel("New Password");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(131, 251, 194, 25);
		lblNewLabel_2_1_1.setEnabled(false);

		add(lblNewLabel_2_1_1);
		
		lblNewLabel_2_1_1_1 = new JLabel("Confirm Password");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_1.setBounds(131, 291, 185, 25);
		lblNewLabel_2_1_1_1.setEnabled(false);
		add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_3 = new JButton("Save Change\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNewPass.getText().length()<1 || txtConfirmPass.getText().length()<1) {
					lbNotice.setText("Please enter new password or confirm password ");
				} 
				else 
				{
				if (txtNewPass.getText().equals(txtConfirmPass.getText())) {
					
					Staff s = SystemConstant.staff;
					s.setPassword(txtConfirmPass.getText());
					if (txtNewUser.getText().length()>1)
					{
						String st = txtNewUser.getText();
						if (DataChecked.checkUsername(st))
						{
					s.setUsername(st);
					staffBus.update(s);
					lbNotice.setText("");
					JOptionPane.showMessageDialog(null, "You update account sucessful. Please enter system again");
				
						
						} else{
							lbNotice.setText("Username is existed. Please enter new username");

						}
						}} else
				
				{
					lbNotice.setText("NewPassword is not compatible ConfirmPassword. Please check again!");
				}
					
				}
			}
		});
		btnNewButton_3.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		btnNewButton_3.setBounds(760, 40, 130, 35);
		add(btnNewButton_3);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(new Color(0, 51, 102));
		txtPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotice.setText("");
			}
		});
		txtPass.setBounds(328, 211, 522, 25);
		add(txtPass);
		
		txtNewPass = new JPasswordField();
		txtNewPass.setForeground(new Color(0, 51, 102));
		txtNewPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotice.setText("");
			}
		});
		txtNewPass.setBounds(328, 251, 522, 25);
		txtNewPass.setEnabled(false);;
		add(txtNewPass);
		
		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setForeground(new Color(0, 51, 102));
		txtConfirmPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			lbNotice.setText("");
			}
		});
		txtConfirmPass.setBounds(328, 291, 522, 25);
		txtConfirmPass.setEnabled(false);
		add(txtConfirmPass);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setBounds(900, 211, 40, 25);
		btnNewButton_2_1.setIcon(new ImageIcon(SystemConstant.img_edit2));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
		});
		add(btnNewButton_2_1);
		
		lbNotice = new JLabel("");
		lbNotice.setForeground(new Color(255, 0, 0));
		lbNotice.setBounds(131, 333, 560, 25);
		add(lbNotice);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(900, 40, 40, 35);
		btnNewButton_4.setIcon(new ImageIcon(SystemConstant.img_exit3));
		add(btnNewButton_4);
	}
	
	
}
