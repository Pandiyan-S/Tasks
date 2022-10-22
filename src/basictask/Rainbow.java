package basictask;

public enum Rainbow
{
	VIOLET (1),
	INDIGO (2),
	BLUE (3),
	GREEN (4),
	YELLOW (5),
	ORANGE (6),
	RED (7);
	private final int sNo;
	Rainbow(int sNo)
	{
		this.sNo = sNo;
	}
	public Integer getSno()
	{
		return sNo;
	}
	
}
