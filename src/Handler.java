import java.awt.*;
import java.util.*;

/**
 * Clase que agrega todos los objetos interactuables en una lista para poder dibujar y procesar cada uno
 * Los que tengan la variable fuera como verdadero se eliminaran de la lista antes de iterar
 * @author Marla/Alberto
 * @version 1.0
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<>();

    public void tick()
    {
        for(int i=0;i<object.size();i++)
        {
            if(object.get(i).fuera)
                object.remove(i);
        }
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }


    }

    /**
     *
     * @param g Graficas utilizadas
     */
    public void render(Graphics g)
    {
        for(int i=0;i<object.size();i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.render(g);

        }
    }

    /**
     *
     * @param object objeto que se agregara a la lista
     */
    public void agregarObjeto(GameObject object)
    {
        this.object.add(object);
    }

    /**
     *
     * @param object objeto que se eliminara de la lista
     */
    public void removeObject(GameObject object)
    {
        this.object.remove(object);
    }
}

