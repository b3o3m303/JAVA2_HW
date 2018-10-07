
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Client extends Thread {
    private Socket socket;

    private InetAddress ipAd;

    private PrintStream outStream;
    private BufferedReader inStream;
    private CFrame cFrm;
    public Client(CFrame clientFrm) {
        this.setDaemon(true);
        cFrm = clientFrm;
    }
    public void run() {
        try {
            socket = new Socket(cFrm.getIP(), 1823);
            outStream = new PrintStream(socket.getOutputStream());
            inStream = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String str = "";
            send2client("連線成功");
            while (!(str = inStream.readLine()).equals("")) {
                if (str.charAt(0) == '$' && str.charAt(2) == '@') {
                    cFrm.playing(str);
                    cFrm.setGround(0);
                } 
                else if (str.equals("OK")) {
                    cFrm.replay();
                }
                else if(str.equals("輪到你囉"))
                {
                    cFrm.setleb();
                }
                else if(str.equals("@#comsgDialog")){
                	cFrm.msgDialog();
                }
                else if(str.equals("@#afaYES")){
                	cFrm.replay();
                }else if(str.equals("@#afaNO")) {
                    cFrm.NO();
                }
                else {
                    cFrm.addMsg(str);
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error" + e.toString());
        }
    }

    public void send2client(String msg) {
        try {
            if (outStream != null) {
                if (msg.equals(null)) {
                    outStream.println(msg + " ");
                } else {
                    outStream.println(msg);
                }

            } else {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Error, Please make connection with Client frist");
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error" + e.toString());
        }
    }

    public void closeSocket() {
        try {
            inStream.close();
            socket.close();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error" + e.toString());
        }
    }

}