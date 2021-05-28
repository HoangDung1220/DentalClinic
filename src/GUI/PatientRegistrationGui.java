package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import com.toedter.calendar.JDateChooser;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import DTO.Patient;
import DTO.Patient;

import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PatientRegistrationGui extends JFrame 
{

	private JPanel contentPane, panel, panel_1, panel_2;
	private JTextField textFieldSearchName;
	private JTextField textFieldSearchICard;

	private JTextField textFieldID;
	private JTextField textFieldFullName;
	private JTextField textFieldICard;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5,
			lblNewLabel_6, lblNewLabel_7, lblNewLabel_8;
	private JDateChooser dateOfBirth;
	private JButton btnNewButtonSearch, btnNewButtonSave, btnNewButtonUpdate, btnNewButtonDelete;
	private JScrollPane scrollPane, scrollPane_1;
	private JRadioButton rdbtnMale, rdbtnFemale;
	private JFrame frame;
	

	DefaultTableModel defaultTable = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	PatientBUS patient= new PatientBUS();
	private JTable table;
	private JTable table_1;
	


	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PatientRegistrationGui frame = new PatientRegistrationGui();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
		
	public PatientRegistrationGui() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 750);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00CCM KI\u1EBEM TH\u00D4NG TIN", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowBorder));
		panel.setBounds(21, 25, 528, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 lblNewLabel = new JLabel("FullName");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel.setBounds(27, 40, 68, 21);
		panel.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("ICard ");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_1.setBounds(27, 91, 68, 31);
		panel.add(lblNewLabel_1);
		
		textFieldSearchName = new JTextField();
		textFieldSearchName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldSearchName.setBounds(105, 35, 252, 25);
		panel.add(textFieldSearchName);
		textFieldSearchName.setColumns(10);
		
		textFieldSearchICard = new JTextField();
		textFieldSearchICard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldSearchICard.setBounds(105, 91, 252, 25);
		panel.add(textFieldSearchICard);
		textFieldSearchICard.setColumns(10);
		
		 btnNewButtonSearch = new JButton("SEARCH");
		btnNewButtonSearch.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		btnNewButtonSearch.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonSearch.setBounds(398, 58, 108, 31);
		panel.add(btnNewButtonSearch);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 508, 229);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		 panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TH\u00D4NG TIN B\u1EC6NH NH\u00C2N", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.controlDkShadow));
		panel_1.setBounds(562, 28, 548, 378);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		 lblNewLabel_2 = new JLabel("IDPatient");
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 29, 74, 22);
		panel_1.add(lblNewLabel_2);
		
		textFieldID = new JTextField();
		textFieldID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldID.setBounds(94, 29, 154, 25);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		 lblNewLabel_3 = new JLabel("FullName");
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 81, 74, 22);
		panel_1.add(lblNewLabel_3);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldFullName.setBounds(94, 81, 154, 25);
		panel_1.add(textFieldFullName);
		textFieldFullName.setColumns(10);
		
		 lblNewLabel_4 = new JLabel("ICard ");
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 134, 74, 16);
		panel_1.add(lblNewLabel_4);
		
		textFieldICard = new JTextField();
		textFieldICard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldICard.setBounds(94, 131, 154, 25);
		panel_1.add(textFieldICard);
		textFieldICard.setColumns(10);
		
		 lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 185, 74, 22);
		panel_1.add(lblNewLabel_5);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldAddress.setBounds(94, 182, 154, 25);
		panel_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		 lblNewLabel_6 = new JLabel("Phonenumber");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6.setBounds(271, 32, 103, 19);
		panel_1.add(lblNewLabel_6);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldPhone.setBounds(384, 29, 154, 25);
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		 lblNewLabel_7 = new JLabel("DateOfBirth ");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_7.setBounds(271, 81, 103, 25);
		panel_1.add(lblNewLabel_7);
		
		 lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_8.setBounds(271, 134, 70, 17);
		panel_1.add(lblNewLabel_8);
		
		 btnNewButtonSave = new JButton("SAVE");
		btnNewButtonSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				patient.insert(GetDataToGUI());
				showTable(patient.findAll());
			}
		});
		btnNewButtonSave.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonSave.setBounds(32, 276, 103, 33);
		panel_1.add(btnNewButtonSave);
		
		 btnNewButtonUpdate = new JButton("UPDATE");
		btnNewButtonUpdate.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonUpdate.setBounds(221, 276, 103, 33);
		panel_1.add(btnNewButtonUpdate);
		
		 btnNewButtonDelete = new JButton("DELETE");
		 btnNewButtonDelete.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		
		 	
		 		
		 		int[] list = table_1.getSelectedRows();
				List<Integer> listId = new ArrayList<Integer>(); 
				for (int i:list) {
					listId.add(Integer.parseInt(table_1.getValueAt(i, 0).toString()));
				}
				
				patient.delete(listId);
				showTable(patient.findAll());
				
		 	}
		 });
		
		btnNewButtonDelete.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonDelete.setBounds(395, 276, 103, 33);
		panel_1.add(btnNewButtonDelete);
		
		 dateOfBirth = new JDateChooser();
		dateOfBirth.setBounds(393, 84, 105, 19);
		panel_1.add(dateOfBirth);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMale.setBounds(379, 130, 103, 21);
		panel_1.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFemale.setBounds(379, 164, 103, 21);
		panel_1.add(rdbtnFemale);
		
		 panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH B\u1EC6NH NH\u00C2N ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textInactiveText));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(22, 429, 1088, 274);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		 scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 1068, 243);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int row = table_1.getSelectedRow();
				int id = Integer.parseInt(table_1.getValueAt(row, 0).toString());
				if (row != -1) 
				{
					setDataByGUI(id);
				}
			}
			
		});
		scrollPane_1.setViewportView(table_1);
		
		
		showTable(patient.findAll());
		
	}
		
	public void showTable(List<Patient> list)
	{
		String []header = {"ID", "FULLNAME", "GENDER", "ICARD", "ADDRESS", "DAY OF BIRTH", "PHONENUMBER"}; 
		DefaultTableModel dtm = new DefaultTableModel(header, 0);
		ArrayList<Patient> arr = new ArrayList<Patient>();
		PatientBUS  patientBLL  = new PatientBUS();
		arr = (ArrayList<Patient>) patientBLL.findAll();
		Patient patientDTO = new Patient();
		for(int i = 0; i<arr.size(); i++)
		{
			patientDTO = arr.get(i);
			int id = patientDTO.getId();
			String name = patientDTO.getFullname();
			boolean gender = patientDTO.getGender();
			String gender1;
			if(gender)
				gender1 = "Male";
			else
				gender1 = "Female";
			Date date = patientDTO.getBirthday();
			String phone = patientDTO.getPhone();
			String address = patientDTO.getAddress();
			String icard = patientDTO.getiCard();
			Object [] row = {id, name, gender1, date,phone, address, icard};
			dtm.addRow(row);
			
		}
		table_1.setModel(dtm);
	}
	
	public Patient GetDataToGUI()
	{
		String st = sdf.format(dateOfBirth.getDate());
		Date date1 = Date.valueOf(st);
		Patient p = new Patient();
		p.setId(Integer.parseInt(textFieldID.getText()));
		p.setFullname(textFieldFullName.getText());
		p.setGender(rdbtnMale.isSelected());
		p.setBirthday(date1);
		p.setPhone(textFieldPhone.getText());
		p.setAddress(textFieldAddress.getText());
		p.setiCard(textFieldICard.getText());
		return p;
	}
	
	public void setDataByGUI(int id)
	{
		Patient p = patient.findOne(id);
		textFieldID.setText(String.valueOf(p.getId()));
		textFieldFullName.setText(p.getFullname());
		textFieldICard.setText(p.getiCard());
		textFieldAddress.setText(p.getAddress());
		textFieldPhone.setText(p.getPhone());
		dateOfBirth.setDate(p.getBirthday());
		boolean gen = p.getGender();
		if (gen == true) 
			rdbtnMale.setSelected(true);	
		else 
			rdbtnFemale.setSelected(true);
		
		
	}
}
		
