import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DRect extends DShape{
	
	/*public DRect()
{
	super();
}*/

public DRect(int x, int y,int height, int width, Color color)
{
	super(x,y,color);
	//super(x,y,height,width,color);		// who creates DShapeMode this or parent?
										// if parent then how instanceOf()?   Vic: I think we need to ask to clearify
	// OR 
	super.model= new DRectModel(x,y,height,width,color);
	//new Rectangle(x,y,height,width);
}

public void draw(Graphics g)
{
	g.setColor(super.model.color);
	g.fillRect(super.model.x,super.model.y,super.model.width,super.model.height);
	
}


	
}
