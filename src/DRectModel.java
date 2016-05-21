import java.awt.Color;

public class DRectModel extends DShapeModel{

	
	public DRectModel(int x, int y, int height, int width, Color color) {
		super(x,y,height,width,color);
//		super.mine(this.getClass());
	}

	public DShapeModel getDimn()
	{
		return super.getDimn(); // or new DShapeModel(with params)
	}

}
