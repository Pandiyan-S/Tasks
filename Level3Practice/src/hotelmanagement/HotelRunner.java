package hotelmanagement;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelRunner
{
	public static void main(String[] args)
	{
		StorageLayer store = new StorageLayer();
		store.initialize();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		try {
			while (choice != 7) {
				System.out.println("Enter the operation to be performed");
				System.out.println("\n1. Print the hotel data.");
				System.out.println("\n2. Sort hotels by Name");
				System.out.println("\n3. Sort Hotel by highest rating");
				System.out.println("\n4. Print Hotel data for a Location");
				System.out.println("\n5. Sort hotels by maximum number of rooms Available");
				System.out.println("\n6. Print user Booking data");
				System.out.println("\n7. Exit");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Hotels data");
					for (Hotel h : store.getHotels()) {
						System.out.println(h.toString());
					}
					break;
				case 2:
					System.out.println("Sort by name");
					List<Hotel> list = store.getHotels();
					Collections.sort(list, new Comparator<Hotel>() {
						public int compare(Hotel h1, Hotel h2) {
							return h1.getName().compareTo(h2.getName());
						}
					});
					for (Hotel h : list) {
						System.out.println(h.toString());
					}
					break;
				case 3:
					System.out.println("Sort by rating");
					list = store.getHotels();
					Collections.sort(list, new Comparator<Hotel>() {
						public int compare(Hotel h1, Hotel h2) {
							return ((Integer) h2.getRating()).compareTo(h1.getRating());
						}
					});
					for (Hotel h : list) {
						System.out.println(h.toString());
					}
					break;
				case 4:
					System.out.println("Enter the location");
					sc.nextLine();
					String location = sc.nextLine();
					list = store.getHotels();
					for (Hotel h : list) {
						if (h.getLocation().equals(location)) {
							System.out.println(h.toString());
						}
					}
					break;
				case 5:
					System.out.println("Sort by rooms available");
					list = store.getHotels();
					Collections.sort(list, new Comparator<Hotel>() {
						public int compare(Hotel h1, Hotel h2) {
							return ((Integer) h2.getMaxRooms()).compareTo(h1.getMaxRooms());
						}
					});
					for (Hotel h : list) {
						System.out.println(h.toString());
					}
					break;
				case 6:
					System.out.println("User Booking data");
					List<UserBooking> book = store.getBookings();
					for (UserBooking h : book) {
						System.out.println(h.toString());
					}
				}
			} 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			sc.close();
		}
	}
}
