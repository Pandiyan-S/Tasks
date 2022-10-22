package dbtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import check.UserException;

public class DataBaseMethods
{
	private void check(Object obj) throws UserException
	{
		if(Objects.isNull(obj))
		{
			throw new UserException("the value is null ");
		}
	}
	private static Connection connector()
	{
//		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/incubationDB";
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
	private void shutDown(Connection link,Statement state)
	{
		try
		{
			state.close();
			link.close();
		}
		catch (SQLException e)
		{
			//e.printStackTrace();
		}
	}
	public void create(String str) throws UserException
	{
		try
		{
			Connection wire = connector();
			Statement query = wire.createStatement();
			query.executeUpdate(str);
			shutDown(wire,query);
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}//swami - resolved
	}
	public void setEmpDetails(String name,long mobile,String eMail,String department) throws UserException
	{
		check(name);
		check(department);
		try
		{
			Connection wire = connector();
			PreparedStatement query = wire.prepareStatement("Insert into Employee(NAME, MOBILE, EMAIL, DEPARTMENT)"
																	+ "values (?,?,?,?);");
			query.setString(1, name);
			query.setLong(2, mobile);
			query.setString(3, eMail);
			query.setString(4, department);
			query.executeUpdate();
			shutDown(wire,query);
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}//swami - resolved
	}
	public void setEmpDetails(EmployeePojo pojo) throws UserException
	{
		check(pojo);
		setEmpDetails(pojo.getName(),pojo.getMobile(),pojo.getEmail(),pojo.getDepartment());
	}
	public List<Map<String,Object>> findDetails(String name) throws UserException
	{
		check(name);
		try
		{
			Connection wire = connector();
			List<Map<String,Object>> employeeList = new ArrayList<Map<String,Object>>();
			PreparedStatement query = wire.prepareStatement("select * from Employee where name = ? ;");
			query.setString(1, name);
			try(ResultSet rset = query.executeQuery())
			{
				ResultSetMetaData rsmd = rset.getMetaData();
				while(rset.next())
				{
					Map<String,Object> hm = new HashMap<String,Object>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						if(rsmd.getColumnType(i)==Types.INTEGER)
						{
							hm.put(rsmd.getColumnName(i), rset.getInt(i));
						}
						else if(rsmd.getColumnType(i)==Types.BIGINT)
						{
							hm.put(rsmd.getColumnName(i), rset.getLong(i));
						}
						else
						{
							hm.put(rsmd.getColumnName(i), rset.getString(i));
						}//swami -check for Metadata.. - resolved
					}
					employeeList.add(hm);
				}
			}
			shutDown(wire,query);
			return employeeList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<EmployeePojo> findPojoDetails(String name) throws UserException
	{
		check(name);
		try
		{
			Connection wire = connector();
			List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
			PreparedStatement query = wire.prepareStatement("select * from Employee where name = ? ;");
			query.setString(1, name);
			try(ResultSet rset = query.executeQuery())//swami - resolved
			{
				while(rset.next())
				{
					EmployeePojo pojo = new EmployeePojo();
					pojo.setEmployeeID(rset.getInt("EMPLOYEE_ID"));
					pojo.setName(rset.getString("NAME"));
					pojo.setMobile(rset.getLong("MOBILE"));
					pojo.setEmail(rset.getString("EMAIL"));
					pojo.setDepartment(rset.getString("DEPARTMENT"));
					employeeList.add(pojo);
				}
			}
			shutDown(wire,query);
			return employeeList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public void updateDB(String name,String column,long mobile) throws UserException
	{
		check(name);
		check(column);
		try
		{
			Connection wire = connector();
			PreparedStatement query = wire.prepareStatement("update Employee set " + column + " = '" 
														+ mobile + "' where name = '" + name +"'");
			query.executeUpdate();
			shutDown(wire,query);
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public void updateDB(String name,String column,String change) throws UserException
	{
		check(name);
		check(column);
		check(change);
		try
		{
			Connection wire = connector();
			PreparedStatement query = wire.prepareStatement("update Employee set " + column + " = '" 
														+ change + "' where name = '" + name +"'");
			query.executeUpdate();
			shutDown(wire,query);
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<Map<String,Object>> show(int n) throws UserException
	{
		try
		{
			Connection wire = connector();
			List<Map<String,Object>> employeeList = new ArrayList<Map<String,Object>>();
			PreparedStatement query = wire.prepareStatement("select * from Employee limit ?;");
			query.setInt(1, n);
			try(ResultSet rset = query.executeQuery())
			{
				ResultSetMetaData rsmd = rset.getMetaData();
				while(rset.next())
				{
					Map<String,Object> hm = new HashMap<String,Object>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						if(rsmd.getColumnType(i)==Types.INTEGER)
						{
							hm.put(rsmd.getColumnName(i), rset.getInt(i));
						}
						else if(rsmd.getColumnType(i)==Types.BIGINT)
						{
							hm.put(rsmd.getColumnName(i), rset.getLong(i));
						}
						else
						{
							hm.put(rsmd.getColumnName(i), rset.getString(i));
						}//swami -check for Metadata.. - resolved
					}
					employeeList.add(hm);
				}
			}
			shutDown(wire,query);
			return employeeList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<EmployeePojo> pojoShow(int n) throws UserException
	{
		try
		{
			Connection wire = connector();
			List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
			PreparedStatement query = wire.prepareStatement("select * from Employee limit ?;");
			query.setInt(1, n);
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					EmployeePojo pojo = new EmployeePojo();
					pojo.setEmployeeID(rset.getInt("EMPLOYEE_ID"));
					pojo.setName(rset.getString("NAME"));
					pojo.setMobile(rset.getLong("MOBILE"));
					pojo.setEmail(rset.getString("EMAIL"));
					pojo.setDepartment(rset.getString("DEPARTMENT"));
					employeeList.add(pojo);
				}
			}
			shutDown(wire,query);
			return employeeList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<Map<String, Object>> sortedShow(int n,String column,String order) throws UserException
	{
		check(column);
		check(order);
		try
		{
			Connection wire = connector();
			List<Map<String,Object>> employeeList = new ArrayList<Map<String,Object>>();
			PreparedStatement query = wire.prepareStatement("select * from Employee order by "+column+" "+order+" limit ?");
			query.setInt(1, n);
			try(ResultSet rset = query.executeQuery())
			{
				ResultSetMetaData rsmd = rset.getMetaData();
				while(rset.next())
				{
					Map<String,Object> hm = new HashMap<String,Object>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						if(rsmd.getColumnType(i)==Types.INTEGER)
						{
							hm.put(rsmd.getColumnName(i), rset.getInt(i));
						}
						else if(rsmd.getColumnType(i)==Types.BIGINT)
						{
							hm.put(rsmd.getColumnName(i), rset.getLong(i));
						}
						else
						{
							hm.put(rsmd.getColumnName(i), rset.getString(i));
						}//swami -check for Metadata.. - resolved
					}
					employeeList.add(hm);
				}
			}
			shutDown(wire,query);
			return employeeList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<EmployeePojo> sortedPojoShow(int n,String column,String order) throws UserException
	{
		check(column);
		check(order);
		try
		{
			Connection wire = connector();
			List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
			PreparedStatement query = wire.prepareStatement("select * from Employee order by "+column+" "+order+" limit ?");
			query.setInt(1, n);
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					
					EmployeePojo pojo = new EmployeePojo();
					pojo.setEmployeeID(rset.getInt("EMPLOYEE_ID"));
					pojo.setName(rset.getString("NAME"));
					pojo.setMobile(rset.getLong("MOBILE"));
					pojo.setEmail(rset.getString("EMAIL"));
					pojo.setDepartment(rset.getString("DEPARTMENT"));
					employeeList.add(pojo);
				}
			}
			shutDown(wire,query);
			return employeeList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public void fire(int id) throws UserException
	{
		try
		{
			Connection wire = connector();
			PreparedStatement query = wire.prepareStatement("delete from Employee where EMPLOYEE_ID = ?;");
			query.setInt(1, id);
			query.executeUpdate();
			shutDown(wire,query);
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
//	public void createDependTable() throws SQLException
//	{
//		Connection wire = connector();
//		PreparedStatement query = wire.prepareStatement("create table Dependent (EMPLOYEE_ID int not null,"
//									+ "NAME varchar(30) not null,AGE int not null,RELATIONSHIP varchar(30) "
//									+ "not null,Foreign key (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID))");
//		query.executeUpdate();
//		shutDown(wire);
//	}
	public void assignRelation(int id,String name,int age,String type) throws UserException
	{
		check(name);
		check(type);
		try
		{
			Connection wire = connector();
			PreparedStatement query = wire.prepareStatement("Insert into Dependent values (?,?,?,?);");
			query.setInt(1, id);
			query.setString(2, name);
			query.setInt(3, age);
			query.setString(4, type);
			query.executeUpdate();
			shutDown(wire,query);
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<Integer> idOfName(String name) throws UserException
	{
		check(name);
		try
		{
			Connection wire = connector();
			PreparedStatement query = wire.prepareStatement("select EMPLOYEE_ID from Employee where name = ?");
			query.setString(1, name);
			List<Integer> ids = new ArrayList<Integer>();
			ResultSet rset = query.executeQuery();
			while(rset.next())
			{
				ids.add(rset.getInt("EMPLOYEE_ID"));
			}
			shutDown(wire,query);
			return ids;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<Map<String, Object>> getDependent(List<Integer> ids) throws UserException
	{
		try
		{
			check(ids);
			Connection wire = connector();
			List<Map<String,Object>> dependentList = new ArrayList<Map<String,Object>>();
			PreparedStatement query = null;
			for(int i=0; i<ids.size(); i++)
			{
				query = wire.prepareStatement("select Employee.name,Employee.employee_id, "
										+ "Dependent.dependent_name,Dependent.AGE,Dependent.RELATIONSHIP from Employee join Dependent "
										+ "on Employee.EMPLOYEE_ID = Dependent.EMPLOYEE_ID where Dependent.EMPLOYEE_ID = ?");
				query.setInt(1, ids.get(i));
				try(ResultSet rset = query.executeQuery())
				{
					ResultSetMetaData rsmd = rset.getMetaData();
					while(rset.next())
					{
						Map<String,Object> hm = new HashMap<String,Object>();
						for(int j=1;j<=rsmd.getColumnCount();j++)
						{
							if(rsmd.getColumnType(i)==Types.INTEGER)
							{
								hm.put(rsmd.getColumnName(i), rset.getInt(i));
							}
							else
							{
								hm.put(rsmd.getColumnName(i), rset.getString(i));
							}//swami -check for Metadata.. - resolved
						}
						dependentList.add(hm);
					}
				}
			}
			shutDown(wire,query);
			return dependentList;
		}
		catch (SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
	public List<Map<String,Object>> mergedDependent(int n) throws UserException
	{
		try
		{
			Connection wire = connector();
			List<Map<String,Object>> dependentList = new ArrayList<Map<String,Object>>();
			PreparedStatement query = wire.prepareStatement("select distinct(employee_id) from Dependent order by employee_id "
																+ "asc limit ?;");
			query.setInt(1, n);
			List<Integer> nEmoployeeIds = new ArrayList<Integer>(n);
			try(ResultSet rset = query.executeQuery())
			{
				while(rset.next())
				{
					nEmoployeeIds.add(rset.getInt(1));
				}
			}
			StringBuilder build = new StringBuilder("select Employee.name,Employee.employee_id,Dependent.dependent_name,Dependent.AGE,"
					+ "Dependent.RELATIONSHIP from Employee join Dependent on Employee.EMPLOYEE_ID = "
					+ "Dependent.EMPLOYEE_ID where Employee.EMPLOYEE_ID in (");
			for(int i=0;i<n;i++)
			{
				build.append(nEmoployeeIds.get(i)).append(",");
			}
			int size = build.length();
			build.replace(size-1,size , ") order by Employee.name;");
			query = wire.prepareStatement(build.toString());
			try(ResultSet rset = query.executeQuery())
			{
				ResultSetMetaData rsmd = rset.getMetaData();
				while(rset.next())
				{
					Map<String,Object> hm = new HashMap<String,Object>();
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						if(rsmd.getColumnType(i)== Types.INTEGER)
						{
							hm.put(rsmd.getColumnName(i), rset.getInt(i));//swami -check for Metadata.. - resolved
						}
						else
						{
							hm.put(rsmd.getColumnName(i), rset.getString(i));
						}
					}
					dependentList.add(hm);
				}
			}
		shutDown(wire,query);
		return dependentList;
		}
		catch(SQLException e)
		{
			throw new UserException("This is an exception in db",e);
		}
	}
}
