package Constant;

import java.awt.Image;

import javax.swing.ImageIcon;

import DTO.Staff;
import GUI.CreateMedicalForm;
import GUI.FirstPrimitiveSystem;
import GUI.Login;
import GUI.MainSystem;
import GUI.ManagementInvoice;
import GUI.ManagementService;
import GUI.ManagementStaff;
import GUI.PanelDanhMuc;
import GUI.PanelNghiepVu;

public class SystemConstant {
	public static final int LIMIT =6;
	public static final int LIMITStatic =21;
	public static final String MANAGER ="manager";
	public static final String ADMIN ="admin";
	public static final String DOCTOR ="doctor";

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static final String[] listConstant = {"viên","ống","vỉ","hộp"};
	public static final String[] listConstantService = {"răng","hàm"};
	public static Staff staff;
	public static final Image img_home1 = new ImageIcon(FirstPrimitiveSystem.class.getResource("/icon_project/home_icon.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	public static final Image img_home = new ImageIcon(MainSystem.class.getResource("/icon_project/home_icon.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_list = new ImageIcon(MainSystem.class.getResource("/icon_project/list_icon.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_cure = new ImageIcon(MainSystem.class.getResource("/icon_project/ICON-3.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_statistic = new ImageIcon(MainSystem.class.getResource("/icon_project/statistic_icon.jpg")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	public static final Image img_login = new ImageIcon(MainSystem.class.getResource("/icon_project/login_icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
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
	public static final Image img_avatar = new ImageIcon(MainSystem.class.getResource("/icon_project/avatar1_icon.png")).getImage().getScaledInstance(36,36, Image.SCALE_SMOOTH);
	public static final Image img_history = new ImageIcon(CreateMedicalForm.class.getResource("/icon_project/history_icon.jpg")).getImage().getScaledInstance(67,36, Image.SCALE_SMOOTH);
	public static final Image img_exit1 = new ImageIcon(CreateMedicalForm.class.getResource("/icon_project/exit.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	public static final Image img_invoice1 = new ImageIcon(PanelNghiepVu.class.getResource("/icon_project/invoice_icon.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	public static final Image img_patient = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/patient_icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	public static final Image home = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/home_icon1.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	public static final Image home2 = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/home2.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static final Image manager = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/manager.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static final Image cure = new ImageIcon(MainSystem.class.getResource("/icon_project/ICON-3.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static final Image statistic = new ImageIcon(MainSystem.class.getResource("/icon_project/statistic_icon.jpg")).getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
	public static final Image account = new ImageIcon(MainSystem.class.getResource("/icon_project/login_icon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static final Image logout = new ImageIcon(MainSystem.class.getResource("/icon_project/logout.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static final Image change = new ImageIcon(MainSystem.class.getResource("/icon_project/change.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	public static final Image dental = new ImageIcon(MainSystem.class.getResource("/icon_project/dental.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);

	
	
	
	public static final Image img_save = new ImageIcon(ManagementStaff.class.getResource("/icon_project/save_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_edit = new ImageIcon(ManagementStaff.class.getResource("/icon_project/edit_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_delete = new ImageIcon(ManagementStaff.class.getResource("/icon_project/delete_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_exit2 = new ImageIcon(ManagementStaff.class.getResource("/icon_project/exit1_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_search = new ImageIcon(ManagementStaff.class.getResource("/icon_project/search.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

	public static final Image img_dental1 = new ImageIcon(ManagementService.class.getResource("/icon_project/dentalservice_icon.png")).getImage().getScaledInstance(102, 60, Image.SCALE_SMOOTH);
	public static final Image img_save1 = new ImageIcon(ManagementService.class.getResource("/icon_project/save_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_edit1 = new ImageIcon(ManagementService.class.getResource("/icon_project/edit_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_delete1= new ImageIcon(ManagementService.class.getResource("/icon_project/delete_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_exit3 = new ImageIcon(ManagementService.class.getResource("/icon_project/exit1_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_search1 = new ImageIcon(ManagementService.class.getResource("/icon_project/search_icon.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);

	public static final Image img_create = new ImageIcon(ManagementService.class.getResource("/icon_project/create1_icon.png")).getImage().getScaledInstance(26, 22, Image.SCALE_SMOOTH);
	public static final Image img_exit4 = new ImageIcon(ManagementService.class.getResource("/icon_project/exit1_icon.jpg")).getImage().getScaledInstance(26, 26, Image.SCALE_SMOOTH);
	public static final Image img_medicine1 = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/medicine_icon.jpg")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_dental2 = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/dentalservice_icon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);

	public static final Image img_avatar1 = new ImageIcon(MainSystem.class.getResource("/icon_project/avatar3_icon.png")).getImage().getScaledInstance(180,160, Image.SCALE_SMOOTH);
	public static final Image img_first = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/first_icon.png")).getImage().getScaledInstance(448, 85, Image.SCALE_SMOOTH);
	public static final StringBuilder introduction = new StringBuilder("*Giới thiệu chung:\n    Nha khoa ABC tự hào là một trong những nha khoa chất lượng và uy tín hàng đầu tại thành phố \nĐà Nẵng.\n\n*Sứ mệnh:\n   Với sứ mệnh giúp cho mọi người chăm sóc sức khỏe răng miệng tốt hơn mỗi ngày với chi phí \nhợp lí, nha khoa rất chú trọng trong việc tạo sự thoải mái cho khách hàng nên cơ sở vật chất tại ABC\nđược xây dựng để làm nên điều đó. Cơ sở vật chất của phòng khám khang trang, hiện đại và sang trọng, \nliên tục hoàn thiện và phát triển để tạo sự thuận lợi nhất đến với khách hàng.\n\n*Đội ngũ nha sĩ chuyên môn cao\n  Nha khoa ABC có đội ngũ nha sĩ có trình độ chuyên môn giỏi, nhiều năm kinh nghiệm, tốt nghiệp tại\ncác trường răng hàm mặt nổi tiếng trong và ngoài nước.");
	
	public static final Image img_loginfirst = new ImageIcon(MainSystem.class.getResource("/icon_project/main_icon.jpg")).getImage().getScaledInstance(600,143, Image.SCALE_SMOOTH);
	public static final Image img_edit2 = new ImageIcon(ManagementService.class.getResource("/icon_project/edit1_icon.png")).getImage().getScaledInstance(40, 25, Image.SCALE_SMOOTH);
	public static final Image img_print = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/print_icon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_new = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/new_icon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);

	public static final Image img_patient_statistic = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/patient_statistic_icon.png")).getImage().getScaledInstance(162, 116, Image.SCALE_SMOOTH);
	public static final Image img_invoice_statistic = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/invoice_statistic_icon.jpg")).getImage().getScaledInstance(162, 116, Image.SCALE_SMOOTH);
	public static final Image img_detail = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/detail_icon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image img_main = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/main.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
	public static final Image back = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/back1.jpg")).getImage().getScaledInstance(743, 165, Image.SCALE_SMOOTH);
	public static final Image back1 = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/back1.jpg")).getImage().getScaledInstance(920, 165, Image.SCALE_SMOOTH);
	public static final Image logout1 = new ImageIcon(MainSystem.class.getResource("/icon_project/logout.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

	public static final Image img1 = new ImageIcon(PanelDanhMuc.class.getResource("/icon_project/1.jpg")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);

}
