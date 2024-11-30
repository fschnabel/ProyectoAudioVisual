package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.SerieDeTV;
import modelo.Temporada;

public class SerieDeTVTest {

    @Test
    public void testConstructorSerieDeTV() {
        Temporada temporada1 = new Temporada("Temporada 1");
        Temporada temporada2 = new Temporada("Temporada 2");
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 50, "Drama", List.of(temporada1, temporada2), new String[]{"Bryan Cranston", "Aaron Paul"});

        assertEquals("Breaking Bad", serie.getTitulo());
        assertEquals(50, serie.getDuracionEnMinutos());
        assertEquals("Drama", serie.getGenero());
        assertEquals(2, serie.getTemporadas().size());
        assertEquals(2, serie.getActores().size());
    }

    @Test
    public void testAgregarTemporada() {
        SerieDeTV serie = new SerieDeTV();
        serie.setAtributo("<temporadas>", "Temporada 1");
        assertEquals(1, serie.getTemporadas().size());
    }

    @Test
    public void testAgregarActor() {
        SerieDeTV serie = new SerieDeTV();
        serie.setAtributo("<actores>", "Bryan Cranston");
        assertEquals(1, serie.getActores().size());
        assertEquals("Bryan Cranston", serie.getActores().get(0).getNombre());
    }
}
