/*package GUI;

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
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DentalServiceBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.DentalService;
import PAGING.PageRequest;
import PAGING.Pageble;

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
	private JLabel lberror ;
	private	JLabel lbpage;
	private JLabel lbtotalpage;
	private static List<DentalService> list = new ArrayList<DentalService>();
	private static String name="";
	private static int totalPages;



	

	
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
		list = service.findAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 498);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 637, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID_Service");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 36, 79, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name_Service");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 93, 93, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 146, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(331, 36, 71, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price\r\n");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(331, 93, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Warranty");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(331, 146, 71, 13);
		panel.add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setOpaque(false);
		txtID.setBounds(113, 34, 146, 19);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtName.setBounds(113, 91, 146, 19);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtUnit = new JTextField();
		txtUnit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtUnit.setBounds(113, 144, 146, 19);
		panel.add(txtUnit);
		txtUnit.setColumns(10);
		
		txtQuantity = new JTextField();
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtQuantity.setBounds(442, 34, 150, 19);
		panel.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtPrice.setBounds(442, 91, 150, 19);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtWarranty = new JTextField();
		txtWarranty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtWarranty.setBounds(442, 144, 150, 19);
		panel.add(txtWarranty);
		txtWarranty.setColumns(10);
		
		JButton Save = new JButton("");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					if (checkData(txtPrice.getText(),txtQuantity.getText())) {
						DentalService d = getDataByGui();
						txtID.setText(String.valueOf(service.insert(d)));
						JOptionPane.showMessageDialog(null, "You save data successful");
						refresh();
					}
			}
			
		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(52, 202, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save1));
		Save.setToolTipText("Save data");
		panel.add(Save);
		
		JButton Edit = new JButton("");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index =-1;
				 index = table.getSelectedRow();
				 if (index!=-1) {
				int id = Integer.parseInt(table.getValueAt(index, 0).toString());
					if (checkData(txtPrice.getText(),txtQuantity.getText())) {
				DentalService  mData = getDataByGui();
				mData.setId(id);
				lberror.setText("");
				service.update(mData);
				JOptionPane.showMessageDialog(null, "You update data successful");
				refresh();
			}
				
			}
				 }
		});
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.setBounds(128, 202, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit1));
		Edit.setToolTipText("Edit data");
		panel.add(Edit);
		
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
					
					service.delete(listId);
					refresh();
				}
				}
			}
		});
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(206, 202, 40, 35);
		Delete.setIcon(new ImageIcon(SystemConstant.img_delete1));
		Delete.setToolTipText("Delete data");
		panel.add(Delete);
		
		JButton Exit = new JButton("");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? ","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) {
					dispose();
				} 
			}
		});
		Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(280, 202, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit3));
		Exit.setToolTipText("Exit data");
		panel.add(Exit);
		
		lberror = new JLabel("");
		lberror.setBounds(357, 224, 250, 13);
		panel.add(lberror);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(657, 10, 340, 248);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Name_Service");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(28, 136, 109, 13);
		panel_1.add(lblNewLabel_6);
		
		JButton SearchButton = new JButton("");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = txtSearchName.getText();
				list = service.searchByName(name);
				DentalService dental = paging(1,SystemConstant.LIMIT,list,name);
				showTable(dental.getList());
				decorPaging(dental);
			}
		});
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		SearchButton.setBounds(164, 203, 35, 35);
		SearchButton.setIcon(new ImageIcon(SystemConstant.img_search1));
		SearchButton.setToolTipText("Search data");
		panel_1.add(SearchButton);
		
		txtSearchName = new JTextField();
		txtSearchName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtSearchName.setBounds(134, 134, 168, 19);
		panel_1.add(txtSearchName);
		txtSearchName.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(146, 48, 102, 60);
		lblNewLabel_7.setIcon(new ImageIcon(SystemConstant.img_dental1));
		panel_1.add(lblNewLabel_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of services", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 268, 987, 183);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 967, 121);
		panel_2.add(scrollPane);
		
		table = new JTable(defaultTable);
		scrollPane.setViewportView(table);
		
		JButton btnfirst = new JButton("<<");
		btnfirst.setBackground(SystemColor.activeCaption);
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DentalService s= paging(1,SystemConstant.LIMIT,list,name);
				decorPaging(s);
				showTable(s.getList());
				//refresh();
			}
		});
		btnfirst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnfirst.setForeground(new Color(0, 51, 153));
		btnfirst.setBounds(305, 152, 60, 21);
		panel_2.add(btnfirst);
		
		JButton btnbefor = new JButton("<");
		btnbefor.setBackground(SystemColor.activeCaption);
		btnbefor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage>1) {
				String page = String.valueOf(--currentPage);
				DentalService s= paging(currentPage,SystemConstant.LIMIT,list,name);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					DentalService s= paging(currentPage,SystemConstant.LIMIT,list,name);
					showTable(s.getList());

				}
			//	refresh();
			}
		});
		btnbefor.setForeground(new Color(0, 51, 153));
		btnbefor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnbefor.setBounds(375, 152, 60, 21);
		panel_2.add(btnbefor);
		
		lbpage = new JLabel("");
		lbpage.setForeground(new Color(0, 51, 153));
		lbpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbpage.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbpage.setBounds(445, 156, 45, 13);
		panel_2.add(lbpage);
		
		lbtotalpage = new JLabel("");
		lbtotalpage.setForeground(new Color(0, 51, 153));
		lbtotalpage.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbtotalpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalpage.setBounds(500, 156, 45, 13);
		panel_2.add(lbtotalpage);
		
		JButton lbafter = new JButton(">");
		lbafter.setBackground(SystemColor.activeCaption);
		lbafter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage<totalPages) {
				String page = String.valueOf(++currentPage);
				DentalService s= paging(currentPage,SystemConstant.LIMIT,list,name);
				lbpage.setText(page);
				lbtotalpage.setText(s.getPage()+"/"+s.getTotalPage());
				showTable(s.getList());
				} else 
				{
					DentalService s= paging(currentPage,SystemConstant.LIMIT,list,name);
					showTable(s.getList());

				}
				//refresh();
			}
		});
		lbafter.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbafter.setForeground(new Color(0, 51, 153));
		lbafter.setBounds(555, 152, 60, 21);
		panel_2.add(lbafter);
		
		JButton lblast = new JButton(">>");
		lblast.setBackground(SystemColor.activeCaption);
		lblast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DentalService s= paging(totalPages,SystemConstant.LIMIT,list,name);
				decorPaging(s);
				showTable(s.getList());
			//	refresh();
			}
		});
		lblast.setForeground(new Color(0, 51, 153));
		lblast.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblast.setBounds(625, 152, 60, 21);
		panel_2.add(lblast);
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
		
		//Pageble pageable =  new PageRequest(1, SystemConstant.LIMIT);
		DentalService dental = paging(1,SystemConstant.LIMIT,list,name);
		showTable(dental.getList());
		decorPaging(dental);
		
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
		txtWarranty.setText("");
		name = txtSearchName.getText();
		list = service.searchByName(name);
		DentalService dental = paging(1,SystemConstant.LIMIT,list,name);
		showTable(dental.getList());
		decorPaging(dental);
		
		
		
		
	}
	public boolean checkData(String quantity,String price) {
		boolean check =true;
			for (int i=0;i<quantity.length();i++) {
				if (((quantity.charAt(i)<'0' || quantity.charAt(i)>'9') && quantity.charAt(i)!='.')) {
					check=false;
				}
			}
			
			for (int i=0;i<price.length();i++) {
				if ((price.charAt(i)<'0' || price.charAt(i)>'9') && price.charAt(i)!='.') {
					check=false;
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
	public DentalService paging(int page,int limit,List<DentalService> list,String name){
		DentalService s= new DentalService();
		List<DentalService> listPaging = null;
		int totalItem = list.size();
		int totalPage = (int) Math.ceil(((double) totalItem)/limit);
		Pageble pageable =  new PageRequest(page, limit);
		listPaging = service.searchByName(name, pageable);
		s.setTotalItem(totalItem);
		s.setTotalPage(totalPage);
		s.setPage(page);
		s.setLimit(limit);
		s.setList(listPaging);
		totalPages = s.getTotalPage();
		return s;
	}
	
	public void decorPaging(DentalService dental) {
		lbpage.setText(String.valueOf(dental.getPage()));
		lbtotalpage.setText(dental.getPage()+"/"+dental.getTotalPage());

	}
}*/

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
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.IDentalServiceBUS;
import BUS.implement.DentalServiceBUS;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.DentalService;
import PAGING.PageRequest;
import PAGING.Pageble;

public class ManagementService extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtUnit;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JTextField txtWarranty;
	private JTable table;
	private DefaultTableModel defaultTable = new DefaultTableModel();
	private IDentalServiceBUS service = new DentalServiceBUS();
	private JTextField txtSearchName;
	private JLabel lberror;
	private JLabel lbpage;
	private JLabel lbtotalpage;
	private static List<DentalService> list = new ArrayList<DentalService>();
	private static String name = "";
	private static int totalPages;

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
		list = service.findAll();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1021, 498);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 637, 248);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID_Service");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 36, 79, 13);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name_Service");
lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 93, 93, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Unit");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 146, 45, 13);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(331, 36, 71, 13);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Price\r\n");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(331, 93, 45, 13);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Warranty");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(331, 146, 71, 13);
		panel.add(lblNewLabel_5);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setOpaque(false);
		txtID.setBounds(113, 34, 146, 19);
		panel.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");
			}
		});
		txtName.setBounds(113, 91, 146, 19);
		panel.add(txtName);
		txtName.setColumns(10);

		txtUnit = new JTextField();
		txtUnit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtUnit.setBounds(113, 144, 146, 19);
		panel.add(txtUnit);
		txtUnit.setColumns(10);

		txtQuantity = new JTextField();
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtQuantity.setBounds(442, 34, 150, 19);
		panel.add(txtQuantity);
		txtQuantity.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtPrice.setBounds(442, 91, 150, 19);
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		txtWarranty = new JTextField();
		txtWarranty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtWarranty.setBounds(442, 144, 150, 19);
		panel.add(txtWarranty);
		txtWarranty.setColumns(10);

		JButton Save = new JButton("");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtQuantity.getText().length()>0 && txtPrice.getText().length() > 0
						 && txtUnit.getText().length()>0
						&& txtName.getText().length()>0) {
if (checkData(txtQuantity.getText(), txtPrice.getText())) {
						DentalService d = new DentalService();
						d = getDataByGui(d);
						txtID.setText(String.valueOf(service.insert(d)));
						JOptionPane.showMessageDialog(null, "You save data successful");

						refresh();
					} else
						lberror.setText("This data is errored!");
					lberror.setForeground(Color.red);

				} else {
					lberror.setText("Please fill data to fields !");
					lberror.setForeground(Color.red);
				}
			}

		});
		Save.setFont(new Font("Tahoma", Font.BOLD, 14));
		Save.setBounds(52, 202, 40, 35);
		Save.setIcon(new ImageIcon(SystemConstant.img_save1));
		Save.setToolTipText("Save data");
		panel.add(Save);

		JButton Edit = new JButton("");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lberror.setText("");
				if (txtQuantity.getText().length()>0 && txtPrice.getText().length() > 0
						&& txtUnit.getText().length()>0
						&& txtName.getText().length()>0) 
				{
					DentalService d = service.findOne(Integer.parseInt(txtID.getText()));
					d = getDataByGui(d);
					if (checkData(txtQuantity.getText(), txtPrice.getText()))
					{
						service.update(d);
						JOptionPane.showMessageDialog(null, "This data is edited Succesfully");
						showTable(service.findAll());
						refresh();
					}
					else
					{
						lberror.setText("data is errorred");
						lberror.setForeground(Color.red);
					}
				}
				else
				{
					lberror.setText("Please fill data fully");
					lberror.setForeground(Color.red);
				}
			}

			
		});
		
		Edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Edit.setBounds(128, 202, 40, 35);
		Edit.setIcon(new ImageIcon(SystemConstant.img_edit1));
		Edit.setToolTipText("Edit data");
		panel.add(Edit);

		JButton Delete = new JButton("");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] listRow = table.getSelectedRows();
				if (listRow.length > 0) {
					List<Integer> listId = new ArrayList<Integer>();
					for (int i : listRow) {
						listId.add(Integer.parseInt(table.getValueAt(i, 0).toString()));
					}
					int res = JOptionPane.showConfirmDialog(null, "You are sure delete databases", "confirm",
							JOptionPane.YES_NO_OPTION);
					if (res != JOptionPane.YES_OPTION) {
						return;
					} else {

						service.delete(listId);
						refresh();
					}
				}
			
			}
		});
		
		Delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		Delete.setBounds(206, 202, 40, 35);
		Delete.setIcon(new ImageIcon(SystemConstant.img_delete1));
		Delete.setToolTipText("Delete data");
		panel.add(Delete);

		JButton Exit = new JButton("");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? ", "confirm",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
Exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		Exit.setBounds(280, 202, 40, 35);
		Exit.setIcon(new ImageIcon(SystemConstant.img_exit3));
		Exit.setToolTipText("Exit data");
		panel.add(Exit);

		lberror = new JLabel("");
		lberror.setBounds(357, 224, 250, 13);
		panel.add(lberror);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(657, 10, 340, 248);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Name_Service");
		lblNewLabel_6.setForeground(new Color(0, 51, 153));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(28, 136, 109, 13);
		panel_1.add(lblNewLabel_6);

		JButton SearchButton = new JButton("");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = txtSearchName.getText();
				list = service.searchByName(name);
				DentalService dental = paging(1, SystemConstant.LIMIT, list, name);
				showTable(dental.getList());
				decorPaging(dental);
			}
		});
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		SearchButton.setBounds(164, 203, 35, 35);
		SearchButton.setIcon(new ImageIcon(SystemConstant.img_search1));
		SearchButton.setToolTipText("Search data");
		panel_1.add(SearchButton);

		txtSearchName = new JTextField();
		txtSearchName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lberror.setText("");

			}
		});
		txtSearchName.setBounds(134, 134, 168, 19);
		panel_1.add(txtSearchName);
		txtSearchName.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(146, 48, 102, 60);
		lblNewLabel_7.setIcon(new ImageIcon(SystemConstant.img_dental1));
		panel_1.add(lblNewLabel_7);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"List of services", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 268, 987, 183);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 967, 121);
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
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
if (e.getKeyCode()== KeyEvent.VK_DOWN || e.getKeyCode()== KeyEvent.VK_UP) {
					int row = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(row, 0).toString());
					setDataToGui(id);
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		scrollPane.setViewportView(table);

		JButton btnfirst = new JButton("<<");
		btnfirst.setBackground(SystemColor.activeCaption);
		btnfirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DentalService s = paging(1, SystemConstant.LIMIT, list, name);
				decorPaging(s);
				showTable(s.getList());
				// refresh();
			}
		});
		btnfirst.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnfirst.setForeground(new Color(0, 51, 153));
		btnfirst.setBounds(305, 152, 60, 21);
		panel_2.add(btnfirst);

		JButton btnbefor = new JButton("<");
		btnbefor.setBackground(SystemColor.activeCaption);
		btnbefor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage > 1) {
					String page = String.valueOf(--currentPage);
					DentalService s = paging(currentPage, SystemConstant.LIMIT, list, name);
					lbpage.setText(page);
					lbtotalpage.setText(s.getPage() + "/" + s.getTotalPage());
					showTable(s.getList());
				} else {
					DentalService s = paging(currentPage, SystemConstant.LIMIT, list, name);
					showTable(s.getList());

				}
				// refresh();
			}
		});
		btnbefor.setForeground(new Color(0, 51, 153));
		btnbefor.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnbefor.setBounds(375, 152, 60, 21);
		panel_2.add(btnbefor);

		lbpage = new JLabel("");
		lbpage.setForeground(new Color(0, 51, 153));
		lbpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbpage.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbpage.setBounds(445, 156, 45, 13);
		panel_2.add(lbpage);

		lbtotalpage = new JLabel("");
		lbtotalpage.setForeground(new Color(0, 51, 153));
		lbtotalpage.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbtotalpage.setHorizontalAlignment(SwingConstants.CENTER);
		lbtotalpage.setBounds(500, 156, 45, 13);
		panel_2.add(lbtotalpage);

		JButton lbafter = new JButton(">");
		lbafter.setBackground(SystemColor.activeCaption);
		lbafter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int currentPage = Integer.parseInt(lbpage.getText());
				if (currentPage < totalPages) {
					String page = String.valueOf(++currentPage);
					DentalService s = paging(currentPage, SystemConstant.LIMIT, list, name);
					lbpage.setText(page);
					lbtotalpage.setText(s.getPage() + "/" + s.getTotalPage());
					showTable(s.getList());
				} else {
					DentalService s = paging(currentPage, SystemConstant.LIMIT, list, name);
					showTable(s.getList());

				}
				// refresh();
			}
		});
lbafter.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbafter.setForeground(new Color(0, 51, 153));
		lbafter.setBounds(555, 152, 60, 21);
		panel_2.add(lbafter);

		JButton lblast = new JButton(">>");
		lblast.setBackground(SystemColor.activeCaption);
		lblast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DentalService s = paging(totalPages, SystemConstant.LIMIT, list, name);
				decorPaging(s);
				showTable(s.getList());
				// refresh();
			}
		});
		lblast.setForeground(new Color(0, 51, 153));
		lblast.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblast.setBounds(625, 152, 60, 21);
		panel_2.add(lblast);
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
		/*
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
		*/
		scrollPane.setViewportView(table);

		// Pageble pageable = new PageRequest(1, SystemConstant.LIMIT);
		DentalService dental = paging(1, SystemConstant.LIMIT, list, name);
		showTable(dental.getList());
		decorPaging(dental);

	}

	public void showTable(List<DentalService> list) {
		defaultTable.setRowCount(0);
		defaultTable
				.setColumnIdentifiers(new String[] { "ID", "Name_Service", "Unit", "Quantity", "Warranty", "Price" });

		for (DentalService i : list) {
			Object[] o = new Object[] { i.getId(), i.getNameService(), i.getUnit(), i.getQuantity(), i.getWarranty(),
					i.getPrice() };
			defaultTable.addRow(o);
		}

	}

	public DentalService getDataByGui(DentalService d) {
		if(d == null)
		{
			d = new DentalService();
		}
		d.setNameService(txtName.getText());
		d.setUnit(txtUnit.getText());
        d.setQuantity(Integer.parseInt(txtQuantity.getText()));
		
		d.setWarranty(txtWarranty.getText());
		d.setPrice(Float.parseFloat(txtPrice.getText()));
		

		return d;
	}

	public void setDataToGui(int id) {
		DentalService d = service.findOne(id);
		txtID.setText(String.valueOf(d.getId()));
		txtName.setText(d.getNameService());
		txtUnit.setText(d.getUnit());
		txtQuantity.setText(String.valueOf(d.getQuantity()));
		txtWarranty.setText(d.getWarranty());
		txtPrice.setText(String.valueOf(d.getPrice()));
	
	}

	public void refresh() {
		txtID.setText("");
		txtName.setText("");
		txtUnit.setText("");
		
		txtQuantity.setText("");
txtWarranty.setText("");
		txtPrice.setText("");
		name = txtSearchName.getText();
		list = service.searchByName(name);
		DentalService dental = paging(1, SystemConstant.LIMIT, list, name);
		showTable(dental.getList());
		decorPaging(dental);

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

	public DentalService paging(int page, int limit, List<DentalService> list, String name) {
		DentalService s = new DentalService();
		List<DentalService> listPaging = null;
		int totalItem = list.size();
		int totalPage = (int) Math.ceil(((double) totalItem) / limit);
		Pageble pageable = new PageRequest(page, limit);
		listPaging = service.searchByName(name, pageable);
		s.setTotalItem(totalItem);
		s.setTotalPage(totalPage);
		s.setPage(page);
		s.setLimit(limit);
		s.setList(listPaging);
		totalPages = s.getTotalPage();
		return s;
	}

	public void decorPaging(DentalService dental) {
		lbpage.setText(String.valueOf(dental.getPage()));
		lbtotalpage.setText(dental.getPage() + "/" + dental.getTotalPage());

	}
}
