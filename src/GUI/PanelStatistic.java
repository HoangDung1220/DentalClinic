package GUI;

import javax.swing.JPanel;

import Constant.SystemConstant;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelStatistic extends JPanel {

	
	public PanelStatistic() {
		setSize(763, 405);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientStatisticalGui frame1 = new PatientStatisticalGui();
				frame1.setVisible(true);
			}
		});
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(111, 73, 182, 190);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 162, 116);
		lblNewLabel.setIcon(new ImageIcon(SystemConstant.img_patient_statistic));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 151, 162, 29);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FinancialStatisticGui frame1 = new FinancialStatisticGui();
				frame1.setVisible(true);
			}
		});
		panel_1.setBackground(new Color(176, 224, 230));
		panel_1.setBounds(400, 73, 182, 190);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 10, 162, 116);
		lblNewLabel_2.setIcon(new ImageIcon(SystemConstant.img_invoice_statistic));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Invoice");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 151, 162, 29);
		panel_1.add(lblNewLabel_3);
	}
}
