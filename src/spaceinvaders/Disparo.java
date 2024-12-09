package spaceinvaders;

import java.util.List;
import motor.CajaColisionable;
import motor.Colo;
import motor.Cara;
import motor.Objeto3D;
import motor.Punto;
import motor.Tiempo;

public class Disparo extends Objeto3D {

    @Override
    public String getEtiqueta() {
        return "disparo";
    }

    @Override
    public void construir() {
        CajaColisionable colisionable = new CajaColisionable();
        colisionable.getA().setX(-1);
        colisionable.getA().setY(-50);
        colisionable.getA().setZ(-1);
        colisionable.getB().setX(1);
        colisionable.getB().setY(50);
        colisionable.getB().setZ(1);
        setColisionable(colisionable);
        
        Punto p1 = new Punto( -1, -50, -1);
        Punto p2 = new Punto( 1, -50, -1);
        Punto p3 = new Punto( 1, 50, -1);
        Punto p4 = new Punto( -1, 50, -1);
        Punto p5 = new Punto( -1, -50, 1);
        Punto p6 = new Punto( 1, -50, 1);
        Punto p7 = new Punto( 1, 50, 1);
        Punto p8 = new Punto( -0, 50, 1);
        
        Cara c1 = new Cara(p1, p2, p3, p4);
        Cara c2 = new Cara(p5, p6, p7, p8);
        Cara c3 = new Cara(p1, p2, p6, p5);
        Cara c4 = new Cara(p2, p3, p7, p6);
        Cara c5 = new Cara(p3, p4, p8, p7);
        Cara c6 = new Cara(p4, p1, p5, p8);
        
        agregarCara(c1);
        agregarCara(c2);
        agregarCara(c3);
        agregarCara(c4);
        agregarCara(c5);
        agregarCara(c6);
        
        setColor(new Colo(255, 255, 0)); // amarillo
    }

    @Override
    public void actualizar() {
        getTraslacion().agregarY(Tiempo.getDelta() * 0.000005f);
        if (getTraslacion().getY() > 2000) {
            getEspacio().eliminarObjeto3D(this);
        }
    }

    public void colidiu(List<Objeto3D> objetos) {
        System.out.println("El disparo acertó a " + objetos.get(0).getEtiqueta() + " ...");
        getEspacio().eliminarObjeto3D(this);
    }

    @Override
    public void colisiono(List<Objeto3D> objetos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
