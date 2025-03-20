package trabajoenfoquewordle;

import java.io.*;
import java.util.*;

public class WordleFileManager {

    // Método para leer palabras desde un archivo
    public static String[] leerPalabras(String nombreArchivo) {
        List<String> palabras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.length() == 5) { // Solo palabras de 5 letras
                    palabras.add(linea.toUpperCase()); // Convertimos a mayúsculas
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return palabras.toArray(new String[0]);
    }

    // Método para guardar el historial de partidas
    public static void guardarPartida(String nombreArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(contenido);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la partida: " + e.getMessage());
        }
    }
}
