package Constant;

import java.awt.Image;

import javax.swing.ImageIcon;

import GUI.Login;
import GUI.MainSystem;
import GUI.ManagementInvoice;
import GUI.PanelDanhMuc;

public class SystemConstant {
	public static final String[] listConstant = {"viên","ống","vỉ","hộp"};
	public static final String[] listConstantService = {"răng","hàm"};
	public static final Image img_home = new ImageIcon(MainSystem.class.getResource("/icon_project/home_icon.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_list = new ImageIcon(MainSystem.class.getResource("/icon_project/list_icon.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_cure = new ImageIcon(MainSystem.class.getResource("/icon_project/ICON-3.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_statistic = new ImageIcon(MainSystem.class.getResource("/icon_project/statistic_icon.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_login = new ImageIcon(MainSystem.class.getResource("/icon_project/login1_icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_setting = new ImageIcon(MainSystem.class.getResource("/icon_project/setting_icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_exit = new ImageIcon(MainSystem.class.getResource("/icon_project/exit_icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_loginmain = new ImageIcon(Login.class.getResource("/icon_project/login2_icon.jpg")).getImage().getScaledInstance(462, 444, Image.SCALE_SMOOTH);
	public static final Image img_loginmain1 = new ImageIcon(Login.class.getResource("/icon_project/login4.png")).getImage().getScaledInstance(471, 477, Image.SCALE_SMOOTH);
	public static final Image img_staff = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/staff_icon.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	public static final Image img_dental = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/dentalservice_icon.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	public static final Image img_medicine = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/medicine_icon.jpg")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	public static final Image img_medicalForm = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/medicalform_icon.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	public static final Image img_invoice = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/invoice_icon.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	public static final Image img_adminssion = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/admission_icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	public static final Image img_medicalform = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/medicalform_icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	public static final Image img_background = new ImageIcon(Login.class.getResource("/icon_project/back_icon.jpg")).getImage().getScaledInstance(451, 453, Image.SCALE_SMOOTH);
	public static final Image img_background1 = new ImageIcon(Login.class.getResource("/icon_project/back1_icon.png")).getImage().getScaledInstance(421, 400, Image.SCALE_SMOOTH);
	public static final Image img_login1 = new ImageIcon(MainSystem.class.getResource("/icon_project/ICON-3.png")).getImage().getScaledInstance(136,65, Image.SCALE_SMOOTH);
	public static final Image img_add = new ImageIcon(ManagementInvoice.class.getResource("/icon_project/add_icon.jpg")).getImage().getScaledInstance(42,21, Image.SCALE_SMOOTH);
	public static final Image img_sign = new ImageIcon(Login.class.getResource("/icon_project/sign_icon.png")).getImage().getScaledInstance(74,46, Image.SCALE_SMOOTH);

}
