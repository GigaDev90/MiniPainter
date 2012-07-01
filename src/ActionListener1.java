import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;


public class ActionListener1 extends Observable implements ActionListener {
	
	public static ActionListener1 listener = new ActionListener1();
	
	private ActionListener1() {
		this.addObserver(Jframe.getFrame().getPaint());
	}
	public static ActionListener1 getActionListener() {
		return listener;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setChanged();
		this.notifyObservers(arg0);
	}

}
