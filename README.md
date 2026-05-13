# Catálogo JavaFX

Aplicación de escritorio desarrollada con **JavaFX 17** como proyecto de la materia de **Programación Orientada a Objetos** en **FES Aragón, UNAM**. Integra múltiples módulos funcionales en una sola interfaz: gestión de usuarios, manejo de archivos, operaciones con números racionales y un mini-juego de Pac-Man.

---

## Características

- **Gestión de usuarios** — registro, consulta y tabla de usuarios con serialización de imagen de perfil.
- **Manejo de archivos** — lectura y escritura de datos persistentes mediante serialización.
- **Operaciones con racionales** — suma, resta, multiplicación y división de números racionales con reducción automática.
- **Mini-juego Pac-Man** — juego funcional con laberinto, fantasmas, puntos, música de fondo y controles por teclado.
- **Interfaz estilizada** con BootstrapFX y FontAwesome.

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 17 |
| JavaFX | 17.0.6 |
| Maven | 3.x |
| BootstrapFX | 0.4.0 |
| FontAwesomeFX | 4.7.0-9.1.2 |
| JLayer (audio) | 1.0.1 |
| JUnit Jupiter | 5.10.0 |

---

## Estructura del proyecto

```
CatalogoJavaFX/
├── src/main/java/fes/aragon/
│   ├── inicio/
│   │   ├── Inicio.java              # Punto de entrada (Application)
│   │   └── PrincipalRacional.java
│   ├── controller/
│   │   ├── InicioController.java    # Navegación principal
│   │   ├── ArchivoController.java
│   │   ├── RacionalController.java
│   │   ├── RegistroDeUsuarioController.java
│   │   ├── TablaUsuarioController.java
│   │   ├── PacmanController.java
│   │   └── Contenido.java
│   └── modelo/
│       ├── Usuario.java / SingletonUsuario.java
│       ├── Racional.java / OperacionRacional.java
│       ├── Archivos.java / SerializableImage.java
│       └── Pacman / Fantasma / Maze / Puntos / Fondo / ...
├── src/main/resources/fes/aragon/
│   ├── xml/         # Vistas FXML
│   ├── css/         # bootstrapfx.css
│   ├── imagen/      # Sprites y portada
│   └── musica/      # musica_entrada.mp3
└── pom.xml
```

---

## Instalación y ejecución

### Requisitos previos

- **JDK 17** o superior
- **Maven 3.x**

### Clonar y ejecutar

```bash
git clone <url-del-repositorio>
cd CatalogoJavaFX
mvn clean javafx:run
```

### Compilar JAR

```bash
mvn clean package
```

El JAR generado se encontrará en `target/CatalogoJavaFX-1.0-SNAPSHOT.jar`.

---

## Módulos

### Inicio
Pantalla principal con botones de navegación hacia cada módulo.

### Usuarios
Registro de usuarios con nombre, datos y foto de perfil (serializable). Lista de usuarios en tabla con opción de eliminar.

### Archivos
Lectura y escritura de objetos serializados al sistema de archivos local.

### Racionales
Calculadora de operaciones aritméticas con fracciones. Implementa reducción por MCD automáticamente.

### Pac-Man
Mini-juego completo con:
- Movimiento del personaje con teclas de dirección
- 4 fantasmas con lógica de movimiento
- Laberinto con puntos coleccionables
- Música de fondo en bucle
- Modal de juego con foco capturado

---

## Autor

Desarrollado por Ana Guadalupe Martínez Colón y Aldo Daniel Ramírez Cortés estudiantes de **FES Aragón, UNAM** como proyecto para la materia de **Programación Orientada a Objetos**.
