import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivosPoema {
    
    public List<String> leerPalabras(String nombreArchivo) throws IOException {
        List<String> palabras = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            int cantidadPalabras = Integer.parseInt(br.readLine().trim());
            
            for (int i = 0; i < cantidadPalabras; i++) {
                String linea = br.readLine();
                if (linea == null) {
                    throw new IOException("El archivo tiene menos palabras de las esperadas");
                }
                String palabra = linea.trim().toLowerCase();
                palabras.add(palabra);
            }
        }
        
        return palabras;
    }
    
    public void escribirResultado(String nombreArchivo, EstadisticaPoema estadistica) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String letra : estadistica.getLetrasMaxFrecuencia()) {
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
