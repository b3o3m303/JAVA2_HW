package ½Ò°ó½m²ß;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class cal extends JFrame {
    private JButton jb[] = new JButton[12];

    private Container cp;

    private JPasswordField jpf = new JPasswordField();

    private String btnLabel[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "." };

    private JCheckBox jcb = new JCheckBox("Show password");

    private JPanel jp = new JPanel();

    cal() {
        initComp();
    }

    private void initComp() {
        this.setBounds(100, 100, 200, 400);
        this.setLayout(new GridLayout(4, 3, 5, 5));
        cp = this.getContentPane();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Random ran = new Random();
        jp.setLayout(new GridLayout(4, 3, 5, 5));
        jpf.setBackground(Color.pink);
        jpf.setEditable(false);
        cp.add(jpf, BorderLayout.NORTH);
        cp.add(jp, BorderLayout.CENTER);
        cp.add(jcb, BorderLayout.SOUTH);
        int i = 0;
        int val[] = new int[11];
        while (i < 11) {
            val[i] = ran.nextInt(11);
            boolean flag = true;
            int j = 0;
            while (j < i) {
                if (val[i] == val[j]) {
                    flag = false;
                    j = i;
                }
                j++;
            }
            if (flag) {
                i++;
            }
        }
        for (i = 0; i < 11; i++) {
            jb[i] = new JButton(btnLabel[val[i]]);
            jb[i].addActionListener(new BtnAction());
            jp.add(jb[i]);
        }
        jb[11] = new JButton("Exit");
        jp.add(jb[11]);
        jb[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        jcb.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                JCheckBox jcbTemp = (JCheckBox) ie.getSource();
                if (jcbTemp.isSelected()) {
                    jpf.setEchoChar((char) 0);
                } else {
                    jpf.setEchoChar('*');
                }
            }
        });
    }

    class BtnAction implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JButton jbtnTmp = (JButton) ae.getSource();
            jpf.setText(jpf.getText() + jbtnTmp.getText());
        }
    }
}