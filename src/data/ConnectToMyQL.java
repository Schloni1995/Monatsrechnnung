package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToMyQL
{
	Connection connection;

	public ConnectToMyQL()
	{
		connect("DESKTOP-8ED31O8","monatsrechnung","root","rootTZ");
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
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionCommand = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password="
					+ passwd;
			connection = DriverManager.getConnection(connectionCommand);
			return true;

		}
		catch (Exception ex)
		{
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
