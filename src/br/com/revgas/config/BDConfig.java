package br.com.revgas.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class BDConfig {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {			
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bancos_db?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false", "root", "Admin123@");
	}
		
}
