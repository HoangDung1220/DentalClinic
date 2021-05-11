package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import CheckData.CheckPhone;
import DTO.Patient;

import com.toedter.calendar.JDateChooser;

public class PatientRegistrationGui extends JFrame{
	private static JPanel contentPane;
	private static JTextField textFieldSearchName;
	private static JTextField textFieldSearchICard;
	private static JTable table;
	private static JTextField textFieldID;
	private static JTextField textFieldFullName;
	private static JTextField textFieldICard;
	private static JTextField textFieldAddress;
	private static JTextField textFieldPhone;
	private static JTable table_1;
	private static JButton btnNewButtonSearch,btnNewButtonSave,btnNewButtonUpdate,btnNewButtonDelete;
	private static JRadioButton rdbtnNewRadioButtonMale, rdbtnNewRadioButtonFemale;
    private static JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
    
	public static void setColumn(Vector v)
	{
		v.add("Id");
		v.add("Full name");
		v.add("Gender");
		v.add("Birthday");
		v.add("Phone");
		v.add("Address");
		v.add("ICard");
		v.add("Create By");
		v.add("Create Date");  
		v.add("Modified By");
		v.add("Modified Date");
		v.add("Status");
	}
	public static void getDataToRow(Vector row, Patient p)
	{
		row.add(p.getId());
		row.add(p.getFullname());
		row.add(p.getGender());
		row.add(p.getBirthday());
		row.add(p.getPhone());
		row.add(p.getAddress());
		row.add(p.getiCard());
		row.add(p.getCreatedBy());
		row.add(p.getCreatedDate());
		row.add(p.getModifiedBy());
		row.add(p.getModifiedDate());
		row.add(p.getStatus());
	}
// get data to DefaultTableModel
	public static DefaultTableModel showDataToTable(String name, String idCard)  
	{
		
		DefaultTableModel model =new DefaultTableModel();
		Vector column =new Vector();
		setColumn(column);
        model.setColumnIdentifiers(column);
        
        IPatientBUS patient = new PatientBUS();
		List<Patient> list =new ArrayList<Patient>();
		list= patient.findAll();     // find all patient

		for (int i=0;i<list.size();i++)
		{
			Patient p=(Patient)list.get(i);
            if (name!="" && idCard !="" && p.getFullname().equalsIgnoreCase(name) && p.getiCard().equalsIgnoreCase(idCard)  )
            {
            	
    				Vector row =new Vector();
    				getDataToRow(row,p);				
    				model.addRow(row);	
            }
            if (name=="" && idCard =="")
            {
            	Vector row =new Vector();
				getDataToRow(row,p);				
				model.addRow(row);
				
            }
            
            textFieldID.setText("");
            
            textFieldFullName.setText("");
            textFieldICard.setText("");
            
            textFieldPhone.setText("");
            textFieldAddress.setText("");
            rdbtnNewRadioButtonFemale.setSelected(true);       
            Date date  = new Date(2000-1900,02,01);
                dateChooser.setDate(date);
            
            
		
		}
		return model;
	 }
// show data from Row Selected to panel_1
	public static void loadData(int index)
	{
	    IPatientBUS patient = new PatientBUS();
		List<Patient> list =new ArrayList<Patient>();
		list= patient.findAll();     // find all patient
        Patient p=(Patient)list.get(index);
        
       
        textFieldID.setText(""+p.getId());
       
        textFieldFullName.setText(""+p.getFullname());
        textFieldICard.setText(p.getiCard());
        
        textFieldPhone.setText(p.getPhone());
        textFieldAddress.setText(p.getAddress());
        if (p.getGender() ==0) rdbtnNewRadioButtonFemale.setSelected(true);
        else rdbtnNewRadioButtonMale.setSelected(true);
        
            DefaultTableModel model = (DefaultTableModel)table_1.getModel();
            Date date=p.getBirthday();
          //  System.out.println(date);
            dateChooser.setDate(date);
        
        
		// System.out.print(SelectedRowIndex);
	}
// 
	public static void getData(Patient p)
	{   
		 CheckPhone check =new CheckPhone();
		 // Exception 
		if (textFieldFullName.getText().equals("") || textFieldICard.getText().equals("") 
	                            || textFieldAddress.getText().equals("") ||  check.checkSDT( textFieldPhone.getText())==false )
	
	   {
		 JOptionPane.showMessageDialog(null, "Please complete all information !");
	   }
		if ( textFieldFullName.getText() !=null && textFieldICard.getText() !=null 
				&& textFieldAddress.getText()!=null   /*&&   check.checkSDT( textFieldPhone.getText())==true  */ )
		{  
		    p.setFullname(textFieldFullName.getText());
		    if (rdbtnNewRadioButtonFemale.isSelected()) p.setGender((byte)0);
		    else if ( rdbtnNewRadioButtonMale.isSelected()) p.setGender((byte)1);


		    SimpleDateFormat month =new SimpleDateFormat ("MM");
	        String m =month.format(dateChooser.getDate());
	    
	        SimpleDateFormat year =new SimpleDateFormat ("yyyy");
	        String y =year.format(dateChooser.getDate());
	    
	        SimpleDateFormat day =new SimpleDateFormat ("dd");
	        String d =day.format(dateChooser.getDate());
	    
	        Date d2 = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1, Integer.parseInt(d));
	        p.setBirthday(d2);
	       	p.setPhone( textFieldPhone.getText());
	    	p.setAddress(textFieldAddress.getText());
		    p.setiCard(textFieldICard.getText());
		    p.setCreatedBy("HBB");
		    p.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		    p.setModifiedBy("HBB");
		    p.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		    p.setStatus(1);
		}
	}
	public PatientRegistrationGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 750);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00CCM KI\u1EBEM TH\u00D4NG TIN", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowBorder));
		panel.setBounds(21, 25, 528, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FullName");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel.setBounds(27, 40, 68, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ICard ");
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
	//	btnNewButtonSearch.addActionListener(this);
		panel.add(btnNewButtonSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 508, 229);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TH\u00D4NG TIN B\u1EC6NH NH\u00C2N", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.controlDkShadow));
		panel_1.setBounds(562, 28, 548, 378);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("IDPatient");
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 29, 74, 22);
		panel_1.add(lblNewLabel_2);
		
		textFieldID = new JTextField();
		textFieldID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldID.setBounds(94, 29, 154, 25);
		textFieldID.enable(false);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("FullName");
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 81, 74, 22);
		panel_1.add(lblNewLabel_3);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldFullName.setBounds(94, 81, 154, 25);
		panel_1.add(textFieldFullName);
		textFieldFullName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ICard ");
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 134, 74, 16);
		panel_1.add(lblNewLabel_4);
		
		textFieldICard = new JTextField();
		textFieldICard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldICard.setBounds(94, 131, 154, 25);
		panel_1.add(textFieldICard);
		textFieldICard.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 185, 74, 22);
		panel_1.add(lblNewLabel_5);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldAddress.setBounds(94, 182, 154, 25);
		panel_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phonenumber");
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6.setBounds(271, 32, 103, 19);
		panel_1.add(lblNewLabel_6);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldPhone.setBounds(384, 29, 154, 25);
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DateOfBirth ");
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_7.setBounds(271, 81, 103, 25);
		panel_1.add(lblNewLabel_7);
		
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_8.setBounds(271, 134, 70, 17);
		panel_1.add(lblNewLabel_8);
		
		
		 rdbtnNewRadioButtonMale = new JRadioButton("Male");
		rdbtnNewRadioButtonMale.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		rdbtnNewRadioButtonMale.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButtonMale.setBounds(281, 158, 70, 21);
		panel_1.add(rdbtnNewRadioButtonMale);
		
		
		 rdbtnNewRadioButtonFemale = new JRadioButton("Female");
		rdbtnNewRadioButtonFemale.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButtonFemale.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		rdbtnNewRadioButtonFemale.setBounds(417, 158, 81, 21);
		panel_1.add(rdbtnNewRadioButtonFemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButtonMale);
		bg.add(rdbtnNewRadioButtonFemale);
		
	    btnNewButtonSave = new JButton("SAVE");
		btnNewButtonSave.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonSave.setBounds(32, 305, 103, 33);
	//	btnNewButtonSave.addActionListener(this);
		panel_1.add(btnNewButtonSave);
		
	    btnNewButtonUpdate = new JButton("UPDATE");
		btnNewButtonUpdate.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonUpdate.setBounds(221, 305, 103, 33);
		//btnNewButtonUpdate.addActionListener(this);
		panel_1.add(btnNewButtonUpdate);
		
		 btnNewButtonDelete = new JButton("DELETE");
		
		btnNewButtonDelete.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonDelete.setBounds(395, 305, 103, 33);
	//	btnNewButtonDelete.addActionListener(this);
		panel_1.add(btnNewButtonDelete);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(384, 81, 153, 25);
		panel_1.add(dateChooser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH B\u1EC6NH NH\u00C2N ", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textInactiveText));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(31, 421, 1076, 254);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 1068, 243);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
//Search		
		btnNewButtonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(showDataToTable(textFieldSearchName.getText(),textFieldSearchICard.getText() ));

			}
		});
//Add
		btnNewButtonSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				    
			    	IPatientBUS patient = new PatientBUS();
					Patient p=new Patient();
					getData(p);			
					patient.insert(p);					
					table_1.setModel(showDataToTable("",""));
					
					
				
			}
		});
//Delete
		btnNewButtonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				   int SelectedRowIndex=table_1.getSelectedRow();
				    IPatientBUS patient = new PatientBUS();
					List<Patient> list =new ArrayList<Patient>();
					list= patient.findAll();     // find all patient

					
						Patient p=(Patient)list.get(SelectedRowIndex);
						patient.delete(p.getId());
						table_1.setModel(showDataToTable("",""));
			}
	    });
//loadData from Row Selected to panel_1
				
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {
				int index=table_1.getSelectedRow(); 
				loadData(index);
			}
		});
//Update
		btnNewButtonUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index=table_1.getSelectedRow(); 
			
				IPatientBUS patient = new PatientBUS();
				List<Patient> list =new ArrayList<Patient>();
				list= patient.findAll();     // find all patient
				Patient p=(Patient)list.get(index);
				getData(p);
			    patient.update(p);
				

				table_1.setModel(showDataToTable("",""));
				
			}
	    });
}
			
	

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PatientRegistrationGui frame = new PatientRegistrationGui();
				frame.setVisible(true);
				//loadData();
				
				table_1.setModel(showDataToTable("",""));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	
}
}
	


