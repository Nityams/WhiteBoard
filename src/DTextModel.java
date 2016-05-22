import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class DTextModel extends DShapeModel {
	String input = null;
	Color color = null;
	Font font = null;

	public DTextModel(String input) {
		super();
		setInput(input);
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Font getFont() {
		return font;
	}
}
