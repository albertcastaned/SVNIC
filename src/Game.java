
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * Backend principal del programa en donde ocurre el 'Game Loop',
 * Aqui se crean todos los objetos, se crea la ventana, y se llama los metodos del handler.
 * @author Marla/Alberto
 * @version 1.0
 */

public class Game extends Canvas implements Runnable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1200,HEIGHT = WIDTH/16 * 9;
    private Thread thread;
    private boolean running=false;
    private Handler handler;
    private HUD hud;
    private GeneradorBloques genebloques;
    private GeneradorObjetos genepuntos;
    private BufferedImage fondo;
    private double fondox=0;
    private double fondoDx=0.005;

    public Game()
    {	
        hud = new HUD();
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new MiCanvas(WIDTH,HEIGHT, "Proyecto",this);
        try {
            fondo = ImageIO.read(Game.class.getResourceAsStream("/imagenes/fondo.jpg"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        Random r =  new Random();
        genepuntos = new GeneradorObjetos(handler);
        genebloques =  new GeneradorBloques(handler);
        handler.agregarObjeto(new Jugador(5,HEIGHT/2,ID.Jugador,handler));
        


    }
    /**
  	 * Se usa para la lectura de todos los threads de las distintas clases
  	 * 
  	 */
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }
    /**
   	 * Detiene el chequeo de todos lo threads
   	 * 
   	 */
    public synchronized void stop()
    {
        try{
            thread.join();
            running=false;
            
            
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
   	 * llama al metodo de ejecución para evitar el parpadeo y va actualizando la pantalla
   	 */
    public synchronized void run()
    {
            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000/amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames=0;
            while(running)
            {
                long now = System.nanoTime();
                delta += (now - lastTime)/ns;
                lastTime = now;
                while(delta >=1)
                {
                    tick();
                    delta--;
                }
                if(running)
                    render();
                frames++;

                if(System.currentTimeMillis()-timer>1000){
                    timer+=1000;
                    System.out.println("FPS: " + frames);
                    frames=0;
                }
            }
            stop();
    }
    /**
   	 *	Actualiza los procesos de los objetos
   	 */
    private void tick()
    {	
        handler.tick();
        hud.tick();
        if(HUD.VIDA==0)
        {	
        	
        	
        	System.exit(0);
        }

       
        
    
    }
    /**
   	 * Llama todos los metodos graficos
   	 */
    private void render()
    {	
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
    
        if(fondox>getWidth()*-1)
        {
        	fondox-=fondoDx;
        }else {
        	fondox=0;
        }
        g.drawImage(fondo,(int)fondox,0,null);
        g.drawImage(fondo,(int)fondox+getWidth(),0,null);
        
        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
 
        
    }
    /**
   	 * @param int var el valor actual, ya sea de vida o puntos
   	 * @param int var el valor minimo, que pueda tener vida antes de detener el juego
   	 * @param int var el valor maximo, que pueda tener vida para no sumarle mas vidas
   	 * checa que los parametros esten al margen
   	 */
    public static int clamp(int var, int min,int max){
        if(var >= max)
            return var = max;
        else if(var<=min)
            return var=min;
        else
            return var;
    }
    public static void main(String args[])
    {
        new Game();
    }
}