
import java.awt.Color;
import java.awt.Graphics;

public class DOval extends DShape{
	
//	public DOval()
//	{
//		super();
//	}
	
	Color color = Color.gray;
	public DOval(int x, int y,int height, int width, Color color)
	{
		//super(x,y,color);
		//super(x,y,height,width,color);		// who creates DShapeMode this or parent?
											// if parent then how instanceOf()?
		// OR 
		super.model= new DOvalModel(x,y,height,width,color);
	}
	public void setColor(Color c)
	{
		this.color = c;
		//draw(getGraphics());
	}
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(super.model.x,super.model.y,super.model.width,super.model.height);
	}

	
}