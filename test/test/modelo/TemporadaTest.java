package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Temporada;

public class TemporadaTest {

    @Test
    public void testConstructorConNombre() {
        Temporada temporada = new Temporada("Temporada 1");
        assertEquals("Temporada 1", temporada.getNombreTemporada());
        assertEquals(0, temporada.getCapitulos().length);
    }

    @Test
    public void testAgregarCapitulo() {
        Temporada temporada = new Temporada("Temporada 2");
        temporada.addCapitulos("Capítulo 1");
        temporada.addCapitulos("Capítulo 2");

        assertEquals(2, temporada.getCapitulos().length);
        assertEquals("Capítulo 1", temporada.getCapitulos()[0]);
        assertEquals("Capítulo 2", temporada.getCapitulos()[1]);
    }

    @Test
    public void testSetCapitulos() {
        Temporada temporada = new Temporada("Temporada 3");
        String[] capitulos = {"Capítulo 1", "Capítulo 2", "Capítulo 3"};
        temporada.setCapitulos(capitulos);

        assertEquals(3, temporada.getCapitulos().length);
        assertEquals("Capítulo 1", temporada.getCapitulos()[0]);
    }

    @Test
    public void testObtenerAtributos() {
        Temporada temporada = new Temporada("Temporada 4");
        temporada.addCapitulos("Capítulo 1");
        temporada.addCapitulos("Capítulo 2");

        List<Object> atributos = temporada.obtenerAtributos();
        assertTrue(atributos.contains("Temporada 4"));
        assertTrue(atributos.contains("Capítulo 1"));
        assertTrue(atributos.contains("Capítulo 2"));
    }

    @Test
    public void testObtenerCabecera() {
        Temporada temporada = new Temporada("Temporada 5");
        temporada.addCapitulos("Capítulo 1");
        temporada.addCapitulos("Capítulo 2");

        List<String> cabecera = temporada.obtenerCabecera();
        assertTrue(cabecera.contains("temporada"));
        assertEquals(3, cabecera.size()); // Incluye "temporada" + 2 capítulos.
    }
}
