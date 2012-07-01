
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;


public class Curve extends ShapeP{

	public Curve() {
		shape = new QuadCurve2D.Double(); 
		NShape = 8;
		points = new Point2D[3];
		draw = new  DrawBorder();
		scale = 0;
		drag = true;
		select = true;
	}
	@Override
	public void makeShape() {
		((QuadCurve2D.Double)shape).setCurve(points[0], points[2], points[1]);
	}
	@Override
	public void setFirstPoint(Point2D p) {
		points[0] = p;
		points[1] = new Point2D.Double(p.getX()+scale,p.getY()+scale);
		points[2] = new Point2D.Double(p.getX()-scale, p.getY()-scale);
		((QuadCurve2D.Double)shape).setCurve(points[0], points[1], points[2]);
		
	}

}
