# poo_unidad1
- Se crea el proyecto inicial con las siguientes entidades
	Actor.java
	ContenidoAudiovisual.java
	Documental.java
	Investigador.java
	Pelicula.java
	SerieDeTV.java
	Temporada.java
	
- Se cambia el metodo abstracto mostrarDetalles de la clase ContenidoAudiovisual.java para que pueda imprimir sus propiedades
de esa forma evitar duplicidad de codigo en las clases en la cual se hereda

- Se agregan las siguientes clases para tener mas variedad de contenido Audio Visual
	Tutorial.java (En esta clase se va a manejar video tutoriales en principio de temas informaticos)
	VideoMusical.java (En esta clase se va a manejar los videos musicales que se incluyan en nuestro contenido audio visual)
	
- Se cambia la clase Actor.java para que contenga una creación basada en una fabrica de Actores para que a un mismo actor se le puedan agregar mas peliculas