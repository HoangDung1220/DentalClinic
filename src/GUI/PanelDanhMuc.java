package GUI;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Constant.SystemConstant;

public class PanelDanhMuc extends JPanel {

	
	public PanelDanhMuc() {
		setSize(763, 405);
		setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagementStaff frame1 = new ManagementStaff();
				frame1.setVisible(true);
			}
		});
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(69, 228, 145, 161);
		add(panel);
		panel.setLayout(null);
		
		JLabel img = new JLabel("");
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setBounds(10, 10, 125, 100);
		img.setIcon(new ImageIcon(SystemConstant.img_staff));
		panel.add(img);
		
		JLabel lblNewLabel_1 = new JLabel("Staff");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1.setBounds(20, 120, 115, 31);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagementService service = new ManagementService();
				service.setVisible(true);
			}
		});
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(313, 39, 145, 161);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel img1 = new JLabel("");
		img1.setHorizontalAlignment(SwingConstants.CENTER);
		img1.setBounds(10, 10, 125, 100);
		img1.setIcon(new ImageIcon(SystemConstant.img_dental));
		panel_1.add(img1);
		
		JLabel lblNewLabel_2 = new JLabel("Dental Service");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 120, 125, 31);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagementMedicine medicine = new ManagementMedicine();
				medicine.setVisible(true);
			}
		});
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(554, 39, 145, 161);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel img3 = new JLabel("");
		img3.setHorizontalAlignment(SwingConstants.CENTER);
		img3.setBounds(10, 10, 125, 100);
		img3.setIcon(new ImageIcon(SystemConstant.img_medicine));
		panel_2.add(img3);
		
		JLabel lblNewLabel_3 = new JLabel("Medicine");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 120, 125, 31);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagementMedicalForms frame = new ManagementMedicalForms();
				frame.setVisible(true);
			}
		});
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setBounds(313, 236, 145, 161);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel img4 = new JLabel("");
		img4.setHorizontalAlignment(SwingConstants.CENTER);
		img4.setBounds(9, 8, 125, 100);
		img4.setIcon(new ImageIcon(SystemConstant.img_medicalForm));
		panel_3.add(img4);
		
		JLabel lblNewLabel_4 = new JLabel("Medical Form");
		lblNewLabel_4.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(20, 127, 115, 30);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.controlHighlight);
		panel_4.setBounds(554, 236, 145, 161);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel img5 = new JLabel("");
		img5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InvoiceDanhMuc frame = new InvoiceDanhMuc();
				frame.setVisible(true);
			}
		});
		img5.setHorizontalAlignment(SwingConstants.CENTER);
		img5.setBounds(10, 8, 125, 100);
		img5.setIcon(new ImageIcon(SystemConstant.img_invoice));
		panel_4.add(img5);
		
		JLabel lblNewLabel_6 = new JLabel("Invoice");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_6.setBounds(20, 130, 115, 30);
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientDanhMuc frame = new PatientDanhMuc();
				frame.setVisible(true);
				
			}
		});
		panel_5.setLayout(null);
		panel_5.setBackground(SystemColor.controlHighlight);
		panel_5.setBounds(69, 39, 145, 161);
		add(panel_5);
		
		JLabel img_1 = new JLabel("");
		img_1.setHorizontalAlignment(SwingConstants.CENTER);
		img_1.setBounds(10, 10, 125, 100);
		img_1.setIcon(new ImageIcon(SystemConstant.img_patient));
		panel_5.add(img_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(20, 120, 115, 31);
		panel_5.add(lblNewLabel_1_1);

	}
}
