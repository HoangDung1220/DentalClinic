package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;

import BUS.implement.RoleBUS;
import BUS.implement.StaffBUS;
import DTO.Role;
import DTO.Staff;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementStaff extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtICard;
	private JTextField txtAddress;

	private JLabel lblNewLabel_2;
	private JRadioButton Female; 
	private JRadioButton Male ;
	private JDateChooser dateOfWork;
    private	JDateChooser dateOfBirth;
	private JComboBox<Role> comboRole;




	private JTable table;
	RoleBUS role = new RoleBUS();
	DefaultTableModel defaultTable = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	StaffBUS staff = new StaffBUS();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementStaff frame = new ManagementStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagementStaff() {
		showTable(staff.findAll());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 607);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 22, 316, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seeek_By");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 34, 108, 13);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ID_Staff");
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton.setBounds(15, 68, 103, 21);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Name_Staff");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_1.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_1.setBounds(174, 68, 103, 21);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Char");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 131, 45, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new CompoundBorder());
		textField.setBounds(107, 128, 140, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton Search = new JButton("SEARCH");
		Search.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(96, 189, 85, 21);
		panel.add(Search);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(349, 22, 743, 298);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("ID_Staff");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(21, 32, 82, 13);
		panel_1.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(113, 29, 156, 19);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fullname");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(21, 82, 59, 13);
		panel_1.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setBounds(113, 79, 156, 19);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblDateofbirth = new JLabel("DateOfBirth");
		lblDateofbirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateofbirth.setBounds(21, 139, 82, 13);
		panel_1.add(lblDateofbirth);
		
		dateOfBirth = new JDateChooser();
		dateOfBirth.setBounds(113, 133, 156, 19);
		panel_1.add(dateOfBirth);
		
		JLabel lblNewLabel_4 = new JLabel("Phonenumber");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(21, 192, 96, 13);
		panel_1.add(lblNewLabel_4);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(113, 189, 156, 19);
		panel_1.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(279, 32, 45, 13);
		panel_1.add(lblNewLabel_5);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(362, 29, 145, 19);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("I_Card ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(279, 82, 72, 13);
		panel_1.add(lblNewLabel_6);
		
		txtICard = new JTextField();
		txtICard.setBounds(362, 79, 145, 19);
		panel_1.add(txtICard);
		txtICard.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DateOfWork");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(279, 139, 103, 13);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Adress");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(279, 192, 45, 13);
		panel_1.add(lblNewLabel_8);
		
	    Male = new JRadioButton("Male");
		Male.setBackground(SystemColor.activeCaption);
		Male.setFont(new Font("Tahoma", Font.BOLD, 13));
		Male.setBounds(602, 28, 103, 21);
		panel_1.add(Male);
		
		Female = new JRadioButton("Female");
		Female.setFont(new Font("Tahoma", Font.BOLD, 13));
		Female.setBackground(SystemColor.activeCaption);
		Female.setBounds(602, 78, 103, 21);
		panel_1.add(Female);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(351, 189, 354, 19);
		panel_1.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(527, 32, 69, 13);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Role");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(527, 139, 45, 13);
		panel_1.add(lblNewLabel_10);
		
		comboRole = new JComboBox<Role>();
		for (Role i : role.findAll() ) {
			comboRole.addItem(i);
		}
		comboRole.setBounds(602, 135, 103, 21);
		panel_1.add(comboRole);
		
	    dateOfWork = new JDateChooser();
		dateOfWork.setBounds(362, 133, 145, 19);
		panel_1.add(dateOfWork);
		
		JButton Save = new JButton("SAVE");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				staff.insert(GetDataToGui());
			    showTable(staff.findAll());

			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(62, 250, 85, 21);
		panel_1.add(Save);
		
		JButton Edit = new JButton("EDIT");
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.setBounds(239, 250, 85, 21);
		panel_1.add(Edit);
		
		JButton Delete = new JButton("DELETE");
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(426, 250, 96, 21);
		panel_1.add(Delete);
		
		JButton Exit = new JButton("EXIT ");
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(599, 250, 85, 21);
		panel_1.add(Exit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 364, 1069, 185);
		contentPane.add(panel_2);
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1049, 155);
		panel_2.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
	}
	
	public void showTable(List<Staff> list) {
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Fullname","Gender","Birthday","Phone","Address","Identified Card","Email","Date_Start_Work","Role"
		});
		for (Staff i :list) {
			Object[] row = new Object[] {
					i.getId(),i.getFullname(),i.getGender(),i.getBirthday(),i.getPhone(),i.getAddress(),i.getiCard(),
					i.getEmail(),i.getDateStartWork(),i.getRole().getName()
			};
			defaultTable.addRow(row);
		}
	}
	public Staff GetDataToGui() {
		Date birthday=null,work=null;
		try {
			 birthday = sdf.parse(sdf.format(dateOfBirth.getDate()));
			 work = sdf.parse(sdf.format(dateOfWork.getDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Staff s= new Staff();
		s.setFullname(txtName.getText());
		s.setGender(Male.isSelected());
		s.setAddress(txtAddress.getText());
	    s.setBirthday(birthday);

	    s.setDateStartWork(work);
	    s.setEmail(txtEmail.getText());
	    s.setPhone(txtPhone.getText());
	    s.setiCard(txtICard.getText());
	    s.setIdRole(((Role)comboRole.getSelectedItem()).getId());
	    
		
		return s;
	}
}
