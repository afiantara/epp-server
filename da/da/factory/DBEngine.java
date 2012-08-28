package da.factory;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import tools.Tools;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import da.error.DAException;


public class DBEngine implements IDBProperty{
	private Connection conn = null;
	private ResultSet rs;
	private boolean m_autoCommit=true;
	
	public DBEngine() throws DAException 
	{
		try {
	        Class.forName(Tools.readprops( "driver", "com.mysql.jdbc.Driver")).newInstance();
	    } catch (Exception ex) {
	        // handle the error
	    	throw new DAException (ex.getMessage());
	    }	
	}
	
	public DBEngine(boolean autoCommit) throws DAException 
	{
		try {
	        Class.forName(Tools.readprops( "driver", "com.mysql.jdbc.Driver")).newInstance();
	        m_autoCommit=autoCommit;
	    } catch (Exception ex) {
	        // handle the error
	    	throw new DAException (ex.getMessage());
	    }	
	}
	
	//it used when set auto commit=true
	public void commit()
	{
		try {
			conn.commit();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	private Statement stmt = null;
	
	public PreparedStatement getStatement(String strSQL) throws SQLException
	{
		PreparedStatement p=conn.prepareStatement(strSQL);
		return p;
	}
	@Override
	public boolean execute(String strSQL) throws DAException
	{
		try {
		    stmt = (Statement) conn.createStatement();
		    stmt.executeUpdate(strSQL);
		    disConnect();
		    return true;
		}
		catch (SQLException ex){
		    // handle any errors
			String exMsg="SQLException: " + ex.getMessage() + "\r\n";
			exMsg+="SQLState: " + ex.getSQLState()+ "\r\n";
			exMsg+="VendorError: " + ex.getErrorCode();
			throw new DAException (exMsg);
		}
	}

	@Override
	public boolean connect() throws DAException {
		// TODO Auto-generated method stub
		try {
		    conn =(Connection) DriverManager.getConnection(Tools.readprops("header", "jdbc:mysql://localhost/simrs?") +
		                                   "user=" + Tools.readprops("userid", "root") + "&password=" + Tools.readprops( "password", "password"));
		    // Do something with the Connection
		    conn.setAutoCommit(m_autoCommit);
		} catch (SQLException ex) {
		    // handle any errors
			String exMsg="SQLException: " + ex.getMessage() + "\r\n";
			exMsg+="SQLState: " + ex.getSQLState()+ "\r\n";
			exMsg+="VendorError: " + ex.getErrorCode();
			throw new DAException (exMsg);
		}
		return true;
	}

	@Override
	public boolean disConnect() {
		// TODO Auto-generated method stub
		if (rs != null) {
	        try {
	            rs.close();
	        } catch (SQLException sqlEx) { } // ignore
	        rs = null;
	    }
	    if (stmt != null) {
	        try {
	            stmt.close();
	        } catch (SQLException sqlEx) { } // ignore
	        stmt = null;
	    }
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vector getData(String syntax) throws DAException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		if(columns!=null)
			columns=null;
		columns=new Vector<String>();
		
		Vector rows=new Vector();
		try {
		    stmt = (Statement) conn.createStatement();
		    rs = stmt.executeQuery(syntax);
		    int numOfCol=0;
		    
		    if(rs!=null)
		    {
			    ResultSetMetaData rsmd = rs.getMetaData();
			    numOfCol=rsmd.getColumnCount();
			    currentColumnCount=numOfCol;
		    }
		    
		    while(rs.next())
		    {
		    	Vector newRow =new Vector();
		    	for(int i=0; i < numOfCol;i++)
		    	{
		    		columns.add(rs.getMetaData().getColumnName(i+1));
		    		if(rs.getMetaData().getColumnTypeName(i+1).equals("VARBINARY"))
		    			newRow.addElement(rs.getString(i+1));
		    		else
		    		{
		    			if(rs.getObject(i+1)==null)
		    				newRow.addElement("");
		    			else
		    				newRow.addElement(rs.getObject(i+1));
		    		}
		    	}
		    	rows.add(newRow);
		    }
		}
		catch (SQLException ex){
		    // handle any errors
			String exMsg="SQLException: " + ex.getMessage() + "\r\n";
			exMsg+="SQLState: " + ex.getSQLState()+ "\r\n";
			exMsg+="VendorError: " + ex.getErrorCode();
			throw new DAException (exMsg);
		}
		finally {
		    
		}
		return rows;
	}

	@Override
	public boolean execute(PreparedStatement p) throws DAException {
		// TODO Auto-generated method stub
		try
		{
			p.executeUpdate();
			if(!m_autoCommit)
				conn.commit();
			return true;
		}
		catch(Exception ex)
		{
			throw new DAException(ex.getLocalizedMessage());
		}
	}

	private int currentColumnCount=0;
	
	public int getCurrentColumnCount()
	{
		return currentColumnCount;
	}
	
	private Vector<String> columns;
	public String getColumnName(int idx)
	{
		return columns.get(idx);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Vector getData(PreparedStatement p) throws DAException {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		if(columns!=null)
			columns=null;
		columns=new Vector<String>();
		Vector rows=new Vector();
		try {
		    rs = p.executeQuery();
		    int numOfCol=0;
		    
		    if(rs!=null)
		    {
			    ResultSetMetaData rsmd = rs.getMetaData();
			    numOfCol=rsmd.getColumnCount();
			    currentColumnCount=numOfCol;
		    }
		    else
		    	return null;
		    
		    while(rs.next())
		    {
		    	Vector newRow =new Vector();
		    	for(int i=0; i < numOfCol;i++)
		    	{
		    		columns.add(rs.getMetaData().getColumnName(i+1));
		    		
		    		if(rs.getMetaData().getColumnTypeName(i+1).equals("VARBINARY"))
		    			newRow.addElement(rs.getString(i+1));
		    		{
		    			if(rs.getObject(i+1)==null)
		    				newRow.addElement("");
		    			else
		    				newRow.addElement(rs.getObject(i+1));
		    		}
		    	}
		    	rows.add(newRow);
		    }
		}
		catch (SQLException ex){
		    // handle any errors
			String exMsg="SQLException: " + ex.getMessage() + "\r\n";
			exMsg+="SQLState: " + ex.getSQLState()+ "\r\n";
			exMsg+="VendorError: " + ex.getErrorCode();
			throw new DAException (exMsg);
		}
		finally {
		    
		}
		return rows;
	}
}
