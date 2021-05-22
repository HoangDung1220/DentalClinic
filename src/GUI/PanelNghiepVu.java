package GUI;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Constant.SystemConstant;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelNghiepVu extends JPanel {

	
	public PanelNghiepVu() {
		setSize(760, 404);
		setLayout(null);
		
		JPanel Patient = new JPanel();
		Patient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientRegistrationGui patient = new PatientRegistrationGui();
				patient.setVisible(true);
				
			}
		});
		Patient.setBackground(new Color(240, 255, 240));
		Patient.setBounds(67, 99, 174, 192);
		add(Patient);
		Patient.setLayout(null);
		
		JLabel img = new JLabel("");
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setBounds(10, 10, 154, 131);
		img.setIcon(new ImageIcon(SystemConstant.img_adminssion));
		Patient.add(img);
		
		JLabel lblNewLabel_1 = new JLabel("Admission Patient");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 151, 154, 31);
		Patient.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(325, 99, 174, 192);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel img1 = new JLabel("");
		img1.setHorizontalAlignment(SwingConstants.CENTER);
		img1.setBounds(10, 10, 154, 131);
		img1.setIcon(new ImageIcon(SystemConstant.img_medicalform));
		panel_1.add(img1);
		
		JLabel lblNewLabel_2 = new JLabel("Medical Record");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 151, 154, 31);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(570, 99, 174, 192);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 154, 131);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 151, 154, 31);
		panel_2.add(lblNewLabel_3);
	}
}
