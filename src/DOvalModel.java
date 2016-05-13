import java.awt.Color;

public class DOvalModel extends DShapeModel {
	
	

	public DOvalModel(int x, int y, int height, int width, Color color) {
		// TODO Auto-generated constructor stub
		
			super(x,y,height,width,color);
		
		
	}

	public DShapeModel getDimn()
	{
		// or return this?
		return super.getDimn(); // or new DShapeModel(with params)
	}
}
