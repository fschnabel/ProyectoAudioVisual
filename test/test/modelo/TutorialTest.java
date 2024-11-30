package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Tutorial;

public class TutorialTest {

    @Test
    public void testConstructorTutorial() {
        Tutorial tutorial = new Tutorial("Java Básico", 120, "Educativo", "Programación", "John Doe");

        assertEquals("Java Básico", tutorial.getTitulo());
        assertEquals(120, tutorial.getDuracionEnMinutos());
        assertEquals("Educativo", tutorial.getGenero());
        assertEquals("Programación", tutorial.getMateria());
        assertEquals("John Doe", tutorial.getExpositor());
    }

    @Test
    public void testSetMateria() {
        Tutorial tutorial = new Tutorial();
        tutorial.setMateria("Matemáticas");
        assertEquals("Matemáticas", tutorial.getMateria());
    }

    @Test
    public void testSetExpositor() {
        Tutorial tutorial = new Tutorial();
        tutorial.setExpositor("Jane Smith");
        assertEquals("Jane Smith", tutorial.getExpositor());
    }

    @Test
    public void testObtenerAtributos() {
        Tutorial tutorial = new Tutorial("Cálculo Integral", 90, "Matemáticas", "Cálculo", "Dr. Euler");
        List<Object> atributos = tutorial.obtenerAtributos();

        assertTrue(atributos.contains("Cálculo Integral"));
        assertTrue(atributos.contains(90));
        assertTrue(atributos.contains("Cálculo"));
        assertTrue(atributos.contains("Dr. Euler"));
    }

    @Test
    public void testObtenerCabecera() {
        Tutorial tutorial = new Tutorial("Python Avanzado", 150, "Programación", "Python", "Guido van Rossum");
        List<String> cabecera = tutorial.obtenerCabecera();

        assertTrue(cabecera.contains("materia"));
        assertTrue(cabecera.contains("expositor"));
    }
}
