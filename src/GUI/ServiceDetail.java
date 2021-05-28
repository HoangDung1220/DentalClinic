package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DentalServiceBUS;
import BUS.implement.DetailServiceBUS;
import BUS.implement.MedicalFormBUS;
import Constant.SystemConstant;
import DTO.DentalService;
import DTO.DetailService;
import DTO.MedicalForm;

public class ServiceDetail extends JFrame {

	private JPanel contentPane;
	private JTextField txtNameSearch;
	private JTextField txtID;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTable table;
	private JTable table_1;
	private JComboBox<String> comboUnit;
	private static int idForm;
	DefaultTableModel defaultTable = new DefaultTableModel();
	DefaultTableModel defaultTable_1 = new DefaultTableModel();

	DentalServiceBUS service = new DentalServiceBUS();
	DetailServiceBUS detailService = new DetailServiceBUS();
	MedicalFormBUS medicalForm = new MedicalFormBUS();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceDetail frame = new ServiceDetail(idForm);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ServiceDetail(int Id_Medical_Form) {
		idForm = Id_Medical_Form;
		showTable(service.findAll());
		showTable1();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134, 636);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm d\u1ECBch v\u1EE5 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 1082, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtNameSearch = new JTextField();
		txtNameSearch.setBounds(227, 29, 159, 19);
		panel.add(txtNameSearch);
		txtNameSearch.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name_Service");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(68, 32, 106, 13);
		panel.add(lblNewLabel);
		
		JButton Search = new JButton("SEARCH");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String charr =txtNameSearch.getText();
				List<DentalService> list = service.searchByName(charr);
				showTable(list);
			}
		});
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(457, 26, 121, 21);
		panel.add(Search);
		
		JButton Exit = new JButton("");
		Exit.setToolTipText("Tho\u00E1t");
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(1032, 14, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit3));
		Exit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				MedicalForm m = medicalForm.findOne(idForm);
				CreateMedicalForm form = new CreateMedicalForm(m);
				form.setVisible(true);
				dispose();
				
			}
			
		});
		panel.add(Exit);
		
		JButton Save = new JButton("");
		Save.setToolTipText("L\u01B0u th\u00F4ng tin");
		Save.setBounds(882, 14, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save1));
		panel.add(Save);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetailService de = getDataByGui();
				detailService.insert(de);
				txtPrice.setText(String.valueOf(de.getPrice()));
				showTable1();
				refresh();
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton Edit = new JButton("");
		Edit.setToolTipText("Ch\u1EC9nh s\u1EEDa th\u00F4ng tin");
		Edit.setBounds(932, 14, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit1));
		panel.add(Edit);
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetailService de = getDataByGui();
				int index = table_1.getSelectedRow();
				int id = Integer.parseInt(table_1.getValueAt(index, 0).toString());
				de.setId(id);
				detailService.update(de);
				txtPrice.setText(String.valueOf(de.getPrice()));
				showTable1();
				refresh();
			}
		});
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton Delete = new JButton("");
		Delete.setToolTipText("X\u00F3a th\u00F4ng tin");
		Delete.setBounds(982, 14, 40, 35);
		Delete.setIcon(new ImageIcon(SystemConstant.img_delete1));
		panel.add(Delete);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] indexs = table_1.getSelectedRows();
				List<Integer> list = new ArrayList<Integer>();
				for (int i: indexs) {
					list.add(Integer.parseInt(table_1.getValueAt(i, 0).toString()));
				}
				detailService.delete(list);
				showTable1();
				refresh();
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 78, 688, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 668, 169);
		panel_1.add(scrollPane);
		
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
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(708, 78, 376, 199);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID_Service");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(29, 21, 86, 13);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(29, 73, 45, 13);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(29, 118, 72, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(29, 176, 45, 13);
		panel_2.add(lblNewLabel_4);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(125, 18, 229, 19);
		panel_2.add(txtID);
		txtID.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(125, 118, 229, 19);
		panel_2.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setEnabled(false);
		txtPrice.setBounds(125, 170, 229, 19);
		panel_2.add(txtPrice);
		txtPrice.setColumns(10);
		
	    comboUnit = new JComboBox<String>();
	    for (String i:Constant.SystemConstant.listConstantService) {
	    	comboUnit.addItem(i);
	    }
		comboUnit.setBounds(125, 69, 229, 21);
		panel_2.add(comboUnit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EED d\u1EE5ng d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(10, 309, 1082, 253);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 1062, 220);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable(defaultTable_1);
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
		scrollPane_1.setViewportView(table_1);
	}
	
	public void showTable(List<DentalService> list) {
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Name_Service","Unit","Quantity","Warranty","Price"
		});
		for (DentalService i:list) {
			Object[] row = new Object[] {
					i.getId(),i.getNameService(),i.getUnit(),i.getQuantity(),i.getWarranty(),i.getPrice()
			};
			defaultTable.addRow(row);
		}
	}
	

	public void showTable1() {
		defaultTable_1.setRowCount(0);
		defaultTable_1.setColumnIdentifiers(new String[] {
				"ID","Name_Service","Unit","Quantity","Warranty","Price"
		});
		List<DetailService> list = detailService.findAll(idForm);
		for (DetailService i:list) {
			Object[] row = new Object[] {
					i.getId(),i.getDentalService().getNameService(),i.getDentalService().getUnit(),i.getQuantity(),i.getDentalService().getWarranty(),i.getPrice()
			};
			defaultTable_1.addRow(row);
		}
	}
	
	public void setDataToGui(int id) {
		
		DentalService ser = service.findOne(id);
		txtID.setText(String.valueOf(ser.getId()));
		comboUnit.setSelectedItem(ser.getUnit());
	
	}
	
	public DetailService getDataByGui() {
		DetailService de = new DetailService();
		de.setIdDentalService(Integer.parseInt(txtID.getText()));
		de.setQuantity(Integer.parseInt(txtQuantity.getText()));
		double price1 = Integer.parseInt(txtQuantity.getText())*(service.findOne(Integer.parseInt(txtID.getText()))).getPrice();
		de.setPrice(price1);
		de.setIdMedicalForm(idForm);
		return de;
	}

	public void setDataToGui1(int id) {
		
		DetailService ser = detailService.findOne(id);
		txtID.setText(String.valueOf(ser.getIdDentalService()));
		comboUnit.setSelectedItem(ser.getDentalService().getUnit());
		txtQuantity.setText(String.valueOf(ser.getQuantity()));
		txtPrice.setText(String.valueOf(ser.getPrice()));
		
		
	
	}
	
	public void refresh() {
		txtID.setText("");
		comboUnit.setSelectedIndex(0);
		txtQuantity.setText("");
		txtPrice.setText("");
		
	}
	
}
