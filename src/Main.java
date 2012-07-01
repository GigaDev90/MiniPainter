import javax.swing.JFrame;


public class Main {
	public static void main(String[]args) {
		CreatorFrame creator = new CreatorFrame1();
		Jframe frame = creator.createJframe();
		creator.createAndSetListener();
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
	}
}
