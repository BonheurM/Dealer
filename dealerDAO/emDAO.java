package dealerDAO;
import jakarta.persistence.*;

// entity manger 
public class emDAO {
		
		static EntityManagerFactory entityManagerFactory;
		static EntityManager em;
		
		public static void initEM()
		{
		entityManagerFactory =  Persistence.createEntityManagerFactory("Dealer");
	    em = entityManagerFactory.createEntityManager();
		}
		
		public static EntityManager getEM()
		{
			if (em==null)
			{ 
				initEM();
			
			}
			return em;
		}
		
		public static void close()
		{
			em.close();
		    entityManagerFactory.close();
		}

	}

