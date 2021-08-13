package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Patient;

public class PatientDanhMuc extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	DefaultTableModel defaultTable = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JDateChooser dateChooser;
	private IPatientBUS patient = new PatientBUS();
	private JTable table;
	private JTextField textID;
	private JTextField textname;
	private JTextField textIcard;
	private JTextField textaddress;
	private JTextField textphone;
	private JRadioButton male; //male
	private JRadioButton female; //female
	private JLabel lb1;
	private ButtonGroup Group ;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
					PatientDanhMuc frame = new PatientDanhMuc();
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
	public PatientDanhMuc() {
		
		showTable(patient.findAll());
		setBackground(new Color(135, 206, 235));
		setTitle("Management Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 492);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGEMENT PATIENTS");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(334, 10, 200, 41);
lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Manipulate", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(153, 180, 209));
		panel.setBounds(10, 82, 260, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Fullname");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 10, 81, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ICard");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 37, 57, 22);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setOpaque(false);
		textField.setBounds(96, 13, 154, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBounds(96, 40, 154, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnReset = new JButton("");
		btnReset.setBounds(163, 96, 40, 35);
		panel.add(btnReset);
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon(SystemConstant.img_edit1));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable(patient.findAll());
			}
		});
		btnReset.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnReset.setBackground(new Color(135, 206, 235));
		
		JButton btSearch = new JButton("");
		btSearch.setBounds(65, 96, 40, 35);
		panel.add(btSearch);
		btSearch.setToolTipText("Search");
		btSearch.setIcon(new ImageIcon(SystemConstant.img_search1));
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullname = textField.getText();
				String icard = textField_1.getText();
				
				defaultTable.setRowCount(0);
				if(fullname.length() == 0 && icard.length() == 0)
				{
					showTable(patient.findAll());
				}
				else
				{
					if(fullname.length() != 0 && icard.length() != 0)
					{
						showTable(patient.searchByNameAndIcard(fullname, icard));
					}
					if(fullname.length() != 0 && icard.length() == 0)
					{
						showTable(patient.searchByName(fullname));	
					}
					if(fullname.length() == 0 && icard.length() != 0)
					{
						showTable(patient.searchByIcard(icard));
					}
				}
				textField.setText("");
				textField_1.setText("");
			}
		});
		btSearch.setBackground(new Color(135, 206, 235));
		btSearch.setFont(new Font("Sitka Small", Font.BOLD, 14));
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 10, 125, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 0, 115, 100);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(SystemConstant.img_patient));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 954, 172);
		contentPane.add(scrollPane);
		
		table = new JTable(defaultTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 8));
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.text));
		panel_1.setForeground(SystemColor.controlText);
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(301, 82, 663, 181);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btAdd = new JButton("");
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textname.getText().length()>0)
				{
					if(checkData(textphone.getText(), textIcard.getText()))
					{
						Patient p =null;
						 p = getDataByGUI(p);
						textID.setText(String.valueOf(patient.insert(p)));
						JOptionPane.showMessageDialog(null, "You save data successfully");
						refresh();
						
					}
					else
					{
						lb1.setText("errored");
						lb1.setForeground(Color.red);
					}
				}
				else
				{
					lb1.setText("Please fill data fully");
					lb1.setForeground(Color.red);
				}
				
				
			}
		});
		btAdd.setBounds(613, 10, 40, 29);
		panel_1.add(btAdd);
		btAdd.setBackground(Color.WHITE);
		btAdd.setToolTipText("ADD");
		btAdd.setIcon(new ImageIcon(SystemConstant.img_add));
		
		JButton btEdit = new JButton("");
		btEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lb1.setText("");
				if (textID.getText().length()>0 && textname.getText().length()>0) 
				{
					Patient p = patient.findOne(Integer.parseInt(textID.getText()));
					p = getDataByGUI(p);
					if (checkData(textphone.getText(), textIcard.getText()))
					{
						patient.update(p);
						JOptionPane.showMessageDialog(null, "This data is edited Succesfully");
						showTable(patient.findAll());
						refresh();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "please check your information! phonenumber has 10 characters and icard has 9 characters");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill your data fully");
				}
			}
		});
			
		btEdit.setBounds(613, 49, 40, 29);
		panel_1.add(btEdit);
		btEdit.setToolTipText("EDIT");
		btEdit.setIcon(new ImageIcon(SystemConstant.img_edit2));
		
		JButton btDel = new JButton("");
		btDel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				lb1.setText("");
				int[] list = table.getSelectedRows();
				if (list.length>0) 
				{
					List<Integer> listId = new ArrayList<Integer>(); 
				for (int i:list) 
				{
					listId.add(Integer.parseInt(table.getValueAt(i, 0).toString()));
				}
				
				int res=JOptionPane.showConfirmDialog(null, "You are sure delete databases","confirm", JOptionPane.YES_NO_OPTION);
				if (res!= JOptionPane.YES_OPTION) 
				{
					return ;
				} else 
				{
					
					patient.delete(listId);
					JOptionPane.showMessageDialog(null, "Data deleted Succesfully");
					showTable(patient.findAll());
					refresh();
				}
				}
			}
		});
		btDel.setBounds(613, 88, 40, 27);
		panel_1.add(btDel);
		btDel.setToolTipText("DELETE");
		btDel.setIcon(new ImageIcon(SystemConstant.img_delete1));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(613, 125, 40, 35);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? ","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) 
				{
					dispose();
				} 
				
			}
		});
		btnNewButton_1.setToolTipText("Exit");
		btnNewButton_1.setIcon(new ImageIcon(SystemConstant.img_exit3));
		
		JLabel lblNewLabel_4 = new JLabel("IDPatient");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setBounds(10, 10, 73, 13);
		panel_1.add(lblNewLabel_4);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setBounds(98, 10, 159, 19);
		panel_1.add(textID);
		textID.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fullname");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 49, 73, 13);
		panel_1.add(lblNewLabel_5);
		
		textname = new JTextField();
		textname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb1.setText("");
			}
		});
		textname.setBounds(98, 49, 159, 19);
		panel_1.add(textname);
		textname.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ICard");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 86, 73, 13);
		panel_1.add(lblNewLabel_6);
		
		textIcard = new JTextField();
		textIcard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb1.setText("");
			}
		});
		textIcard.setBounds(98, 88, 159, 19);
		panel_1.add(textIcard);
		textIcard.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 125, 73, 13);
		panel_1.add(lblNewLabel_7);
		
		textaddress = new JTextField();
		textaddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb1.setText("");
			}
		});
		textaddress.setBounds(98, 125, 260, 19);
		panel_1.add(textaddress);
		textaddress.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Phonenumber");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(267, 10, 91, 13);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Date Of Birth");
		lblNewLabel_9.setForeground(new Color(0, 51, 153));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(267, 49, 91, 13);
		panel_1.add(lblNewLabel_9);
		
		textphone = new JTextField();
		textphone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lb1.setText("");
			}
		});
		textphone.setBounds(385, 7, 152, 19);
		panel_1.add(textphone);
		textphone.setColumns(10);
		
		 dateChooser = new JDateChooser();
		 dateChooser.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		lb1.setText("");
		 	}
		 });
		dateChooser.setBounds(385, 49, 152, 19);
		panel_1.add(dateChooser);
		
		JLabel lblNewLabel_10 = new JLabel("Gender");
		lblNewLabel_10.setForeground(new Color(0, 51, 153));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(267, 86, 91, 13);
		panel_1.add(lblNewLabel_10);
		
		male = new JRadioButton("Male");
		male.setSelected(true);
		male.setForeground(new Color(0, 51, 153));
		male.setFont(new Font("Tahoma", Font.BOLD, 13));
		male.setOpaque(false);
		male.setBounds(385, 88, 102, 21);
		panel_1.add(male);
female = new JRadioButton("Female");
female.setForeground(new Color(0, 51, 153));
female.setFont(new Font("Tahoma", Font.BOLD, 13));
female.setOpaque(false);
		female.setBounds(385, 125, 102, 21);
		panel_1.add(female);
		
		Group =  new ButtonGroup();
		
		
		Group.add(male);
		Group.add(female);
		
		panel_1.add(male);
		panel_1.add(female);
		
		

		
	
		lb1 = new JLabel("");
		lb1.setForeground(Color.RED);
		lb1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lb1.setBounds(20, 149, 424, 13);
		panel_1.add(lb1);
		
		JButton btRefresh = new JButton("REFRESH");
		btRefresh.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btRefresh.setBackground(Color.YELLOW);
		btRefresh.setToolTipText("REFRESH");
		btRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		btRefresh.setBounds(528, 129, 75, 21);
		panel_1.add(btRefresh);
		
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount()==1) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				setDataToGUI(id);
				lb1.setText("");
				
				}
			}
			
		});
		table.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent action) {
			
			}

			@Override
			public void keyReleased(KeyEvent action) {
				if (action.getKeyCode()== KeyEvent.VK_DOWN || action.getKeyCode()== KeyEvent.VK_UP) {
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					setDataToGUI(id);
				}
			}

			@Override
			public void keyTyped(KeyEvent action) {
			
			}
		});
		scrollPane.setViewportView(table);
		
	}
	
	public void refresh() {
		textID.setText("");
		textname.setText("");
		textaddress.setText("");
		textphone.setText("");
		textIcard.setText("");
		male.setSelected(true);
			
		dateChooser.setDate(new Timestamp(System.currentTimeMillis()));
		
		
		showTable(patient.findAll());
		
	}
	public Patient getDataByGUI(Patient p)
	{
		if(p == null)
		{
			 p = new Patient();
		}
		p.setFullname(textname.getText());
		p.setGender(male.isSelected());
		String st = sdf.format(dateChooser.getDate());
		Date date1 = Date.valueOf(st);
		p.setBirthday(date1);
		p.setPhone(textphone.getText());
		p.setAddress(textaddress.getText());
		p.setiCard(textIcard.getText());
		
		
		return p;
	}
	
	public void setDataToGUI(int id)
	{
		Patient p = patient.findOne(id);
		textID.setText(String.valueOf(p.getId()));
		textname.setText(p.getFullname());
		if(p.getGender() == true)
		{
			male.setSelected(true);
			
		}
		else
		{
			female.setSelected(true);
			
		}
		dateChooser.setDate(p.getBirthday());
		textphone.setText(p.getPhone());
		
		textaddress.setText(p.getAddress());
		
		textIcard.setText(p.getiCard());
		
		
	}
	public boolean checkData(String phone, String icard)
	{
		boolean check = true;
		if(DataChecked.checkSDT(phone) && DataChecked.checkICard(icard))
			check = true;
		else
			check = false;
		return check;
	}
public void showTable(List<Patient> list)
	{
		String gender;
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID", "FULLNAME", "GENDER", "ICARD", "ADDRESS", "DAY OF BIRTH", "PHONENUMBER", "CREATED BY",
		  "CREATED DATE", "MODIFIED BY", "MODIFIED DATE"});
		
		for (Patient i : list) {
			if (i.getGender())
				gender = "Nam";
			else
				gender = "Nữ";
		
			Object[] row = new Object[] { i.getId(), i.getFullname(), gender, i.getiCard(), i.getAddress(),
					i.getBirthday(), i.getPhone(), i.getCreatedBy(), i.getCreatedDate(), i.getModifiedBy(), i.getModifiedDate()

			};
			 defaultTable.addRow(row);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	        if (male.isSelected()) 
	        {
	            male.setSelected(true);
	        }
	        if (female.isSelected()) 
	        {
	            female.setSelected(true);
	        }
	    
		
	}
}