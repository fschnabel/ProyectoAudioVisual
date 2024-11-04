package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Actor {
	private String nombre;
	private List<Pelicula> peliculas;
	
	private static List<Actor> actores;
	
	public static Actor getActor(String nombre) {
		if (actores == null) {
			actores = new ArrayList<Actor>();
		}
		Optional<Actor> buscarActor = actores.stream().filter(a -> a.nombre.equals(nombre)).findFirst();
		if (buscarActor.isPresent()) {
			return buscarActor.get();
		}else {
			Actor nuevoActor = new Actor(nombre);
			actores.add(nuevoActor);
			return nuevoActor;
		}
	}
	
	public static Actor getActor(String nombre, Pelicula pelicula) {
		if (actores == null) {
			actores = new ArrayList<Actor>();
		}
		Optional<Actor> buscarActor = actores.stream().filter(a -> a.nombre.equals(nombre)).findFirst();
		if (buscarActor.isPresent()) {
			buscarActor.get().agregarPelicula(pelicula);
			return buscarActor.get();
		}else {
			Actor nuevoActor = new Actor(nombre, pelicula);
			actores.add(nuevoActor);
			return nuevoActor;
		}
	}
	
	private Actor(String nombre) {
		this.setNombre(nombre);
	}
	
	private Actor(String nombre, Pelicula pelicula) {
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
