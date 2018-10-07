import java.io.*;
import java.net.*;

public class Client extends Thread {
	private PrintStream outStream;
	private BufferedReader inStream;
	private Socket socket;
	private CFrame cfrm;

	public Client(CFrame clientFrame) {
		this.setDaemon(true);
		cfrm = clientFrame;

	}

	public void run() {
		try {
			socket = new Socket(cfrm.getIP(), 1723);
			outStream = new PrintStream(socket.getOutputStream());
			inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			send2client("client Connect");
			String str = "";
			while (!(str = inStream.readLine()).equals("")) {
				cfrm.addMsg(str);
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

	public void closeSocket() {
		try {
			inStream.close();
			socket.close();
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "error" + e.toString());

		}
	}
}
