package uni1a;

public class Tutorial extends ContenidoAudiovisual {
	private String materia;
	private String expositor;
	

	public Tutorial(String titulo, int duracionEnMinutos, String genero, String materia, String expositor) {
		super(titulo, duracionEnMinutos, genero);
		this.materia = materia;
		this.expositor = expositor;
	}


	public String getMateria() {
		return materia;
	}


	public void setMateria(String materia) {
		this.materia = materia;
	}


	public String getExpositor() {
		return expositor;
	}


	public void setExpositor(String expositor) {
		this.expositor = expositor;
	}

}
