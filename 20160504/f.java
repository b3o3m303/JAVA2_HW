import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class f extends JFrame {
	private Container cp;
	private Container jifcp;
	private JScrollPane jsp;
	private JPanel jpnt;
	private JButton jbt1 = new JButton("Conn.DB");
	private JButton jbt2 = new JButton("Show data");
	private JButton jbt3 = new JButton("Exit");
	private JDesktopPane jdp = new JDesktopPane();
	private DBConnection dbconn;
	private JInternalFrame jif1;
	private ResultSet rs;
	private ResultSetMetaData meta;
	private JTextArea jta = new JTextArea();

	public f() {
		init();
	}

	private void init() {
		cp = getContentPane();
		setBounds(200, 100, 600, 600);
		cp.setLayout(new BorderLayout(3, 3));
		jpnt = new JPanel(new GridLayout(1, 4, 3, 3));
		cp.add(jpnt, BorderLayout.NORTH);
		cp.add(jdp, BorderLayout.CENTER);
		jpnt.add(jbt1);
		jbt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dbconnection();
				if (dbconn != null) {
					jif1 = new JInternalFrame("DB connected");
					jifcp = jif1.getContentPane();
					jif1.setBounds(0, 0, 400, 300);
					jdp.add(jif1);
					jif1.setVisible(true);
				}
			}
		});
		jpnt.add(jbt2);
		jbt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showData();
			}
		});
		jpnt.add(jbt3);
		jbt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
	}

	private void dbconnection() {
		dbconn = new DBConnection(this, "csieadm", "c8ie6lo1");

	}

	private void showData() {
		try {
			rs = dbconn.getData();
			int colCount = 0;
			if (rs != null) {
				jsp = new JScrollPane(jta);
				meta = rs.getMetaData();
				colCount = meta.getColumnCount();
				while (rs.next()) {
					String[] record = new String[colCount];
					for (int i = 0; i < colCount; i++) {
						record[i] = rs.getString(i + 1);
						jta.append(record[i] + "\t");
					}
					jta.append("\n");
				}
				jifcp.add(jsp);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	
}
