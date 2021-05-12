package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.MedicineBUS;
import BUS.implement.PrescriptionBUS;
import BUS.implement.TypeMedicineBUS;
import Constant.SystemConstant;
import DTO.Medicine;
import DTO.Prescription;
import DTO.TypeMedicine;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MedicalDetail extends JFrame {

	private JPanel contentPane;
	private JTextField txtNameSearch;
	private JTextField txtID;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTable table;
	private JTable table_1;
	private JTextArea txtUsage;
	private JTextArea txtNote ;

	private TypeMedicineBUS typeMedicine = new TypeMedicineBUS();
	private MedicineBUS medicine = new  MedicineBUS();
	private PrescriptionBUS prescription = new PrescriptionBUS();

	JComboBox<TypeMedicine> comboTypeSearch;
	JComboBox<String> comboUnit ;
	DefaultTableModel defaultTable = new DefaultTableModel();
	DefaultTableModel defaultTable1 = new DefaultTableModel();


		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalDetail frame = new MedicalDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MedicalDetail() {
		showTable1();

		showTable(medicine.findAll());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 640);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 74, 572, 224);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 550, 189);
		panel.add(scrollPane_1);
		
		table = new JTable(defaultTable);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
			
				int index = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				setDataToGui(id);
				
				
			}
			
			
		});
		
		table.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent action) {
				if (action.getKeyCode()==KeyEvent.VK_UP || action.getKeyCode()==KeyEvent.VK_DOWN) {
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					setDataToGui(id);
				}
				
			}
			
		});
		scrollPane_1.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(602, 74, 454, 243);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID_Medicine");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(37, 27, 96, 13);
		panel_1.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(179, 21, 96, 21);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Unit");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(37, 65, 45, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(37, 108, 112, 13);
		panel_1.add(lblNewLabel_4);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(179, 105, 96, 21);
		panel_1.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		comboUnit = new JComboBox<String>();
		comboUnit.setBounds(179, 62, 96, 21);
		for (String i:SystemConstant.listConstant)
			comboUnit.addItem(i);
		panel_1.add(comboUnit);
		
		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(37, 139, 45, 21);
		panel_1.add(lblNewLabel_5);
		
		txtPrice = new JTextField();
		txtPrice.setEnabled(false);
		txtPrice.setBounds(179, 136, 96, 21);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton Save = new JButton("SAVE");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prescription p = getDataByGui();
				txtPrice.setText(String.valueOf(p.getPrice()));
				prescription.insert(p);
				showTable1();
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(327, 24, 96, 21);
		panel_1.add(Save);
		
		JButton Edit = new JButton("EDIT");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table_1.getSelectedRow();
				int id = Integer.parseInt(table_1.getValueAt(index, 0).toString());
				
				Prescription pre = getDataByGui();
				pre.setId(id);
				prescription.update(pre);
				showTable1();
			}
		});
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.setBounds(328, 79, 96, 21);
		panel_1.add(Edit);
		
		JButton Delete = new JButton("DELETE");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] indexs = table_1.getSelectedRows();
				List<Integer> list = new ArrayList<Integer>();
				for (int i: indexs) {
					list.add(Integer.parseInt(table_1.getValueAt(i, 0).toString()));
				}
				prescription.delete(list);
				showTable1();
				
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(327, 138, 96, 21);
		panel_1.add(Delete);
		
		JLabel lblNewLabel_6 = new JLabel("Usage");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(37, 179, 45, 19);
		panel_1.add(lblNewLabel_6);
		
		txtUsage = new JTextArea();
		txtUsage.setBounds(179, 177, 265, 27);
		panel_1.add(txtUsage);
		
		JLabel lblNewLabel_7 = new JLabel("Note");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(37, 220, 45, 13);
		panel_1.add(lblNewLabel_7);
		
		txtNote = new JTextArea();
		txtNote.setBounds(179, 214, 265, 27);
		panel_1.add(txtNote);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch thu\u1ED1c trong b\u1EC7nh \u00E1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(20, 327, 1036, 232);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 30, 1016, 192);
		panel_2.add(scrollPane_2);
		
		table_1 = new JTable(defaultTable1);
		table_1.addMouseListener(new MouseAdapter() {

			

			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				int id = Integer.parseInt(table_1.getValueAt(index, 0).toString());
				setDataToGui1(id);
			}
			
		});
		

		table_1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent action) {
				if (action.getKeyCode()==KeyEvent.VK_UP || action.getKeyCode()==KeyEvent.VK_DOWN) {
					int row = table_1.getSelectedRow();
					int id = Integer.parseInt(table_1.getValueAt(row, 0).toString());
					setDataToGui1(id);
				}
				
			}
			
		});
	
		scrollPane_2.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(20, 10, 1036, 54);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Type_Medicine");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 22, 114, 19);
		panel_3.add(lblNewLabel_1);
		
	    comboTypeSearch = new JComboBox<TypeMedicine>();
		comboTypeSearch.setBounds(146, 22, 225, 21);
		comboTypeSearch.addItem(new TypeMedicine(0,"all","All"));
		List<TypeMedicine> list = typeMedicine.findAll();
		for (TypeMedicine i: list) {
			comboTypeSearch.addItem(i);
		}
		panel_3.add(comboTypeSearch);
		
		JButton Search = new JButton("SEARCH");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idType = ((TypeMedicine) (comboTypeSearch.getSelectedItem())).getId();
				String name = txtNameSearch.getText();
				
				List<Medicine> list = medicine.searchByNameAndIDType(name, idType);
				showTable(list);
			}
		});
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(874, 22, 119, 21);
		panel_3.add(Search);
		
		JLabel lblNewLabel = new JLabel("Name_Medicine");
		lblNewLabel.setBounds(410, 21, 119, 24);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtNameSearch = new JTextField();
		txtNameSearch.setBounds(539, 25, 199, 19);
		panel_3.add(txtNameSearch);
		txtNameSearch.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("EXIT ");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(922, 569, 85, 21);
		contentPane.add(btnNewButton_4);
	}
	
	public void showTable(List<Medicine> list) {
		defaultTable.setRowCount(0);

		String[] columns = {"ID","Name_Type","Name_Medicine","Unit","Price","Quantity"};
		defaultTable.setColumnIdentifiers(columns);
		for (Medicine i: list) {
			Object[] row = new Object[] {
					i.getId(),i.getTypeMedicine().getName(),i.getNameMedicine(),i.getUnit(),i.getPrice(),i.getQuantity()
			};
			defaultTable.addRow(row);
			
		}
	}
	
	public void showTable1() {
		defaultTable1.setRowCount(0);
		defaultTable1.setColumnIdentifiers(new String[] {
				"STT","Name_Medicine","Quantity","Price","Usages","Note"
		});
		
		List<Prescription> list = prescription.findAll(1);
		for (Prescription i: list) {
			Object[] row = new Object[] {
					i.getId(),i.getMedicine().getNameMedicine(),i.getQuantity(),i.getPrice(),i.getUsage(),i.getNote()
			};
			defaultTable1.addRow(row);
		}
	}
	
	public void setDataToGui1(int id) {
		Prescription pre = prescription.findOne(id);
		txtID.setText(String.valueOf(pre.getIdMedicine()));
		comboUnit.setSelectedItem(pre.getMedicine().getUnit());
		txtQuantity.setText(String.valueOf(pre.getQuantity()));
		txtPrice.setText(String.valueOf(pre.getPrice()));
		txtUsage.setText(pre.getUsage());
		txtNote.setText(pre.getNote());
		
	}
		
	public void setDataToGui(int id) {
			Medicine m = medicine.findOne(id);
			txtID.setText(String.valueOf(m.getId()));
			comboUnit.setSelectedItem(m.getUnit());
			
		
	}
	
	public Prescription getDataByGui() {
		Prescription pre = new Prescription();
		pre.setIdMedicine(Integer.parseInt(txtID.getText()));
		pre.setQuantity(Integer.parseInt(txtQuantity.getText()));
		pre.setNote(txtNote.getText());
		pre.setUsage(txtUsage.getText());
		Double price1 = (medicine.findOne(Integer.parseInt(txtID.getText()))).getPrice()*Integer.parseInt(txtQuantity.getText());
		pre.setPrice(price1);
		pre.setIdMedicalForm(1);
		return pre;
	}
		
}
