package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Documental;
import modelo.Investigador;

public class InvestigadorTest {

    @Test
    public void testConstructorConNombre() {
        Investigador investigador = new Investigador("Stephen Hawking");
        assertEquals("Stephen Hawking", investigador.getNombre());
        assertTrue(investigador.getDocumental().isEmpty());
    }

    @Test
    public void testConstructorConNombreYDocumental() {
        Documental documental = new Documental("Breve Historia del Tiempo", 80, "Ciencia", "Cosmología", null);
        Investigador investigador = new Investigador("Stephen Hawking", documental);
        
        assertEquals("Stephen Hawking", investigador.getNombre());
        assertEquals(1, investigador.getDocumental().size());
        assertTrue(investigador.getDocumental().contains(documental));
    }

    @Test
    public void testAgregarDocumental() {
        Investigador investigador = new Investigador("Jane Goodall");
        Documental documental = new Documental("El Mundo de los Primates", 120, "Documental", "Primates", investigador);
        
        investigador.agregarDocumental(documental);
        List<Documental> documentales = investigador.getDocumental();
        
        assertEquals(1, documentales.size());
        assertTrue(documentales.contains(documental));
    }

    @Test
    public void testSetNombre() {
        Investigador investigador = new Investigador("David Attenborough");
        investigador.setNombre("Sir David Attenborough");
        assertEquals("Sir David Attenborough", investigador.getNombre());
    }

    @Test
    public void testSetDocumentales() {
        Investigador investigador = new Investigador("Carl Sagan");
        Documental documental1 = new Documental("Cosmos", 60, "Ciencia", "Espacio", investigador);
        Documental documental2 = new Documental("El Universo", 90, "Ciencia", "Astronomía", investigador);

        investigador.setDocumentales(List.of(documental1, documental2));
        List<Documental> documentales = investigador.getDocumental();

        assertEquals(2, documentales.size());
        assertTrue(documentales.contains(documental1));
        assertTrue(documentales.contains(documental2));
    }
}
