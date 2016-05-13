import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DRect extends DShape{
	public DRect()
{
	super();
}

public DRect(int x, int y,int height, int width, Color color)
{
	super(x,y,color);
	//super(x,y,height,width,color);		// who creates DShapeMode this or parent?
										// if parent then how instanceOf()?
	// OR 
	super.model= new DRectModel(x,y,height,width,color);
	new Rectangle(x,y,height,width);
}

public void draw(Graphics g)
{
	g.setColor(super.model.color);
	g.drawRect(super.model.x,super.model.y,super.model.width,super.model.height);
}

	
}
