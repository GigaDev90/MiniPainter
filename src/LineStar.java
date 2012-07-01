import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;



public class LineStar extends ShapeP{
	private GeneralPath path;
	public LineStar() {
		shape = new Polygon();
		points = new Point2D[1];
		scale = 0;
		drag = false;
		select = false;
		draw = new DrawFill();
		NShape = 6;
		path = new GeneralPath();
	}
	@Override
	public void makeShape() {
		 double angolo=2*Math.PI/5;
	        int[] X=new int[5];
	        int[] Y=new int[5];
	        X[0]=(int)(Math.cos(-Math.PI/2)*scale/2);
	        Y[0]=(int)(Math.sin(-Math.PI/2)*scale/2);
	        X[1]=(int)(Math.cos(angolo*2-Math.PI/2)*scale/2);
	        Y[1]=(int)(Math.sin(angolo*2-Math.PI/2)*scale/2);
	        X[2]=(int)(Math.cos(angolo*4-Math.PI/2)*scale/2);
	        Y[2]=(int)(Math.sin(angolo*4-Math.PI/2)*scale/2);
	        X[3]=(int)(Math.cos(angolo-Math.PI/2)*scale/2);
	        Y[3]=(int)(Math.sin(angolo-Math.PI/2)*scale/2);
	        X[4]=(int)(Math.cos(angolo*3-Math.PI/2)*scale/2);
	        Y[4]=(int)(Math.sin(angolo*3-Math.PI/2)*scale/2);
	        shape=new Polygon(X,Y,5);
	        ((Polygon)shape).translate((int)points[0].getX(), (int)points[0].getY());
	        path = new GeneralPath(shape);
	        path.setWindingRule(GeneralPath.WIND_NON_ZERO);
	      
	}

	@Override
	public void draw(Graphics2D g2) {
		draw.draw(path, g2, c);
		
	}
	public boolean isSelect() {
		return false;
	}
	public void setFirstPoint(Point2D point) {
		points[0] = point;
		makeShape();
	}

}
