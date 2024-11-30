package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un investigador asociado a uno o más documentales.
 */
public class Investigador {
    private String nombre; // Nombre del investigador.
    private List<Documental> documentales; // Lista de documentales asociados.

    /**
     * Constructor para crear un investigador con un nombre.
     * 
     * @param nombre Nombre del investigador.
     */
    public Investigador(String nombre) {
        this.nombre = nombre;
        this.documentales = new ArrayList<>(); // Inicializa la lista de documentales.
    }

    /**
     * Constructor que inicializa con un nombre y un documental asociado.
     * 
     * @param nombre     Nombre del investigador.
     * @param documental Documental asociado.
     */
    public Investigador(String nombre, Documental documental) {
        this(nombre); // Llama al constructor principal.
        this.agregarDocumental(documental);
    }

    /**
     * Obtiene el nombre del investigador.
     * 
     * @return Nombre del investigador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el investigador.
     * 
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de documentales asociados.
     * 
     * @return Lista de documentales.
     */
    public List<Documental> getDocumental() {
        return documentales;
    }

    /**
     * Establece una nueva lista de documentales.
     * 
     * @param documentales Lista de documentales.
     */
    public void setDocumentales(List<Documental> documentales) {
        this.documentales = documentales;
    }

    /**
     * Agrega un documental a la lista de documentales del investigador.
     * 
     * @param documental Documental a agregar.
     */
    public void agregarDocumental(Documental documental) {
        if (this.documentales == null) {
            this.documentales = new ArrayList<>();
        }
        this.documentales.add(documental);
    }
}
