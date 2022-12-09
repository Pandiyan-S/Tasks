package foodorderingsystem;

import java.util.List;
import java.util.Map;

public class FoodLogic
{

	public boolean ifExist(String email)
	{
		FoodStorage store = new FoodStorage();
		return store.checkAccount(email);
	}
	public boolean confirmPassword(String email, String password)
	{
		FoodStorage store = new FoodStorage();
		return store.verifyPassword(email,password);
	}

	public void addCustomer(Customer cust)
	{
		FoodStorage store = new FoodStorage();
		store.addCustomer(cust);
	}
	
	public List<String> findHotel()
	{
		FoodStorage store = new FoodStorage();
		return store.findHotel();
	}
	public Map<String, Integer> getFood()
	{
		FoodStorage store = new FoodStorage();
		return store.getFood();
	}
	public Map<String, Integer> getHotelFood(String hotel)
	{
		FoodStorage store = new FoodStorage();
		return store.getHotelFood(hotel);
	}
}
