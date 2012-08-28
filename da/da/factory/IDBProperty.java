package da.factory;

import java.sql.PreparedStatement;
import java.util.Vector;

import da.error.DAException;


public interface IDBProperty {
	public boolean connect() throws DAException;
	public boolean disConnect() throws DAException;
	@SuppressWarnings("unchecked")
	public Vector getData(String syntax) throws DAException;
	@SuppressWarnings("unchecked")
	public Vector getData(PreparedStatement p) throws DAException;
	public boolean execute(String syntax) throws DAException;
	public boolean execute(PreparedStatement p) throws DAException;
}
