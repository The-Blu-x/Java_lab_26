import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            // Zadanie 3a: Podanie loginu przed rozpoczęciem czatu
            System.out.print("Podaj swój login: ");
            String login = scanner.nextLine();
            out.println(login); // Wysłanie loginu do serwera

            // Zadanie 2: Osobny wątek do odbierania wiadomości z serwera
            Thread receiverThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Rozłączono z serwerem.");
                }
            });
            receiverThread.start();

            // Zadanie 2: Główny wątek odpowiada za czytanie wejścia z konsoli i wysyłanie do serwera
            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                out.println(message);
            }

        } catch (IOException e) {
            System.err.println("Nie można połączyć z serwerem: " + e.getMessage());
        }
    }
}