package model.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	//entity manager
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close()	{
		emf.close();
		emf = null;
	}
	
	//sql properties
	private static Properties dbInfo = new Properties();
	private static Properties sql = new Properties();
	
	static {
		try {
			dbInfo.load(new FileInputStream("db.properties"));
			sql.load(new FileInputStream("librarysql.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getSql() {
		return sql;
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbInfo.getProperty("jdbc.url"), 
				   						   dbInfo.getProperty("jdbc.id"), 
				   						   dbInfo.getProperty("jdbc.pw"));
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
}
