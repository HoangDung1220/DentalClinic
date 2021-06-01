package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.IPatientBUS;
import BUS.implement.PatientBUS;
import Constant.SystemConstant;
import DTO.Patient;

public class PatientDanhMuc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	DefaultTableModel defaultTable = new DefaultTableModel();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private IPatientBUS patient1 = new PatientBUS();
	private JTable table;

	
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

	/**
	 * Create the frame.
	 */
	public PatientDanhMuc() {
		showTable(patient1.findAll());
		setBackground(new Color(135, 206, 235));
		setTitle("Management Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 492);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANAGEMENT PATIENTS");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(334, 10, 200, 41);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 97, 829, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("FULLNAME: ");
		lblNewLabel_1.setBounds(49, 10, 81, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ICARD: ");
		lblNewLabel_2.setBounds(49, 37, 57, 22);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setOpaque(false);
		textField.setBounds(140, 12, 221, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setBounds(140, 39, 221, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Search");
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_search1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullname = textField.getText();
				String icard = textField_1.getText();
				
				defaultTable.setRowCount(0);
				if(fullname.length() == 0 && icard.length() == 0)
				{
					JOptionPane.showMessageDialog(null, "nhap đi");
					showTable(patient1.findAll());
				}
				else
				{
					if(fullname.length() != 0 && icard.length() != 0)
					{
						showTable(patient1.searchByNameAndIcard(fullname, icard));
					}
					if(fullname.length() != 0 && icard.length() == 0)
					{
						showTable(patient1.searchByName(fullname));	
					}
					if(fullname.length() == 0 && icard.length() != 0)
					{
						showTable(patient1.searchByIcard(icard));
					}
				}
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton.setBounds(557, 24, 40, 35);
		panel.add(btnNewButton);
		
		JButton btnReset = new JButton("");
		btnReset.setToolTipText("Reset");
		btnReset.setIcon(new ImageIcon(SystemConstant.img_new));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTable(patient1.findAll());
			}
		});
		btnReset.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnReset.setBackground(new Color(135, 206, 235));
		btnReset.setBounds(625, 24, 40, 35);
		panel.add(btnReset);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setToolTipText("Exit");
		btnNewButton_1.setBounds(688, 24, 40, 35);
		btnNewButton_1.setIcon(new ImageIcon(SystemConstant.img_exit3));
		panel.add(btnNewButton_1);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 10, 125, 84);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 0, 105, 78);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(SystemConstant.img_patient));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 829, 254);
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
					
				}
				super.keyReleased(e);
			}
			
		});
		
	}
	
	
	public void showTable(List<Patient> list)
	{
		String gender;
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID", "FULLNAME", "GENDER", "ICARD", "ADDRESS", "DAY OF BIRTH", "PHONENUMBER", "CREATED BY",
		  "CREATED DATE", "MODIFIED BY", "MODIFIED BY"});
		
		for (Patient i : list) {
			if (i.getGender())
				gender = "Nam";
			else
				gender = "Nữ";
		/*	if(i.getStatus() == 0)
			{
				status = "New patient";
			}
			else
			{
				status = "Existed";
			}
				*/
			Object[] row = new Object[] { i.getId(), i.getFullname(), gender, i.getiCard(), i.getAddress(),
					i.getBirthday(), i.getPhone(), i.getCreatedBy(), i.getCreatedDate(), i.getModifiedBy(), i.getModifiedDate()

			};
			 defaultTable.addRow(row);
		}

	}
}
