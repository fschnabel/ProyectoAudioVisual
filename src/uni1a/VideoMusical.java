package uni1a;

public class VideoMusical extends ContenidoAudiovisual {
	private String productora;
	private String interprete;

	public VideoMusical(String titulo, int duracionEnMinutos, String genero, String productora, String interprete) {
		super(titulo, duracionEnMinutos, genero);
		this.productora =  productora;
		this.interprete = interprete;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public String getInterprete() {
		return interprete;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}
	
	@Override
	public void mostrarDetalles() {
		System.out.println("Detalles de la película:");
		super.mostrarDetalles();
		System.out.println("Productora: " + productora);
		System.out.println("Interprete: " + interprete);
		System.out.println();
	}

}
