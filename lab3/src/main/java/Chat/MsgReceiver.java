package Chat;

public class MsgReceiver extends Thread {
    NetworkHandler networkHandler;

    MsgReceiver(NetworkHandler networkHandler) {
        this.networkHandler = networkHandler;
    }

    public void run() {
        while(!interrupted()) {
            System.out.println(networkHandler.checkMessages());
        }
    }
}
