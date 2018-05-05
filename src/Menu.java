
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Menu  extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton inicio,cj;
	private JPanel panel;
	private Icon logo;
	private static JLabel icon;

	
	public Menu()
	{
		super();
		setLayout(new BorderLayout());
		panel = new JPanel(new FlowLayout(1,0,90));
		logo = new ImageIcon(getClass().getResource("/imagenes/LOGO.gif"));
		icon = new JLabel(logo);
		icon.setBackground(new Color(0,0,0));
		icon.setOpaque(true);
		setInicio(new JButton("START"));
		cj = new JButton("COMO JUGAR");
		cj.setForeground(new Color(240, 113, 21));
		cj.addActionListener(this);
		cj.setPreferredSize(new Dimension(100, 100));
		inicio.setForeground(new Color(255,0,0));
		inicio.addActionListener(this);
		inicio.setPreferredSize(new Dimension(100, 100));
		panel.setBackground(new Color(0,0,0));
		panel.add(inicio);
		panel.add(cj);
		panel.paint(getGraphics());
		add(icon, BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
   }
	
	
	
	static Menu m;
	private Game g;
	private ComoJugar c;
	public static void main(String args[])
    {
        m = new Menu();
        m.setSize(1200, 675);
        m.setVisible(true);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public JButton getInicio() {
		return inicio;
	}

	public void setInicio(JButton inicio) {
		this.inicio = inicio;
	}

	
	@Override
	/**
	 Cuando le das click a un boton y crea la ventana del juego si le das start y en como jugar 
	 despliega instrucciones 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inicio)
		{
			m.setVisible(false);
			dispose();
			Game g = new Game();
		}
		if(e.getSource() == cj)
		{
			setC(new ComoJugar());
		}
		
	}
	public Game getG() {
		return g;
	}
	public void setG(Game g) {
		this.g = g;
	}
	public ComoJugar getC() {
		return c;
	}
	public void setC(ComoJugar c) {
		this.c = c;
	}
	
	

}