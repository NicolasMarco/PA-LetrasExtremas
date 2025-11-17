package main;

public class Extremas {
    public static void main(String[] args) {
        try {
            AnalizadorPoema analizador = new AnalizadorPoema(); 
            analizador.ejecutarAnalisis();
            System.out.println("+ Procesamiento completado exitosamente.");
        } catch (Exception e) {
            System.err.println("+ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
