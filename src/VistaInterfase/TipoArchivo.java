package VistaInterfase;

import modelo.ContenidoAudiovisual;

/**
 * Interfaz para manejar archivos que contienen datos de contenidos audiovisuales.
 */
public interface TipoArchivo {

    /**
     * Genera la cabecera de un archivo a partir de un objeto.
     *
     * @param continAudiovisual Objeto del cual obtener los nombres de los atributos.
     * @return Cadena de texto que representa la cabecera del archivo.
     */
    public String obtenerCabecera(ContenidoAudiovisual continAudiovisual);

    /**
     * Genera un registro de texto a partir de un objeto.
     *
     * @param continAudiovisual Objeto a serializar.
     * @return Cadena de texto que representa el objeto en formato de archivo.
     */
    public String obtenerRegistro(ContenidoAudiovisual continAudiovisual);

    /**
     * Configura la cabecera del archivo desde un registro.
     *
     * @param registro Registro que contiene los nombres de los atributos separados.
     */
    public void setCabecera(String registro);

    /**
     * Crea una entidad de tipo `ContenidoAudiovisual` a partir de un registro de texto.
     *
     * @param <T>           Tipo genérico que extiende `ContenidoAudiovisual`.
     * @param tipoContenido Clase de la entidad a crear.
     * @param registro      Cadena de texto que representa un registro del archivo.
     * @return Instancia de la entidad creada.
     */
    public <T extends ContenidoAudiovisual> T obtenerEntidad(Class<T> tipoContenido, String registro);
}

