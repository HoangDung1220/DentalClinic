/*package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.IMedicineBUS;
import BUS.ITypeMedicineBUS;
import BUS.implement.MedicineBUS;
import BUS.implement.TypeMedicineBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Medicine;
import DTO.TypeMedicine;
import PAGING.PageRequest;
import PAGING.Pageble;

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
    private JLabel lberror;
    private	JLabel lbpage;
    private JLabel lbtotalpage;
	private static List<Medicine> list = new ArrayList<Medicine>();
	private static String name="";
	private static int idType=0;
	private static int totalPages;
	private JComboBox<TypeMedicine> comboSearchType;


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
		list = medicine.findAll();
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 321, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type_Medicine");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 49, 115, 13);
		panel.add(lblNewLabel);
		
		comboSearchType = new JComboBox<TypeMedicine>();
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
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 125, 115, 13);
		panel.add(lblNewLabel_1);
		
		JButton Search = new JButton("SEARCH");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idType = ((TypeMedicine)comboSearchType.getSelectedItem()).getId();
				name = txtSearchName.getText();
				defaultTable.setRowCount(0);
				list = medicine.searchByNameAndIDType(name, idType);
				Medicine med = paging(1,SystemConstant.LIMIT,list,name,idType);
				showTable(med.getList());
				decorPaging(med);
				
				
				
			}
		});
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(97, 213, 115, 21);
		panel.add(Search);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(340, 10, 756, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID_Medicine");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(31, 42, 97, 13);
		panel_1.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setOpaque(false);
		txtID.setBounds(154, 39, 160, 19);
		
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name_medicine");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(31, 102, 140, 13);
		panel_1.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtName.setBounds(154, 100, 160, 19);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price\r\n");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(31, 158, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		txtPrice = new JTextField();
		txtPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtPrice.setBounds(154, 156, 160, 19);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_5.setBounds(324, 42, 90, 13);
		panel_1.add(lblNewLabel_5);
		
		txtQuantity = new JTextField();
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtQuantity.setBounds(424, 39, 160, 19);
		panel_1.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Unit");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_6.setBounds(324, 102, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		JButton Save = new JButton("");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
			if (checkData(txtPrice.getText(),txtQuantity.getText())) {
					Medicine i = getDataByGui();
					txtID.setText(String.valueOf(medicine.insert(i)));
					JOptionPane.showMessageDialog(null, "You save data successful");
					refresh();  
			}
			}
		
			
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(656, 36, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save1));
		panel_1.add(Save);
		
		JButton Edit = new JButton("");
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index =-1;
				index = table.getSelectedRow();
				if (index!=-1) {
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
				if (checkData(txtPrice.getText(),txtQuantity.getText())) {
				Medicine mData = getDataByGui();
				mData.setId(id);
				lberror.setText("");
				medicine.update(mData);
				JOptionPane.showMessageDialog(null, "You update data successful");
				refresh();
					} 				
				}
			}		
		});
		Edit.setBounds(656, 100, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit1));
		panel_1.add(Edit);
		
		JButton Delete = new JButton("");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] listRow = table.getSelectedRows();
				if (listRow.length>0) {
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
			}
				
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(656, 166, 40, 35);
		Delete.setIcon(new ImageIcon(SystemConstant.img_delete1));
		panel_1.add(Delete);
		
		JButton Exit = new JButton("");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ? ","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) {
					dispose();
				} 
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(656, 231, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit3));
		panel_1.add(Exit);
		
		JLabel lblNewLabel_7 = new JLabel("Type_Medicine");
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7.setBounds(324, 157, 109, 19);
		panel_1.add(lblNewLabel_7);
		comboType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		
		comboType.setBounds(427, 155, 157, 21);
		
		
		for (TypeMedicine i : listType)
		comboType.addItem(i);
		panel_1.add(comboType);
		comboUnit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		
		comboUnit.setBounds(424, 99, 160, 21);
		for (String i : SystemConstant.listConstant) {
		comboUnit.addItem(i);
		}
		panel_1.add(comboUnit);
		
		JLabel lblNewLabel_8 = new JLabel("Code");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_8.setBounds(31, 212, 45, 13);
		panel_1.add(lblNewLabel_8);
		
		txtCode = new JTextField();
		txtCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		
		txtCode.setBounds(154, 209, 160, 19);
		panel_1.add(txtCode);
		txtCode.setColumns(10);
		
		lberror = new JLabel("");
		lberror.setBounds(10, 253, 304, 25);
		panel_1.add(lberror);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of medicines", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 322, 1086, 176);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane.setBounds(10, 22, 1066, 131);
		panel_2.add(scrollPane);
		table = new JTable(defaultTable);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount()==1) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				getDataToGui(id);
				lberror.setText("");
				
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
		
		JButton btnfirst = new JButton("<<");
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicine s= paging(1,SystemConstant.LIMIT,list,name,idType);
				decorPaging(s);
				showTable(s.getList());
			}
		});
		btnfirst.setForeground(new Color(0, 51, 153));
		btnfirst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnfirst.setBounds(362, 547, 60, 21);
		contentPane.add(btnfirst);
		
		JButton btnbefor = new JButton("<");
		btnbefor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage>1) {
				String page = String.valueOf(--currentPage);
				Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
					showTable(s.getList());

				}
				
			}
		});
		btnbefor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnbefor.setForeground(new Color(0, 51, 153));
		btnbefor.setBounds(432, 547, 60, 21);
		contentPane.add(btnbefor);
		
		lbpage = new JLabel("");
		lbpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbpage.setForeground(new Color(0, 51, 153));
		lbpage.setBounds(502, 551, 45, 13);
		contentPane.add(lbpage);
		
		lbtotalpage = new JLabel("");
		lbtotalpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalpage.setForeground(new Color(0, 51, 153));
		lbtotalpage.setBounds(557, 551, 45, 13);
		contentPane.add(lbtotalpage);
		
		JButton lbafter = new JButton(">");
		lbafter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage<totalPages) {
				String page = String.valueOf(++currentPage);
				Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
					showTable(s.getList());

				}
			}
		});
		lbafter.setForeground(new Color(0, 51, 153));
		lbafter.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbafter.setBounds(612, 547, 60, 21);
		contentPane.add(lbafter);
		
		JButton lblast = new JButton(">>");
		lblast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicine s= paging(totalPages,SystemConstant.LIMIT,list,name,idType);
				decorPaging(s);
				showTable(s.getList());
			}
		});
		lblast.setForeground(new Color(0, 51, 153));
		lblast.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblast.setBounds(682, 547, 60, 21);
		contentPane.add(lblast);
		
		Medicine dental = paging(1,SystemConstant.LIMIT,list,name,idType);
		showTable(dental.getList());
		decorPaging(dental);
		
		

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
		idType = ((TypeMedicine)comboSearchType.getSelectedItem()).getId();
		name = txtSearchName.getText();
		defaultTable.setRowCount(0);
		list = medicine.searchByNameAndIDType(name, idType);
		Medicine dental = paging(1,SystemConstant.LIMIT,list,name,idType);
		showTable(dental.getList());
		decorPaging(dental);
		
		
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
	
	public boolean checkData(String quantity,String price) {
		boolean check =true;
			for (int i=0;i<quantity.length();i++) {
				if ((quantity.charAt(i)<'0' || quantity.charAt(i)>'9') && quantity.charAt(i)!='.') {
					check= false;
				}
			}
			
			for (int i=0;i<price.length();i++) {
				if ((price.charAt(i)<'0' || price.charAt(i)>'9') && price.charAt(i)!='.') {
					check= false;
				}
			}
			if (DataChecked.checkInteger(quantity)) check = false;	
			if (DataChecked.checkInteger(price)) check=false;
			
			if (!check) {
				lberror.setText("This data is errored!!");
			    lberror.setForeground(Color.red);
			    return false;
			}
			
			if (txtPrice.getText().length()==0 || txtQuantity.getText().length()==0) {
				lberror.setText("Please fill data to fields !");
			    lberror.setForeground(Color.red);
				return false;
			}
		
		return true;
	}
	
	
	public Medicine paging(int page,int limit,List<Medicine> list,String name, int idtype){
		Medicine s= new Medicine();
		List<Medicine> listPaging = null;
		int totalItem = list.size();
		int totalPage = (int) Math.ceil(((double) totalItem)/limit);
		Pageble pageable =  new PageRequest(page, limit);
		listPaging = medicine.searchByNameAndIDType(name, idtype, pageable);
		s.setTotalItem(totalItem);
		s.setTotalPage(totalPage);
		s.setPage(page);
		s.setLimit(limit);
		s.setList(listPaging);
		totalPages = s.getTotalPage();
		return s;
	}
	
	public void decorPaging(Medicine dental) {
		lbpage.setText(String.valueOf(dental.getPage()));
		lbtotalpage.setText(dental.getPage()+"/"+dental.getTotalPage());

	}
}
*/
package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.IMedicineBUS;
import BUS.ITypeMedicineBUS;
import BUS.implement.MedicineBUS;
import BUS.implement.TypeMedicineBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.Medicine;
import DTO.TypeMedicine;
import PAGING.PageRequest;
import PAGING.Pageble;

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
    private JLabel lberror;
    private	JLabel lbpage;
    private JLabel lbtotalpage;
	private static List<Medicine> list = new ArrayList<Medicine>();
	private static String name="";
	private static int idType=0;
	private static int totalPages;
	private JComboBox<TypeMedicine> comboSearchType;


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
		list = medicine.findAll();
		
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
panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 321, 288);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type_Medicine");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 49, 115, 13);
		panel.add(lblNewLabel);
		
		comboSearchType = new JComboBox<TypeMedicine>();
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
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 125, 115, 13);
		panel.add(lblNewLabel_1);
		
		JButton Search = new JButton("SEARCH");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idType = ((TypeMedicine)comboSearchType.getSelectedItem()).getId();
				name = txtSearchName.getText();
				defaultTable.setRowCount(0);
				list = medicine.searchByNameAndIDType(name, idType);
				Medicine med = paging(1,SystemConstant.LIMIT,list,name,idType);
				showTable(med.getList());
				decorPaging(med);
				
				
				
			}
		});
		Search.setFont(new Font("Tahoma", Font.BOLD, 14));
		Search.setBounds(97, 213, 115, 21);
		panel.add(Search);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(340, 10, 756, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ID_Medicine");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(31, 42, 97, 13);
		panel_1.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setOpaque(false);
		txtID.setBounds(154, 39, 160, 19);
		
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Name_medicine");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(31, 102, 140, 13);
		panel_1.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.addMouseListener(new MouseAdapter() {
@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtName.setBounds(154, 100, 160, 19);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price\r\n");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(31, 158, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		txtPrice = new JTextField();
		txtPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtPrice.setBounds(154, 156, 160, 19);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_5.setBounds(324, 42, 90, 13);
		panel_1.add(lblNewLabel_5);
		
		txtQuantity = new JTextField();
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtQuantity.setBounds(424, 39, 160, 19);
		panel_1.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Unit");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_6.setBounds(324, 102, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		JButton Save = new JButton("");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			if (txtPrice.getText().length()>0 && txtQuantity.getText().length()>0 
					 && txtCode.getText().length()>0
					&& txtName.getText().length()>0) {
			if (checkData(txtPrice.getText(),txtQuantity.getText())) {
					Medicine m = new Medicine();
					m = getDataByGui(m);
					txtID.setText(String.valueOf(medicine.insert(m)));
					JOptionPane.showMessageDialog(null, "You save data successful");
					refresh();  
			} else
			{
				lberror.setText("This data is errored!!");
			    lberror.setForeground(Color.red);
			}
			}
		
			
				else 
			{
				lberror.setText("Please fill data to fields !");
			    lberror.setForeground(Color.red);
			}
			}
			
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(656, 36, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save1));
		panel_1.add(Save);
		
		JButton Edit = new JButton("");
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lberror.setText("");
				if (txtPrice.getText().length()>0 && txtQuantity.getText().length()>0 
						 && txtCode.getText().length()>0
						&& txtName.getText().length()>0)
				{
					
					if(checkData(txtQuantity.getText(), txtPrice.getText()))
					{
						Medicine m = medicine.findOne(Integer.parseInt(txtID.getText()));
						m = getDataByGui(m);
						medicine.update(m);
						JOptionPane.showMessageDialog(null, "This data is edited Succesfully");
						showTable(medicine.findAll());
						refresh();
					}
					else
					{
						lberror.setText("Quantity or Price is erorred!");
						lberror.setForeground(Color.red);
					}
					
				}
				else
				{
					lberror.setText("Please fill data fully!");
					lberror.setForeground(Color.red);
				}
			}
		});
		Edit.setBounds(656, 100, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit1));
		panel_1.add(Edit);
		
		JButton Delete = new JButton("");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] listRow = table.getSelectedRows();
				if (listRow.length>0) {
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
			}
				
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(656, 166, 40, 35);
		Delete.setIcon(new ImageIcon(SystemConstant.img_delete1));
		panel_1.add(Delete);
		
		JButton Exit = new JButton("");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ? ","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) {
					dispose();
				} 
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(656, 231, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit3));
		panel_1.add(Exit);
		
		JLabel lblNewLabel_7 = new JLabel("Type_Medicine");
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7.setBounds(324, 157, 109, 19);
		panel_1.add(lblNewLabel_7);
		comboType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		
		comboType.setBounds(427, 155, 157, 21);
		
		
		for (TypeMedicine i : listType)
		comboType.addItem(i);
		panel_1.add(comboType);
		comboUnit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		
		comboUnit.setBounds(424, 99, 160, 21);
		for (String i : SystemConstant.listConstant) {
		comboUnit.addItem(i);
		}
		panel_1.add(comboUnit);
		
		JLabel lblNewLabel_8 = new JLabel("Code");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_8.setBounds(31, 212, 45, 13);
		panel_1.add(lblNewLabel_8);
		
		txtCode = new JTextField();
txtCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		
		txtCode.setBounds(154, 209, 160, 19);
		panel_1.add(txtCode);
		txtCode.setColumns(10);
		
		lberror = new JLabel("");
		lberror.setBounds(10, 253, 304, 25);
		panel_1.add(lberror);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of medicines", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 322, 1086, 176);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane.setBounds(10, 22, 1066, 131);
		panel_2.add(scrollPane);
		table = new JTable(defaultTable);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount()==1) {
				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(row, 0).toString());
				setDataToGui(id);
				lberror.setText("");
				
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
					setDataToGui(id);
				}
			}

			@Override
			public void keyTyped(KeyEvent action) {
			
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnfirst = new JButton("<<");
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicine s= paging(1,SystemConstant.LIMIT,list,name,idType);
				decorPaging(s);
				showTable(s.getList());
			}
		});
		btnfirst.setForeground(new Color(0, 51, 153));
		btnfirst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnfirst.setBounds(362, 547, 60, 21);
		contentPane.add(btnfirst);
		
		JButton btnbefor = new JButton("<");
		btnbefor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage>1) {
				String page = String.valueOf(--currentPage);
				Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
					showTable(s.getList());

				}
				
			}
		});
		btnbefor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnbefor.setForeground(new Color(0, 51, 153));
		btnbefor.setBounds(432, 547, 60, 21);
		contentPane.add(btnbefor);
		
		lbpage = new JLabel("");
		lbpage.setHorizontalAlignment(SwingConstants.CENTER);
lbpage.setForeground(new Color(0, 51, 153));
		lbpage.setBounds(502, 551, 45, 13);
		contentPane.add(lbpage);
		
		lbtotalpage = new JLabel("");
		lbtotalpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalpage.setForeground(new Color(0, 51, 153));
		lbtotalpage.setBounds(557, 551, 45, 13);
		contentPane.add(lbtotalpage);
		
		JButton lbafter = new JButton(">");
		lbafter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage<totalPages) {
				String page = String.valueOf(++currentPage);
				Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					Medicine s= paging(currentPage,SystemConstant.LIMIT,list,name,idType);
					showTable(s.getList());

				}
			}
		});
		lbafter.setForeground(new Color(0, 51, 153));
		lbafter.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbafter.setBounds(612, 547, 60, 21);
		contentPane.add(lbafter);
		
		JButton lblast = new JButton(">>");
		lblast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicine s= paging(totalPages,SystemConstant.LIMIT,list,name,idType);
				decorPaging(s);
				showTable(s.getList());
			}
		});
		lblast.setForeground(new Color(0, 51, 153));
		lblast.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblast.setBounds(682, 547, 60, 21);
		contentPane.add(lblast);
		
		Medicine dental = paging(1,SystemConstant.LIMIT,list,name,idType);
		showTable(dental.getList());
		decorPaging(dental);
		
		

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
	
	public Medicine getDataByGui(Medicine m) {
		if(m == null)
		{
			 m= new Medicine();
		}
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
		idType = ((TypeMedicine)comboSearchType.getSelectedItem()).getId();
		name = txtSearchName.getText();
		defaultTable.setRowCount(0);
list = medicine.searchByNameAndIDType(name, idType);
		Medicine dental = paging(1,SystemConstant.LIMIT,list,name,idType);
		showTable(dental.getList());
		decorPaging(dental);
		
		
	}
	
	public void setDataToGui(int id) {
		Medicine m = medicine.findOne(id);
		txtID.setText(String.valueOf(m.getId()));
		comboType.setSelectedIndex(m.getIdTypeMedicine()-1);
		txtName.setText(m.getNameMedicine());
		txtCode.setText(m.getCodeMedicine());
		comboUnit.setSelectedItem(m.getUnit());
		txtPrice.setText(String.valueOf(m.getPrice()));
		txtQuantity.setText(String.valueOf(m.getQuantity()));
		
	}
	
	public boolean checkData(String quantity,String price) {
		boolean check =true;
			for (int i=0;i<quantity.length();i++) {
				if ((quantity.charAt(i)<'0' || quantity.charAt(i)>'9') && quantity.charAt(i)!='.') {
					check= false;
				}
			}
			
			for (int i=0;i<price.length();i++) {
				if ((price.charAt(i)<'0' || price.charAt(i)>'9') && price.charAt(i)!='.') {
					check= false;
				}
			}
			if (DataChecked.checkInteger(quantity)) return false;	
			if (DataChecked.checkInteger(price)) return false;
		
		return check;
	}
	
	
	public Medicine paging(int page,int limit,List<Medicine> list,String name, int idtype){
		Medicine s= new Medicine();
		List<Medicine> listPaging = null;
		int totalItem = list.size();
		int totalPage = (int) Math.ceil(((double) totalItem)/limit);
		Pageble pageable =  new PageRequest(page, limit);
		listPaging = medicine.searchByNameAndIDType(name, idtype, pageable);
		s.setTotalItem(totalItem);
		s.setTotalPage(totalPage);
		s.setPage(page);
		s.setLimit(limit);
		s.setList(listPaging);
		totalPages = s.getTotalPage();
		return s;
	}
	
	public void decorPaging(Medicine dental) {
		lbpage.setText(String.valueOf(dental.getPage()));
		lbtotalpage.setText(dental.getPage()+"/"+dental.getTotalPage());

	}
}