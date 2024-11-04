/**
 * Class Pelicula
 */
package uni1a;

import java.util.Arrays;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
	private String estudio;
	private Actor[] actores;

	public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio, String[] actores) {
		super(titulo, duracionEnMinutos, genero);
		this.estudio = estudio;
		this.setActores(Arrays.stream(actores).map(nombre -> Actor.getActor(nombre, this)).toArray(Actor[]::new));
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	public Actor[] getActores() {
		return actores;
	}

	public void setActores(Actor[] actores) {
		this.actores = actores;
	}

	@Override
	public void mostrarDetalles() {
		System.out.println("Detalles de la película:");
		super.mostrarDetalles();
		System.out.println("Estudio: " + estudio);
		System.out.println();
	}

	
}