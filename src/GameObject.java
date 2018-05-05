import java.awt.*;

/**
 * Objeto padre de todos los objetos fisicos dentro del juego que interactuan entre si
 * Aqui se crea las variables de posicion x,y, velocidades, y booleano de si deben ser borrados o no
 * @author Marla/Alberto
 * @version 1.0
 */
public abstract class GameObject {

    protected int x,y;
    protected ID id;
    protected int velX,velY;
    protected boolean fuera;

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id identificador
     */
    public GameObject(int x,int y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        fuera=false;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle obtenerRectangulo();

    /**
     *
     * @param x posicion x deseada
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     *
     * @param y posicion y deseada
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     *
     * @param id identificador deseado
     */
    public void setID(ID id)
    {
        this.id = id;
    }

    /**
     *
     * @return posicion x actual
     */
    public int getX()
    {
        return x;
    }

    /**
     *
     * @return posicion y actual
     */
    public int getY()
    {
        return y;
    }

    /**
     *
     * @return identificador actual
     */
    public ID getID()
    {
        return id;
    }

    /**
     *
     * @param velX velocidad horizontal deseada
     */
    public void setVelX(int velX)
    {
        this.velX = velX;
    }

    /**
     *
     * @param velY velocidad vertical deseada
     */
    public void setVelY(int velY)
    {
        this.velY = velY;
    }

    /**
     *
     * @return velocidad horizontal actual
     */
    public int getVelX()
    {
        return velX;
    }

    /**
     *
     * @return velocidad vertical actual
     */
    public int getVelY()
    {
        return velY;
    }

}
