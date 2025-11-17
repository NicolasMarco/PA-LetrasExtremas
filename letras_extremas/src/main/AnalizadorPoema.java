package main;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class AnalizadorPoema {
    private static final String ARCHIVO_ENTRADA = "EXTREMAS.in";
    private static final String ARCHIVO_SALIDA  = "EXTREMAS.out";

    private final ContadorFrecuencias contador;
    private final GestorArchivosPoema gestorArchivos;
    private List<String> palabrasDelPoema;

    public AnalizadorPoema() {
        this.contador = new ContadorFrecuencias();
        this.gestorArchivos = new GestorArchivosPoema(ARCHIVO_ENTRADA);
    }

    public void ejecutarAnalisis() throws IOException {
        // 1) Leer palabras
        palabrasDelPoema = gestorArchivos.leerArchivo();

        // 2) Contar letras extremas
        contador.contarExtremas(palabrasDelPoema);

        // 3) Obtener letras con frecuencia máxima y palabras asociadas
        Set<String> letrasMax = contador.getLetrasConFrecuenciaMaxima();
        Set<String> palabrasFiltradas = contador.getPalabrasConLetrasMaximas(palabrasDelPoema);

        // 4) Crear objeto EstadisticaPoema
        EstadisticaPoema estadistica = new EstadisticaPoema(letrasMax, palabrasFiltradas);

        // 5) Escribir archivo de salida
        gestorArchivos.escribirArchivo(estadistica, ARCHIVO_SALIDA);
    }
}
