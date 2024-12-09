package motor;

public abstract class Motor implements Runnable {

    private Pantalla pantalla;
    private Espacio espacio = new Espacio();

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }
    
    public void iniciar() {
        if (pantalla == null) {
            throw new RuntimeException("¡Pantalla no fue establecida!");
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        int contador = 0;
        int fps = 0;
        long tiempo = System.currentTimeMillis();
        
        /*
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(System.getProperty("user.dir").replace("\\","/") + "/res/fundo.jpg"));
        } catch (IOException e) {
        }
         */
        
        while (true) {
            Tiempo.setInicio(System.nanoTime());
            
            //Graphics b = getBufferStrategy().getDrawGraphics();
            
            //setBackground(Colo.BLACK);
            //b.clearRect(0, 0, getWidth(), getHeight());
            //b.drawImage(img, 0, 0, null);
            pantalla.limpiar();
            
            espacio.verificarColisiones();
            espacio.dibujar(pantalla);

            /*
            // Simula un retraso de tiempo aleatorio
            try {
                long pausa = (long) (Math.random() * 10);
                Thread.sleep(pausa);
            } catch (InterruptedException ex) {
            }
            */ 

            contador++;
            long tiempoTranscurrido = System.currentTimeMillis() - tiempo;
            if (tiempoTranscurrido >= 1000) {
               fps = contador;
               tiempo = System.currentTimeMillis();
               contador = 0;
            }
            pantalla.setColor(new Colo(255, 255, 255));
            pantalla.dibujarTexto("FPS: " + fps, 50, 50);
            
            pantalla.mostrar();
            
            Tiempo.setFin(System.nanoTime());
        }
    }
}
