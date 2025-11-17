package main;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ContadorFrecuencias {
    private static final int TAM_ALFABETO = 26;
    private final int[] frecuencias;

    public ContadorFrecuencias() {
        this.frecuencias = new int[TAM_ALFABETO];
    }

    public void contarExtremas(List<String> palabras) {
        for (String palabra : palabras) {
            procesarPalabra(palabra);
        }
    }

    public Set<String> getLetrasConFrecuenciaMaxima() {
        int max = getFrecuenciaMaxima();
        Set<String> letras = new HashSet<>();

        for (int i = 0; i < TAM_ALFABETO; i++) {
            if (frecuencias[i] == max) {
                char letra = (char) ('a' + i);
                letras.add(String.valueOf(letra));
            }
        }
        return letras;
    }

    public Set<String> getPalabrasConLetrasMaximas(List<String> palabras) {
        Set<String> resultado = new LinkedHashSet<>();
        Set<String> letrasMax = getLetrasConFrecuenciaMaxima();

        for (String palabra : palabras) {
            if (palabra == null || palabra.isEmpty()) continue;

            char primera = palabra.charAt(0);
            char ultima = palabra.charAt(palabra.length() - 1);

            String p1 = String.valueOf(primera);
            String p2 = String.valueOf(ultima);

            if (letrasMax.contains(p1) || letrasMax.contains(p2)) {
                resultado.add(palabra);
            }
        }

        return resultado;
    }

    private void procesarPalabra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return; // o lanzar excepción si preferís
        }

        char primera = palabra.charAt(0);
        char ultima  = palabra.charAt(palabra.length() - 1);

        incrementarFrecuencia(primera);
        incrementarFrecuencia(ultima);
    }

    private void incrementarFrecuencia(char c) {
        int indice = c - 'a';  // asume letras 'a'..'z'

        if (indice < 0 || indice >= TAM_ALFABETO) {
            throw new IllegalArgumentException("Carácter fuera de rango [a-z]: " + c);
        }

        frecuencias[indice]++;
    }

    private int getFrecuenciaMaxima() {
        int max = 0;
        for (int f : frecuencias) {
            if (f > max) max = f;
        }
        return max;
    }
}
