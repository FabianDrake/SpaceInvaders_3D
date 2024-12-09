package spaceinvaders;

import java.util.List;
import motor.Objeto3D;
import motor.Tiempo;

public class Fragmento extends Objeto3D {

    float x = (float) (Math.random() * 0.000000005f);
    float y = (float) (Math.random() * 0.000000005f);
    float z = (float) (Math.random() * 0.000000005f);

    float xt = (float) (Math.random() * 0.0000002f - 0.0000001f);
    float zt = (float) (Math.random() * 0.0000002f - 0.0000001f);
    
    @Override
    public void actualizar() {
        // Actualiza la rotación del fragmento
        getRotacion().agregarX(Tiempo.getDelta() * x);
        getRotacion().agregarY(Tiempo.getDelta() * y);
        getRotacion().agregarZ(Tiempo.getDelta() * z);

        // Actualiza la traslación del fragmento
        getTraslacion().agregarY(Tiempo.getDelta() * -0.0000001f);
        getTraslacion().agregarX(Tiempo.getDelta() * xt);
        getTraslacion().agregarZ(Tiempo.getDelta() * zt);
        
        // Elimina el fragmento si su posición en Y es menor a -200
        if (getTraslacion().getY() < -200) {
            getEspacio().eliminarObjeto3D(this);
        }
    }

    @Override
    public String getEtiqueta() {
        return "fragmento"; // Etiqueta identificadora del objeto
    }

    @Override
    public void construir() {
        // Método vacío; personalizar si se necesita construir la geometría del fragmento
    }

    @Override
    public void colisiono(List<Objeto3D> objetos) {
        // Método vacío; personalizar lógica de colisión si es necesario
    }
    
}
