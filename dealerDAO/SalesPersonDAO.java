package dealerDAO;

import java.util.List;
import jakarta.persistence.*;
import dealerPD.SalesPerson;
public class SalesPersonDAO {

	public static void addSalesPerson(SalesPerson SalesPerson)
	{
		emDAO.getEM().persist(SalesPerson);
	}
		
	public static void saveSalesPerson(SalesPerson SalesPerson) {
		emDAO.getEM().persist(SalesPerson);
		
	}

	public static List<SalesPerson> listSalesPerson()
	{
		TypedQuery<SalesPerson> query = emDAO.getEM().createQuery(
				"SELECT SalesPerson FROM SalesPerson SalesPerson", SalesPerson.class);
		return query.getResultList();
	}

	public static SalesPersonDAO findSalesPersonById(long id)
	{
		SalesPersonDAO SalesPerson = emDAO.getEM().find(SalesPersonDAO.class, id);
		return SalesPerson;
	}
	
	public static void removeSalesPerson(SalesPerson salesPerson)
	{
		emDAO.getEM().remove(salesPerson);
	}
}
