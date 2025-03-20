package trabajoenfoquewordle;

public class Main {
    public static void main(String[] args) {
        // Cargar las palabras desde el archivo
        String[] palabras = WordleFileManager.leerPalabras("palabras.txt");
        if (palabras.length > 0) {
            System.out.println("Palabras cargadas correctamente.");
            // Iniciar el juego
            WordleGame juego = new WordleGame(palabras);
            juego.start();
        } else {
            System.out.println("No se cargaron palabras. ¿El archivo está en la ubicación correcta?");
        }
    }
}