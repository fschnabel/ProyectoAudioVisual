package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Investigador {
	private String nombre;
	private List<Documental> documentales;
	
	public Investigador(String nombre) {
		this.nombre = nombre;
	}
	
	public Investigador(String nombre, Documental documental) {
		this.nombre = nombre;
		this.agregarDocumental(documental);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Documental> getDocumental() {
		return documentales;
	}
	
	public void setDocumentales(List<Documental> documentales) {
		this.documentales = documentales;
	}
	
	public void agregarDocumental(Documental documental) {
		if (this.documentales == null) {
			this.documentales = new ArrayList<Documental>();
		}
		this.documentales.add(documental);
	}
	
}
