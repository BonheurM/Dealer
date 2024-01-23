package dealerDAO;

import java.util.List;
import jakarta.persistence.*;
import dealerPD.Dealer;
public class DealerDAO {

	public static void addDealer(Dealer Dealer)
	{
		emDAO.getEM().persist(Dealer);
	}
		
	public static void saveDealer(Dealer Dealer) {
		emDAO.getEM().persist(Dealer);
		
	}

	public static List<Dealer> listDealer()
	{
		TypedQuery<Dealer> query = emDAO.getEM().createQuery(
				"SELECT dealer FROM dealer dealer", Dealer.class);
		return query.getResultList();
	}

	public static Dealer findDealerById(long id)
	{
		Dealer Dealer = emDAO.getEM().find(Dealer.class, id);
		return Dealer;
	}
	
	public static void removeDealer(Dealer Dealer)
	{
		emDAO.getEM().remove(Dealer);
	}
}
