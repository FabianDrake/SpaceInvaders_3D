package motor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Objeto3D {

    private Espacio espacio;
    
    private Punto traslacion = new Punto(0, 0, 0);
    private Punto rotacion = new Punto(0.01f, 0.01f, 0.01f);
    private Punto escala = new Punto(0, 0, 0);
    
    private List<Cara> caras = new ArrayList<Cara>();
    
    private Colisionable colisionable;
    
    private Colo color = new Colo(255, 255, 255); // blanco
    
    public Objeto3D(Cara ... fs) {
        caras.addAll(Arrays.asList(fs));
        construir();
    }

    public List<Cara> getCaras() {
        return caras;
    }

    public Colo getColor() {
        return color;
    }

    public void setColor(Colo color) {
        this.color = color;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public Punto getTraslacion() {
        return traslacion;
    }

    public void setTraslacion(Punto traslacion) {
        this.traslacion = traslacion;
    }

    public Punto getRotacion() {
        return rotacion;
    }

    public void setRotacion(Punto rotacion) {
        this.rotacion = rotacion;
    }

    public Punto getEscala() {
        return escala;
    }

    public void setEscala(Punto escala) {
        this.escala = escala;
    }
    
    public Colisionable getColisionable() {
        return colisionable;
    }

    public void setColisionable(Colisionable colisionable) {
        colisionable.setTraslacion(traslacion);
        this.colisionable = colisionable;
    }
    
    public void agregarCara(Cara cara) {
        cara.setObjeto3D(this);
        caras.add(cara);
    }

    public void removerCara(Cara cara) {
        cara.setObjeto3D(null);
        caras.remove(cara);
    }
    
    public void dibujar(Pantalla pantalla, Camara camara) {
        for (Cara cara : caras) {
            cara.dibujar(pantalla, camara, traslacion, rotacion, escala);
        }
    }
    
    // Para cada actualización
    public abstract void actualizar();
    
    // Sirve como identificador para el objeto 3D
    public abstract String getEtiqueta();

    // Invocado para construir
    public abstract void construir();

    // Invocado cuando un objeto 3D colisiona con otro
    public abstract void colisiono(List<Objeto3D> objetos);
    
}
