import java.io.IOException;

public class Extremas {
    public static void main(String[] args) {
        try {
            AnalizadorPoema analizador = new AnalizadorPoema();
            analizador.procesarPoema();
            System.out.println("Procesamiento completado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error en formato de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
