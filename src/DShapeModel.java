import java.awt.Color;

public class DShapeModel {
	int x, y, height, width;
	Color color;

	public DShapeModel() {
		x = 0;
		y = 0;
		height = 0;
		width = 0;
		color = color.gray;

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

	// add by vic
	public int getY() {
		return y;
	}

	// add by vic
	public int getWidth() {
		return width;
	}

	// add by vic
	public int getHeight() {
		return height;
	}

	// add by vic
	public Object[] getArray() {
		Object[] array = { x, y, height, width };
		return array;
	}
}
