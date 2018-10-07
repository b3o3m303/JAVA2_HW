package ½Ò°ó;

import java.awt.*;
import java.awt.event.*;

public class VI {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MainFrame a = new MainFrame();
        a.setVisible(true);
    }
}
class MainFrame extends Frame implements ActionListener {
    private int n = 0;
    private Button b = new Button("¥[");
    private Button c = new Button("´î");
    private Button d = new Button("EXIT");
    public MainFrame() {
        init();
    }
    private void init() {
        this.setLocation(249, 135);
        this.setSize(300, 400);
        this.setLayout(null);
        b.setLocation(20, 50);
        b.setSize(80, 150);
        c.setLocation(200, 50);
        c.setSize(80, 150);
        c.setBackground(Color.yellow);
        d.setLocation(64, 250);
        d.setSize(150, 30);
        b.setBackground(new Color(254, 100, 9));
        this.add(d);
        this.add(b);
        this.add(c);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });
        //
        d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        this.setBackground(Color.green);
        b.addActionListener(this);
        c.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if ((Button) ae.getSource() == b) {
            n++;
            this.setTitle("" + n);
        }
        if ((Button) ae.getSource() == c) {
            n--;
            this.setTitle("" + n);
        }
    }
}