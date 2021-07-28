package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DetailServiceBUS;
import BUS.implement.MedicalFormBUS;
import BUS.implement.PatientBUS;
import BUS.implement.PrescriptionBUS;
import Constant.SystemConstant;
import DTO.DetailService;
import DTO.MedicalForm;
import DTO.Patient;
import DTO.Prescription;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class HistoryRecord extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtBirthday;
	private JTextField txtICard;
	private static int id_Form;
	private JRadioButton Male ;
	private JRadioButton Female ;

	private Patient patient = new Patient();
	private PatientBUS patientProcess = new PatientBUS();
	private PrescriptionBUS prescription = new PrescriptionBUS();
	private DetailServiceBUS detailService = new DetailServiceBUS();
	private MedicalFormBUS medicalForm = new MedicalFormBUS();
	
	DefaultTableModel defaultTable = new DefaultTableModel();
	DefaultTableModel defaultTable1 = new DefaultTableModel();
	DefaultTableModel defaultTable2= new DefaultTableModel();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryRecord frame = new HistoryRecord(id_Form);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HistoryRecord(int id) {
		id_Form = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 684);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Patient Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 34, 393, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fullname");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 39, 59, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 82, 59, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Birthday");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 126, 59, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Identified Card");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 174, 98, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 216, 74, 13);
		panel.add(lblNewLabel_4);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setOpaque(false);
		txtName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null));
		txtName.setBounds(155, 37, 228, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setOpaque(false);
		txtAddress.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionBorder, null, null, null));
		txtAddress.setBounds(155, 80, 228, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtBirthday = new JTextField();
		txtBirthday.setEditable(false);
		txtBirthday.setOpaque(false);
		txtBirthday.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null));
		txtBirthday.setBounds(155, 124, 228, 20);
		panel.add(txtBirthday);
		txtBirthday.setColumns(10);
		
		txtICard = new JTextField();
		txtICard.setEditable(false);
		txtICard.setOpaque(false);
		txtICard.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.activeCaptionBorder, null, null, null));
		txtICard.setBounds(155, 172, 228, 20);
		panel.add(txtICard);
		txtICard.setColumns(10);
		
		Male = new JRadioButton("Male");
		Male.setForeground(new Color(0, 51, 153));
		Male.setOpaque(false);
		Male.setFont(new Font("Tahoma", Font.BOLD, 12));
		Male.setBackground(SystemColor.activeCaption);
		Male.setBounds(155, 213, 103, 21);
		panel.add(Male);
		
		Female = new JRadioButton("Female");
		Female.setForeground(new Color(0, 51, 153));
		Female.setOpaque(false);
		Female.setBackground(SystemColor.activeCaption);
		Female.setFont(new Font("Tahoma", Font.BOLD, 12));
		Female.setBounds(284, 213, 103, 21);
		panel.add(Female);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of record", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(428, 34, 563, 262);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 543, 231);
		panel_1.add(scrollPane);
		
		table = new JTable(defaultTable);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				showTable1(id);
				showTable2(id);
			}
			
			
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dental Service Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 349, 496, 221);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 28, 476, 183);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable(defaultTable2);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prescription Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(526, 349, 465, 221);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 31, 445, 180);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable(defaultTable1);
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_exit2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 16));
		btnNewButton.setBounds(920, 602, 40, 35);
		contentPane.add(btnNewButton);
		getInit();
	}
	
	public void getInit() {
	    patient = patientProcess.findOne(id_Form);
		txtName.setText(patient.getFullname());
		txtBirthday.setText(String.valueOf(patient.getBirthday()));
		txtAddress.setText(patient.getAddress());
		txtICard.setText(patient.getiCard());
		if (patient.getGender()) {
			Male.setSelected(true);
		} else 
			Female.setSelected(true);
		showTable();
	}
	
	public void showTable() {
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Name_Doctor","Date_Cure","Status_Before_Of_Patient","Status_After_Of_Patient","Content_Cure"
		});
		
		List<MedicalForm> list = medicalForm.searchByIDPatient(id_Form);
		for (MedicalForm i:list) {
			Object[] o = new Object[] {
				i.getId(),i.getStaff().getFullname(),i.getDateCure(),i.getStatusBeforeCure(),i.getStatusAfterCure(),i.getContentCure()	
			};
			defaultTable.addRow(o);
		}
		
		
	}
	
	public void showTable1(int id) {
			defaultTable1.setRowCount(0);
			defaultTable1.setColumnIdentifiers(new String[] {
					"STT","Name_Medicine","Quantity","Price","Usages","Note"
			});
			
			List<Prescription> list = prescription.findAll(id);
			for (Prescription i: list) {
				Object[] row = new Object[] {
						i.getId(),i.getMedicine().getNameMedicine(),i.getQuantity(),i.getPrice(),i.getUsage(),i.getNote()
				};
				defaultTable1.addRow(row);
			}
		}
		
	
	
	public void showTable2(int id) {
		defaultTable2.setRowCount(0);
		defaultTable2.setColumnIdentifiers(new String[] {
				"ID","Name_Service","Unit","Quantity","Warranty","Price"
		});
		List<DetailService> list = detailService.findAll(id);
		for (DetailService i:list) {
			Object[] row = new Object[] {
					i.getId(),i.getDentalService().getNameService(),i.getDentalService().getUnit(),i.getQuantity(),i.getDentalService().getWarranty(),i.getPrice()
			};
			defaultTable2.addRow(row);
		}
	}
}
