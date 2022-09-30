package pojopackage;

public class ThisIsPojo
{
	String str;
	int no;
	ThisIsPojo(){System.out.println("hi");}
	ThisIsPojo(String str,int n)
	{
		this.str = str;
		no = n;
		System.out.println("Hello");
	}
	public void setStr(String line)
	{
		str = line;
	}

	public void setNo(int n)
	{
		no = n;
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
