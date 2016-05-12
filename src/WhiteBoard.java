import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.*;

public class WhiteBoard extends JFrame{
	//singleton to create only one WhiteBoard
		
		public WhiteBoard()
		{
			this.setTitle("WhiteBoard");
			this.setLayout(new BorderLayout());
			this.add(new Controls(),BorderLayout.WEST);
			this.add(new Canvas(),BorderLayout.CENTER);
			setSize(800,400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}


}
