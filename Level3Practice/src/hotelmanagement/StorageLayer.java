package hotelmanagement;

import java.util.ArrayList;
import java.util.List;

public class StorageLayer
{
	private List<Hotel> list = new ArrayList<>();
	private List<UserBooking> bookings = new ArrayList<>();
	public void initialize()
	{
		Hotel H1 = new Hotel("H1",4,"Bangalore",5,100);
		Hotel H2 = new Hotel("H2",5,"Bangalore",5,200);
		Hotel H3 = new Hotel("H3",6,"Bangalore",3,100);
		UserBooking book1 = new UserBooking("U1",2,"H1",1000);
		UserBooking book2 = new UserBooking("U2",3,"H2",1200);
		UserBooking book3 = new UserBooking("U3",4,"H3",1100);
		list.add(H1);
		list.add(H2);
		list.add(H3);
		bookings.add(book1);
		bookings.add(book2);
		bookings.add(book3);
	}
	public List<Hotel> getHotels()
	{
		return list;
	}
	public List<UserBooking> getBookings()
	{
		return bookings;
	}
}
