package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BUS.implement.StaffBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Staff;

public class PanelTaiKhoan extends JPanel {
	private JTextField txtname;
	private JTextField txtdateofbirth;
	private JTextField txtaddress;
	private JTextField txticard;
	private JTextField txtwork;
	private JLabel lblNewLabel_5;

	
	private StaffBUS staffBus = new StaffBUS();

	
	public PanelTaiKhoan() {
		setBackground(new Color(230, 230, 250));
		setSize(763, 405);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(10, 10, 216, 385);
		add(panel);
		panel.setLayout(null);
		
		JLabel Role = new JLabel("");
		Role.setForeground(new Color(204, 51, 153));
		Role.setHorizontalAlignment(SwingConstants.CENTER);
		Role.setBounds(10, 247, 196, 33);
		Role.setText(SystemConstant.staff.getRole().getName());
		panel.add(Role);
		
		JLabel email = new JLabel("New label");
		email.setForeground(new Color(204, 0, 204));
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setBounds(10, 290, 196, 33);
		email.setText(SystemConstant.staff.getEmail());
		panel.add(email);
		
		JLabel Phone = new JLabel("New label");
		Phone.setForeground(new Color(204, 0, 204));
		Phone.setHorizontalAlignment(SwingConstants.CENTER);
		Phone.setBounds(10, 333, 196, 24);
		Phone.setText(SystemConstant.staff.getPhone());
		panel.add(Phone);
		
		JLabel img = new JLabel("");
		img.setBounds(10, 10, 196, 164);
		img.setIcon(new ImageIcon(SystemConstant.img_avatar1));
		panel.add(img);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 240, 245));
		panel_1.setBounds(236, 72, 517, 323);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fullname");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 30, 75, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DateOfBirth");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 96, 93, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 153, 75, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Identity Card");
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 209, 108, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DateStartOfWork");
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 266, 137, 13);
		panel_1.add(lblNewLabel_4);
		
		txtname = new JTextField();
		txtname.setBounds(227, 31, 269, 22);
		txtname.setText(SystemConstant.staff.getFullname());
		panel_1.add(txtname);
		txtname.setColumns(10);
		
		txtdateofbirth = new JTextField();
		txtdateofbirth.setBounds(227, 91, 269, 22);
		txtdateofbirth.setText(String.valueOf(SystemConstant.staff.getBirthday()));
		panel_1.add(txtdateofbirth);
		txtdateofbirth.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(227, 148, 269, 22);
		txtaddress.setText(SystemConstant.staff.getAddress());
		panel_1.add(txtaddress);
		txtaddress.setColumns(10);
		
		txticard = new JTextField();
		txticard.setBounds(227, 204, 269, 22);
		txticard.setText(SystemConstant.staff.getiCard());
		panel_1.add(txticard);
		txticard.setColumns(10);
		
		txtwork = new JTextField();
		txtwork.setBounds(228, 261, 268, 22);
		txtwork.setText(String.valueOf(SystemConstant.staff.getDateStartWork()));
		panel_1.add(txtwork);
		txtwork.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(236, 10, 517, 49);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Edit = new JLabel("");
		Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Staff s = SystemConstant.staff;
				
				if (txticard.getText().length()==0 || (txticard.getText().length()>0 && DataChecked.checkICard(txticard.getText()))) {
				s.setiCard(txticard.getText());
				s.setAddress(txtaddress.getText());
				staffBus.update(s);
				lblNewLabel_5.setText("Bạn cập nhập thông tin thành công!");
				}  else 
					lblNewLabel_5.setText("Bạn cập nhập thông tin không thành công!");

					
				
				
			}
		});
		Edit.setToolTipText("Ch\u1EC9nh s\u1EEDa th\u00F4ng tin c\u00E1 nh\u00E2n");
		Edit.setBounds(383, 10, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit1));
		panel_2.add(Edit);
		
		JLabel Exit = new JLabel("");
		Exit.setToolTipText("Tho\u00E1t");
		Exit.setBounds(446, 10, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit3));
		panel_2.add(Exit);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(204, 0, 204));
		lblNewLabel_5.setBounds(10, 10, 350, 29);
		panel_2.add(lblNewLabel_5);

	}
	
	
}
