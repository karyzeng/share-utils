package com.util.date;

import com.alibaba.fastjson.JSON;
import com.github.houbb.paradise.common.util.StringUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 时间工具类
 * 
 * @author zzp
 * @since 2018.09.30
 *
 */
public class DateUtil {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static String FORMAT_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
	public static String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
	public static String FORMAT_yyyy_MM = "yyyy-MM";
	public static String FORMAT_MM = "MM";
	public static String FORMAT_dd = "dd";
	public static String FORMAT_yyyy = "yyyy";
	public static String FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static String FORMAT_yyyyMMdd = "yyyyMMdd";
	public static String FORMAT_yyyy_MM_dd_HH = "yyyy-MM-dd HH";
	public static String FORMAT_yyMMdd = "yyMMdd";
	public static String FORMAT_HH_mm_ss = "HH:mm:ss";

	public static void main(String[] args) {
//		System.out.println(getLastMonthFirstDay());
//		System.out.println(getLastMonthLastDay());
		System.out.println(getDayByNum("2020-10-27", 0));
//		System.out.println(getMonthFirstDay("2020-06-09"));
//		System.out.println(getMonthLastDay("2020-06-09"));
//		System.out.println(getNumFutureMonthDate("2018-10-01", 3));
//		System.out.println(betweenDays("2020-01-03", "2020-01-01"));
//		System.out.println(JSON.toJSONString(getDueDates()));
//
//		System.out.println(getNumDayDate("2020-06-01", 6));
//		System.out.println(JSON.toJSONString(getDateStartAndEndList("2020-06-23", "2020-06-23", 6)));
//		System.out.println(JSON.toJSONString(getBeforeNowDay(6, false)));
	}
	
	/**
	 * 获得上一个月的第一天
	 * 
	 * @return String
	 */
	public static String getLastMonthFirstDay() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse("2018-05-15"));
			calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获得上一个月的最后一天
	 * 
	 * @return String
	 */
	public static String getLastMonthLastDay() {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse("2018-05-15"));
			calendar.set(Calendar.DAY_OF_MONTH, 1); 
			calendar.add(Calendar.DATE, -1);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据date来获取当前月的最后一天
	 * 
	 * @param date 日期字符串
	 * 
	 * @return String
	 */
	public static String getMonthLastDay(String date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据date来获取当前月的第一天
	 *
	 * @param date 日期字符串
	 *
	 * @return String
	 */
	public static String getMonthFirstDay(String date) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(date));
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param dateStr
	 * @param num
	 * @return
	 */
	public static String getDayByNum(String dateStr, int num) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateFormat.parse(dateStr));
			calendar.add(Calendar.DATE, num);
			return dateFormat.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将分钟数转换成X天 Xh Xmin的格式
	 *
	 * @param num 分钟数
	 * @return String
	 */
	public static String convertMinToStr(long num) {
		long minute = 0;
		long hour = 0;
		long day = 0;

		if (num > 0) {
			minute = num % 60;
			num -= minute;
			if (num > 0) {
				num /= 60;
				hour = num % 24;
				num -= hour;
				if (num > 0) {
					day = num / 24;
				}
			}
		}

		if (day > 0) {
			return day + "天" + hour + "h" + minute + "min";
		} else if (hour > 0) {
			return hour + "h" + minute + "min";
		} else {
			return minute + "min";
		}
	}

	/**
	 * 将字符串转换为Date
	 * @param dateString
	 * @param format
	 * @return Date
	 */
	public static Date convertStringToDate(String dateString, String format) {

		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			if (!StringUtil.isBlank(dateString)) {
				date = sdf.parse(dateString);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据date获取num个月之后的日期
	 * @param date 日期字符串，格式如2020-02-14
	 * @param num 月数，正数为未来的月份，负数为过去的月份
	 * @return
	 */
	public static String getNumFutureMonthDate(String date, Integer num) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(DateUtils.parseDate(date, FORMAT_yyyy_MM_dd));
			calendar.add(Calendar.MONTH, num);
			return DateFormatUtils.format(calendar.getTime(), FORMAT_yyyy_MM_dd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据date获取num天之后或之前的日期
	 * @param dateStr date 日期字符串，格式如2020-02-14
	 * @param num 天数，正数为未来的天数，负数为过去的天数
	 * @return
	 */
	public static String getNumDayDate(String dateStr, Integer num) {
		try {
			Date date = DateUtils.parseDate(dateStr, FORMAT_yyyy_MM_dd);
			return getNumDayDate(date, num);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据date获取num天之后或之前的日期
	 * @param date date 日期
	 * @param num 天数，正数为未来的天数，负数为过去的天数
	 * @return
	 */
	public static String getNumDayDate(Date date, Integer num) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, num);
			return DateFormatUtils.format(calendar.getTime(), FORMAT_yyyy_MM_dd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 比较日期date1和日期date2
	 * @param date1
	 * @param date2
	 * @return 如果date1等于date2，则返回值 0；如果date1在date2之前，则返回小于0的值；如果date1在date2之后，则返回大于 0 的值。
	 */
	public static Integer compare(String date1, String date2) {
		try {
			Date temp1 = DateUtils.parseDate(date1, FORMAT_yyyy_MM_dd);
			Date temp2 = DateUtils.parseDate(date2, FORMAT_yyyy_MM_dd);
			return temp1.compareTo(temp2);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 计算日期date1和日期date2之间相差的天数，date1减去date2
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Integer betweenDays(String date1, String date2) {
		try {
			Date temp1 = DateUtils.parseDate(date1, FORMAT_yyyy_MM_dd);
			Date temp2 = DateUtils.parseDate(date2, FORMAT_yyyy_MM_dd);
			Long betweenDays =  (temp1.getTime() - temp2.getTime()) / (1000L*3600L*24L);
			return betweenDays.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static List<Map<String, String>> getDueDates() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String startDateStr = "2018-01-01";// 只统计此时间及之后的记录
//		String nowDateStr = DateFormatUtils.format(new Date(), DateUtil.FORMAT_yyyy_MM_dd);
		String nowDateStr = "2018-04-01";
		while (compare(nowDateStr, startDateStr) >= 0) {
			String endDateStr = getNumFutureMonthDate(startDateStr, 3);
			Map<String, String> map = new HashMap<String, String>();
			map.put("dueDateStart", startDateStr);
			map.put("dueDateEnd", endDateStr);
			list.add(map);
			startDateStr = endDateStr;
		}
		return list;
	}

	/**
	 * 获取startDate之后间隔为intervalDayNum的时间列表，结束日期为当前日期
	 * @param startDate 开始日期，格式如"2020-01-01"
	 * @param intervalDayNum 间隔的天数
	 * @return
	 */
	public static List<Map<String, String>> getDateStartAndEndList(String startDate, Integer intervalDayNum) {
		String nowDateStr = DateFormatUtils.format(new Date(), DateUtil.FORMAT_yyyy_MM_dd);
		return getDateStartAndEndList(startDate, nowDateStr, intervalDayNum);
	}

	/**
	 * 获取startDate之后间隔为intervalDayNum的时间列表，结束日期为endDate
	 * @param startDate 开始日期，格式如"2020-01-01"
	 * @param endDate 结束日期，格式如"2020-02-01"
	 * @param intervalDayNum 间隔的天数
	 * @return
	 */
	public static List<Map<String, String>> getDateStartAndEndList(String startDate, String endDate, Integer intervalDayNum) {
		if (intervalDayNum < 0) {
			throw new RuntimeException("intervalDayNum 不能小于0");
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String startDateStr = startDate;// 只统计此时间及之后的记录
		String nowDateStr = endDate;
		while (compare(nowDateStr, startDateStr) >= 0) {
			Integer tempIntervalDayNum = betweenDays(nowDateStr, startDateStr);
			tempIntervalDayNum = tempIntervalDayNum >= intervalDayNum ? intervalDayNum : tempIntervalDayNum;
			String endDateStr = getNumDayDate(startDateStr, tempIntervalDayNum);
			Map<String, String> map = new HashMap<String, String>();
			map.put("dateStart", startDateStr);
			map.put("dateEnd", endDateStr + " 23:59:59");
			list.add(map);
			startDateStr = getNumDayDate(endDateStr, 1);;
		}
		return list;
	}

	/**
	 * 获得当天之前间隔intervalDayNum天的日期列表
	 * @param intervalDayNum 间隔日期
	 * @param containNowDay 是否包含当天
	 * @return
	 */
	public static Map<String, String> getBeforeNowDay(Integer intervalDayNum, boolean containNowDay){
		if (intervalDayNum > 0) {
			intervalDayNum = intervalDayNum * -1;
		}
		String nowDateStr = DateFormatUtils.format(new Date(), DateUtil.FORMAT_yyyy_MM_dd);
		String endDate = containNowDay ? nowDateStr : getNumDayDate(nowDateStr, -1);
		String startDate = getNumDayDate(endDate, intervalDayNum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("dateStart", startDate);
		map.put("dateEnd", endDate + " 23:59:59");
		return map;
	}

}
