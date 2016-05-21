import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DRect extends DShape{
	
	/*public DRect()
{
	super();
}*/

	Color color = Color.gray;
public DRect(int x, int y,int height, int width, Color color)
{
	//super(x,y,color);
	//super(x,y,height,width,color);		// who creates DShapeMode this or parent?
										// if parent then how instanceOf()?   Vic: I think we need to ask to clearify
	// OR 
	super.model= new DRectModel(x,y,height,width,color);
	//new Rectangle(x,y,height,width);
}

public void setColor(Color c)
{
	this.color = c;
	//draw(getGraphics());
}

public void draw(Graphics g)
{
	g.setColor(color);
	g.fillRect(super.model.x,super.model.y,super.model.width,super.model.height);
	
}


	
}
