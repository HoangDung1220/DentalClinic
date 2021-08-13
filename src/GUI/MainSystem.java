package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private PanelHome Home;


	private PanelChangeAccount ChangeAccount;
	private JLabel labelDanhmuc;
	private JLabel labelCure;
	private JLabel lableAccount;
	private JLabel labelStatistic;
	private JLabel labelHome ;

	private JPanel panel_1;
	private static Staff staff_main;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JPanel panelsort ;
	private JLabel lbManagerSort;
	private JLabel lbTreatment;
	private JLabel lbStatistic;
	private JButton btnNewButton_1;
	private JLabel lbLogout;
	private JLabel lbChange;
	
	private JPanel panelSortMain;
	private PanelDanhMucSort DanhMucSort;
	private PanelNgiepVuSort NghiepVuSort;
	private PanelStatisticSort ThongKeSort;
	private PanelChangeAccountSort ChangeAccountSort;
	private PanelHomeSort HomeSort;




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
		DanhMuc.setBounds(4, 1, 760, 404);
		
		labelDanhmuc = new JLabel("Management ");
		labelDanhmuc.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		labelDanhmuc.setForeground(new Color(240, 255, 240));
		labelDanhmuc.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelDanhmuc.setBounds(10, 56, 251, 37);
		labelDanhmuc.setIcon(new ImageIcon(SystemConstant.img_list));
		labelDanhmuc.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(DanhMuc,labelDanhmuc);
				clickedSort(DanhMucSort);

			}
			
		});
		panel.add(labelDanhmuc);
		NghiepVu = new PanelNghiepVu();
		NghiepVu.setBounds(3, 1, 760, 404);
		
		labelCure = new JLabel("Treatment");
		labelCure.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		labelCure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				clicked(NghiepVu,labelCure);
				clickedSort(NghiepVuSort);

				
			}
		});
		labelCure.setForeground(new Color(240, 255, 240));
		labelCure.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelCure.setBounds(10, 103, 240, 37);
		labelCure.setIcon(new ImageIcon(SystemConstant.img_cure));

		panel.add(labelCure);
		ThongKe = new PanelStatistic();
		ThongKe.setBounds(3, 1, 760, 404);
		labelStatistic = new JLabel("Statistics & Revenues");
		labelStatistic.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		labelStatistic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(ThongKe,labelStatistic);
				clickedSort(ThongKeSort);


			}
		});
		labelStatistic.setForeground(new Color(240, 255, 240));
		labelStatistic.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelStatistic.setBounds(10, 150, 251, 37);
		labelStatistic.setIcon(new ImageIcon(SystemConstant.img_statistic));
		panel.add(labelStatistic);
		
		TaiKhoan = new PanelTaiKhoan();
		TaiKhoan.setBounds(3, 1, 760, 404);
		lableAccount = new JLabel("Account");
		lableAccount.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		lableAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(TaiKhoan,lableAccount);
			}
		});
		lableAccount.setForeground(new Color(240, 255, 240));
		lableAccount.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lableAccount.setBounds(10, 197, 251, 37);
		lableAccount.setIcon(new ImageIcon(SystemConstant.img_login));
		panel.add(lableAccount);

		JPanel viewsetting = new JPanel();
		viewsetting.setBorder(new LineBorder(new Color(0, 0, 0)));
		viewsetting.setBackground(new Color(153, 204, 204));
		viewsetting.setBounds(10, 262, 230, 79);
		viewsetting.setEnabled(false);
		viewsetting.setVisible(false);
		panel.add(viewsetting);
		viewsetting.setLayout(null);
		
		ChangeAccount = new PanelChangeAccount();
		ChangeAccount.setBounds(3, 1, 760, 404);
		lblNewLabel_1 = new JLabel("Change username and password");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.white);
				lblNewLabel.setForeground(Color.black);

			}
		});
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 10, 210, 27);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Home.setVisible(false);
				labelHome.setForeground(Color.white);
				DanhMuc.setVisible(false);
				labelDanhmuc.setForeground(Color.white);
				labelCure.setForeground(Color.white);
				lableAccount.setForeground(Color.white);
				NghiepVu.setVisible(false);
				TaiKhoan.setVisible(false);
				ChangeAccount.setVisible(true);
				ThongKe.setVisible(false);
				labelStatistic.setForeground(Color.white);
				
				clickedSort(ChangeAccountSort);

			}
			
		});
		viewsetting.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Log out");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FirstPrimitiveSystem f = new FirstPrimitiveSystem();
				f.setVisible(true);
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel.setForeground(Color.white);
				lblNewLabel_1.setForeground(Color.black);
			}
		});
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 47, 113, 18);
		viewsetting.add(lblNewLabel);
		
		JLabel set1 = new JLabel("");
		set1.setBorder(null);
		set1.setHorizontalAlignment(SwingConstants.LEFT);
		set1.setBounds(10, 351, 80, 45);
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
		labelSetting.setHorizontalAlignment(SwingConstants.LEFT);
		labelSetting.setBounds(10, 351, 80, 45);
		labelSetting.setIcon(new ImageIcon(SystemConstant.img_setting));
		panel.add(labelSetting);
		
		labelHome = new JLabel("Home");
		labelHome.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		labelHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked(Home,labelHome);
				clickedSort(HomeSort);


			}
		});
		labelHome.setForeground(Color.black);
	//	labelHome.setForeground(new Color(240, 255, 255));
		labelHome.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		labelHome.setBounds(10, 10, 250, 37);
		labelHome.setIcon(new ImageIcon(SystemConstant.home));
		
		panel.add(labelHome);
		
		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSortMain.setVisible(true);
				panelsort.setVisible(true);
				panel.setVisible(false);
				panel_1.setVisible(false);

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(181, 374, 59, 21);
		panel.add(btnNewButton);
		btnNewButton.setOpaque(false);
		btnNewButton.setBackground(SystemColor.activeCaption);
		
		panelsort = new JPanel();
		panelsort.setBackground(SystemColor.activeCaption);
		panelsort.setBounds(0, 54, 59, 405);
		panelsort.setVisible(false);
		contentPane.add(panelsort);
		panelsort.setLayout(null);
		
		JLabel lbHomeSort = new JLabel();
		lbHomeSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedSort(HomeSort);
				clicked(Home,labelHome);

			}
		});
		lbHomeSort.setOpaque(true);
		lbHomeSort.setBounds(10, 10, 40, 40);
		lbHomeSort.setIcon(new ImageIcon(SystemConstant.home2));
		panelsort.add(lbHomeSort);
		
		lbManagerSort = new JLabel("");
		lbManagerSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedSort(DanhMucSort);
				clicked(DanhMuc,labelDanhmuc);

			}
		});
		lbManagerSort.setOpaque(true);
		lbManagerSort.setBounds(10, 56, 40, 40);
		lbManagerSort.setIcon(new ImageIcon(SystemConstant.manager));
		panelsort.add(lbManagerSort);
		
		lbTreatment = new JLabel("");
		lbTreatment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedSort(NghiepVuSort);
				clicked(NghiepVu,labelCure);

			}
		});
		lbTreatment.setOpaque(true);
		lbTreatment.setBounds(10, 103, 40, 40);
		lbTreatment.setIcon(new ImageIcon(SystemConstant.cure));

		panelsort.add(lbTreatment);
		
		lbStatistic = new JLabel("");
		lbStatistic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedSort(ThongKeSort);
				clicked(ThongKe,labelStatistic);
			}
		});
		lbStatistic.setOpaque(true);
		lbStatistic.setBounds(10, 150, 40, 40);
		lbStatistic.setIcon(new ImageIcon(SystemConstant.statistic));
		panelsort.add(lbStatistic);
		
		btnNewButton_1 = new JButton(">>");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelSortMain.setVisible(false);
				panelsort.setVisible(false);
				panel.setVisible(true);
				panel_1.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBounds(0, 375, 59, 21);
		
		panelsort.add(btnNewButton_1);
		
		lbLogout = new JLabel("");
		lbLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				FirstPrimitiveSystem f = new FirstPrimitiveSystem();
				f.setVisible(true);
			}
		});
		lbLogout.setOpaque(true);
		lbLogout.setBounds(10, 244, 40, 40);
		lbLogout.setIcon(new ImageIcon(SystemConstant.logout));
		panelsort.add(lbLogout);
		
		lbChange = new JLabel("");
		lbChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedSort(ChangeAccountSort);
			}
		});
		lbChange.setOpaque(true);
		lbChange.setBounds(10, 197, 40, 40);
		lbChange.setIcon(new ImageIcon(SystemConstant.change));
		panelsort.add(lbChange);
		Home = new PanelHome();
		Home.setBounds(3, 1, 760, 404);
		
		
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
		panel_1.add(Home);
		DanhMuc.setVisible(false);
		NghiepVu.setVisible(false);
		TaiKhoan.setVisible(false);
		ChangeAccount.setVisible(false);
		ThongKe.setVisible(false);
		Home.setVisible(true);
		//labelHome.setForeground(Color.white);
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBounds(0, 0, 1011, 55);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel labelMain = new JLabel("");
		labelMain.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 12));
		labelMain.setBounds(721, 10, 280, 36);
		labelMain.setIcon(new ImageIcon(SystemConstant.img_login));
	
		StringBuilder st = new StringBuilder("Welcome, ");
		st.append(SystemConstant.staff.getFullname());
		labelMain.setText(st.toString());
		
		panel_5.add(labelMain);
		
		panelSortMain = new JPanel();
		panelSortMain.setBounds(59, 54, 950, 405);
		panelSortMain.setLayout(null);
		HomeSort = new PanelHomeSort();
		HomeSort.setBounds(3, 1, 950, 404);
		HomeSort.setVisible(false);
		panelSortMain.add(HomeSort);
		
		DanhMucSort = new PanelDanhMucSort();
		DanhMucSort.setBounds(3, 1, 950, 404);
		DanhMucSort.setVisible(false);
		panelSortMain.add(DanhMucSort);
		
		NghiepVuSort = new PanelNgiepVuSort();
		NghiepVuSort.setBounds(3, 1, 950, 404);
		NghiepVuSort.setVisible(false);
		panelSortMain.add(NghiepVuSort);
		
		ThongKeSort = new PanelStatisticSort();
		ThongKeSort.setBounds(3, 1, 950, 404);
		ThongKeSort.setVisible(false);
		panelSortMain.add(ThongKeSort);
		
		ChangeAccountSort = new PanelChangeAccountSort();
		ChangeAccountSort.setBounds(3, 1, 950, 404);
		ChangeAccountSort.setVisible(false);
		panelSortMain.add(ChangeAccountSort);
		
		panelSortMain.setVisible(false);
		contentPane.add(panelSortMain);
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
		labelHome.setForeground(Color.white);
		Home.setVisible(false);
		panel.setVisible(true);
		label.setForeground(Color.black);
	}
	
	public void clickedSort(JPanel panel) {
		DanhMucSort.setVisible(false);
		NghiepVuSort.setVisible(false);
		ChangeAccountSort.setVisible(false);
		ThongKeSort.setVisible(false);
		HomeSort.setVisible(false);
		panel.setVisible(true);
	}
	

	
	
/*	public void moved(JLabel label) {
		labelDanhmuc.setForeground(Color.white);
		labelCure.setForeground(Color.white);
		lableAccount.setForeground(Color.white);
		labelStatistic.setForeground(Color.white);
		labelHome.setForeground(Color.white);
		label.setForeground(Color.black);
		
	}*/
}
