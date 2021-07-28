package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.IInvoiceBUS;
import BUS.implement.InvoiceBUS;
import BUS.implement.MedicalFormBUS;
import Constant.SystemConstant;
import DTO.Invoice;
import javax.swing.SwingConstants;

public class InvoiceDanhMuc extends JFrame{
	private static JPanel contentPane;
	private static JTextField txtIDmedicalform;
	private static JTextField txtIDStaff;
	private static JTable table_1;
	private static JButton btnNewButtonSearch,btnDetail;
    private MedicalFormBUS medicalForm = new MedicalFormBUS();
    private InvoiceBUS invoiceExecute = new InvoiceBUS();
    private JLabel lbInvoice ;
    private JLabel lbNamePatient;
    private JLabel lbNameStaff;
    private JLabel lbTotal;


    
	public static void setColumn(Vector<String> v)
	{
		v.add("Id");
		v.add("Name_Staff");
		v.add("Name_Patient");
		v.add("Id Medical Form");
		v.add("Total Price Medicine");
		v.add("Total Price Service");
		v.add("Total Price");
		v.add("Pay date");	
	}
	public  void getDataToRow(Vector<Object> row, Invoice p)
	{
		row.add(p.getId());
		row.add(p.getStaff().getFullname());
		row.add(medicalForm.findOne(p.getIdMedicalForm()).getPatient().getFullname());
		row.add(p.getIdMedicalForm());
		row.add(p.getTotalPriceMedicine());
		row.add(p.getTotalPriceService());
		row.add(p.getTotalPrice());
		row.add(p.getPayDate());
		
	}
	public  DefaultTableModel showDataToTable(String idMedicalform, String idStaff)  
	{
		
		DefaultTableModel model =new DefaultTableModel();
		Vector<String> column =new Vector<String>();
		setColumn(column);
        model.setColumnIdentifiers(column);
        
        IInvoiceBUS invoice = new InvoiceBUS();
		List<Invoice> list =new ArrayList<Invoice>();
		list= invoice.findAll();

		for (int i=0;i<list.size();i++)
		{
			Invoice p=(Invoice)list.get(i);
            if (idMedicalform!="" && idStaff !="" &&   String.valueOf(p.getIdMedicalForm()).contains(idMedicalform)&&  String.valueOf(p.getIdStaff()).contains(idStaff)  )
            {
            	
    				Vector<Object> row =new Vector<Object>();
    				getDataToRow(row,p);				
    				model.addRow(row);	
            }
            if (idMedicalform=="" && idStaff == "")
            {
            	Vector<Object> row =new Vector<Object>();
				getDataToRow(row,p);				
				model.addRow(row);
				
            }
            	
		}
		return model;
	 }

	public InvoiceDanhMuc() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 585);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 100, 100)));
		panel.setBounds(10, 10, 944, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID_MedicalForm");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 95, 129, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID_Staff");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 34, 68, 31);
		panel.add(lblNewLabel_1);
		
		txtIDmedicalform = new JTextField();
		txtIDmedicalform.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDetail.setEnabled(false);
				refresh();
			}
		});
		txtIDmedicalform.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtIDmedicalform.setBounds(149, 93, 178, 25);
		panel.add(txtIDmedicalform);
		txtIDmedicalform.setColumns(10);
		
		txtIDStaff = new JTextField();
		txtIDStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDetail.setEnabled(false);
				refresh();
			}
		});
		txtIDStaff.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtIDStaff.setBounds(148, 35, 179, 25);
		panel.add(txtIDStaff);
		txtIDStaff.setColumns(10);
		
		 btnNewButtonSearch = new JButton("");
		btnNewButtonSearch.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));
		btnNewButtonSearch.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButtonSearch.setBounds(184, 152, 40, 35);
		panel.add(btnNewButtonSearch);
		
		JLabel lblNewLabel_2 = new JLabel("ID_Invoice");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(399, 41, 101, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name_Patient");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(399, 99, 101, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name_Staff");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(399, 153, 101, 13);
		panel.add(lblNewLabel_4);
		
		lbInvoice = new JLabel("");
		lbInvoice.setForeground(SystemColor.control);
		lbInvoice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbInvoice.setBounds(520, 41, 148, 15);
		panel.add(lbInvoice);
		
		lbNamePatient = new JLabel("");
		lbNamePatient.setForeground(SystemColor.control);
		lbNamePatient.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbNamePatient.setBounds(520, 99, 330, 15);
		panel.add(lbNamePatient);
		
		lbNameStaff = new JLabel("");
		lbNameStaff.setForeground(SystemColor.control);
		lbNameStaff.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbNameStaff.setBounds(520, 154, 330, 15);
		panel.add(lbNameStaff);
		
		JLabel lblNewLabel_8 = new JLabel("Total_Price");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(679, 41, 87, 13);
		panel.add(lblNewLabel_8);
		
		lbTotal = new JLabel("");
		lbTotal.setForeground(SystemColor.control);
		lbTotal.setBounds(798, 41, 136, 15);
		panel.add(lbTotal);
		
		ButtonGroup bg=new ButtonGroup();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "List of invoices", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(109, 109, 109)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 226, 944, 312);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 923, 220);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	btnDetail.setEnabled(true);

				int index = table_1.getSelectedRow();
				String id = table_1.getValueAt(index, 0).toString();
				getDataToGui(id);
				}
					
		});

		
		
	     btnDetail = new JButton("");
	     btnDetail.setToolTipText("Show Detail Data");
	     btnDetail.setIcon(new ImageIcon(SystemConstant.img_detail));
		 btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					medical frame1 = new medical(lbInvoice.getText());
					frame1.setVisible(true);
			}
		});
		btnDetail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDetail.setBounds(780, 251, 40, 35);
		btnDetail.setEnabled(false);
		panel_2.add(btnDetail);
		
		btnNewButtonSearch.setIcon(new ImageIcon(SystemConstant.img_search1));
		btnNewButtonSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh();
				btnDetail.setEnabled(false);
				table_1.setModel(showDataToTable(txtIDmedicalform.getText(),txtIDStaff.getText()));

			}
		});
		table_1.setModel(showDataToTable("",""));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setToolTipText("Exit");
		btnNewButton.setBounds(842, 251, 40, 35);
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_exit3));
		panel_2.add(btnNewButton);

}

	public void getDataToGui(String id) {
		Invoice inv = invoiceExecute.findOne(id);
		lbInvoice.setText(inv.getId());
		lbNamePatient.setText(medicalForm.findOne(inv.getIdMedicalForm()).getPatient().getFullname());
		lbNameStaff.setText(String.valueOf(inv.getStaff().getFullname()));

		lbTotal.setText(String.valueOf(inv.getTotalPrice()));
	}
	
	public void refresh() {
		lbInvoice.setText("");
		lbNamePatient.setText("");
		lbNameStaff.setText("");
		lbTotal.setText("");
	}
	

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				InvoiceDanhMuc frame = new InvoiceDanhMuc();
				frame.setVisible(true);				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	
	
}
}
	

