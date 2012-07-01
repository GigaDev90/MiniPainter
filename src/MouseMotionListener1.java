import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Observable;


public class MouseMotionListener1 extends Observable implements MouseMotionListener {
	public static MouseMotionListener1 listener = new MouseMotionListener1();
	private MouseMotionListener1() {
		this.addObserver(Jframe.getFrame().getPaint());
	}
	public static MouseMotionListener1 getMouseMotionListener() {
		return listener;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		this.setChanged();
		this.notifyObservers(arg0);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}

}
