import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
public class Ventana extends JFrame{
	JPanel panel_principal;
	JPanel panel_secundario;
	JTextField panel_numerico;
	
	//Metodo main (opcional?)
	public static void main(String[] args) {
		new Ventana();
	}
	
	//Iniciar la ventana
	private void init() {
		panel_principal=new JPanel();
		panel_secundario=new JPanel();
		panel_numerico=new JTextField();
		panel_principal.setLayout(new BorderLayout());
		panel_principal.add("North",panel_numerico);
		panel_secundario.setLayout(new GridLayout(5,4,8,8));
		panel_principal.add("Center",panel_secundario);
		getContentPane().add(panel_principal);
	}
	
	//Crear la ventana
	public Ventana() {
		setTitle("Calculadora");
		setSize(400,300);
		setResizable(false);
		setBounds(200, 200, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	
}
