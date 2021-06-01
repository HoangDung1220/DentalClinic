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
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.implement.RoleBUS;
import BUS.implement.StaffBUS;
import Constant.SystemConstant;
import DTO.Role;
import DTO.Staff;

public class ManagementStaff extends JFrame {

	private JPanel contentPane;
	private JTextField txtChar;
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
		lblNewLabel.setBounds(10, 26, 108, 21);
		panel.add(lblNewLabel);
		
		JRadioButton ID_Staff = new JRadioButton("ID_Staff");
		ID_Staff.setBackground(SystemColor.activeCaption);
		ID_Staff.setFont(new Font("Tahoma", Font.BOLD, 13));
		ID_Staff.setBounds(15, 68, 103, 21);
		panel.add(ID_Staff);
		
		JRadioButton NameStaff = new JRadioButton("Name_Staff");
		NameStaff.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameStaff.setBackground(SystemColor.activeCaption);
		NameStaff.setBounds(174, 68, 103, 21);
		panel.add(NameStaff);
		
		JLabel lblNewLabel_1 = new JLabel("Char");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 131, 45, 13);
		panel.add(lblNewLabel_1);
		
		txtChar = new JTextField();
		txtChar.setBorder(new CompoundBorder());
		txtChar.setBounds(107, 128, 140, 19);
		panel.add(txtChar);
		txtChar.setColumns(10);
		
		JButton Search = new JButton("");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		Search.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(140, 191, 35, 35);
		Search.setIcon(new ImageIcon(SystemConstant.img_search1));
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
		txtID.setEditable(false);
		txtID.setOpaque(false);
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
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(279, 192, 72, 13);
		panel_1.add(lblNewLabel_8);
		
	    Male = new JRadioButton("Male");
		Male.setBackground(SystemColor.activeCaption);
		Male.setFont(new Font("Tahoma", Font.BOLD, 13));
		Male.setBounds(602, 28, 103, 21);
		Male.setSelected(true);
		panel_1.add(Male);
		
		Female = new JRadioButton("Female");
		Female.setFont(new Font("Tahoma", Font.BOLD, 13));
		Female.setBackground(SystemColor.activeCaption);
		Female.setBounds(602, 78, 103, 21);
		panel_1.add(Female);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(Male);
		bg.add(Female);
		
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
		
		
		JButton Save = new JButton("");
		Save.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				staff.insert(GetDataToGui());
			    showTable(staff.findAll());
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(506, 250, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save));
		Save.setToolTipText("Save data");
		panel_1.add(Save);
		
		JButton Edit = new JButton("");
		Edit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			    
				Staff s= GetDataToGui();
				s.setId(Integer.parseInt(txtID.getText()));
			
				staff.update(s);
				showTable(staff.findAll());
			}
		});
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.setBounds(565, 250, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit));
		Edit.setToolTipText("Edit data");
		panel_1.add(Edit);
		
		JButton Delete = new JButton("");
		Delete.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] list = table.getSelectedRows();
				List<Integer> listId = new ArrayList<Integer>(); 
				for (int i:list) {
					listId.add(Integer.parseInt(table.getValueAt(i, 0).toString()));
				}
				
				staff.delete(listId);
				showTable(staff.findAll());
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(615, 250, 40, 35);
		Delete.setIcon(new ImageIcon(SystemConstant.img_delete));
		Delete.setToolTipText("Delete data");
		panel_1.add(Delete);
		
		JButton Exit = new JButton("");
		Exit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(665, 250, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit2));
		Exit.setToolTipText("Exit");
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
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				SetDataByGui(id);
			}
			
		});
		
		table.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent action) {
				if (action.getKeyCode()==KeyEvent.VK_UP || action.getKeyCode()==KeyEvent.VK_DOWN) {
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					SetDataByGui(id);
				}
				
			}
			
		});
	}
	
	public void showTable(List<Staff> list) {
		String gender;
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Fullname","Gender","Birthday","Phone","Address","Identified Card","Email","Date_Start_Work","Role"
		});
		
		for (Staff i :list) {
			if (i.getGender()) gender="Nam"; else gender="Nữ";
			Object[] row = new Object[] {
					i.getId(),i.getFullname(),gender,i.getBirthday(),i.getPhone(),i.getAddress(),i.getiCard(),
					i.getEmail(),i.getDateStartWork(),i.getRole().getName()
			};
			defaultTable.addRow(row);
		}
	}
	public Staff GetDataToGui() {
	
		String st = sdf.format(dateOfBirth.getDate());
	    Date date1 = Date.valueOf(st);
	    
	    String st1 = sdf.format(dateOfWork.getDate());
	    Date date2 = Date.valueOf(st1);
	    
		Staff s= new Staff();
		s.setFullname(txtName.getText());
		s.setGender(Male.isSelected());
		s.setAddress(txtAddress.getText());
	    s.setBirthday(date1);
	    s.setDateStartWork(date2);
	    s.setEmail(txtEmail.getText());
	    s.setPhone(txtPhone.getText());
	    s.setiCard(txtICard.getText());
	    s.setRole((Role) comboRole.getSelectedItem());
	    s.setIdRole(((Role)comboRole.getSelectedItem()).getId());
	    
		
		return s;
	}
	
	public void SetDataByGui(int id) {
		Staff s = staff.findOne(id);
		txtID.setText(String.valueOf(s.getId()));
		txtName.setText(s.getFullname());
		txtAddress.setText(s.getAddress());
		txtPhone.setText(s.getPhone());
		txtICard.setText(s.getiCard());
		txtEmail.setText(s.getEmail());
		comboRole.setSelectedItem(s.getRole());
		if (s.getGender()==true)
		{ 
			Male.setSelected(true);
			} 
		else Female.setSelected(true);
		dateOfBirth.setDate(s.getBirthday());
		dateOfWork.setDate(s.getDateStartWork());
		

	}
}