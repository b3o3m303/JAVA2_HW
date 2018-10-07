package 課堂練習;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class text extends JFrame {
    
    private MenuBar meb = new MenuBar();
    private Menu menuf = new Menu("File");
    private Menu menuh = new Menu("Help");
    private Choice chall = new Choice();
    private Choice chst = new Choice();
    private Choice chsize = new Choice();
    private MenuItem Mopen = new MenuItem("Open");
    private MenuItem Msave = new MenuItem("Save");
    private MenuItem Mexit = new MenuItem("Exit");
    private MenuItem ha = new MenuItem("About");
    private Dialog dlg;
    private FileDialog fDialog;
    private Button dlgbut = new Button("OK");
    private Label dlglab = new Label(" 1fwef1332 ");
    private JTextArea ta = new JTextArea();
    private String fontnane[] = { "新細明體", "微軟正黑體", "標楷體" };
    private Panel pa = new Panel();
    public text() {
        initComp();
    }
    private void initComp() {
        this.setBounds(10, 10, 500, 400);
        this.setLayout(new BorderLayout(5, 5));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ae) {
                System.exit(0);
            }
        });

        pa.setLayout(new GridLayout(1, 3, 5, 5));
        for (int i = 0; i < fontnane.length; i++) {
            chall.addItem(fontnane[i]);

        }
        chall.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                setJTafont();
            }
        });
        chst.addItem("無");
        chst.addItem("粗體");
        chst.addItem("斜體");
        chst.addItem("粗斜體");
        chst.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                setJTafont();
            }
        });
        for (int i = 12; i < 41; i++) {
            chsize.addItem(Integer.toString(i));
        }
        chsize.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                setJTafont();
            }
        });
        pa.add(chall);
        pa.add(chst);
        pa.add(chsize);
        this.add(pa, BorderLayout.NORTH);
        dlg = new Dialog(this);
        dlg.setBounds(this.getX() + 50, this.getY() + 50, 200, 300);
        dlg.setLayout(new BorderLayout(10, 10));
        dlglab.setSize(new Dimension(100, 100));
        dlgbut.setSize(new Dimension(50, 50));
        dlg.add(dlglab, BorderLayout.CENTER);
        dlg.add(dlgbut, BorderLayout.NORTH);
        dlg.addWindowListener(new WindowAdapter() {
            public void windowClosing(Window ae) {
                dlg.setVisible(false);
               
            }
        });
        dlgbut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent aw) {
                dlg.setVisible(false);
            }
        });
        this.add(ta, BorderLayout.CENTER);
        fDialog = new FileDialog(this);
        this.setMenuBar(meb);
        meb.add(menuf);
        meb.add(menuh);
        menuf.add(Mopen);
        menuf.add(Msave);
        menuf.add(Mexit);
        meb.add(menuh);
        menuh.add(ha);
        Mexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        Mopen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                fDialog.setVisible(true);
                String fileName = fDialog.getDirectory() + fDialog.getFile();
                try {
                    FileInputStream fi = new FileInputStream(fileName);
                    byte data[] = new byte[fi.available()];
                    fi.read(data);
                    ta.setText(new String(data));
                    fi.close();
                } catch (IOException ioe) {
                    dlglab.setText("開啟" + fDialog.getFile() + "錯誤");
                    dlg.setVisible(true);
                }
            }
        });
        Msave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                fDialog.setVisible(true);
                String fileName = fDialog.getDirectory() + fDialog.getFile();
                try {
                    FileOutputStream fo = new FileOutputStream(fileName);
                    byte data[] = ta.getText().getBytes();
                    fo.write(data);
                    fo.close();
                } catch (IOException ioe) {
                    dlglab.setText("寫入" + fDialog.getFile() + "錯誤");
                    dlg.setVisible(true);
                }
            }
        });
        ha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dlg.setVisible(true);
                dlglab.setText(" 1989879 ");
            }
        });
    }
    public void setJTafont() {
        String str = chall.getSelectedItem();
        int sty = 0;
        switch (chst.getSelectedIndex()) {
        case 0:
            sty = Font.PLAIN;
            break;
        case 1:
            sty = Font.BOLD;
            break;
        case 2:
            sty = Font.ITALIC;
            break;
        case 3:
            sty = Font.BOLD + Font.ITALIC;
            break;
        }
        ta.setFont(new Font(str, sty, Integer.parseInt(chsize.getSelectedItem())));
    }
}
