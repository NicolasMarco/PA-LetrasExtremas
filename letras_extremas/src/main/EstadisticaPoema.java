package main;

import java.util.Set;

public class EstadisticaPoema {
    private Set<String> letrasMaxFrecuencia;
    private Set<String> palabrasFiltradas;

    public EstadisticaPoema(Set<String> letrasMaxFrecuencia, Set<String> palabrasFiltradas) {
        this.letrasMaxFrecuencia = letrasMaxFrecuencia;
        this.palabrasFiltradas = palabrasFiltradas;
    }

    public Set<String> getLetrasMaxFrecuencia() {
        return letrasMaxFrecuencia;
    }

    public Set<String> getPalabrasFiltradas() {
        return palabrasFiltradas;
    }
}
