package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un actor y sus producciones audiovisuales.
 */
public class Actor {
	private final String nombre; // Nombre del actor, es inmutable.
    private final List<ContenidoAudiovisual> producciones; // Lista de producciones asociadas al actor.

    private static List<Actor> actores = new ArrayList<>(); // Almacena los actores únicos creados.

    /**
     * Constructor privado para evitar la creación directa de instancias.
     * Utiliza un patrón singleton para garantizar una instancia única por nombre.
     *
     * @param nombre Nombre del actor, no puede ser nulo.
     */
    private Actor(final String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        this.producciones = new ArrayList<>();
    }

    /**
     * Obtiene una instancia de Actor por su nombre. Si no existe, la crea.
     *
     * @param nombre Nombre del actor.
     * @return Instancia única de Actor.
     */
    public static Actor getActor(final String nombre) {
        return actores.stream()
                .filter(a -> a.nombre.equals(nombre)) // Busca el actor por nombre.
                .findFirst()
                .orElseGet(() -> { // Si no existe, lo crea.
                    Actor nuevoActor = new Actor(nombre);
                    actores.add(nuevoActor);
                    return nuevoActor;
                });
    }

    /**
     * Obtiene una instancia de Actor por su nombre y asocia una producción.
     * 
     * @param nombre Nombre del actor.
     * @param produccion Producción audiovisual a asociar.
     * @return Instancia de Actor actualizada.
     */
    public static Actor getActor(final String nombre, final ContenidoAudiovisual produccion) {
        Actor actor = getActor(nombre);
        actor.agregarProduccion(produccion);
        return actor;
    }

    /**
     * Agrega una producción a la lista de producciones del actor, si no está ya incluida.
     * 
     * @param produccion Producción audiovisual a agregar.
     */
    public void agregarProduccion(final ContenidoAudiovisual produccion) {
        Objects.requireNonNull(produccion, "La producción no puede ser nula.");
        if (!producciones.contains(produccion)) {
            producciones.add(produccion);
        }
    }

    /**
     * Devuelve el nombre del actor.
     *
     * @return Nombre del actor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve una copia de la lista de producciones del actor.
     *
     * @return Lista de producciones asociadas.
     */
    public List<ContenidoAudiovisual> getProducciones() {
        return new ArrayList<>(producciones);
    }
    
    /**
     * Muestra los detalles del actor y sus producciones audiovisuales.
     */
    public void mostrarDetalles() {
        System.out.println("Detalles del actor");
        System.out.println("nombre: " + this.nombre);
        System.out.println("Producciones Audio Visuales: ");
        for (ContenidoAudiovisual iterador : this.producciones) {
            iterador.mostrarDetalles(); // Supone que ContenidoAudiovisual tiene este método.
        }
        System.out.println();
    }
    
    /**
     * Devuelve una lista con los atributos del actor.
     * 
     * @return Lista de atributos del actor.
     */
    public List<Object> obtenerAtributos() {
        List<Object> atributos = new ArrayList<>();
        atributos.add(this.nombre);
        return atributos;
    }

    /**
     * Devuelve una lista con los nombres de las columnas que representan los atributos del actor.
     * 
     * @return Lista de nombres de columnas.
     */
    public List<String> obtenerCabecera() {
        List<String> cabecera = new ArrayList<>();
        cabecera.add("nombre");
        return cabecera;
    }
}
	