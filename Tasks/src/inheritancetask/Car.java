package inheritancetask;

public class Car 
{
	private int yearOfMake;
	private String engineNumber;
	private String type;
	public Car(){}
	public Car(String str)
	{
		System.out.println("str");
	}
	public void setYearOfMake(int no)
	{
		yearOfMake = no;
	}
	public void setEngineNumber(String num)
	{
		engineNumber = num;
	}
	public void setType(String model)
	{
		type = model;
	}
	public int getYearOfMake()
	{
		return yearOfMake;
	}
	public String getEngineNumber()
	{
		return engineNumber;
	}
	public String getType()
	{
		return type;
	}
	public void maintenance()
	{
		System.out.println("Car under maintenance");
	}
}
