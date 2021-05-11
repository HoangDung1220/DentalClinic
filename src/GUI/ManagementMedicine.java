package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.IMedicineBUS;
import BUS.ITypeMedicineBUS;
import BUS.implement.MedicineBUS;
import BUS.implement.TypeMedicineBUS;
import Constant.SystemConstant;
import DTO.Medicine;
import DTO.TypeMedicine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManagementMedicine extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchName;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTable table;
    private JTextField txtCode;
	private JScrollPane scrollPane = new JScrollPane();
	private JComboBox<TypeMedicine> comboType = new JComboBox<TypeMedicine>();
	private JComboBox<String> comboUnit = new JComboBox<String>();
	private DefaultTableModel defaultTable = new DefaultTableModel();
    private IMedicineBUS medicine = new MedicineBUS();
    private ITypeMedicineBUS typeMedicine = new TypeMedicineBUS();
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementMedicine frame = new ManagementMedicine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagementMedicine() {
		List<TypeMedicine> listType = new ArrayList<TypeMedicine>();
		listType = typeMedicine.findAll();
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 635);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		showTable(medicine.findAll());
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 321, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type_Medicine");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 49, 115, 13);
		panel.add(lblNewLabel);
		
		JComboBox<TypeMedicine> comboSearchType = new JComboBox<TypeMedicine>();
		comboSearchType.setBounds(119, 46, 167, 21);
		comboSearchType.addItem(new TypeMedicine(0,"all","All"));
		for (TypeMedicine i : listType)
			comboSearchType.addItem(i);
		   panel.add(comboSearchType);
		
		txtSearchName = new JTextField();
		txtSearchName.setBounds(119, 123, 167, 19);
		panel.add(txtSearchName);
		txtSearchName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name_Medicine");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 125, 115, 13);
		panel.add(lblNewLabel_1);
		
		JButton Search = new JButton("SEARCH");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idType = ((TypeMedicine)comboSearchType.getSelectedItem()).getId();
				String chara = txtSearchName.getText();
				defaultTable.setRowCount(0);
				List<Medicine> list = new ArrayList<Medicine>();
				list = medicine.searchByNameAndIDType(chara, idType);
				showTable(list);
				
				
				
			}
		});
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(97, 213, 115, 21);
		panel.add(Search);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(340, 10, 756, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID_Medicine");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(31, 42, 97, 13);
		panel_1.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(154, 39, 160, 19);
		
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name_medicine");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(31, 102, 140, 13);
		panel_1.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setBounds(154, 100, 160, 19);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price\r\n");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(31, 158, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(154, 156, 160, 19);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_5.setBounds(324, 42, 90, 13);
		panel_1.add(lblNewLabel_5);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(424, 39, 160, 19);
		panel_1.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Unit");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_6.setBounds(324, 102, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		JButton Save = new JButton("SAVE");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
					Medicine i = getDataByGui();
					txtID.setText(String.valueOf(medicine.insert(i)));
					JOptionPane.showMessageDialog(null, "You save data successful");
					showTable(medicine.findAll());
					refresh();   
					
			
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(622, 36, 96, 21);
		panel_1.add(Save);
		
		JButton Edit = new JButton("EDIT");
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				

				Medicine mData = getDataByGui();
				Medicine m = new Medicine();
				m.setId(id);
				m.setCodeMedicine(mData.getCodeMedicine());
				m.setIdTypeMedicine(mData.getIdTypeMedicine());
				m.setPrice(mData.getPrice());
				m.setQuantity(mData.getQuantity());
				m.setUnit(mData.getUnit());
				m.setNameMedicine(mData.getNameMedicine());
				
				medicine.update(m);
				JOptionPane.showMessageDialog(null, "You update data successful");
				showTable(medicine.findAll());
				refresh();
				
			}
		});
		Edit.setBounds(622, 98, 96, 21);
		panel_1.add(Edit);
		
		JButton Delete = new JButton("DELETE");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] listRow = table.getSelectedRows();
				List<Integer> listId = new ArrayList<Integer>(); 
				for (int i : listRow) {
					listId.add(Integer.parseInt(table.getValueAt(i, 0).toString()));
				}
				int res=JOptionPane.showConfirmDialog(null, "You are sure delete databases","confirm", JOptionPane.YES_NO_OPTION);
				if (res!= JOptionPane.YES_OPTION) {
					return ;
				} else 
				{
					medicine.delete(listId);
					showTable(medicine.findAll());
					refresh();
				}
			}
				
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(622, 168, 96, 21);
		panel_1.add(Delete);
		
		JButton Exit = new JButton("EXIT ");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(622, 228, 96, 21);
		panel_1.add(Exit);
		
		JLabel lblNewLabel_7 = new JLabel("Type_Medicine");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7.setBounds(324, 157, 109, 19);
		panel_1.add(lblNewLabel_7);
		
		comboType.setBounds(427, 155, 157, 21);
		
		
		for (TypeMedicine i : listType)
		comboType.addItem(i);
		panel_1.add(comboType);
		
		comboUnit.setBounds(424, 99, 160, 21);
		for (String i : SystemConstant.listConstant) {
		comboUnit.addItem(i);
		}
		panel_1.add(comboUnit);
		
		JLabel lblNewLabel_8 = new JLabel("Code");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_8.setBounds(31, 212, 45, 13);
		panel_1.add(lblNewLabel_8);
		
		txtCode = new JTextField();
		txtCode.setBounds(154, 209, 160, 19);
		panel_1.add(txtCode);
		txtCode.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 322, 1086, 243);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane.setBounds(10, 22, 1066, 211);
		panel_2.add(scrollPane);
		table = new JTable(defaultTable);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount()==1) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				getDataToGui(id);
				
				}
			}
			
		});
		table.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent action) {
			
			}

			@Override
			public void keyReleased(KeyEvent action) {
				if (action.getKeyCode()== KeyEvent.VK_DOWN || action.getKeyCode()== KeyEvent.VK_UP) {
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					getDataToGui(id);
				}
			}

			@Override
			public void keyTyped(KeyEvent action) {
			
			}
		});
		scrollPane.setViewportView(table);
		

	}
	
	public void showTable(List<Medicine> list) {
		defaultTable.setRowCount(0);

		String[] columns = {"ID","Name_Type","Name_Medicine","Code","Unit","Price","Quantity"};
		defaultTable.setColumnIdentifiers(columns);
		for (Medicine i: list) {
			Object[] row = new Object[] {
					i.getId(),i.getTypeMedicine().getName(),i.getNameMedicine(),i.getCodeMedicine(),i.getUnit(),i.getPrice(),i.getQuantity()
			};
			defaultTable.addRow(row);
			
		}


		
	}
	
	public Medicine getDataByGui() {
		Medicine m = new Medicine();
		
		m.setNameMedicine(txtName.getText());
		m.setPrice(Double.parseDouble(txtPrice.getText()));
		m.setQuantity(Integer.parseInt(txtQuantity.getText()));
		m.setUnit(comboUnit.getSelectedItem().toString());
		m.setIdTypeMedicine(((TypeMedicine)comboType.getSelectedItem()).getId());
		m.setCodeMedicine(txtCode.getText());
		m.setTypeMedicine(((TypeMedicine)comboType.getSelectedItem()));
		return m;
	}
	
	public void refresh() {
		txtID.setText("");
		txtName.setText("");
		txtCode.setText("");
		txtPrice.setText("");
		txtQuantity.setText("");
		comboUnit.setSelectedIndex(0);
		comboType.setSelectedIndex(0);
		
	}
	
	public void getDataToGui(int id) {
		Medicine m = medicine.findOne(id);
		txtID.setText(String.valueOf(m.getId()));
		comboType.setSelectedIndex(m.getIdTypeMedicine()-1);
		txtName.setText(m.getNameMedicine());
		txtCode.setText(m.getCodeMedicine());
		comboUnit.setSelectedItem(m.getUnit());
		txtPrice.setText(String.valueOf(m.getPrice()));
		txtQuantity.setText(String.valueOf(m.getQuantity()));
		
	}
	
	
}
