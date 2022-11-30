
public class Client {
    Facade networkFacade;
    int port;
    public Client(String name){
        this.networkFacade = new Facade(name);
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
