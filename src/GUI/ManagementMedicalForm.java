package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.MedicalFormBUS;
import DTO.MedicalForm;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementMedicalForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textSearch;
	private JCheckBox checkName ;
	private JCheckBox checkDate ;


	MedicalFormBUS medicalForm = new MedicalFormBUS();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel defaultTable = new DefaultTableModel();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementMedicalForm frame = new ManagementMedicalForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagementMedicalForm() {
		showTable(medicalForm.findAll());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 458);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Create = new JButton("Create New Medical Form");
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateMedicalForm form1 = new CreateMedicalForm();
				form1.show();
			}
		});
		Create.setBounds(394, 22, 213, 26);
		contentPane.add(Create);
		Create.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(630, 22, 126, 26);
		contentPane.add(Exit);
		Exit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Medical Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 60, 100, 15);
		contentPane.add(lblNewLabel);
		
		JCheckBox checkAll = new JCheckBox("All",true);
		checkAll.setToolTipText("");
		checkAll.setBackground(SystemColor.activeCaption);
		checkAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkAll.setBounds(336, 57, 93, 21);
		contentPane.add(checkAll);
		
		checkName = new JCheckBox("Name_Patient");
		checkName.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkName.setBackground(SystemColor.activeCaption);
		checkName.setBounds(457, 57, 126, 21);
		contentPane.add(checkName);
		
		checkDate = new JCheckBox("Date_Cure");
		checkDate.setBackground(SystemColor.activeCaption);
		checkDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		checkDate.setBounds(640, 57, 93, 21);
		contentPane.add(checkDate);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch Medical_Form", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel.setBounds(10, 147, 746, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 726, 234);
		panel.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u1EA5n Enter \u0111\u1EC3 t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.controlLtHighlight));
		panel_1.setBounds(10, 80, 746, 57);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textSearch = new JTextField();
		textSearch.setBounds(10, 15, 361, 32);
		panel_1.add(textSearch);
		textSearch.setColumns(10);
		
		JDateChooser dateSearch = new JDateChooser();
		dateSearch.setBounds(393, 15, 343, 32);
		panel_1.add(dateSearch);
		textSearch.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					JOptionPane.showMessageDialog(null, "ok");
					String st = sdf.format(dateSearch.getDate());
				    Date date1 = Date.valueOf(st);
					List<MedicalForm> list = medicalForm.search(checkName.isSelected(), checkDate.isSelected(), textSearch.getText(),date1);
					showTable(list);
					
				}
			}
	
		});
		
	}
	
	public void showTable(List<MedicalForm> list) {
		defaultTable.setColumnIdentifiers(new Object[] {
			"ID","Name_Patient","Name_Doctor","Date_Cure",""
		});
		
		for (MedicalForm i :list ) {
			Object[] row = new Object[] {
				i.getId(),i.getPatient().getFullname(),i.getStaff().getFullname(),i.getDateCure()	
			};
			defaultTable.addRow(row);
		}
	}
	

}
