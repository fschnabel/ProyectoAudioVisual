package modelo;


import java.util.List;

/**
 * Representa un video musical, una subclase de ContenidoAudiovisual.
 */
public class VideoMusical extends ContenidoAudiovisual {
    private String productora; // Nombre de la productora del video musical.
    private String interprete; // Nombre del intérprete de la música.

    /**
     * Constructor vacío.
     */
    public VideoMusical() {
        super();
    }

    /**
     * Constructor que inicializa un video musical con detalles específicos.
     *
     * @param titulo            Título del video musical.
     * @param duracionEnMinutos Duración en minutos.
     * @param genero            Género del video musical.
     * @param productora        Nombre de la productora.
     * @param interprete        Nombre del intérprete.
     */
    public VideoMusical(String titulo, int duracionEnMinutos, String genero, String productora, String interprete) {
        super(titulo, duracionEnMinutos, genero);
        this.productora = productora;
        this.interprete = interprete;
    }

    /**
     * Obtiene la productora del video musical.
     *
     * @return Nombre de la productora.
     */
    public String getProductora() {
        return productora;
    }

    /**
     * Establece la productora del video musical.
     *
     * @param productora Nueva productora.
     */
    public void setProductora(String productora) {
        this.productora = productora;
    }

    /**
     * Obtiene el intérprete del video musical.
     *
     * @return Nombre del intérprete.
     */
    public String getInterprete() {
        return interprete;
    }

    /**
     * Establece el intérprete del video musical.
     *
     * @param interprete Nuevo intérprete.
     */
    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    /**
     * Muestra los detalles del video musical.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del video musical:");
        super.mostrarDetalles();
        System.out.println("Productora: " + productora);
        System.out.println("Intérprete: " + interprete);
        System.out.println();
    }

    /**
     * Obtiene los atributos del video musical.
     *
     * @return Lista de atributos.
     */
    @Override
    public List<Object> obtenerAtributos() {
        List<Object> atributos = super.obtenerAtributos();
        atributos.add(this.productora);
        atributos.add(this.interprete);
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
        cabecera.add("productora");
        cabecera.add("interprete");
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
            case "productora":
                productora = valor;
                break;
            case "interprete":
                interprete = valor;
                break;
            default:
                super.setAtributo(nombre, valor);
        }
    }
}
