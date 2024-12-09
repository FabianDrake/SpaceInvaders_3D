package spaceinvaders;

import motor.WaveFront;

/**
 *
 * @author leonardo
 */
public class Util {

    public static void main(String[] args) {
        //Wavefront.convertirEnCodigo(System.getProperty("user.dir").replace("\\","/") + "/res/nave.obj", 30);
        WaveFront.convertirACodigo(System.getProperty("user.dir").replace("\\","/") + "/res/heroi.obj", 3f);
    }
    
}
