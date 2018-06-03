package gui;

import javax.swing.JFrame;

public class Haupt extends JFrame
{

	public static void main(String[] args)
	{
		new Haupt();
	}

	public Haupt()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
