package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import data.DataReceiver;

public class Haupt extends JFrame
{
	private static final long serialVersionUID = -3157452541727432023L;
	private JPanel contentPanel;
	private JScrollPane tablePanel;
	private JMenuBar jMenuBar;
	private JTable table;
	private static final String[] mainColNames = new String[] {"id","position","preis","datum","bemerkung","jasmin","toni","name"};

	public static void main(String[] args)
	{
		new Haupt();
	}

	public Haupt()
	{
		setJMenuBar(getJMenuBar());
		setContentPane(getContentPanel());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenu getDateiMenu()
	{
		JMenu dateiMenu = new JMenu("Datei");
		dateiMenu.add(getImportItem());
		return dateiMenu;
	}

	private JMenuItem getImportItem()
	{
		JMenuItem importItem = new JMenuItem("Importieren");
		importItem.addActionListener(e ->
		{
			Object[][] data = DataReceiver.getAusgaben(mainColNames);
			table.setModel(new DefaultTableModel(data, mainColNames));
			// table.setModel(new DefaultTableModel(DataReceiver.getFreqs(),new
			// String[] {"ID","Häufigkeit"}));
			table.getColumnModel().getColumn(table.getColumnModel().getColumnIndex(mainColNames[0])).setMinWidth(0);
			table.getColumnModel().getColumn(table.getColumnModel().getColumnIndex(mainColNames[0])).setMaxWidth(0);
			table.getColumnModel().getColumn(table.getColumnModel().getColumnIndex(mainColNames[0])).setPreferredWidth(0);

		});
		return importItem;
	}

	/** @return the contentPanel */
	public JPanel getContentPanel()
	{
		if (contentPanel == null)
		{
			contentPanel = new JPanel();
			contentPanel.add(getTablePanel());
		}
		return contentPanel;
	}

	/** @return the tablePanel */
	public JScrollPane getTablePanel()
	{
		if (tablePanel == null)
		{
			tablePanel = new JScrollPane(getTable());
		}
		return tablePanel;
	}

	public JTable getTable()
	{
		if (table == null)
		{
			table = new JTable();
		}
		return table;
	}

	/** @return the menuBar */
	public JMenuBar getJMenuBar()
	{
		jMenuBar = new JMenuBar();
		jMenuBar.add(getDateiMenu());
		return jMenuBar;
	}
}
