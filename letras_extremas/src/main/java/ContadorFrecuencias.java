import java.util.HashMap;
import java.util.Map;

public class ContadorFrecuencias {
    private static final int ALPHABET_SIZE = 26;
    private int[] frecuencias;

    public ContadorFrecuencias() {
        this.frecuencias = new int[ALPHABET_SIZE];
    }

    public void contarLetraExtrema(String palabra) {
        if (palabra == null || palabra.isEmpty()) return;
        contarLetra(palabra.charAt(0));
        contarLetra(palabra.charAt(palabra.length() - 1));
    }

    private void contarLetra(char letra) {
        if (letra >= 'a' && letra <= 'z') {
            frecuencias[letra - 'a']++;
        }
    }

    public Map<Character, Integer> obtenerFrecuencias() {
        Map<Character, Integer> resultado = new HashMap<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (frecuencias[i] > 0) {
                resultado.put((char)('a' + i), frecuencias[i]);
            }
        }
        return resultado;
    }

    public Character obtenerLetraMasFrecuente() {
        int maxFrecuencia = 0;
        Character letraMasFrecuente = null;

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (frecuencias[i] > maxFrecuencia) {
                maxFrecuencia = frecuencias[i];
                letraMasFrecuente = (char)('a' + i);
            }
        }
        return letraMasFrecuente;
    }

    public int obtenerFrecuencia(char letra) {
        if (letra >= 'a' && letra <= 'z') {
            return frecuencias[letra - 'a'];
        }
        return 0;
    }

    public int getFrecuenciaMaxima() {
        int max = 0;
        for (int frec : frecuencias) {
            if (frec > max) max = frec;
        }
        return max;
    }
}
