package §@·~;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class calculator extends Frame {
    private Panel pn1 = new Panel(new GridLayout(4, 4));
    private Panel pn2 = new Panel(new GridLayout(5, 1));
    private Button cn = new Button("C");
    private Button dot = new Button(".");
    private Button ans = new Button("=");
    private Button div = new Button("/");
    private Button mul = new Button("*");
    private Button neg = new Button("-");
    private Button add = new Button("+");
    private Button num[] = new Button[10];
    private long re;// ¼È®É
    private char op;
    private Label lab = new Label("0",Label.RIGHT);
    public calculator() {
        cal();
    }

    private void cal() {
        this.setBackground(Color.white);
        this.setBounds(60, 50, 420, 400);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });
        pn1.setBounds(20, 70, 300, 105);
        pn2.setBounds(320, 68, 90, 107);
        lab.setBounds(20, 30, 390, 30);
        lab.setBackground(new Color(240, 220, 190));
        this.add(pn1);
        for (int i = 9; i >= 0; i--) {
            num[i] = new Button(Integer.toString(i));
            pn1.add(num[i]);
            num[i].addActionListener(new ActLis());
        }
        pn1.add(dot);
        dot.addActionListener(new ActLis());
        add.addActionListener(new ActLis());
        pn1.add(cn);
       cn.addActionListener(new ActLis()); pn2.add(add);
        pn2.add(neg);
        neg.addActionListener(new ActLis());
        pn2.add(mul);
        mul.addActionListener(new ActLis());
        pn2.add(div);
        pn2.add(ans);
        ans.addActionListener(new ActLis());
        this.add(pn2);
        this.add(lab);
        div.addActionListener(new ActLis());
    }
    public class ActLis implements ActionListener {
        public void actionPerformed(ActionEvent a)
                throws NumberFormatException, ArithmeticException {
            long result;
            Button btn = (Button) a.getSource();
            try {
                for (int i = 0; i <= 9; i++) {
                    if (btn == num[i]) {
                        output_digit(num[i]);
                        break;
                    }
                }
                if (btn == cn) {
                    result = 0L;
                    re = 0L;
                    op = 0;
                    lab.setText(Long.toString(re));
                } else if (btn == add) {// +
                    smun(add);
                    op = 1;
                } else if (btn == neg) {// -
                    smun(neg);
                    op = 2;
                } else if (btn == mul) {// *
                    smun(mul);
                    op = 3;
                } else if (btn == div) {// /
                    smun(div);
                    op = 4;
                }else if(btn==dot) {
                    smun(dot);
                    op=5;
                }
                else if (btn == ans) {// =
                    result = Long.parseLong(lab.getText());

                    switch (op) {
                    case 1:
                        re +=  result;
                        break;
                    case 2:
                        re -= result;
                        break;
                    case 3:
                        re *=  result;
                        break;
                    case 4:
                        re /=  result;
                        break;
//                    case 5:
//                        =result;
//                        dot=1;
//                        break;
                    default:
                    }
                    result = 0L;
                    lab.setText(Long.toString(re));
                }
            } catch (NumberFormatException ne) {

            } catch (ArithmeticException ae) {
            }
        }

        private void output_digit(Button btn) {
            lab.setText(Long.toString(Long.parseLong(lab.getText() + btn.getLabel())));
        }

        public void smun(Button oper) {
            re = Long.parseLong(lab.getText());
            lab.setText("");
        }
    }

}
