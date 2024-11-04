/**
 * Class SerieDeTV
 */
package uni1a;

import java.util.Arrays;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas;
    private List<Actor> actores;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, List<Temporada> temporadas, String[] actores) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.actores = Arrays.stream(actores).map(nombre -> Actor.getActor(nombre, this)).toList();
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }
    
	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Serie de TV:");
        super.mostrarDetalles();
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println();
    }


}