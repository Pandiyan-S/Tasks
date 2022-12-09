package onlinereservationsystem;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfo implements Serializable
{
	String userId;
	String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String useerId) {
		this.userId = useerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("User Id:");
		str.append( userId);
		str.append("\nPassword:");
		str.append( password);
		return str.toString();
	}
}
