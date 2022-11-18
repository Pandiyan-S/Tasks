package pojopackage;

public class ThisIsPojo
{
	String str;
	int no;
	ThisIsPojo(){System.out.println("hi");}
	ThisIsPojo(String str,int num)
	{
		this.str = str;
		no = num;
		System.out.println("Hello");
	}
	public void setStr(String line)
	{
		str = line;
	}

	public void setNo(int num)
	{
		no = num;
	}
	public String getStr()
	{
		return str;
	}
	public int getNo()
	{
		return no;
	}
	@Override
	public String toString()
	{
		return (str + no);
	}
}
