package CheckData;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhone {
   public  boolean checkSDT(String st)
   {
	    String regex = "[\\d]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(st);
		if (matcher.find()) {
		return true;
		}
		return false;
   }   
	  
}
