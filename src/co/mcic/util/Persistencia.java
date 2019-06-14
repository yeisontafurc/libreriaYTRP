package co.mcic.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistencia {
	private static final EntityManagerFactory emFactory;
	static {
		   emFactory = Persistence.createEntityManagerFactory("LibreriaYTRP");
	}
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	public static void close(){
		emFactory.close();
	}
}
