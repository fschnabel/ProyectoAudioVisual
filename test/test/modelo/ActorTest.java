package test.modelo;

import org.junit.jupiter.api.Test;

import modelo.Actor;
import modelo.ContenidoAudiovisual;
import modelo.Pelicula;
import modelo.SerieDeTV;
import modelo.Temporada;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ActorTest {

	@Test
	public void testGetActorCreacion() {
		Actor actor = Actor.getActor("Leonardo DiCaprio");
		assertNotNull(actor);
		assertEquals("Leonardo DiCaprio", actor.getNombre());
	}

	@Test
	public void testGetActorExistente() {
		Actor actor1 = Actor.getActor("Brad Pitt");
		Actor actor2 = Actor.getActor("Brad Pitt");
		assertSame(actor1, actor2); // Verifica que ambas referencias son al mismo objeto.
	}

	@Test
	public void testAgregarProduccion() {
		String[] actoresAvatar = { "Sam Worthington", "Zoe Saldaña", "Sigourney Weaver", "Stephen Lang",
				"Giovanni Ribisi", "Michelle Rodriguez", "Joel David Moore", "CCH Pounder", "Wes Studi", "Laz Alonso",
				"Kate Winslet", "Cliff Curtis", "Britain Dalton", "Jamie Flatters", "Trinity Jo-Li Bliss",
				"Jack Champion" };
		Actor actor = Actor.getActor("Zoe Saldaña");
		ContenidoAudiovisual produccion = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actoresAvatar);
		List<ContenidoAudiovisual> producciones = actor.getProducciones();
		assertTrue(producciones.contains(produccion));
	}

	@Test
	public void testGetProducciones() {
		Actor actor = Actor.getActor("Steve Carell");
		String[] actoresTheOffice = { "Steve Carell", "John Krasinski", "Rainn Wilson", "Jenna Fischer", "Mindy Kaling",
				"BJ Novak", "Ed Helms", "Ellie Kemper", "Craig Robinson", "James Spader" };

		String[] actores40YearOldVirgin = { "Steve Carell", "Paul Rudd", "Seth Rogen", "Catherine Keener",
				"Elizabeth Banks", "Jane Lynch", "Romany Malco", "Mindy Kaling", "Leslie Mann" };

		ContenidoAudiovisual produccion1 = new Pelicula("The 40-Year-Old Virgin", 116, "Comedy", "Universal Pictures",
				actores40YearOldVirgin);
		ContenidoAudiovisual produccion2 = new SerieDeTV("The Office", 22, "Comedy", new ArrayList<Temporada>(),
				actoresTheOffice);

		List<ContenidoAudiovisual> producciones = actor.getProducciones();
		assertEquals(2, producciones.size());
		assertTrue(producciones.contains(produccion1));
		assertTrue(producciones.contains(produccion2));
	}
}
