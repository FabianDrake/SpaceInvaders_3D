package spaceinvaders;

import java.util.List;
import motor.Colo;
import motor.Espacio;
import motor.Objeto3D;
import motor.Tiempo;
import juego.MotorImpl;

public class SpaceInvaders extends Objeto3D {

    public static SpaceInvaders juego = new SpaceInvaders(); // Instancia principal del juego
    public static Nave nave = new Nave(); // Instancia de la nave del jugador
    public static Espacio espacio; // Espacio 3D donde se desarrollará el juego

    public static void main(String[] args) {
        // Inicializa el motor del juego
        MotorImpl motor = new MotorImpl();
        espacio = motor.getEspacio(); // Obtiene el espacio del motor
        prepararEspacio(espacio); // Configura los elementos iniciales
        motor.iniciar(); // Inicia el bucle del juego
    }

    // Configura los elementos del espacio (nave, enemigos, estrellas, etc.)
    public static void prepararEspacio(Espacio espacio) {
        espacio.agregarObjeto3D(juego); // Agrega el juego como objeto 3D principal

        // Generar estrellas de fondo de manera aleatoria
        for (int i = 0; i < 100; i++) {
            Estrella estrella = new Estrella();
            estrella.getTraslacion().setX((float) (Math.random() * 700 - 350));
            estrella.getTraslacion().setY((float) (Math.random() * 5750 - 750));
            estrella.getTraslacion().setZ((float) (Math.random() * 600 - 300));
            espacio.agregarObjeto3D(estrella);
        }

        // Generar enemigos y configurar sus posiciones y colores
        for (int i = 0; i < 20; i++) {
            Enemigo enemigo = new Enemigo();
            enemigo.getTraslacion().setX((float) (Math.random() * 500 - 250));
            enemigo.getTraslacion().setY((float) (Math.random() * 5000) - 2000);
            enemigo.getTraslacion().setZ((float) (Math.random() * 500 - 250));
            enemigo.setColor(new Colo(255, 0, 0)); // Colo rojo para los enemigos
            espacio.agregarObjeto3D(enemigo);

            Mira mira = new Mira(nave, enemigo); // Configura la mira entre la nave y el enemigo
            enemigo.establecerMira(mira);
            espacio.agregarObjeto3D(mira);
        }

        // Agrega la nave del jugador al espacio
        espacio.agregarObjeto3D(nave);
    }

    @Override
    public void actualizar() {
        // Verifica si la nave fue impactada y reinicia después de 5 segundos
        if (Tiempo.obtenerCronometro("nave impactada") > 5000) {
            Tiempo.detenerCronometro("nave impactada");
            nave = new Nave(); // Reinicia la nave del jugador
            Mira.nave = nave; // Actualiza la referencia de la mira
            espacio.agregarObjeto3D(nave);
            espacio.getCamara().getPosicion().setX(0); // Reinicia la posición de la cámara
            espacio.getCamara().getPosicion().setZ(0);
        }
    }

    @Override
    public String getEtiqueta() {
        return "juego"; // Etiqueta identificadora del objeto
    }

    @Override
    public void construir() {
        // Método para construir el objeto, actualmente vacío
    }

    @Override
    public void colisiono(List<Objeto3D> objetos) {
        // Lógica de colisión con otros objetos, actualmente vacía
    }
}
