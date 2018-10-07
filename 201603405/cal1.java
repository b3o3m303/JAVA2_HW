package �@�~;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class cal1 extends Frame {
    private static Frame frm = new Frame("�p��L");
    private static Panel pn1 = new Panel(new GridLayout(4, 3));
    private static Panel pn2 = new Panel(new GridLayout(5, 1));
    private static Label lab = new Label("0", Label.RIGHT);
    private static Button cn, ad, sub, mul, div, amo;
    private static Button digits[] = new Button[10];
    private static long num;// �s�񵲪G
    private static byte op;// �N��B��l
    public static void main(String args[]) {
        frm.setLayout(null);
        frm.setBounds(450, 250, 160, 180);
        frm.setResizable(false);
        lab.setBounds(20, 30, 120, 20);
        lab.setBackground(new Color(240, 220, 190));
        pn1.setBounds(20, 60, 90, 105);
        pn2.setBounds(110, 60, 30, 105);
        // 0~9�Ʀr�s
        for (int i = 9; i >= 0; i--) {
            digits[i] = new Button(Integer.toString(i));
            pn1.add(digits[i]);
            digits[i].addActionListener(new ActLis());
        }
        // �M���s
        cn = new Button("C");
        pn1.add(cn);
        cn.addActionListener(new ActLis());
        // ����s
        amo = new Button("=");
        pn1.add(amo);
        amo.addActionListener(new ActLis());
        // �[�s
        ad = new Button("+");
        pn2.add(ad);
        ad.addActionListener(new ActLis());
        // ��s
        sub = new Button("-");
        pn2.add(sub);
        sub.addActionListener(new ActLis());
        // ���s
        mul = new Button("*");
        pn2.add(mul);
        mul.addActionListener(new ActLis());
        // ���s
        div = new Button("/");
        pn2.add(div);
        div.addActionListener(new ActLis());

        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frm.add(lab);
        frm.add(pn1);
        frm.add(pn2);
        frm.setVisible(true);
    }

    
    
    
    public static class ActLis implements ActionListener {
        public void actionPerformed(ActionEvent e)
                throws NumberFormatException, ArithmeticException {
            long result;// �s��Ѧr���ন���ƭ�
            Button btn = (Button) e.getSource();
            try {
                // �B�z�ƭ�1-9
                for (int i = 0; i <= 9; i++) {
                    if (btn == digits[i]) {
                        output_digit(digits[i]);
                        break;
                    }
                }
                if (btn == cn) {
                    result = 0L;// ���x�s�����G�k0
                    num = 0L;
                    op = 0;
                    lab.setText(Long.toString(num));
                } else if (btn == ad) {// �[
                    save_num(ad);
                    op = 1;
                } else if (btn == sub) {// ��
                    save_num(sub);
                    op = 2;
                } else if (btn == mul) {// ��
                    save_num(mul);
                    op = 3;
                } else if (btn == div) {// ��
                    save_num(div);
                    op = 4;
                } else if (btn == amo) {
                    result = Long.parseLong(lab.getText());

                    switch (op) {
                    case 1:
                        num += result;
                        break;
                    case 2:
                        num -= result;
                        break;
                    case 3:
                        num *= result;
                        break;
                    case 4:
                        num /= result;
                        break;
                    default:
                    }
                    result = 0L;
                    // ��X�B��᪺���G����ܾ�
                    lab.setText(Long.toString(num));
                }
            } catch (NumberFormatException ne) {
                // �����ҥ~
            } catch (ArithmeticException ae) {
                // �����Q���ƬO�s���ҥ~
            }
        }
        // ��X�ƭȨ���ܾ�
        private void output_digit(Button btn) {
            lab.setText(Long
                    .toString(Long.parseLong(lab.getText() + btn.getLabel())));
        }
        // ��Ĥ@�ռƭ��x�s�_��
        private void save_num(Button oper) {
            num = Long.parseLong(lab.getText());
            lab.setText(Long.toString(0L));
        }
    }
}