package Checked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataChecked {

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
	
	
}
