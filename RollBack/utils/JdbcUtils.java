/**
 * 
 */
package com.xyd.dem04.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

/**
 * @author scott
 * @date 2018年1月8日上午10:27:20
 * @version
 * @description
 * 				jdbc的工具类的封装
 * 
 */
public class JdbcUtils {
	
	public static String ORALCEDRIVER = "";
	public static String URL = "";
	public static String USERNAME = "";
	public static String PASSWORD = "";

	// 静态代码块 来处理 (运行的时候 只 加载 一次 )
	static {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 1. 创建pro
		Properties pro = new Properties();
		// 2. 加载 pro文件
		try {
			pro.load(new BufferedReader(new FileReader(new File("src/jdbc.properties"))));

			// 通过key 获取 value
			ORALCEDRIVER = pro.getProperty("oralceDriver");
			URL = pro.getProperty("url");
			USERNAME = pro.getProperty("username");
			PASSWORD = pro.getProperty("password");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {

		// 方法的调用 不用每次 都加载 驱动

		try {
			// 用配置文件 来 配置 url username password
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 资源释放
	 */
	public static void close(ResultSet rs,Statement st,Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
