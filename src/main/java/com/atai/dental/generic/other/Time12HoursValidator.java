package com.atai.dental.generic.other;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time12HoursValidator{

	  private Pattern pattern;
	  private Matcher matcher;

	  private static final String TIME12HOURS_PATTERN =
                                "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";

	  public Time12HoursValidator(){
		  pattern = Pattern.compile(TIME12HOURS_PATTERN);
	  }

	  /**
	   * Validate time in 12 hours format with regular expression
	   * @param time time address for validation
	   * @return true valid time fromat, false invalid time format
	   */
	  private boolean validateprivate(final String time){
		  System.out.println("########### 04"+time );
		  matcher = pattern.matcher(time);
		  return matcher.matches();
	  }
	  
	  public void validate(final String time){
		  System.out.println("########### 03"+time );
		  if(!time.isEmpty())
		  {
			  if(!validateprivate(time))
			  { System.out.println("########### 05"+time );
				  throw new java.lang.Error("Invalid Time format");
			  }
			  System.out.println("########### 06"+time );
		  }
	  }
	  
	  public String convertTime(final String time)
	  {
		  String tmpTime = time;
		  if(!time.isEmpty())
		  {
			  if(tmpTime.length()>2)
			  {
					String s = tmpTime.substring(tmpTime.length()-2, tmpTime.length());
					s = s.toLowerCase();
					String i = tmpTime.substring(0, tmpTime.indexOf(':'));
					int iN   = Integer.parseInt(i);
					if(s.equals("pm"))
					{
						if(iN!=12)
						{
							iN=iN+12;
						}
					}
					else
					{
						if(iN==12)
						{
							iN=0;
						}
					}
					
					tmpTime = Integer.toString(iN) +tmpTime.substring(tmpTime.indexOf(':'),tmpTime.length()-2)+":00";
			 }
		 }
		 return tmpTime;
	  }
	  
	  public String convertTimeBack(final String time)
	  {
		  String tmpTime = time;
		  if(!time.isEmpty())
		  {
			  if(tmpTime.length()>2)
			  {
					String s ="";
					String i = tmpTime.substring(0, tmpTime.indexOf(':'));
					String j = tmpTime.substring(tmpTime.indexOf(':')+1,tmpTime.length());
					int iN   = Integer.parseInt(i);
					if(iN==0)
					{
						iN=12;
						s = "am";
					}
					else if(iN==12)
					{
						iN=12;
						s = "pm";
					}
					else if(iN<12)
					{
						s="am";
					}
					else
					{
						iN=iN-12;
						s="pm";
					}
					tmpTime = Integer.toString(iN) +":"+j.substring(0,j.indexOf(':'))+s;
			 }
		 }
		 return tmpTime;
	  }
}