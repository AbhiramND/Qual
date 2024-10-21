package supplychainmanagement.qual.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
public void getDbConnection(String url,String username,String password)
{
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		 con = DriverManager.getConnection(url,username,password);
		
		
	}
	catch(Exception e) {}
}
public void getDbConnection()
{
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		 con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		
		
	}
	catch(Exception e) {}
}
public void closeDbConnection()
{
	try {
		con.close();
	}
	catch(Exception e) {}
}

public ResultSet executeSelectQuary( String query)
{	ResultSet resultSet =null;
	try{
		 Statement stat = con.createStatement();
		resultSet = stat.executeQuery(query);
	}
	catch(Exception e) {}
	return resultSet;
}
public int executeNonSelectQuary( String query)
{	int resultSet = 0 ;
	try{
		 Statement stat = con.createStatement();
		resultSet = stat.executeUpdate(query);
	}
	catch(Exception e) {}
	return resultSet;
}
}
