package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NetworkHandler {

    private ServerSocket ss;
    private int port;
    private final String name;
    private static final int min_port_num = 5000;
    private static final int max_port_num = 5200;
    private final HashMap<String, Integer> nameToPortMap = new HashMap<>();

    public NetworkHandler(String name) {
        this.name = name;
        for (int i = min_port_num; i < max_port_num; i++) {
            try {
                ss = new ServerSocket(i);
                port = i;
                break;
            } catch (IOException e) {
            }
        }
    }

    public int getPort() {
        return port;
    }

    public void broadcast(String text, String prefix) {
        for (int i = min_port_num; i < max_port_num; i++) {
            if (i == port) {
                continue;
            }
            try {
                sendMessage(i, prefix + " " + text);
            } catch (IOException e) {

            }
        }
    }

    public void broadcast(String text) {
        broadcast(text, "b");
    }

    private void sendMessage(int port, String text) throws IOException {
        Socket send_s = new Socket("127.0.0.1", port);
        DataOutputStream dout = new DataOutputStream(send_s.getOutputStream());
        dout.writeUTF(text);
    }

    public void sendPrivateMessage(String targetName, String msg) {
        try {
            if (nameToPortMap.get(targetName) != null) {
                sendMessage(nameToPortMap.get(targetName), "m from: " + name + "; " + msg);
            } else {
                System.out.println("no such user");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastWelcomeMessage() {
        broadcast(port + " " + name, "n");
    }

    private void ansToWelcome(int destPort) {
        try {
            sendMessage(destPort, "a " + port + " " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastGoodbyeMessage() {
        broadcast("g " + port + " " + name);
    }

    public String checkMessages() {
        try {
            Socket recv_s = ss.accept();
            DataInputStream din = new DataInputStream(recv_s.getInputStream());
            String msg = din.readUTF();
            recv_s.getInputStream().close();
            recv_s.close();
            if (msg.charAt(0) == 'n' || msg.charAt(0) == 'a') {
                return handleNewUser(msg);
            }
            if (msg.charAt(0) == 'm') {
                char[] msgCht = msg.toCharArray();
                msgCht[0] = ' ';
                return "new message" + new String(msgCht);
            }
            if (msg.charAt(0) == 'g') {
                char[] msgCht = msg.toCharArray();
                msgCht[0] = ' ';
                char[] nameCht = new char[50];
                String name = getNameFromCht(msg, nameCht);
                System.out.println(name);
                nameToPortMap.remove(name);
                return name + " left the chat";
            }
            if (msg.charAt(0) == 'b') {
                return "broadcast msg received: " + msg.substring(1);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getNameFromCht(String msg, char[] nameCht) {
        msg.getChars(7, msg.length(), nameCht, 0);
        StringBuilder nameStrB = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            if (nameCht[i] == 0) {
                break;
            }
            nameStrB.append(nameCht[i]);
        }
        return nameStrB.toString();
    }

    public String getActiveUsers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : nameToPortMap.keySet()) {
            stringBuilder.append(name).append("\n");
        }
        return stringBuilder.toString();
    }

    private String handleNewUser(String msg) {
        char[] portCht = new char[4];
        char[] nameCht = new char[50];
        msg.getChars(2, 6, portCht, 0);
        String name = getNameFromCht(msg, nameCht);
        int newUserPort = Integer.parseInt(String.valueOf(portCht));
        nameToPortMap.put(name, newUserPort);
        if (msg.charAt(0) == 'n') {
            ansToWelcome(newUserPort);
        }
        return ("new guy! " + name + " " + newUserPort);
    }
}
