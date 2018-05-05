import javax.imageio.ImageIO;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase puntos que le da al jugador 5 puntos al ser tocada
 * @author Marla/Alberto
 * @version 1.0
 */
public class Puntos extends GameObject{
    private BufferedImage imagen = null;
    private BufferedImage[] animacion;
    private int index=0;
    private ObtenerSectorImagen sheet;
    private Timer timer;

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id idetnificador
     */
    public Puntos(int x, int y, ID id)
    {
        super(x,y,id);
        velX=-6;

        try {
            imagen = ImageIO.read(Puntos.class.getResourceAsStream("/imagenes/monedas.png"));
        }catch(IOException e)
        {
            e.printStackTrace();
            
        }
        animacion = new BufferedImage[6];
        sheet = new ObtenerSectorImagen(imagen);
        animacion[0] = sheet.crop(7, 0, 33, 33);
        animacion[1] = sheet.crop(43, 0, 33, 33);
        animacion[2] = sheet.crop(79, 0, 33, 33);
        animacion[3] = sheet.crop(115, 0, 33, 33);
       animacion[4] = sheet.crop(151, 0, 33, 33);
        animacion[5] = sheet.crop(186, 0, 33, 33);

        timer = new Timer(100, animacionActualizar);
        timer.setRepeats(true);
        timer.start();
    }

    /**
     *
     * @return devuelve medida de rectangulo
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
    ActionListener animacionActualizar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            index++;
            if (index == animacion.length)
                index = 0;

        }
    };
    /**
     *
     * @param g grafica usada
     */
    public void render(Graphics g)
    {
        g.drawImage(animacion[index], x, y, null);

    }


}
