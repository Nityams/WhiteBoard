
import java.awt.*;
import javax.swing.*;
public class Controls extends JPanel {
	// or JPanel, goes to the left side of whiteboard
	public Controls() {
		setLayout(new GridLayout(5, 1));
		setSize(400, 400);
		add(new addPanel());// panel for creating shapes
		add(new colorPanel());// panel for setting color
		add(new textPanel());// panel for setting text
		add(new posPanel());// panel for moving and removing
		add(new tablePanel());// panel for the table, basically empty right now
	}

}
