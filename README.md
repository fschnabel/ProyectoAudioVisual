
# Proyecto: Gestión de Contenidos Audiovisuales

Este proyecto es una aplicación en Java para gestionar diferentes tipos de contenidos audiovisuales, como películas, series de TV, documentales, tutoriales y videos musicales. Incluye funcionalidades para mostrar detalles de los contenidos, exportarlos a archivos planos, importarlos y asociarlos con actores u otros elementos relacionados.

---

## Cambios Recientes

1. **Reorganización del Código**:
   - Modularización en la clase `PruebaAudioVisual` para mayor claridad y legibilidad.
   - Métodos específicos para crear contenidos, mostrar detalles, exportar/importar películas y exportar series de TV.

2. **Pruebas Unitarias**:
   - Clases de prueba agregadas para cada entidad (`Pelicula`, `SerieDeTV`, `Tutorial`, etc.).
   - Pruebas específicas para `ArchivoPlano`, `VistaArchivo` y la interfaz `TipoArchivo`.

3. **Documentación**:
   - Comentarios detallados añadidos a cada clase y método.
   - Organización del flujo principal del programa.

---

## Estructura del Proyecto

```
Proyecto/
├── src/
│   ├── modelo/                  # Entidades principales del dominio
│   │   ├── Actor.java
│   │   ├── ContenidoAudiovisual.java
│   │   ├── Pelicula.java
│   │   ├── SerieDeTV.java
│   │   ├── Documental.java
│   │   ├── Temporada.java
│   │   ├── Tutorial.java
│   │   └── VideoMusical.java
│   ├── vista/                   # Manejo de vistas y archivos
│   │   ├── ArchivoPlano.java
│   │   ├── VistaArchivo.java
│   ├── controlador/             # Controladores
│   │   └── ControladorArchivo.java
│   ├── pruebas/                 # Pruebas unitarias
│   │   └── (Clases de prueba para cada entidad)
│   └── poo/                     # Clase principal
│       └── PruebaAudioVisual.java
├── test/                        # Archivos de prueba para importación/exportación
├── README.md
```

---

## Requisitos Previos

1. **Java Development Kit (JDK)**: Asegúrate de tener instalado JDK 11 o superior.
2. **IDE (Opcional)**: IntelliJ IDEA, Eclipse o cualquier otro IDE que prefieras.

---

## Cómo Clonar y Ejecutar el Proyecto

### Clonar el Repositorio

```bash
git clone https://github.com/tuusuario/proyecto-audiovisual.git
cd proyecto-audiovisual
```

### Compilar y Ejecutar

1. **Compilación desde la Línea de Comandos**:
   - Compila el proyecto desde el directorio `src`:

     ```bash
     javac -d bin -sourcepath src src/poo/PruebaAudioVisual.java
     ```

2. **Ejecución**:
   - Ejecuta la clase principal desde el directorio `bin`:

     ```bash
     java -cp bin poo.PruebaAudioVisual
     ```

---

## Cómo Ejecutar las Pruebas

1. **Compilación de las Pruebas**:
   - Compila las clases de prueba junto con las demás clases:

     ```bash
     javac -d bin -sourcepath src src/pruebas/*.java
     ```

2. **Ejecución de las Pruebas**:
   - Ejecuta cada clase de prueba individualmente desde el directorio `bin`:

     ```bash
     java -cp bin pruebas.ActorTest
     java -cp bin pruebas.PeliculaTest
     ```

---

## Funcionalidades Principales

1. **Gestión de Contenidos Audiovisuales**:
   - Creación de instancias de películas, series de TV, documentales, tutoriales y videos musicales.
   - Asociación de actores y otros elementos relacionados.

2. **Exportar Contenidos**:
   - Serialización de los contenidos a archivos planos en formato delimitado por un separador.

3. **Importar Contenidos**:
   - Deserialización de archivos planos para crear instancias de entidades.

4. **Pruebas Unitarias**:
   - Cobertura de las funcionalidades principales para garantizar la calidad del software.

---

## Ejemplo de Uso

### Código de Ejemplo para Crear y Mostrar Contenidos

```java
ContenidoAudiovisual pelicula = new Pelicula("Inception", 148, "Sci-Fi", "Warner Bros", new String[]{"Leonardo DiCaprio", "Joseph Gordon-Levitt"});
pelicula.mostrarDetalles();
```

### Exportar Películas a Archivo

```java
VistaArchivo vistaArchivo = new VistaArchivo();
TipoArchivo archivoPlano = new ArchivoPlano(",");
ControladorArchivo controlador = new ControladorArchivo(List.of(pelicula), vistaArchivo);
controlador.exportarArchivo("peliculas.txt", archivoPlano);
```

### Importar Películas desde Archivo

```java
List<Pelicula> peliculas = controlador.importarArchivo(Pelicula.class, "peliculas.txt", archivoPlano);
peliculas.forEach(Pelicula::mostrarDetalles);
```

---

## Contribuir

1. Realiza un fork del repositorio.
2. Crea una nueva rama: `git checkout -b feature/nueva-funcionalidad`.
3. Realiza tus cambios y haz commits descriptivos.
4. Envía un pull request.

---

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).
