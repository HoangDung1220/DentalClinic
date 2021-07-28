package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Constant.SystemConstant;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelHome extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	
	public PanelHome() {
		setSize(763, 405);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setForeground(new Color(0, 0, 153));
		panel.setBounds(10, 10, 743, 385);
		
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 743, 165);
		lblNewLabel_1.setIcon(new ImageIcon(SystemConstant.back));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 164, 372, 211);
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
		panel_2.setBounds(382, 164, 361, 211);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SystemConstant.dental));
		lblNewLabel_3.setBounds(165, 43, 70, 70);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Dental Care");
		lblNewLabel_4.setForeground(new Color(0, 51, 153));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(96, 146, 176, 26);
		panel_2.add(lblNewLabel_4);
	

	}
}
