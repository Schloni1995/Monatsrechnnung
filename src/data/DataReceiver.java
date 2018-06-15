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

	public static Object[][] getAusgaben(String[] colnames)
	{
		Object[][] ausgaben = null;
		Connection c = new ConnectToMySQL().getConnection();
		Statement st = null;
		ResultSet rs = null;
		try
		{
			st = c.createStatement();
			String sql = ("SELECT a.id, a.position, a.preis, a.datum, a.bemerkung, a.jasmin, a.toni, f.name\r\n"
					+ "FROM monatsrechnung.ausgaben AS a LEFT JOIN monatsrechnung.frequency AS f ON a.frequenz = f.id");
			rs = st.executeQuery(sql);
			int columnCount = colnames.length;
			int rowCount = 0;

			if (rs.last())
			{
				rowCount = rs.getRow();
				// Move to beginning
				rs.beforeFirst();
			}
			System.out.println("TableDimension:" + rowCount + "(Rows)*" + columnCount + "(Column)");
			ausgaben = new Object[rowCount][columnCount];
			while (rs.next())
			{
				int x = 0;
				for (String string : colnames)
				{
					ausgaben[rs.getRow() - 1][x] = rs.getObject(string);
				}
			}

			c.close();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		finally
		{
			try
			{
				rs.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		for (Object[] objects : ausgaben)
		{
			for (Object object : objects)
			{
				System.out.println(object+"");
			}
		}

		return ausgaben;
	}
}
