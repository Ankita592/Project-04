package in.co.rays.util;

import java.util.ResourceBundle;

public class PropertyReader {

	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");
	
	public static String getValue(String key)
	{
		String val = null;
		try {
			val = rb.getString(key); //0 is required
		}
		catch(Exception e)
		{
			val = key;
		}
		
		return val;
		
	}
	
	/*
Input key diya gaya ("error.require" ya "invalidKey").
Try block mein ResourceBundle se value fetch ki jaati hai:
Agar key milti hai, to uski value return hoti hai.
Agar key nahi milti, to exception catch block mein handle hoti hai aur key ko hi return kr dete h.
	
	*/
	
	
	public static String getValue(String key,String param)
	
	{
		String msg = getValue(key); //0 is requied.
		msg = msg.replace("{0}", param);
		return msg;
		
		
	}
	
	/*
	 * getValue(key) se message fetch kiya jata hai resource bundle se. Example:
	 * "{0} is required". {0} placeholder ko given parameter (jaise "loginId" ya
	 * "password") se replace kar diya jata hai
	 * 
	 * Final message return hota hai with the placeholder replaced.
	 */
	
	
	public static String getValue(String key, String [] params)
	
	{
		String msg = getValue(key);
		for(int i=0;i<params.length;i++)
		{
			msg = msg.replace("{" + i + "}", params[i]);
		}
		
		return msg;
		
		
		
		
	}
	
/* getValue(String key) :Returns the message with placeholders (e.g., "{0} is required").
getValue(String key, String param) : Returns the message with {0} replaced by the value of param 
(e.g., "loginId is required").
	*/
	
	public static void main(String[] args) {
		
		System.out.println("Single key example:");
		System.out.println(PropertyReader.getValue("error.require"));
		
		System.out.println("\nSingle parameter Replacement Example:");
		System.out.println(PropertyReader.getValue("error.require","loginId"));
		
		System.out.println("\nMultiple parameter Replacement Example ");
		String[] params = {"Roll No","Student Name"};
		System.out.println(PropertyReader.getValue("error.multipleFields", params));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
