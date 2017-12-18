package flying.tool;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {
	
	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	public static String formatDate(Date date, String...format) throws ParseException{
		String fmtString = format.length > 0? format[0]: "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmtString);
        return sdf.format(date);
	}
   
	public static Date parse(String strDate, String...format) throws ParseException{
		String fmtString = format.length > 0? format[0]: "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmtString);
        return sdf.parse(strDate);
	}
	
}
