package  com.bootdo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

public class DateUtil
{
  public static final String Format_Year = "yyyy";
  public static final String Format_Month = "yyyyMM";
  public static final String Format_Date = "yyyy-MM-dd";
  public static final String Format_Time = "HH:mm:ss";
  public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";
  public static final SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
  
  private static final ThreadLocal<SimpleDateFormat> sdfd = new ThreadLocal<SimpleDateFormat>(); 

  public static final SimpleDateFormat sdft = new SimpleDateFormat("HH:mm:ss");

  public static final SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  
  public static SimpleDateFormat getDateFormat()   
  {  
	  SimpleDateFormat df = sdfd.get();  
      if(df==null){  
          df = new SimpleDateFormat(Format_Date);  
          sdfd.set(df);  
      }  
      return df;  
  }  
  
  
  public static String getYear(Date date){
	  return sdfy.format(date);
  }
  
  
  
  public static String getCurrentDate()
  {
    return getDateFormat().format(new Date());
  }

  public static String getCurrentDate(String format)
  {
    SimpleDateFormat t = new SimpleDateFormat(format);
    return t.format(new Date());
  }

  public static String getCurrentTime()
  {
    return sdft.format(new Date());
  }

  public static String getCurrentTime(String format)
  {
    SimpleDateFormat t = new SimpleDateFormat(format);
    return t.format(new Date());
  }

  public static String getCurrentDateTime()
  {
    String format = "yyyy-MM-dd HH:mm:ss";
    return getCurrentDateTime(format);
  }

  public static int getDayOfWeek() {
    Calendar cal = Calendar.getInstance();
    return cal.get(7);
  }

  public static int getDayOfWeek(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(7);
  }

  public static int getDayOfMonth() {
    Calendar cal = Calendar.getInstance();
    return cal.get(5);
  }

  public static int getDayOfMonth(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(5);
  }

  public static int getMaxDayOfMonth(Date date)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.getActualMaximum(5);
  }

  public static String getFirstDayOfMonth(String date)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(parse(date));
    cal.set(5, 1);
    return getDateFormat().format(cal.getTime());
  }
  
  public static String getFirstDayOfMonth(Date date){
	  return getFirstDayOfMonth(toString(date));
  }
  
  /**
   * 取得某个月的最后一天
   * @param date
   * @param format
   * @return
   */
  public static String getLastDayofMonth(String date,String format){
	  Calendar cal = Calendar.getInstance();
	  cal.setTime(parse(date));
	  cal.set(5, getMaxDayOfMonth(parseDateTime(date,format)));
	  return getDateFormat().format(cal.getTime());
  }
  
  public static String getLastDayofMonth(Date date,String format){
	  return getLastDayofMonth(toString(date,format),format);
  }

  public static int getDayOfYear() {
    Calendar cal = Calendar.getInstance();
    return cal.get(6);
  }

  public static int getDayOfYear(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(6);
  }

  public static int getWeekOfYear() {
    Calendar cal = Calendar.getInstance();
    return cal.get(Calendar.WEEK_OF_YEAR);
  }

  public static int getWeekOfYear(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(Calendar.WEEK_OF_YEAR);
  }

  public static int getDayOfWeek(String date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(parse(date));
    return cal.get(7);
  }

  public static int getDayOfMonth(String date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(parse(date));
    return cal.get(5);
  }

  public static int getDayOfYear(String date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(parse(date));
    return cal.get(6);
  }
  
  public static String getCurrentDateTime(String format) {
    SimpleDateFormat t = new SimpleDateFormat(format);
    return t.format(new Date());
  }

  public static String toString(Date date)
  {
    if (date == null) {
      return "";
    }
    return getDateFormat().format(date);
  }

  public static String toDateTimeString(Date date)
  {
    if (date == null) {
      return "";
    }
    return sdfdt.format(date);
  }

  public static String toString(Date date, String format)
  {
    if (date == null) {
      return "";
    }
    SimpleDateFormat t = new SimpleDateFormat(format);
    return t.format(date);
  }

  public static String toTimeString(Date date)
  {
    if (date == null) {
      return "";
    }
    return sdft.format(date);
  }

  public static int compare(String date1, String date2) {
    return compare(date1, date2, "yyyy-MM-dd");
  }

  public static int compareTime(String time1, String time2) {
    return compareTime(time1, time2, "HH:mm:ss");
  }

  public static int compare(String date1, String date2, String format) {
    Date d1 = parse(date1, format);
    Date d2 = parse(date2, format);
    return d1.compareTo(d2);
  }

  public static int compareTime(String time1, String time2, String format) {
    String[] arr1 = time1.split(":");
    String[] arr2 = time2.split(":");
    if (arr1.length < 2) {
      throw new RuntimeException("错误的时间值:" + time1);
    }
    if (arr2.length < 2) {
      throw new RuntimeException("错误的时间值:" + time2);
    }
    int h1 = Integer.parseInt(arr1[0]);
    int m1 = Integer.parseInt(arr1[1]);
    int h2 = Integer.parseInt(arr2[0]);
    int m2 = Integer.parseInt(arr2[1]);
    int s1 = 0; int s2 = 0;
    if (arr1.length == 3) {
      s1 = Integer.parseInt(arr1[2]);
    }
    if (arr2.length == 3) {
      s2 = Integer.parseInt(arr2[2]);
    }
    if ((h1 < 0) || (h1 > 23) || (m1 < 0) || (m1 > 59) || (s1 < 0) || (s1 > 59)) {
      throw new RuntimeException("错误的时间值:" + time1);
    }
    if ((h2 < 0) || (h2 > 23) || (m2 < 0) || (m2 > 59) || (s2 < 0) || (s2 > 59)) {
      throw new RuntimeException("错误的时间值:" + time2);
    }
    if (h1 != h2) {
      return ((h1 > h2) ? 1 : -1);
    }
    if (m1 == m2) {
      if (s1 == s2) {
        return 0;
      }
      return ((s1 > s2) ? 1 : -1);
    }

    return ((m1 > m2) ? 1 : -1);
  }

  public static boolean isTime(String time)
  {
    String[] arr = time.split(":");
    if (arr.length < 2)
      return false;
    try
    {
      int h = Integer.parseInt(arr[0]);
      int m = Integer.parseInt(arr[1]);
      int s = 0;
      if (arr.length == 3) {
        s = Integer.parseInt(arr[2]);
      }
      if ((h < 0) || (h > 23) || (m < 0) || (m > 59) || (s < 0) || (s > 59))
        return false;
    }
    catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isDate(String date) {
    String[] arr = date.split("-");
    if (arr.length < 3)
      return false;
    try
    {
      int y = Integer.parseInt(arr[0]);
      int m = Integer.parseInt(arr[1]);
      int d = Integer.parseInt(arr[2]);
      if ((y < 0) || (m > 12) || (m < 0) || (d < 0) || (d > 31))
        return false;
    }
    catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isWeekend(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int t = cal.get(7);

    return ((t == 7) || (t == 1));
  }

  public static boolean isWeekend(String str)
  {
    return isWeekend(parse(str));
  }

  public static Date parse(String str) {
    if (StringUtils.isEmpty(str))
      return null;
    try
    {
      return getDateFormat().parse(str);
    } catch (ParseException e) {
      e.printStackTrace(); }
    return null;
  }

  public static Date parse(String str, String format)
  {
    if (StringUtils.isEmpty(str))
      return null;
    try
    {
      SimpleDateFormat t = new SimpleDateFormat(format);
      return t.parse(str);
    } catch (ParseException e) {
      e.printStackTrace(); }
    return null;
  }

  public static Date parseDateTime(String str)
  {
    if (StringUtils.isEmpty(str)) {
      return null;
    }
    if (str.length() == 10){
    	return parse(str);
    }
    	
    try
    {
    	//SimpleDateFormat是非线程安全的,线程中调用必须new一个新的实例
      SimpleDateFormat sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      return sdfdt.parse(str);
    } catch (ParseException e) {
      e.printStackTrace(); }
    return null;
  }

  public static Date parseDateTime(String str, String format)
  {
    if (StringUtils.isEmpty(str))
      return null;
    try
    {
      SimpleDateFormat t = new SimpleDateFormat(format);
      return t.parse(str);
    } catch (ParseException e) {
      e.printStackTrace(); }
    return null;
  }

  public static Date addMinute(Date date, int count)
  {
    return new Date(date.getTime() + 60000L * count);
  }

  public static Date addHour(Date date, int count)
  {
    return new Date(date.getTime() + 3600000L * count);
  }

  public static Date addDay(Date date, int count)
  {
    return new Date(date.getTime() + 86400000L * count);
  }

  public static Date addWeek(Date date, int count)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(3, count);
    return c.getTime();
  }

  public static Date addMonth(Date date, int count)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(2, count);
    return c.getTime();
  }

  public static Date addYear(Date date, int count)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(1, count);
    return c.getTime();
  }
  public static String dateToString(Date date, String pattern) {
		String datVal = null;
		SimpleDateFormat simp = new SimpleDateFormat();
		try {
			simp.applyPattern(pattern);
			datVal = simp.format(date);
		} catch (Exception e) {
			return null;
		}

		return datVal;
	}
  	/**
	 * 查询日期的起始时间：2009-8-18 00:00:00
	 * @author zhaohui
	 * @param value
	 * @return
	 */
	public static Date getStartTimeOfDate(Date value) {
		if(value == null) return value;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(value);
		cal1.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cal1.getTime();
	}

	/**
	 * 查询日期的结束时间：2009-8-18 23:59:59
	 * @author zhaohui
	 * @param value
	 * @return
	 */
	public static Date getEndTimeOfDate(Date value) {
		if(value == null) return value;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(value);
		cal1.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return cal1.getTime();
	}
	
	public static Date getStartTimeOfDateWeek(Date value) {
		
		 Calendar cd = Calendar.getInstance();
		 cd.setTime(value);
		cd.setFirstDayOfWeek(Calendar.MONDAY);
		 cd.set(Calendar.DAY_OF_WEEK, 2);
		 cd.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cd.getTime();
	}
	
	public static Date getEndTimeOfDateWeek(Date value) {
		
		 Calendar cd = Calendar.getInstance();
		 cd.setTime(value);
		 cd.setFirstDayOfWeek(Calendar.MONDAY);
		 cd.set(Calendar.DAY_OF_WEEK, 8);
		 cd.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
	       
		return cd.getTime();
	}
	public static Date getStartTimeOfDateOfMonth(Date value,Integer mstart) {
		
		 Calendar cd = Calendar.getInstance();
		 cd.setTime(value);
		int d= cd.get(Calendar.DAY_OF_MONTH);
		if(d>=mstart) {
			cd.set(Calendar.DAY_OF_MONTH, mstart);
		}else {
			cd.add(Calendar.MONTH, -1);
			cd.set(Calendar.DAY_OF_MONTH, mstart);
		}
		cd.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cd.getTime();
	}
	public static Date getEndTimeOfDateOfMonth(Date value,Integer mstart) {
		
		 Calendar cd = Calendar.getInstance();
		 cd.setTime(value);
		int d= cd.get(Calendar.DAY_OF_MONTH);
		if(d>=mstart) {
			cd.add(Calendar.MONTH, 1);
			cd.set(Calendar.DAY_OF_MONTH, mstart-1);
		}else {
			cd.set(Calendar.DAY_OF_MONTH, mstart-1);
		}
		cd.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return cd.getTime();
	}
	//mstart, 半月开始时间，大值
	//mend, 半月结束时间，小值
	public static Date getStartTimeOfDateHalfOfMonth(Date value,Integer mstart,Integer mend) {
		
		 Calendar cd = Calendar.getInstance();
		 cd.setTime(value);
		int d= cd.get(Calendar.DAY_OF_MONTH);
		if(d>=mstart) {
			cd.set(Calendar.DAY_OF_MONTH, mstart);
		}else if(d<mend+1){
			cd.add(Calendar.MONTH, -1);
			cd.set(Calendar.DAY_OF_MONTH, mstart);
		}
		else if(d>=mend+1) {
			cd.set(Calendar.DAY_OF_MONTH, mend+1);
		}
		cd.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		return cd.getTime();
	}
	public static Date getEndTimeOfDateHalfOfMonth(Date value,Integer mstart,Integer mend) {
		
		 Calendar cd = Calendar.getInstance();
		 cd.setTime(value);
		int d= cd.get(Calendar.DAY_OF_MONTH);
		if(d>=mstart) {
			cd.add(Calendar.MONTH, 1);
			cd.set(Calendar.DAY_OF_MONTH, mend);
		}else if(d<=mend){
			
			cd.set(Calendar.DAY_OF_MONTH, mend);
		}
		else if(d>mend) {
			cd.set(Calendar.DAY_OF_MONTH, mstart-1);
		}
		cd.set(cd.get(Calendar.YEAR), cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		return cd.getTime();
	}
	
	/**
	 * 获取日期差，返回相差小时数。
	 * @author zhaohui
	 */
	public static long getCompareHour(Date startDate,Date endDate){
      long l = endDate.getTime() - startDate.getTime();
      long h = l/(60*60*1000);
      return h;
	}
	
	/**
	 * 获取日期差，返回相差天数。
	 * @author zhaohui
	 */
	public static long getCompareDate(Date startDate,Date endDate){
      long l = endDate.getTime() - startDate.getTime();
      long d = l/(24*60*60*1000);
      return d;
	}
	/**
	 * 获取日期差，返回相差天数,只计算天的差距，不算小时
	 * @author zhaohui
	 */
	public static long getCompareDateNumber(Date startDate,Date endDate){
		Calendar scal =Calendar.getInstance();
		scal.setTime(startDate);
		scal.set(scal.get(Calendar.YEAR), scal.get(Calendar.MONTH), scal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		
		Calendar ecal =Calendar.getInstance();
		ecal.setTime(endDate);
		ecal.set(ecal.get(Calendar.YEAR), ecal.get(Calendar.MONTH), ecal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		
		 long l = ecal.getTimeInMillis() - scal.getTimeInMillis();
	     long d = l/(24*60*60*1000);
	     return d;
		}
	/**
	 * 获得相差月数，date1-date2
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getCompareMonth(Date date1, Date date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(date1);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(date2);
		int c = (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12
				+ cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH);
		return c;
	}
	
	/**
	 * 获取一个月的天数
	 * @param date
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static int getDaysOfMonth(String date,String format){
		Calendar rightNow = Calendar.getInstance();
		try {
			SimpleDateFormat simpleDate = new SimpleDateFormat(format);
			rightNow.setTime(simpleDate.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int days = rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);
		return days;
	}
	
	/*
	 * 传入参数
	 *-- year:年
	 *-- weekNo:本年第几周，一年有52周，所以传入的周数最大为52，取值范围:1——52 周
	 *
	 *例：输入：year=2015,weekNo=35. 返回：开始日期：2015-08-24，结束日期：2015-08-30
	 * */
    public static String getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        String monthStr = (cal.get(Calendar.MONTH) + 1)<10 ? "0" +(cal.get(Calendar.MONTH) + 1) : ""+(cal.get(Calendar.MONTH) + 1);
        return cal.get(Calendar.YEAR) + "-" + monthStr + "-" +
               cal.get(Calendar.DAY_OF_MONTH);    
        
    }
    
    public static String getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        String monthStr = (cal.get(Calendar.MONTH) + 1)<10 ? "0" +(cal.get(Calendar.MONTH) + 1) : ""+(cal.get(Calendar.MONTH) + 1);
        return cal.get(Calendar.YEAR) + "-" + monthStr + "-" +
               cal.get(Calendar.DAY_OF_MONTH);    
    }
    
    public static Calendar getCalendarFormYear(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);      
        cal.set(Calendar.YEAR, year);
        return cal;
    }
    
    public static String date2String(Date date, String pattern)
	  {
	    if (date == null)
	      return "";
	    String datVal = null;
	    SimpleDateFormat simp = new SimpleDateFormat();
	    try {
	      simp.applyPattern(pattern);
	      datVal = simp.format(date);
	    } catch (Exception e) {
	      return null;
	    }

	    return datVal;
	  }
    // 获得本周一与当前日期相差的天数  
    public static  int getMondayPlus() {  
        Calendar cd = Calendar.getInstance();  
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);  
        if (dayOfWeek == 1) {  
            return -6;  
        } else {  
            return 2 - dayOfWeek;  
        }  
    }  
    // 获得当前周- 周一的日期  
    public static  String getCurrentMonday() {  
        int mondayPlus = getMondayPlus();  
        GregorianCalendar currentDate = new GregorianCalendar();  
        currentDate.add(GregorianCalendar.DATE, mondayPlus);  
        Date monday = currentDate.getTime();  
        String preMonday = toString(monday);  
        return preMonday;  
    }    
    
    // 获得当前周- 周日  的日期  
    public static String getPreviousSunday() {  
        int mondayPlus = getMondayPlus();  
        GregorianCalendar currentDate = new GregorianCalendar();  
        currentDate.add(GregorianCalendar.DATE, mondayPlus +6);  
        Date monday = currentDate.getTime();  
        String preMonday = toString(monday);  
        return preMonday;  
    } 
    
    /**
	 * 输入一个日期,输出这个日期所在周的第一天及最后一天,默认一周是从周一开始
	 * @param nowDate
	 * @return
	 */
    public static String getStartAndEndDayOfWeek(String nowDate){
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Calendar cal = Calendar.getInstance();
		try {
			Date time = sdf.parse(nowDate);
			cal.setTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("日期转换错误！");
		}
		// System.out.println("要计算日期为:"+sdf.format(cal.getTime())); //输出要计算日期

		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}

		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一

		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		// System.out.println("所在周星期一的日期："+sdf.format(cal.getTime()));
		// System.out.println(cal.getFirstDayOfWeek()+"-"+day+"+6="+(cal.getFirstDayOfWeek()-day+6));
		result+=sdf.format(cal.getTime());
		
		cal.add(Calendar.DATE, 6);
		// System.out.println("所在周星期日的日期："+sdf.format(cal.getTime()));
		return result+ "@" + sdf.format(cal.getTime());
	}
	
	/**
	 * 输入一个日期,输出这个日期所在的年及周     默认一周是从周一开始
	 * @param nowDate
	 * @return
	 */
    public static String getYearAndWeek(String nowDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cl = Calendar.getInstance();
		cl.setFirstDayOfWeek(Calendar.MONDAY);
		try {
			Date time = sdf.parse(nowDate);
			cl.setTime(time);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("日期转换错误！");
		}
		
		int week = cl.get(Calendar.WEEK_OF_YEAR);
		System.out.println(week);
		cl.add(Calendar.DAY_OF_MONTH, -7);
		int year = cl.get(Calendar.YEAR);
		if (week < cl.get(Calendar.WEEK_OF_YEAR)) {
			year += 1;
		}
		return year + "@" + week;
	}
    
    /**
     * 获取指定年及周的第一天
     * @param year
     * @param week
     * @return
     */
    public static String getStartDayOfWeek(String year,String week){
    	Calendar cal=Calendar.getInstance();
		cal.clear();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.YEAR,Integer.parseInt( year));
		cal.set(Calendar.WEEK_OF_YEAR, Integer.parseInt(week));
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return DateUtil.getDateFormat().format(cal.getTime());
    }
    
    /**
     * 获取指定年及周的最后一在
     * @param year
     * @param week
     * @return
     */
    public static String getEndDayOfWeek(String year,String week){
    	Calendar cal=Calendar.getInstance();
		cal.clear();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.WEEK_OF_YEAR, Integer.parseInt(week));
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, 6);
		return DateUtil.getDateFormat().format(cal.getTime());
    }
    
	public static void main(String[] str) {
//		String d = getPreviousSunday();
//		System.out.println(getEndDayOfWeek("2017","27"));
//		System.out.println(jwdTransfer("12.55"));
//			System.out.println(getCompareDate(new Date(), new Date()));
//		System.out.println(toString(addMonth(new Date(), -1), "yyyy年MM月dd日"));
//		System.out.println(getCompareMonth(new Date(), addMonth(new Date(), -24)));
//		System.out.println(getCompareMonth(new Date(), new Date()));
		//System.out.println(getDayOfYear("2013-12-30")/7);
//		System.out.println(getMaxDayOfMonth(parse("2013-04-01")));
		
		Date sdate=DateUtil.parse("2018053102", "yyyyMMddhh");
		System.out.println(sdate);
	}
	
}