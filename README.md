# Proyectos Audiovisuales

## Propósito del Proyecto

Los proyectos audiovisuales tienen como objetivo la creación y difusión de contenido multimedia que combina elementos visuales y auditivos para informar, educar, entretener o inspirar a la audiencia. Estos proyectos pueden incluir producciones como películas, series de televisión, documentales, videos musicales, tutoriales, cortometrajes y más.


# Guía para importar un proyecto de Java desde Git

Este documento proporciona una guía sencilla para clonar e importar un proyecto de Java desde un repositorio de Git a tu entorno de desarrollo (por ejemplo, Eclipse o IntelliJ IDEA).

## Requisitos previos

- [Git](https://git-scm.com/) instalado en tu máquina.
- Un entorno de desarrollo integrado (IDE) como [Eclipse](https://www.eclipse.org/) o [IntelliJ IDEA](https://www.jetbrains.com/idea/).
- Java Development Kit (JDK) configurado.

## Pasos para clonar el repositorio

1. **Abrir la terminal o línea de comandos**:
   - Ve al directorio donde quieras clonar el proyecto.

2. **Clonar el repositorio**:
   - Ejecuta el siguiente comando en tu terminal reemplazando `URL_DEL_REPOSITORIO` con la URL del repositorio de Git:
     bash
     git clone URL_DEL_REPOSITORIO
     

3. **Entrar al directorio del proyecto**:
   bash
   cd nombre-del-proyecto


## Historial del Proyecto

- **Se crea el proyecto inicial** con las siguientes entidades:
  - `Actor.java`
  - `ContenidoAudiovisual.java`
  - `Documental.java`
  - `Investigador.java`
  - `Pelicula.java`
  - `SerieDeTV.java`
  - `Temporada.java`
  
- **Modificación de `ContenidoAudiovisual.java`**:
  - Se cambia el método abstracto `mostrarDetalles` para que pueda imprimir las propiedades del contenido audiovisual, evitando así la duplicidad de código en las clases que heredan de ella.

- **Adición de nuevas clases**:
  - `Tutorial.java`: Maneja videos tutoriales, inicialmente enfocados en temas informáticos.
  - `VideoMusical.java`: Maneja los videos musicales incluidos en nuestro contenido audiovisual.

- **Actualización de `Actor.java`**:
  - Se cambia para incluir una fábrica de actores, lo que permite agregar más películas al mismo actor de forma más sencilla.
  - Se modifica para que pueda soportar `ContenidoAudiovisual` en lugar de solo `Pelicula`, permitiendo que un actor participe tanto en películas como en series de TV.
