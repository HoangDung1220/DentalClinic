package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DentalServiceBUS;
import DTO.DentalService;
import DTO.Medicine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ManagementService extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtUnit;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtWarranty;
	private JTable table;
	DefaultTableModel defaultTable = new DefaultTableModel();
	DentalServiceBUS service = new DentalServiceBUS();
	private JTextField txtSearchName;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementService frame = new ManagementService();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagementService() {
		showTable(service.findAll());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 498);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 637, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID_Service");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 36, 79, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name_Service");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 93, 93, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 146, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(331, 36, 71, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(331, 93, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Warranty");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(331, 146, 71, 13);
		panel.add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(113, 34, 146, 19);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(113, 91, 146, 19);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtUnit = new JTextField();
		txtUnit.setBounds(113, 144, 146, 19);
		panel.add(txtUnit);
		txtUnit.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(442, 34, 150, 19);
		panel.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(442, 91, 150, 19);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtWarranty = new JTextField();
		txtWarranty.setBounds(442, 144, 150, 19);
		panel.add(txtWarranty);
		txtWarranty.setColumns(10);
		
		JButton Save = new JButton("SAVE");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DentalService d = getDataByGui();
				txtID.setText(String.valueOf(service.insert(d)));
				JOptionPane.showMessageDialog(null, "You save data successful");
				showTable(service.findAll());
				refresh();
			}
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(52, 202, 85, 21);
		panel.add(Save);
		
		JButton Edit = new JButton("EDIT");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				

				DentalService  mData = getDataByGui();
				DentalService  m = new DentalService();
				m.setId(id);
				m.setNameService(mData.getNameService());
				m.setPrice(mData.getPrice());
				m.setQuantity(mData.getQuantity());
				m.setUnit(mData.getUnit());
				m.setWarranty(mData.getWarranty());
				
				service.update(m);
				JOptionPane.showMessageDialog(null, "You update data successful");
				showTable(service.findAll());
				refresh();
			}
		});
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.setBounds(198, 202, 85, 21);
		panel.add(Edit);
		
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
					service.delete(listId);
					showTable(service.findAll());
					refresh();
				}
				}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(345, 202, 101, 21);
		panel.add(Delete);
		
		JButton Exit = new JButton("EXIT");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(491, 202, 85, 21);
		panel.add(Exit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(657, 10, 287, 248);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Name_Service");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 89, 109, 13);
		panel_1.add(lblNewLabel_6);
		
		JButton SearchButton = new JButton("SEARCH");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String chara = txtSearchName.getText();
				showTable(service.searchByName(chara));
			}
		});
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		SearchButton.setBounds(102, 201, 94, 21);
		panel_1.add(SearchButton);
		
		txtSearchName = new JTextField();
		txtSearchName.setBounds(143, 87, 109, 19);
		panel_1.add(txtSearchName);
		txtSearchName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 268, 932, 165);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 912, 134);
		panel_2.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount()==1) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				setDataToGui(id);
				
				}
			}
			
		});
		table.addKeyListener(new KeyAdapter() {
			
			
			@Override
			public void keyReleased(KeyEvent action) {
				if (action.getKeyCode() == KeyEvent.VK_DOWN || action.getKeyCode() == KeyEvent.VK_UP ) {
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					setDataToGui(id);
				}
			}
		
		});
		
	}
	
	public void showTable(List<DentalService> list) {
		defaultTable.setRowCount(0);
		defaultTable.setColumnIdentifiers(new String[] {
				"ID","Name_Service","Unit","Quantity","Warranty","Price"
		});
		
		for (DentalService i : list) {
			Object[] o = new Object[] {
					i.getId(),i.getNameService(),i.getUnit(),i.getQuantity(),i.getWarranty(),i.getPrice()
			};
			defaultTable.addRow(o);
		}
		
	}
	
	public DentalService getDataByGui() {
		DentalService d = new DentalService();
		d.setNameService(txtName.getText());
		d.setPrice(Float.parseFloat(txtPrice.getText()));
		d.setQuantity(Integer.parseInt(txtQuantity.getText()));
		d.setUnit(txtUnit.getText());
		d.setWarranty(txtWarranty.getText());
		
		return d;
	}
	
	public void setDataToGui(int id) {
		DentalService ser = service.findOne(id);
		txtID.setText(String.valueOf(ser.getId()));
		txtName.setText(ser.getNameService());
		txtPrice.setText(String.valueOf(ser.getPrice()));
		txtQuantity.setText(String.valueOf(ser.getQuantity()));
		txtWarranty.setText(ser.getWarranty());
		txtUnit.setText(ser.getUnit());
		
	}
	
	public void refresh() {
		txtID.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtQuantity.setText("");
		txtUnit.setText("");
		txtWarranty.setText("");;
		
	}
}
