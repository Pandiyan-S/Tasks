package task5;

public class XUV extends Car
{
	private int seats;
	private int airbags;
	private String model;
	private String color;
	public XUV()
	{
		super("this is XUV");
	}
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
}
