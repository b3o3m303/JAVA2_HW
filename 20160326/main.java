import java.awt.*;
import java.awt.event.*;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame a = new MainFrame();
		a.setVisible(true);
	}
}

class MainFrame extends Frame {

	private Label b = new Label("104021043,Â²¯À§g");

	public MainFrame() {
		init();
	}

	private void init() {
		this.setLocation(249, 135);
		this.setSize(500, 400);
		this.setLayout(null);
		b.setLocation(250, 150);
		b.setSize(150, 30);
		b.setBackground(new Color(254, 100, 9));
		this.add(b);

		//
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				System.exit(0);
			}
		});
		//
		this.setBackground(Color.green);
	}

}