


public class CreatorFrame1 implements CreatorFrame {
	private Jframe frame = Jframe.getFrame();
	@Override
	public Jframe createJframe() {
		return frame;
	}

	@Override
	public void createAndSetListener() {
		frame.setActionListener(ActionListener1.getActionListener());
		frame.setKeyListener(KeyListener1.getKeyListener());
		frame.setMouseListener(MouseListener1.getMouseListener());
		frame.setMouseMotionListener(MouseMotionListener1.getMouseMotionListener());
	}

}
