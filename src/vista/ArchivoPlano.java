package vista;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import VistaInterfase.TipoArchivo;
import modelo.ContenidoAudiovisual;

/**
 * Clase para gestionar archivos planos de contenidos audiovisuales.
 */
public class ArchivoPlano implements TipoArchivo {

	private static final String SEPARADOR_DEFECTO = "|"; // Separador por defecto para los registros.
	private String separador; // Separador utilizado en el archivo.
	private String[] cabecera; // Cabecera del archivo, usada como referencia para los atributos.

	/**
	 * Constructor por defecto que utiliza el separador estándar.
	 */
	public ArchivoPlano() {
		this.separador = SEPARADOR_DEFECTO;
	}

	/**
	 * Constructor que permite configurar un separador personalizado.
	 *
	 * @param separador Separador a utilizar.
	 */
	public ArchivoPlano(String separador) {
		this.separador = separador;
	}

	/**
	 * Establece la cabecera del archivo a partir de un registro.
	 *
	 * @param registro Registro que contiene los nombres de los atributos separados
	 *                 por el separador.
	 */
	@Override
	public void setCabecera(String registro) {
		this.cabecera = registro.split(separador.equals(SEPARADOR_DEFECTO) ? "\\" + separador : separador);
	}

	/**
	 * Genera un registro de texto a partir de un objeto de tipo
	 * ContenidoAudiovisual.
	 *
	 * @param continAudiovisual Objeto a serializar.
	 * @return Registro en formato de texto plano.
	 */
	@Override
	public String obtenerRegistro(ContenidoAudiovisual continAudiovisual) {
		return String.join(separador, continAudiovisual.obtenerAtributos().stream().map(Object::toString).toList());
	}

	/**
	 * Genera una entidad de tipo ContenidoAudiovisual a partir de un registro de
	 * texto.
	 *
	 * @param tipoContenido Clase de la entidad a crear.
	 * @param registro      Registro en formato de texto plano.
	 * @param <T>           Tipo genérico que extiende ContenidoAudiovisual.
	 * @return Instancia de la entidad creada.
	 */
	@Override
	public <T extends ContenidoAudiovisual> T obtenerEntidad(Class<T> tipoContenido, String registro) {
		String[] atributosSinProcesar = registro
				.split(separador.equals(SEPARADOR_DEFECTO) ? "\\" + separador : separador);
		try {
			T entidad = tipoContenido.getDeclaredConstructor().newInstance(); // Crea una instancia de la clase.
			Set<String> listaCabecera = new HashSet<>();
			int contadorCabecera = 0;

			for (String atributo : atributosSinProcesar) {
				if (esLista(atributo) >= 0) { // Detecta listas en los atributos.
					contadorCabecera = esLista(atributo);
					if (!listaCabecera.add(cabecera[contadorCabecera])) {
						listaCabecera.remove(cabecera[contadorCabecera]);
						if (!listaCabecera.isEmpty()) {
							contadorCabecera = esLista(listaCabecera.iterator().next());
						}
					}
				}
				entidad.setAtributo(cabecera[contadorCabecera], atributo); // Asigna el atributo correspondiente.
				if (listaCabecera.isEmpty() && contadorCabecera < cabecera.length - 1) {
					contadorCabecera++;
				}
			}
			return entidad;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new RuntimeException("Error al instanciar la entidad: " + tipoContenido.getName(), e);
		}
	}

	/**
	 * Devuelve el índice de un atributo que puede ser una lista.
	 *
	 * @param valor Valor del atributo.
	 * @return Índice del atributo si es válido, -1 en caso contrario.
	 */
	private int esLista(String valor) {
		for (int i = 0; i < cabecera.length; i++) {
			if (cabecera[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Genera una cabecera en formato de texto plano a partir de un objeto.
	 *
	 * @param continAudiovisual Objeto que proporciona los nombres de los atributos.
	 * @return Cabecera en formato de texto plano.
	 */
	@Override
	public String obtenerCabecera(ContenidoAudiovisual continAudiovisual) {
		return String.join(separador, continAudiovisual.obtenerCabecera());
	}
}
