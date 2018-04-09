package com.wetogether.common.util.PubUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormater {
	public static final String DATETIME1="yyyy-MM-dd HH:mm:ss";
	public static final String DATETIME2="yyyy/MM/dd HH:mm:ss";
	public static final String DATETIME3="yyyy/MM/dd HH:mm";
	public static final String DATETIME4="yyyy-MM-dd HH:mm";
	
	public static final String TIME1 = "HH:mm:ss";
	
	public static final String DATE1="yyyy/MM/dd";
	public static final String DATE2="yyyy/MM/dd";
	
	public static String formater(Date date,String style){
		SimpleDateFormat f=new SimpleDateFormat(style);
		return f.format(date);
	}
  
 public static String  getTimeOrDate(Date d){
		  	SimpleDateFormat sdf = null;
		  
		    Date nowTime = new Date();
		    Calendar cNow = Calendar.getInstance();
		    cNow.setTime(nowTime);
		    Integer nowYear = cNow.get(Calendar.YEAR);
		    Integer nowMonth = cNow.get(Calendar.MONTH);
		    Integer nowDate = cNow.get(Calendar.DATE);
		    
		    Calendar cd = Calendar.getInstance();
		    cd.setTime(d);
		    Integer dYear = cd.get(Calendar.YEAR);
		    Integer dMonth = cd.get(Calendar.MONTH);
		    Integer dDate = cd.get(Calendar.DATE);
		   
		    
		    if(nowYear.equals(dYear)){
		    	if(nowMonth.equals(dMonth)&&nowDate.equals(dDate)){
		    		sdf = new SimpleDateFormat("HH:mm");
		    	}else{
		    		sdf = new SimpleDateFormat("MM-dd HH:mm");
		    	}	
		    }else{
		    	sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    }
		    
		    return sdf.format(d);
	  
	  }
	
}
