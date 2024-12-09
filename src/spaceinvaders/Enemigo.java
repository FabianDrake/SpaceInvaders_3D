package spaceinvaders;

import java.util.List;
import motor.CajaColisionable;
import motor.Colo;
import motor.Cara;
import motor.Objeto3D;
import motor.Punto;
import motor.Tiempo;

public class Enemigo extends Objeto3D {

    private float semillaX = (float) Math.random() * 2;
    private float semillaZ = (float) Math.random() * 2;
    private float semillaRotacion = (float) (Math.random() * 2);
    private Mira mira;

    public void establecerMira(Mira mira) {
        this.mira = mira;
    }

    @Override
    public void actualizar() {
        float z = (float) Math.sin((double) System.currentTimeMillis() / 1000 * semillaZ) * 200;
        getTraslacion().setZ(z);

        float x = (float) Math.sin((double) System.currentTimeMillis() / 2000 * semillaX) * 300;
        getTraslacion().setX(x);

        getTraslacion().agregarY(-Tiempo.getDelta() * 0.0000001f);
        if (getTraslacion().getY() < -100) {
            getTraslacion().setY(3000);
        }

        getRotacion().agregarZ(Tiempo.getDelta() * 0.000000005f);
    }

    @Override
    public String getEtiqueta() {
        return "enemigo";
    }

    @Override
    public void construir() {
        CajaColisionable colisionable = new CajaColisionable();
        colisionable.getA().setX(-15);
        colisionable.getA().setY(-15);
        colisionable.getA().setZ(-15);
        colisionable.getB().setX(15);
        colisionable.getB().setY(15);
        colisionable.getB().setZ(15);
        setColisionable(colisionable);

        // Creación de puntos y caras manualmente
        Punto p1 = new Punto(-0.0f, -30.0f, 0.0f);
        Punto p2 = new Punto(-21.213211f, -21.213211f, 0.0f);
        Punto p3 = new Punto(-30.0f, 0.0f, -0.0f);
        Punto p4 = new Punto(-21.213211f, 21.213211f, -0.0f);
        Punto p5 = new Punto(0.0f, 30.0f, -0.0f);
        Punto p6 = new Punto(21.213211f, 21.213211f, -0.0f);
        Punto p7 = new Punto(30.0f, -0.0f, 0.0f);
        Punto p8 = new Punto(21.213211f, -21.213211f, 0.0f);

        // Continuar agregando puntos y caras según sea necesario

        Cara c1 = new Cara(p8, p1, p3, p4);
        Cara c2 = new Cara(p8, p7, p5, p6);

        agregarCara(c1);
        agregarCara(c2);

        getRotacion().setZ(semillaRotacion);
    }

    public void colision(List<Objeto3D> objetos) {
        boolean tieneDisparo = false;
        for (Objeto3D objeto : objetos) {
            if (objeto.getEtiqueta().equals("disparo")) {
                tieneDisparo = true;
                break;
            }
        }

        if (!tieneDisparo) {
            return;
        }

        // Lógica para manejar la explosión
        /*for (Cara cara : getCaras()) {
            Fragmento fragmento = new Fragmento();
            fragmento.setColor(new Colo(150, 150, 150));
            fragmento.getTraslacion().setX(getTraslacion().getX());
            fragmento.getTraslacion().setY(getTraslacion().getY());
            fragmento.getTraslacion().setZ(getTraslacion().getZ());
            fragmento.getRotacion().setX(getRotacion().getX());
            fragmento.getRotacion().setY(getRotacion().getY());
            fragmento.getRotacion().setZ(getRotacion().getZ());
            fragmento.getEscala().setX(getEscala().getX());
            fragmento.getEscala().setY(getEscala().getY());
            fragmento.getEscala().setZ(getEscala().getZ());
            fragmento.addCara(cara);
            getEspacio().addObjeto3D(fragmento);
        }*/

        getEspacio().eliminarObjeto3D(this);
        getEspacio().eliminarObjeto3D(mira);
    }

    @Override
    public void colisiono(List<Objeto3D> objetos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
