package vista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import VistaInterfase.TipoArchivo;
import modelo.ContenidoAudiovisual;

/**
 * Clase para leer y escribir datos de archivos que contienen información de contenidos audiovisuales.
 */
public class VistaArchivo {

    /**
     * Lee datos desde un archivo y los transforma en una lista de entidades del tipo especificado.
     *
     * @param <T>          Tipo genérico que extiende ContenidoAudiovisual.
     * @param tipoContenido Clase del tipo de contenido a leer.
     * @param ruta         Ruta del archivo a leer.
     * @param tipoArchivo  Implementación de TipoArchivo para manejar el formato del archivo.
     * @return Lista de entidades del tipo especificado, o `null` si ocurre un error.
     */
    public <T extends ContenidoAudiovisual> List<T> leerDatos(Class<T> tipoContenido, String ruta,
                                                              TipoArchivo tipoArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            List<T> listEntidad = new ArrayList<>();
            String linea;
            boolean esCabecera = true;

            while ((linea = br.readLine()) != null) {
                if (esCabecera) {
                    tipoArchivo.setCabecera(linea); // Configura la cabecera del archivo.
                    esCabecera = false;
                } else {
                    T entidad = tipoArchivo.obtenerEntidad(tipoContenido, linea); // Convierte la línea en una entidad.
                    if (entidad != null) {
                        listEntidad.add(entidad);
                    }
                }
            }
            return listEntidad;
        } catch (IOException e) {
            return null; // Retorna null en caso de error.
        }
    }

    /**
     * Escribe una lista de entidades en un archivo.
     *
     * @param datos       Lista de entidades a escribir.
     * @param ruta        Ruta del archivo a escribir.
     * @param tipoArchivo Implementación de TipoArchivo para manejar el formato del archivo.
     */
    public void escribirDatos(List<ContenidoAudiovisual> datos, String ruta, TipoArchivo tipoArchivo) {
        StringBuilder registros = new StringBuilder();

        // Genera la cabecera del archivo.
        registros.append(tipoArchivo.obtenerCabecera(datos.get(0)));
        registros.append("\n");

        // Genera los registros de cada entidad.
        for (ContenidoAudiovisual registroEntidad : datos) {
            registros.append(tipoArchivo.obtenerRegistro(registroEntidad));
            registros.append("\n");
        }

        // Crea el archivo y escribe el contenido.
        try (FileWriter escritor = new FileWriter(ruta)) {
            escritor.write(registros.toString());
            System.out.println("Archivo creado y contenido escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear/escribir el archivo.");
            e.printStackTrace();
        }
    }
}
