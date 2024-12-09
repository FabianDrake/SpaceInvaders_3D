package motor;


public interface Colisionable {
    
    public abstract void setTranslacion(Punto punto);
    public abstract boolean colisiona(Colisionable colisionable);

    public void setTraslacion(Punto traslacion);
    
}
