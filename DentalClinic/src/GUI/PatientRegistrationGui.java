package GUI;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Patient;
import DTO.Staff;

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
    private JButton exit;
    private PatientBUS patientExecute = new PatientBUS();
	
	public static void setColumn(Vector<String> v)
	{
		v.add("Id");
		v.add("Full name");
		v.add("Gender");
		v.add("Birthday");
		v.add("Phone");
		v.add("Address");
		v.add("ICard");
	
	}
	public static void getDataToRow(Vector<Object> row, Patient p)
	{
		row.add(p.getId());
		row.add(p.getFullname());
		if (p.getGender()) {
		row.add("Nam");
		} else row.add("Nữ");
		row.add(p.getBirthday());
		row.add(p.getPhone());
		row.add(p.getAddress());
		row.add(p.getiCard());
		
	}
// get data to DefaultTableModel
	public static DefaultTableModel showDataToTable(String name, String idCard)  
	{
		
		DefaultTableModel model =new DefaultTableModel();
		Vector<String> column =new Vector<String>();
		setColumn(column);
        model.setColumnIdentifiers(column);
        
        IPatientBUS patient = new PatientBUS();
		List<Patient> list =new ArrayList<Patient>();
		list= patient.findAll();     // find all patient
		for (int i=0;i<list.size();i++)
		{
			Patient p=(Patient)list.get(i);
            if (name!="" && idCard !="" && (p.getFullname().contains(name)||p.getFullname().contains(name.toUpperCase())) && p.getiCard().contains(idCard)  )
            {
            	
    				Vector<Object> row =new Vector<Object>();
    				getDataToRow(row,p);				
    				model.addRow(row);	
            }
            if (name=="" && idCard =="")
            {
            	Vector<Object> row =new Vector<Object>();
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
        if (p.getGender()) rdbtnNewRadioButtonMale.setSelected(true);
        else rdbtnNewRadioButtonFemale.setSelected(true);
        
            DefaultTableModel model = (DefaultTableModel)table_1.getModel();
            Date date=(Date) p.getBirthday();
            dateChooser.setDate(date);
        
        
	}
	public static void getData(Patient p)
	{   
	
		{  
		
//	        p.setId(Integer.parseInt(textFieldID.getText()));
		    p.setFullname(textFieldFullName.getText());
		    if (rdbtnNewRadioButtonFemale.isSelected()) p.setGender(false);
		    else if ( rdbtnNewRadioButtonMale.isSelected()) p.setGender(true);


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
		    p.setCreatedBy(SystemConstant.staff.getFullname());
		    p.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 100, 100)));
		panel.setBounds(21, 25, 528, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FullName");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel.setBounds(27, 40, 68, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ICard ");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
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
		
		 btnNewButtonSearch = new JButton("");
		btnNewButtonSearch.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		btnNewButtonSearch.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonSearch.setBounds(398, 58, 40, 35);
		panel.add(btnNewButtonSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 508, 229);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				Patient p = patientExecute.findOne(id);
				getGui(p);
				
			}
			
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(105, 105, 105)));
		panel_1.setBounds(562, 28, 548, 378);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("IDPatient");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 29, 74, 22);
		panel_1.add(lblNewLabel_2);
		
		textFieldID = new JTextField();
		textFieldID.setOpaque(false);
		textFieldID.setEnabled(false);
		textFieldID.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldID.setBounds(94, 29, 154, 25);
		panel_1.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("FullName");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 81, 74, 22);
		panel_1.add(lblNewLabel_3);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldFullName.setBounds(94, 81, 154, 25);
		panel_1.add(textFieldFullName);
		textFieldFullName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ICard ");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 134, 74, 16);
		panel_1.add(lblNewLabel_4);
		
		textFieldICard = new JTextField();
		textFieldICard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldICard.setBounds(94, 131, 154, 25);
		panel_1.add(textFieldICard);
		textFieldICard.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 185, 74, 22);
		panel_1.add(lblNewLabel_5);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldAddress.setBounds(94, 182, 154, 25);
		panel_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phonenumber");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_6.setBounds(271, 32, 103, 19);
		panel_1.add(lblNewLabel_6);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldPhone.setBounds(384, 29, 154, 25);
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DateOfBirth ");
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_7.setBounds(271, 81, 103, 25);
		panel_1.add(lblNewLabel_7);
		
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_8.setBounds(271, 134, 70, 17);
		panel_1.add(lblNewLabel_8);
		
		
		 rdbtnNewRadioButtonMale = new JRadioButton("Male");
		 rdbtnNewRadioButtonMale.setForeground(new Color(0, 51, 153));
		rdbtnNewRadioButtonMale.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		rdbtnNewRadioButtonMale.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButtonMale.setBounds(281, 158, 70, 21);
		rdbtnNewRadioButtonMale.setSelected(true);
		panel_1.add(rdbtnNewRadioButtonMale);
		
		
		 rdbtnNewRadioButtonFemale = new JRadioButton("Female");
		 rdbtnNewRadioButtonFemale.setForeground(new Color(0, 51, 153));
		rdbtnNewRadioButtonFemale.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButtonFemale.setFont(new Font("Sitka Small", Font.PLAIN, 13));
		rdbtnNewRadioButtonFemale.setBounds(417, 158, 81, 21);
		panel_1.add(rdbtnNewRadioButtonFemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButtonMale);
		bg.add(rdbtnNewRadioButtonFemale);
		
	    btnNewButtonSave = new JButton("");
		btnNewButtonSave.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonSave.setBounds(32, 305, 40, 35);
		btnNewButtonSave.setIcon(new ImageIcon(SystemConstant.img_save1));
		panel_1.add(btnNewButtonSave);
		
	    btnNewButtonUpdate = new JButton("");
		btnNewButtonUpdate.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonUpdate.setBounds(94, 305, 40, 35);
		btnNewButtonUpdate.setIcon(new ImageIcon(SystemConstant.img_edit1));
		panel_1.add(btnNewButtonUpdate);
		
		 btnNewButtonDelete = new JButton("");
		
		btnNewButtonDelete.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonDelete.setBounds(167, 305, 40, 35);
		btnNewButtonDelete.setIcon(new ImageIcon(SystemConstant.img_delete));
	//	btnNewButtonDelete.addActionListener(this);
		panel_1.add(btnNewButtonDelete);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(384, 81, 153, 25);
		panel_1.add(dateChooser);
		
		exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) {
					dispose();
				} 
				
			}
		});
		exit.setFont(new Font("Sitka Small", Font.BOLD, 14));
		exit.setIcon(new ImageIcon(SystemConstant.img_exit2));
		exit.setBounds(233, 305, 40, 35);
		panel_1.add(exit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of patients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(109, 109, 109)));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(31, 421, 1076, 254);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 1056, 223);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				int id = Integer.parseInt(table_1.getValueAt(index, 0).toString());
				Patient p = patientExecute.findOne(id);
				getGui(p);
				
			}
			
		});
		
		
		scrollPane_1.setViewportView(table_1);
		
//Search	
		btnNewButtonSearch.setIcon(new ImageIcon(SystemConstant.img_search1));
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
					if (checkData(p)){
					int id =patient.insert(p);		
					textFieldID.setText(String.valueOf(id));
					JOptionPane.showMessageDialog(null, "Data Saved successfully");
					table_1.setModel(showDataToTable("",""));
					}
					
					
				
			}
		});
//Delete
		btnNewButtonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int[] list = table_1.getSelectedRows();
				List<Integer> listId = new ArrayList<Integer>(); 
				for (int i:list) {
					listId.add(Integer.parseInt(table_1.getValueAt(i, 0).toString()));
				}
				int res=JOptionPane.showConfirmDialog(null, "You are sure delete databases","confirm", JOptionPane.YES_NO_OPTION);
				if (res!= JOptionPane.YES_OPTION) {
					return ;
				} else 
				{
					patientExecute.delete(listId);
					
					JOptionPane.showMessageDialog(null, "Data deleted Succesfully");							
					table_1.setModel(showDataToTable("",""));
				}
				
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
				Patient p=new Patient();
//				List<Patient> list =new ArrayList<Patient>();
//				list= patient.findAll();     // find all patient
//				Patient p=(Patient)list.get(index);
				getData(p);
				p.setModifiedDate(new Timestamp(System.currentTimeMillis()));
				p.setModifiedBy(SystemConstant.staff.getFullname());
			    
			    if (checkData(p)) {
			    	patient.update(p);
			    	JOptionPane.showMessageDialog(null, "Data updated successfully");
			    }
				

				table_1.setModel(showDataToTable("",""));
				
			}
	    });
		table_1.setModel(showDataToTable("",""));

}
			
	

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PatientRegistrationGui frame = new PatientRegistrationGui();
				frame.setVisible(true);
//				table_1.setModel(showDataToTable("",""));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	
}

public boolean checkData(Patient s) {
	boolean[] list = {true,true,true} ;
	
	if (s.getPhone().length()>0) {
	if (DataChecked.checkSDT(s.getPhone())){
		list[0]= true;
	} else
	{
		textFieldPhone.setText("");
		list[0]= false;
	}
	}

	if (s.getiCard().length()>0) {
	if (DataChecked.checkICard(s.getiCard())){
		list[1]= true;
	} else
	{
		textFieldICard.setText("");
		list[1]= false;
	}
	}
	StringBuilder st = new StringBuilder();

	
	for (int i = 0;i<list.length;i++) {
		if (!list[i])
		switch (i) {
		case 0:
			st.append("Phone,");
			break;
		case 1:
			st.append("Identified Card,");
			break;
		}
	}
	if (st.toString().equals(""))
	{	return true;
	}
	else 
	{
		
		st.append(" is errored");
		JOptionPane.showMessageDialog(null,st.toString());
	return false;
	}
} 

public void getGui(Patient patient) {
	textFieldID.setText(String.valueOf(patient.getId()));
	textFieldFullName.setText(patient.getFullname());
	textFieldICard.setText(patient.getiCard());
	textFieldAddress.setText(patient.getAddress());
	textFieldPhone.setText(patient.getPhone());
	dateChooser.setDate(patient.getBirthday());
}
}
	

