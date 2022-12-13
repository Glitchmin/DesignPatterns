package Chat;

import java.util.Scanner;

public class TerminalClient {
    private ChatFacade chat;
    private String name;
    private Scanner input;

    void start() {
        input = new Scanner(System.in);
        register();
        showCommands();
        while (true) {
            String command = input.next();

            switch (command) {
                case "HELP" -> showCommands();
                case "SEND" -> {
                    String recipient = input.next();
                    String message = input.nextLine();
                    chat.sendPrivateMessage(recipient, message);
                }
                case "BROADCAST" -> {
                    String message = input.nextLine();
                    chat.broadcast(message);
                }
                case "USERS" -> System.out.println(chat.getActiveUsers());
                case "ADDRESS" -> System.out.println(chat.getAddress());
                case "EXIT" -> {
                    chat.broadcastGoodbyeMessage();
                    chat.stopReceivingMessages();
                    return;
                }
                default -> System.out.println("Unrecognized command");
            }

        }
    }

    private void showCommands() {
        System.out.println("""
                Available commands:
                HELP - show commands list
                SEND <recipient username> <message> - send message to one user
                BROADCAST <message> - send message to all active users
                USERS - show usernames list of active users
                ADDRESS - see your address
                EXIT - unregister and exit
                """);
    }

    private void register() {
        System.out.println("Choose your name:");
        name = input.next();
        chat = new ChatFacade(name);
        chat.broadcastWelcomingMessage();
        chat.startReceivingMessages();
    }

}
