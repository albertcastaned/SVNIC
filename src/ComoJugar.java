

import java.awt.BorderLayout;
		import javax.swing.Icon;
		import javax.swing.ImageIcon;
		import javax.swing.JFrame;
		import javax.swing.JLabel;


public class ComoJugar extends JFrame
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Icon intstrucciones;
	private JLabel show;

	ComoJugar()
	{
		setLayout(new BorderLayout());
		setSize(710, 615);
		setVisible(true);
		setLocationRelativeTo(null);
		intstrucciones = new ImageIcon(getClass().getResource("/imagenes/INTRUCCIONES.png"));
		show = new JLabel(intstrucciones);
		add(show, BorderLayout.CENTER);

	}


} 