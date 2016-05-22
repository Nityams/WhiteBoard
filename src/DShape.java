import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class DShape {

	int x;
	int y;
	Color color ;
	
	UI view;
	DShapeModel model ;
	
	void attachView(UI view) {
		this.view = view;
	}
	
	public DShape()
	{
		//model = new DShapeModel();
	}
	public DShape(int x, int y, Color c)
	{
		this.x = x; this.y = y; color = c;
	}
	public DShape(Point x, Point y)
	{
		model = new DShapeModel(x,y);
	}
	public DShape(int x, int y,int height, int width, Color color)
	{
		model = new DShapeModel(x,y,height,width,this.color);	
	}
	
	public void draw(Graphics g)
	{
		System.out.println("Parent called");
		
	}
	
	//Added by Vic
	public Object[] getArray(){
		
		return model.getArray();
	}
	public void setColor(Color c)
	{
		color = c;
	}
	public boolean contains(Point pnt)
	{
		return model.contains(pnt);
	}
	
	int getX()
	{
		return model.getX();
	}
	int getY()
	{
		return model.getY();
	}
	int getHeight()
	{
		return model.getHeight();
	}
	int getWidth()
	{
		return model.getWidth();
	}

}
