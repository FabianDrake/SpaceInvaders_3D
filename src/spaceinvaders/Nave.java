package spaceinvaders;

import java.util.List;
import motor.CajaColisionable;
import motor.Camara;
import motor.Cara;
import motor.Objeto3D;
import motor.Punto;
import motor.Teclado;
import motor.Tiempo;

public class Nave extends Objeto3D {
    
    private Float camaraX;
    private Float camaraZ;

    public String obtenerEtiqueta() {
        return "nave";
    }

    @Override
    public void construir() {
        CajaColisionable colisionable = new CajaColisionable();
        colisionable.getA().setX(-40);
        colisionable.getA().setY(-40);
        colisionable.getA().setZ(-40);
        colisionable.getB().setX(40);
        colisionable.getB().setY(40);
        colisionable.getB().setZ(40);
        setColisionable(colisionable);
        
        // Wavefront.cargar(System.getProperty("user.dir").replace("\\","/") + "/res/hero.obj", this, 7f);
        
        Punto p1 = new Punto(-3.1566288f, 6.999993f, -5.35017f);
        Punto p2 = new Punto(-3.1566288f, -7.0000067f, -5.350156f);
        Punto p3 = new Punto(3.1566288f, -7.0000067f, -5.350156f);
        Punto p4 = new Punto(3.1566288f, 7.0f, -5.35017f);
        Punto p5 = new Punto(-3.058923f, 7.0f, 2.191385f);
        Punto p6 = new Punto(-3.058916f, -7.0f, 2.191399f);
        Punto p7 = new Punto(3.058923f, -6.999993f, 2.191399f);
        Punto p8 = new Punto(3.058916f, 7.0f, 2.191385f);
        Punto p9 = new Punto(3.1566288f, 21.0f, -5.3501844f);
        Punto p10 = new Punto(3.058916f, 21.0f, 0.305445f);
        Punto p11 = new Punto(-3.1566288f, 20.999992f, -5.3501844f);
        Punto p12 = new Punto(-3.058923f, 21.0f, 0.305445f);
        Punto p13 = new Punto(-17.034256f, -1.589602f, -6.53548f);
        Punto p14 = new Punto(-17.034256f, -1.589602f, -4.939368f);
        Punto p15 = new Punto(-17.034256f, -15.589602f, -6.5354657f);
        Punto p16 = new Punto(-17.034256f, -15.589602f, -4.939354f);
        Punto p17 = new Punto(17.034256f, -1.589595f, -6.53548f);
        Punto p18 = new Punto(17.034256f, -1.589602f, -4.939368f);
        Punto p19 = new Punto(17.034256f, -15.589602f, -6.5354657f);
        Punto p20 = new Punto(17.034256f, -15.589596f, -4.939354f);
        Punto p21 = new Punto(4.133374f, 24.787336f, -5.556789f);
        Punto p22 = new Punto(-4.133388f, 24.787336f, -5.556789f);
        Punto p23 = new Punto(-4.1333947f, 28.511244f, -4.159183f);
        Punto p24 = new Punto(4.133374f, 28.511244f, -4.159183f);
        Punto p25 = new Punto(4.133367f, 32.057186f, -5.793991f);
        Punto p26 = new Punto(4.133374f, 32.05718f, -5.347195f);
        Punto p27 = new Punto(-4.1333947f, 32.05718f, -5.793991f);
        Punto p28 = new Punto(-4.1333947f, 32.05718f, -5.347195f);
        Punto p29 = new Punto(10.429523f, 2.7052062f, -2.356893f);
        Punto p30 = new Punto(7.186886f, 2.7052062f, 0.325283f);
        Punto p31 = new Punto(7.1868925f, -11.294794f, 0.325297f);
        Punto p32 = new Punto(10.429531f, -11.294802f, -2.356879f);
        Punto p33 = new Punto(-7.1868925f, 2.705199f, 0.325283f);
        Punto p34 = new Punto(-10.429531f, 2.705199f, -2.356893f);
        Punto p35 = new Punto(-10.429531f, -11.294802f, -2.356879f);
        Punto p36 = new Punto(-7.186886f, -11.294802f, 0.325297f);
        Punto p37 = new Punto(32.892807f, -1.589595f, -0.85843104f);
        Punto p38 = new Punto(32.89281f, -15.589596f, -0.858417f);
        Punto p39 = new Punto(-32.89281f, -1.589602f, -0.85841f);
        Punto p40 = new Punto(-32.892807f, -15.589602f, -0.85839605f);
        Cara f1 = new Cara(p1, p2, p3, p4);
        Cara f2 = new Cara(p5, p8, p7, p6);
        Cara f3 = new Cara(p2, p6, p7, p3);
        Cara f4 = new Cara(p4, p8, p10, p9);
        Cara f5 = new Cara(p5, p1, p11, p12);
        Cara f6 = new Cara(p8, p5, p12, p10);
        Cara f7 = new Cara(p1, p4, p9, p11);
        Cara f8 = new Cara(p11, p9, p21, p22);
        Cara f9 = new Cara(p10, p12, p23, p24);
        Cara f10 = new Cara(p12, p11, p22, p23);
        Cara f11 = new Cara(p9, p10, p24, p21);
        Cara f12 = new Cara(p21, p24, p26, p25);
        Cara f13 = new Cara(p23, p22, p27, p28);
        Cara f14 = new Cara(p24, p23, p28, p26);
        Cara f15 = new Cara(p22, p21, p25, p27);
        Cara f16 = new Cara(p4, p29, p30, p8);
        Cara f17 = new Cara(p29, p17, p18, p30);
        Cara f18 = new Cara(p7, p31, p32, p3);
        Cara f19 = new Cara(p31, p20, p19, p32);
        Cara f20 = new Cara(p8, p30, p31, p7);
        Cara f21 = new Cara(p30, p18, p20, p31);
        Cara f22 = new Cara(p3, p32, p29, p4);
        Cara f23 = new Cara(p32, p19, p17, p29);
        Cara f24 = new Cara(p34, p1, p5, p33);
        Cara f25 = new Cara(p33, p14, p13, p34);
        Cara f26 = new Cara(p2, p35, p36, p6);
        Cara f27 = new Cara(p35, p15, p16, p36);
        Cara f28 = new Cara(p6, p36, p33, p5);
        Cara f29 = new Cara(p36, p16, p14, p33);
        Cara f30 = new Cara(p1, p34, p35, p2);
        Cara f31 = new Cara(p34, p13, p15, p35);
        Cara f32 = new Cara(p17, p19, p38, p37);
        Cara f33 = new Cara(p20, p18, p37, p38);
        Cara f34 = new Cara(p19, p20, p38);
        Cara f35 = new Cara(p18, p17, p37);
        Cara f36 = new Cara(p15, p13, p39, p40);
        Cara f37 = new Cara(p14, p16, p40, p39);
        Cara f38 = new Cara(p16, p15, p40);
        Cara f39 = new Cara(p14, p13, p39);
        agregarCara(f1);
        agregarCara(f2);
        agregarCara(f3);
        agregarCara(f4);
        agregarCara(f5);
        agregarCara(f6);
        agregarCara(f7);
        agregarCara(f8);
        agregarCara(f9);
        agregarCara(f10);
        agregarCara(f11);
        agregarCara(f12);
        agregarCara(f13);
        agregarCara(f14);
        agregarCara(f15);
        agregarCara(f16);
        agregarCara(f17);
        agregarCara(f18);
        agregarCara(f19);
        agregarCara(f20);
        agregarCara(f21);
        agregarCara(f22);
        agregarCara(f23);
        agregarCara(f24);
        agregarCara(f25);
        agregarCara(f26);
        agregarCara(f27);
        agregarCara(f28);
        agregarCara(f29);
        agregarCara(f30);
        agregarCara(f31);
        agregarCara(f32);
        agregarCara(f33);
        agregarCara(f34);
        agregarCara(f35);
        agregarCara(f36);
        agregarCara(f37);
        agregarCara(f38);
        agregarCara(f39);
    }

    public void construirCubo() {
    Punto p1 = new Punto( 0,  0,  0);
    Punto p2 = new Punto(50,  0,  0);
    Punto p3 = new Punto(50, 50,  0);
    Punto p4 = new Punto(0,  50,  0);
    Punto p5 = new Punto( 0,  0, 50);
    Punto p6 = new Punto(50,  0, 50);
    Punto p7 = new Punto(50, 50, 50);
    Punto p8 = new Punto(0,  50, 50);
    
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
}

private float rotacionY = 0;
private float rotacionVolverY = 0; 

private float rotacionX = 0;
private float rotacionVolverX = 0;

@Override
public void actualizar() {
    if (Teclado.isKeyPressed(39)) {
        getTraslacion().agregarX(-Tiempo.getDelta() * 0.0000003f);
        rotacionY -= Tiempo.getDelta() * 0.0000000005;
        getRotacion().setY(rotacionY);
        rotacionVolverY = 0.000000001f;
    }
    else if (Teclado.isKeyPressed(37)) {
        getTraslacion().agregarX(Tiempo.getDelta() * 0.0000003f);
        rotacionY += Tiempo.getDelta() * 0.0000000005;
        getRotacion().setY(rotacionY);
        rotacionVolverY = -0.000000001f;
    }
    else {
        rotacionY += Tiempo.getDelta() * rotacionVolverY;
        if ((rotacionY > 0 && rotacionVolverY > 0) || (rotacionY < 0 && rotacionVolverY < 0)) {
            rotacionY = 0;
        }
        else {
            getTraslacion().agregarX(Tiempo.getDelta() * rotacionVolverY * -200);
        }
        getRotacion().setY(rotacionY);
    }
    
    if (Teclado.isKeyPressed(38)) {
        getTraslacion().agregarZ(Tiempo.getDelta() * 0.0000003f);
        rotacionX += Tiempo.getDelta() * 0.0000000005;
        getRotacion().setX(rotacionX);
        rotacionVolverX = -0.000000001f;
    }
    else if (Teclado.isKeyPressed(40)) {
        getTraslacion().agregarZ(-Tiempo.getDelta() * 0.0000003f);
        rotacionX -= Tiempo.getDelta() * 0.0000000005;
        getRotacion().setX(rotacionX);
        rotacionVolverX = 0.000000001f;
    }
    else {
        rotacionX += Tiempo.getDelta() * rotacionVolverX;
        if ((rotacionX > 0 && rotacionVolverX > 0) || (rotacionX < 0 && rotacionVolverX < 0)) {
            rotacionX = 0;
        } 
        else {
            getTraslacion().agregarZ(Tiempo.getDelta() * rotacionVolverX * -300);
        }
        getRotacion().setX(rotacionX);
    }

    if (Teclado.isKeyPressed(107)) {
        getTraslacion().agregarY(Tiempo.getDelta() * 0.0000003f);
    }
    if (Teclado.isKeyPressed(109)) {
        getTraslacion().agregarY(-Tiempo.getDelta() * 0.0000003f);
    }
    if (Teclado.isKeyPressed(32)) {
        Teclado.Keyup(32);
        Disparo disparo = new Disparo();
        disparo.getTraslacion().setX(getTraslacion().getX() + 0);
        disparo.getTraslacion().setY(getTraslacion().getY() + 0);
        disparo.getTraslacion().setZ(getTraslacion().getZ() + 0);
        getEspacio().agregarObjeto3D(disparo);
    }
    
    // Actualiza posición de la cámara
    Camara camara = getEspacio().getCamara();
    if (camaraX == null) {
        camaraX = camara.getPosicion().getX();
        camaraZ = camara.getPosicion().getZ();
    }
    camara.getPosicion().setX(camaraX + (int) (getTraslacion().getX() / 1.5));
    camara.getPosicion().setZ(camaraZ + (int) (getTraslacion().getZ() / 1.5));
}

@Override
public void colisiono(List<Objeto3D> objetos) {
    System.out.println("Nave acertó " + objetos.get(0).getEtiqueta() + " ...");
    
    boolean tieneEnemigo = false;
    for (Objeto3D objeto : objetos) {
        if (objeto.getEtiqueta().equals("enemigo")) {
            tieneEnemigo = true;
            break;
        }
    }
    if (!tieneEnemigo) {
        return;
    }
    
    // Explosión
    /*for (Cara cara : obtenerCaras()) {
        Esquirla esquirla = new Esquirla();
        esquirla.obtenerTraslacion().setX(obtenerTraslacion().getX());
        esquirla.obtenerTraslacion().setY(obtenerTraslacion().getY());
        esquirla.obtenerTraslacion().setZ(obtenerTraslacion().getZ());
        esquirla.obtenerRotacion().setX(obtenerRotacion().getX());
        esquirla.obtenerRotacion().setY(obtenerRotacion().getY());
        esquirla.obtenerRotacion().setZ(obtenerRotacion().getZ());
        esquirla.obtenerEscala().setX(obtenerEscala().getX());
        esquirla.obtenerEscala().setY(obtenerEscala().getY());
        esquirla.obtenerEscala().setZ(obtenerEscala().getZ());
        esquirla.agregarCara(cara);
        obtenerEspacio().agregarObjeto3D(esquirla);
    }*/
    getEspacio().eliminarObjeto3D(this);
    Tiempo.iniciarCronometro("nave alcanzada");
    }

    @Override
    public String getEtiqueta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}