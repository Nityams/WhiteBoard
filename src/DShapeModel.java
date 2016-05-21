import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DShapeModel {
	int x, y, height, width;
	Color color;
//	Shape mine; 

	public DShapeModel() {
		x = 0;
		y = 0;
		height = 0;
		width = 0;
		color = color.gray;

	}

	public DShapeModel(int x, int y, int height, int width, Color color) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
	}

	public DShapeModel getDimn() {
		return this; // or new DShapeModel(with params)
	}
	
//	public void mine(Class cla)
//	{
//		if(cla.getName().equals("DRectModel"))
//		{
//			mine = new Rectangle2D.Double(x,y,height,width);
//			System.out.println("Rect2d created"+ x+","+ y+","+ height+","+ width);
//		}
//		else if (cla.getName().equals("DOvalModel"))
//		{
//			mine = new Ellipse2D.Double(x, y, height, width);
//			System.out.println("Oval 2D created"+ x+","+ y+","+ height+","+ width);
//		}
//		else
//			System.out.println("mine error");
//	}

	// add by vic
	public int getX() {
		return x;
	}

	// add by vic
	public int getY() {
		return y;
	}

	// add by vic
	public int getWidth() {
		return width;
	}

	// add by vic
	public int getHeight() {
		return height;
	}

	// add by vic
	public Object[] getArray() {
		Object[] array = { x, y, height, width };
		return array;
	}
	public boolean contains(Point pnt)
	{//System.out.println("Bounds:"+mine.getBounds2D());
		if(pnt.x>=this.x && pnt.x<(this.x+this.width))
		{
			if(pnt.y>=this.y && pnt.y<(this.y+this.height))
				return true;
		}
		return false;
		
		//return mine.contains(pnt);
	}
}
