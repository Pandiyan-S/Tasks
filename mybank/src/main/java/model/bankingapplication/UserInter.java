package model.bankingapplication;


public interface UserInter
{

	public boolean signIn(int id, String password) throws UserException;

	public boolean changePassword(int id,String oldPassword, String newPassword) throws UserException;
	
	public String userType(int id) throws UserException;

}