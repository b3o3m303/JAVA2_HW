import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class EX1 extends JFrame {
	String data[]={"◤","◣","◥","◢"};
	JPanel jp=new JPanel();
	JLabel note=new  JLabel("顯示字",SwingConstants.RIGHT);
	JLabel h=new JLabel("高度",SwingConstants.RIGHT);
	JButton run=new JButton("Run");
	JComboBox jc=new JComboBox(data);
	JTextArea ta=new JTextArea();
	JTextField tb=new JTextField();
	JTextField te=new JTextField();
	
	public EX1() {
		init();
	}

	public void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(20,20,300,400);
		this.add(jp,BorderLayout.NORTH);
		//		note.setSize(30,30);
		jp.setLayout(new GridLayout(2,3,5,5));
		jp.add(note);
		jp.add(tb);
		jp.add(jc);
		jp.add(h);
		jp.add(te);
		jp.add(run);
	this.add(ta,BorderLayout.CENTER);
	}



}
