/**
 * Class Pelicula
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa una película, una subclase de ContenidoAudiovisual.
 */
public class Pelicula extends ContenidoAudiovisual {
    private String estudio; // Estudio responsable de la película.
    private List<Actor> actores; // Lista de actores asociados a la película.

    /**
     * Constructor vacío.
     */
    public Pelicula() {
        super();
    }

    /**
     * Constructor que inicializa una película con detalles específicos.
     *
     * @param titulo            Título de la película.
     * @param duracionEnMinutos Duración en minutos.
     * @param genero            Género de la película.
     * @param estudio           Estudio responsable de la película.
     * @param actores           Nombres de los actores asociados.
     */
    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, String[] actores) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.setActores(Arrays.stream(actores).map(nombre -> Actor.getActor(nombre, this)).toList());
    }

    /**
     * Obtiene el estudio responsable de la película.
     *
     * @return Nombre del estudio.
     */
    public String getEstudio() {
        return estudio;
    }

    /**
     * Establece el estudio responsable.
     *
     * @param estudio Nuevo nombre del estudio.
     */
    public void setEstudio(String estudio) {
        this.estudio = estudio;
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
     * @param actores Lista de actores.
     */
    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    /**
     * Muestra los detalles de la película.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        super.mostrarDetalles(); // Detalles generales de ContenidoAudiovisual.
        System.out.println("Estudio: " + estudio);
        System.out.println("Actores: ");
        for (Actor iterador : actores) {
            System.out.println("\t -" + iterador.getNombre());
        }
        System.out.println();
    }

    /**
     * Obtiene los atributos de la película.
     *
     * @return Lista de atributos.
     */
    @Override
    public List<Object> obtenerAtributos() {
        List<Object> atributos = new ArrayList<>(super.obtenerAtributos());
        atributos.add(estudio);
        atributos.add("<actores>");
        actores.forEach(actor -> atributos.addAll(actor.obtenerAtributos()));
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
        cabecera.add("estudio");
        cabecera.add("<actores>");
        return cabecera;
    }

    /**
     * Establece un atributo específico por nombre.
     *
     * @param nombre Nombre del atributo.
     * @param valor  Valor a asignar.
     */
    @Override
    public void setAtributo(String nombre, String valor) {
        switch (nombre) {
            case "estudio" -> this.estudio = valor;
            case "<actores>" -> {
                if (actores == null) {
                    actores = new ArrayList<>();
                }
                if (!"<actores>".equals(valor)) {
                    actores.add(Actor.getActor(valor));
                }
            }
            default -> super.setAtributo(nombre, valor);
        }
    }
}
