package fes.aragon.modelo;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingletonItems {
    private static SingletonItems items;
    private Pacman pacman;
    private Fantasma fantasmaRojo;
    private Fantasma fantasmaRosa;
    private Fantasma fantasmaNaranja;
    private Fantasma fantasmaAzul;
    private Fondo fondo;
    private Maze maze;
    private Puntos puntos;

    private ArrayList<ComponentesPacman> elementos;
    private SingletonItems() {
        this.iniciar();
    }
    public static SingletonItems getInstance(){
        if(items == null){
            items = new SingletonItems();
        }
        return items;
    }
    public void  iniciar(){
        //crear e inicializar los objetos
        fondo=new Fondo(0,0,getClass().getResource("/fes/aragon/imagen/Fondo.png").getFile(),0);
        maze =new Maze(0,0,null,0);
        puntos = new Puntos(0,0,null, 0);
        pacman=new Pacman(350,555,getClass().getResource("/fes/aragon/imagen/PacmanDerecha.png").getFile(),1);
        fantasmaRojo=new Fantasma(375,350,getClass().getResource("/fes/aragon/imagen/FantasmaRojo.png").getFile(),1);
        fantasmaRosa=new Fantasma(375,350,getClass().getResource("/fes/aragon/imagen/FantasmaRosa.png").getFile(),1);
        fantasmaNaranja=new Fantasma(375,350,getClass().getResource("/fes/aragon/imagen/FantasmaNaranja.png").getFile(),1);
        fantasmaAzul=new Fantasma(375,350,getClass().getResource("/fes/aragon/imagen/FantasmaAzul.png").getFile(),1);
        elementos=new ArrayList<>();
        // Agregar fantasmas a una lista
        List<Fantasma> fantasmas = Arrays.asList(fantasmaRojo, fantasmaRosa, fantasmaNaranja, fantasmaAzul);

// Establecer la lista de fantasmas en la instancia de Pacman
        pacman.setFantasmas(fantasmas);

        //agrega los objetos
        elementos.add(fondo);
        elementos.add(puntos);
        elementos.add(maze);
        elementos.add(pacman);
        elementos.add(fantasmaRojo);
        elementos.add(fantasmaRosa);
        elementos.add(fantasmaNaranja);
        elementos.add(fantasmaAzul);
    }
    public ArrayList<ComponentesPacman> getElementos() {
        return elementos;
    }
    public Fondo getFondo() {
        return fondo;
    }
    public Puntos getPuntos(){return puntos;}
    public Pacman getPacman() {return pacman;}
    public Fantasma getFantasmaRojo() {return fantasmaRojo;}
    public Fantasma getFantasmaRosa() {return fantasmaRosa;}
    public Fantasma getFantasmaNaranja() {return fantasmaNaranja;}
    public Fantasma getFantasmaAzul() {return fantasmaAzul;}
    public Maze getMaze() {return maze;}
    // Método para obtener la matriz 'nivel' desde la instancia única de 'Maze'
    public int[][] getNivel() {
        return maze.getNivel();
    }

}
