package da.accounting;

import com.mysql.jdbc.Connection;

import da.error.DAException;
import da.factory.DBEngine;

public class Report {
	
	private DBEngine db;
	public Report() throws DAException
	{
		db=new DBEngine();
		if(!db.connect()) throw new DAException("Could not connect to database");
	}
	
	public Connection getConnection()
	{
		return db.getConnection();
	}
}
