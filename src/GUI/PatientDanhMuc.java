package GUI;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.PatientBUS;
import DTO.Patient;

public class PatientDanhMuc extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel defaultTable = new DefaultTableModel();
	private PatientBUS patient = new PatientBUS();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientDanhMuc frame = new PatientDanhMuc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PatientDanhMuc() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 564);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm b\u1EC7nh nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 959, 133);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch b\u1EC7nh nh\u00E2n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 153, 959, 385);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 927, 334);
		panel_1.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
		showTable(patient.findAll());
	}
	public void showTable(List<Patient> list) {
		String gender;
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Fullname","Gender","Birthday","Phone","Address","Identified Card"
		});
		
		for (Patient i :list) {
			if (i.getGender()) gender="Nam"; else gender="Nữ";
			Object[] row = new Object[] {
					i.getId(),i.getFullname(),gender,i.getBirthday(),i.getPhone(),i.getAddress(),i.getiCard()
			};
			defaultTable.addRow(row);
		}
	}
}
