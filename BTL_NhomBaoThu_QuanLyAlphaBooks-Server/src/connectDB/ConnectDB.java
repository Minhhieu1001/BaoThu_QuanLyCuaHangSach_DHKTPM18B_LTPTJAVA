package connectDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	private static EntityManager em = null;

	public static void connect() {
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlphaBooks-MariaDB-Production");
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectDB getInstance() {
		return instance;
	}
	
	public static EntityManager getEntityManager() {
		if (em.getTransaction().isActive())
			em.getTransaction().commit();
		return em;
	}

	@Deprecated
	public static Connection getConnection() {
		return null;
	}
	
	@Deprecated
	public static void closeConnection() {
	}
}
