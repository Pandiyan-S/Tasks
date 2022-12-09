package foodorderingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FoodStorage
{
	private Map<String,Map<String,Integer>> dishes = new HashMap<>();
	private List<Customer> list = new ArrayList<>();
	
	public void initialize()
	{
		Map<String,Integer> price = new HashMap<>();
		price.put("Sandwich", 70);
		price.put("Pizza", 100);
		price.put("Noodles", 75);
		dishes.put("Aarya_Bhavan", price);
		price = new HashMap<>();
		price.put("Fried Rice", 95);
		price.put("Parotta", 15);
		price.put("Faloda", 35);
		dishes.put("Banu_Hotel", price);
		price = new HashMap<>();
		price.put("Chicken Rice", 80);
		price.put("Chicken Briyani", 90);
		price.put("Prawn", 120);
		dishes.put("SR_Bhavan", price);
	}

	public boolean checkAccount(String email)
	{
		for(Customer cust : list)
		{
			if(cust.getEmail().equals(email))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyPassword(String email, String password)
	{
		for(Customer cust : list)
		{
			if(cust.getEmail().equals(email))
			{
				if(cust.getPassword().equals(password))
				{
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public void addCustomer(Customer cust)
	{
		list.add(cust);
	}

	public List<String> findHotel()
	{
		List<String> keys = new ArrayList<>(dishes.keySet());
		return keys;
	}

	public Map<String, Integer> getFood()
	{
		Map<String,Integer> food = new HashMap<String,Integer>();
		for(Entry<String,Map<String,Integer>> hm : dishes.entrySet())
		{
			for(Entry<String,Integer> dish: hm.getValue().entrySet())
			{
				food.put(dish.getKey(), dish.getValue());
			}
		}
		return food;
	}

	public Map<String, Integer> getHotelFood(String hotel)
	{
		return dishes.get(hotel);
	}
}
