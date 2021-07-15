package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DetailServiceBUS;
import BUS.implement.MedicalFormBUS;
import BUS.implement.PatientBUS;
import BUS.implement.PrescriptionBUS;
import BUS.implement.StaffBUS;
import Constant.SystemConstant;
import DTO.DetailService;
import DTO.MedicalForm;
import DTO.Patient;
import DTO.Prescription;
import DTO.Staff;
import javax.swing.UIManager;

public class CreateMedicalForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtIDSearch;
	private JButton Search;
	private JTable table;
	private JTable table_1;
	private JTextArea txtbefore;
	private JTextArea txtContent_cure;
	JLabel txtDate = new JLabel("");
	private DefaultTableModel defaultTable = new DefaultTableModel();
	private DefaultTableModel defaultTable1 = new DefaultTableModel();
	private static MedicalForm medical_Form;
	private JTextArea txtAfter;
	private JLabel txtNameDentist;
	private JLabel txtIDPatient;
	private JLabel txtNamePatient;
	private JLabel txtAge;
	private JButton btnNewButton_4 ;
	private JButton History_record;
	private JButton Dental_service;
	private JButton Medicine ;
	private boolean check = false;



	StaffBUS staff_bus = new StaffBUS();
	MedicalFormBUS medical_form = new MedicalFormBUS();
	DetailServiceBUS serviceDetail = new DetailServiceBUS();
	PrescriptionBUS prescription = new PrescriptionBUS();
	MedicalFormBUS form = new MedicalFormBUS();
	PatientBUS patient = new PatientBUS();
	private JTextField txtForm;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMedicalForm frame = new CreateMedicalForm(medical_Form);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CreateMedicalForm(MedicalForm medical_Form1) {
		medical_Form = medical_Form1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 717);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm b\u1EC7nh nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(21, 10, 325, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IDPatient");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel.setBounds(46, 15, 76, 16);
		panel.add(lblNewLabel);
		
		txtIDSearch = new JTextField();
		txtIDSearch.setOpaque(false);
		txtIDSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtIDSearch.setBounds(155, 15, 154, 23);
		panel.add(txtIDSearch);
		txtIDSearch.setColumns(10);
		
		Search = new JButton("SEARCH");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idPatient = Integer.parseInt(txtIDSearch.getText());
				Patient pa = new Patient();
				pa = patient.findOne(idPatient);
				if (pa==null) {
					JOptionPane.showMessageDialog(null,"Not have data. Please check again");
				} else
				{
					txtIDPatient.setText(String.valueOf(pa.getId()));
					txtNamePatient.setText(pa.getFullname());
					Date date = new Date (System.currentTimeMillis());
					@SuppressWarnings("deprecation")
					int age = date.getYear()-pa.getBirthday().getYear();
					txtAge.setText(String.valueOf(age));
				}
			}
		});
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(115, 53, 108, 25);
		panel.add(Search);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 124, 980, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("IDPatient :");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_3.setBounds(25, 20, 71, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name_Patient :");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_4.setBounds(25, 54, 114, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("StatusBeforeCure :");
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_7.setBounds(25, 93, 137, 13);
		panel_1.add(lblNewLabel_7);
		
		txtbefore = new JTextArea();
		txtbefore.setForeground(new Color(0, 51, 204));
		txtbefore.setOpaque(false);
		txtbefore.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtbefore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtbefore.setBackground(SystemColor.scrollbar);
		txtbefore.setBounds(163, 89, 269, 28);
		panel_1.add(txtbefore);
		
		JLabel lblNewLabel_6 = new JLabel("Content_Cure :");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_6.setBounds(458, 57, 102, 13);
		panel_1.add(lblNewLabel_6);
		
		txtContent_cure = new JTextArea();
		txtContent_cure.setForeground(new Color(0, 51, 204));
		txtContent_cure.setOpaque(false);
		txtContent_cure.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtContent_cure.setBackground(new Color(245, 245, 245));
		txtContent_cure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContent_cure.setBounds(591, 56, 352, 64);
		panel_1.add(txtContent_cure);
		
		JLabel lblNewLabel_8 = new JLabel("Age :");
		lblNewLabel_8.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_8.setBounds(458, 20, 45, 17);
		panel_1.add(lblNewLabel_8);
		
		JButton Create = new JButton("");
		Create.setBounds(908, 130, 35, 30);
		Create.setIcon(new ImageIcon(SystemConstant.img_create));
		Create.setToolTipText("Tạo bệnh án");
		panel_1.add(Create);
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicalForm m = getDataByGui();
				int id = medical_form.insert(m);
				txtForm.setText(String.valueOf(id));
				JOptionPane.showMessageDialog(null, "You create medical_form successful");
				Dental_service.setEnabled(true);
				Medicine.setEnabled(true);
				
				
				
			}
		});
		Create.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtIDPatient = new JLabel("");
		txtIDPatient.setForeground(new Color(0, 51, 204));
		txtIDPatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIDPatient.setBounds(164, 16, 252, 23);
		panel_1.add(txtIDPatient);
		
		txtNamePatient = new JLabel("");
		txtNamePatient.setForeground(new Color(0, 51, 204));
		txtNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNamePatient.setBounds(163, 49, 257, 20);
		panel_1.add(txtNamePatient);
		
	    txtAge = new JLabel("");
		txtAge.setForeground(new Color(0, 51, 204));
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAge.setBounds(590, 21, 147, 13);
		panel_1.add(txtAge);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(356, 10, 644, 104);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("IDForm :");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 14, 61, 22);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dentist :");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2.setBounds(282, 17, 74, 16);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Date-Cure :");
		lblNewLabel_5.setBounds(18, 61, 88, 13);
		panel_4.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDate.setForeground(new Color(0, 51, 204));
		
		txtDate.setBounds(105, 57, 145, 22);
		panel_4.add(txtDate);
		
		txtNameDentist = new JLabel("");
		txtNameDentist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNameDentist.setForeground(new Color(0, 51, 204));
		txtNameDentist.setBounds(366, 14, 221, 22);
		panel_4.add(txtNameDentist);
		
		txtForm = new JTextField();
		txtForm.setEditable(false);
		txtForm.setBounds(102, 17, 96, 19);
		panel_4.add(txtForm);
		txtForm.setColumns(10);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EED d\u1EE5ng d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(20, 306, 980, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.controlHighlight);
		scrollPane.setBounds(10, 24, 960, 96);
		panel_2.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EED d\u1EE5ng thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(21, 446, 980, 135);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 960, 104);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable(defaultTable1);
		scrollPane_1.setViewportView(table_1);
		
				
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(21, 591, 980, 79);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Status_After_Cure");
		lblNewLabel_9.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(10, 10, 127, 13);
		panel_5.add(lblNewLabel_9);
		
		txtAfter = new JTextArea();
		txtAfter.setForeground(new Color(0, 51, 204));
		txtAfter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAfter.setOpaque(false);
		txtAfter.setBackground(new Color(211, 211, 211));
		txtAfter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAfter.setBounds(159, 5, 360, 22);
		panel_5.add(txtAfter);
		
		JLabel lblNewLabel_10 = new JLabel("Note_Of_Dentist");
		lblNewLabel_10.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(10, 42, 139, 13);
		panel_5.add(lblNewLabel_10);
		
		JTextArea txtNote = new JTextArea();
		txtNote.setForeground(new Color(0, 51, 204));
		txtNote.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNote.setOpaque(false);
		txtNote.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNote.setBounds(159, 36, 360, 23);
		panel_5.add(txtNote);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setToolTipText("Lưu thông tin sau khi khám ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicalForm m = getDataByGui();
				m.setId(Integer.parseInt(txtForm.getText()));
				medical_form.update(m);
				JOptionPane.showMessageDialog(null, "You save data successful");
				check = true;
	
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(880, 10, 40, 35);
		btnNewButton_4.setIcon(new ImageIcon(SystemConstant.img_save1));
		panel_5.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (check) {
					int res=JOptionPane.showConfirmDialog(null, "You are sure you want to exit","confirm", JOptionPane.YES_NO_OPTION);
					if (res!= JOptionPane.YES_OPTION) {
						return ;
					
				} else dispose();
					
				} else 
				{
					int res=JOptionPane.showConfirmDialog(null, "Data is not saved, you still exit ","confirm", JOptionPane.YES_NO_OPTION);
					if (res!= JOptionPane.YES_OPTION) {
						return ;
					} else dispose(); 
				}
				}
			
		});
		btnNewButton_5.setToolTipText("Thoát");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBounds(930, 10, 40, 35);
		btnNewButton_5.setIcon(new ImageIcon(SystemConstant.img_exit3));
		panel_5.add(btnNewButton_5);
		
		Medicine = new JButton("");
		Medicine.setToolTipText("Thuốc sử dụng");
		Medicine.setBounds(831, 10, 40, 35);
		panel_5.add(Medicine);
		Medicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicalDetail frame3 = new MedicalDetail(Integer.parseInt(txtForm.getText()));
				frame3.setVisible(true);
				dispose();
			}
		});
		
		Medicine.setIcon(new ImageIcon(SystemConstant.img_medicine1));
		Medicine.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Dental_service = new JButton("");
		Dental_service.setToolTipText("Dịch vụ khám ");
		Dental_service.setBounds(781, 10, 40, 35);
		panel_5.add(Dental_service);
		Dental_service.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServiceDetail frame2 = new ServiceDetail(Integer.parseInt(txtForm.getText()));
				frame2.setVisible(true);
				dispose();
				
			}
		});
		
		Dental_service.setFont(new Font("Tahoma", Font.BOLD, 13));
		Dental_service.setIcon(new ImageIcon(SystemConstant.img_dental2));
		
		History_record = new JButton("");
		History_record.setBounds(698, 8, 74, 37);
		panel_5.add(History_record);
		History_record.setIcon(new ImageIcon(SystemConstant.img_history));
		History_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HistoryRecord frame4 = new HistoryRecord(Integer.parseInt(txtIDSearch.getText()));
				frame4.setVisible(true);
				
			}
		});
		History_record.setFont(new Font("Tahoma", Font.BOLD, 13));
		History_record.setToolTipText("Lịch sử bệnh án bệnh nhân ");
		getInit();///
		GuiInit();

	}
	
	public void GuiInit() {
		
		Date date = new Date(System.currentTimeMillis());
		txtDate.setText(String.valueOf(date));
		Staff s= SystemConstant.staff;
		txtNameDentist.setText(s.getFullname());
		
		
	}
	
	public MedicalForm getDataByGui() {
		MedicalForm m = new MedicalForm();
		m.setIdDoctor(SystemConstant.staff.getId());
		m.setIdPatient(Integer.parseInt(txtIDPatient.getText()));
		m.setDateCure(Date.valueOf(txtDate.getText()));
		m.setStatusBeforeCure(txtbefore.getText());
		m.setContentCure(txtContent_cure.getText());
		m.setStatusAfterCure(txtAfter.getText());
		return m;
	}
	
	public void showTableService() {
		
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Name_Service","Unit","Quantity","Warranty","Price"
		});
		List<DetailService> list = serviceDetail.findAll(Integer.parseInt(txtForm.getText()));
		for (DetailService i:list) {
			Object[] row = new Object[] {
					i.getId(),i.getDentalService().getNameService(),i.getDentalService().getUnit(),i.getQuantity(),i.getDentalService().getWarranty(),i.getPrice()
			};
			defaultTable.addRow(row);
		}
	}
	
	
	
	public void showTable1() {
		defaultTable1.setRowCount(0);
		defaultTable1.setColumnIdentifiers(new String[] {
				"STT","Name_Medicine","Quantity","Price","Usages","Note"
		});
		
		List<Prescription> list = prescription.findAll(Integer.parseInt(txtForm.getText()));
		for (Prescription i: list) {
			Object[] row = new Object[] {
					i.getId(),i.getMedicine().getNameMedicine(),i.getQuantity(),i.getPrice(),i.getUsage(),i.getNote()
			};
			defaultTable1.addRow(row);
		}
	}
	
	
	public void getInit() {
		if (medical_Form!=null) {
			txtForm.setText(String.valueOf(medical_Form.getId()));
			txtNameDentist.setText(medical_Form.getStaff().getFullname());
			txtNamePatient.setText(medical_Form.getPatient().getFullname());
			txtbefore.setText(medical_Form.getStatusBeforeCure());
			txtContent_cure.setText(medical_Form.getContentCure());
			txtDate.setText(String.valueOf(medical_Form.getDateCure()));
			txtIDPatient.setText(String.valueOf(medical_Form.getIdPatient()));
			showTableService();
			showTable1();
		} else 
		{
			Dental_service.setEnabled(false);
			Medicine.setEnabled(false);
		}

	}
}
