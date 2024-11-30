package controlador;

import java.util.List;
import java.util.Objects;

import VistaInterfase.TipoArchivo;
import modelo.ContenidoAudiovisual;
import vista.VistaArchivo;

/**
 * Controlador para manejar la exportación e importación de archivos de contenido audiovisual.
 */
public class ControladorArchivo {

    private final List<ContenidoAudiovisual> contenidoAudioVisual;
    private final VistaArchivo vistaArchivo;

    /**
     * Constructor del ControladorArchivo.
     * 
     * @param contenidoAudioVisual Lista de contenido audiovisual a gestionar.
     * @param vistaArchivo         Dependencia para interactuar con archivos.
     */
    public ControladorArchivo(final List<ContenidoAudiovisual> contenidoAudioVisual, final VistaArchivo vistaArchivo) {
        this.contenidoAudioVisual = Objects.requireNonNull(contenidoAudioVisual, "La lista de contenido no puede ser nula.");
        this.vistaArchivo = Objects.requireNonNull(vistaArchivo, "La vista de archivo no puede ser nula.");
    }

    /**
     * Exporta contenido audiovisual a un archivo.
     * 
     * @param ruta       Ruta del archivo destino.
     * @param tipoArchivo Tipo de archivo a exportar.
     */
    public void exportarArchivo(final String ruta, final TipoArchivo tipoArchivo) {
        if (ruta == null || ruta.isEmpty()) {
            throw new IllegalArgumentException("La ruta no puede ser nula o vacía.");
        }
        Objects.requireNonNull(tipoArchivo, "El tipo de archivo no puede ser nulo.");
        vistaArchivo.escribirDatos(contenidoAudioVisual, ruta, tipoArchivo);
    }

    /**
     * Importa contenido audiovisual desde un archivo.
     * 
     * @param <T>           Tipo de contenido audiovisual.
     * @param tipoContenido Clase del tipo de contenido.
     * @param ruta          Ruta del archivo fuente.
     * @param tipoArchivo   Tipo de archivo a importar.
     * @return Lista de contenido audiovisual importado.
     */
    public <T extends ContenidoAudiovisual> List<T> importarArchivo(final Class<T> tipoContenido, final String ruta, final TipoArchivo tipoArchivo) {
        if (ruta == null || ruta.isEmpty()) {
            throw new IllegalArgumentException("La ruta no puede ser nula o vacía.");
        }
        Objects.requireNonNull(tipoContenido, "El tipo de contenido no puede ser nulo.");
        Objects.requireNonNull(tipoArchivo, "El tipo de archivo no puede ser nulo.");
        return vistaArchivo.leerDatos(tipoContenido, ruta, tipoArchivo);
    }

}
