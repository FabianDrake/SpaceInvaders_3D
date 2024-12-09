package motor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cara {
    
    private Objeto3D objeto3D;
    private List<Punto> puntos = new ArrayList<Punto>();

    public Cara(Punto ... p) {
        puntos.addAll(Arrays.asList(p));
    }

    public Objeto3D getObjeto3D() {
        return objeto3D;
    }

    public void setObjeto3D(Objeto3D objeto3D) {
        this.objeto3D = objeto3D;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }

    public void dibujar(Pantalla g, Camara camara, Punto translacion, Punto rotacion, Punto escala) {
        float xc = camara.getPosicion().getX();
        float yc = camara.getPosicion().getY();
        float zc = camara.getPosicion().getZ();
        float ys = camara.getObjetivo().getY();
        
        Poligono poligono = new Poligono();
        
        for (Punto p : puntos) {
            double xp = p.getX() + 0.000000001;
            double yp = p.getY() + 0.000000001;
            double zp = p.getZ() + 0.000000001;
            
            double hipotenusa = 0;
            double a = 0;

            // Rotación en Z
            hipotenusa = Math.sqrt(Math.pow(xp, 2) + Math.pow(yp, 2));
            a = Math.atan(xp / yp);
            a -= rotacion.getZ();
            yp = (float) (hipotenusa * Math.cos(a));
            xp = (float) (hipotenusa * Math.sin(a));
            if (p.getY() < 0) {
                yp = -yp;
                xp = -xp;
            }
            
            // Rotación en X
            hipotenusa = Math.sqrt(Math.pow(yp, 2) + Math.pow(zp, 2));
            a = Math.atan(yp / zp);
            a -= rotacion.getX();
            zp = (float) (hipotenusa * Math.cos(a));
            yp = (float) (hipotenusa * Math.sin(a));
            if (p.getZ() < 0) {
                zp = -zp;
                yp = -yp;
            }
            
            // Rotación en Y
            double zpg = zp;
            hipotenusa = Math.sqrt(Math.pow(xp, 2) + Math.pow(zp, 2));
            a = Math.atan(xp / zp);
            a -= rotacion.getY();
            zp = (float) (hipotenusa * Math.cos(a));
            xp = (float) (hipotenusa * Math.sin(a));
            if (zpg < 0) {
                zp = -zp;
                xp = -xp;
            }

            // Translación
            xp += translacion.getX();
            yp += translacion.getY();
            zp += translacion.getZ();
            
            float xv = (float) ((yc - ys) * (xc - xp) / (yc - yp));
            float zv = (float) ((yc - ys) * (zc - zp) / (yc - yp));
            
            xv += (camara.getAncho() / 2);
            zv += (camara.getAlto() / 2);

            poligono.agregarPunto((int) xv, (int) zv);
        }
        g.setColor(new Colo(255, 255, 255)); // Blanco
        if (objeto3D != null) {
            g.setColor(objeto3D.getColor());
        }
        dibujarPoligono(g, poligono);
    }

    private class PuntoPoligono {
        int x;
        int y;
        public PuntoPoligono(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private class Poligono {
        List<PuntoPoligono> puntos = new ArrayList<>();
        public void agregarPunto(int x, int y) {
            puntos.add(new PuntoPoligono(x, y));
        }
    }
    
    private void dibujarPoligono(Pantalla pantalla, Poligono poligono) {
        PuntoPoligono puntoInicial = poligono.puntos.get(0);
        PuntoPoligono puntoFinal = null;
        for (int i = 1; i < poligono.puntos.size(); i++) {
            puntoFinal = poligono.puntos.get(i);
            if (objeto3D != null) {
                pantalla.setColor(objeto3D.getColor());
            }
            pantalla.dibujarLinea(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
            puntoInicial = puntoFinal;
        }
        puntoFinal = poligono.puntos.get(0);
        pantalla.dibujarLinea(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
    }
}
