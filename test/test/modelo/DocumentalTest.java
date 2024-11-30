package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.Documental;
import modelo.Investigador;

public class DocumentalTest {

    @Test
    public void testConstructorDocumental() {
        Investigador investigador = new Investigador("Jane Goodall");
        Documental documental = new Documental("El Mundo de los Primates", 120, "Documental", "Primates", investigador);

        assertEquals("El Mundo de los Primates", documental.getTitulo());
        assertEquals(120, documental.getDuracionEnMinutos());
        assertEquals("Documental", documental.getGenero());
        assertEquals("Primates", documental.getTema());
        assertEquals("Jane Goodall", documental.getInvestigador().getNombre());
    }

    @Test
    public void testSetTema() {
        Documental documental = new Documental();
        documental.setTema("Ecología");
        assertEquals("Ecología", documental.getTema());
    }

    @Test
    public void testSetInvestigador() {
        Documental documental = new Documental();
        Investigador investigador = new Investigador("David Attenborough");
        documental.setInvestigador(investigador);
        assertEquals("David Attenborough", documental.getInvestigador().getNombre());
    }

    @Test
    public void testMostrarDetalles() {
        Investigador investigador = new Investigador("Marie Curie");
        Documental documental = new Documental("Radiación y Salud", 90, "Ciencia", "Radiactividad", investigador);

        documental.mostrarDetalles();
        // Verifica la salida visualmente o redirige la salida estándar para comparar.
    }
}
