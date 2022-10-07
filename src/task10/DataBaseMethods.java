package task10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBaseMethods
{
	public static Connection connector()
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
	public void shutDown(Connection link)
	{
		try
		{
			link.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void create() throws SQLException
	{
		Connection wire = connector();
		Statement query = wire.createStatement();
		query.executeUpdate("create table Employee(EMPLOYEE_ID integer not null Auto_increment ,NAME varchar(30) not null ,"
					+ "MOBILE bigint not null, EMAIL varchar(40),DEPARTMENT varchar(30) not null,primary key(Employee_id));");
		shutDown(wire);
	}
	public void setEmpDetails(String NAME,long MOBILE,String EMAIL,String DEPARTMENT) throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("Insert into Employee(NAME, MOBILE, EMAIL, DEPARTMENT)"
																+ "values (?,?,?,?);");
		query.setString(1, NAME);
		query.setLong(2, MOBILE);
		query.setString(3, EMAIL);
		query.setString(4, DEPARTMENT);
		query.executeUpdate();
		shutDown(wire);
	}
	public void setEmpDetails(EmployeePojo pojo) throws SQLException
	{
		setEmpDetails(pojo.getName(),pojo.getMobile(),pojo.getEmail(),pojo.getDepartment());
	}
	public List<HashMap<String,Object>> findDetails(String name) throws SQLException
	{
		Connection wire = connector();
		List<HashMap<String,Object>> employeeList = new ArrayList<HashMap<String,Object>>();
		PreparedStatement query = wire.prepareStatement("select * from Employee where name = ? ;");
		query.setString(1, name);
		ResultSet rset = query.executeQuery();
		HashMap<String,Object> hm;
		while(rset.next())
		{
			hm = new HashMap<String,Object>();
			hm.put("EMPLOYEE_ID", rset.getInt("EMPLOYEE_ID"));
			hm.put("NAME", rset.getString("NAME"));
			hm.put("MOBILE", rset.getLong("MOBILE"));
			hm.put("EMAIL", rset.getString("EMAIL"));
			hm.put("DEPARTMENT", rset.getString("DEPARTMENT"));
			employeeList.add(hm);
		}
		shutDown(wire);
		return employeeList;
	}
	public List<EmployeePojo> findPojoDetails(String name) throws SQLException
	{
		Connection wire = connector();
		List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
		PreparedStatement query = wire.prepareStatement("select * from Employee where name = ? ;");
		query.setString(1, name);
		ResultSet rset = query.executeQuery();
		EmployeePojo pojo;
		while(rset.next())
		{
			pojo = new EmployeePojo();
			pojo.setEmployeeID(rset.getInt("EMPLOYEE_ID"));
			pojo.setName(rset.getString("NAME"));
			pojo.setMobile(rset.getLong("MOBILE"));
			pojo.setEmail(rset.getString("EMAIL"));
			pojo.setDepartment(rset.getString("DEPARTMENT"));
			employeeList.add(pojo);
		}
		shutDown(wire);
		return employeeList;
	}
	public void updateDB(String name,String column,long mobile) throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("update Employee set " + column + " = '" 
													+ mobile + "' where name = '" + name +"'");
		query.executeUpdate();
		shutDown(wire);
	}
	public void updateDB(String name,String column,String change) throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("update Employee set " + column + " = '" 
													+ change + "' where name = '" + name +"'");
		query.executeUpdate();
		shutDown(wire);
	}
	public List<HashMap<String,Object>> show(int n) throws SQLException
	{
		Connection wire = connector();
		List<HashMap<String,Object>> employeeList = new ArrayList<HashMap<String,Object>>();
		PreparedStatement query = wire.prepareStatement("select * from Employee limit ?;");
		query.setInt(1, n);
		ResultSet rset = query.executeQuery();
		HashMap<String,Object> hm;
		while(rset.next())
		{
			hm = new HashMap<String,Object>();
			hm.put("EMPLOYEE_ID", rset.getInt("EMPLOYEE_ID"));
			hm.put("NAME", rset.getString("NAME"));
			hm.put("MOBILE", rset.getLong("MOBILE"));
			hm.put("EMAIL", rset.getString("EMAIL"));
			hm.put("DEPARTMENT", rset.getString("DEPARTMENT"));
			employeeList.add(hm);
		}
		shutDown(wire);
		return employeeList;
	}
	public List<EmployeePojo> pojoShow(int n) throws SQLException
	{
		Connection wire = connector();
		List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
		PreparedStatement query = wire.prepareStatement("select * from Employee limit ?;");
		query.setInt(1, n);
		ResultSet rset = query.executeQuery();
		EmployeePojo pojo;
		while(rset.next())
		{
			pojo = new EmployeePojo();
			pojo.setEmployeeID(rset.getInt("EMPLOYEE_ID"));
			pojo.setName(rset.getString("NAME"));
			pojo.setMobile(rset.getLong("MOBILE"));
			pojo.setEmail(rset.getString("EMAIL"));
			pojo.setDepartment(rset.getString("DEPARTMENT"));
			employeeList.add(pojo);
		}
		shutDown(wire);
		return employeeList;
	}
	public List<HashMap<String, Object>> sortedShow(int n,String column,String order) throws SQLException
	{
		Connection wire = connector();
		List<HashMap<String,Object>> employeeList = new ArrayList<HashMap<String,Object>>();
		PreparedStatement query = wire.prepareStatement("select * from Employee order by "+column+" "+order+" limit ?");
		query.setInt(1, n);
		ResultSet rset = query.executeQuery();
		HashMap<String,Object> hm;
		while(rset.next())
		{
			hm = new HashMap<String,Object>();
			hm.put("EMPLOYEE_ID", rset.getInt("EMPLOYEE_ID"));
			hm.put("NAME", rset.getString("NAME"));
			hm.put("MOBILE", rset.getLong("MOBILE"));
			hm.put("EMAIL", rset.getString("EMAIL"));
			hm.put("DEPARTMENT", rset.getString("DEPARTMENT"));
			employeeList.add(hm);
		}
		shutDown(wire);
		return employeeList;
	}
	public List<EmployeePojo> sortedPojoShow(int n,String column,String order) throws SQLException
	{
		Connection wire = connector();
		List<EmployeePojo> employeeList = new ArrayList<EmployeePojo>();
		PreparedStatement query = wire.prepareStatement("select * from Employee order by "+column+" "+order+" limit ?");
		query.setInt(1, n);
		ResultSet rset = query.executeQuery();
		EmployeePojo pojo;
		while(rset.next())
		{
			pojo = new EmployeePojo();
			pojo.setEmployeeID(rset.getInt("EMPLOYEE_ID"));
			pojo.setName(rset.getString("NAME"));
			pojo.setMobile(rset.getLong("MOBILE"));
			pojo.setEmail(rset.getString("EMAIL"));
			pojo.setDepartment(rset.getString("DEPARTMENT"));
			employeeList.add(pojo);
		}
		shutDown(wire);
		return employeeList;
	}
	public void fire(int id) throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("delete from Employee where EMPLOYEE_ID = ?;");
		query.setInt(1, id);
		query.executeUpdate();
		shutDown(wire);
	}
	public void createDependTable() throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("create table Dependent (EMPLOYEE_ID int not null,"
									+ "NAME varchar(30) not null,AGE int not null,RELATIONSHIP varchar(30) "
									+ "not null,Foreign key (EMPLOYEE_ID) REFERENCES Employee(EMPLOYEE_ID))");
		query.executeUpdate();
		shutDown(wire);
	}
	public void assignRelation(int id,String name,int age,String type) throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("Insert into Dependent values (?,?,?,?);");
		query.setInt(1, id);
		query.setString(2, name);
		query.setInt(3, age);
		query.setString(4, type);
		query.executeUpdate();
		shutDown(wire);
	}
	public List<Integer> idOfName(String name) throws SQLException
	{
		Connection wire = connector();
		PreparedStatement query = wire.prepareStatement("select EMPLOYEE_ID from Employee where name = ?");
		query.setString(1, name);
		ResultSet rset = query.executeQuery();
		List<Integer> ids = new ArrayList<Integer>();
		while(rset.next())
		{
			ids.add(rset.getInt("EMPLOYEE_ID"));
		}
		shutDown(wire);
		return ids;
	}
	public List<HashMap<String, Object>> getDependent(List<Integer> ids) throws SQLException
	{
		Connection wire = connector();
		List<HashMap<String,Object>> dependentList = new ArrayList<HashMap<String,Object>>();
		for(int i=0; i<ids.size(); i++)
		{
			PreparedStatement query = wire.prepareStatement("select * from Dependent where EMPLOYEE_ID = ?");
			query.setInt(1, ids.get(i));
			ResultSet rset = query.executeQuery();
			HashMap<String,Object> hm;
			while(rset.next())
			{
				hm = new HashMap<String,Object>();
				hm.put("EMPLOYEE_ID", rset.getInt("EMPLOYEE_ID"));
				hm.put("NAME", rset.getString("NAME"));
				hm.put("AGE", rset.getInt("AGE"));
				hm.put("RELATIONSHIP", rset.getString("RELATIONSHIP"));
				dependentList.add(hm);
			}
		}
		shutDown(wire);
		return dependentList;
	}
	public List<HashMap<String,Object>> mergedDependent(int n) throws SQLException
	{
		Connection wire = connector();
		List<HashMap<String,Object>> dependentList = new ArrayList<HashMap<String,Object>>();
		PreparedStatement query = wire.prepareStatement("select Employee.name,Employee.employee_id,"
								+ "Dependent.NAME,Dependent.AGE,Dependent.RELATIONSHIP from Employee"
								+ " join Dependent on Employee.EMPLOYEE_ID = Dependent.EMPLOYEE_ID "
								+ "where Employee.EMPLOYEE_ID between 1 and ? "
								+ "order by Dependent.name;");
		query.setInt(1, n);
		ResultSet rset = query.executeQuery();
		HashMap<String,Object> hm;
		while(rset.next())
		{
			hm = new HashMap<String,Object>();
			hm.put("Employee_NAME", rset.getString("Employee.NAME"));
			hm.put("EMPLOYEE_ID", rset.getInt("Employee.EMPLOYEE_ID"));
			hm.put("NAME", rset.getString("Dependent.NAME"));
			hm.put("AGE", rset.getInt("Dependent.AGE"));
			hm.put("RELATIONSHIP", rset.getString("Dependent.RELATIONSHIP"));
			dependentList.add(hm);
		}
	shutDown(wire);
	return dependentList;
	}
}
