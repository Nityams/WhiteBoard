
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Controls extends JPanel {
	// or JPanel, goes to the left side of whiteboard
	
	Canvas c = null;
	
	public Controls() {
		c = WhiteBoard.getCanvas();
		
		//general stuff for master panel
		setLayout(new GridLayout(5, 1));
		setSize(400, 400);
		
		//adding shapes
		JPanel addPanel = new JPanel(new GridLayout(1,5));
		addPanel.add(new JLabel("Add"));
		JButton rect = new JButton("Rect");
		rect.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.addShapes(new DRect(50,50,10,20,Color.blue));
				c.paintComponent();		
			}
			
		});
		addPanel.add(rect);
		
		//addPanel.add(new JButton("Rect").addActionListener(new btnListener("Rect")));
		JButton oval = new JButton("Oval");
		oval.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.addShapes(new DOval(50,50,30,25,Color.red));
				c.paintComponent();		
			}
			
		});
		addPanel.add(oval);
		
		//addPanel.add(new JButton("Oval").addActionListener(new btnListener("Oval")));
		addPanel.add(new JButton("Line"));
		addPanel.add(new JButton("Text"));
		
		//changing color
		JPanel colorPanel = new JPanel(new GridLayout(1,1));
		colorPanel.add(new JButton("Set Color"));
		
		//setting text
		JPanel textPanel = new JPanel(new GridLayout(1,2));
		textPanel.add(new JTextField());
		textPanel.add(new JButton("font"));//should be combo box = drop down
		
		//moving around
		JPanel posPanel = new JPanel(new GridLayout(1,3));
		posPanel.add(new JButton("Move to Front"));
		posPanel.add(new JButton("Move to Back"));
		posPanel.add(new JButton("Remove Shape"));
		
		
		//testing for table. now working on how to grab all data to put into array, I've been stucking here for 2 hours...
		 String[] columnNames={"X","Y","Widt","Height"};
		Object[][] data={{12,11,66,55},{4,5,6,7},{4,5,6,7},{1,23,4,5},{4,5,6,7}};
		
		
		//add all panels to the"master" panel
		add(addPanel);
		add(colorPanel);
		add(textPanel);
		add(posPanel);	
		add(new JScrollPane(new tablePanel(data, columnNames)));//I keep the table like this for now because I still haven't figure out how to do it.
		
		
	}
	

}
