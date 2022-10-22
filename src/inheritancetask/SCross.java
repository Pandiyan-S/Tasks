package inheritancetask;

public class SCross extends Car
{
	private int seats;
	private int airbags;
	private String model;
	private String color;
	public void setSeats(int no)
	{
		seats = no;
	}
	public void setAirbags(int no)
	{
		airbags = no;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public void setColor(String col)
	{
		color = col;
	}
	public int getSeats()
	{
		return seats;
	}
	public int getAirbags()
	{
		return airbags;
	}
	public String getModel()
	{
		return model;
	}
	public String getColor()
	{
		return color;
	}
	public void maintenance()
	{
		System.out.println("Maruti SCross under maintenance");
	}
}
