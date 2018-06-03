package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Haupt extends JFrame
{
	private static final long serialVersionUID = -3157452541727432023L;
	private JPanel contentPanel;
	private JScrollPane tablePanel;
	private JMenuBar jMenuBar;

	public static void main(String[] args)
	{
		new Haupt();
	}

	public Haupt()
	{
		setJMenuBar(getJMenuBar());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenu getDateiMenu()
	{
		JMenu dateiMenu = new JMenu("Datei");
		return dateiMenu;
	}

	/** @return the contentPanel */
	public JPanel getContentPanel()
	{
		if (contentPanel == null)
		{
			contentPanel = new JPanel();
		}
		return contentPanel;
	}

	/** @return the tablePanel */
	public JScrollPane getTablePanel()
	{
		return tablePanel;
	}

	/** @return the menuBar */
	public JMenuBar getJMenuBar()
	{
		jMenuBar = new JMenuBar();
		jMenuBar.add(getDateiMenu());
		return jMenuBar;
	}
}
