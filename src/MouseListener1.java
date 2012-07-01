import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;


public class MouseListener1 extends Observable implements MouseListener {

	public static MouseListener1 listener = new MouseListener1();
	private MouseListener1() {
		this.addObserver(Jframe.getFrame().getPaint());
	}
	public static MouseListener1 getMouseListener() {
		return listener;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		this.setChanged();
		this.notifyObservers(arg0);
		
	}

	@Override//metodi non utilizzati
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.setChanged();
		this.notifyObservers(arg0);
		
	}

}
