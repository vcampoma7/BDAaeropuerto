package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
	public boolean stringIsNumeric(String str){
		  try  
		  {  
		    Float.parseFloat(str);  
		  }  
		  catch(Exception e)  
		  {  
		    return false;  
		  }  
		  return true; 
	}
	
	public boolean stringIsDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed;
		try {
			parsed = format.parse(str);
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return false;
	}
	
	public Date stringToDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed;
		try {
			parsed = format.parse(str);
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
	        return sql;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
