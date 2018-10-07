import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class sFrame extends JFrame {
	private JButton jbstart = new JButton("start");
	private JButton jbexit = new JButton("exit");
	private JButton jbsend = new JButton("send");
	private JTextArea jta = new JTextArea();
	private JTextArea jtaOut = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JScrollPane jspout = new JScrollPane(jtaOut);
	private JPanel jbut = new JPanel(new BorderLayout(5, 5));

	private JPanel jpnFuntion = new JPanel(new GridLayout(5, 1, 5, 5));
	private JLabel jlb = new JLabel("Status");
	private Container cp;
	private Server serv;

	public sFrame() {
		init();
	}

	public void init() {
		this.setBounds(200, 100, 300, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Server");
		cp = getContentPane();
		cp.setLayout(new BorderLayout(5, 5));
		jbstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				serv = new Server(sFrame.this);
				serv.start();
				jta.append("½Ðµyµ¥\n");
				((JButton) ae.getSource()).setEnabled(false);
			}
		});
		jbexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		jbsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				serv.send2client(jtaOut.getText());
				jta.append("Server:" + jtaOut.getText() + "\n");
				jtaOut.setText("");
			}
		});

		jta.setBackground(Color.green);
		jta.setFont(new Font(null, Font.PLAIN, 24));
		jlb.setIconTextGap(10);
		jlb.setHorizontalTextPosition(JLabel.LEFT);
		jta.setEditable(false);
		jbsend.setPreferredSize(new Dimension(65, 75));
		jbut.add(jspout, BorderLayout.CENTER);
		jbut.add(jbsend, BorderLayout.EAST);
		jpnFuntion.add(jbstart);
		jpnFuntion.add(jbexit);
		cp.add(jpnFuntion, BorderLayout.EAST);
		cp.add(jsp, BorderLayout.CENTER);
		cp.add(jbut, BorderLayout.SOUTH);
	}

	public void addMsg(String inStr) {
		jta.append("Client:" + inStr + "\n");

	}

	public static void main(String argv[]) {
		sFrame main = new sFrame();
		main.setVisible(true);
	}
}
