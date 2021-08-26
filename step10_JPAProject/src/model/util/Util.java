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
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close()	{
		emf.close();
		emf = null;
	}
}