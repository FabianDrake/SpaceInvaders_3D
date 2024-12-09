package motor;


public class Camara {

    private Punto posicion = new Punto(25, -300, 25);
    private Punto objetivo = new Punto(25, 500, 25);

    private int ancho = 800;
    private int alto = 600;
    
    public Punto getPosicion() {
        return posicion;
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }

    public Punto getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Punto objetivo) {
        this.objetivo = objetivo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

}
