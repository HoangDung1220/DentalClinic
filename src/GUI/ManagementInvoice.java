package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DetailServiceBUS;
import BUS.implement.InvoiceBUS;
import BUS.implement.MedicalFormBUS;
import BUS.implement.PrescriptionBUS;
import Checked.AutoID;
import Checked.DataChecked;
import Constant.SystemConstant;
import DTO.DetailService;
import DTO.Invoice;
import DTO.MedicalForm;
import DTO.Prescription;

public class ManagementInvoice extends JFrame {

	private JPanel contentPane;
	private JTable table_service;
	private JTable table_medicine;
	private JTextField textIDMedical;
	private JLabel lbDate;
	private	JLabel lbStaff ;
	private	JLabel lbNamePatient;
	private JLabel lbAddress;
	private JLabel lbPhone;
	DefaultTableModel defaultTableMedicine = new DefaultTableModel();
	DefaultTableModel defaultTableService = new DefaultTableModel();
	DefaultTableModel defaultTableMedicalRecord = new DefaultTableModel();
	private PrescriptionBUS prescription = new PrescriptionBUS();
	private DetailServiceBUS detailService = new DetailServiceBUS();
	private MedicalFormBUS medicalForm = new MedicalFormBUS();
	private JLabel lbTotalMedicine = new JLabel("");
	private JLabel lbTotalService = new JLabel("");
	private JLabel TotalPrice = new JLabel("");
	private JLabel lbID = new JLabel("");
	private JButton btnNewButton_1 ;
	private JLabel lblNewLabel_6 ;
	private JButton btnNewButton_2;
	private boolean checkPrint=false;




	private InvoiceBUS invoiceExecute = new InvoiceBUS();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementInvoice frame = new ManagementInvoice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagementInvoice() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 543);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Invoice Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(384, 23, 633, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID_Invoice");
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 33, 114, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date_Created");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 93, 102, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Staff");
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 146, 45, 13);
		panel.add(lblNewLabel_2);
		
		lbID.setBounds(134, 34, 154, 17);
		lbID.setForeground(Color.white);
		panel.add(lbID);
		
		lbDate = new JLabel("");
		lbDate.setBounds(134, 94, 131, 17);
		lbDate.setForeground(Color.white);
		panel.add(lbDate);
		
		lbStaff = new JLabel("");
		lbStaff.setBounds(134, 147, 184, 17);
		lbStaff.setForeground(Color.white);
		panel.add(lbStaff);
		
		JLabel lblNewLabel_3 = new JLabel("Name_Patient");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(328, 34, 108, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(328, 94, 96, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phonenumber");
		lblNewLabel_5.setForeground(new Color(0, 51, 153));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(328, 147, 114, 13);
		panel.add(lblNewLabel_5);
		
		lbNamePatient = new JLabel("");
		lbNamePatient.setBounds(447, 34, 176, 17);
		lbNamePatient.setForeground(Color.white);
		panel.add(lbNamePatient);
		
		lbAddress = new JLabel("");
		lbAddress.setBounds(447, 94, 176, 17);
		lbAddress.setForeground(Color.white);
		panel.add(lbAddress);
		
		lbPhone = new JLabel("");
		lbPhone.setBounds(447, 147, 176, 17);
		lbPhone.setForeground(Color.white);
		panel.add(lbPhone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 214, 1007, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 475, 105);
		panel_1.add(scrollPane);
		
		table_service = new JTable(defaultTableService);
		scrollPane.setViewportView(table_service);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(496, 20, 501, 105);
		panel_1.add(scrollPane_1);
		
		table_medicine = new JTable(defaultTableMedicine);
		scrollPane_1.setViewportView(table_medicine);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(10, 23, 362, 181);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_15 = new JLabel("ID_MedicalRecord");
		lblNewLabel_15.setForeground(new Color(0, 51, 153));
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_15.setBounds(10, 46, 118, 32);
		panel_2.add(lblNewLabel_15);
		
		textIDMedical = new JTextField();
		textIDMedical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_6.setText("");
			}
		});
		
		textIDMedical.setBounds(138, 51, 203, 25);
		panel_2.add(textIDMedical);
		textIDMedical.setColumns(10);
		
		JButton search = new JButton("");
		search.setIcon(new ImageIcon(SystemConstant.img_search));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_1.setEnabled(true);
				if ((textIDMedical.getText()).length()>0) {
					if (DataChecked.checkData(textIDMedical.getText())) {
					int id_form = Integer.parseInt(textIDMedical.getText());
					Invoice invoice = invoiceExecute.findOneByIdMedical(id_form);
					if (invoice != null)
						{
						btnNewButton_1.setEnabled(false);
						setGui(id_form);
						lbDate.setText(String.valueOf(invoice.getPayDate()));
						lbTotalMedicine.setText(String.valueOf(invoice.getTotalPriceMedicine()));
						lbTotalService.setText(String.valueOf(invoice.getTotalPriceService()));
						TotalPrice.setText(String.valueOf(invoice.getTotalPrice()));
						}
					else
					{
					setGui(id_form);
					}
				} else 
					{
					lblNewLabel_6.setText("This data is errored!");
					}}
					else 
				{
					lblNewLabel_6.setText("Please fill out this field");

				}
			}
		});
		search.setFont(new Font("Tahoma", Font.BOLD, 9));
		search.setBounds(270, 112, 35, 35);
		panel_2.add(search);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(20, 117, 215, 30);
		panel_2.add(lblNewLabel_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Event of invoice", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 359, 996, 130);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Total_Price_Medicine");
		lblNewLabel_9.setForeground(new Color(0, 51, 153));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(10, 32, 176, 13);
		panel_3.add(lblNewLabel_9);
		
		lbTotalMedicine.setBounds(196, 33, 107, 13);
		lbTotalMedicine.setForeground(Color.white);
		panel_3.add(lbTotalMedicine);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Save Data");
		btnNewButton_1.setIcon(new ImageIcon(SystemConstant.img_save));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Invoice inv = getGui();
				if (inv!=null) {
				invoiceExecute.Save(inv);
				JOptionPane.showMessageDialog(null, "Save data successful");
				checkPrint = true;
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(820, 85, 40, 35);
		panel_3.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Print Invoice");
		btnNewButton_2.setIcon(new ImageIcon(SystemConstant.img_print));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkPrint) {
				invoiceExecute.printf(lbID.getText());
				}
				checkPrint = false;
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(884, 85, 40, 35);
		panel_3.add(btnNewButton_2);
		
		JLabel lblNewLabel_11 = new JLabel("Total_Price_Service");
		lblNewLabel_11.setForeground(new Color(0, 51, 153));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(10, 64, 155, 13);
		panel_3.add(lblNewLabel_11);
		
		lbTotalService.setBounds(196, 65, 143, 13);
		lbTotalService.setForeground(Color.white);
		panel_3.add(lbTotalService);
		
		JLabel lblNewLabel_13 = new JLabel("Total_Price");
		lblNewLabel_13.setForeground(new Color(0, 51, 153));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(10, 104, 85, 13);
		panel_3.add(lblNewLabel_13);
		
		TotalPrice.setBounds(196, 99, 107, 13);
		TotalPrice.setForeground(Color.red);
		panel_3.add(TotalPrice);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int res=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit ?","confirm", JOptionPane.YES_NO_OPTION);
				if (res== JOptionPane.YES_OPTION) {
					dispose();
				} 
				
			}
		});
		btnNewButton_4.setToolTipText("Exit");
		btnNewButton_4.setIcon(new ImageIcon(SystemConstant.img_exit3));
		btnNewButton_4.setBounds(946, 85, 40, 35);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Create New Invoice");
		btnNewButton.setBounds(755, 85, 40, 35);
		btnNewButton.setIcon(new ImageIcon(SystemConstant.img_new));
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textIDMedical.setText("");
				lbID.setText("");
				lbDate.setText("");
				lbNamePatient.setText("");
				lbAddress.setText("");
				lbPhone.setText("");
				showTableMedicine(0);
				showTable1(0);
				TotalPrice.setText("");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		lbDate.setText(String.valueOf(time));
		lbStaff.setText(SystemConstant.staff.getFullname());

		
		
		
	}
	
	
	public void showTableMedicine(int idForm) {
		double s_price =0;
		defaultTableMedicine.setRowCount(0);
		defaultTableMedicine.setColumnIdentifiers(new String[] {
			"Name_Medicine","Quantity","Price"
		});
		
		List<Prescription> list = prescription.findAll(idForm);
		for (Prescription i: list) {
			Object[] row = new Object[] {
					i.getMedicine().getNameMedicine(),i.getQuantity(),i.getPrice()
			};
			s_price +=i.getPrice();
			defaultTableMedicine.addRow(row);
		}
		lbTotalMedicine.setText(String.valueOf(s_price));

	}
	

	public void showTable1(int idForm) {
		double s_price = 0;
		defaultTableService.setRowCount(0);
		defaultTableService.setColumnIdentifiers(new String[] {
				"Name_Service","Unit","Quantity","Warranty","Price"
		});
		List<DetailService> list = detailService.findAll(idForm);
		for (DetailService i:list) {
			Object[] row = new Object[] {
				i.getDentalService().getNameService(),i.getDentalService().getUnit(),i.getQuantity(),i.getDentalService().getWarranty(),i.getPrice()
			};
			s_price +=i.getPrice();
			defaultTableService.addRow(row);
		}
		lbTotalService.setText(String.valueOf(s_price));
	}
	
	public void setGui(int idForm) {
		
		List<Invoice> list = invoiceExecute.findAll();
		for (Invoice invoice:list) {
			if (invoice.getIdMedicalForm()==idForm)
			{
				btnNewButton_2.setEnabled(false);
			}
		}
		
		lbStaff.setText(SystemConstant.staff.getFullname());
			
		MedicalForm m = medicalForm.findOne(idForm);
		if (m!=null) {
		lbNamePatient.setText(m.getPatient().getFullname());
		lbAddress.setText(m.getPatient().getAddress());
		lbPhone.setText(m.getPatient().getPhone());
		String st = AutoID.CreateAutoID(m.getIdPatient());
		lbID.setText(st);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		lbDate.setText(String.valueOf(time));	
		showTableMedicine(idForm);
		showTable1(idForm);
		double price = Double.parseDouble(lbTotalMedicine.getText())+Double.parseDouble(lbTotalService.getText());
		TotalPrice.setText(String.valueOf(price));
		} else 
		{
			lblNewLabel_6.setText("ID_Medical_Form is invalid! ");
		}
		
	}
	
	public Invoice getGui() {
		if (lbID.getText().length()>0) {
		Invoice inv = new Invoice();
		inv.setId(lbID.getText());
		inv.setIdMedicalForm(Integer.parseInt(textIDMedical.getText()));
		inv.setIdStaff(SystemConstant.staff.getId());//// phan quyen
		inv.setPayDate(Timestamp.valueOf(lbDate.getText()));
		inv.setTotalPrice(Double.parseDouble(TotalPrice.getText()));
		inv.setTotalPriceMedicine(Double.parseDouble(lbTotalMedicine.getText()));
		inv.setTotalPriceService(Double.parseDouble(lbTotalService.getText()));
		
		return inv;
		} else 
			return null;
	}
}
