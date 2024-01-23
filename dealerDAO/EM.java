package dealerDAO;

	import jakarta.persistence.EntityManager;
	import jakarta.persistence.EntityManagerFactory;
	import jakarta.persistence.EntityTransaction;
	import jakarta.persistence.Persistence;

	public class EM {
	      
	      static EntityManagerFactory entityManagerFactory;
	      static EntityManager em;
	      
	      private static void initEM()
	      {
	entityManagerFactory 
	=  Persistence.createEntityManagerFactory("Dealer");
	        	em = entityManagerFactory.createEntityManager();
	      }
	      
	      public static EntityManager getEM()
	      {
	        if (em==null)
	        	 initEM();
	        return em;
	      }
	      
	      public static void close()
	      {
	        em.close();
	          entityManagerFactory.close();
	      }
	      
	      private EM() {}

	    }