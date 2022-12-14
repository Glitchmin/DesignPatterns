package Chat;

import java.io.IOException;

public class ChatFacade {
    private final NetworkHandler networkHandler;
    Thread receiver;

    public ChatFacade(String name) {
        networkHandler = new NetworkHandler(name);
    }

    public void broadcast(String msg) {
        networkHandler.broadcast(msg);
    }

    public void broadcastWelcomingMessage() {
        networkHandler.broadcastWelcomeMessage();
    }

    public void sendPrivateMessage(String target, String msg) {
        networkHandler.sendPrivateMessage(target, msg);
    }

    public String getActiveUsers() {
        return networkHandler.getActiveUsers();
    }

    public void broadcastGoodbyeMessage() {
        networkHandler.broadcastGoodbyeMessage();
    }

    public void startReceivingMessages() {
        receiver = new Thread(new MsgReceiver(networkHandler));
        receiver.start();
    }

    public void stopReceivingMessages() {
        try {
            networkHandler.ss.close();
        } catch (IOException ignored) {
        }
        receiver.interrupt();
        try {
            receiver.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getAddress() {
        return Integer.toString(networkHandler.getPort());
    }

}
