import java.io.IOException;
import java.util.List;
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
        contadorFrecuencias.contarExtremas(palabras);
        
        Set<String> letrasMaxFrecuencia = contadorFrecuencias.getLetrasConFrecuenciaMaxima();
        Set<String> palabrasFiltradas = contadorFrecuencias.getPalabrasConLetrasMaximas(palabras);
        
        return new EstadisticaPoema(letrasMaxFrecuencia, palabrasFiltradas);
    }
}
