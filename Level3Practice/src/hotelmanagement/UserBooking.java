package hotelmanagement;

public class UserBooking
{
	String userName;
	int userId;
	String hotelName;
	int bookingCost;
	
	public UserBooking(String userName, int userId, String hotelName, int bookingCost)
	{
		this.userName = userName;
		this.userId = userId;
		this.hotelName = hotelName;
		this.bookingCost = bookingCost;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getHotelName()
	{
		return hotelName;
	}
	public void setHotelName(String hotelName)
	{
		this.hotelName = hotelName;
	}
	public int getBookingCost()
	{
		return bookingCost;
	}
	public void setBookingCost(int bookingCost)
	{
		this.bookingCost = bookingCost;
	}
	@Override
	public String toString()
	{
		return "\nUser Name = " + userName + "\nUser Id = " + userId + "\nHotel Name = " + hotelName
				+ "\nBooking Cost = " + bookingCost;
	}
}
