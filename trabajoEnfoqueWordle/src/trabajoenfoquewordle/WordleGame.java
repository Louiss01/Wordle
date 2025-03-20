package trabajoenfoquewordle;

import java.util.*;

public class WordleGame {
    private static final int MAX_TRIES = 6;
    private static final int WORD_LENGTH = 5;
    private String[] fileWords;
    private String secretWord;
    private int remainingAttempts;
    private List<String> triesHistory;

    // Constructor
    public WordleGame(String[] fileWords) {
        this.fileWords = fileWords;
        this.secretWord = selectRandomWord(fileWords);
        this.remainingAttempts = MAX_TRIES;
        this.triesHistory = new ArrayList<>();
    }

    // Método para seleccionar una palabra secreta al azar
    private String selectRandomWord(String[] words) {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    // Método para iniciar el juego
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a Wordle!");
        System.out.println("Tienes " + MAX_TRIES + " intentos para adivinar la palabra.");

        while (remainingAttempts > 0) {
            System.out.println("Intentos restantes: " + remainingAttempts);
            String userGuess = getUserInput(scanner);

            if (userGuess.equals(secretWord)) {
                System.out.println("¡Felicidades! Has adivinado la palabra correcta: " + secretWord);
                WordleFileManager.guardarPartida("historial.txt", "¡Ganaste! Palabra: " + secretWord);
                break;
            } else {
                remainingAttempts--;
                triesHistory.add(userGuess);
                showTriesHistory();
                System.out.println(WordleFeedback.feedBackString(userGuess, secretWord));
                WordleFileManager.guardarPartida("historial.txt", "Intento: " + userGuess);
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("¡Agotaste tus intentos! La palabra correcta era: " + secretWord);
            WordleFileManager.guardarPartida("historial.txt", "¡Perdiste! Palabra: " + secretWord);
        }

        scanner.close();
    }

    // Método para obtener la entrada del usuario
    private String getUserInput(Scanner scanner) {
        String userGuess;
        while (true) {
            System.out.print("Introduce una palabra de 5 letras: ");
            userGuess = scanner.nextLine().toUpperCase();
            if (userGuess.length() == WORD_LENGTH) {
                return userGuess;
            } else {
                System.out.println("La palabra debe tener exactamente 5 letras.");
            }
        }
    }

    // Método para mostrar el historial de intentos
    private void showTriesHistory() {
        System.out.println("Historial de intentos:");
        for (String attempt : triesHistory) {
            System.out.println(attempt);
        }
    }
}