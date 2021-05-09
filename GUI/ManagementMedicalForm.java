package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ManagementMedicalForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementMedicalForm frame = new ManagementMedicalForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManagementMedicalForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 458);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Create New Medical Form");
		btnNewButton.setBounds(394, 22, 213, 26);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(630, 22, 126, 26);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Medical Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 60, 100, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 85, 746, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("All");
		chckbxNewCheckBox.setBackground(SystemColor.activeCaption);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setBounds(223, 58, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("ID_Patient");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_1.setBackground(SystemColor.activeCaption);
		chckbxNewCheckBox_1.setBounds(365, 58, 93, 21);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Date_Cure");
		chckbxNewCheckBox_2.setBackground(SystemColor.activeCaption);
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_2.setBounds(520, 58, 93, 21);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Content_Cure");
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox_3.setBackground(SystemColor.activeCaption);
		chckbxNewCheckBox_3.setBounds(651, 58, 109, 21);
		contentPane.add(chckbxNewCheckBox_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch Medical_Form", TitledBorder.LEADING, TitledBorder.TOP, null, Color.YELLOW));
		panel.setBounds(10, 147, 746, 264);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 726, 234);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
