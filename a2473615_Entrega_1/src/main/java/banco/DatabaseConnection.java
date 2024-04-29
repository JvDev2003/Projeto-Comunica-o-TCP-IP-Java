package banco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnection {
	private static EntityManagerFactory emf;
	private static EntityManager entityManager;
	
	public static EntityManager getConnection() {
		if (entityManager == null) {
			emf = Persistence.createEntityManagerFactory("BancoLinkedin");
			entityManager = emf.createEntityManager();
		}
		
		return entityManager;
	}
}
