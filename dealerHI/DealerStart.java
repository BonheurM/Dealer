package dealerHI;

import java.util.List;

import dealerDAO.DealerDAO;
import dealerPD.Dealer;


public class DealerStart {

  public static void main(String[] args) {
    
	  Dealer dealer = null; 
	List<Dealer> listDealer = DealerDAO.listDealer();
	System.out.println(listDealer);
	System.out.println(listDealer.isEmpty());
	if(listDealer.isEmpty()) { 
		
		System.out.println("Hello?");
		dealer = new Dealer();
		System.out.println(dealer);
	}
		
	
	else dealer = listDealer.get(0);
	
	System.out.println(dealer);
    DealerFrame.open(dealer);

  }

}
