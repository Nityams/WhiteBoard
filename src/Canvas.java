import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class Canvas extends JPanel{
	ArrayList<DShape> shapes;  // may need to use stack/queue to display last on top 
	//list of shape objects and reflectes each after adding and editing..
	//also defines the ordering of the shape as last shape comming first	
	
	//paintComponent() should loop through all the shapes and draw them.
	public Canvas()
	{
		setBackground(Color.orange);
		setSize(400,400);	//size 400x400
		
	}
	
//called by buttons' action listener
	/*
	 * @param- selected shape to delete
	 */
	private void remove(DShape delshape)
	{
		Iterator<DShape> itr = shapes.iterator();
		if(shapes.contains(delshape))
		{
			
			while(itr.next() != delshape)
			{
				itr.next();
			}
			itr.remove();  // should remove the next element
		}
	}

	/*
	 *  @param- selected shape to add
	 */
	private void add(DShape delshape)
	{
		// may need to check instance of delshape
		shapes.add(delshape);
	}
}
