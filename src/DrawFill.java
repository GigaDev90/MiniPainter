import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;


public class DrawFill extends Draw{

	
	@Override
	public void draw(Shape p, Graphics2D g, Color c) {
		g.setColor(c);
		g.fill(p);		
	}

}
