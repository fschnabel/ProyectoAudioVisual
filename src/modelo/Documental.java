/**
 * Class Documental
 */
package modelo;

import java.util.List;

/**
 * Representa un documental, una subclase de ContenidoAudiovisual.
 */
public class Documental extends ContenidoAudiovisual {
    private String tema; // Tema principal del documental.
    private Investigador investigador; // Investigador asociado al documental.

    /**
     * Constructor vacío.
     */
    public Documental() {
        super();
    }

    /**
     * Constructor que inicializa un documental con detalles específicos.
     *
     * @param titulo            Título del documental.
     * @param duracionEnMinutos Duración en minutos.
     * @param genero            Género del documental.
     * @param tema              Tema principal del documental.
     * @param investigador      Investigador principal.
     */
    public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigador = investigador;
    }

    /**
     * Obtiene el tema del documental.
     *
     * @return Tema.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Establece el tema del documental.
     *
     * @param tema Nuevo tema.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Obtiene el investigador asociado.
     *
     * @return Investigador.
     */
    public Investigador getInvestigador() {
        return investigador;
    }

    /**
     * Establece el investigador asociado.
     *
     * @param investigador Nuevo investigador.
     */
    public void setInvestigador(Investigador investigador) {
        this.investigador = investigador;
    }

    /**
     * Muestra los detalles del documental, incluyendo atributos específicos.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        super.mostrarDetalles(); // Detalles generales de ContenidoAudiovisual.
        System.out.println("Tema: " + this.tema);
        System.out.println("Investigador: " + (this.investigador != null ? this.investigador.getNombre() : "Desconocido"));
        System.out.println();
    }

    /**
     * Obtiene los atributos del documental, incluyendo los heredados.
     *
     * @return Lista de atributos.
     */
    @Override
    public List<Object> obtenerAtributos() {
        List<Object> atributos = super.obtenerAtributos(); // Atributos generales.
        atributos.add(this.tema);
        atributos.add(this.investigador != null ? this.investigador.getNombre() : "Desconocido");
        return atributos;
    }

    /**
     * Obtiene los nombres de columnas para los atributos.
     *
     * @return Lista de nombres de columnas.
     */
    @Override
    public List<String> obtenerCabecera() {
        List<String> cabecera = super.obtenerCabecera();
        cabecera.add("tema");
        cabecera.add("investigador");
        return cabecera;
    }

    /**
     * Establece un atributo del documental por nombre.
     *
     * @param nombre Nombre del atributo.
     * @param valor  Valor a asignar.
     */
    @Override
    public void setAtributo(String nombre, String valor) {
        switch (nombre) {
            case "tema":
                tema = valor;
                break;
            case "investigador":
                investigador = new Investigador(valor); // Supone un constructor en Investigador.
                break;
            default:
                super.setAtributo(nombre, valor); // Llama a la implementación de ContenidoAudiovisual.
        }
    }
}
