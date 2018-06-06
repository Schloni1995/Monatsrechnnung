package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DataReceiver
{
	public static Object[][] getFreqs()
	{
		Object[][] freqs = null;
		Connection c = new ConnectToMySQL().getConnection();
		Statement st = null;
		ResultSet rs = null;
		try
		{
			st = c.createStatement();
			String sql = ("SELECT * FROM frequency");
			rs = st.executeQuery(sql);
			int columnCount = rs.getMetaData().getColumnCount();
			int rowCount = 0;
			if (rs.last())
			{
				rowCount = rs.getRow();
				// Move to beginning
				rs.beforeFirst();
			}
			freqs = new Object[rowCount][columnCount];
			while (rs.next())
			{
				freqs[rs.getRow() - 1][0] = rs.getInt("id");
				freqs[rs.getRow() - 1][1] = rs.getString("name");
			}

			c.close();
		}
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return freqs;
	}

	public static Object[][] getAusgaben()
	{
		Object[][] ausgaben = null;
		Connection c = new ConnectToMySQL().getConnection();
		Statement st = null;
		ResultSet rs = null;
		try
		{
			st = c.createStatement();
			String sql = ("use monatsrechnung;" + " SELECT * FROM ausgaben AS a LEFT JOIN frequency AS f ON a.frequenz = f.id");
			rs = st.executeQuery(sql);
			int columnCount = rs.getMetaData().getColumnCount();
			int rowCount = 0;
			if (rs.last())
			{
				rowCount = rs.getRow();
				// Move to beginning
				rs.beforeFirst();
			}
			ausgaben = new Object[rowCount][columnCount];
			while (rs.next())
			{
				for (int i = 0; i < columnCount; i++)
				{
					ausgaben[rs.getRow() - 1][i] = rs.getObject(i);
				}
			}

			c.close();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		return ausgaben;
	}
}
