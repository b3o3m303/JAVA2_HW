import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class e1 extends JFrame {
	JLabel id = new JLabel("ID :");
	JLabel pass = new JLabel("Password :");
	JTextField jt = new JTextField();
	JPasswordField jp = new JPasswordField();
	JButton OK = new JButton("OK");
	JButton Exit = new JButton("Exit");
	String user="user";
	String password="23323456";
	public e1() {
		init();
	}

	public void init() {
		this.setLayout(null);
		this.setBounds(20, 20, 300, 200);
		id.setBounds(50, 20, 60, 20);
		pass.setBounds(20, 60, 80, 20);
		jt.setBounds(90, 20, 100, 20);
		jp.setBounds(90, 60, 100, 20);
		Exit.setBounds(190, 100, 60, 20);
		OK.setBounds(50, 100, 60, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(id);
		this.add(pass);
		this.add(Exit);
		this.add(OK);
		this.add(jt);
		this.add(jp);

		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});// exitaction

		OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String pa = jp.getText();
				String na = jt.getText();
				if (na.equals(user) && pa.equals(password)) {
					
						EX1 m2 = new EX1();
						m2.setVisible(true);
						b();

				}
						else{System.out.println("¿ù»~");}
			}
		});
	}

	public void b() {
		this.setVisible(false);
	}

	public static void main(String[] args) {
		e1 x = new e1();
		x.setVisible(true);
	}

}
