package Utils;

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
}
