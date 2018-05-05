import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Clase que genera los puntos, las vidas, y los poderes a travez de diferentes timers y en posicion random
 * @author Marla/Alberto
 * @version 1.0
 */
public class GeneradorObjetos {
    private Random r;
    private Random p;
    private Handler handler;
    private Timer timer,timer2,timer3;

    /**
     *
     * @param handler llama al handler para clear los diferentes objetos
     */
    public GeneradorObjetos(Handler handler)
    {
        this.handler=handler;
        p = new Random();
        timer = new Timer(p.nextInt(3000)+2000, crearPuntos);
        timer.setRepeats(true);
        timer.start();
        timer2 = new Timer(p.nextInt(12000)+8000, crearVida);
        timer2.setRepeats(true);
        timer2.start();
        timer3 = new Timer(p.nextInt(20000)+15000, crearPoder);
        timer3.setRepeats(true);
        timer3.start();
    }

    ActionListener crearPuntos = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
                r = new Random();
                handler.agregarObjeto(new Puntos(Game.WIDTH, r.nextInt(Game.HEIGHT-100), ID.Puntos));
                p = new Random();
                timer.setDelay(p.nextInt(3000));

                }


    };

    ActionListener crearPoder = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            r = new Random();
            handler.agregarObjeto(new Poder(Game.WIDTH, r.nextInt(Game.HEIGHT), ID.Poder));
            p = new Random();
            timer.setDelay(p.nextInt(5000));
        }


    };

    ActionListener crearVida = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            r = new Random();
            handler.agregarObjeto(new Vida(Game.WIDTH, r.nextInt(Game.HEIGHT), ID.Vida));
            p = new Random();
            timer.setDelay(p.nextInt(8000));
        }


    };
}
