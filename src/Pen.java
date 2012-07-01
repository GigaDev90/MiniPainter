import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class Pen extends ShapeP{
	
	public  Pen() {
		points = new Point2D[2];
		drag = false;
		shape = new Line2D.Double();
		select = false;
		draw = new DrawBorder();
		NShape = 7;
	}
	
	public Shape getShape() {
		return shape;
	}
	@Override
	public void setFirstPoint(Point2D p) {
			points[0] = p;
	}
	@Override
	public void makeShape() {
		((Line2D) shape).setLine(points[0],points[1]);
		
	}
	@Override
	public void setPoints(Point2D point,int i) {
		points[i] = point;
		makeShape();
		
	}
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
