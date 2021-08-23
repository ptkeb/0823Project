package model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDB");
	public static EntityManager getEntitymanager() {
		return emf.createEntityManager();
	}
	
	public static void close()	{
		emf.close();
		emf = null;
	}
}
