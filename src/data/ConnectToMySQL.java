package data;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectToMySQL
{
	Connection connection;

	public ConnectToMySQL()
	{
		connect("127.0.0.1:3306","monatsrechnung","root","rootTZ");
	}

	/**
	 * 
	 * @param host
	 * @param database
	 * @param user
	 * @param passwd
	 * @return
	 */
	private boolean connect(String host, String database, String user, String passwd)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//			String connectionCommand = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password="
//					+ passwd;
			String connectionCommand = "jdbc:mysql://localhost/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
			connection = DriverManager.getConnection(connectionCommand,user,passwd);
			return true;

		}
		catch (Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(), "DB Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
			System.out.println("false");
			return false;
		}
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection()
	{
		return connection;
	}

}
