

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
public class serverend extends Thread {
    private ServerSocket sSk;

    private Socket sk;

    private BufferedReader inStream;

    private PrintStream outStream;

    private InetAddress ipAd;

    private serverF���� sFrm;

    public serverend(serverF���� serverF����) {
        sFrm = serverF����;

        try {
            sSk = new ServerSocket(1823);
            ipAd = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error" + e.toString());
        } catch (IOException ioe) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error" + ioe.toString());
        }
    }

    public void run() {
        try {
            sk = sSk.accept();
            outStream = new PrintStream(sk.getOutputStream());
            inStream = new BufferedReader(
                    new InputStreamReader(sk.getInputStream()));
            sendclient("�s�u���\");
            String str = "";

            while (!(str = inStream.readLine()).equals("")) {

            	if (str.charAt(0) == '$' && str.charAt(2) == '@') {
                    sFrm.playing(str);
                    sFrm.setGround(1);
                }
            	else if (str.equals("OK")) {
                    sFrm.replay();
                }
            	else if(str.equals("����A�o"))
                {
                    sFrm.setleb();
                }
            	else if(str.equals("@#comsgDialog")){
                	sFrm.msgDialog();
                }
            	else if(str.equals("@#afaYES")){
                	sFrm.replay();
                }else if(str.equals("@#afaNO")) {
                    sFrm.NO();
                }
            	else {
                    sFrm.addMsg(str);
                }
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showConfirmDialog(null,
                    "Error" + e.toString());
        }

    }

    public String getIP() {
        return ipAd.getHostAddress();
    }

    public void sendclient(String msg) {
        try {
            if (outStream != null) {
                if (msg.equals(null)) {
                    outStream.println(msg + " ");
                } else {
                    outStream.println(msg);
                }

            } else {
                javax.swing.JOptionPane.showConfirmDialog(null,
                        "Error:Please make connextion with frist!");
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showConfirmDialog(null, e.toString());
        }

    }

}