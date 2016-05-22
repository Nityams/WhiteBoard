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
	Clicker ma = new Clicker();
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
	
	void refresh()
	{
		repaint();
		for(int i=0; i<shapes.size(); i++)
			shapes.get(i).draw(getGraphics());
		paintComponent();
	
		
	}
	
	void swap(int x, int num)
	{
		System.out.println("before"+shapes);
		if(x==0) // back to front
		{
			DShape temp = shapes.get(shapes.size()-1);
			shapes.set(shapes.size()-1, shapes.get(num));
			shapes.set(num, temp);
		}
		else if(x==1)
		{
			DShape temp = shapes.get(0);
			shapes.set(0, shapes.get(num));
			shapes.set(num, temp);
		}
		refresh();
	}
	void paintComponent()
	{
//		System.out.println("-----------------");
		for (DShape dshape : shapes) {
			if (dshape instanceof DRect) {
//				System.out.println("DRect");
				dshape.draw(getGraphics());
				addMouseListener(ma);
				addMouseMotionListener(ma);
//				addMouseMotionListener(ma);//the mouse listener
//				  addMouseListener(ma);//the mouse listener

			} else if (dshape instanceof DOval) {
//				System.out.println("DOval");
				dshape.draw(getGraphics());
				addMouseListener(ma);
				addMouseMotionListener(ma);

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
	
	void delete(int deleteNum) //level package
	{
		System.out.println(deleteNum+" needs to be deleted");
		shapes.remove(deleteNum);
		System.out.println(shapes.size());
//		paintComponent();
//		repaint();
		if(shapes.size()>0)
			{
			for(int i=0; i<shapes.size(); i++)
				{	
					shapes.get(i).draw(getGraphics());
				}
			paintComponent();
			}
		refresh();
//		paintComponent();
		
		// amy be for each draw
		
	}

	//sort of working
	class Clicker extends MouseAdapter 
	{
		DShape move;
		int x,y;
		int num;
		
		public void colorMe(Color color)
		{
			if(ObjSelected.getnum()!=-1)
			{
				System.out.println(ObjSelected.getnum());
				shapes.get(ObjSelected.getnum()).setColor(color);
				shapes.get(ObjSelected.getnum()).draw(getGraphics());
			}ObjSelected.setnum(-1);
		}
		
		public void thisMove(int n)
		{
			if(ObjSelected.getnum()>-1)
				swap(0,ObjSelected.getnum());
			else
				System.out.println("Do nothing moving here");
		}
		public void thisDelete()
		{
			System.out.println(ObjSelected.getnum());
			if(!(ObjSelected.getnum()<0))
				{
	  			delete(ObjSelected.getnum());
	  			ObjSelected.setnum(-1);
				}
		}
		
		@Override
		public void mouseClicked(MouseEvent me)
		{
		//	super.mouseClicked(me);
		//	boolean brk = false;
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			if(!(ObjSelected.getnum()<0)){

				System.out.println("Moving this: "+ObjSelected.getnum());
				move = shapes.get(ObjSelected.getnum());
				//super.mouseDragged(e);
				System.out.println(move+"Dragged!!!");
				int dx = e.getPoint().x - move.model.x;
				int dy = e.getPoint().y - move.model.y;
				dx = dx-10;
				dy = dy-10;
				move.model.x += dx;
				move.model.y += dy;
				// paintComponent();
				repaint(); 
				move.draw(getGraphics());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(!(ObjSelected.getnum()<0))
			{
				move = shapes.get(ObjSelected.getnum());
				for(DShape s: shapes)
				{
					s.draw(getGraphics());
				}			
				System.out.println(move.model);

			}	
		}


		@Override
		public void mouseExited(MouseEvent e) {}		@Override
		public void mousePressed(MouseEvent me) {//may be here?
			
			int count=shapes.size()-1;
			
			while(!(count<0))
			{
				System.out.println("****"+count+"****");
				DShape s = shapes.get(count);
//				System.out.println(count+"--------");
//				System.out.println(s);
				System.out.println(s.contains(me.getPoint()));
				ObjSelected.setnum(-1);
				if(s.contains(me.getPoint()))
				{ 						
					if(s instanceof DRect)
					{
						//num = count;
						ObjSelected.setnum(count);
						count = -1;
//						move = s;
					System.out.println("Drect clicked"+count);
					}
					else if(s instanceof DOval)
					{
						//num = count;
						ObjSelected.setnum(count);
						count = -1;
//						move = new DOval();
//						move = s;
						System.out.println("DOval clicked!"+count);
					}
					System.out.println(count);
//					brk = true;
				}
				count--;
			}
			System.out.println("move this obj number : "+ObjSelected.getnum());
			}	
		
		@Override
		public void mouseMoved(MouseEvent e) {}			@Override
		public void mouseEntered(MouseEvent e) {}
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
			  
	

