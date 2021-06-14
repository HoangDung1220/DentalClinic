package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.implement.DetailServiceBUS;
import BUS.implement.InvoiceBUS;
import BUS.implement.MedicalFormBUS;
import BUS.implement.PrescriptionBUS;
import Constant.SystemConstant;
import DTO.DetailService;
import DTO.MedicalForm;
import DTO.Prescription;

public class medical extends JFrame {

	private JPanel contentPane;
	private JTable table_service;
	private JTable table_medicine;
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
	private static String idInvoice;
	private InvoiceBUS invoiceExecute = new InvoiceBUS();


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medical frame = new medical(idInvoice);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public medical(String id) {
		idInvoice = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 593);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 633, 181);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID_Invoice");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 33, 114, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date_Created");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 94, 102, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Staff");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 146, 45, 13);
		panel.add(lblNewLabel_2);
		
		lbID.setBounds(123, 34, 165, 17);
		lbID.setForeground(Color.white);
		panel.add(lbID);
		
		lbDate = new JLabel("");
		lbDate.setBounds(123, 93, 131, 17);
		lbDate.setForeground(Color.white);
		panel.add(lbDate);
		
		lbStaff = new JLabel("");
		lbStaff.setBounds(123, 145, 120, 17);
		lbStaff.setForeground(Color.white);
		panel.add(lbStaff);
		
		JLabel lblNewLabel_3 = new JLabel("Name_Patient");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(328, 34, 108, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(328, 94, 96, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phonenumber");
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
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin d\u1ECBch v\u1EE5 v\u00E0 thu\u1ED1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 201, 633, 212);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 613, 86);
		panel_1.add(scrollPane);
		
		table_service = new JTable(defaultTableService);
		scrollPane.setViewportView(table_service);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 119, 613, 83);
		panel_1.add(scrollPane_1);
		
		table_medicine = new JTable(defaultTableMedicine);
		scrollPane_1.setViewportView(table_medicine);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBorder(new TitledBorder(null, "S\u1EF1 ki\u1EC7n c\u1EE7a h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 423, 633, 130);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Total_Price_Medicine");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(10, 32, 176, 13);
		panel_3.add(lblNewLabel_9);
		
		lbTotalMedicine.setBounds(196, 33, 107, 13);
		lbTotalMedicine.setForeground(Color.white);
		panel_3.add(lbTotalMedicine);
		
		JLabel lblNewLabel_11 = new JLabel("Total_Price_Service");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(10, 64, 155, 13);
		panel_3.add(lblNewLabel_11);
		
		lbTotalService.setBounds(196, 65, 143, 13);
		lbTotalService.setForeground(Color.white);
		panel_3.add(lbTotalService);
		
		JLabel lblNewLabel_13 = new JLabel("Total_Price");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(365, 33, 85, 13);
		panel_3.add(lblNewLabel_13);
		
		TotalPrice.setBounds(471, 33, 107, 13);
		TotalPrice.setForeground(Color.red);
		panel_3.add(TotalPrice);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon(SystemConstant.img_exit3));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(558, 85, 40, 35);
		panel_3.add(btnNewButton_2_1);
		
		

		setGui(invoiceExecute.findOne(idInvoice).getIdMedicalForm());
		
		
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
		//lbTotalMedicine.setText(String.valueOf(s_price));

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
		//lbTotalService.setText(String.valueOf(s_price));
	}
	public void setGui(int idForm) {
		
		
			MedicalForm m = medicalForm.findOne(idForm);

			lbNamePatient.setText(m.getPatient().getFullname());
			lbAddress.setText(m.getPatient().getAddress());
			lbPhone.setText(m.getPatient().getPhone());
			lbID.setText(idInvoice);
			lbDate.setText(String.valueOf(invoiceExecute.findOne(idInvoice).getPayDate()));
			lbStaff.setText(invoiceExecute.findOne(idInvoice).getStaff().getFullname());
			showTableMedicine(idForm);
			showTable1(idForm);
			lbTotalMedicine.setText(String.valueOf(invoiceExecute.findOne(idInvoice).getTotalPriceMedicine()));
			lbTotalService.setText(String.valueOf(invoiceExecute.findOne(idInvoice).getTotalPriceService()));
			double price = Double.parseDouble(lbTotalMedicine.getText())+Double.parseDouble(lbTotalService.getText());
			TotalPrice.setText(String.valueOf(price));
		
	}
	
	
}