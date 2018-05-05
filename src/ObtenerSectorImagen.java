import java.awt.image.BufferedImage;

/**
 * Clase para cortar la imagen del jugador en sectores
 * @author Marla/Alberto
 * @version 1.0
 */
public class ObtenerSectorImagen {
    private BufferedImage sheet;

    /**
     *
     * @param sheet imagen usada
     */
    public ObtenerSectorImagen(BufferedImage sheet)
    {
        this.sheet = sheet;
    }

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param width ancho
     * @param height alto
     * @return devuelve imagen
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x,y,width,height);
    }
}
