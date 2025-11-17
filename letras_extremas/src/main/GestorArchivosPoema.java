package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GestorArchivosPoema {

    private final String rutaArchivo;

    public GestorArchivosPoema(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<String> leerArchivo() throws IOException {
        List<String> palabras = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {

            // Leer y validar la primera línea
            String primeraLinea = reader.readLine();
            if (primeraLinea == null) {
                throw new IllegalArgumentException("Archivo vacío.");
            }

            int cantidadPalabras = parsearCantidad(primeraLinea);

            // Leer exactamente esa cantidad de palabras (sin validarlas)
            for (int i = 0; i < cantidadPalabras; i++) {
                String palabra = reader.readLine();

                if (palabra == null) {
                    throw new IllegalArgumentException(
                        "Faltan palabras según la cantidad indicada en la primera línea."
                    );
                }

                palabras.add(palabra.trim());
            }
        }

        return palabras;
    }

    public void escribirArchivo(EstadisticaPoema estadistica, String rutaSalida) throws IOException {

        Set<String> letras = estadistica.getLetrasMaxFrecuencia();
        Set<String> palabras = estadistica.getPalabrasFiltradas();

        StringBuilder primeraLinea = new StringBuilder();
        for (String letra : letras) {
            primeraLinea.append(letra);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {

            // Primera línea: letras extremas
            writer.write(primeraLinea.toString());
            writer.newLine();

            for (String p : palabras) {
                writer.write(p);
                writer.newLine();
            }
        }
    }

    private int parsearCantidad(String linea) {
        try {
            return Integer.parseInt(linea.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La primera línea no es un número válido.");
        }
    }
}