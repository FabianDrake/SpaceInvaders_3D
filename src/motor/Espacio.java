package motor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Espacio {

    private Camara camara = new Camara();
    private List<Objeto3D> objetos = Collections.synchronizedList(new ArrayList<Objeto3D>());
    private List<Objeto3D> objetosAgregar = Collections.synchronizedList(new ArrayList<Objeto3D>());
    private List<Objeto3D> objetosEliminar = Collections.synchronizedList(new ArrayList<Objeto3D>());
    
    public void agregarObjeto3D(Objeto3D objeto) {
        objeto.setEspacio(this);
        objetosAgregar.add(objeto);
    }

    public void eliminarObjeto3D(Objeto3D objeto) {
        objetosEliminar.add(objeto);
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public void dibujar(Pantalla g) {
        Iterator<Objeto3D> i = objetos.iterator();
        while (i.hasNext()) {
            Objeto3D objeto = i.next();
            objeto.actualizar();
            objeto.dibujar(g, camara);
        }
        
        objetos.addAll(objetosAgregar);
        objetosAgregar.clear();
        
        objetos.removeAll(objetosEliminar);
        objetosEliminar.clear();
    }

    public void verificarColisiones() {
        Iterator<Objeto3D> i = objetos.iterator();
        while (i.hasNext()) {
            List<Objeto3D> objetosColisionados = new ArrayList<Objeto3D>();
            Objeto3D objeto = i.next();
            
            if (objeto.getColisionable() == null) {
                continue;
            }
            
            Iterator<Objeto3D> i2 = objetos.iterator();
            while (i2.hasNext()) {
                Objeto3D objeto2 = i2.next();
                
                if (objeto2.getColisionable() == null || objeto == objeto2) {
                    continue;
                }
                
                if (objeto.getColisionable().colisiona(objeto2.getColisionable())) {
                    objetosColisionados.add(objeto2);
                }
            }
            
            if (!objetosColisionados.isEmpty()) {
                objeto.colisiono(objetosColisionados);
            }
        }
    }
}
