package onlinereservationsystem;

import java.io.Serializable;

public class PassengerInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	String pnr;
	String name;
	int age;
	String idNo;
	char sex;
	String coachClass;
	String berth;
	int seatNo;
	String trainNo;
	String trainName;
	String from;
	String to;
	String doj;
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdNo()
	{
		return idNo;
	}
	public void setIdNo(String idNo)
	{
		this.idNo = idNo;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public char getSex()
	{
		return sex;
	}
	public void setSex(char sex)
	{
		this.sex = sex;
	}
	public String getCoachClass()
	{
		return coachClass;
	}
	public void setCoachClass(String coachClass)
	{
		this.coachClass = coachClass;
	}
	public String getBerth()
	{
		return berth;
	}
	public void setBerth(String berth)
	{
		this.berth = berth;
	}
	public int getSeatNo()
	{
		return seatNo;
	}
	public void setSeatNo(int seatNo)
	{
		this.seatNo = seatNo;
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
		StringBuilder str = new StringBuilder();//0156132649
		str.append("\nPNR:");
		str.append( pnr);
		str.append("\nName:");
		str.append( name);
		str.append("\nAge:");
		str.append(age);
		str.append("\nSex:");
		str.append(sex);
		str.append("\nId No:");
		str.append(idNo);
		str.append("\nBerth:");
		str.append( berth);
		str.append("\nSeat No:");
		str.append(seatNo);
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
