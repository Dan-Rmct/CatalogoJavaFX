package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Random;

public class Fantasma extends ComponentesPacman{
    //valor inicial de las direcciones
    private boolean derecha=false;
    private boolean izquierda=false;
    private boolean arriba=false;
    private boolean abajo=false;

    //variables para almacenar los recursos
    private Image fantasmaRojo;
    private Image fantasmaRosa;
    private Image fantasmaNaranja;
    private Image fantasmaAzul;
    private boolean visible = true; // Para controlar la visibilidad del fantasma
    //alto y ancho de las imagenes
    private int ancho;
    private int alto;

    //nos ayuda a que se continue generando el random
    private  int contador=0;


    public Fantasma(int x, int y, String imagen, int velocidad) {
        super(375,350, imagen, velocidad);
        File f = new File(imagen);
        this.fantasmaRojo = new Image(f.toURI().toString());
        File f2 =  new File (imagen);
        this.fantasmaRosa = new Image(f2.toURI().toString());
        File f3 =  new File (imagen);
        this.fantasmaNaranja = new Image(f3.toURI().toString());
        File f4 =  new File (imagen);
        this.fantasmaAzul = new Image(f4.toURI().toString());
        direccion();
    }


    @Override
    public void pintar(GraphicsContext graficos) {

        graficos.drawImage(fantasmaRojo,x,y);

    }

    @Override
    public void teclado(KeyEvent evento, boolean presiona) {

        }


    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
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

        int i = y / 25;
        int j = x / 25;

        // Verificar colisión con el siguiente movimiento
        if (derecha && j + 1 < nivel[0].length && nivel[i][j + 1] != 1) {
            x += 25;
        } else if (izquierda && j - 1 >= 0 && nivel[i][j - 1] != 1) {
            x -= 25;
        } else if (arriba && i - 1 >= 0 && nivel[i - 1][j] != 1) {
            y -= 25;
        } else if (abajo && i + 1 < nivel.length && nivel[i + 1][j] != 1) {
            y += 25;
        } else {
            // Si hay una colisión, cambiar la dirección
            direccion();
        }

        // Incrementar contador
        if (contador >= 100) {
            contador = 0;
            direccion();
        } else {
            contador++;
        }

        // Ajustar el tiempo de espera para hacer el movimiento más lento
        try {
            Thread.sleep(50); // Espera 200 milisegundos entre cada movimiento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void direccion(){
        int movimiento = (int) (Math.random() * 4 + 1);

        switch (movimiento) {
            case 1:
                derecha = true;
                izquierda = false;
                arriba = false;
                abajo = false;
                break;
            case 2:
                derecha = false;
                izquierda = true;
                arriba = false;
                abajo = false;
                break;
            case 3:
                derecha = false;
                izquierda = false;
                arriba = true;
                abajo = false;
                break;
            case 4:
                derecha = false;
                izquierda = false;
                arriba = false;
                abajo = true;
                break;
        }
    }
    public Rectangle getRectangulo() {
        return new Rectangle(x, y, 25, 25);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
}