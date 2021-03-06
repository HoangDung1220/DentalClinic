package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import Constant.SystemConstant;
import DTO.Patient;
import PAGING.PageRequest;
import PAGING.Pageble;

public class PatientStatisticalGui extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldSL;
	private static JTextField textFieldMale;
	private static JTextField textFieldFemale;
	private JTable table;
	private JDateChooser dateChooserFrom , dateChooserTo;
	private JButton btnNewButtonListPatient;
	private JButton btnNewButton;
	private IPatientBUS patient = new PatientBUS();
	private static int totalPages;
	private JLabel lbpage;
	private JLabel lbtotalpage;
	private Date date01 = Date.valueOf("2020-01-01");
	private Date date02 = Date.valueOf("2022-01-01");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientStatisticalGui frame = new PatientStatisticalGui();
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
	public static void setColumn(Vector<String> v)
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
	}
	public static void getDataToRow(Vector<Object> row, Patient p)
	{
		row.add(p.getId());
		row.add(p.getFullname());
		if (p.getGender()==true) {
			row.add("Nam");
		} else row.add("Nu");
		row.add(p.getBirthday());
		row.add(p.getPhone());
		row.add(p.getAddress());
		row.add(p.getiCard());
		row.add(p.getCreatedBy());
		row.add(p.getCreatedDate());
		row.add(p.getModifiedBy());
		row.add(p.getModifiedDate());
	}

	// get data to DefaultTableModel
		public static DefaultTableModel showDataToTable(Date d1, Date d2)  
		{
			int count =0, countMale=0, countFemale=0;
			DefaultTableModel model =new DefaultTableModel();
			Vector<String> column =new Vector<String>();
			setColumn(column);
	        model.setColumnIdentifiers(column);
	        IPatientBUS patient = new PatientBUS();
			List<Patient> list =new ArrayList<Patient>();
			list= patient.findAll();     // find all patient

			if (d1.compareTo(d2)<=0)
			{
				for (int i=0;i<list.size();i++)
				{
					Patient p=(Patient)list.get(i);
					@SuppressWarnings("deprecation")
					Date date =new Date(p.getCreatedDate().getYear(), p.getCreatedDate().getMonth(),p.getCreatedDate().getDate());
					if (date.compareTo(d1)>=0 && date.compareTo(d2)<=0 )
					{   if (p.getGender()==false) countFemale++;
					    else if (p.getGender()==true) countMale++;
						Vector<Object> row =new Vector<Object>();
	    				getDataToRow(row,p);				
	    				model.addRow(row);	
	    				count++;
					}



				}
			}
			else JOptionPane.showMessageDialog(null, "Please select the start date before the end date !");

			textFieldSL.setText(""+count);
			textFieldFemale.setText(""+countFemale);
			textFieldMale.setText(""+countMale);
			return model;
		 }

		public static DefaultTableModel showDataToTable1()  
		{
			int count =0, countMale=0, countFemale=0;
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
					
					{   if (p.getGender()==false) countFemale++;
					    else if (p.getGender()==true) countMale++;
						Vector<Object> row =new Vector<Object>();
	    				getDataToRow(row,p);				
	    				model.addRow(row);	
	    				count++;
					}



				}
			

			textFieldSL.setText(""+count);
			textFieldFemale.setText(""+countFemale);
			textFieldMale.setText(""+countMale);
			return model;
		 }
		
		public static DefaultTableModel showDataToTable2(List<Patient> list)  
		{
			int count =0, countMale=0, countFemale=0;
			DefaultTableModel model =new DefaultTableModel();
			Vector<String> column =new Vector<String>();
			setColumn(column);
	        model.setColumnIdentifiers(column);

			
				for (int i=0;i<list.size();i++)
				{
					Patient p=(Patient)list.get(i);
					
					{   if (p.getGender()==false) countFemale++;
					    else if (p.getGender()==true) countMale++;
						Vector<Object> row =new Vector<Object>();
	    				getDataToRow(row,p);				
	    				model.addRow(row);	
	    				count++;
					}



				}
			

		
			return model;
		 }

	public PatientStatisticalGui() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 662);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("From day:");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(105, 43, 85, 14);
		contentPane.add(lblNewLabel);

		JLabel lblThngKBnh = new JLabel("Patient Statistics");
		lblThngKBnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKBnh.setForeground(new Color(0, 51, 153));
		lblThngKBnh.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThngKBnh.setFont(new Font("Sitka Text", Font.BOLD, 19));
		lblThngKBnh.setBackground(Color.GRAY);
		lblThngKBnh.setBounds(243, 11, 540, 23);
		contentPane.add(lblThngKBnh);

		JLabel lblnNgy = new JLabel("To day:");
		lblnNgy.setForeground(new Color(0, 51, 153));
		lblnNgy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblnNgy.setBackground(Color.GRAY);
		lblnNgy.setBounds(576, 43, 85, 14);
		contentPane.add(lblnNgy);

	    dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(200, 43, 112, 20);
		dateChooserFrom.setDate(date01);
		contentPane.add(dateChooserFrom);

	    dateChooserTo = new JDateChooser();
	    dateChooserTo.setDate(new Timestamp(System.currentTimeMillis()));
		dateChooserTo.setBounds(647, 43, 112, 20);
		contentPane.add(dateChooserTo);

		btnNewButtonListPatient = new JButton("");
		btnNewButtonListPatient.setToolTipText("Search Data");
		btnNewButtonListPatient.setBounds(833, 42, 40, 35);
		btnNewButtonListPatient.setIcon(new ImageIcon(SystemConstant.img_search1));
		contentPane.add(btnNewButtonListPatient);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.text));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 87, 953, 527);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblSLng = new JLabel("Total:");
		lblSLng.setForeground(new Color(0, 51, 153));
		lblSLng.setBounds(88, 11, 66, 25);
		panel.add(lblSLng);
		lblSLng.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSLng.setBackground(Color.GRAY);

		textFieldSL = new JTextField();
		textFieldSL.setFont(new Font("Tahoma", Font.BOLD, 10));
		textFieldSL.setForeground(new Color(0, 51, 0));
		textFieldSL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldSL.setBounds(178, 15, 81, 20);
		textFieldSL.enable(false);
		panel.add(textFieldSL);
		textFieldSL.setColumns(10);

		JLabel lblNam = new JLabel("Male:");
		lblNam.setForeground(new Color(0, 51, 153));
		lblNam.setBounds(478, 11, 44, 25);
		lblNam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNam.setBackground(Color.GRAY);
		panel.add(lblNam);

		JLabel lblN = new JLabel("Female:");
		lblN.setForeground(new Color(0, 51, 153));
		lblN.setBounds(726, 11, 110, 25);
		lblN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblN.setBackground(Color.GRAY);
		panel.add(lblN);

		textFieldMale = new JTextField();
		textFieldMale.setFont(new Font("Tahoma", Font.BOLD, 10));
		textFieldMale.setForeground(new Color(0, 51, 153));
		textFieldMale.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldMale.setBounds(559, 15, 55, 20);
		textFieldMale.setColumns(10);
		textFieldMale.enable(false);
		panel.add(textFieldMale);

		textFieldFemale = new JTextField();
		textFieldFemale.setFont(new Font("Tahoma", Font.BOLD, 10));
		textFieldFemale.setForeground(new Color(0, 51, 102));
		textFieldFemale.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldFemale.setBounds(846, 15, 55, 20);
		textFieldFemale.setColumns(10);
		textFieldFemale.enable(false);
		panel.add(textFieldFemale);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 933, 387);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBounds(883, 41, 40, 35);
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_exit3));
		contentPane.add(btnNewButton);


		btnNewButtonListPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				    SimpleDateFormat month =new SimpleDateFormat ("MM");
				    SimpleDateFormat year =new SimpleDateFormat ("yyyy");
			        SimpleDateFormat day =new SimpleDateFormat ("dd");

			        String m =month.format(dateChooserFrom.getDate());	    
			        String y =year.format(dateChooserFrom.getDate());
			        String d =day.format(dateChooserFrom.getDate());

			        @SuppressWarnings("deprecation")
					Date date1 = new Date(Integer.parseInt(y)-1900, Integer.parseInt(m)-1, Integer.parseInt(d));


			        String m1 =month.format(dateChooserTo.getDate());
			        String y1 =year.format(dateChooserTo.getDate());
			        String d1 =day.format(dateChooserTo.getDate());

			        @SuppressWarnings("deprecation")
					Date date2 = new Date(Integer.parseInt(y1)-1900, Integer.parseInt(m1)-1, Integer.parseInt(d1));
			        date01 = date1;
			        date02 = date2;
			        if (date01.compareTo(date02)<0) {
				    Patient p = paging(1,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);
				    table.setModel(showDataToTable2(p.getList()));
					decorPaging(p);

			        } else 
			        {
			        	   Patient p = new Patient();
						    table.setModel(showDataToTable2(p.getList()));
							decorPaging(p);
			        }

			}
			
		});
	    table.setModel(showDataToTable1());
	    
	    JButton btnfirst = new JButton("<<");
	    btnfirst.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    btnfirst.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Patient s= paging(1,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);
				decorPaging(s);
			    table.setModel(showDataToTable2(s.getList()));
	    	}
	    });
	    btnfirst.setOpaque(false);
	    btnfirst.setBackground(SystemColor.activeCaption);
	    btnfirst.setForeground(new Color(0, 51, 204));
	    btnfirst.setFont(new Font("Tahoma", Font.BOLD, 10));
	    btnfirst.setBounds(323, 464, 60, 21);
	    panel.add(btnfirst);
	    
	    JButton btnbefore = new JButton("<");
	    btnbefore.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    btnbefore.setBackground(SystemColor.activeCaption);
	    btnbefore.setOpaque(false);
	    btnbefore.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage>1) {
				String page = String.valueOf(--currentPage);
	    		Patient s= paging(currentPage,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);

				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
			    table.setModel(showDataToTable2(s.getList()));
				} else 
				{
		    		Patient s= paging(currentPage,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);

				    table.setModel(showDataToTable2(s.getList()));

				}
	    	}
	    });
	    btnbefore.setForeground(new Color(0, 51, 204));
	    btnbefore.setFont(new Font("Tahoma", Font.BOLD, 10));
	    btnbefore.setBounds(393, 464, 55, 21);
	    panel.add(btnbefore);
	    
	    lbpage = new JLabel("");
	    lbpage.setHorizontalAlignment(SwingConstants.CENTER);
	    lbpage.setBounds(446, 468, 45, 13);
	    panel.add(lbpage);
	    
	    lbtotalpage = new JLabel("");
	    lbtotalpage.setHorizontalAlignment(SwingConstants.CENTER);
	    lbtotalpage.setBounds(489, 468, 45, 13);
	    panel.add(lbtotalpage);
	    
	    JButton lbafter = new JButton(">");
	    lbafter.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    lbafter.setBackground(SystemColor.activeCaption);
	    lbafter.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage<totalPages) {
				String page = String.valueOf(++currentPage);
	    		Patient s= paging(currentPage,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);

				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
			    table.setModel(showDataToTable2(s.getList()));
				} else 
				{
		    		Patient s= paging(currentPage,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);

				    table.setModel(showDataToTable2(s.getList()));

				}
				
	    	}
	    });
	    lbafter.setOpaque(false);
	    lbafter.setForeground(new Color(0, 51, 204));
	    lbafter.setFont(new Font("Tahoma", Font.BOLD, 10));
	    lbafter.setBounds(543, 464, 55, 21);
	    panel.add(lbafter);
	    
	    JButton lblast = new JButton(">>");
	    lblast.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    lblast.setBackground(SystemColor.activeCaption);
	    lblast.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Patient s= paging(totalPages,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);

				decorPaging(s);
			    table.setModel(showDataToTable2(s.getList()));

	    	}
	    });
	    lblast.setOpaque(false);
	    lblast.setForeground(new Color(0, 51, 204));
	    lblast.setFont(new Font("Tahoma", Font.BOLD, 10));
	    lblast.setBounds(608, 464, 60, 21);
	    panel.add(lblast);
	    showDataToTable1();
	   
	    	    	   
	    Patient p = paging(1,SystemConstant.LIMITStatic,patient.findAllPage(date01, date02),date01,date02);
	    table.setModel(showDataToTable2(p.getList()));
		decorPaging(p);

	}
	public Patient paging(int page,int limit,List<Patient> list,Date date1, Date date2){
		Patient s= new Patient();
		int totalItem = list.size();
		int totalPage = (int) Math.ceil(((double) totalItem)/limit);
		Pageble pageable =  new PageRequest(page, limit);
		List<Patient> listPaging = patient.findAllPage(pageable, date1, date2);
		s.setTotalItem(totalItem);
		s.setTotalPage(totalPage);
		s.setPage(page);
		s.setLimit(limit);
		s.setList(listPaging);
		totalPages = s.getTotalPage();
		return s;
	}
	
	public void decorPaging(Patient p) {
		lbpage.setText(String.valueOf(p.getPage()));
		lbtotalpage.setText(p.getPage()+"/"+p.getTotalPage());

	}
}