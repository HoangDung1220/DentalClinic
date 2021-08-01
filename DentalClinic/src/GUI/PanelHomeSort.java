package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Constant.SystemConstant;

public class PanelHomeSort extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	
	public PanelHomeSort() {
		setSize(950, 405);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(new Color(0, 0, 153));
		panel.setBounds(10, 10, 930, 385);
		
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 920, 165);
		lblNewLabel_1.setIcon(new ImageIcon(SystemConstant.back1));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 164, 432, 211);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Better Technology");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 51, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(114, 146, 178, 30);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(167, 51, 70, 70);
		panel_1.add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setIcon(new ImageIcon(SystemConstant.img1));
		
		panel_2 = new JPanel();
		panel_2.setBounds(442, 164, 478, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SystemConstant.dental));
		lblNewLabel_3.setBounds(230, 48, 70, 70);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Dental Care");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(185, 147, 176, 26);
		panel_2.add(lblNewLabel_4);
	

	}
}
