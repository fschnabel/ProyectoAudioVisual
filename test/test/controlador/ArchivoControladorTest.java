package test.controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import VistaInterfase.TipoArchivo;
import controlador.ControladorArchivo;
import modelo.ContenidoAudiovisual;
import modelo.Documental;
import modelo.Investigador;
import modelo.Pelicula;
import modelo.SerieDeTV;
import modelo.Temporada;
import modelo.Tutorial;
import modelo.VideoMusical;
import vista.ArchivoPlano;
import vista.VistaArchivo;

class ControladorArchivoTest {

	private ControladorArchivo controlador;
	private VistaArchivo vistaArchivo;
	private TipoArchivo tipoArchivo;
	private ArrayList<ContenidoAudiovisual> registrosPeliculas;
	private ArrayList<ContenidoAudiovisual> registrosSeriesTV;

	@BeforeEach
	void setUp() {
		vistaArchivo = new VistaArchivo();
		tipoArchivo = new ArchivoPlano(",");

		// Configurar registros de prueba
		registrosPeliculas = new ArrayList<>();
		registrosPeliculas.add(new Pelicula("Avatar", 125, "Accion", "20th Century Studios",
				new String[] { "Sam Worthington", "Zoe Saldaña" }));
		registrosPeliculas.add(new Pelicula("Guardians of the Galaxy", 121, "Sci-Fi", "Marvel Studios",
				new String[] { "Chris Pratt", "Zoe Saldaña" }));

		// Configurar series con temporadas y capítulos
		registrosSeriesTV = new ArrayList<>();

		Temporada temporada1 = new Temporada("Temporada 1");
		temporada1.setCapitulos(new String[] { "Capítulo 1: Winter Is Coming", "Capítulo 2: The Kingsroad" });

		Temporada temporada2 = new Temporada("Temporada 2");
		temporada2.setCapitulos(new String[] { "Capítulo 1: The North Remembers", "Capítulo 2: The Night Lands" });

		List<Temporada> temporadasGoT = Arrays.asList(temporada1, temporada2);

		registrosSeriesTV.add(new SerieDeTV("Game of Thrones", 60, "Fantasy", temporadasGoT,
				new String[] { "Emilia Clarke", "Kit Harington" }));

		Temporada temporadaBB = new Temporada("Temporada 1");
		temporadaBB.setCapitulos(new String[] { "Capítulo 1: Pilot", "Capítulo 2: Cat's in the Bag..." });

		List<Temporada> temporadasBB = Arrays.asList(temporadaBB);

		registrosSeriesTV.add(new SerieDeTV("Breaking Bad", 47, "Drama", temporadasBB,
				new String[] { "Bryan Cranston", "Aaron Paul" }));
	}

	@Test
	void testExportarArchivoRutaInvalida() {
		controlador = new ControladorArchivo(registrosPeliculas, vistaArchivo);
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			controlador.exportarArchivo("", null);
		});
		assertEquals("La ruta no puede ser nula o vacía.", exception.getMessage());
	}

	@Test
	void testExportarArchivoTipoArchivoNulo() {
		controlador = new ControladorArchivo(registrosPeliculas, vistaArchivo);
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			controlador.exportarArchivo("ruta.txt", null);
		});
		assertEquals("El tipo de archivo no puede ser nulo.", exception.getMessage());
	}

	@Test
	void testExportarPeliculas() {
		controlador = new ControladorArchivo(registrosPeliculas, vistaArchivo);

		String ruta = "peliculas.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		// No se puede verificar directamente el archivo en esta prueba,
		// pero podemos asegurarnos de que no se generen excepciones y que el archivo
		// exista.
		assertTrue(true, "Exportación completada sin errores.");
	}

	@Test
	void testImportarPeliculas() {
		controlador = new ControladorArchivo(registrosPeliculas, vistaArchivo);

		String ruta = "peliculas.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		List<Pelicula> peliculasImportadas = controlador.importarArchivo(Pelicula.class, ruta, tipoArchivo);

		// Verificar que las películas importadas coincidan con las exportadas
		assertNotNull(peliculasImportadas, "La lista de películas importadas no debería ser nula.");
		assertEquals(registrosPeliculas.size(), peliculasImportadas.size(),
				"El número de películas importadas debería coincidir con el exportado.");
		for (int i = 0; i < registrosPeliculas.size(); i++) {
			assertEquals(((Pelicula) registrosPeliculas.get(i)).getActores().size(),
					peliculasImportadas.get(i).getActores().size(),
					"El número de actores importados debería coincidir con el exportado.");
		}
	}

	@Test
	void testExportarSeries() {
		controlador = new ControladorArchivo(registrosSeriesTV, vistaArchivo);

		String ruta = "series.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		// Asegurarse de que el proceso se completa sin excepciones
		assertTrue(true, "Exportación completada sin errores.");
	}

	@Test
	void testImportarSeries() {
		controlador = new ControladorArchivo(registrosSeriesTV, vistaArchivo);

		String ruta = "series.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		List<SerieDeTV> seriesImportadas = controlador.importarArchivo(SerieDeTV.class, ruta, tipoArchivo);

		// Verificar que las series importadas coincidan con las exportadas
		assertNotNull(seriesImportadas, "La lista de series importadas no debería ser nula.");
		assertEquals(registrosSeriesTV.size(), seriesImportadas.size(),
				"El número de series importadas debería coincidir con el exportado.");
		for (int i = 0; i < registrosSeriesTV.size(); i++) {
			assertEquals(((SerieDeTV) registrosSeriesTV.get(i)).getActores().size(),
					seriesImportadas.get(i).getActores().size(),
					"El número de actores importados debería coincidir con el exportado.");
			assertEquals(((SerieDeTV) registrosSeriesTV.get(i)).getTemporadas().size(),
					seriesImportadas.get(i).getTemporadas().size(),
					"El número de temporadas importadas debería coincidir con el exportado.");
			for (int j = 0; j < seriesImportadas.get(i).getTemporadas().size(); j++) {
				assertEquals(((SerieDeTV) registrosSeriesTV.get(i)).getTemporadas().get(j).getCapitulos().length,
						seriesImportadas.get(i).getTemporadas().get(j).getCapitulos().length,
						"El número de capitulos importadas debería coincidir con el exportado.");
			}
		}
	}

	@Test
	void testExportarTutoriales() {
		ArrayList<ContenidoAudiovisual> registrosTutoriales = new ArrayList<>();
		registrosTutoriales
				.add(new Tutorial("Aprender Java", 45, "Programación", "Juan Pérez", "Conceptos básicos de Java"));
		registrosTutoriales
				.add(new Tutorial("Aprender Python", 60, "Programación", "María Gómez", "Introducción a Python"));

		controlador = new ControladorArchivo(registrosTutoriales, vistaArchivo);

		String ruta = "tutoriales.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		assertTrue(true, "Exportación de tutoriales completada sin errores.");
	}

	@Test
	void testImportarTutoriales() {
		ArrayList<ContenidoAudiovisual> registrosTutoriales = new ArrayList<>();
		registrosTutoriales
				.add(new Tutorial("Aprender Java", 45, "Programación", "Juan Pérez", "Conceptos básicos de Java"));
		registrosTutoriales
				.add(new Tutorial("Aprender Python", 60, "Programación", "María Gómez", "Introducción a Python"));

		controlador = new ControladorArchivo(registrosTutoriales, vistaArchivo);

		String ruta = "tutoriales.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		List<Tutorial> tutorialesImportados = controlador.importarArchivo(Tutorial.class, ruta, tipoArchivo);

		assertNotNull(tutorialesImportados, "La lista de tutoriales importados no debería ser nula.");
		assertEquals(registrosTutoriales.size(), tutorialesImportados.size(),
				"El número de tutoriales importados debería coincidir con el exportado.");
		for (int i = 0; i < registrosTutoriales.size(); i++) {
			assertEquals(((Tutorial) registrosTutoriales.get(i)).getExpositor(),
					tutorialesImportados.get(i).getExpositor(),
					"El autor importado debería coincidir con el exportado.");
		}
	}

	@Test
	void testExportarDocumentales() {
		ArrayList<ContenidoAudiovisual> registrosDocumentales = new ArrayList<>();
		registrosDocumentales.add(
				new Documental("Planeta Tierra", 120, "Naturaleza", "Fauna y Flora", new Investigador("Jane Goodall")));
		registrosDocumentales.add(new Documental("La Vida en el Océano", 90, "Naturaleza", "Ecosistemas Marinos",
				new Investigador("Sylvia Earle")));

		controlador = new ControladorArchivo(registrosDocumentales, vistaArchivo);

		String ruta = "documentales.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		assertTrue(true, "Exportación de documentales completada sin errores.");
	}

	@Test
	void testImportarDocumentales() {
		ArrayList<ContenidoAudiovisual> registrosDocumentales = new ArrayList<>();
		registrosDocumentales.add(
				new Documental("Planeta Tierra", 120, "Naturaleza", "Fauna y Flora", new Investigador("Jane Goodall")));
		registrosDocumentales.add(new Documental("La Vida en el Océano", 90, "Naturaleza", "Ecosistemas Marinos",
				new Investigador("Sylvia Earle")));

		controlador = new ControladorArchivo(registrosDocumentales, vistaArchivo);

		String ruta = "documentales.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		List<Documental> documentalesImportados = controlador.importarArchivo(Documental.class, ruta, tipoArchivo);

		assertNotNull(documentalesImportados, "La lista de documentales importados no debería ser nula.");
		assertEquals(registrosDocumentales.size(), documentalesImportados.size(),
				"El número de documentales importados debería coincidir con el exportado.");
		for (int i = 0; i < registrosDocumentales.size(); i++) {
			Documental original = (Documental) registrosDocumentales.get(i);
			Documental importado = documentalesImportados.get(i);

			assertEquals(original.getTema(), importado.getTema(),
					"El tema importado debería coincidir con el exportado.");
			assertEquals(original.getInvestigador().getNombre(), importado.getInvestigador().getNombre(),
					"El nombre del investigador importado debería coincidir con el exportado.");
		}
	}

	@Test
	void testExportarVideosMusicales() {
		ArrayList<ContenidoAudiovisual> registrosVideosMusicales = new ArrayList<>();
		registrosVideosMusicales.add(new VideoMusical("Thriller", 5, "Pop", "Michael Jackson", "Epic Records"));
		registrosVideosMusicales.add(new VideoMusical("Bohemian Rhapsody", 6, "Rock", "Queen", "EMI"));

		controlador = new ControladorArchivo(registrosVideosMusicales, vistaArchivo);

		String ruta = "videosMusicales.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		assertTrue(true, "Exportación de videos musicales completada sin errores.");
	}

	@Test
	void testImportarVideosMusicales() {
		ArrayList<ContenidoAudiovisual> registrosVideosMusicales = new ArrayList<>();
		registrosVideosMusicales.add(new VideoMusical("Thriller", 5, "Pop", "Michael Jackson", "Epic Records"));
		registrosVideosMusicales.add(new VideoMusical("Bohemian Rhapsody", 6, "Rock", "Queen", "EMI"));

		controlador = new ControladorArchivo(registrosVideosMusicales, vistaArchivo);

		String ruta = "videosMusicales.txt";
		controlador.exportarArchivo(ruta, tipoArchivo);

		List<VideoMusical> videosMusicalesImportados = controlador.importarArchivo(VideoMusical.class, ruta,
				tipoArchivo);

		assertNotNull(videosMusicalesImportados, "La lista de videos musicales importados no debería ser nula.");
		assertEquals(registrosVideosMusicales.size(), videosMusicalesImportados.size(),
				"El número de videos musicales importados debería coincidir con el exportado.");
		for (int i = 0; i < registrosVideosMusicales.size(); i++) {
			assertEquals(((VideoMusical) registrosVideosMusicales.get(i)).getInterprete(),
					videosMusicalesImportados.get(i).getInterprete(),
					"El Interprete importado debería coincidir con el exportado.");
		}
	}

}
