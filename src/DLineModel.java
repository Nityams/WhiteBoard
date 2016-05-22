import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class DLineModel extends DShapeModel{

	Point p1;
	Point p2;
	Color color = Color.gray;
	public DLineModel(Point p1, Point p2)
	{
		super(p1,p2);
		this.p1 = p1;
		this.p2 = p2;
		
	}
	
	void draw(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		int x1 = p1.x;
		int x2 = p2.x;
		int y1 = p1.y;
		int y2 = p2.y;
		g2d.drawLine(x1, y1, x2, y2);
		
	}
	
	Point getP1()
	{
		return p1;
	}
	Point getP2()
	{
		return p2;
	}
	void setP1(Point p1)
	{
		this.p1 = p1;
	}
	void setP2(Point p2)
	{
		this.p2 = p2;
	}
	
	public boolean contains(Point pn)
	{
		System.out.println("Line contains");
		return false;
	}


}
