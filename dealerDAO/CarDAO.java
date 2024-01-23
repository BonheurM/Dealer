package dealerDAO;

import java.util.List;
import jakarta.persistence.*;
import dealerPD.Car;
public class CarDAO {

	public static void addCar(Car car)
	{
		emDAO.getEM().persist(car);
	}
		
	public static void saveCar(Car Car) {
		emDAO.getEM().persist(Car);
		
	}

	public static List<Car> listCar()
	{
		TypedQuery<Car> query = emDAO.getEM().createQuery(
				"SELECT Car FROM Car Car", Car.class);
		return query.getResultList();
	}

	public static Car findCarById(long id)
	{
		Car Car = emDAO.getEM().find(Car.class, id);
		return Car;
	}
	
	public static void removeCar(Car Car)
	{
		emDAO.getEM().remove(Car);
	}
}
