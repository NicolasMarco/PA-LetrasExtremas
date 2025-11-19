import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivosPoema {
    private static final int MAX_PALABRAS = 250;
    private static final int MAX_LONGITUD_PALABRA = 10;

    public List<String> leerPalabras(String nombreArchivo) throws IOException {
        List<String> palabras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            int cantidadPalabras = Integer.parseInt(br.readLine().trim());

            if (cantidadPalabras <= 0 || cantidadPalabras > MAX_PALABRAS) {
                throw new IllegalArgumentException(
                    "Cantidad de palabras fuera de rango: " + cantidadPalabras);
            }

            for (int i = 0; i < cantidadPalabras; i++) {
                String palabra = br.readLine();
                if (palabra == null) {
                    throw new IllegalArgumentException("Faltan palabras en el archivo");
                }

                palabra = palabra.trim().toLowerCase();

                if (palabra.isEmpty() || palabra.length() > MAX_LONGITUD_PALABRA) {
                    throw new IllegalArgumentException(
                        "Palabra con longitud inválida: " + palabra);
                }

                if (!esAlfabeticaMinuscula(palabra)) {
                    throw new IllegalArgumentException(
                        "Palabra con caracteres inválidos: " + palabra);
                }

                palabras.add(palabra);
            }
        }

        return palabras;
    }

    private boolean esAlfabeticaMinuscula(String palabra) {
        for (char c : palabra.toCharArray()) {
            if (c < 'a' || c > 'z') return false;
        }
        return true;
    }

    public void escribirResultado(String nombreArchivo, EstadisticaPoema estadistica) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Character letra : estadistica.getLetrasMaxFrecuencia()) {
                bw.write(letra);
            }

            bw.newLine();

            for (String palabra : estadistica.getPalabrasFiltradas()) {
                bw.write(palabra);
                bw.newLine();
            }
        }
    }
}
