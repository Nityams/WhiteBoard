import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DShape {

	int x;
	int y;
	Color color;
	
	DShapeModel model ;
	
	public DShape()
	{
		model = new DShapeModel();
	}
	// may need to clear the list if all the elements in the list has 0 dimensions
	public DShape(int x, int y, Color c)
	{
		this.x = x; this.y = y; color = c;
	}
	public DShape(int x, int y,int height, int width, Color color)
	{
		model = new DShapeModel(x,y,height,width,color);	
	}
	
	public void draw(Graphics g)
	{
		System.out.println("Parent called");
	}
	
	//Added by Vic
	public Object[] getArray(){
		return model.getArray();
	}
}
