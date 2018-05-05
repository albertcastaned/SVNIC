import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase Poder que le da al jugador 10 segundos de invencibilidad
 * @author Marla/Alberto
 * @version 1.0
 */
public class Poder extends GameObject{
    private BufferedImage imagen;

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id identificador
     */
    public Poder(int x, int y, ID id)
    {
        super(x,y,id);
        velX=-6;
        try {
            imagen = ImageIO.read(Poder.class.getResourceAsStream("/imagenes/poder.png"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return devuelve medida de rectangulo
     */
    public Rectangle obtenerRectangulo()
    {
            return new Rectangle(x,y,imagen.getWidth(),imagen.getHeight());
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
     * @param g grafica usada
     */
    public void render(Graphics g)
    {
        g.drawImage(imagen, x, y, null);

    }


}
