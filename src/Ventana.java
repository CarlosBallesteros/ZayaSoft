import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
public class Ventana {

	private JFrame frmCalculadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setResizable(false);
		frmCalculadora.setBounds(100, 100, 401, 301);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
