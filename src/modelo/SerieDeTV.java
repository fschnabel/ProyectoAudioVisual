/**
 * Class SerieDeTV
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa una serie de televisión, una subclase de ContenidoAudiovisual.
 */
public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas; // Lista de temporadas de la serie.
    private List<Actor> actores; // Lista de actores asociados a la serie.
    private static final List<String> HEADERS = List.of("<temporadas>", "<capitulos>", "<actores>"); // Cabeceras válidas.

    /**
     * Constructor vacío.
     */
    public SerieDeTV() {
    }

    /**
     * Constructor que inicializa una serie con detalles específicos.
     *
     * @param titulo            Título de la serie.
     * @param duracionEnMinutos Duración promedio por capítulo en minutos.
     * @param genero            Género de la serie.
     * @param temporadas        Lista de temporadas de la serie.
     * @param actores           Nombres de los actores asociados.
     */
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, List<Temporada> temporadas, String[] actores) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.actores = Arrays.stream(actores).map(nombre -> Actor.getActor(nombre, this)).toList();
    }

    /**
     * Obtiene la lista de temporadas.
     *
     * @return Lista de temporadas.
     */
    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    /**
     * Establece la lista de temporadas.
     *
     * @param temporadas Nueva lista de temporadas.
     */
    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    /**
     * Obtiene la lista de actores asociados.
     *
     * @return Lista de actores.
     */
    public List<Actor> getActores() {
        return actores;
    }

    /**
     * Establece la lista de actores.
     *
     * @param actores Nueva lista de actores.
     */
    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    /**
     * Muestra los detalles de la serie de televisión.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Serie de TV:");
        super.mostrarDetalles(); // Detalles generales de ContenidoAudiovisual.
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println("Actores: ");
        for (Actor iterador : actores) {
            System.out.println("\t -" + iterador.getNombre());
        }
        System.out.println();
    }

    /**
     * Obtiene los atributos de la serie.
     *
     * @return Lista de atributos.
     */
    @Override
    public List<Object> obtenerAtributos() {
        List<Object> atributos = new ArrayList<>(super.obtenerAtributos());
        atributos.add("<temporadas>");
        this.temporadas.forEach(temporada -> atributos.addAll(temporada.obtenerAtributos()));
        atributos.add("<temporadas>");
        atributos.add("<actores>");
        this.actores.forEach(actor -> atributos.addAll(actor.obtenerAtributos()));
        atributos.add("<actores>");
        return atributos;
    }

    /**
     * Obtiene la cabecera de los atributos.
     *
     * @return Lista de nombres de columnas.
     */
    @Override
    public List<String> obtenerCabecera() {
        List<String> cabecera = super.obtenerCabecera();
        cabecera.add("<temporadas>");
        cabecera.add("<capitulos>");
        cabecera.add("<actores>");
        return cabecera;
    }

    /**
     * Valida si un atributo es válido.
     *
     * @param valor Atributo a validar.
     * @return `true` si es válido, `false` en caso contrario.
     */
    private boolean esAtributoValido(String valor) {
        return !HEADERS.contains(valor);
    }

    /**
     * Establece un atributo específico por nombre.
     *
     * @param nombre Nombre del atributo.
     * @param valor  Valor a asignar.
     */
    @Override
    public void setAtributo(String nombre, String valor) {
        if (!esAtributoValido(valor)) return;

        switch (nombre) {
            case "<temporadas>" -> agregarTemporada(valor);
            case "<capitulos>" -> agregarCapitulo(valor);
            case "<actores>" -> agregarActor(valor);
            default -> super.setAtributo(nombre, valor);
        }
    }

    /**
     * Agrega una nueva temporada a la serie.
     *
     * @param valor Nombre de la temporada.
     */
    private void agregarTemporada(String valor) {
        if (temporadas == null) temporadas = new ArrayList<>();
        temporadas.add(new Temporada(valor));
    }

    /**
     * Agrega un capítulo a la última temporada de la serie.
     *
     * @param valor Nombre del capítulo.
     */
    private void agregarCapitulo(String valor) {
        if (temporadas == null || temporadas.isEmpty()) {
            agregarTemporada(null); // Añadir temporada vacía si no existe.
        }
        temporadas.get(temporadas.size() - 1).addCapitulos(valor);
    }

    /**
     * Agrega un actor a la serie.
     *
     * @param valor Nombre del actor.
     */
    private void agregarActor(String valor) {
        if (actores == null) actores = new ArrayList<>();
        actores.add(Actor.getActor(valor));
    }
}
