package Checked;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import BUS.implement.StaffBUS;
import DTO.Staff;


public class DataChecked {
	
	private static StaffBUS staff = new StaffBUS();

	public static boolean checkSDT(String st) {
		String regex = "^\\d{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		 if (matcher.matches()) {
			 return true;
		 }
		 return false;
		
	}
	
	public static boolean checkEmail(String st) {
		String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		 if (matcher.matches()) {
			 return true;
		 }
		 return false;
		
	}
	
	
	
	public static boolean checkICard(String st) {
		String regex = "^\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		 if (matcher.matches()) {
			 return true;
		 }
		 return false;
		
	}
	

	public static boolean checkData(String st) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		 if (matcher.matches()) {
			 return true;
		 }
		 return false;
		
	}
	
	public static boolean checkUsername(String st) {
		List<Staff> list =staff.findAll();
		boolean check=true;
		for (Staff sta:list) {
			if (sta.getUsername().equalsIgnoreCase(st))
				check=false;
		}
		
		return check;
	}
	

	public static boolean checkInteger(String st) {
		String regex = "[0,.]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		 if (matcher.matches()) {
			 return true;
		 }
		 return false;
	}
	
}
