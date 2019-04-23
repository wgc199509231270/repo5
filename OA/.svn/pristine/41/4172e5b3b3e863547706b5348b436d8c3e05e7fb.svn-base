package com.OuSoft.OA;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.OuSoft.system.entity.ResponseModel;
import com.OuSoft.system.entity.Tsuser;
import com.OuSoft.system.service.Tsuser.ITsuserService;


public class GenEntityTable {
	
	/**
	 * 这里是Oracle连接方法
	 *private static final String driver = "oracle.jdbc.driver.OracleDriver";
	 *private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 *private static final String uid = "system";
	 *private static final String pwd = "sys";
	 *这里是SQL Server连接方法
	 *private static final String url = "jdbc:sqlserver://localhost:1433;DateBaseName=数据库名";
	 *private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
	 *private static final String uid = "sa";
	 *private static final String pwd = "sa";
	 *
	 *
	 * 这里是MySQL连接方法
	 */
	
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String pwd="OuSoft2014";
	private static final String user="root";
	private static final String url = "jdbc:mysql://123.57.28.18:3306/OuSoftOAOnline?useUnicode=true&characterEncoding=utf8";
	private static String tablename = "att";// 表名
	
	private static String setpackage="com.OuSoft.OA.ccc";//你的实体类所在的包的位置
	private static String lastname = "/src/main/java/com/OuSoft/";
	private static Connection getConnection=null;
	
	public static void main(String[] args) {
		try {
			getConnection=getConnections();
			DatabaseMetaData dbmd=getConnection.getMetaData();
			ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
			while (resultSet.next()) {
				System.out.println("1111111111");
				String tableName=resultSet.getString("TABLE_NAME");
		    	if(tablename.equals(tableName)){
		    		String primaryKey = "";
		    		ResultSet primaryKeyResultSet = dbmd.getPrimaryKeys(null,null,tablename);  
		    		while(primaryKeyResultSet.next()){  
		    		    primaryKey = primaryKeyResultSet.getString("COLUMN_NAME");  
		    		} 
		    		System.out.println(primaryKey);
		    		System.out.println("执行");
		    		tableName = initcap(tablename);
		    		ResultSet rs1 = dbmd.getColumns(null, "%", tableName, "%");
		    		ResultSet rs2 = dbmd.getColumns(null, "%", tableName, "%");
		    		ResultSet rs4 = dbmd.getColumns(null, "%", tableName, "%");
		    		GenEntityTable(rs1, rs2, tableName); // 生成实体类
		    		GenEntityTables(primaryKey,tableName); // 生成 dao层内的tablename
		    		GenEntityTablesByXML(primaryKey,tableName,rs4); // 生成dao层内的xml
		    		GenEntityTablesByIService(primaryKey, tableName); // 生成service内的ItablenameService
		    		GenEntityTablesByService(primaryKey, tableName); // 生成service/impl内的tablename
		    		GenEntityTableController(primaryKey,tableName);
		    	}
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
	public static void GenEntityTableController(String primaryKey,String tablename) throws IOException, SQLException{
		File files = new File(""); // 设定为当前文件夹
		String path = "";
		path = files.getCanonicalPath()+lastname+"system/controller/"+tablename;
		System.out.println(path);
		File myfile = new File(path);
    	if(!myfile.exists()){
    		myfile.mkdir();//如果文件夹不存在，则创建一个
    	}
		File directory = new File(path+"\\"+ initcap(tablename)+"Controller.java");
		FileWriter fw = new FileWriter(directory);
		PrintWriter pw = new PrintWriter(fw);
		pw.write("package com.OuSoft.system.controller."+tablename+";\r\n");
		pw.write("\r\n");
		pw.write("\r\n");
		pw.write("import java.util.ArrayList;\r\n");
		pw.write("import java.util.List;\r\n");
		pw.write("\r\n");
		pw.write("import javax.servlet.http.HttpServletRequest;\r\n");
		pw.write("\r\n");
		pw.write("import org.apache.ibatis.annotations.Param;\r\n");
		pw.write("import org.springframework.beans.factory.annotation.Autowired;\r\n");
		pw.write("import org.springframework.stereotype.Controller;\r\n");
		pw.write("import org.springframework.web.bind.annotation.RequestBody;\r\n");
		pw.write("import org.springframework.web.bind.annotation.RequestMapping;\r\n");
		pw.write("import org.springframework.web.bind.annotation.ResponseBody;\r\n");
		pw.write("\r\n");
		pw.write("import com.OuSoft.system.entity.ResponseModel;\r\n");
		pw.write("import com.OuSoft.system.entity."+tablename+";\r\n");
		pw.write("import com.OuSoft.system.service."+tablename+".I"+tablename+"Service;\r\n");
		pw.write("\r\n");
		pw.write("@Controller\r\n");
		pw.write("public class "+tablename+"Controller {\r\n");
		pw.write("\r\n");
		pw.write("\t@Autowired\r\n");
		pw.write("\tHttpServletRequest request;\r\n");
		pw.write("\t@Autowired\r\n");
		pw.write("\tI"+tablename+"Service i"+tablename+"Service;\r\n");
		pw.write("\t@RequestMapping(value=\"/Query"+tablename+"List\")\r\n");
		pw.write("\t@ResponseBody\r\n");
		pw.write("\tpublic List<"+tablename+"> Query"+tablename+"List() {;\r\n");
		pw.write("\t\tList<"+tablename+"> list = new ArrayList<"+tablename+">();\r\n");
		pw.write("\t\tlist = i"+tablename+"Service.Query"+tablename+"List();\r\n");
		pw.write("\t\treturn list;\r\n");
		pw.write("\t}\r\n");
		
		pw.write("\t@RequestMapping(value=\"/Del"+tablename+"\")\r\n");
		pw.write("\t@ResponseBody\r\n");
		pw.write("\tpublic ResponseModel Del"+tablename+"(@Param(\""+primaryKey+"\") String "+primaryKey+") {\r\n");
		pw.write("\t\tResponseModel model = i"+tablename+"Service.Del"+tablename+"("+primaryKey+");\r\n");
		pw.write("\t\treturn model;\r\n");
		pw.write("\t}\r\n");
		pw.write("\r\n");
		pw.write("\t@RequestMapping(value=\"/Query"+tablename+"Byid\")\r\n");
		pw.write("\t@ResponseBody\r\n");
		pw.write("\tpublic "+tablename+" Query"+tablename+"Byid(@Param(\""+primaryKey+"\") String "+primaryKey+") {\r\n");
		pw.write("\t\t"+tablename+" model = i"+tablename+"Service.Query"+tablename+"Byid("+primaryKey+");\r\n");
		pw.write("\t\treturn model;\r\n");
		pw.write("\t}\r\n");
		pw.write("\r\n");
		pw.write("\t@RequestMapping(value=\"/Update"+tablename+"Byid\")\r\n");
		pw.write("\t@ResponseBody\r\n");
		pw.write("\tpublic ResponseModel Update"+tablename+"Byid(@RequestBody "+tablename+" model) {\r\n");
		pw.write("\t\tResponseModel remodel = i"+tablename+"Service.Update"+tablename+"Byid(model);\r\n");
		pw.write("\t\treturn remodel;\r\n");
		pw.write("\t}\r\n");
		pw.write("\r\n");
		pw.write("\t@RequestMapping(value=\"/Insert"+tablename+"\")\r\n");
		pw.write("\t@ResponseBody\r\n");
		pw.write("\tpublic ResponseModel Insert"+tablename+"(@RequestBody "+tablename+" model) {\r\n");
		pw.write("\t\tResponseModel remodel = i"+tablename+"Service.Insert"+tablename+"(model);\r\n");
		pw.write("\t\treturn remodel;\r\n");
		pw.write("\t}\r\n");
		pw.write("}\r\n");
		pw.flush();
		pw.close();
	}
	
	public static void GenEntityTables(String primaryKey,String tablename) throws IOException, SQLException{
//		String path = "com.OuSoft.system.dao.";
//		getConnection=getConnections();
//		DatabaseMetaData dbmd=getConnection.getMetaData();
		File files = new File(""); // 设定为当前文件夹
		String path = "";
		path = files.getCanonicalPath()+lastname+"system/dao/"+tablename;
		System.out.println(path);
		// 找到位置
		File myfile = new File(path);
    	if(!myfile.exists()){
    		myfile.mkdir();//如果文件夹不存在，则创建一个
    	}
//		File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//		String desktopPath = desktopDir.getAbsolutePath();
		File directory = new File(path+"\\"+ initcap(tablename)+"s.java");
		FileWriter fw = new FileWriter(directory);
		PrintWriter pw = new PrintWriter(fw);
		pw.write("package com.OuSoft.system.dao."+tablename+";\r\n");
		pw.write("import com.OuSoft.system.entity."+tablename+";\r\n");
		pw.write("import org.apache.ibatis.annotations.Mapper;\r\n");
		pw.write("import org.apache.ibatis.annotations.Param;\r\n");
		pw.write("import org.springframework.stereotype.Component;\r\n");
		pw.write("import com.OuSoft.system.entity.ResponseModel;\r\n");
		pw.write("import org.springframework.web.bind.annotation.RequestBody;\r\n");
		
		pw.write("import java.util.List;\r\n");
		pw.write("\r\n");
		pw.write("@Mapper\r\n");
		pw.write("@Component(value = \""+tablename+"\")\r\n");
		pw.write("public interface "+tablename+"s {\r\n");
		pw.write("\r\n");
		pw.write("\tList<"+tablename+"> Query"+tablename+"List();\r\n");
		pw.write("\r\n");
		pw.write("\tResponseModel Del"+tablename+"(@Param(\""+primaryKey+"\") String "+primaryKey+");\r\n");
		pw.write("\r\n");
		pw.write("\t"+tablename+" Query"+tablename+"Byid(@Param(\""+primaryKey+"\") String "+primaryKey+");\r\n");
		pw.write("\r\n");
		pw.write("\tResponseModel Update"+tablename+"Byid(@RequestBody "+tablename+" model);\r\n");
		pw.write("\r\n");
		pw.write("\tResponseModel Insert"+tablename+"(@RequestBody "+tablename+" model);\r\n");
		pw.write("\r\n");
		pw.write("}\r\n");
		pw.flush();
		pw.close();
	}
	

	public static void GenEntityTablesByXML(String primaryKey,String tablename,ResultSet rs1) throws IOException, SQLException{
		if(primaryKey==null){
			primaryKey = "id";
		}
		File files = new File(""); // 设定为当前文件夹
		String path = "";
		path = files.getCanonicalPath()+lastname+"system/dao/"+tablename;
		System.out.println(path);
		// 找到位置
		File myfile = new File(path);
    	if(!myfile.exists()){
    		myfile.mkdir();//如果文件夹不存在，则创建一个
    	}
//		String path = "com.OuSoft.system.dao.";
//		File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//		String desktopPath = desktopDir.getAbsolutePath();
		File directory = new File(path+"\\"+ initcap(tablename)+".xml");
		FileWriter fw = new FileWriter(directory);
		PrintWriter pw = new PrintWriter(fw);
		pw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		pw.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\r\n");
		pw.write("<mapper namespace=\"com.OuSoft.system.dao."+tablename+"."+tablename+"s\">\r\n");
		pw.write("\r\n");
		// querylist
		pw.write("\t<select id=\"Query"+tablename+"List\" resultType=\"com.OuSoft.system.entity."+tablename+"\">\r\n");
		pw.write("\t\tselect * from "+tablename+" where 1=1\r\n");
		pw.write("\t</select>\r\n");
		pw.write("\r\n");
		// del
		pw.write("\t<delete id=\"Del"+tablename+"\" parameterType=\"int\">\r\n");
		pw.write("\t\tDELETE FROM "+tablename+" where 1=1 AND "+primaryKey+"='${"+primaryKey+"}'\r\n");
		pw.write("\t</delete>\r\n");
		pw.write("\r\n");
		// querybyid
		pw.write("\t<select id=\"Query"+tablename+"Byid\" resultType=\"com.OuSoft.system.entity."+tablename+"\">\r\n");
		pw.write("\t\tselect * from "+tablename+" where 1=1 and "+primaryKey+"='${"+primaryKey+"}'\r\n");
		pw.write("\t</select>\r\n");
		pw.write("\r\n");
		// update
		pw.write("\t<update id=\"Update"+tablename+"Byid\" parameterType=\"com.OuSoft.system.entity."+tablename+"\">\r\n");
		pw.write("\t\tUpdate "+tablename+" \r\n");
		pw.write("\t\t<set> \r\n");
		String updatesql = "";
		String Insertsql = "";
		String insertsqls = "";
		Insertsql += "\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\r\n";
		insertsqls += "\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\r\n";
		while(rs1.next()){
			String name = rs1.getString("COLUMN_NAME");
			updatesql += "\t\t\t<if test=\""+name+" != null\">\r\n";
			updatesql += "\t\t\t\t"+name+"=#{"+name+"},\r\n";
			updatesql += "\t\t\t</if>\r\n";
//			updatesql += "\t\t\t"+name+"='${model."+name+"}',\r\n";
//			Insertsql += "'${model."+name+"}',";
			
			Insertsql += "\t\t\t<if test=\""+name+" != null\">\r\n";
			Insertsql += "\t\t\t\t"+name+",\r\n";
			Insertsql += "\t\t\t</if>\r\n";
			
			insertsqls += "\t\t\t<if test=\""+name+" != null\">\r\n";
			insertsqls += "\t\t\t\t\t#{"+name+"},\r\n";
			insertsqls += "\t\t\t</if>\r\n";
		}
		Insertsql +="\t\t</trim>\r\n";
		insertsqls +="\t\t</trim>\r\n";
//		updatesql += updatesql.substring(0,updatesql.length()-5)+"'\r\n";
//		Insertsql += Insertsql.substring(0,Insertsql.length());
		
		pw.write(updatesql);
		pw.write("\t\t</set>\r\n");
		pw.write("\t\twhere 1=1 and "+primaryKey+"='${"+primaryKey+"}'\r\n");
		pw.write("\t</update>\r\n");
		
		pw.write("\r\n");
		pw.write("\t<insert id=\"InsertTsuser\" parameterType=\"com.OuSoft.system.entity."+tablename+"\">\r\n");
//		pw.write("\tINSERT INTO "+tablename+" VALUES ("+Insertsql+")\r\n");
		pw.write(Insertsql);
		pw.write(insertsqls);
		pw.write("\t</insert>\r\n");
		pw.write("\r\n");
		pw.write("</mapper>\r\n");
		pw.flush();
		pw.close();
	}
	
	public static void GenEntityTablesByIService(String primaryKey,String tablename) throws IOException, SQLException{
		if(primaryKey==null){
			primaryKey = "id";
		}
//		String path = "com.OuSoft.system.service.";
		File files = new File(""); // 设定为当前文件夹
		String path = "";
		path = files.getCanonicalPath()+lastname+"system/service/"+tablename;
		System.out.println(path);
		// 找到位置
		File myfile = new File(path);
    	if(!myfile.exists()){
    		myfile.mkdir();//如果文件夹不存在，则创建一个
    	}
//		File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//		String desktopPath = desktopDir.getAbsolutePath();
		File directory = new File(path+"\\I"+ initcap(tablename)+"Service.java");
		FileWriter fw = new FileWriter(directory);
		PrintWriter pw = new PrintWriter(fw);
		pw.write("package com.OuSoft.system.service."+tablename+";\r\n");
		pw.write("import com.OuSoft.system.entity.ResponseModel;\r\n");
		pw.write("import org.apache.ibatis.annotations.Param;\r\n");
		pw.write("import java.util.List;\r\n");
		pw.write("import com.OuSoft.system.entity."+tablename+";\r\n");
		pw.write("import org.springframework.web.bind.annotation.RequestBody;\r\n");
		pw.write("\r\n");
		// querylist
		pw.write("public interface I"+tablename+"Service {\r\n");
		pw.write("\r\n");
		pw.write("\tList<"+tablename+"> Query"+tablename+"List();\r\n");
		pw.write("\r\n");
		pw.write("\tResponseModel Del"+tablename+"(@Param(\""+primaryKey+"\") String "+primaryKey+");\r\n");
		pw.write("\r\n");
		pw.write("\t"+tablename+" Query"+tablename+"Byid(@Param(\""+primaryKey+"\") String "+primaryKey+");\r\n");
		pw.write("\r\n");
		pw.write("\tResponseModel Update"+tablename+"Byid(@RequestBody "+tablename+" model);\r\n");
		pw.write("\r\n");
		pw.write("\tResponseModel Insert"+tablename+"(@RequestBody "+tablename+" model);\r\n");
		pw.write("\r\n");
		pw.write("}\r\n");
		
		pw.flush();
		pw.close();
	}
	
	public static void GenEntityTablesByService(String primaryKey,String tablename) throws IOException, SQLException{
		if(primaryKey==null){
			primaryKey = "id";
		}
		File files = new File(""); // 设定为当前文件夹
		String path = "";
		path = files.getCanonicalPath()+lastname+"system/service/"+tablename+"/impl/";
		System.out.println(path);
//		String path = "com.OuSoft.system.service.";
		// 找到位置
		File myfile = new File(path);
    	if(!myfile.exists()){
    		myfile.mkdir();//如果文件夹不存在，则创建一个
    	}
		// 准备写入
//		File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//		String desktopPath = desktopDir.getAbsolutePath();
    	
		File directory = new File(path+"\\"+ initcap(tablename)+"Service.java");
		FileWriter fw = new FileWriter(directory);
		PrintWriter pw = new PrintWriter(fw);
		pw.write("package com.OuSoft.system.service."+tablename+".impl;\r\n");
		pw.write("\r\n");
		pw.write("import com.OuSoft.system.dao."+tablename+"."+tablename+"s;\r\n");
		pw.write("import com.OuSoft.system.entity."+tablename+";\r\n");
		pw.write("import com.OuSoft.system.service."+tablename+".I"+tablename+"Service;\r\n");
		pw.write("import org.springframework.web.bind.annotation.RequestBody;\r\n");
		pw.write("import com.OuSoft.system.entity.ResponseModel;\r\n");
		pw.write("import java.util.List;\r\n");
		pw.write("import java.util.ArrayList;\r\n");
		
		pw.write("\r\n");
		// querylist
		pw.write("import org.apache.ibatis.annotations.Param;\r\n");
		pw.write("import org.springframework.beans.factory.annotation.Autowired;\r\n");
		pw.write("import org.springframework.stereotype.Service;\r\n");
		pw.write("\r\n");
		pw.write("@Service\r\n");
		pw.write("public class "+tablename+"Service implements I"+tablename+"Service {\r\n");
		pw.write("\r\n");
		pw.write("\t@Autowired\r\n");
		pw.write("\t"+tablename+"s "+UPcap(tablename)+";\r\n");
		pw.write("\t\r\n");
		
		pw.write("\t@Override\r\n");
		pw.write("\tpublic List<"+tablename+"> Query"+tablename+"List() {\r\n");
		pw.write("\t\tList<"+tablename+"> list = new ArrayList<"+tablename+">();\r\n");
		pw.write("\t\tlist = "+UPcap(tablename)+".Query"+tablename+"List();\r\n");
		pw.write("\t\treturn list;\r\n");
		pw.write("\t}\r\n");
		
		pw.write("\t@Override\r\n");
		pw.write("\tpublic ResponseModel Del"+tablename+"(@Param(\""+primaryKey+"\") String "+primaryKey+") {\r\n");
		pw.write("\t\tResponseModel model = new ResponseModel();\r\n");
		pw.write("\t\tmodel = "+UPcap(tablename)+".Del"+tablename+"("+primaryKey+");\r\n");
		pw.write("\t\treturn model;\r\n");
		pw.write("\t}\r\n");
		
		pw.write("\t@Override\r\n");
		pw.write("\tpublic ResponseModel Update"+tablename+"Byid(@RequestBody "+tablename+" model) {\r\n");
		pw.write("\t\tResponseModel remodel = new ResponseModel();\r\n");
		pw.write("\t\t"+UPcap(tablename)+".Update"+tablename+"Byid(model);\r\n"); // model = 
		pw.write("\t\treturn remodel;\r\n");
		pw.write("\t}\r\n");
		
		pw.write("\t@Override\r\n");
		pw.write("\tpublic "+tablename+" Query"+tablename+"Byid(@Param(\""+primaryKey+"\") String "+primaryKey+") {\r\n");
		pw.write("\t\t"+tablename+" model = new "+tablename+"();\r\n");
		pw.write("\t\tmodel = "+UPcap(tablename)+".Query"+tablename+"Byid("+primaryKey+");\r\n");
		pw.write("\t\treturn model;\r\n");
		pw.write("\t}\r\n");
		
		pw.write("\t@Override\r\n");
		pw.write("\tpublic ResponseModel Insert"+tablename+"(@RequestBody "+tablename+" model) {\r\n");
		pw.write("\t\tResponseModel remodel = new ResponseModel();\r\n");
		pw.write("\t\t "+UPcap(tablename)+".Insert"+tablename+"(model);\r\n"); // model = 
		pw.write("\t\treturn remodel;\r\n");
		pw.write("\t}\r\n");
		
		pw.write("}\r\n");
		pw.flush();
		pw.close();
	}
	
	public static String GenEntityTable(ResultSet rs1,ResultSet rs2,String tablename) throws IOException, SQLException{
		File files = new File(""); // 设定为当前文件夹
		String path = "";
		path = files.getCanonicalPath()+lastname+"system/entity/";
		System.out.println(path);
		// 找到位置
		File myfile = new File(path);
    	if(!myfile.exists()){
    		myfile.mkdir();//如果文件夹不存在，则创建一个
    	}
//		getConnection=getConnections();
//		try {
//			DatabaseMetaData dbmd=getConnection.getMetaData();
//		    ResultSet resultSet = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });
//		    while (resultSet.next()) {
//		    	String tableName=resultSet.getString("TABLE_NAME");
//		    	//System.out.println(tableName);
//		    	// 如果需要全部生成可以注掉这个IF
//		    	if(tablename.equals(tableName)){
//		    		//ResultSet rs =getConnection.getMetaData().getColumns(null, getXMLConfig.getSchema(),tableName.toUpperCase(), "%");//其他数据库不需要这个方法的，直接传null，这个是oracle和db2这么用
//		    		ResultSet rs1 = dbmd.getColumns(null, "%", tableName, "%");
//		    		ResultSet rs2 = dbmd.getColumns(null, "%", tableName, "%");
		    		File directory = new File(path+"\\"+ initcap(tablename)+".java");
					FileWriter fw = new FileWriter(directory);
					PrintWriter pw = new PrintWriter(fw);
//					if(setpackage==null || setpackage==""){
//						pw.write("package com.OuSoft.OA;\r\n");
//					}else{
					pw.write("package com.OuSoft.system.entity;\r\n");
//					}
					pw.write("\r\n");
					pw.write("   /**\r\n");
					pw.write("    * " + tablename + " 实体类\r\n");
					pw.write("    * " + getDate()+ " Lw\r\n");
					pw.write("    */ \r\n");
					pw.write("\r\npublic class " + initcap(tablename) + "{\r\n");
					System.out.println();
					System.out.println(tablename+"表信息：");
					System.out.println();
		    		while(rs1.next()){
		    			System.out.println("private " +sqlType2JavaType(rs1.getString("TYPE_NAME"))+"	"+rs1.getString("COLUMN_NAME")+";");
						if (directory.exists()) {
						} else {
							directory.createNewFile();
						}
//						rs1.getGeneratedKeys();
						String type = sqlType2JavaType(rs1.getString("TYPE_NAME"));
						String name = rs1.getString("COLUMN_NAME");
						String remark = rs1.getString("REMARKS");
						createPrtype(pw,type,name,remark);
		    		}
		    		//提供Get和Set方法
					pw.write("\r\n");
		    		while(rs2.next()){
		    			String name = rs2.getString("COLUMN_NAME");
		    			String type = rs2.getString("TYPE_NAME");
		    			createMethod(pw,type,name);
		    		}
		    		pw.write("}\r\n");
		    		
	    			pw.flush();
					pw.close();
					System.out.println();
					System.out.println();
					System.out.println("=====注意☆信息=====");
					System.out.println();
					if(setpackage==null || setpackage=="" ||setpackage.equals("com.OuSoft.OA.ccc")){
						System.out.println(" 生成成功、文件在你的桌面。但你没有设置你的实体类所在的包的位置，有可能package会出错！");
						System.out.println("找到私有属性“setpackage”来设置，默认为：com.OuSoft.OA.ccc;");
						System.out.println();
					}else{
						System.out.println("	生成成功！文件在你的桌面。");
						System.out.println();
					}
//		    	}
//		    }
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return "success";
	}
	
	/**生成属性*/
	public static void createPrtype(PrintWriter pw,String type,String name,String remark){
		if(remark!=null && !"".equals(remark)){
			pw.write("\t/**\r\n");
			pw.write("\t*"+remark+"\r\n");
			pw.write("\t*/\r\n");
		}else{
			pw.write("\t//"+name+"\r\n");
		}
		pw.write("\tprivate " +type+"	"+name+";\r\n");
	}
	
	/**生成方法*/
	public static void createMethod(PrintWriter pw,String type,String name){
		pw.write("\tpublic void set" + initcap(name) + "("+ sqlType2JavaType(type) + " " + name+ "){\r\n");
		pw.write("\t\tthis." + name + "=" + name + ";\r\n");
		pw.write("\t}\r\n");
		pw.write("\tpublic " + sqlType2JavaType(type) + " get"+ initcap(name) + "(){\r\n");
		pw.write("\t\treturn " + name + ";\r\n");
		pw.write("\t}\r\n");
		pw.write("\r\n");
	}
	
	
	// 创建数据库连接
	public static Connection getConnections() {
		try {
			Class.forName(driver);
			getConnection = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getConnection;
	}
 
	// 将单词字母首字母改为大写
	private static String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}
 
	private static String UPcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		return new String(ch);
	}
	
	// 判断属性类型
	public static String sqlType2JavaType(String sqlType) {
		String str = null;
		if (sqlType.equalsIgnoreCase("bit")) {
			str = "boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {
			str = "byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
			str = "short";
		} else if (sqlType.equalsIgnoreCase("int")) {
			str = "int";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
			str = "long";
		} else if (sqlType.equalsIgnoreCase("float")) {
			str = "float";
		} else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney")) {
			str = "double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text")) {
			str = "String";
		} else if (sqlType.equalsIgnoreCase("datetime")) {
			str = "String";
		} else if (sqlType.equalsIgnoreCase("image")) {
			str = "Blod";
		}
		return str;
	}
 
	// 获取格式化后的时间
	private static String getDate() {
		String time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time = sdf.format(new Date());
		return time;
	}

}
