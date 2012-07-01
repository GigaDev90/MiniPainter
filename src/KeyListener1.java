import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;


public class KeyListener1 extends Observable implements KeyListener {
	//creo l'istanza della classe statica che verrà ritornata a chi la chiede
	public static KeyListener1 listener = new KeyListener1();
	//il costruttore è privato per avere un controllo sulle istanze della classe
	private KeyListener1() {
		this.addObserver(Jframe.getFrame().getPaint());
		this.myKeyboardEventManager();
	}
	public static KeyListener1 getKeyListener() {
		return listener;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		//setta le modifiche e notifica l'osservatore
		this.setChanged();
		this.notifyObservers(arg0);

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		this.setChanged();
		this.notifyObservers(arg0);
	}
	//metodo particolare per evitare che la tastiera si disattivi
	public void myKeyboardEventManager() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
				new KeyEventDispatcher() {

					public boolean dispatchKeyEvent(KeyEvent e) {

						keyPressed(e);

						return false;
					}
				});
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
