package com.OuSoft.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringEscapeUtils;


public class CommUtil {
	
	
	
	public static String listForSqlIn(List<String> strlist){
		String str="''";
		for(int i=0;i<strlist.size();i++){
			str+=",'"+strlist.get(i)+"'";
		}
		return str;
	}
	
	
	public static String CreateToken(){
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		String timeString=format.format(date);
		String randomString=UUID.randomUUID().toString().replace("-","" ).substring(0, 18);
		return timeString+randomString;
	}
	
//	public static String  sql_killer(String sql){
//		return StringEscapeUtils.escapeSql(sql);
//	}
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
	
	public static String getTimeID() {
		String sd = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 18);
		return sd + uuid;
	}

	public static String classToJson(List list) throws ClassNotFoundException, IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String json = "{rows:[";
		// 对所有对象执行循环
		for (int i = 0; i < list.size(); i++) {
			Field[] fs = list.get(i).getClass().getDeclaredFields();
			PropertyDescriptor pd = new PropertyDescriptor("ID", list.get(i).getClass());
			Method method = pd.getReadMethod();
			Object retObj = method.invoke(list.get(i), fs);
			json = json + "{ id:" + retObj + ",data:[";
			
			//对每个字段执行循环
			for (int j = 0; j < fs.length; j++) {
				Class objClass = Class.forName(list.get(i).getClass().getName());
				pd = new PropertyDescriptor(fs[j].getName(), list.get(i).getClass());
				method = pd.getReadMethod();
				if (pd.getName() != "ID") {
					retObj = method.invoke(list.get(i), fs);
					if (j == fs.length - 1) {
						if (i==list.size()-1){
							json = json + "\"" + retObj + "\"]}]}";
						}else{
							json = json + "\"" + retObj + "\"]},";
						}
					} else {
						json = json + "\"" + retObj + "\",";
					}
				}

			}
		}
		return json;

	}
	
	public static void main(String args[]) throws IllegalArgumentException, IntrospectionException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, InvocationTargetException{

		System.out.println(getTimeID());
	}

}
