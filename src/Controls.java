/*import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Controls extends JPanel{
		// or JPanel, goes to the left side of whiteboard
	
	public Controls()
	{
		setBackground(Color.black);
		setSize(400,400);
	}
}*/

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Controls extends JPanel{
		// or JPanel, goes to the left side of whiteboard
	public Controls()
	{
		setLayout(new GridLayout(5,1));
	//	setBackground(Color.black);
		setSize(400,400);
		add(new JButton("hay u1"));//testing purpose
		add(new JButton("hay u2"));//testing purpose
		add(new JButton("hay u3"));//testing purpose
		add(new JButton("hay u4"));//testing purpose
		add(new JButton("hay u5"));//testing purpose
	}
}

