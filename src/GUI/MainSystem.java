package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Constant.SystemConstant;
import DTO.Staff;

public class MainSystem extends JFrame {

	private JPanel contentPane;
	private JLabel labelSetting = new JLabel("");
	private PanelDanhMuc DanhMuc;
	private PanelNghiepVu NghiepVu;
	private PanelTaiKhoan TaiKhoan;
	private PanelStatistic ThongKe;
	private PanelChangeAccount ChangeAccount;
	private JLabel labelDanhmuc;
	private JLabel labelCure;
	private JLabel lableAccount;
	private JLabel labelStatistic;




	
	private JPanel panel_1;
	private static Staff staff_main;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;



	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSystem frame = new MainSystem(staff_main);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainSystem(Staff s) {
		staff_main =s;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 54, 250, 405);
		contentPane.add(panel);
		panel.setLayout(null);
		
		DanhMuc = new PanelDanhMuc();
		DanhMuc.setBounds(3, 1, 760, 404);
		
		labelDanhmuc = new JLabel("DANH M\u1EE4C");
		labelDanhmuc.setForeground(new Color(240, 255, 240));
		labelDanhmuc.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelDanhmuc.setBounds(10, 31, 251, 37);
		labelDanhmuc.setIcon(new ImageIcon(SystemConstant.img_list));
		labelDanhmuc.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(DanhMuc,labelDanhmuc);


			}
			
		});
		panel.add(labelDanhmuc);
		NghiepVu = new PanelNghiepVu();
		NghiepVu.setBounds(3, 1, 760, 404);
		
		labelCure = new JLabel("NGHI\u1EC6P V\u1EE4 KH\u00C1M B\u1EC6NH");
		labelCure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clicked(NghiepVu,labelCure);
				
			}
		});
		labelCure.setForeground(new Color(240, 255, 240));
		labelCure.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelCure.setBounds(10, 78, 240, 37);
		labelCure.setIcon(new ImageIcon(SystemConstant.img_cure));

		panel.add(labelCure);
		ThongKe = new PanelStatistic();
		ThongKe.setBounds(3, 1, 760, 404);
		labelStatistic = new JLabel("TH\u1ED0NG K\u00CA");
		labelStatistic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(ThongKe,labelStatistic);

			}
		});
		labelStatistic.setForeground(new Color(240, 255, 240));
		labelStatistic.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelStatistic.setBounds(10, 125, 251, 37);
		labelStatistic.setIcon(new ImageIcon(SystemConstant.img_statistic));
		panel.add(labelStatistic);
		
		TaiKhoan = new PanelTaiKhoan();
		TaiKhoan.setBounds(3, 1, 760, 404);
		lableAccount = new JLabel("Account");
		lableAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(TaiKhoan,lableAccount);
			}
		});
		lableAccount.setForeground(new Color(240, 255, 240));
		lableAccount.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lableAccount.setBounds(10, 172, 251, 37);
		lableAccount.setIcon(new ImageIcon(SystemConstant.img_login));
		panel.add(lableAccount);

		JPanel viewsetting = new JPanel();
		viewsetting.setBorder(new LineBorder(new Color(0, 0, 0)));
		viewsetting.setBackground(new Color(153, 204, 204));
		viewsetting.setBounds(10, 219, 230, 97);
		viewsetting.setEnabled(false);
		viewsetting.setVisible(false);
		panel.add(viewsetting);
		viewsetting.setLayout(null);
		
		ChangeAccount = new PanelChangeAccount();
		ChangeAccount.setBounds(3, 1, 760, 404);
		lblNewLabel_1 = new JLabel("Change username and password");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 10, 210, 27);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				DanhMuc.setVisible(false);
				labelDanhmuc.setForeground(Color.white);
				labelCure.setForeground(Color.white);
				lableAccount.setForeground(Color.white);
				NghiepVu.setVisible(false);
				TaiKhoan.setVisible(false);
				ChangeAccount.setVisible(true);
			}
			
		});
		viewsetting.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Log out");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 47, 113, 18);
		viewsetting.add(lblNewLabel);
		
		JLabel set1 = new JLabel("");
		set1.setBorder(null);
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
		labelSetting.setBorder(null);
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
		panel_1.add(NghiepVu);
		panel_1.add(TaiKhoan);
		panel_1.add(ChangeAccount);
		panel_1.add(ThongKe);
		DanhMuc.setVisible(false);
		NghiepVu.setVisible(false);
		TaiKhoan.setVisible(false);
		ChangeAccount.setVisible(false);
		ThongKe.setVisible(false);
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(0, 0, 1011, 55);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel labelMain = new JLabel("");
		labelMain.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 14));
		labelMain.setBounds(721, 10, 280, 36);
		labelMain.setIcon(new ImageIcon(SystemConstant.img_login));
		labelMain.setText("Welcome, "+SystemConstant.staff.getFullname());
		
		panel_5.add(labelMain);
	}
	
	public void clicked(JPanel panel,JLabel label) {
		DanhMuc.setVisible(false);
		labelDanhmuc.setForeground(Color.white);
		labelCure.setForeground(Color.white);
		lableAccount.setForeground(Color.white);
		labelStatistic.setForeground(Color.white);
		NghiepVu.setVisible(false);
		TaiKhoan.setVisible(false);
		ChangeAccount.setVisible(false);
		ThongKe.setVisible(false);
		panel.setVisible(true);
		label.setForeground(Color.cyan);
	}
}
