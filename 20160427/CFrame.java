import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CFrame extends JFrame {

	private JButton jbexit = new JButton("exit");
	private JButton jbstart = new JButton("Connect");
	private JButton jbsend = new JButton("send");
	private JTextArea jta = new JTextArea();
	private JTextArea jtashow = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JScrollPane jspout = new JScrollPane(jtashow);
	private JPanel jbut = new JPanel(new BorderLayout(3, 3));
	private JPanel jpnFuntion = new JPanel(new GridLayout(7, 1, 5, 5));
	private JLabel jip = new JLabel("IP");
	private JTextField jtfip = new JTextField("127.0.0.1");
	private Container cp;
	private Client client;

	public CFrame() {
		init();
	}

	public void init() {
		this.setBounds(600, 100, 300, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Client");
		cp = getContentPane();
		cp.setLayout(new BorderLayout(5, 5));
		client = new Client(CFrame.this);
		jbstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (((JButton) ae.getSource()).getText().equals("Connect")) {
					client.start();
					((JButton) ae.getSource()).setText("Disconnect");
				} else {
					client.closeSocket();
					((JButton) ae.getSource()).setText("Connect");
				}
			}
		});
		jbexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		jbsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				client.send2client(jtashow.getText());
				jta.append("clicent:" + jtashow.getText() + "\n");
				jtashow.setText("");
			}
		});
		jta.setBackground(Color.yellow);
		jta.setFont(new Font(null, Font.PLAIN, 24));
		jta.setEditable(false);
		jpnFuntion.add(jip);
		jpnFuntion.add(jtfip);
		jpnFuntion.add(jbstart);
		jpnFuntion.add(jbexit);
		jbsend.setPreferredSize(new Dimension(85, 65));
		jbut.add(jspout, BorderLayout.CENTER);
		jbut.add(jbsend, BorderLayout.EAST);
		cp.add(jsp, BorderLayout.CENTER) ;
		cp.add(jpnFuntion, BorderLayout.EAST);
		cp.add(jbut, BorderLayout.SOUTH);
	}

	public void addMsg(String in) {
		jta.append("Server:" + in + "\n");
	}

	public String getIP() {
		return jtfip.getText();
	}

	public static void main(String[] args) {
		CFrame main = new CFrame();
		main.setVisible(true);
	}

}
