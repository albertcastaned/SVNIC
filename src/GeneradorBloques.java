import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

/**
 * Clase que genera bloques con un timer y en posicion random
 * @author Marla/Alberto
 * @version 1.0
 */
public class GeneradorBloques {
    private int ypos1,espacio;
    private Random p;
    private Handler handler;
    private Timer timer;

    /**
     *
     * @param handler llama al handler para crear los bloques
     */
    public GeneradorBloques(Handler handler)
    {
        this.handler=handler;
        p = new Random();
        timer = new Timer(1300, crear);
        timer.setRepeats(true);
        timer.start();
    }
    /**
    *
    * van generando vidas, puntos o poder en cordenadas distintas depues de cierto tiempo
    */
    ActionListener crear = new ActionListener(){
        public void actionPerformed(ActionEvent e) {

            ypos1 = p.nextInt(Game.HEIGHT/2);
            espacio = p.nextInt(200)+32;
            handler.agregarObjeto(new Bloque(Game.WIDTH,ypos1,ID.Bloque,handler));
            handler.agregarObjeto(new Bloque(Game.WIDTH,ypos1+espacio,ID.Bloque,handler));
            handler.agregarObjeto(new Bloque(Game.WIDTH,ypos1+espacio*2,ID.Bloque,handler));
            handler.agregarObjeto(new Bloque(Game.WIDTH,ypos1+espacio*3,ID.Bloque,handler));


        }
    };
}

