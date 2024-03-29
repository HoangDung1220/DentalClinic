
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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.implement.RoleBUS;
import BUS.implement.StaffBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Role;
import DTO.Staff;
import PAGING.PageRequest;
import PAGING.Pageble;

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
	private JRadioButton NameStaff;
	private JRadioButton ID_Staff;
	private JLabel lbNote;
	private JScrollPane scrollPane;
	private JPanel panel_2;
	private JLabel lbNote1;





	RoleBUS role = new RoleBUS();
	DefaultTableModel defaultTable = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	StaffBUS staff = new StaffBUS();
	private JLabel lbpage;
	private JLabel lbtotalpage;
	private JButton btnbefore;
	private JButton btnfirst;
	private JButton lbafter;
	private JButton lblast;
	private static int totalPages;
	

	
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 607);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 22, 316, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seeek_By");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 26, 108, 21);
		panel.add(lblNewLabel);
		
		ID_Staff = new JRadioButton("ID_Staff",true);
		ID_Staff.setForeground(new Color(0, 51, 153));
		ID_Staff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote.setText("");
			}
		});
		ID_Staff.setBackground(SystemColor.activeCaption);
		ID_Staff.setFont(new Font("Tahoma", Font.BOLD, 13));
		ID_Staff.setBounds(15, 68, 103, 21);
		panel.add(ID_Staff);
		
		NameStaff = new JRadioButton("Name_Staff");
		NameStaff.setForeground(new Color(0, 51, 153));
		NameStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote.setText("");
			}
		});
		NameStaff.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameStaff.setBackground(SystemColor.activeCaption);
		NameStaff.setBounds(174, 68, 103, 21);
		panel.add(NameStaff);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(ID_Staff);
		bg1.add(NameStaff);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Char");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 131, 45, 13);
		panel.add(lblNewLabel_1);
		
		txtChar = new JTextField();
		txtChar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote.setText("");
			}
		});
		txtChar.setBorder(new CompoundBorder());
		txtChar.setBounds(107, 128, 140, 19);
		panel.add(txtChar);
		txtChar.setColumns(10);
		
		JButton Search = new JButton("");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 List<Staff> list = new ArrayList<Staff>();
				 if (txtChar.getText().length()==0) {
					  lbNote.setText("Please enter value in Char's field ");
				 } 
				 else {
				 String ch = txtChar.getText();
				  if (ID_Staff.isSelected()) {
					  boolean check = true;
					  for (int i=0;i<ch.length();i++) {
						  if (ch.charAt(i)<'0' || ch.charAt(i)>'9' ) {
							  check = false;
							  break;
						  }
					  }
					  if (check) {
					  list = staff.searchByIDOrName(Integer.parseInt(ch), null);} 
					  else
					  {
						  lbNote.setText("This data is not suitable");

					  }
				  } else 
				  {
						 list = staff.searchByIDOrName(-1,ch);
						 
				  }
				  if (list.size()>0)
				  {
				  showTable(list); 
				  lbNote.setText("");

				  }
				  else 
				  {
					  lbNote.setText("This data is not suitable");
					   

				  }
					  
			}
				
			}
		});
		Search.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(140, 191, 35, 35);
		Search.setIcon(new ImageIcon(SystemConstant.img_search1));
		panel.add(Search);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(349, 22, 743, 298);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("ID_Staff");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
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
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(21, 82, 82, 13);
		panel_1.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote1.setText("");
			}
		});
		txtName.setBounds(113, 79, 156, 19);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblDateofbirth = new JLabel("DateOfBirth");
		lblDateofbirth.setForeground(new Color(0, 51, 153));
		lblDateofbirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateofbirth.setBounds(21, 139, 82, 13);
		panel_1.add(lblDateofbirth);
		
		dateOfBirth = new JDateChooser();
		dateOfBirth.setBounds(113, 133, 156, 19);
		dateOfBirth.setDate(new Timestamp(System.currentTimeMillis()));
		panel_1.add(dateOfBirth);
		
		JLabel lblNewLabel_4 = new JLabel("Phonenumber");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(21, 192, 96, 13);
		panel_1.add(lblNewLabel_4);
		
		txtPhone = new JTextField();
		txtPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote1.setText("");
			}
		});
		txtPhone.setBounds(113, 189, 156, 19);
		panel_1.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(279, 32, 45, 13);
		panel_1.add(lblNewLabel_5);
		
		txtEmail = new JTextField();
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote1.setText("");

			}
		});
		txtEmail.setBounds(362, 29, 145, 19);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("I_Card ");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(279, 82, 72, 13);
		panel_1.add(lblNewLabel_6);
		
		txtICard = new JTextField();
		txtICard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNote1.setText("");

			}
		});
		txtICard.setBounds(362, 79, 145, 19);
		panel_1.add(txtICard);
		txtICard.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DateOfWork");
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(279, 139, 103, 13);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(279, 192, 72, 13);
		panel_1.add(lblNewLabel_8);
		
	    Male = new JRadioButton("Male");
	    Male.setForeground(new Color(0, 51, 153));
		Male.setBackground(SystemColor.activeCaption);
		Male.setFont(new Font("Tahoma", Font.BOLD, 13));
		Male.setBounds(602, 28, 103, 21);
		Male.setSelected(true);
		panel_1.add(Male);
		
		Female = new JRadioButton("Female");
		Female.setForeground(new Color(0, 51, 153));
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
		lblNewLabel_9.setForeground(new Color(0, 51, 153));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(527, 32, 69, 13);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Role");
		lblNewLabel_10.setForeground(new Color(0, 51, 153));
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
		dateOfWork.setDate(new Timestamp(System.currentTimeMillis()));
		panel_1.add(dateOfWork);
		
		
		JButton Save = new JButton("");
		Save.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtID.getText().length()==0) {
				Staff s = null;
				s = GetDataToGui(s);
				if (checkData(s))
					if (staff.searchByNameAndICard(txtName.getText(), txtICard.getText())==null)
				{
				lbNote1.setText("");
				txtID.setText(String.valueOf(staff.insert(s)));
				Staff sta = staff.findOne(Integer.parseInt(txtID.getText()));
				StringBuilder st = new StringBuilder("NV");
				st.append(txtID.getText());
				sta.setUsername(st.toString());
				staff.update(sta);
				JOptionPane.showMessageDialog(null, "Data Saved Successfully");
				refresh();
				} else 
				{
					lbNote1.setText("Information of staff is avaliable");
				}
				
			}}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(515, 250, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save));
		Save.setToolTipText("Save data");
		panel_1.add(Save);
		
		JButton Edit = new JButton("");
		Edit.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbNote1.setText("");
				if (txtID.getText().length()>0 && txtName.getText().length()>0) {
				Staff sm = staff.findOne(Integer.parseInt(txtID.getText()));
			    sm = GetDataToGui(sm);	
			    if (checkData(sm)) {
				staff.update(sm);
				JOptionPane.showMessageDialog(null, "Data edited Succesfully");
				showTable(staff.findAll());
				refresh();
				}
			}
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
				lbNote1.setText("");
				int[] list = table.getSelectedRows();
				if (list.length>0) {
				List<Integer> listId = new ArrayList<Integer>(); 
				for (int i:list) {
					listId.add(Integer.parseInt(table.getValueAt(i, 0).toString()));
				}
				
				int res=JOptionPane.showConfirmDialog(null, "You are sure delete databases","confirm", JOptionPane.YES_NO_OPTION);
				if (res!= JOptionPane.YES_OPTION) {
					return ;
				} else 
				{
					
					staff.delete(listId);
					JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
					showTable(staff.findAll());
					refresh();
				}
				}
				
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
				
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ? ","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) {
					dispose();
				} 
				
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(665, 250, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit2));
		Exit.setToolTipText("Exit");
		panel_1.add(Exit);
		
		lbNote1 = new JLabel("");
		lbNote1.setForeground(Color.RED);
		lbNote1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbNote1.setBounds(21, 252, 382, 33);
		panel_1.add(lbNote1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refresh();
			}
		});
		btnNewButton.setBounds(467, 250, 40, 35);
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_new));
		panel_1.add(btnNewButton);
		
		panel_2 = new JPanel();
		panel_2.setBounds(23, 346, 1069, 203);
		contentPane.add(panel_2);
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of patients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 34, 1049, 122);
		panel_2.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
		
		lbNote = new JLabel("");
		lbNote.setBounds(10, 18, 337, 20);
		panel_2.add(lbNote);
		lbNote.setForeground(Color.RED);
		lbNote.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lbpage = new JLabel("1");
		lbpage.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbpage.setBounds(498, 177, 45, 13);
		panel_2.add(lbpage);
		
		lbtotalpage = new JLabel("1/5\r\n");
		lbtotalpage.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbtotalpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalpage.setBounds(553, 177, 45, 13);
		panel_2.add(lbtotalpage);
		
		btnbefore = new JButton("<");
		btnbefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage>1) {
				String page = String.valueOf(--currentPage);
				Staff s= paging(currentPage,SystemConstant.LIMIT);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					Staff s= paging(currentPage,SystemConstant.LIMIT);
					showTable(s.getList());

				}
			}
		});
		btnbefore.setOpaque(false);
		btnbefore.setForeground(new Color(0, 51, 204));
		btnbefore.setBackground(SystemColor.activeCaption);
		btnbefore.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnbefore.setBounds(444, 173, 55, 21);
		panel_2.add(btnbefore);
		
		btnfirst = new JButton("<<");
		btnfirst.setOpaque(false);
		btnfirst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnfirst.setForeground(new Color(0, 51, 204));
		btnfirst.setBackground(SystemColor.activeCaption);
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff s= paging(1,SystemConstant.LIMIT);
				decorPaging(s);
				showTable(s.getList());
			}
		});
		btnfirst.setBounds(374, 173, 60, 21);
		panel_2.add(btnfirst);
		
		lbafter = new JButton(">");
		lbafter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage<totalPages) {
				String page = String.valueOf(++currentPage);
				Staff s= paging(currentPage,SystemConstant.LIMIT);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					Staff s= paging(currentPage,SystemConstant.LIMIT);
					showTable(s.getList());

				}
				
			}
		});
		lbafter.setOpaque(false);
		lbafter.setBackground(SystemColor.activeCaption);
		lbafter.setForeground(new Color(0, 51, 204));
		lbafter.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbafter.setBounds(597, 173, 55, 21);
		panel_2.add(lbafter);
		
		lblast = new JButton(">>");
		lblast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff s= paging(totalPages,SystemConstant.LIMIT);
				decorPaging(s);
				showTable(s.getList());
			}
		});
		lblast.setOpaque(false);
		lblast.setForeground(new Color(0, 51, 204));
		lblast.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblast.setBackground(SystemColor.activeCaption);
		lblast.setBounds(662, 173, 60, 21);
		panel_2.add(lblast);
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				SetDataByGui(id);
				lbNote1.setText("");
				
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
		Staff staff1 = paging(1,SystemConstant.LIMIT);
		showTable(staff1.getList());
		decorPaging(staff1);
	}
	
	public void showTable(List<Staff> list) {
		if (list!=null) {
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
	}
	public Staff GetDataToGui(Staff s) {
	 if (s==null) 
	 {
		 s = new Staff();
	 }
		String st = sdf.format(dateOfBirth.getDate());
	    Date date1 = Date.valueOf(st);
	    String st1 = sdf.format(dateOfWork.getDate());
	    Date date2 = Date.valueOf(st1);
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
		comboRole.setSelectedIndex(s.getIdRole()-1);

		if (s.getGender()==true)
		{ 
			Male.setSelected(true);
			} 
		else Female.setSelected(true);
		dateOfBirth.setDate(s.getBirthday());
		dateOfWork.setDate(s.getDateStartWork());
	}
	
	public void refresh() {
		txtID.setText("");
		txtName.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtICard.setText("");
		txtEmail.setText("");
		comboRole.setSelectedIndex(0);
		
			Male.setSelected(true);
			
		dateOfBirth.setDate(new Timestamp(System.currentTimeMillis()));
		dateOfWork.setDate(new Timestamp(System.currentTimeMillis()));
		Staff staff1 = paging(1,SystemConstant.LIMIT);
		showTable(staff1.getList());
		decorPaging(staff1);
	}
	
	public boolean checkData(Staff s) {
		if (txtName.getText().length()>0 && txtICard.getText().length()>0 && txtEmail.getText().length()>0 && txtPhone.getText().length()>0) {
		boolean[] list = {true,true,true,true} ;
		
		if (s.getPhone().length()>0) {
		if (DataChecked.checkSDT(s.getPhone())){
			list[0]= true;
		} else
		{
			txtPhone.setText("");
			list[0]= false;
		}
		}
	
		if (s.getEmail().length()>0) {
		if (DataChecked.checkEmail(s.getEmail())){
			list[1]= true;
		} else
		{
			txtEmail.setText("");
			list[1]= false;
		}
		}
		
		if (s.getiCard().length()>0) {
		if (DataChecked.checkICard(s.getiCard())){
			list[2]= true;
		} else
		{
			txtICard.setText("");
			list[2]= false;
		}
		}
		
		if (dateOfBirth.getDate().compareTo(dateOfWork.getDate())>=0) {
			list[3]= false;
		}
		
		StringBuilder st = new StringBuilder();

		
		for (int i = 0;i<list.length;i++) {
			if (!list[i])
			switch (i) {
			case 0:
				st.append("Phone,");
				break;
			case 1:
				st.append("Email,");
				break;
			case 2:
				st.append("Identified Card,");
				break;
			
			case 3:
			st.append("Date of birth and Work start date,");
			break;
			}
		}
		if (st.toString().equals(""))
		{	return true;
		}
		else 
		{
			st.deleteCharAt(st.length()-1);
			st.append(" is errored");
			lbNote1.setText(st.toString());
		return false;
		}}
		else 
		{
			lbNote1.setText("Please filled data");	
			return false;
		}
	} 
	
	public Staff paging(int page,int limit){
		Staff s= new Staff();
		List<Staff> list = staff.findAll();
		int totalItem = list.size();
		int totalPage = (int) Math.ceil(((double) totalItem)/limit);
		Pageble pageable =  new PageRequest(page, limit);
		List<Staff> listPaging = staff.findStaffWithPage(pageable);
		s.setTotalItem(totalItem);
		s.setTotalPage(totalPage);
		s.setPage(page);
		s.setLimit(limit);
		s.setList(listPaging);
		totalPages = s.getTotalPage();
		return s;
	}
	
	public void decorPaging(Staff staff) {
		lbpage.setText(String.valueOf(staff.getPage()));
		lbtotalpage.setText(staff.getPage()+"/"+staff.getTotalPage());

	}
}