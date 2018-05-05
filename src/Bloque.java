
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Clase Bloque se creara para que el jugador lo esquive y para crear balas desde su posicion
 * @author Marla/Alberto
 * @version 1.0
 */
public class Bloque extends GameObject{
    private Timer timer;
    private Handler handler;

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id identificador del objeto
     * @param handler llama al handler para poder agregar los objetos de las balas
     */
    public Bloque(int x,int y, ID id,Handler handler)
    {
        super(x,y,id);
        this.handler=handler;
        velX=-10;
        timer = new Timer(750, crear);
        timer.setRepeats(true);
        timer.start();
    }

    /**
     *
     * @return Regresa la medida del rectangulo
     */
    public Rectangle obtenerRectangulo() {
        return new Rectangle(x,y,64,64);
    }

    public void tick(){
        x+=velX;
        if(x<-150)
        {
            fuera=true;
        }

    }

    public void render(Graphics g)
    {
    	if(HUD.NIVEL==1)
        g.setColor(new Color(255,195,0));
    	if(HUD.NIVEL==2)
            g.setColor(new Color(255,87,51));
    	if(HUD.NIVEL==3)
            g.setColor(new Color(199,0,57));
    	if(HUD.NIVEL==4)
            g.setColor(new Color(144,12,63));
    	if(HUD.NIVEL==5)
            g.setColor(new Color(88,24,69));
    	
        g.fillRect(x,y,64,64);
    }
    ActionListener crear = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if(!fuera) {
                handler.agregarObjeto(new Bala(x - 5, y + 16, ID.Bala));
             

            }

        }
    };
}
