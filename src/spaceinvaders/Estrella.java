package spaceinvaders;

import java.util.List;
import motor.Cara;
import motor.Objeto3D;
import motor.Punto;
import motor.Tiempo;

public class Estrella extends Objeto3D {

    @Override
    public String getEtiqueta() {
        return "estrella"; // Etiqueta identificadora del objeto
    }

    @Override
    public void construir() {
        // Define los puntos para construir la estrella
        Punto p1 = new Punto(0, 0, 0);
        Punto p2 = new Punto(2, 0, 0);
        Punto p3 = new Punto(2, 2, 0);
        Punto p4 = new Punto(0, 2, 0);
        Punto p5 = new Punto(0, 0, 2);
        Punto p6 = new Punto(2, 0, 2);
        Punto p7 = new Punto(2, 2, 2);
        Punto p8 = new Punto(0, 2, 2);

        // Crea las caras de la estrella
        Cara c1 = new Cara(p1, p2, p3, p4);
        Cara c2 = new Cara(p5, p6, p7, p8);
        Cara c3 = new Cara(p1, p2, p6, p5);
        Cara c4 = new Cara(p2, p3, p7, p6);
        Cara c5 = new Cara(p3, p4, p8, p7);
        Cara c6 = new Cara(p4, p1, p5, p8);

        // Agrega las caras al objeto (descomentarlas si se utiliza una lista de caras)
        // addCara(c1);
        // addCara(c2);
        // addCara(c3);
        // addCara(c4);
        // addCara(c5);
        // addCara(c6);
    }

    @Override
    public void actualizar() {
        // Actualiza la posición de la estrella
        getTraslacion().agregarY(-Tiempo.getDelta() * 0.000001f);
        if (getTraslacion().getY() < -150) {
            getTraslacion().setY(5000); // Reinicia la posición en Y
        }
    }

    @Override
    public void colisiono(List<Objeto3D> objetos) {
        // Lógica para manejar colisiones, actualmente vacío
    }
}
