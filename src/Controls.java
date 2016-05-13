
import java.awt.*;
import javax.swing.*;
public class Controls extends JPanel {
	// or JPanel, goes to the left side of whiteboard
	public Controls() {
		//general stuff for master panel
		setLayout(new GridLayout(5, 1));
		setSize(400, 400);
		
		//adding shapes
		JPanel addPanel = new JPanel(new GridLayout(1,5));
		addPanel.add(new JLabel("Add"));
		addPanel.add(new JButton("Rect"));
		addPanel.add(new JButton("Oval"));
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
		
		
		//add all panels to the"master" panel
		add(addPanel);
		add(colorPanel);
		add(textPanel);
		add(posPanel);	
		add(new tablePanel());//I keep the table like this for now because I still haven't figure out how to do it.
		
		
	}

}
