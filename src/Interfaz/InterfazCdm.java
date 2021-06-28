package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import Controlador.Controlador;

public class InterfazCdm 
{

	protected JFrame frame;
	protected Controlador controlador;
	private JLabel imagen;
	private HashSet<Integer> numerosOp1;
	private HashSet<Integer> numerosOp2;
	private HashSet<Integer> numerosOp3;
	private HashSet<Integer> numerosOp4;
	private JLabel EGrafo1;
	private JLabel EResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					InterfazCdm window = new InterfazCdm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazCdm() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		controlador=Interfaz.controlador;
		crearFrame();
		
		creaECdm();
		creaEGrafo();
		creaImagen1();
		creaImagen2();
		creaImagen3();
		creaImagen4();
		creaEResultado();
		
		creaBoton();
	}

	private void creaBoton()
	{
		//Boton volver
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				lanzarInterfazAnterior();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(650, 22, 106, 37);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void lanzarInterfazAnterior() 
	{
		try
		{
			Interfaz window = new Interfaz();
			window.frame.setVisible(true);
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void creaImagen1() 
	{
		agregarNumerosOp1();
		if(numerosOp1.equals(controlador.getConjuntoDominanteMinimo()))
		{
			imagen = new JLabel("");
			imagen.setBounds(140, 38, 727, 397);
			imagen.setIcon(new ImageIcon("grafo1.PNG"));
			frame.getContentPane().add(imagen);
		}

	}

	private void agregarNumerosOp1() 
	{
		numerosOp1= new HashSet<Integer>();
		numerosOp1.add(2);
		numerosOp1.add(4);
	}
	
	private void creaImagen2() 
	{
		agregarNumerosOp2();
		if(numerosOp2.equals(controlador.getConjuntoDominanteMinimo()))
		{
			imagen = new JLabel("");
			imagen.setBounds(140, 38, 727, 397);
			imagen.setIcon(new ImageIcon("grafo2.PNG"));
			frame.getContentPane().add(imagen);
		}
	}

	private void agregarNumerosOp2() 
	{
		numerosOp2= new HashSet<Integer>();
		numerosOp2.add(2);
		numerosOp2.add(4);
		numerosOp2.add(6);
	}


	private void creaImagen3() 
	{
		agregarNumerosOp3();
		if(numerosOp3.equals(controlador.getConjuntoDominanteMinimo()))
		{
			imagen = new JLabel("");
			imagen.setBounds(170, 38, 727, 397);
			imagen.setIcon(new ImageIcon("grafo3.PNG"));
			frame.getContentPane().add(imagen);
		}
	}

	private void agregarNumerosOp3() 
	{
		numerosOp3= new HashSet<Integer>();
		numerosOp3.add(1);
	}

	private void creaImagen4() 
	{
		agregarNumerosOp4();
		if(numerosOp4.equals(controlador.getConjuntoDominanteMinimo()))
		{
			imagen = new JLabel("");
			imagen.setBounds(150, 38, 727, 397);
			imagen.setIcon(new ImageIcon("grafo4.PNG"));
			frame.getContentPane().add(imagen);
		}
	}

	private void agregarNumerosOp4() 
	{
		numerosOp4= new HashSet<Integer>();
		numerosOp4.add(1);
		numerosOp4.add(3);
		numerosOp4.add(5);
	}
	
	private void creaEResultado() {
		EResultado = new JLabel(" ");
		EResultado.setForeground(new Color(0, 0, 0));
		EResultado.setFont(new Font("Tahoma", Font.BOLD, 35));
		EResultado.setBounds(113, 562, 360, 65);
		EResultado.setText(controlador.getConjuntoDominanteMinimo().toString());
		frame.getContentPane().add(EResultado);
	}

	private void crearFrame() 
	{
		frame = new JFrame();
		frame.setIconImage(new javax.swing.ImageIcon("testigos.png").getImage());
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(200, 70, 800, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Testigos de Java");	
	}	
	
	private void creaECdm() 
	{
		JLabel cdm = new JLabel("Conjunto Dominante Minimo: ");
		cdm.setForeground(new Color(0, 0, 0));
		cdm.setFont(new Font("Tahoma", Font.BOLD, 50));
		cdm.setBounds(23, 482, 831, 101);
		frame.getContentPane().add(cdm);
	}
	
	private void creaEGrafo()
	{
		EGrafo1 = new JLabel("Grafo: ");
		EGrafo1.setFont(new Font("Tahoma", Font.BOLD, 35));
		EGrafo1.setBounds(27, 22, 132, 39);
		frame.getContentPane().add(EGrafo1);
	}
}
