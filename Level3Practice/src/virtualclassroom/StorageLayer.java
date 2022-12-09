package virtualclassroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import check.UserException;


public class StorageLayer
{
	private static Connection connector()
	{
		String url = "jdbc:mysql://localhost:3306/virtualclassroom";
		String userName = "Task10";
		String password = "Thirsty@Elephant0241";
		Connection connect = null;
		try
		{
			connect = DriverManager.getConnection(url, userName, password);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return connect;
	}
	private void shutDown(Connection link,PreparedStatement... state)
	{
		try
		{
			for(PreparedStatement prep:state)
			{
				prep.close();
			}
			link.close();
		}
		catch (SQLException e)
		{
			//e.printStackTrace();
		}
	}
	public void insertRequest(UserInfo user) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("INSERT INTO UserInfo (password,name,dob,type,phoneNumber,status)"
					+ " VALUES (?,?,?,?,?,'pending');");
			query.setString(1, user.getPassword());
			query.setString(2, user.getName());
			query.setString(3, user.getDob());
			query.setString(4, user.getType());
			query.setLong(5, user.getPhoneNumber());
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public UserInfo findif(int userId, String password) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		UserInfo user = null;
		try
		{
			query = wire.prepareStatement("SELECT * FROM UserInfo WHERE userID = ?");
			query.setInt(1, userId);
			try(ResultSet rset = query.executeQuery())
			{
				rset.next();
				if(rset.getString("password").equals(password) && rset.getString("status").equalsIgnoreCase("approved"))
				{
					user = new UserInfo();
					user.setUserId(userId);
					user.setPassword(password);
					user.setName(rset.getString(3));
					user.setDob(rset.getString(4));
					user.setPhoneNumber(rset.getLong(5));
					user.setType(rset.getString(6));
				}
			}
			return user;
		}
		catch (SQLException e)
		{
			throw new UserException("The user id or password is invalid",e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void updateUser(int userId, String name, String dob, long phNo) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("UPDATE UserInfo SET name = ?,dob = ?,phoneNumber = ? WHERE userID = ?");
			query.setString(1, name);
			query.setString(2, dob);
			query.setLong(3, phNo);
			query.setInt(4, userId);
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void deleteMaterial(Long materialId) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("DELETE FROM StudyMaterial WHERE materialId = ?");
			query.setLong(1, materialId);
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public boolean checkUser(int userId, Long materialId) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT postedBy FROM StudyMaterial WHERE materialId = ?");
			query.setLong(1, materialId);
			try(ResultSet rset = query.executeQuery())
			{
				if(rset.next())
				{
					if(rset.getInt("postedBy")==userId)
					{
						return true;
					}
				}
			}
			return false;
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void newMaterial(StudyMaterial study) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("INSERT INTO StudyMaterial (postedBy ,topic ,fileType ,link ) VALUES (?,?,?,?);");
			query.setLong(1, study.getPostedBy());
			query.setString(2, study.getTopic());
			query.setString(3, study.getFileType());
			query.setString(4, study.getLink());
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public List<StudyMaterial> findYourMaterial(int userId) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT * FROM StudyMaterial WHERE postedBy = ?;");
			query.setLong(1, userId);
			List<StudyMaterial> list = new ArrayList<StudyMaterial>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					StudyMaterial study = new StudyMaterial(); 
					study.setMaterialId(rset.getLong(1));
					study.setPostedBy(rset.getInt(2));
					study.setTopic(rset.getString(3));
					study.setFileType(rset.getString(4));
					study.setLink(rset.getString(5));
					list.add(study);
				}
			}
			return list;
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public List<StudyMaterial> particularMaterial(String topic) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT * FROM StudyMaterial WHERE topic = ?;");
			query.setString(1, topic);
			List<StudyMaterial> list = new ArrayList<StudyMaterial>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					StudyMaterial study = new StudyMaterial(); 
					study.setMaterialId(rset.getLong(1));
					study.setPostedBy(rset.getInt(2));
					study.setTopic(rset.getString(3));
					study.setFileType(rset.getString(4));
					study.setLink(rset.getString(5));
					list.add(study);
				}
			}
			return list;
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void insertDoubt(String question) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("INSERT INTO Doubts (question) VALUES (?);");
			query.setString(1, question);
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public List<Doubts> allDoubts() throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT * FROM Doubts;");
			List<Doubts> list = new ArrayList<Doubts>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					Doubts ask = new Doubts(); 
					ask.setDoubtId(rset.getLong(1));
					ask.setQuestion(rset.getString(2));
					ask.setAnswer(rset.getString(3));
					list.add(ask);
				}
			}
			return list;
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void upadateDoubt(long doubtId,String answer) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("UPDATE Doubts SET answer = ? where doubtId = ?;");
			query.setString(1, answer);
			query.setLong(2, doubtId);
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public List<UserInfo> allUsers() throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT * FROM UserInfo WHERE status = 'approved';");
			List<UserInfo> list = new ArrayList<UserInfo>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					UserInfo user = new UserInfo();
					user.setUserId(rset.getInt(1));
					user.setPassword(rset.getString(2));
					user.setName(rset.getString(3));
					user.setDob(rset.getString(4));
					user.setPhoneNumber(rset.getLong(5));
					user.setType(rset.getString(6));
					list.add(user);
				}
			}
			return list;
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public List<UserInfo> allPending() throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("SELECT * FROM UserInfo WHERE status = 'pending';");
			List<UserInfo> list = new ArrayList<UserInfo>();
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					UserInfo user = new UserInfo();
					user.setUserId(rset.getInt(1));
					user.setPassword(rset.getString(2));
					user.setName(rset.getString(3));
					user.setDob(rset.getString(4));
					user.setPhoneNumber(rset.getLong(5));
					user.setType(rset.getString(6));
					list.add(user);
				}
			}
			return list;
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void deleteDoubt(long doubtId) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("DELETE FROM Doubts WHERE doubtId = ?");
			query.setLong(1, doubtId);
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	public void updateUserStatus(int userId, String string) throws UserException
	{
		Connection wire = connector();
		PreparedStatement query = null;
		try
		{
			query = wire.prepareStatement("UPDATE UserInfo SET status = ? where userId = ?;");
			query.setString(1, string);
			query.setInt(2, userId);
			query.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new UserException(e.getMessage(),e);
		}
		finally
		{
			shutDown(wire,query);
		}
	}
	
}
