package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import DTO.Patient;
import javax.swing.JScrollPane;

public class ManagerPatient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	DefaultTableModel defaultTable = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	PatientBUS patient= new PatientBUS();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPatient frame = new ManagerPatient();
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
	public ManagerPatient() {
		setBackground(new Color(135, 206, 235));
		setTitle("Management Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGEMENT PATIENTS");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(238, 10, 200, 41);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 97, 609, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("FULLNAME: ");
		lblNewLabel_1.setBounds(49, 10, 81, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ICARD: ");
		lblNewLabel_2.setBounds(49, 37, 57, 22);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(140, 12, 144, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 39, 168, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton.setBounds(462, 24, 108, 35);
		panel.add(btnNewButton);
		
		showTable("", "");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 141, 77);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 0, 121, 78);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\PC\\Downloads\\Screenshot 2021-05-27 145134.jpg"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 609, 207);
		contentPane.add(scrollPane);
		
		table = new JTable(defaultTable);
		table.setFont(new Font("Tahoma", Font.PLAIN, 8));
		scrollPane.setViewportView(table);
		table.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
			//	setDataByGUI(id);
			}
			
		});
		
		table.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_KP_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					//setDataByGUI(id);
				}
				super.keyReleased(e);
			}
			
		});
		
		showTable("", "");
		
	}
	
	
	public DefaultTableModel showTable(String name, String icard)
	{
		IPatientBUS patient = new PatientBUS();
		List<Patient> list = new ArrayList<Patient>();
		list = patient.findAll();
		String gender;
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID", "FULLNAME", "GENDER", "ICARD", "ADDRESS", "DAY OF BIRTH", "PHONENUMBER"
		});
		
		for (Patient i : list) {
			if (i.getGender())
				gender = "Nam";
			else
				gender = "Nữ";
			Object[] row = new Object[] { i.getId(), i.getFullname(), gender, i.getiCard(), i.getAddress(),
					i.getBirthday(), i.getPhone()

			};
		}
		return defaultTable;
	}
}
