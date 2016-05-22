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
	
	// add by vic
	public int getX() {
		return x;
	}
	public void setX(int x){
		this.x = x;
	}

	// add by vic
	public int getY() {
		return y;
	}
	public void setY(int y){
		this.y = y;
	}

	// add by vic
	public int getWidth() {
		return width;
	}
	public void setWidth(int width){
		this.width = width;
	}

	// add by vic
	public int getHeight() {
		return height;
	}
	public void setHeight(int height){
		this.height = height;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
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
	
	@Override
	public String toString()
	{
		return Integer.toString(x)+","+Integer.toString(y)+","+Integer.toString(width)+","+Integer.toString(height)+ this.color.toString() ;
	}
}
