/**
 * 
 */
package database.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author joab
 *
 */
public class ConnectionJDBCFactory {
	String Driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost/masabaexam";
	String user="root";
	String password="root";
	
	static ConnectionJDBCFactory instance=new ConnectionJDBCFactory();
	
	private ConnectionJDBCFactory(){
		try {
			Class.forName(Driver);
			
		} catch (Exception e) {
			
		}
	}
	
 public static ConnectionJDBCFactory getInstance(){
	 return instance;
 }
 public Connection getConnection() throws SQLException, ClassNotFoundException {
     Connection connection = DriverManager.getConnection(url, user, password);
     return connection;
 }
}
