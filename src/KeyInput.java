import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase que configura las teclas a utilizar para hacer los movimientos del jugador
 * @author Marla/Alberto
 * @version 1.0
 */
public class KeyInput extends KeyAdapter {
    private Handler handler;
    private boolean up,down,left,right;

    /**
     *
     * @param handler handler utilizado
     */
    public KeyInput(Handler handler)
    {
        this.handler = handler;
    }

    /**
     *
     * @param e tecla presionada
     */
    public void keyPressed(KeyEvent e)
    {   int key = e.getKeyCode();
        for(int i=0;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID()==ID.Jugador)
            {
                if(key == KeyEvent.VK_UP) {up=true;tempObject.setVelY(-9);}
                if(key == KeyEvent.VK_DOWN){down=true; tempObject.setVelY(9);}
                if(key == KeyEvent.VK_LEFT) {left=true;tempObject.setVelX(-9);}
                if(key == KeyEvent.VK_RIGHT){right=true; tempObject.setVelX(9);}


            }
        }

    }
    /**
     *
     * @param e tecla presionada
     */
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        for(int i=0;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID()==ID.Jugador) {
                if (key == KeyEvent.VK_UP) {
                    up = false;
                    if (down) {
                        tempObject.setVelY(9);
                    } else {
                        tempObject.setVelY(0);
                    }
                }
                if (key == KeyEvent.VK_DOWN) {
                    down = false;
                    if (up) {
                        tempObject.setVelY(-9);
                    } else {
                        tempObject.setVelY(0);
                    }
                }
                if (key == KeyEvent.VK_LEFT){
                        left = false;
                        if (right) {
                            tempObject.setVelX(9);
                        } else {
                            tempObject.setVelX(0);
                        }
                }
                    if (key == KeyEvent.VK_RIGHT){
                        right = false;
                        if (left) {
                            tempObject.setVelX(-9);
                        } else {
                            tempObject.setVelX(0);
                        }
                    }


            }
        }

    }
}
