package juego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import motor.Motor;
import motor.Teclado;
import motor.Pantalla;

public class MotorImpl extends Motor implements KeyListener {

    private JFrame ventana = new JFrame() {
        @Override
        public void update(Graphics g) {
            super.update(g);
        }
    };

    public MotorImpl() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(800, 600);
        ventana.setLocationRelativeTo(null);
        ventana.addKeyListener(this);
        ventana.setVisible(true);
        Pantalla pantalla = new PantallaImpl(ventana);
        setPantalla(pantalla);
    }

    @Override
    public void iniciar() {
        super.iniciar();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed " + e.getKeyCode() + " ...");
        Teclado.keyDown(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Teclado.keyUp(e.getKeyCode());
    }
}
