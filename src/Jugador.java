import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase de jugador que procesara su posicion, su imagen, y el estado en el que esta
 * @author Marla/Alberto
 * @version 1.0
 */
public class Jugador extends GameObject {
    private BufferedImage imagen = null;
    private BufferedImage blank;
    private BufferedImage[] jugador;
    private BufferedImage[] jugadorArriba;
    private BufferedImage[] jugadorAbajo;
    private BufferedImage[] frames = new BufferedImage[2];
    private ObtenerSectorImagen sheet;
    private Timer timer;
    private Timer poder;
    private Timer golpeadoT;
    private Handler handler;
    private boolean invencible;
    private boolean golpeado;
    private int index = 0;
    private boolean visible=true;

    /**
     *
     * @param x posicion horizontal
     * @param y posicion vertical
     * @param id identificador
     * @param handler handler utilizado
     */
    public Jugador(int x, int y, ID id,Handler handler) {
        super(x, y, id);
        this.handler=handler;
        try {
            imagen = ImageIO.read(Jugador.class.getResourceAsStream("/imagenes/sprites.png"));
            blank = ImageIO.read(Jugador.class.getResourceAsStream("/imagenes/blank.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
            jugador = new BufferedImage[3];
            jugadorAbajo = new BufferedImage[3];
            jugadorArriba = new BufferedImage[3];

            sheet = new ObtenerSectorImagen(imagen);
            jugador[0] = sheet.crop(0, 84, 88, 78);
            jugador[1] = sheet.crop(92, 84, 88, 78);
            jugadorArriba[0] = sheet.crop(0, 8, 88, 64);
            jugadorArriba[1] = sheet.crop(92, 8, 88, 64);
            jugadorAbajo[0] = sheet.crop(0, 176, 88, 64);
            jugadorAbajo[1] = sheet.crop(92, 176, 88, 64);
            timer = new Timer(100, animacionActualizar);
            timer.setRepeats(true);
            timer.start();
            invencible=false;
            golpeado=false;



    }

    /**
     *
     * @return devuelve rectangulo de la medida de la imagen
     */
    @Override
    public Rectangle obtenerRectangulo() {
        return new Rectangle(x,y-10,jugador[0].getWidth()-10,jugador[0].getHeight()-10);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        y=Game.clamp(y,0,Game.HEIGHT-100);
        x=Game.clamp(x,0,Game.WIDTH-100);
        collision();
    }

    private void collision()
    {
        for(int i=0;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID()==ID.Bloque)
            {
                if(obtenerRectangulo().intersects(tempObject.obtenerRectangulo()))
                {
                    if(!invencible&&!golpeado) {
                        HUD.VIDA -= 1;
                        golpeado=true;
                        golpeadoT = new Timer(2000, golpeadoTimer);
                        golpeadoT.start();
                        tempObject.fuera=true;
                    }

                }

            }

            if(tempObject.getID()==ID.Bala)
            {
                if(obtenerRectangulo().intersects(tempObject.obtenerRectangulo()))
                {
                    if(!invencible&&!golpeado) {
                        HUD.VIDA -= 1;
                        golpeado=true;
                        golpeadoT = new Timer(2000, golpeadoTimer);
                        golpeadoT.start();
                        tempObject.fuera=true;
                    }

                }

            }
            if(tempObject.getID()==ID.Puntos)
            {
                if(obtenerRectangulo().intersects(tempObject.obtenerRectangulo()))
                {
                    HUD.PUNTOS+=5;
                    tempObject.fuera=true;


                }

            }
            if(tempObject.getID()==ID.Vida)
            {
                if(obtenerRectangulo().intersects(tempObject.obtenerRectangulo()))
                {	
                	if(HUD.VIDA<5)
                {
                    HUD.VIDA+=1;
                    tempObject.fuera=true;
                }
                }

            }
            if(tempObject.getID()==ID.Poder)
            {
                if(obtenerRectangulo().intersects(tempObject.obtenerRectangulo()))
                {   if(!invencible) {
                	invencible=true;
                    poder = new Timer(10000, podertimer);
                    poder.start();                    
                    tempObject.fuera=true;             
                }
                }

            }
        }
    }
    /**
     *actualiza el movimiento de la nave
     */
    ActionListener animacionActualizar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            index++;
            if (index == frames.length)
                index = 0;
            
            if(golpeado)
            {
            	visible=!visible;
            }

        }
    };
    /**
     *cambia el estado de la nave para que por unos segundos no le hagandaño los golpes
     *y el contacto con otro obejto solo le quite una vida
     */
    ActionListener golpeadoTimer = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            golpeado=false;
            golpeadoT.stop();
            visible=true;
        }
    };
    /**
     *cambia el estado del poder para que vuelva a recibir daño
     */
    ActionListener podertimer = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
        
            invencible = false;
            poder.stop();
        }
    };

  



    /**
     *
     * @param g grafica usada
     */
    @Override
    public void render(Graphics g) {
    		
    	 if(visible) {
            if(velY==0) {
                
               
                	g.drawImage(jugador[index], x, y, null);
                
            }else if(velY<0) {
                g.drawImage(jugadorArriba[index], x, y, null);
            }else if(velY>0) {
                g.drawImage(jugadorAbajo[index], x, y, null);
            }
            if(invencible) {
                g.setColor(new Color(129, 241, 116, 50));
                g.fillOval(x - 10, y - 10, jugador[0].getWidth() + 10, jugador[0].getWidth() + 10);
            }
    	 }
          

    }
}
