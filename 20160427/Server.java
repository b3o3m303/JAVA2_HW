import java.io.*;
import java.net.*;

public class Server extends Thread {
	private InetAddress ipAdr;
	private Socket socket;
	private ServerSocket sSocket;
	private PrintStream outStream;
	private BufferedReader inStream;
	private sFrame sFrm;

	public Server(sFrame serverFrm) {
		sFrm = serverFrm;
		try {
			ipAdr = InetAddress.getLocalHost();
			sSocket = new ServerSocket(1723);

		} catch (UnknownHostException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "error" + e.toString());
		} catch (IOException ioe) {
			javax.swing.JOptionPane.showMessageDialog(null, "error" + ioe.toString());
		}
	}

	public void run() {
		try {
			socket = sSocket.accept();
			outStream = new PrintStream(socket.getOutputStream());
			inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			send2client("Connect");
			String str = "";
			while (!(str = inStream.readLine()).equals("")) {
				sFrm.addMsg(str);
			}
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "error" + e.toString());
		}
	}

	public void send2client(String msg) {
		try {
			if (outStream != null) {
				outStream.println(msg);

			} else {
				javax.swing.JOptionPane.showMessageDialog(null, "error,please make connection with Client first");
			}
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "error" + e.toString());

		}
	}
}
