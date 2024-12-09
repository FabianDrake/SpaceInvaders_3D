package spaceinvaders;

import java.util.List;
import motor.Colo;
import motor.Cara;
import motor.Objeto3D;
import motor.Punto;


public class Mira extends Objeto3D {
    
    public static Nave nave;
    private Enemigo enemigo;
    
    // Constructor que asocia la nave y el enemigo a esta mira
    public Mira(Nave nave, Enemigo enemigo) {
        this.nave = nave;
        this.enemigo = enemigo;
    }

    // Devuelve la etiqueta del objeto, identificándolo como "mira"
    @Override
    public String getEtiqueta() {
        return "mira";
    }

    // Construcción de la mira 3D, definiendo su geometría y color
    @Override
    public void construir() {
        setColor(new Colo(0, 255, 0)); // Establece el color verde para la mira
        //Wavefront.cargar(System.getProperty("user.dir").replace("\\","/") + "/res/mira.obj", this, 10);

        // Definición de puntos en el espacio tridimensional para construir un cubo
        Punto p1 = new Punto(-10, -10, -10);
        Punto p2 = new Punto(10, -10, -10);
        Punto p3 = new Punto(10, 10, -10);
        Punto p4 = new Punto(-10, 10, -10);
        Punto p5 = new Punto(-10, -10, 10);
        Punto p6 = new Punto(10, -10, 10);
        Punto p7 = new Punto(10, 10, 10);
        Punto p8 = new Punto(-10, 10, 10);

        // Creación de caras utilizando los puntos definidos
        Cara c1 = new Cara(p1, p2, p3, p4); // Cara frontal
        // Cara c2 = new Cara(p5, p6, p7, p8); // Cara trasera
        // Cara c3 = new Cara(p1, p2, p6, p5); // Cara inferior
        // Cara c4 = new Cara(p2, p3, p7, p6); // Cara derecha
        // Cara c5 = new Cara(p3, p4, p8, p7); // Cara superior
        // Cara c6 = new Cara(p4, p1, p5, p8); // Cara izquierda

        // Añade la cara construida al objeto
        agregarCara(c1);
        //addCara(c2);
        //addCara(c3);
        //addCara(c4);
        //addCara(c5);
        //addCara(c6);
    }

    // Actualiza la posición de la mira según la nave y el enemigo
    @Override
    public void actualizar() {
        // Sincroniza la posición de la mira con el enemigo en el eje Y
        getTraslacion().setY(enemigo.getTraslacion().getY() - 10);
        // Ajusta la posición en X y Z para seguir la nave
        getTraslacion().setX(nave.getTraslacion().getX());
        getTraslacion().setZ(nave.getTraslacion().getZ());
    }

    // Manejo de colisiones (vacío por ahora)
    @Override
    public void colisiono(List<Objeto3D> objetos) {
    }
}
