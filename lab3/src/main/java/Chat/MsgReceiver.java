package Chat;

public class MsgReceiver implements Runnable {
    NetworkHandler networkHandler;

    MsgReceiver(NetworkHandler networkHandler) {
        this.networkHandler = networkHandler;
    }

    public void run() {
        while(true) {
            System.out.println(networkHandler.checkMessages());
        }
    }
}
