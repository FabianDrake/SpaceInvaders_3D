package motor;

import java.util.HashMap;
import java.util.Map;

public class Tiempo {

    private static long inicio;
    private static long fin;
    private static long delta;
    private static Map<String, Long> cronometros = new HashMap<String, Long>();

    public static long getInicio() {
        return inicio;
    }

    public static void setInicio(long inicio) {
        Tiempo.inicio = inicio;
    }

    public static long getFin() {
        return fin;
    }

    public static void setFin(long fin) {
        Tiempo.fin = fin;
        delta = fin - inicio;
    }

    public static long getDelta() {
        return delta;
    }
    
    public static void iniciarCronometro(String clave) {
        cronometros.put(clave, System.currentTimeMillis());
    }

    public static void detenerCronometro(String clave) {
        cronometros.remove(clave);
    }
    
    public static long obtenerCronometro(String clave) {
        Long tiempo = cronometros.get(clave);
        if (tiempo == null) {
            return -1;
        }
        tiempo = System.currentTimeMillis() - tiempo;
        return tiempo;
    }
    
}
