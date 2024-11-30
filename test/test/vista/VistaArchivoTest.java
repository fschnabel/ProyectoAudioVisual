package test.vista;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.ContenidoAudiovisual;
import modelo.Tutorial;
import vista.ArchivoPlano;
import vista.VistaArchivo;

public class VistaArchivoTest {

    @Test
    public void testLeerDatos() {
        String ruta = "test_tutorials.txt";
        ArchivoPlano archivoPlano = new ArchivoPlano();
        VistaArchivo vistaArchivo = new VistaArchivo();

        // Escribe un archivo de prueba.
        try (FileWriter escritor = new FileWriter(ruta)) {
            escritor.write("titulo|duracionEnMinutos|genero|materia|expositor\n");
            escritor.write("Java Básico|120|Educativo|Programación|John Doe\n");
        } catch (IOException e) {
            fail("Error al escribir el archivo de prueba.");
        }

        // Lee los datos del archivo.
        List<Tutorial> tutoriales = vistaArchivo.leerDatos(Tutorial.class, ruta, archivoPlano);
        assertNotNull(tutoriales);
        assertEquals(1, tutoriales.size());

        Tutorial tutorial = tutoriales.get(0);
        assertEquals("Java Básico", tutorial.getTitulo());
        assertEquals(120, tutorial.getDuracionEnMinutos());
        assertEquals("Educativo", tutorial.getGenero());
        assertEquals("Programación", tutorial.getMateria());
        assertEquals("John Doe", tutorial.getExpositor());

        // Limpia el archivo de prueba.
        new File(ruta).delete();
    }

    @Test
    public void testEscribirDatos() {
        String ruta = "test_write_tutorials.txt";
        ArchivoPlano archivoPlano = new ArchivoPlano();
        VistaArchivo vistaArchivo = new VistaArchivo();

        // Crea una lista de tutoriales.
        Tutorial tutorial = new Tutorial("Python Avanzado", 150, "Educativo", "Programación", "Guido van Rossum");
        List<ContenidoAudiovisual> tutoriales = List.of(tutorial);

        // Escribe los datos en el archivo.
        vistaArchivo.escribirDatos(tutoriales, ruta, archivoPlano);

        // Verifica que el archivo se creó.
        File archivo = new File(ruta);
        assertTrue(archivo.exists());

        // Limpia el archivo de prueba.
        archivo.delete();
    }
}

