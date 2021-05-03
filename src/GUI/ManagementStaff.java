package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class ManagementStaff extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JLabel lblNewLabel_2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementStaff frame = new ManagementStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagementStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 607);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 22, 316, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seeek_By");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 34, 108, 13);
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ID_Staff");
		rdbtnNewRadioButton.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton.setBounds(15, 68, 103, 21);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Name_Staff");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_1.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_1.setBounds(174, 68, 103, 21);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Char");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 131, 45, 13);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new CompoundBorder());
		textField.setBounds(107, 128, 140, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(96, 189, 85, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(349, 22, 743, 298);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_2 = new JLabel("ID_Staff");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(21, 32, 82, 13);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 29, 156, 19);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fullname");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(21, 82, 59, 13);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(113, 79, 156, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDateofbirth = new JLabel("DateOfBirth");
		lblDateofbirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateofbirth.setBounds(21, 139, 82, 13);
		panel_1.add(lblDateofbirth);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(113, 133, 156, 19);
		panel_1.add(dateChooser);
		
		JLabel lblNewLabel_4 = new JLabel("Phonenumber");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(21, 192, 96, 13);
		panel_1.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 189, 156, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(279, 32, 45, 13);
		panel_1.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(362, 29, 145, 19);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("I_Card ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(279, 82, 72, 13);
		panel_1.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(362, 79, 145, 19);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("DateOfWork");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(279, 139, 103, 13);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Adress");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(279, 192, 45, 13);
		panel_1.add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Male\r\n");
		rdbtnNewRadioButton_2.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_2.setBounds(602, 28, 103, 21);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Female");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnNewRadioButton_3.setBackground(SystemColor.activeCaption);
		rdbtnNewRadioButton_3.setBounds(602, 78, 103, 21);
		panel_1.add(rdbtnNewRadioButton_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(351, 189, 354, 19);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Gender");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(527, 32, 69, 13);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Role");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(527, 139, 45, 13);
		panel_1.add(lblNewLabel_10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(602, 135, 103, 21);
		panel_1.add(comboBox);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(362, 133, 145, 19);
		panel_1.add(dateChooser_1);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(62, 250, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EDIT");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(239, 250, 85, 21);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(426, 250, 96, 21);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("EXIT ");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(599, 250, 85, 21);
		panel_1.add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 364, 1069, 185);
		contentPane.add(panel_2);
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
}
