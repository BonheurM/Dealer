package dealerPD;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import dealerDAO.CarDAO;
import dealerDAO.SalesPersonDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@SuppressWarnings("unused")
@Entity(name = "dealer")
public class Dealer implements Serializable {
	private static final long serialVersionUID=1L; 
	@Id //signifies the primary key
    @Column(name = "dealer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long dealerID; 
	
	@Column(name = "name", nullable = false,length = 50)
  private String name;
	@Column(name = "address", nullable = true,length = 30)
  private String address;
	@Column(name = "city", nullable = true,length = 50)
  private String city;
	@Column(name = "state", nullable = true,length = 2)
  private String state;
	@Column(name = "zip", nullable = false,length = 10)
  private String zip;
	
	@OneToMany(mappedBy="dealer",targetEntity=Car.class,
			fetch=FetchType.EAGER)
  private Collection<Car> cars;
	
	@OneToMany(mappedBy="dealer",targetEntity=SalesPerson.class,
			fetch=FetchType.EAGER)
  private Collection<SalesPerson> salesPersons;
  
  public Dealer() {
	  System.out.println("Hello2?");
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getZip() {
    return zip;
  }
  public void setZip(String zip) {
    this.zip = zip;
  }
  public Collection<Car> getCars() {
    return cars;
  }
  
  public Collection<SalesPerson> getSalesPersons() {
    return salesPersons;
  }
  
  public void addCar(Car car) {
	  car.seteDealer(this);
    CarDAO.addCar(car);
  }
  
  public void removeCar(Car car)
  {
    CarDAO.removeCar(car);
  }
  
  public void addSalesPerson(SalesPerson salesPerson)
  
  {
	salesPerson.setDealer(this);
    SalesPersonDAO.addSalesPerson(salesPerson);
  }
  public void removeSalesPerson(SalesPerson salesPerson)
  
  {
    SalesPersonDAO.removeSalesPerson(salesPerson);
  }
  
  public int getCarForSaleCount() {
    int count = 0;
    if(getCars()==null)return count;
    for (Car car : getCars()) {
      if (car.getDateSold() == null) count =count+1;
    }
    return count;
     
  }
  
  public int getCarsSoldThisMonth() {
    int count = 0;
    if(getCars()==null)return count;
    for (Car car : getCars()) {
      if ((car.getDateSold().getMonth()== LocalDate.now().getMonth()) &&
              (car.getDateSold().getYear() == LocalDate.now().getYear())) count =count+1;
    }
    return count;
     
  }
  
  public String toString() {
    return "I am dealer";
  }
}