package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Actor;
import modelo.Pelicula;

public class PeliculaTest {

    @Test
    public void testConstructorPelicula() {
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros", new String[]{"Leonardo DiCaprio", "Joseph Gordon-Levitt"});
        
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(148, pelicula.getDuracionEnMinutos());
        assertEquals("Ciencia Ficción", pelicula.getGenero());
        assertEquals("Warner Bros", pelicula.getEstudio());
        assertEquals(2, pelicula.getActores().size());
    }

    @Test
    public void testSetEstudio() {
        Pelicula pelicula = new Pelicula();
        pelicula.setEstudio("Pixar");
        assertEquals("Pixar", pelicula.getEstudio());
    }

    @Test
    public void testSetActores() {
        Pelicula pelicula = new Pelicula();
        List<Actor> actores = List.of(Actor.getActor("Tom Hanks"), Actor.getActor("Tim Allen"));
        pelicula.setActores(actores);

        assertEquals(2, pelicula.getActores().size());
        assertTrue(pelicula.getActores().stream().anyMatch(actor -> actor.getNombre().equals("Tom Hanks")));
    }

    @Test
    public void testMostrarDetalles() {
        Pelicula pelicula = new Pelicula("Toy Story", 81, "Animación", "Pixar", new String[]{"Tom Hanks", "Tim Allen"});
        pelicula.mostrarDetalles();
        // Verificar visualmente la salida o redirigir la salida estándar para comparar.
    }
}
