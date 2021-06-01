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

public class CreateMedicalFormManagements extends JFrame {

	private JPanel contentPane;
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
	private JLabel txtForm ;
	private StaffBUS staffExecute = new StaffBUS();


	StaffBUS staff_bus = new StaffBUS();
	MedicalFormBUS medical_form = new MedicalFormBUS();
	DetailServiceBUS serviceDetail = new DetailServiceBUS();
	PrescriptionBUS prescription = new PrescriptionBUS();
	MedicalFormBUS form = new MedicalFormBUS();
	PatientBUS patient = new PatientBUS();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMedicalFormManagements frame = new CreateMedicalFormManagements(medical_Form);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CreateMedicalFormManagements(MedicalForm medical_Form1) {
		medical_Form = medical_Form1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 640);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 78, 980, 197);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("IDPatient :");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		lblNewLabel_3.setBounds(25, 26, 71, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name_Patient :");
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_4.setBounds(25, 72, 114, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("StatusBeforeCure :");
		lblNewLabel_7.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_7.setBounds(25, 109, 137, 24);
		panel_1.add(lblNewLabel_7);
		
		txtbefore = new JTextArea();
		txtbefore.setEditable(false);
		txtbefore.setOpaque(false);
		txtbefore.setBorder(null);
		txtbefore.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtbefore.setBackground(SystemColor.scrollbar);
		txtbefore.setBounds(163, 109, 269, 37);
		panel_1.add(txtbefore);
		
		JLabel lblNewLabel_6 = new JLabel("Content_Cure :");
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_6.setBounds(442, 99, 102, 13);
		panel_1.add(lblNewLabel_6);
		
		txtContent_cure = new JTextArea();
		txtContent_cure.setEditable(false);
		txtContent_cure.setOpaque(false);
		txtContent_cure.setBorder(null);
		txtContent_cure.setBackground(new Color(245, 245, 245));
		txtContent_cure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContent_cure.setBounds(591, 99, 352, 64);
		panel_1.add(txtContent_cure);
		
		txtIDPatient = new JLabel("");
		txtIDPatient.setForeground(SystemColor.menu);
		txtIDPatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIDPatient.setBounds(164, 26, 252, 23);
		panel_1.add(txtIDPatient);
		
		txtNamePatient = new JLabel("");
		txtNamePatient.setForeground(SystemColor.menu);
		txtNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNamePatient.setBounds(163, 72, 257, 20);
		panel_1.add(txtNamePatient);
		
		JLabel lblNewLabel_9 = new JLabel("Status_After_Cure:");
		lblNewLabel_9.setBounds(436, 20, 127, 13);
		panel_1.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		
		txtAfter = new JTextArea();
		txtAfter.setBounds(591, 20, 360, 22);
		panel_1.add(txtAfter);
		txtAfter.setEnabled(false);
		txtAfter.setEditable(false);
		txtAfter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAfter.setOpaque(false);
		txtAfter.setBackground(new Color(211, 211, 211));
		txtAfter.setBorder(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(20, 10, 980, 58);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("IDForm :");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 14, 61, 22);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dentist :");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblNewLabel_2.setBounds(262, 14, 61, 22);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Date-Cure :");
		lblNewLabel_5.setBounds(559, 14, 88, 22);
		panel_4.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		txtDate.setEnabled(false);
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDate.setForeground(SystemColor.menu);
		
		txtDate.setBounds(669, 14, 145, 22);
		panel_4.add(txtDate);
		
		txtNameDentist = new JLabel("");
		txtNameDentist.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNameDentist.setForeground(SystemColor.menu);
		txtNameDentist.setBounds(334, 14, 221, 22);
		
		panel_4.add(txtNameDentist);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBounds(930, 14, 40, 35);
		panel_4.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				{
					int res=JOptionPane.showConfirmDialog(null, "You sure exit ","confirm", JOptionPane.YES_NO_OPTION);
					if (res== JOptionPane.YES_OPTION) {
						dispose();
					} 
				
				}}
		});
		btnNewButton_5.setToolTipText("Thoát");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setIcon(new ImageIcon(SystemConstant.img_exit3));
		
		txtForm = new JLabel("");
		txtForm.setBounds(91, 14, 96, 19);
		panel_4.add(txtForm);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EED d\u1EE5ng d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(20, 285, 980, 130);
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
		panel_3.setBounds(20, 425, 980, 135);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 960, 104);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable(defaultTable1);
		scrollPane_1.setViewportView(table_1);
		
		getInit();

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
			txtNameDentist.setText(staffExecute.findOne(medical_Form.getIdDoctor()).getFullname());
			txtNamePatient.setText(medical_Form.getPatient().getFullname());
			txtbefore.setText(medical_Form.getStatusBeforeCure());
			txtAfter.setText(medical_Form.getStatusAfterCure());
			txtContent_cure.setText(medical_Form.getContentCure());
			txtDate.setText(String.valueOf(medical_Form.getDateCure()));
			txtIDPatient.setText(String.valueOf(medical_Form.getIdPatient()));
			showTableService();
			showTable1();
			//JOptionPane.showMessageDialog(null, patientExecute.findOne(medical_Form.getIdPatient()).getFullname());

		} else
		{
			JOptionPane.showMessageDialog(null, "null");
		}

	}
}
