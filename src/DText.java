import java.awt.*;

public class DText extends DShape {
	UI view;
	static DTextModel model ;
	
	public DText(String input)
	{
		model = new DTextModel(input);	
		model.setInput(input);
	}
	public DText(String input,Font font)
	{
		model = new DTextModel(input);	
		model.setInput(input);
		model.setFont(font);
	}
	public void draw(Graphics g){
		Graphics2D graphic = (Graphics2D) g;
		int x=100;
		int y=100;
		graphic.setColor(Color.black);
		graphic.drawString(model.getInput(), x, y);
	}

	public void setColor(Color c){
		model.setColor(c);
	}
	public Color getColor(){
		return model.getColor();
	}
	public static void setFont(Font font){
		model.setFont(font);
	}
	public Font getFont(){
		return model.getFont();
	}


}
