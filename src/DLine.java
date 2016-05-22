import java.awt.Graphics;
import java.awt.Point;

public class DLine extends DShape{

		DLineModel line ;
		
		public DLine(Point p1, Point p2)
		{
			line = new DLineModel(p1,p2);
			super.model = new DLineModel(p1,p2);
		}
		
		public void draw(Graphics g)
		{
			line.draw(g);
			System.out.println("line called");
		}
		
		Point getp1()
		{
			return line.getP1();
		}
		Point getp2()
		{
			return line.getP2();
		}
		void setp1(Point p1)
		{
			line.setP1(p1);
			
		}
		void setp2(Point p2)
		{
			line.setP1(p2);
		}
		
}
