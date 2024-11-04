package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Actor {
	private String nombre;
	private List<ContenidoAudiovisual> producciones;
	
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
	
	public static Actor getActor(String nombre, ContenidoAudiovisual produccion) {
		if (actores == null) {
			actores = new ArrayList<Actor>();
		}
		Optional<Actor> buscarActor = actores.stream().filter(a -> a.nombre.equals(nombre)).findFirst();
		if (buscarActor.isPresent()) {
			buscarActor.get().agregarPelicula(produccion);
			return buscarActor.get();
		}else {
			Actor nuevoActor = new Actor(nombre, produccion);
			actores.add(nuevoActor);
			return nuevoActor;
		}
	}
	
	private Actor(String nombre) {
		this.setNombre(nombre);
	}
	
	private Actor(String nombre, ContenidoAudiovisual pelicula) {
		this.setNombre(nombre);
		this.agregarPelicula(pelicula);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ContenidoAudiovisual> getPeliculas() {
		return producciones;
	}

	public void setPeliculas(List<ContenidoAudiovisual> producciones) {
		this.producciones = producciones;
	}
	
	public void agregarPelicula(ContenidoAudiovisual produccion) {
		if (this.producciones == null) {
			this.producciones = new ArrayList<ContenidoAudiovisual>();
		}
		this.producciones.add(produccion);
	}
	
	public void mostrarDetalles() {
        System.out.println("Detalles del actor");
        System.out.println("nombre: " + this.nombre);
        System.out.println("Producciones Audio Visuales: ");
        for (ContenidoAudiovisual iterador : this.producciones) {
        	iterador.mostrarDetalles();
        }
        System.out.println();
    }
	
}
