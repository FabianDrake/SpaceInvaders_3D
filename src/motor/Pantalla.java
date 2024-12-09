package motor;

import motor.Colo;


public interface Pantalla {

    public abstract void setColor(Colo color);
    public abstract void dibujarLinea(int x1, int y1, int x2, int y2);
    public abstract void dibujarTexto(String texto, int x, int y);

    public void limpiar();

    public void mostrar();

}
