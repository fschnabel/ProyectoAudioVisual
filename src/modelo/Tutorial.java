package modelo;

import java.util.List;

/**
 * Representa un tutorial, una subclase de ContenidoAudiovisual.
 */
public class Tutorial extends ContenidoAudiovisual {
    private String materia; // Materia que cubre el tutorial.
    private String expositor; // Nombre del expositor del tutorial.

    /**
     * Constructor vacío.
     */
    public Tutorial() {
        super();
    }

    /**
     * Constructor que inicializa un tutorial con detalles específicos.
     *
     * @param titulo            Título del tutorial.
     * @param duracionEnMinutos Duración en minutos.
     * @param genero            Género del tutorial.
     * @param materia           Materia del tutorial.
     * @param expositor         Nombre del expositor.
     */
    public Tutorial(String titulo, int duracionEnMinutos, String genero, String materia, String expositor) {
        super(titulo, duracionEnMinutos, genero);
        this.materia = materia;
        this.expositor = expositor;
    }

    /**
     * Obtiene la materia del tutorial.
     *
     * @return Materia.
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Establece la materia del tutorial.
     *
     * @param materia Nueva materia.
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * Obtiene el nombre del expositor.
     *
     * @return Expositor.
     */
    public String getExpositor() {
        return expositor;
    }

    /**
     * Establece el nombre del expositor.
     *
     * @param expositor Nuevo nombre del expositor.
     */
    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    /**
     * Obtiene los atributos del tutorial.
     *
     * @return Lista de atributos.
     */
    @Override
    public List<Object> obtenerAtributos() {
        List<Object> atributos = super.obtenerAtributos();
        atributos.add(this.materia);
        atributos.add(this.expositor);
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
        cabecera.add("materia");
        cabecera.add("expositor");
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
            case "materia":
                materia = valor;
                break;
            case "expositor":
                expositor = valor;
                break;
            default:
                super.setAtributo(nombre, valor);
        }
    }
}
