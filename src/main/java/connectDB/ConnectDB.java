package connectDB;

import java.sql.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	private static EntityManager em = null;

	public static void connect() {
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Whimsibook-MSSQL-Production");
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
