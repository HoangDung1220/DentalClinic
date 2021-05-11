package GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import com.toedter.calendar.JDateChooser;

import BUS.implement.MedicalFormBUS;
import DTO.MedicalForm;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class CreateMedicalForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtForm;
	private JTextField txtNameDentist;
	private JTextField txtIDPatient;
	private JTextField txtNamePatient;
	private JButton btnNewButton;
	private JTextField txtAge;
	private JTable table;
	private JTable table_1;

	
	MedicalFormBUS form = new MedicalFormBUS();
	private JTextField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateMedicalForm frame = new CreateMedicalForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CreateMedicalForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 659);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm b\u1EC7nh nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(21, 10, 325, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IDPatient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(46, 15, 76, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(155, 15, 154, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(115, 53, 108, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin kh\u00E1m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(20, 124, 980, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("IDPatient");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(25, 20, 71, 13);
		panel_1.add(lblNewLabel_3);
		
		txtIDPatient = new JTextField();
		txtIDPatient.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtIDPatient.setBounds(149, 18, 267, 19);
		panel_1.add(txtIDPatient);
		txtIDPatient.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Name_Patient");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(25, 54, 114, 13);
		panel_1.add(lblNewLabel_4);
		
		txtNamePatient = new JTextField();
		txtNamePatient.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNamePatient.setBounds(149, 52, 267, 19);
		panel_1.add(txtNamePatient);
		txtNamePatient.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("StatusBeforeCure");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(25, 93, 121, 13);
		panel_1.add(lblNewLabel_7);
		
		JTextArea txtbefore = new JTextArea();
		txtbefore.setBackground(Color.WHITE);
		txtbefore.setBounds(151, 92, 269, 53);
		panel_1.add(txtbefore);
		
		JLabel lblNewLabel_6 = new JLabel("Content_Cure");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(458, 57, 102, 13);
		panel_1.add(lblNewLabel_6);
		
		JTextArea txtContent_cure = new JTextArea();
		txtContent_cure.setBounds(591, 56, 352, 87);
		panel_1.add(txtContent_cure);
		
		JLabel lblNewLabel_8 = new JLabel("Age");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(458, 20, 45, 17);
		panel_1.add(lblNewLabel_8);
		
		txtAge = new JTextField();
		txtAge.setBounds(588, 18, 96, 19);
		panel_1.add(txtAge);
		txtAge.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EED d\u1EE5ng d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(20, 306, 980, 104);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 960, 65);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EED d\u1EE5ng thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(21, 420, 980, 113);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 960, 78);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(356, 10, 417, 104);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("IDForm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(20, 14, 61, 22);
		panel_4.add(lblNewLabel_1);
		
		txtForm = new JTextField();
		txtForm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtForm.setBounds(95, 17, 103, 19);
		panel_4.add(txtForm);
		txtForm.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Dentist");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(208, 20, 74, 16);
		panel_4.add(lblNewLabel_2);
		
		txtNameDentist = new JTextField();
		txtNameDentist.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNameDentist.setBounds(270, 20, 139, 19);
		panel_4.add(txtNameDentist);
		txtNameDentist.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Date-Cure");
		lblNewLabel_5.setBounds(18, 61, 72, 13);
		panel_4.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton History_record = new JButton("History-Record");
		History_record.setFont(new Font("Tahoma", Font.BOLD, 13));
		History_record.setBounds(252, 57, 159, 21);
		panel_4.add(History_record);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 59, 103, 19);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(21, 543, 980, 69);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Status_After_Cure");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_9.setBounds(10, 10, 127, 13);
		panel_5.add(lblNewLabel_9);
		
		JTextArea txtAfter = new JTextArea();
		txtAfter.setBounds(159, 5, 360, 22);
		panel_5.add(txtAfter);
		
		JLabel lblNewLabel_10 = new JLabel("Note_Of_Dentist");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_10.setBounds(10, 42, 102, 13);
		panel_5.add(lblNewLabel_10);
		
		JTextArea txtNote = new JTextArea();
		txtNote.setBounds(159, 36, 360, 23);
		panel_5.add(txtNote);
		
		JButton btnNewButton_4 = new JButton("SAVE");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(581, 22, 85, 21);
		panel_5.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("EXIT");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBounds(721, 22, 85, 21);
		panel_5.add(btnNewButton_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "T\u1EA1o phi\u1EBFu", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(780, 10, 220, 104);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JButton Dental_service = new JButton("Dental_Service");
		Dental_service.setFont(new Font("Tahoma", Font.BOLD, 13));
		Dental_service.setBounds(40, 28, 156, 21);
		panel_6.add(Dental_service);
		
		JButton Medicine = new JButton("Medicine");
		Medicine.setFont(new Font("Tahoma", Font.BOLD, 13));
		Medicine.setBounds(40, 61, 156, 21);
		panel_6.add(Medicine);
	}
	
	/*public void setGui() {
		txtNamePatient.setText("Hoang Dung");
		txt
	}
	public MedicalForm getDataToGui() {
		MedicalForm m = new MedicalForm();
		m.setIdPatient(1);
		m.setIdDoctor(9);
		m.setDateCure(
				);
	}*/
}
