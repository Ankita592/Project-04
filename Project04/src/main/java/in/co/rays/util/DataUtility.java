package in.co.rays.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DataUtility {

	public static final String APP_DATE_FORMAT = "yyyy-MM-dd";
	public static final String APP_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);
	
	public static String getString(String val)
	{
		if(DataValidator.isNotNull(val))
		{
			return val.trim();
		}
		
		else
		{
			return val;
		}
		
	}
	
	public static String getStringData(Object val) //object can be int,char,double,float ,string
	
	{
		if(val != null)
		{
			return val.toString(); //ex:3 then it will return in string "3"
		}
		else
		{
			return ""; //returns empty string
		}
	}
	
	 public static int getInt(String val)
	 {
		 
		 if(DataValidator.isInteger(val))
		 {
			 return Integer.parseInt(val);
		 }
		 
		 else
		 {
			 return 0;
		 }
	 }
//Yeh method ensure karta hai ki agar string me ek valid integer ho, toh use integer me convert karke return kare. Agar valid integer nahi hai, toh safe value 0 return karta hai, taaki program crash ya error na ho.
//ex : int result = getInt("123");
// result = 123 (kyunki yeh valid integer hai)
		 
	 public static long getLong(String val)
	 {
		 if(DataValidator.isLong(val))
		 {
			 return Long.parseLong(val);
		 }
		 else
		 {
			 return 0;
		 }
		 
	 }
	 
	 public static Date getDate(String val) //ye method getDate ek string ko date object m convert krta
	 {
		 Date date = null;
		 try
		 {
			 date = formatter.parse(val);
		 }
		 catch(Exception e)
		 {
			 
		 }
		 return date;
	 }


// string input hai:Ex: "2024-10-16".

//Agar ye format theek hai aur formatter is format ko samajhta hai, toh getDate("2024-10-16") date object return karega.
//Example output : 2024-10-16 00:00:00. tum input "1234" de rhe ho to null return krega ye
	

public static String getDateString(Date date) {
	try {
		return formatter.format(date);
	} catch (Exception e) {
	}
	return "";
}



//getDateString ek Date object ko string format mein convert karne ke liye use kia

//Valid Date: getDateString(new Date(2024 - 1900, 9, 16)) returns "2024-10-16".
//Null Date: getDateString(null) returns "" (empty string).

public static Date getDate(Date date, int day) {
	return null;
}


public static Timestamp getTimestamp(String val)  
{
	
	Timestamp timestamp = null;
	try
	{
		timestamp = new Timestamp((timeFormatter.parse(val)).getTime());
	}
	catch(Exception e)
	{
		return null;
	}
	return timestamp;
}

//function hai input string ko Timestamp object mein convert karna, aur agar string ka format galat hai, toh null return karna.
//Ex: input: getTimestamp("2024-10-16 10:30:00")
//Output: 2024-10-16 10:30:00.0
//Input: getTimestamp("wrong-format")
//Output: null


public static Timestamp getTimestamp(long l)
{
	Timestamp timeStamp = null;
	try
	{
		timeStamp = new Timestamp(l);
	}
	catch(Exception e)
	{
		return null;
	}
	return timeStamp;
}

/*method ek long value l ko use karke Timestamp object banata hai. Agar sab kuch sahi hai, toh wo timestamp return karta hai; agar error hota hai, toh null return karta hai.

ex: Input: getTimestamp(1634572800000L)

Output: 2021-10-18 00:00:00.000 (UTC) */

public static Timestamp getCurrentTimestamp()
{
	Timestamp timeStamp = null;
	
	try
	{
		timeStamp = new Timestamp(new Date().getTime());
	}
	catch(Exception e)
	{
		
	}
	return timeStamp;
}

/*
current date aur time ko Timestamp object mein convert karta hai. 
Agar sab kuch sahi hai, toh wo current timestamp return karega. 
Agar koi error aata hai, toh null return karega.

 Ex :
 
 getCurrentTimestamp() call karte hain, toh ye output karega kuch is tarah ka Timestamp:
Output: 2024-10-16 12:34:56.789 */

public static long getTimestamp(Timestamp tm) {
	try {
		return tm.getTime();
	} catch (Exception e) {
		return 0;
	}
}
/*
Ye method getTimestamp ek Timestamp object ko input ke roop mein leta hai
aur isse long integer (milliseconds) mein convert karta hai
Agar Timestamp valid hai, toh corresponding milliseconds return hota hai;
 agar koi error aata hai, toh 0 return hota hai.
*/

public static void main(String[] args) {
	// Test getString
	System.out.println("getString Test:");
	System.out.println("Original: '  Hello World  ' -> Trimmed: '" + getString("  Hello World  ") + "'");
	System.out.println("Null input: " + getString(null));

	// Test getStringData
	System.out.println("\ngetStringData Test:");
	System.out.println("Object to String: " + getStringData(1234));
	System.out.println("Null Object: '" + getStringData(null) + "'");

	// Test getInt
	System.out.println("\ngetInt Test:");
	System.out.println("Valid Integer String: '124' -> " + getInt("124"));
	System.out.println("Invalid Integer String: 'abc' -> " + getInt("abc"));
	System.out.println("Null String: -> " + getInt(null));

	// Test getLong
	System.out.println("\ngetLong Test:");
	System.out.println("Valid Long String: '123456789' -> " + getLong("123456789"));
	System.out.println("Invalid Long String: 'abc' -> " + getLong("abc"));

	// Test getDate
	System.out.println("\ngetDate Test:");
	String dateStr = "2024/05/15";
	Date date = getDate(dateStr);
	System.out.println("String to Date: '" + dateStr + "' -> " + date);

	// Test getDateString
	System.out.println("\ngetDateString Test:");
	System.out.println("Date to String: '" + getDateString(new Date()) + "'");

	// Test getTimestamp (String)
	System.out.println("\ngetTimestamp(String) Test:");
	String timestampStr = "10/15/2024 10:30:45";
	Timestamp timestamp = getTimestamp(timestampStr);
	System.out.println("String to Timestamp: '" + timestampStr + "' -> " + timestamp);

	// Test getTimestamp (long)
	System.out.println("\ngetTimestamp(long) Test:");
	long currentTimeMillis = System.currentTimeMillis();
	Timestamp ts = getTimestamp(currentTimeMillis);
	System.out.println("Current Time Millis to Timestamp: '" + currentTimeMillis + "' -> " + ts);

	// Test getCurrentTimestamp
	System.out.println("\ngetCurrentTimestamp Test:");
	Timestamp currentTimestamp = getCurrentTimestamp();
	System.out.println("Current Timestamp: " + currentTimestamp);

	// Test getTimestamp(Timestamp)
	System.out.println("\ngetTimestamp(Timestamp) Test:");
	System.out.println("Timestamp to long: " + getTimestamp(currentTimestamp));
}


}






























