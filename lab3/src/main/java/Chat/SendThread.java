package Chat;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;

public class SendThread implements Runnable {
    int port;
    Socket s;
    DataInputStream din;
    DataOutput dout;
    LinkedBlockingDeque<String> q = new LinkedBlockingDeque<>();

    SendThread(int port) {

        this.port = port;
    }

    public void run() {

        while (true) {
            try {
                String ans = q.take();
                s = new Socket("127.0.0.1", port);
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF(ans);
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}
