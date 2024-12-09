package motor;

public class Teclado {

    private static boolean[] teclas = new boolean[255];

    public static void Keydown(int codigoTecla) {
        teclas[codigoTecla] = true;
    }

    public static void Keyup(int codigoTecla) {
        teclas[codigoTecla] = false;
    }
    
    public static boolean isKeyPressed(int codigoTecla) {
        return teclas[codigoTecla];
    }

    public static void keyDown(int keyCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void keyUp(int keyCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
