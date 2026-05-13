package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class Pacman extends ComponentesPacman{
    private boolean derecha=false;
    private boolean izquierda=false;
    private boolean arriba=false;
    private boolean abajo=false;
    private Image pacmanDerecha;
    private Image pacmanIzquierda;
    private Image pacmanArriba;
    private Image pacmanAbajo;
    private boolean visible = true; // Nuevo atributo para la visibilidad
    private List<Fantasma> fantasmas; // Lista de fantasmas para detectar colisiones

    private int ancho;
    private int alto;
    public Pacman(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        File f = new File(imagen);
        this.pacmanDerecha = new Image(f.toURI().toString());
        File f2 = new File(getClass().getResource("/fes/aragon/imagen/PacmanIzquierda.png").getFile());
        this.pacmanIzquierda = new Image(f2.toURI().toString());
        File f3 = new File(getClass().getResource("/fes/aragon/imagen/PacmanArriba.png").getFile());
        this.pacmanArriba = new Image(f3.toURI().toString());
        File f4 =  new File(getClass().getResource("/fes/aragon/imagen/PacmanAbajo.png").getFile());
        this.pacmanAbajo = new Image(f4.toURI().toString());
    }


    @Override
    public void pintar(GraphicsContext graficos) {
        if (!visible) {
            return; // No dibujar si Pacman no es visible
        }
        if(derecha){
            graficos.drawImage(pacmanDerecha,x,y);
        }
        if(izquierda){
            graficos.drawImage(pacmanIzquierda,x,y);
        }
        if(arriba){
            graficos.drawImage(pacmanArriba,x,y);
        }
        if(abajo){
            graficos.drawImage(pacmanAbajo,x,y);
        }

    }

    @Override
    public void teclado(KeyEvent evento, boolean presiona) {
        if(evento.isAltDown()){
            String codigo=evento.getCode().toString();

        }
        switch (evento.getCode().toString()) {
            case "RIGHT":
                derecha=true;
                izquierda=false;
                arriba=false;
                abajo=false;
                break;
            case "LEFT":
                derecha=false;
                izquierda=true;
                arriba=false;
                abajo=false;
                break;
            case "UP":
                derecha=false;
                izquierda=false;
                arriba=true;
                abajo=false;
                break;
            case "DOWN":
                derecha=false;
                izquierda=false;
                arriba=false;
                abajo=true;
                break;

        }
    }


    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
   public void logicaCalculos() {

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[][] nivel = {

                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//1
                {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},//2
                {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},//3
                {1,3,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,3,1},//4
                {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},//5
                {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},//6
                {1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1},//7
                {1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1},//8
                {1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1},//9
                {1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1},//10
                {1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1},//11
                {1,1,1,1,1,1,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,1,1,1,1,1,1},//12
                {1,1,1,1,1,1,2,1,1,0,1,4,4,4,4,4,4,1,0,1,1,2,1,1,1,1,1,1},//13
                {1,1,1,1,1,1,2,0,0,0,1,0,0,0,0,0,0,1,0,0,0,2,1,1,1,1,1,1},//14
                {1,1,1,1,1,1,2,1,1,0,1,0,0,0,0,0,0,1,0,1,1,2,1,1,1,1,1,1},//15
                {1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1},//16
                {1,1,1,1,1,1,2,1,1,0,0,0,0,0,0,0,0,0,0,1,1,2,1,1,1,1,1,1},//17
                {1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1},//18
                {1,1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,0,1,1,2,1,1,1,1,1,1},//19
                {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},//20
                {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},//21
                {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},//22
                {1,3,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,3,1},//23
                {1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1},//24
                {1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1},//25
                {1,2,2,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,1,1,2,2,2,2,2,2,1},//26
                {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},//27
                {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},//28
                {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},//29
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}//30
        };
        // Calcular los índices i y j correspondientes en la matriz nivel
        int i = y / 25;
        int j = x / 25;








        // Verificar si la nueva posición está dentro de los límites de la matriz nivel
        if (i >= 0 && i < nivel.length && j >= 0 && j < nivel[0].length) {
            // Verificar si el Pac-Man puede moverse hacia la derecha sin chocar con un obstáculo
            if (derecha && j + 1 < nivel[0].length && nivel[i][j + 1] != 1) {
                x += 25; // Incrementar x en 25 unidades para mover el Pac-Man hacia la derecha
            }
            // Verificar si el Pac-Man puede moverse hacia la izquierda sin chocar con un obstáculo
            else if (izquierda && j - 1 >= 0 && nivel[i][j - 1] != 1) {
                x -= 25; // Decrementar x en 25 unidades para mover el Pac-Man hacia la izquierda
            }
            // Verificar si el Pac-Man puede moverse hacia arriba sin chocar con un obstáculo
            else if (arriba && i - 1 >= 0 && nivel[i - 1][j] != 1) {
                y -= 25; // Decrementar y en 25 unidades para mover el Pac-Man hacia arriba
            }
            // Verificar si el Pac-Man puede moverse hacia abajo sin chocar con un obstáculo
            else if (abajo && i + 1 < nivel.length && nivel[i + 1][j] != 1) {
                y += 25; // Incrementar y en 25 unidades para mover el Pac-Man hacia abajo
            }

        }


        //Deteccion de colisiones
        Fantasma fantasmaRojo = SingletonItems.getInstance().getFantasmaRojo();
        int fantasmaRojoJ = fantasmaRojo.getX()/25;
        int fantasmaRojoI = fantasmaRojo.getY()/25;
        if (fantasmaRojoI == i && fantasmaRojoJ==j){
            System.out.println("Colision");
        }

        Fantasma fantasmaAzul = SingletonItems.getInstance().getFantasmaAzul();
        int fantasmaAzulJ = fantasmaAzul.getX()/25;
        int fantasmaAzulI = fantasmaAzul.getY()/25;
        if (fantasmaAzulI == i && fantasmaAzulJ==j){
            System.out.println("Colision");
        }

        Fantasma fantasmaRosa = SingletonItems.getInstance().getFantasmaRosa();
        int fantasmaRosaJ = fantasmaRosa.getX()/25;
        int fantasmaRosaI = fantasmaRosa.getY()/25;
        if (fantasmaRosaI == i && fantasmaRosaJ==j){
            System.out.println("Colision");
        }

        Fantasma fantasmaNaranja = SingletonItems.getInstance().getFantasmaNaranja();
        int fantasmaNaranjaJ = fantasmaNaranja.getX()/25;
        int fantasmaNaranjaI = fantasmaNaranja.getY()/25;
        if (fantasmaNaranjaI == i && fantasmaNaranjaJ==j){
            System.out.println("Colision");
        }
// Comprobar colisión con fantasmas
        for (Fantasma fantasma : fantasmas) {
            if (this.getRectangulo().intersects(fantasma.getRectangulo().getBoundsInLocal())) {
                visible = false; // Hacer a Pacman invisible
                break;
            }
        }

    }

    public void setFantasmas(List<Fantasma> fantasmas) {
        this.fantasmas = fantasmas;
    }

    public Rectangle getRectangulo() {
        return new Rectangle(x, y, 25, 25);
    }
}
