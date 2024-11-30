package test.vista;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.Tutorial;
import vista.ArchivoPlano;

public class ArchivoPlanoTest {

    @Test
    public void testObtenerRegistro() {
        Tutorial tutorial = new Tutorial("Java Básico", 120, "Educativo", "Programación", "John Doe");
        ArchivoPlano archivo = new ArchivoPlano();

        String registro = archivo.obtenerRegistro(tutorial);
        assertEquals("Java Básico|120|Educativo|Programación|John Doe", registro);
    }

    @Test
    public void testObtenerEntidad() {
        ArchivoPlano archivo = new ArchivoPlano();
        archivo.setCabecera("titulo|duracionEnMinutos|genero|materia|expositor");

        String registro = "Python Avanzado|150|Educativo|Programación|Guido van Rossum";
        Tutorial tutorial = archivo.obtenerEntidad(Tutorial.class, registro);

        assertEquals("Python Avanzado", tutorial.getTitulo());
        assertEquals(150, tutorial.getDuracionEnMinutos());
        assertEquals("Educativo", tutorial.getGenero());
        assertEquals("Programación", tutorial.getMateria());
        assertEquals("Guido van Rossum", tutorial.getExpositor());
    }

    @Test
    public void testObtenerCabecera() {
        Tutorial tutorial = new Tutorial("Java Básico", 120, "Educativo", "Programación", "John Doe");
        ArchivoPlano archivo = new ArchivoPlano();

        String cabecera = archivo.obtenerCabecera(tutorial);
        assertEquals("titulo|duracionEnMinutos|genero|materia|expositor", cabecera);
    }
}
