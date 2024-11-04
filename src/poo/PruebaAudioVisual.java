package poo;
import java.util.ArrayList;

import uni1a.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[10];
        String[] actoresAvatar = {
        	    "Sam Worthington",
        	    "Zoe Saldaña",
        	    "Sigourney Weaver",
        	    "Stephen Lang",
        	    "Giovanni Ribisi",
        	    "Michelle Rodriguez",
        	    "Joel David Moore",
        	    "CCH Pounder",
        	    "Wes Studi",
        	    "Laz Alonso",
        	    "Kate Winslet",
        	    "Cliff Curtis",
        	    "Britain Dalton",
        	    "Jamie Flatters",
        	    "Trinity Jo-Li Bliss",
        	    "Jack Champion"
        	};
        
        String[] actoresGameOfThrones = {
        	    "Emilia Clarke",
        	    "Kit Harington",
        	    "Peter Dinklage",
        	    "Lena Headey",
        	    "Nikolaj Coster-Waldau",
        	    "Sophie Turner",
        	    "Maisie Williams",
        	    "Sean Bean",
        	    "Isaac Hempstead Wright",
        	    "Richard Madden",
        	    "Iain Glen",
        	    "Alfie Allen",
        	    "Conleth Hill",
        	    "John Bradley",
        	    "Liam Cunningham",
        	    "Gwendoline Christie",
        	    "Rory McCann",
        	    "Natalie Dormer",
        	    "Charles Dance",
        	    "Aidan Gillen"
        	};
     
        String[] actoresTheOffice = {
            "Steve Carell",
            "John Krasinski",
            "Rainn Wilson",
            "Jenna Fischer",
            "Mindy Kaling",
            "BJ Novak",
            "Ed Helms",
            "Ellie Kemper",
            "Craig Robinson",
            "James Spader"
        };

        String[] actores40YearOldVirgin = {
            "Steve Carell",
            "Paul Rudd",
            "Seth Rogen",
            "Catherine Keener",
            "Elizabeth Banks",
            "Jane Lynch",
            "Romany Malco",
            "Mindy Kaling", 
            "Leslie Mann"
        };

        String[] actoresParksAndRec = {
            "Amy Poehler",
            "Nick Offerman",
            "Aubrey Plaza",
            "Chris Pratt",
            "Rashida Jones",
            "Rob Lowe",
            "Adam Scott",
            "Retta",
            "Aziz Ansari",
            "Ben Schwartz"
        };

        String[] actoresGuardiansOfTheGalaxy = {
            "Chris Pratt",
            "Zoe Saldaña",
            "Dave Bautista",
            "Vin Diesel",
            "Bradley Cooper",
            "Michael Rooker",
            "Karen Gillan",
            "Lee Pace",
            "Glenn Close"
        };

        String[] actoresBreakingBad = {
            "Bryan Cranston",
            "Aaron Paul",
            "Anna Gunn",
            "Dean Norris",
            "Betsy Brandt",
            "RJ Mitte",
            "Bob Odenkirk",
            "Jonathan Banks",
            "Giancarlo Esposito",
            "Michael McKean"
        };
        
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", actoresAvatar);
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy",  new ArrayList<Temporada>(), actoresGameOfThrones);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy", new Investigador("Carl Sagan"));
        contenidos[3] = new VideoMusical("Back in Black", 4, "Rock", "Atlantic Records", "AC/DC");
        contenidos[4] = new Tutorial("Arreglar Computadora", 30, "Educativo", "Reparación de computadoras", "Juan Pérez");
        contenidos[5] = new SerieDeTV("The Office", 22, "Comedy", new ArrayList<Temporada>(), actoresTheOffice);
        contenidos[6] = new Pelicula("The 40-Year-Old Virgin", 116, "Comedy", "Universal Pictures", actores40YearOldVirgin);
        contenidos[7] = new SerieDeTV("Parks and Recreation", 22, "Comedy", new ArrayList<Temporada>(), actoresParksAndRec);
        contenidos[8] = new Pelicula("Guardians of the Galaxy", 121, "Sci-Fi", "Marvel Studios", actoresGuardiansOfTheGalaxy);
        contenidos[9] = new SerieDeTV("Breaking Bad", 47, "Drama", new ArrayList<Temporada>(), actoresBreakingBad);

        
        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
        
        // Mostrar del actor Steve Carell
        Actor.getActor("Steve Carell").mostrarDetalles();
        
        // Mostrar del actor Zoe Saldaña
        Actor.getActor("Zoe Saldaña").mostrarDetalles();
        
        // Mostrar del actor Chris Pratt
        Actor.getActor("Chris Pratt").mostrarDetalles();
       
    }
}