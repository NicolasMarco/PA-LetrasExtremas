import java.util.Set;

public class EstadisticaPoema {
    private Set<Character> letrasMaxFrecuencia;
    private Set<String> palabrasFiltradas;

    public EstadisticaPoema(Set<Character> letrasMaxFrecuencia, Set<String> palabrasFiltradas) {
        this.letrasMaxFrecuencia = letrasMaxFrecuencia;
        this.palabrasFiltradas = palabrasFiltradas;
    }

    public Set<Character> getLetrasMaxFrecuencia() {
        return letrasMaxFrecuencia;
    }

    public Set<String> getPalabrasFiltradas() {
        return palabrasFiltradas;
    }
}
