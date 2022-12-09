package onlinereservationsystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Train implements Serializable
{
	String pnr;
	String trainNo;
	String trainName;
	String from;
	String to;
	String doj;
	public String getPnr()
	{
		return pnr;
	}
	public void setPnr(String pnr)
	{
		this.pnr = pnr;
	}
	public String getTrainNo()
	{
		return trainNo;
	}
	public void setTrainNo(String trainNo)
	{
		this.trainNo = trainNo;
	}
	public String getTrainName()
	{
		return trainName;
	}
	public void setTrainName(String trainName)
	{
		this.trainName = trainName;
	}
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	public String getDoj()
	{
		return doj;
	}
	public void setDoj(String doj)
	{
		this.doj = doj;
	}
	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("PNR:");
		str.append( pnr);
		str.append("\nTrain No:");
		str.append( trainNo);
		str.append("\nTrain Name:");
		str.append( trainName);
		str.append("\nFrom:");
		str.append(from);
		str.append("\nTo:");
		str.append(to);
		str.append("\nDOJ:");
		str.append(doj);
		return str.toString();
	}
}
