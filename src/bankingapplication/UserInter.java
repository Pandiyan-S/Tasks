package bankingapplication;

import check.UserException;

public interface UserInter
{

	public boolean signIn(int id, String password) throws UserException;

	public void changePassword(int id,String oldPassword, String newPassword) throws UserException;

	public void signOut(int id) throws UserException;
	
	public String userType(int id) throws UserException;

}