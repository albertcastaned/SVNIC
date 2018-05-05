import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * Clase Bala creada de los bloques se moveran rapido y haran daño al jugador al igual que los bloques
 * @author Marla/Alberto
 * @version 1.0
 */
public class Bala extends GameObject
{
    private Random ran;
    private int diry;

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id identificador del objeto
     */
    public Bala(int x, int y,ID id )
    {
        super(x,y,id);
        ran=new Random();
        diry=ran.nextInt(7);
        if(HUD.NIVEL>2) {
        	velX=-15;
        	diry=ran.nextInt(8);
        }
        if(HUD.NIVEL>4) {
        	velX=-20;
        	diry=ran.nextInt(10);
        }
        velX=-12;
        velY=diry;
        if((diry%2)==0)
            velY*=-1;
    }


    public void tick() {
        x+=velX;
        y+=velY;
        if(x<-150)
        {
            fuera=true;
        }
    }


    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 10, 10);

    }

    /**
     *
     * @return Medida de rectangulo
     */
    public Rectangle obtenerRectangulo() {
        return new Rectangle(x,y,10,10);
    }




}
