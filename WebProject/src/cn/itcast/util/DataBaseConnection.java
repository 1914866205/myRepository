package cn.itcast.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection
{
	private String DBDRIVER	= "com.mysql.jdbc.Driver" ;
	private String DBURL = "jdbc:mysql://localhost:3306/day14?/Unicode=true&characterEncoding=utf-8" ;
	private String DBUSER	= "倪涛涛";
	private String DBPASSWORD = ".15252205596xin" ;
	private Connection conn	= null ;

	public DataBaseConnection()
	{
		try
		{
			Class.forName(DBDRIVER) ;
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public Connection getConnection()
	{
		return this.conn ;
	}
	public void close()
	{
		try
		{
			this.conn.close() ;
		}
		catch (Exception e)
		{
			
		}
	}
};