import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JPanel;



public class Canvas extends JPanel{

	//how to update the shapes?
	ArrayList<DShape> shapes = new ArrayList<>();
//		MovingAdapter ma = new MovingAdapter();
	// may need to use stack/queue to display last on top 
	//list of shape objects axnd reflectes each after adding and editing..
	//also defines the ordering of the shape as last shape comming first	
	//** may need to be static **

	//paintComponent() should loop through all the shapes and draw them.
	public Canvas ()
	{
		setBackground(Color.orange);
		setSize(400,400);	//size 400x400
		//addMouseListener(new Clicker());

	}

	/*
	 *  @param- selected shape to add
	 *  visibility package
	 */
	void addShapes(DShape delshape)
	{
		// may need to check instance of delshape
		shapes.add(delshape);
	}

	void paintComponent()
	{
		System.out.println("-----------------");
		for (DShape dshape : shapes) {
			if (dshape instanceof DRect) {
				System.out.println("DRect");
				dshape.draw(getGraphics());
				addMouseListener(new Clicker());
				addMouseMotionListener(new Clicker());
//				addMouseMotionListener(ma);//the mouse listener
//				  addMouseListener(ma);//the mouse listener

			} else if (dshape instanceof DOval) {
				System.out.println("DOval");
				dshape.draw(getGraphics());
				addMouseListener(new Clicker());
				addMouseMotionListener(new Clicker());

			}
			/*else if(dshape instanceof DLine)
			{
				System.out.println("DLine");
//				DLine paintShape = new DLine();
//				paintShape = (DLine)shapes.get(i);
//				paintShape.draw(getGraphics());
			}
			else if(dshape instanceof DText)
			{
				System.out.println("DText");
//				DText paintShape = new DText();
//				paintShape = (DText)shapes.get(i);
////				paintShape.draw(getGraphics());
			}*/

			else
			{
				System.out.println("Instance error either adding or retriving from List");
			}
		}
	}

	//called by buttons' action listener
	/*
	 * @param- selected shape to delete
	 */
	void remove(DShape delshape) //level package
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

	//sort of working
	class Clicker extends MouseAdapter 
	{

		DShape move;
		int x,y;
		int num=0;
		@Override
		public void mouseClicked(MouseEvent me)
		{
			super.mouseClicked(me);
			boolean brk = false;
			int count=shapes.size()-1;
			
			while(brk == false && count>=0)
			{
				System.out.println("****"+count+"****");
				DShape s = shapes.get(count);
				System.out.println(count+"--------");
				System.out.println(s);
				System.out.println(s.contains(me.getPoint()));
				--count;
				if(s.contains(me.getPoint()))
				{ 						
					if(s instanceof DRect)
					{
						num = count;
						move = s;
					System.out.println("Drect clicked"+count);
					}
					else if(s instanceof DOval)
					{
						num = count;
						move = new DOval();
						move = s;
					System.out.println("DOval clicked!"+count);
					}
					brk = true;
				}
			}
			System.out.println("move this obj-"+move);
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{ 
			
			move = shapes.get(num);
			//super.mouseDragged(e);
			System.out.println(move+"Dragged!!!");
		  int dx = e.getPoint().x - move.model.x;
	      int dy = e.getPoint().y - move.model.y;
	      move.model.x += dx;
	      move.model.y += dy;
	     // paintComponent();
	      move.draw(getGraphics());
	      repaint(); 
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
//			paintComponent();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
//			paintComponent();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
//			paintComponent();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			paintComponent();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
			
	
	}
			
//				for(DShape s: shapes)
//			{
//				Point x = me.getPoint();
////				System.out.println(x);
////				System.out.println(s);
//				if(s.contains(x))
//				{ 	
//					if(s instanceof DRect)
//					{
//					System.out.println("Drect clicked");
//					}
//					else if(s instanceof DOval)
//					{
//					System.out.println("DOval clicked!");
//					}
//					else
//						System.out.println("no obj found");
//				}
////				else
////					System.out.println("Canvas Clicked");
//				break;
//			}
			
		
	
//		  class MovingAdapter extends MouseAdapter {
//	
//			    private int x;
//	
//			    private int y;
//	
//			    public void mousePressed(MouseEvent e) {
//			      x = e.getX();
//			      y = e.getY();
//			    }
//	
//			    public void mouseDragged(MouseEvent e) {
//	
//			      int dx = e.getX() - x;
//			      int dy = e.getY() - y;
//			      repaint();
//			      x += dx;
//			      y += dy;
//			      System.out.println("move attempt");
//	
//			     /* if (myRect.getBounds2D().contains(x, y)) {
//			        myRect.x += dx;
//			        myRect.y += dy;
//			        repaint();
//			      }
//			      x += dx;
//			      y += dy;*/
//			    }
			  }
	

