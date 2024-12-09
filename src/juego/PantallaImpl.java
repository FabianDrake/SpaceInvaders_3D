package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import motor.Colo;
import motor.Pantalla;


public class PantallaImpl implements Pantalla {
    
    private JFrame marco;
    private BufferStrategy estrategiaDeBuffer;
    private Graphics grafico;
    private Colo color;
    
    public PantallaImpl(JFrame marco) {
        marco.setBackground(Color.BLACK);
        marco.createBufferStrategy(2);
        this.marco = marco;
        this.estrategiaDeBuffer = marco.getBufferStrategy();
        this.grafico = estrategiaDeBuffer.getDrawGraphics();
    }
    
    public void setCor(Colo color) {
        this.color = color;
    }

    @Override
    public void dibujarLinea(int x1, int y1, int x2, int y2) {
        grafico.setColor(new Color(color.getR(), color.getG(), color.getB()));
        grafico.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void dibujarTexto(String texto, int x, int y) {
        grafico.setColor(new Color(color.getR(), color.getG(), color.getB()));
        grafico.drawString(texto, x, y);
    }

    @Override
    public void limpiar() {
        grafico.clearRect(0, 0, marco.getWidth(), marco.getHeight());
    }

    @Override
    public void mostrar() {
        estrategiaDeBuffer.show();
    }

    public void establecerColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void setColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setColor(motor.Colo color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
