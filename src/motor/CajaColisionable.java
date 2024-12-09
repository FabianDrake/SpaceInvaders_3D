package motor;

public class CajaColisionable implements Colisionable {

    private Punto a = new Punto(0, 0, 0);
    private Punto b = new Punto(0, 0, 0);
    private Punto translacion = new Punto(0, 0, 0);
    
    public Punto getA() {
        return a;
    }

    public void setA(Punto a) {
        this.a = a;
    }

    public Punto getB() {
        return b;
    }

    public void setB(Punto b) {
        this.b = b;
    }

    public Punto getTranslacion() {
        return translacion;
    }
    
    @Override
    public void setTranslacion(Punto translacion) {
        this.translacion = translacion;
    }
    
    @Override
    public void setTraslacion(Punto translacion) {
        this.translacion = translacion;
    }
    
    public boolean colisiona(Colisionable colisionable) {
        CajaColisionable colisionador = (CajaColisionable) colisionable;
        
        float ax = a.getX() + translacion.getX();
        float ay = a.getY() + translacion.getY();
        float az = a.getZ() + translacion.getZ();

        float bx = b.getX() + translacion.getX();
        float by = b.getY() + translacion.getY();
        float bz = b.getZ() + translacion.getZ();

        float cax = colisionador.a.getX() + colisionador.translacion.getX();
        float cay = colisionador.a.getY() + colisionador.translacion.getY();
        float caz = colisionador.a.getZ() + colisionador.translacion.getZ();

        float cbx = colisionador.b.getX() + colisionador.translacion.getX();
        float cby = colisionador.b.getY() + colisionador.translacion.getY();
        float cbz = colisionador.b.getZ() + colisionador.translacion.getZ();
    
        Rectangulo r1 = new Rectangulo((int) ax, (int) ay, (int)(bx-ax), (int) (by-ay));
        Rectangulo r2 = new Rectangulo((int) ay, (int) az, (int)(by-ay), (int) (bz-az));
        
        boolean v1 = r1.contiene(cax, cay) && r2.contiene(cay, caz);
        boolean v2 = r1.contiene(cax, cay) && r2.contiene(cay, cbz);

        boolean v3 = r1.contiene(cax, cby) && r2.contiene(cby, caz);
        boolean v4 = r1.contiene(cax, cby) && r2.contiene(cby, cbz);

        boolean v5 = r1.contiene(cbx, cby) && r2.contiene(cby, caz);
        boolean v6 = r1.contiene(cbx, cby) && r2.contiene(cby, cbz);

        boolean v7 = r1.contiene(cbx, cay) && r2.contiene(cay, caz);
        boolean v8 = r1.contiene(cbx, cay) && r2.contiene(cay, cbz);
        
        boolean colisiono = v1 || v2 || v3 || v4 || v5 || v6 || v7 || v8;
        return colisiono;
    }
 
    // Implementado para Android
    private class Rectangulo {
        int ax;
        int ay;
        int wx;
        int wy;

        public Rectangulo(int ax, int ay, int wx, int wy) {
            this.ax = ax;
            this.ay = ay;
            this.wx = wx;
            this.wy = wy;
        }
        
        boolean contiene(double x, double y) {
            return (x >= ax && x <= (ax + wx) && y >= ay && y <= (ay + wy));
        }
    }
    
}
