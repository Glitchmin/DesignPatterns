package Chat;

public class Client {
    ChatFacade networkFacade;
    int port;
    public Client(String name){
        this.networkFacade = new ChatFacade(name);
        networkFacade.startReceivingMessages();
        networkFacade.broadcastWelcomingMessage();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        networkFacade.sendPrivateMessage("Adam","heeeej");
        networkFacade.broadcastGoodbyeMessage();
        System.out.println(networkFacade.getActiveUsers());
    }

}
