package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Representa una temporada de una serie de televisión.
 */
public class Temporada {
    private String nombreTemporada; // Nombre de la temporada.
    private List<String> capitulos; // Lista de capítulos de la temporada.
    private SerieDeTV serieDeTV; // Serie de televisión asociada.

    /**
     * Constructor vacío.
     * Inicializa la lista de capítulos.
     */
    public Temporada() {
        capitulos = new ArrayList<>();
    }

    /**
     * Constructor que inicializa una temporada con un nombre.
     *
     * @param nombreTemporada Nombre de la temporada.
     */
    public Temporada(String nombreTemporada) {
        this.nombreTemporada = nombreTemporada;
        capitulos = new ArrayList<>();
    }

    /**
     * Obtiene la serie de televisión asociada.
     *
     * @return Serie de televisión.
     */
    public SerieDeTV getSerieDeTV() {
        return serieDeTV;
    }

    /**
     * Establece la serie de televisión asociada.
     *
     * @param serieDeTV Serie de televisión.
     */
    public void setSerieDeTV(SerieDeTV serieDeTV) {
        this.serieDeTV = serieDeTV;
    }

    /**
     * Obtiene los capítulos de la temporada.
     *
     * @return Array de nombres de capítulos.
     */
    public String[] getCapitulos() {
        return capitulos.toArray(String[]::new);
    }

    /**
     * Establece la lista de capítulos.
     *
     * @param capitulos Array de nombres de capítulos.
     */
    public void setCapitulos(String[] capitulos) {
        this.capitulos = Arrays.asList(capitulos);
    }

    /**
     * Obtiene el nombre de la temporada.
     *
     * @return Nombre de la temporada.
     */
    public String getNombreTemporada() {
        return nombreTemporada;
    }

    /**
     * Establece el nombre de la temporada.
     *
     * @param nombreTemporada Nombre de la temporada.
     */
    public void setNombreTemporada(String nombreTemporada) {
        this.nombreTemporada = nombreTemporada;
    }

    /**
     * Agrega un capítulo a la temporada.
     *
     * @param capitulo Nombre del capítulo.
     */
    public void addCapitulos(String capitulo) {
        capitulos.add(capitulo);
    }

    /**
     * Obtiene los atributos de la temporada.
     *
     * @return Lista de atributos.
     */
    public List<Object> obtenerAtributos() {
        List<Object> atributos = new ArrayList<>();
        atributos.add(nombreTemporada);
        atributos.add("<capitulos>");
        for (String iterador : capitulos) {
            atributos.add(iterador);
        }
        atributos.add("<capitulos>");
        return atributos;
    }

    /**
     * Obtiene la cabecera de los atributos.
     *
     * @return Lista de nombres de columnas.
     */
    public List<String> obtenerCabecera() {
        List<String> cabecera = new ArrayList<>();
        cabecera.add("temporada");
        for (int i = 0; i < capitulos.size(); i++) {
            cabecera.add("capitulos");
        }
        return cabecera;
    }
}
