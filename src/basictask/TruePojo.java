package basictask;

public class TruePojo
{
	String str;
	int no;
	TruePojo(){}
	TruePojo(String str,Integer n)
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
	public Integer getNo()
	{
		return no;
	}
	@Override
	public String toString()
	{
		return (str + no);
	}
}
