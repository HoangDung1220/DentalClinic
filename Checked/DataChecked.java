package Checked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataChecked {

	public boolean checkSDT(String st) {
		String regex = "[\\d]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		if (matcher.find()) {
		return true;
		}
		return false;
		
	}
	
}
