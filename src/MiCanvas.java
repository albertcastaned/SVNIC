import javax.swing.*;
import java.awt.*;

/**
 * Clase que crea la ventana con sus propiedas y tamaño
 * @author Marla/Alberto
 * @version 1.0
 */
public class MiCanvas extends Canvas {
	private JFrame frame;
    /**
     *
     * @param width ancho de ventana
     * @param height altura de ventana
     * @param title titulo de ventana
     * @param game clase game a llamar
     */
    public MiCanvas(int width, int height, String title,Game game)
    {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        frame.setFocusable(false);
        game.start();
        
    }


}
