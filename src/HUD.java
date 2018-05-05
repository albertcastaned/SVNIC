import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Muestra variables importantes del sistema en pantalla
 * @author Marla/Alberto
 * @version 1.0
 */
public class HUD {
    public static int VIDA = 5;
    public static int PUNTOS = 0;
    public static int NIVEL = 1;
    private BufferedImage[] imagen;
    private BufferedImage puntoscounter;
    public HUD() {
    	imagen = new BufferedImage[5];
    	try {
            imagen[0] = ImageIO.read(HUD.class.getResourceAsStream("/imagenes/barravida1.png"));
            imagen[1] = ImageIO.read(HUD.class.getResourceAsStream("/imagenes/barravida2.png"));
            imagen[2] = ImageIO.read(HUD.class.getResourceAsStream("/imagenes/barravida3.png"));
            imagen[3] = ImageIO.read(HUD.class.getResourceAsStream("/imagenes/barravida4.png"));
            imagen[4] = ImageIO.read(HUD.class.getResourceAsStream("/imagenes/barravida5.png"));
            puntoscounter = ImageIO.read(HUD.class.getResourceAsStream("/imagenes/puntoscounter.png"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void tick()
    {
        VIDA = Game.clamp(VIDA,0,100);
        if(PUNTOS==50)
            NIVEL=2;
        if(PUNTOS==100)
            NIVEL=3;
        if(PUNTOS==150)
            NIVEL=4;
        if(PUNTOS==200)
            NIVEL=5;


    }

    /**
     *
     * @param g graficas usadas
     */
    public void render(Graphics g)
    {		g.setColor(Color.white);
    	if(VIDA!=0) {
    	  g.drawImage(imagen[VIDA-1],0,10,null);
          g.drawImage(puntoscounter,-10,50,null);
          g.setFont(new Font("Rockwell", Font.BOLD, 30)); 
          g.drawString("= "+PUNTOS,60,90);
          g.drawString("NIVEL: "+NIVEL,5,140);
    	}
          
    }
}
