package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import Constant.SystemConstant;
import DTO.Patient;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class PatientStatisticalGui extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldSL;
	private static JTextField textFieldMale;
	private static JTextField textFieldFemale;
	private JTable table;
	private JDateChooser dateChooserFrom , dateChooserTo;
	private JButton btnNewButtonListPatient;
	private JButton btnNewButton;

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


	public PatientStatisticalGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 987, 662);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("From day:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(105, 43, 85, 14);
		contentPane.add(lblNewLabel);

		JLabel lblThngKBnh = new JLabel("TH\u1ED0NG K\u00CA B\u1EC6NH NH\u00C2N");
		lblThngKBnh.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThngKBnh.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblThngKBnh.setBackground(Color.GRAY);
		lblThngKBnh.setBounds(379, 11, 404, 23);
		contentPane.add(lblThngKBnh);

		JLabel lblnNgy = new JLabel("To day:");
		lblnNgy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblnNgy.setBackground(Color.GRAY);
		lblnNgy.setBounds(576, 43, 85, 14);
		contentPane.add(lblnNgy);

	    dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(200, 43, 112, 20);
		contentPane.add(dateChooserFrom);

	    dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(671, 43, 112, 20);
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
		lblSLng.setBounds(88, 11, 66, 25);
		panel.add(lblSLng);
		lblSLng.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSLng.setBackground(Color.GRAY);

		textFieldSL = new JTextField();
		textFieldSL.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldSL.setOpaque(false);
		textFieldSL.setBounds(178, 15, 81, 20);
		textFieldSL.enable(false);
		panel.add(textFieldSL);
		textFieldSL.setColumns(10);

		JLabel lblNam = new JLabel("Male:");
		lblNam.setBounds(478, 11, 44, 25);
		lblNam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNam.setBackground(Color.GRAY);
		panel.add(lblNam);

		JLabel lblN = new JLabel("Female:");
		lblN.setBounds(726, 11, 110, 25);
		lblN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblN.setBackground(Color.GRAY);
		panel.add(lblN);

		textFieldMale = new JTextField();
		textFieldMale.setOpaque(false);
		textFieldMale.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldMale.setBounds(559, 15, 55, 20);
		textFieldMale.setColumns(10);
		textFieldMale.enable(false);
		panel.add(textFieldMale);

		textFieldFemale = new JTextField();
		textFieldFemale.setOpaque(false);
		textFieldFemale.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textFieldFemale.setBounds(846, 15, 55, 20);
		textFieldFemale.setColumns(10);
		textFieldFemale.enable(false);
		panel.add(textFieldFemale);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 933, 469);
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

				    table.setModel(showDataToTable(date1, date2));



			}
		});
	}
}