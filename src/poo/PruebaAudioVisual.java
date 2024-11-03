package poo;
import uni1a.*;

public class PruebaAudioVisual {
	public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[3];
        String[] nombreActores = {"Juan", "María", "Pedro", "Ana"};
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios", nombreActores);
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy",  new Temporada[8]);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy", new Investigador());

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
}