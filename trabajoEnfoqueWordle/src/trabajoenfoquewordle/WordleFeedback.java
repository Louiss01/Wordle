package trabajoenfoquewordle;

public class WordleFeedback {
    private static final int WORD_LENGTH = 5;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Método para aplicar color a una letra
    private static String applyColor(String letter, String color) {
        return color + letter + ANSI_RESET;
    }

    // Método para generar la retroalimentación con colores
    public static String feedBackString(String guess, String secretWord) {
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < WORD_LENGTH; i++) {
            char guessChar = guess.charAt(i);
            char secretChar = secretWord.charAt(i);

            if (guessChar == secretChar) {
                feedback.append(applyColor(String.valueOf(guessChar), ANSI_GREEN));
            } else if (secretWord.contains(String.valueOf(guessChar))) {
                feedback.append(applyColor(String.valueOf(guessChar), ANSI_YELLOW));
            } else {
                feedback.append(applyColor(String.valueOf(guessChar), ANSI_WHITE));
            }
        }
        return feedback.toString();
    }
}