package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	private String nombre;
	private List<Pelicula> peliculas;
	
	public Actor(String nombre) {
		this.setNombre(nombre);
	}
	
	public Actor(String nombre, Pelicula pelicula) {
		this.setNombre(nombre);
		this.agregarPelicula(pelicula);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public void agregarPelicula(Pelicula pelicula) {
		if (peliculas == null) {
			peliculas = new ArrayList<Pelicula>();
		}
		peliculas.add(pelicula);
	}
}
