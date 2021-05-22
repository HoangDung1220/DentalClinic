package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Constant.SystemConstant;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainSystem extends JFrame {

	private JPanel contentPane;
	private JLabel labelSetting = new JLabel("");
	private PanelDanhMuc DanhMuc;
	JPanel panel_1;




	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSystem frame = new MainSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(0, 54, 250, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		DanhMuc = new PanelDanhMuc();
		DanhMuc.setBounds(3, 1, 760, 404);
		
		JLabel labelDanhmuc = new JLabel("DANH M\u1EE4C");
		labelDanhmuc.setForeground(new Color(240, 255, 240));
		labelDanhmuc.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelDanhmuc.setBounds(10, 31, 251, 37);
		labelDanhmuc.setIcon(new ImageIcon(SystemConstant.img_list));
		labelDanhmuc.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				labelDanhmuc.setForeground(Color.yellow);
				DanhMuc.setVisible(true);
			}
			
		});
		panel.add(labelDanhmuc);
		
		JLabel labelCure = new JLabel("NGHI\u1EC6P V\u1EE4 KH\u00C1M B\u1EC6NH");
		labelCure.setForeground(new Color(240, 255, 240));
		labelCure.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelCure.setBounds(10, 78, 240, 37);
		labelCure.setIcon(new ImageIcon(SystemConstant.img_cure));

		panel.add(labelCure);
		
		JLabel labelStatistic = new JLabel("TH\u1ED0NG K\u00CA");
		labelStatistic.setForeground(new Color(240, 255, 240));
		labelStatistic.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelStatistic.setBounds(10, 125, 251, 37);
		labelStatistic.setIcon(new ImageIcon(SystemConstant.img_statistic));
		panel.add(labelStatistic);
		
		JLabel lableAccount = new JLabel("Account");
		lableAccount.setForeground(new Color(240, 255, 240));
		lableAccount.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lableAccount.setBounds(10, 172, 251, 37);
		lableAccount.setIcon(new ImageIcon(SystemConstant.img_login));
		panel.add(lableAccount);

		JPanel viewsetting = new JPanel();
		viewsetting.setBorder(new LineBorder(new Color(0, 0, 0)));
		viewsetting.setBackground(new Color(153, 204, 204));
		viewsetting.setBounds(10, 219, 149, 97);
		viewsetting.setEnabled(false);
		viewsetting.setVisible(false);
		panel.add(viewsetting);
		viewsetting.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Login login = new Login();
				dispose();
				login.setVisible(true);
		}
		});
		labelLogin.setBounds(15, 10, 124, 27);
		viewsetting.add(labelLogin);
		labelLogin.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		labelLogin.setIcon(new ImageIcon(SystemConstant.img_login));
		
		JLabel labelExit = new JLabel("Exit");
		labelExit.setBounds(15, 57, 126, 30);
		viewsetting.add(labelExit);
		labelExit.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		labelExit.setIcon(new ImageIcon(SystemConstant.img_exit));
		
		JLabel set1 = new JLabel("");
		set1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		set1.setHorizontalAlignment(SwingConstants.CENTER);
		set1.setBounds(10, 337, 80, 59);
		set1.setIcon(new ImageIcon(SystemConstant.img_setting));
		set1.setVisible(false);
		set1.setEnabled(false);
		set1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewsetting.setVisible(false);
				viewsetting.setEnabled(false);
				set1.setVisible(false);
				set1.setEnabled(false);
				labelSetting.setVisible(true);
				labelSetting.setVisible(true);
				
			}
		});
		panel.add(set1);
		
		//JLabel labelSetting = new JLabel("");
		labelSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewsetting.setVisible(true);
				viewsetting.setEnabled(true);
				set1.setVisible(true);
				set1.setEnabled(true);
				labelSetting.setVisible(false);
				labelSetting.setVisible(false);
				
			}
		});
		labelSetting.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		labelSetting.setHorizontalAlignment(SwingConstants.CENTER);
		labelSetting.setBounds(10, 337, 80, 59);
		labelSetting.setIcon(new ImageIcon(SystemConstant.img_setting));
		panel.add(labelSetting);
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(248, 54, 763, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(DanhMuc);
		DanhMuc.setVisible(false);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(153, 204, 204));
		panel_5.setBounds(0, 0, 1011, 55);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		Label label = new Label("New label");
		label.setBounds(721, 10, 280, 36);
		panel_5.add(label);
	}
	
	public void clicked(JPanel panel) {
		DanhMuc.setVisible(false);
		panel_1.setVisible(false);
		panel.setVisible(true);
	}
}
