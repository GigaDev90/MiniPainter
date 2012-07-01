import java.awt.geom.Line2D;
import java.awt.geom.Point2D;



public class Line extends ShapeP{

	public Line() {
		shape = new Line2D.Double();
		NShape = 3;
		points = new Point2D[2];
		draw = new  DrawBorder();
		scale = 0;
		drag = true;
		select = true;
	}
	@Override
	public void makeShape() {
		
		((Line2D) shape).setLine(points[0], points[1]);
		
	}
	@Override
	public void setFirstPoint(Point2D p) {
		points[0] = p;
		points[1] = new Point2D.Double(p.getX()+scale,p.getY()+scale);
		makeShape();
	}
	@Override
	public void setStile(int stile) {
		switch (stile) {
			case 0 : {
				draw = new DrawBorder();
			} break;
			case 1 : {
				draw = new DrawBorder();
			} break;
			case 2 : {
				draw = new DrawWhiteBorder();
			}
		}
	}


}
