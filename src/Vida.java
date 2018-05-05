import javax.imageio.ImageIO;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase vida que al ser tocada suma 1 a las vidas del jugador
 * @author Marla/Alberto
 * @version 1.0
 */
public class Vida extends GameObject {
	 private BufferedImage imagen = null;
	    private BufferedImage[] animacion;
	    private int index=0;
	    private ObtenerSectorImagen sheet;
	    private Timer timer;
    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id identificador
     */
    public Vida(int x, int y, ID id)
    {
        super(x,y,id);
        velX=-6;

        try {
            imagen = ImageIO.read(Vida.class.getResourceAsStream("/imagenes/vida.png"));
        }catch(IOException e)
        {
            e.printStackTrace();
           
        }
        animacion = new BufferedImage[5];
        sheet = new ObtenerSectorImagen(imagen);
        animacion[0] = sheet.crop(7, 0, 44, 39);
        animacion[1] = sheet.crop(54, 0, 44, 39);
        animacion[2] = sheet.crop(92, 0, 38, 39);
        animacion[3] = sheet.crop(121, 0, 38, 39);
       animacion[4] = sheet.crop(153, 0, 44, 39);

        timer = new Timer(125, animacionActualizar);
        timer.setRepeats(true);
        timer.start();

    }

    /**
     *
     * @return devuelve medidas del rectangulo de imagen
     */
    public Rectangle obtenerRectangulo()
    {
            return new Rectangle(x,y,animacion[0].getWidth(),animacion[0].getHeight());
    }

    public void tick()
    {
        x += velX;
        if(x<-150)
        {
            fuera=true;
        }
    }

    /**
     *
     * @param g Graficas usadas
     */
    public void render(Graphics g)
    {
        g.drawImage(animacion[index], x, y, null);
    }
    ActionListener animacionActualizar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            index++;
            if (index == 5)
                index = 0;

        }
    };


}
