package modelo;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase abstracta que representa contenido audiovisual.
 */
public abstract class ContenidoAudiovisual {
	private static int contador = 0; // Contador para generar IDs únicos.
	private final int id; // ID único de la instancia.
	private String titulo; // Título del contenido audiovisual.
	private int duracionEnMinutos; // Duración en minutos.
	private String genero; // Género del contenido.

    /**
     * Constructor vacío con ID por defecto 0.
     */
	public ContenidoAudiovisual() {
		this.id = 0;
	}

	/**
	 * Constructor principal para inicializar un contenido audiovisual.
	 *
	 * @param titulo            Título del contenido.
	 * @param duracionEnMinutos Duración en minutos, debe ser mayor a 0.
	 * @param genero            Género, no puede ser nulo o vacío.
	 */
	public ContenidoAudiovisual(final String titulo, final int duracionEnMinutos, final String genero) {
		if (duracionEnMinutos <= 0) {
			throw new IllegalArgumentException("La duración debe ser mayor a 0.");
		}
		this.id = contador++;
		this.titulo = titulo != null ? titulo : "Desconocido";
		this.duracionEnMinutos = duracionEnMinutos;
		this.genero = genero != null ? genero : "Sin género";
	}

	/**
	 * Métodos getter y setter: acceden y modifican atributos del contenido.
	 */
	public int getId() { return id; }
	public String getTitulo() { return titulo; }
	public void setTitulo(final String titulo) { 
		if (titulo == null || titulo.isEmpty()) throw new IllegalArgumentException("El título no puede ser nulo o vacío."); 
		this.titulo = titulo; 
	}
	public int getDuracionEnMinutos() { return duracionEnMinutos; }
	public void setDuracionEnMinutos(final int duracionEnMinutos) { 
		if (duracionEnMinutos <= 0) throw new IllegalArgumentException("La duración debe ser mayor a 0."); 
		this.duracionEnMinutos = duracionEnMinutos; 
	}
	public String getGenero() { return genero; }
	public void setGenero(final String genero) { 
		if (genero == null || genero.isEmpty()) throw new IllegalArgumentException("El género no puede ser nulo o vacío."); 
		this.genero = genero; 
	}

	/**
	 * Muestra detalles del contenido audiovisual.
	 */
	public void mostrarDetalles() {
		System.out.println("ID: " + getId());
		System.out.println("Título: " + getTitulo());
		System.out.println("Duración en minutos: " + getDuracionEnMinutos());
		System.out.println("Género: " + getGenero());
	}

	/**
	 * Obtiene los atributos del contenido.
	 *
	 * @return Lista de atributos.
	 */
	public List<Object> obtenerAtributos() {
		List<Object> atributos = new ArrayList<>();
		atributos.add(this.titulo);
		atributos.add(this.duracionEnMinutos);
		atributos.add(this.genero);
		return atributos;
	}

	/**
	 * Obtiene los nombres de columnas de los atributos.
	 *
	 * @return Lista de nombres de columnas.
	 */
	public List<String> obtenerCabecera() {
		List<String> cabecera = new ArrayList<>();
		cabecera.add("titulo");
		cabecera.add("duracionEnMinutos");
		cabecera.add("genero");
		return cabecera;
	}

	/**
	 * Modifica un atributo específico por nombre.
	 *
	 * @param nombre Nombre del atributo.
	 * @param valor  Valor a establecer.
	 */
	public void setAtributo(String nombre, String valor) {
		switch (nombre) {
			case "titulo": titulo = valor; break;
			case "duracionEnMinutos": duracionEnMinutos = Integer.parseInt(valor); break;
			case "genero": genero = valor; break;
		}
	}
}
