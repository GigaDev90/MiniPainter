import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Rectangle extends ShapeP{

	public Rectangle() {
		shape = new Rectangle2D.Double();
		NShape = 2;
		points = new Point2D[2];
		draw = new  DrawBorder();
		scale = 0;
		drag = true;
		select = true;
	}
	@Override
	public void makeShape() {
		((Rectangle2D.Double)shape).setFrameFromDiagonal(points[0], points[1]);
		
	}
	@Override
	public void setFirstPoint(Point2D p) {
		points[0] = p;
		points[1] = new Point2D.Double(p.getX()+scale, p.getY()+scale);
		makeShape();
	}


}
