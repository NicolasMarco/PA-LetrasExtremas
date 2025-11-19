import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalizadorPoema {
    private GestorArchivosPoema gestorArchivos;
    private ContadorFrecuencias contadorFrecuencias;

    public AnalizadorPoema() {
        this.gestorArchivos = new GestorArchivosPoema();
        this.contadorFrecuencias = new ContadorFrecuencias();
    }

    public void procesarPoema() throws IOException {
        List<String> palabras = gestorArchivos.leerPalabras("EXTREMAS.IN");
        EstadisticaPoema resultado = analizar(palabras);
        gestorArchivos.escribirResultado("EXTREMAS.OUT", resultado);
    }

    public EstadisticaPoema analizar(List<String> palabras) {
        for (String palabra : palabras) {
            contadorFrecuencias.contarLetraExtrema(palabra);
        }

        Map<Character, Integer> frecuencias = contadorFrecuencias.obtenerFrecuencias();
        int frecuenciaMaxima = contadorFrecuencias.getFrecuenciaMaxima();

        Set<Character> letrasMaxFrecuencia = new LinkedHashSet<>();
        for (Map.Entry<Character, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() == frecuenciaMaxima) {
                letrasMaxFrecuencia.add(entry.getKey());
            }
        }

        Set<String> palabrasFiltradas = new LinkedHashSet<>();
        for (String palabra : palabras) {
            char letraInicial = palabra.charAt(0);
            char letraFinal = palabra.charAt(palabra.length() - 1);

            if (letrasMaxFrecuencia.contains(letraInicial) || 
                letrasMaxFrecuencia.contains(letraFinal)) {
                palabrasFiltradas.add(palabra);
            }
        }

        return new EstadisticaPoema(letrasMaxFrecuencia, palabrasFiltradas);
    }
}
