import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    // Bezpieczna dla wątków mapa przechowująca pary: login -> obsługa klienta
    private static ConcurrentHashMap<String, ClientHandler> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Serwer czatu uruchomiony na porcie " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                // Zadanie 1: Akceptowanie wielu użytkowników
                Socket clientSocket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(clientSocket);
                new Thread(handler).start(); // Uruchomienie klienta w nowym wątku
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Klasa wewnętrzna obsługująca pojedynczego klienta
    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String login;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Zadanie 3a: Pierwsza wiadomość to login
                login = in.readLine();
                if (login == null || login.trim().isEmpty()) {
                    return; // Zabezpieczenie przed pustym loginem
                }

                // Rejestracja użytkownika
                clients.put(login, this);
                broadcast("Użytkownik " + login + " dołączył do czatu.");

                String message;
                // Zadanie 1: Oczekiwanie na wiadomości
                while ((message = in.readLine()) != null) {

                    // Zadanie 3b: Komenda /online
                    if (message.equals("/online")) {
                        sendPrivateMessage("Dostępni użytkownicy: " + String.join(", ", clients.keySet()));
                    }
                    // Zadanie 4b: Prywatne wiadomości
                    else if (message.startsWith("/w ")) {
                        String[] parts = message.split(" ", 3); // Dzieli na 3 części: komenda, odbiorca, wiadomość
                        if (parts.length == 3) {
                            String recipient = parts[1];
                            String privMsg = parts[2];
                            sendWhisper(recipient, privMsg);
                        } else {
                            sendPrivateMessage("Nieprawidłowy format. Użyj: /w uzytkownik wiadomosc");
                        }
                    }
                    // Zadanie 4a: Zwykła wiadomość (prefix z loginem)
                    else {
                        broadcast(login + ": " + message);
                    }
                }
            } catch (IOException e) {
                System.out.println("Połączenie z użytkownikiem " + login + " zostało przerwane.");
            } finally {
                // Zadanie 3a: Opuszczenie czatu
                if (login != null && clients.containsKey(login)) {
                    clients.remove(login);
                    broadcast("Użytkownik " + login + " opuścił czat.");
                }
                try { socket.close(); } catch (IOException e) { }
            }
        }

        // Metoda rozsyłająca wiadomość do wszystkich
        private void broadcast(String message) {
            for (ClientHandler client : clients.values()) {
                client.out.println(message);
            }
        }

        // Metoda do wysyłania wiadomości tylko do tego konkretnego klienta
        private void sendPrivateMessage(String message) {
            out.println(message);
        }

        // Metoda realizująca komendę /w
        private void sendWhisper(String recipient, String message) {
            ClientHandler recipientHandler = clients.get(recipient);
            if (recipientHandler != null) {
                recipientHandler.sendPrivateMessage("[Prywatna od " + login + "]: " + message);
            } else {
                sendPrivateMessage("Użytkownik " + recipient + " nie jest zalogowany.");
            }
        }
    }
}