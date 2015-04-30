import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
/**
 * Calculadora con interfaz grafica
 * 
 * @author Carlos Ballesteros
 * 
 *@version 3.* 30-Abril-2015
 */
public class Ventana extends JFrame{
	//Parametros de los paneles
	private JPanel panel_principal;
	private JPanel panel_secundario;
	private JTextField caja;
	//Parametros de los botones
	private JButton[] boton;
	private double op1=0,op2=0,memoria=0;
	private String operacion="";
	private boolean nueva=true;
	/**
	 * @param panel_principal Parametro JPanel que define el panel que va a ocupar toda la ventana.
	 * @param panel_secundario Parametro JPanel que define el panel de los botones.
	 * @param caja Parametro JTextField que define el panel donde se visualizan los resultados.
	 * @param boton Parametro conjunto array de botones.
	 * @param op1 Parametro double que guarda valores a operar.
	 * @param op2 Parametro double que guarda valores a operar.
	 * @param memoria Parametro double que guarda valores en memoria.
	 * @param operacion Parametro String que guarda el nombre de la operacion a realizar.
	 * @param nueva Parametro boolean que determina si empezamos una nueva operacion o continuamos otra.
	 */
	
	//Metodo main (opcional: se puede añadir a la clase Main)
	public static void main(String[] args) {
		/**
		 * Metodo main que inicia la calculadora.
		 */
		new Ventana();
	}
	
	//Iniciar la ventana
	private void init() {
		/**
		 * Metodo init que inicia la estructura de la ventana calculadora
		 * Usa el metodo añadirBotones.
		 */
		panel_principal=new JPanel();		//Iniciamos
		panel_secundario=new JPanel();		//los
		caja=new JTextField();				//paneles
		caja.setHorizontalAlignment(JTextField.TRAILING);//alinear el texto a la derecha (TRAILING=RIGHT ?)
		panel_principal.setLayout(new BorderLayout());//le damos layout al panel principal
		panel_principal.add("North",caja);//añadimos la caja de texto al panel principal
		panel_secundario.setLayout(new GridLayout(5,4,5,5));//le damos layout al panel secundario
		añadirBotones();//añadimos los botones
		panel_principal.add("Center",panel_secundario);//añadimos el panel secundario al panel principal
		getContentPane().add(panel_principal);//añadimos el panel principal a la ventana
	}
	
	//Crear los botones
	private void añadirBotones() {
		/**
		 * Metodo añadirBotones que crea los botones y define sus funciones.
		 */
		//CREAMOS EL ARRAY BOTON DE 20 BOTONES
		boton = new JButton[20];
        //INICIALIZAMOS LOS BOTONES
        boton[0]=new JButton("CE");
        boton[1]=new JButton("MR");
        boton[2]=new JButton("M+");
        boton[3]=new JButton("M-");
        boton[4]=new JButton("7");
        boton[5]=new JButton("8");
        boton[6]=new JButton("9");
        boton[7]=new JButton("/");
        boton[8]=new JButton("4");
        boton[9]=new JButton("5");
        boton[10]=new JButton("6");
        boton[11]=new JButton("*");
        boton[12]=new JButton("1");
        boton[13]=new JButton("2");
        boton[14]=new JButton("3");
        boton[15]=new JButton("-");
        boton[16]=new JButton("0");
        boton[17]=new JButton(".");
        boton[18]=new JButton("=");
        boton[19]=new JButton("+");
        //AGREGAMOS LOS BOTONES AL PANEL BOTONES
        for(int i=0;i<20;i++){
            panel_secundario.add(boton[i]);
        }
        caja.setText("0");//Empezar la calculadora en 0
        //DEFINIMOS LOS EVENTOS DE LOS BOTONES
        //MEMORIA
        //MR mostrar memoria
        boton[1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                caja.setText("");
                caja.setText(caja.getText()+memoria);
                nueva=true;
            }
        });
        //M+ añadir a memoria
        boton[2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
            	memoria=memoria+Double.parseDouble(caja.getText());
            }
        });
        //M- restar a memoria
        boton[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
            	memoria=memoria-Double.parseDouble(caja.getText());
            }
        });
        //OPERACIONES
        //+ sumar
        boton[19].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1+Double.parseDouble(caja.getText());
                    else
                        op1=Double.parseDouble(caja.getText());
                    operacion="suma";
                    //caja.setText(caja.getText()+"+");
                    nueva=true;
                }catch(Exception err){}
            }
        });
        //- restar
        boton[15].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1-Double.parseDouble(caja.getText());
                    else
                        op1=Double.parseDouble(caja.getText());
                    operacion="resta";
                    //caja.setText(caja.getText()+"-");
                    nueva=true;
                }catch(Exception err){}
            }
        });
        //* multiplicar
        boton[11].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1*Double.parseDouble(caja.getText());
                    else
                        op1=Double.parseDouble(caja.getText());
                    operacion="multiplicacion";
                    //caja.setText(caja.getText()+"*");
                    nueva=true;
                }catch(Exception err){}
            }
        });
        // / division
        boton[7].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    if(op1!=0)
                        op1=op1/Double.parseDouble(caja.getText());
                    else
                        op1=Double.parseDouble(caja.getText());
                    operacion="division";
                    //caja.setText(caja.getText()+"/");
                    nueva=true;
                }catch(Exception err){}
            }
        });
        //NUMEROS Y PUNTO DECIMAL
        //7
        boton[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"7");
            }
        });
        //8
        boton[5].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"8");
            }
        });
        //9
        boton[6].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"9");
            }
        });
        //4
        boton[8].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"4");
            }
        });
        //5
        boton[9].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"5");
            }
        });
        //6
        boton[10].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"6");
            }
        });
        //1
        boton[12].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"1");
            }
        });
        //2
        boton[13].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"2");
            }
        });
        //3
        boton[14].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"3");
            }
        });
        //0
        boton[16].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+"0");
            }
        });
        //. añair decimales
        boton[17].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(nueva){caja.setText("");nueva=false;}
                caja.setText(caja.getText()+".");
            }
        });
        //IGUAL
        //= obtener resultado
        boton[18].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try{
                    op2=Double.parseDouble(caja.getText());
                }catch(Exception err){}
                if(operacion.equals("suma")){
                    double res=op1+op2;
                    caja.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }else if(operacion.equals("resta")){
                    double res=op1-op2;
                    caja.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }else if(operacion.equals("multiplicacion")){
                    double res=op1*op2;
                    caja.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }else if(operacion.equals("division")){
                    double res=op1/op2;
                    caja.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }
                nueva=true;
            }
        });
        //CE reiniciar calculo
        boton[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                caja.setText("0");
                op1=op2=0;
                operacion="";
            }
        });

	}
	
	//Crear la ventana
	public Ventana() {
		/**
		 * Metodo constructor Ventana que inicia la ventana calculadora.
		 * Usa el metodo init.
		 */
		setTitle("Calculadora");//titulo
		setSize(250,250);//tamaño
		setResizable(false);//NO se puede cambiar el tamaño
		setBounds(250, 250, 250, 250);//definir limites de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//el programa termina al cerrar la ventana
		init();//iniciar
		setVisible(true);//hacerla visible
	}
	
}
