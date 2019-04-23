package com.OuSoft.utils;

import java.io.*;
import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.net.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.OuSoft.system.entity.Tsuser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 时间格式封装类
 * @author pengyueli
 * @date 2018年9月13日
 */
public  class DateUtil {
	
	private static SimpleDateFormat smf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
	private static SimpleDateFormat smf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	private static SimpleDateFormat tasksmf = new SimpleDateFormat("ss mm HH dd MM ? yyyy");//设置定时器格式

	
	@Autowired
    HttpServletRequest request;
	
	/**
	 * test
	 * @author pyl
	 * @date 2018年12月26日
	 */
	public static void main(String[] args) {
//		//季度开始时间
//		System.out.println("quarter...季度开始时间: "+getCurrentQuarterStartTime());
//		//年开始时间
//		System.out.println("year...年开始时间: "+getCurrentYearStartTime());
//		//月开始时间
//		System.out.println("month...月开始时间: "+getCurrentMonthStartTime());
//		//周开始时间
//		System.out.println("weer周开始时间: "+getCurrentWeekDayStartTime());
//		//当前天数
//		System.out.println("当前天数: "+GetDateR());
		//保留两位小数，入
//		getDoubleFormat("3.7780989");
		//保留一位小数，不入
//		getDoubleFormats("3");
		
		
		
	}
	
	 // MD5加码。32位   
	 public static String GetJiamMD5(String inStr) {   
	  MessageDigest md5 = null;   
	  try {   
	   md5 = MessageDigest.getInstance("MD5");   
	  } catch (Exception e) {   
	   System.out.println(e.toString());   
	   e.printStackTrace();   
	   return "";   
	  }   
	  char[] charArray = inStr.toCharArray();   
	  byte[] byteArray = new byte[charArray.length];   
	  
	  for (int i = 0; i < charArray.length; i++)   
	   byteArray[i] = (byte) charArray[i];   
	  
	  byte[] md5Bytes = md5.digest(byteArray);   
	  
	  StringBuffer hexValue = new StringBuffer();   
	  
	  for (int i = 0; i < md5Bytes.length; i++) {   
	   int val = ((int) md5Bytes[i]) & 0xff;   
	   if (val < 16)   
	   hexValue.append("0");   
	   hexValue.append(Integer.toHexString(val));   
	  }   
	  
	  return hexValue.toString();   
	 }   
	  
	 // 可逆的加密算法   
	 public static String KL(String inStr) {   
	  // String s = new String(inStr);   
	  char[] a = inStr.toCharArray();   
	  for (int i = 0; i < a.length; i++) {   
	   a[i] = (char) (a[i] ^ 't');   
	  }   
	  String s = new String(a);   
	  return s;   
	 }   
	  
	 // 加密后解密   
	 public static String JMMD5(String inStr) {   
	  char[] a = inStr.toCharArray();   
	  for (int i = 0; i < a.length; i++) {   
	   a[i] = (char) (a[i] ^ 't');   
	  }   
	  String k = new String(a);   
	  return k;   
	 }   
	    
	
	/**
	 * MD5加密
	 * @author pyl
	 * @date 2018年12月24日
	 */
	public static String GetMD5(String plainText){
		String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
 
            re_md5 = buf.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
	}
	
	/**
	 * 将数据存在session中
	 * @author pyl
	 * @date 2018年10月31日
	 */
	public static void setSession(HttpServletRequest request, String userid, String token){
		if(userid != null && !"".equals(userid) && token != null && !"".equals(token)){
			request.getSession().setAttribute("token", token);
			request.getSession().setAttribute("userid", userid);
			//将用户id,token存在session中
	    	System.out.println("用户1--===============：" + request.getSession().getAttribute("token"));
	    	System.out.println("用户2--===============：" + request.getSession().getAttribute("token"));
    	
		}else{
			System.out.println("dateutil数据为空！");
		}
	}
	
	/**
	 * @author tiger
	 * @date 2012-9-15 上午08:45:46
	 * @return String
	 * @Description: 生成不带-的GUID
	 */
	public static String getID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	public static String GetDate() {
		String str = "";
		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;//0代表1月，最大为11月
//		int day1=cal.get(Calendar.DATE);
//		int hour=cal.get(Calendar.HOUR);
//		int min=cal.get(Calendar.MINUTE);
//		int sec=cal.get(Calendar.SECOND);
//		System.out.println(year+"年"+month+"月"+day1+"日"+""+hour+":"+min+":"+sec);
//		str = year+"/"+month+"/"+day1+" "+""+hour+":"+min+":"+sec;
//		System.out.println(str);
		
		cal.set(cal.get(Calendar.YEAR), month,cal.getActualMinimum(Calendar.DAY_OF_MONTH), 00, 00, 00);
		String begintimes = smf.format(cal.getTime());
		String begintimet = begintimes.substring(0,10);
		long begintime = cal.getTimeInMillis();
		System.out.println(begintimes + " , " + begintimet + " , " + begintime);
		return str;
	}
	/**
	 * 获取年月日  : 2018/08/13 
	 * @author pyl
	 * @date 2018年9月13日
	 */
	public static String GetDateR(){
		   String date = smf.format(new Date());
		   String str = date.substring(0,10);
		   System.out.println(str);// new Date()为获取当前系统时间
		return str;
		
	}
	/**
	 * 获取当前年月日时分秒 : 2018/08/13 11:52:25
	 * @author pyl
	 * @date 2018年9月13日
	 */
	public static String GetDates(){
		   String date = smf.format(new Date());
		   System.out.println(date);// new Date()为获取当前系统时间
		return date;
	}
	/**
	 * 获取当前年月日时分秒 : 2018-08-13 11:52:25
	 * @author mcc
	 * @date 2019年4月9日
	 */
	public static String GetDates2(){
		String date = smf2.format(new Date());
		System.out.println(date);// new Date()为获取当前系统时间
		return date;
	}
	
	/**
	 * 日期：String转换成date类型
	 * @author pyl
	 * @date 2018年12月27日
	 */
	public static Date GetStringToDate(String time) throws ParseException{
//		time = "2018/12/27 00:00:00";
		return smf.parse(time);
	}
	
	
	/**
	 * 日期：String转换成timesartmp类型
	 * @author pyl
	 * @date 2018年12月27日
	 */
	public static Date GetStringToTimestamp(String time) throws ParseException{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		String tsStr = "2011-05-09 11:49:45";  
        try {  
            ts = Timestamp.valueOf(time);  
            System.out.println(ts);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		return ts;
	}
	
	
	
	
	
	
	/**
	 * 获取年月日时分  2018/08/13 11:52
	 * @author pyl
	 * @date 2018年9月13日
	 */
	public static String GetDateF(){
		   String date = smf.format(new Date());
		   String str = date.substring(0,16);
		   System.out.println(str);// new Date()为获取当前系统时间
		   return str;
	}
	
	/**
	 * 获取当前时间前一个月的年月日时分秒：2018/08/13 11:52:25
	 * @author pyl
	 * @date 2018年9月13日
	 */
	public static String GetDateGY(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String str = smf.format(m);
        System.out.println(str);
		return str;
	}

	/**
	 * 获取当前时间前三个月 月初的年月日时分秒：2018/08/13 11:52:25
	 * @author pyl
	 * @date 2018年9月13日
	 */
	public static String GetDateGY3(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -3);
		c.set(Calendar.DAY_OF_MONTH,1);
		Date m = c.getTime();

		String str = smf.format(m);
			str = str.substring(0,10);
		System.out.println(str);
		return str;
	}

	/**
	 * 获取当前时间前一年的年月日时分秒：2017/09/13 11:55:40
	 * @author pyl
	 * @date 2018年9月13日
	 */
	public static String GetDateGN(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date m = c.getTime();
        String str = smf.format(m);
        System.out.println(str);
		return str;
	}

	/**
	 * 用户id
	 * @author pyl
	 * @date 2018年9月21日
	 */
	public static String GetId(){
		HttpServletRequest request = (HttpServletRequest) ServletActionContext.getRequest();
		//获取session  
		HttpSession session = request.getSession();    
		// 获取session中所有的键值  
		Enumeration<String> attrs = session.getAttributeNames();  
		// 遍历attrs中的
		while(attrs.hasMoreElements()){
		// 获取session键值  
	    String name = attrs.nextElement().toString();
	    // 根据键值取session中的值  
	    Object vakue = session.getAttribute(name);
	    // 打印结果 
	    System.out.println("------" + name + ":" + vakue +"--------\n");}
		String n = "11";
		return n;
	}
	
	/**
	 * 获取客户端ip地址
	 * @author pyl
	 * @date 2018年10月17日
	 */
	public static String queryIpAddress(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            //如果ip是   0:0:0:0:0:0:0:1  表示用localhost登录
            if(ip.equals("127.0.0.1")||ip.equals("0:0:0:0:0:0:0:1")){
            	//根据网卡取本机配置的IP    
            	InetAddress inet=null;
            	try {
            		inet = InetAddress.getLocalHost();
            	} catch (UnknownHostException e) {
            		e.printStackTrace();
            	}
            	ip= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割    
        if(ip!=null && ip.length()>15){ //"***.***.***.***".length() = 15    
        	if(ip.indexOf(",")>0){
        		ip = ip.substring(0,ip.indexOf(","));
        	}
        }
        return ip; 
	}

	/**
	 * response
	 * @author pyl
	 * @date 2018年9月21日
	 */
	 public HttpServletResponse GetResponse(){
		 
//		 HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
//		            .get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		 
		  HttpServletResponse response = ServletActionContext.getResponse();
		 return response;
	 }
	 
	 /**
		 * 获取request
		 * @author pyl
		 * @date 2018年9月21日
		 */
		public static HttpServletRequest getRequest() {
//			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//			HttpServletRequest request = (HttpServletRequest) ServletActionContext.getRequest();
			
//			HttpServletRequest request2 = (HttpServletRequest) ActionContext.getContext()
//					.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
			
			HttpServletRequest request = ServletActionContext.getRequest();
			    
			return request;
	 
		}
	 
	/**
	 * Getsession
	 * @author pyl
	 * @date 2018年9月21日
	 */
	public static HttpSession getSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session;
	}
 
	/**
	 *  id
	 * @author pyl
	 * @date 2018年9月21日
	 */
//	public static String GetUserIds(HttpServletRequest request){
//		 userid = (String) request.getSession().getAttribute("userid");
//		userid = queryCookieUserid(request);
//		 System.out.println(" 1.userid = " + userid);
//		 System.out.println(" 2.GetUserId()方法：  " +  GetUserId());
		 
//		return userid;
//	}
	
	/**
	 * userid
	 * @author pyl
	 * @date 2018年11月28日
	 */
	public static String queryCookieUserid(HttpServletRequest request){
		String fyuserid = "";
		Cookie[] coo = request.getCookies();
		if(coo != null){
			for (Cookie cookie : coo) {
				if(cookie.getName().equals("fyuserid")){
					fyuserid = cookie.getValue();
				}
			}
		}else{
			fyuserid = null;
		}
		return fyuserid;
	}

	public static String format(Date date, String string) {
		System.out.println("1: "+ date + " 2: " + string);
		SimpleDateFormat sdf = new SimpleDateFormat(string);
		sdf.format(date);
		return sdf.format(date);
	}
	
	/**
	 * 
	 * @author pyl
	 * 参数：
	 * 	pageNum:第几页
	 * 	pageSize：一页多少条数据
	 *  datas:数据源（list）
	 * 响应：
	 * 	pageNum:当前页数
	 * 	pageSize:页条数
	 * 	pages:总页数
	 * @param <T>
	 * @date 2018年10月24日
	 */
	public static <T> List<T> getpageHelper(int pageNum, int pageSize, List<T> lists , T t){
		
		PageHelper.startPage(pageNum, pageSize, true);
		
		PageInfo<T> pageinfo = new PageInfo<T>(lists);
		
		List<T> pageList = pageinfo.getList();
		
	
		int pagenum = pageinfo.getPageNum();
		int pagesize = pageinfo.getPageSize();
		int pages = pageinfo.getPages();
		
		System.out.println("-page-: " + pagenum +" :  " + pagesize +" :  " + pages);
		
		return pageList;
	}
	
	//判断字符串是否为空
	public static boolean isNullOrEmpty(String str){
		return null == str || str.equals("") || str.equals("null");
	}
	
	/**
	 * 格式化字符串,避免出现null,将null转换为""
	 * 
	 * @param s
	 *            需要格式化的字符串
	 * @return 格式化后的字符串
	 */
	public static String normalizeString(String s) {
		return ((s == null) ? "" : s.trim());
	}
	
	/**
	 * 查看是否都有值
	 * 有一个没有就会返回空
	 * @author pyl
	 * @date 2018年10月30日
	 */
	public static String  QueryParamisNullOrEmpty(String strparams) {
		String params = "";
		try {
			String[] str = strparams.split(",");
			for (String param : str) {
				if(DateUtil.isNullOrEmpty(param)){
					params += param+",";
				}
			}
		} catch (Exception e) {
			params = "exception";
		}
		return params;
	}
	
	
	 /**
     * 获取服务器IP地址
     * @return
     */
    public static String getServerIp(){
    	 String ip = "";
    	  try {
              InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址
              System.out.println(address);//PC-20140317PXKX/192.168.0.121
              ip = address.getHostAddress();
              System.out.println("ip:" + ip);//192.168.0.121
//              System.out.println("===============");
              //InetAddress address1=InetAddress.getByName("www.wodexiangce.cn");//获取的是该网站的ip地址，比如我们所有的请求都通过nginx的，所以这里获取到的其实是nginx服务器的IP地址
              //System.out.println(address1);//www.wodexiangce.cn/124.237.121.122
              //System.out.println(address1.getHostAddress());//124.237.121.122
//             System.out.println("===============");
             //InetAddress[] addresses=InetAddress.getAllByName("www.baidu.com");//根据主机名返回其可能的所有InetAddress对象
//             for(InetAddress addr:addresses){
//                 System.out.println(addr);//www.baidu.com/14.215.177.38
//                                         //www.baidu.com/14.215.177.37
//             }
         } catch (UnknownHostException e) {
             e.printStackTrace();
         }
    	  return ip;
    }
	
    /**
     * 获取userid
     * @author pyl
     * @date 2018年11月29日
     */
    public static String getUserid(){
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	return (String) request.getSession().getAttribute("userid");
    }
    
    /**
     * 获取token
     * @author pyl
     * @date 2018年11月29日
     */
    public static String getToken(){
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	return (String) request.getSession().getAttribute("token");
    }
    
    /**
     * 用户个人信息
     * @author pyl
     * @date 2018年12月11日
     */
    public static Tsuser GetTsuser(){
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    	Tsuser tsuser = new Tsuser();
    	tsuser = (Tsuser) request.getSession().getAttribute("tsuser");
    	return tsuser;
    }
    
	
    
// -----------------   获取 周，月，季，年的第一天时间，------------------------    
    
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat longHourSdf = new SimpleDateFormat("yyyy-MM-dd HH");
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat shortSdf2 = new SimpleDateFormat("yyyy/MM/dd");
    
    /**
     * 获得本周的第一天，周一
     *
     * @return
     */
    public static String getCurrentWeekDayStartTime() {
        Calendar c = Calendar.getInstance();
        try {
            int weekday = c.get(Calendar.DAY_OF_WEEK) - 2;
            c.add(Calendar.DATE, -weekday);
            c.setTime(longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smf.format(c.getTime()).substring(0,10);
    }
    
    
    /**
     * 获得本月的开始时间
     *
     * @return
     */
    public static String getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smf.format(now).substring(0,10);
    }

    /**
     * 当前年的开始时间,年月日
     *
     * @return
     */
    public static String getCurrentYearStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.MONTH, 0);
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smf.format(now).substring(0,10);
    }

    
    
    /**
     * 当前季度的开始时间.年月日
     *
     * @return
     */
    public static String getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smf.format(now).substring(0,10);
    }

	/**
	 * 获取当前周日期
	 * @return
	 */
    public static String getCurrentSundayPeriod(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		String imptimeBegin = shortSdf2.format(cal.getTime());
		// System.out.println("所在周星期一的日期：" + imptimeBegin);
		cal.add(Calendar.DATE, 6);
		String imptimeEnd = shortSdf2.format(cal.getTime());
		// System.out.println("所在周星期日的日期：" + imptimeEnd);
		return imptimeBegin + "," + imptimeEnd;
	}
	/**
	 * 获取当前月日期
	 * @return
	 */
	public static String getCurrentMonthPeriod(){
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date());
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		String firstday = shortSdf2.format(cale.getTime());
		// 获取前月的最后一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		String lastday = shortSdf2.format(cale.getTime());
		return firstday+","+lastday;
	}
	/**
	 * 获取当前年日期
	 * @return
	 */
	public static String getCurrentYearPeriod(){
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date());
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.add(Calendar.YEAR, 0);
		cale.set(Calendar.DAY_OF_YEAR, 1);
		String firstday = shortSdf2.format(cale.getTime());
		// 获取前月的最后一天
		cale = Calendar.getInstance();
		cale.add(Calendar.YEAR, 1);
		cale.set(Calendar.DAY_OF_YEAR, 0);
		String lastday = shortSdf2.format(cale.getTime());
		return firstday+","+lastday;
	}

	/**
	 * 获取所选日期周一到周日
	 * @param dataStr
	 * @return
	 * @throws ParseException
	 */
	public static String getFirstAndLastOfWeek(String dataStr) throws ParseException {
		Calendar cal = Calendar.getInstance();

		cal.setTime(new SimpleDateFormat("yyyy/MM/dd").parse(dataStr));

		int d = 0;
		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
			d = -6;
		} else {
			d = 2 - cal.get(Calendar.DAY_OF_WEEK);
		}
		cal.add(Calendar.DAY_OF_WEEK, d);
		// 所在周开始日期
		String data1 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
		cal.add(Calendar.DAY_OF_WEEK, 6);
		// 所在周结束日期
		String data2 = new SimpleDateFormat("yyyy/MM/dd").format(cal.getTime());
		return data1 + "," + data2;

	}
    /**
     * 接收： Stirng
     * 保留两位小数，四舍五入
     * @author pyl
     * @date 2019年2月27日
     */
    public static String getDoubleFormat(String value) {
    	 DecimalFormat df = new DecimalFormat("#0.00");
    	System.out.println("保留两位小数，入：  " + df.format(Double.valueOf(value)));
    	String st=df.format(Double.valueOf(value));
    	return st;
   }

    
    
    

    /**
     * 接收：int
     * 保留一位小数，不四舍五入
     * @author pyl
     * @date 2019年2月27日
     */
	public static String getDoubleFormats (double value){
		final DecimalFormat formater = new DecimalFormat();
		formater.setMaximumFractionDigits(1);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);
		System.out.println("保留一位小数，不入"+formater.format(value));
		String result = formater.format(value);
		return result;
	}
	
    
    /**
     * 判断对象是否为空，为空则返回true，不为空返回false
     * !getObjCheckIsNull(user)
     * 备注：如果实体类中有boolean 属性，则受boolean的影响，会返回有值（false）的信息
     * 	        如果实体类中有序列化，序列化是有值的，会返回有值（false)的信息
     * @author pyl
     * @date 2019年2月28日
     */
	public static boolean getObjCheckIsNull(Object object){
		@SuppressWarnings("rawtypes")
		Class clazz = (Class)object.getClass(); // 得到类对象
		Field fields[] = clazz.getDeclaredFields(); // 得到所有属性
		boolean flag = true; //定义返回结果，默认为true
		for(Field field : fields){
			field.setAccessible(true);
			Object fieldValue = null;
			try {
				fieldValue = field.get(object); //得到属性值
//				Type fieldType =field.getGenericType();//得到属性类型
//				String fieldName = field.getName(); // 得到属性名
//				System.out.println("属性类型："+fieldType+",属性名："+fieldName+",属性值："+fieldValue);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if(fieldValue != null){  //只要有一个属性值不为null 就返回false 表示对象不为null
				flag = false;
				break;
			}
		}
		System.out.println("     此对象为：              " +   flag);
		return flag;
	}
	
	/***
	 * 检查一个字符串是否是正整数
	 */
	public static boolean isNumeric(String number)
	{
		if (isNullOrEmpty(number)) return false;

		for (int i = 0; i < number.length(); i++)
		{
			char c = number.charAt(i);
			if (Character.isDigit(c)) continue;
			return false;
		}

		return (number.length() <= 11);
	}
	
	/***
	 * 检查一个字符串是否是正长整数
	 */
	public static boolean isLong(String number)
	{
		if (isNullOrEmpty(number)) return false;

		for (int i = 0; i < number.length(); i++)
		{
			char c = number.charAt(i);
			if (Character.isDigit(c)) continue;
			return false;
		}

		return (number.length() <= 19);
	}
	
	/***
	 * 检查一个字符串是否是整数
	 */
	public static boolean isInteger(String number)
	{
		if (isNullOrEmpty(number)) return false;

		int i=0;
		if(number.charAt(i)=='-')
		{
			i++;
		}
		
		for (; i < number.length(); i++)
		{
			char c = number.charAt(i);
			if (Character.isDigit(c)) continue;
			return false;
		}

		return (number.length() <= 11);
	}

	/***
	 * 检查一个字符串是否是浮点数
	 */
	public static boolean isFloatNumber(String str)
	{
		if (isNullOrEmpty(str)) return false;
		int count = 0;
		int i=0;
		if(str.charAt(i)=='-')
		{
			i++;
		}
		for (; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if (c == '.') count++;
			else if (!Character.isDigit(c)) return false;
		}

		return count <= 1;
	}

	/**
	 * 设置定时器时间格式
	 * @param data
	 * @return
	 */
    public static String getTasks(Date data){
		return tasksmf.format(data);
	}


	/**
	 * 读取所有内容
	 *
	 * @param rd
	 * @return
	 * @throws IOException
	 */
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	/**
	 * 拉取网页所有内容，并转化为Json格式
	 *
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static String getAddress(String ip0) {
		String ip = ip0;
		// 这个网址似乎不能了用了
		// String chinaz = "http://ip.chinaz.com";
		// 改用了太平洋的一个网址
		String chinaz = "http://whois.pconline.com.cn/";

		StringBuilder inputLine = new StringBuilder();
		String read = "";
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedReader in = null;
		try {
			url = new URL(chinaz);
			urlConnection = (HttpURLConnection) url.openConnection();
			// 如有乱码的，请修改相应的编码集，这里是 gbk
			in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "gbk"));
			while ((read = in.readLine()) != null) {
				inputLine.append(read + "\r\n");
			}
			// System.out.println(inputLine.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 这个是之前的正则表达式,
		// Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
		// 通过正则表达式匹配我们想要的内容，根据拉取的网页内容不同，正则表达式作相应的改变
		Pattern p = Pattern.compile("显示IP地址为(.*?)的位置信息");
		Matcher m = p.matcher(inputLine.toString());
		if (m.find()) {
			String ipstr = m.group(0);
			// 这里根据具体情况，来截取想要的内容
			ip = ipstr.substring(ipstr.indexOf("为") + 2, ipstr.indexOf("的") - 1);
			System.out.println(ip);
		}
		JSONObject json = null;
		String city = null;
		try {
			// 这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
			json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=" + ip);
			System.out.println(json);
			city = (((JSONObject) json.get("content")).get("address")).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}

}
