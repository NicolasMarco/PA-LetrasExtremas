package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class LetrasTest {
    
    @Test
    @DisplayName("Debe validar correctamente palabras alfabéticas minúsculas")
    void testEsAlfabeticaMinuscula() {
        assertTrue(Letras.esAlfabeticaMinuscula("arbol"));
        assertTrue(Letras.esAlfabeticaMinuscula("a"));
        assertTrue(Letras.esAlfabeticaMinuscula("palabra"));
        
        assertFalse(Letras.esAlfabeticaMinuscula("Arbol"));
        assertFalse(Letras.esAlfabeticaMinuscula("árbol"));
        assertFalse(Letras.esAlfabeticaMinuscula("arbol123"));
        assertFalse(Letras.esAlfabeticaMinuscula("arbol!"));
    }
    
    @Test
    @DisplayName("Debe encontrar correctamente las letras de máxima frecuencia")
    void testEncontrarLetrasMaxFrecuencia() {
        int[] frecuencias = new int[26];
        frecuencias['a' - 'a'] = 5;
        frecuencias['b' - 'a'] = 3;
        frecuencias['c' - 'a'] = 5;
        
        Set<Character> resultado = Letras.encontrarLetrasMaxFrecuencia(frecuencias);
        
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains('a'));
        assertTrue(resultado.contains('c'));
        assertFalse(resultado.contains('b'));
    }
    
    @Test
    @DisplayName("Debe filtrar correctamente las palabras")
    void testFiltrarPalabras() {
        List<String> palabras = Arrays.asList("arbol", "casa", "perro", "auto");
        Set<Character> letrasMax = new LinkedHashSet<>(Arrays.asList('a', 'o'));
        
        Set<String> resultado = Letras.filtrarPalabras(palabras, letrasMax);
        
        assertEquals(3, resultado.size());
        assertTrue(resultado.contains("arbol")); // empieza con 'a'
        assertTrue(resultado.contains("casa"));  // empieza con 'a'
        assertTrue(resultado.contains("perro")); // termina con 'o'
        assertTrue(resultado.contains("auto"));  // empieza con 'a' y termina con 'o'
    }
    
    @Test
    @DisplayName("Debe manejar palabras con letras extremas iguales")
    void testPalabrasConLetrasExtremasIguales() {
        List<String> palabras = Arrays.asList("ana", "oso");
        Set<Character> letrasMax = new LinkedHashSet<>(Arrays.asList('a', 'o'));
        
        Set<String> resultado = Letras.filtrarPalabras(palabras, letrasMax);
        
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains("ana"));
        assertTrue(resultado.contains("oso"));
    }
}
