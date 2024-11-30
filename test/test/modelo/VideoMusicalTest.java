package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.VideoMusical;

public class VideoMusicalTest {

    @Test
    public void testConstructorVideoMusical() {
        VideoMusical video = new VideoMusical("Thriller", 14, "Pop", "Epic Records", "Michael Jackson");

        assertEquals("Thriller", video.getTitulo());
        assertEquals(14, video.getDuracionEnMinutos());
        assertEquals("Pop", video.getGenero());
        assertEquals("Epic Records", video.getProductora());
        assertEquals("Michael Jackson", video.getInterprete());
    }

    @Test
    public void testSetProductora() {
        VideoMusical video = new VideoMusical();
        video.setProductora("Sony Music");
        assertEquals("Sony Music", video.getProductora());
    }

    @Test
    public void testSetInterprete() {
        VideoMusical video = new VideoMusical();
        video.setInterprete("Adele");
        assertEquals("Adele", video.getInterprete());
    }

    @Test
    public void testObtenerAtributos() {
        VideoMusical video = new VideoMusical("Rolling in the Deep", 4, "Pop", "Columbia Records", "Adele");
        List<Object> atributos = video.obtenerAtributos();

        assertTrue(atributos.contains("Rolling in the Deep"));
        assertTrue(atributos.contains("Columbia Records"));
        assertTrue(atributos.contains("Adele"));
    }

    @Test
    public void testObtenerCabecera() {
        VideoMusical video = new VideoMusical("Shape of You", 4, "Pop", "Atlantic Records", "Ed Sheeran");
        List<String> cabecera = video.obtenerCabecera();

        assertTrue(cabecera.contains("productora"));
        assertTrue(cabecera.contains("interprete"));
    }
}
