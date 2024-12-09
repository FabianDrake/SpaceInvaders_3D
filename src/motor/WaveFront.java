package motor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WaveFront {

    public static void cargar(String archivo, Objeto3D objeto, float escala) {
        List<Punto> puntos = new ArrayList<Punto>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = null;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
                if (linea.toLowerCase().startsWith("v")) {
                    String[] ps = linea.split("\\ ");
                    float x = -Float.valueOf(ps[1]) * escala;
                    float z = Float.valueOf(ps[2]) * escala;
                    float y = -Float.valueOf(ps[3]) * escala;
                    Punto p = new Punto(x, y, z);
                    puntos.add(p);
                } else if (linea.toLowerCase().startsWith("f")) {
                    String[] fs = linea.split("\\ ");
                    Cara cara = new Cara();
                    for (int i = 1; i < fs.length; i++) {
                        int indice = Integer.valueOf(fs[i]) - 1;
                        Punto punto = puntos.get(indice);
                        cara.getPuntos().add(punto);
                    }
                    objeto.agregarCara(cara);
                }
            }
            br.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void convertirACodigo(String archivo, float escala) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int pi = 0;
            int ci = 0;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().startsWith("v")) {
                    String[] ps = linea.split("\\ ");
                    float x = -Float.valueOf(ps[1]) * escala;
                    float z = Float.valueOf(ps[2]) * escala;
                    float y = -Float.valueOf(ps[3]) * escala;
                    System.out.println("Punto p" + (++pi) + " = new Punto(" + x + "f, " + y + "f, " + z + "f);");
                } else if (linea.toLowerCase().startsWith("f")) {
                    String[] fs = linea.split("\\ ");
                    System.out.print("Cara c" + (++ci) + " = new Cara(");
                    for (int i = 1; i < fs.length; i++) {
                        int indice = Integer.valueOf(fs[i]);
                        System.out.print("p" + indice + "" + (i == (fs.length - 1) ? "" : ","));
                    }
                    System.out.println(");");
                }
            }
            br.close();
            for (int i = 1; i <= ci; i++) {
                System.out.println("addCara(c" + i + ");");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
