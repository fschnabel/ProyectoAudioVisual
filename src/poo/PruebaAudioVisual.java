package poo;

import java.util.ArrayList;
import java.util.List;

import VistaInterfase.TipoArchivo;
import controlador.ControladorArchivo;
import modelo.*;
import vista.ArchivoPlano;
import vista.VistaArchivo;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Inicio de la prueba de contenidos audiovisuales.\n");

        // Crear contenidos audiovisuales
        ContenidoAudiovisual[] contenidos = crearContenidos();

        // Mostrar detalles de cada contenido audiovisual
        mostrarDetallesContenidos(contenidos);

        // Mostrar detalles de actores específicos
        mostrarDetallesActores("Steve Carell", "Zoe Saldaña", "Chris Pratt");

        // Exportar y luego importar contenidos de películas
        exportarImportarPeliculas(contenidos);

        // Exportar series de TV
        exportarSeriesTV(contenidos);

        System.out.println("Fin de la prueba de contenidos audiovisuales.");
    }

    private static ContenidoAudiovisual[] crearContenidos() {
        String[] actoresAvatar = { "Sam Worthington", "Zoe Saldaña", "Sigourney Weaver", "Stephen Lang",
                "Giovanni Ribisi", "Michelle Rodriguez", "Joel David Moore", "CCH Pounder", "Wes Studi", "Laz Alonso",
                "Kate Winslet", "Cliff Curtis", "Britain Dalton", "Jamie Flatters", "Trinity Jo-Li Bliss",
                "Jack Champion" };

        String[] actoresGameOfThrones = { "Emilia Clarke", "Kit Harington", "Peter Dinklage", "Lena Headey",
                "Nikolaj Coster-Waldau", "Sophie Turner", "Maisie Williams", "Sean Bean", "Isaac Hempstead Wright",
                "Richard Madden", "Iain Glen", "Alfie Allen", "Conleth Hill", "John Bradley", "Liam Cunningham",
                "Gwendoline Christie", "Rory McCann", "Natalie Dormer", "Charles Dance", "Aidan Gillen" };

        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[10];
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actoresAvatar);
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", new ArrayList<>(), actoresGameOfThrones);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy", new Investigador("Carl Sagan"));
        contenidos[3] = new VideoMusical("Back in Black", 4, "Rock", "Atlantic Records", "AC/DC");
        contenidos[4] = new Tutorial("Arreglar Computadora", 30, "Educativo", "Reparación de computadoras",
                "Juan Pérez");
        contenidos[5] = new SerieDeTV("The Office", 22, "Comedy", new ArrayList<>(), new String[] { "Steve Carell" });
        contenidos[6] = new Pelicula("The 40-Year-Old Virgin", 116, "Comedy", "Universal Pictures",
                new String[] { "Steve Carell", "Paul Rudd" });
        contenidos[7] = new SerieDeTV("Parks and Recreation", 22, "Comedy", new ArrayList<>(),
                new String[] { "Amy Poehler", "Nick Offerman" });
        contenidos[8] = new Pelicula("Guardians of the Galaxy", 121, "Sci-Fi", "Marvel Studios",
                new String[] { "Chris Pratt", "Zoe Saldaña" });
        contenidos[9] = new SerieDeTV("Breaking Bad", 47, "Drama", new ArrayList<>(),
                new String[] { "Bryan Cranston", "Aaron Paul" });

        return contenidos;
    }

    private static void mostrarDetallesContenidos(ContenidoAudiovisual[] contenidos) {
        System.out.println("Detalles de los contenidos audiovisuales:\n");
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
        System.out.println();
    }

    private static void mostrarDetallesActores(String... nombresActores) {
        System.out.println("Detalles de actores seleccionados:\n");
        for (String nombre : nombresActores) {
            Actor.getActor(nombre).mostrarDetalles();
        }
        System.out.println();
    }

    private static void exportarImportarPeliculas(ContenidoAudiovisual[] contenidos) {
        System.out.println("Exportando e importando películas...\n");
        ArrayList<ContenidoAudiovisual> registrosPeliculas = new ArrayList<>();
        registrosPeliculas.add(contenidos[0]);
        registrosPeliculas.add(contenidos[6]);
        registrosPeliculas.add(contenidos[8]);

        VistaArchivo vistaArchivo = new VistaArchivo();
        TipoArchivo tipoArchivo = new ArchivoPlano(",");
        ControladorArchivo controladorArchivo = new ControladorArchivo(registrosPeliculas, vistaArchivo);
        controladorArchivo.exportarArchivo("peliculas.txt", tipoArchivo);

        List<Pelicula> peliculas = controladorArchivo.importarArchivo(Pelicula.class, "peliculas.txt", tipoArchivo);
        System.out.println("Películas importadas:");
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarDetalles();
        }
        System.out.println();
    }

    private static void exportarSeriesTV(ContenidoAudiovisual[] contenidos) {
        System.out.println("Exportando series de TV...\n");
        ArrayList<ContenidoAudiovisual> registrosSeriesTV = new ArrayList<>();
        registrosSeriesTV.add(contenidos[1]);
        registrosSeriesTV.add(contenidos[5]);
        registrosSeriesTV.add(contenidos[7]);
        registrosSeriesTV.add(contenidos[9]);

        VistaArchivo vistaArchivo = new VistaArchivo();
        TipoArchivo tipoArchivo = new ArchivoPlano(",");
        ControladorArchivo controladorArchivo = new ControladorArchivo(registrosSeriesTV, vistaArchivo);
        controladorArchivo.exportarArchivo("seriesTV.txt", tipoArchivo);
        System.out.println("Series de TV exportadas exitosamente.\n");
    }
}
