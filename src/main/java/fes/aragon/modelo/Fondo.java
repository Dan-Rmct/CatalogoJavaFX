package fes.aragon.modelo;

import javafx.animation.PauseTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.File;

public class Fondo extends ComponentesPacman {
    private Image img;

    public Fondo(int x, int y, String imagen,int velocidad) {
        super(x, y, imagen, velocidad);
        System.out.println(imagen);
        try {
            File f = new File(imagen);
            this.img = new Image(f.toURI().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void pintar(GraphicsContext graficos) {

        graficos.drawImage(img,1,1);
    }

    @Override
    public void teclado(KeyEvent evento, boolean presiona) {

    }

    @Override
    public void raton(MouseEvent evento) {
        System.out.println(evento.getX() + " "
                + evento.getY());
    }

    @Override
    public void logicaCalculos() {
//        y += velocidad;
//        if (y >= 400) {
//            y = -400;
//        }

    }

    public Image getImg() {
        return img;
    }
}
