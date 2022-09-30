package task8;

public class TruePOJO
{
	String str;
	int no;
	TruePOJO(){}
	TruePOJO(String str,int n)
	{
		this.str = str;
		no = n;
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
