package Interfaz;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Controlador.Controlador;
import Logica.Arista;
import Logica.Vertice;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


import java.awt.Font;

public class Interfaz {

	protected JFrame frame;
	private JTextField textField_Origen;
	private JTextField textField_Destino;
	private JTable table;
	private Integer[][] tablaAristas;
	private String[] encabezadoAristas;
	private JTable table_1;
	private Integer[][] tablaVertices;
	private String[] encabezadoVertices;
	protected static Controlador controlador;
	private JLabel loop;
	private JScrollPane scroll ,scroll2;
	private JTextField textField_Origen_eliminar;
	private JTextField textField_Destino_eliminar;
	private JTextField CVertice;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					Interfaz window = new Interfaz();
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
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controlador=new Controlador();
		crearFrame();

//-----	ETIQUETAS -------------			
		creaEVertices(); 
		creaEAristas();
		creaEOrigen();
		creaEDestino();
		creaEAristas2();
		creaEVertices2();
		creaEOpciones(); 
		creaEGrafo();
		creaEDestino2();
		creaEOrigen2();
		creaELoop();
		creaEVertice();
		
//----- CAJAS DE TEXTO-------------		
		creaCOrigen();
		creaCDestino();
		creaCOrigenEliminar();
		creaCDestinoEliminar();
		crearCVertice();

//----- BOTONES   -------------	
		crearBotonAgregarArista();
		crearBotonEliminarArista();
		crearBotonGrafoOp1();
		crearBotonGrafoOp2(); 
		crearBotonGrafoOp4();
		crearBotonGrafoOp3();
		crearBotonCdm();
		creaBotonAgregarVertice();
	}

//----- METODOS DE BOTONES ---------------
	private void crearBotonCdm() 
	{
		JButton btnNewButton_1 = new JButton("Conjunto dominante minimo");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				controlador.buscarCdm();
				lanzarNuevaInterfaz();
			}
		});
		btnNewButton_1.setBounds(872, 399, 220, 65);
		frame.getContentPane().add(btnNewButton_1);
		

	}

	private void creaBotonAgregarVertice() {
		JButton btnNewButton_3 = new JButton("Agregar Vertice");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				controlador.agregarVertice(Integer.parseInt(CVertice.getText()));
				controlador.crearGrafo();
				actualizarTablaVertices();
			}
		});
		btnNewButton_3.setBounds(969, 210, 123, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
	
	private void crearBotonGrafoOp1() 
	{
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setIcon(new javax.swing.ImageIcon("icono1.PNG"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				crearGrafo("aristasEj1.JSON");
			}
		});
		btnNewButton_4.setBounds(502, 81, 113, 55);
		frame.getContentPane().add(btnNewButton_4);
	}
	
	private void crearBotonGrafoOp2() 
	{
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new javax.swing.ImageIcon("icono2.png"));
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				crearGrafo("aristasEj2.JSON");
			}
		});
		btnNewButton_6.setBounds(656, 80, 113, 55);
		frame.getContentPane().add(btnNewButton_6);
	}
	
	private void crearBotonGrafoOp3()  
	{
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new javax.swing.ImageIcon("icono3.png"));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				crearGrafo("aristasEj3.JSON");
			}
		});
		btnNewButton_5.setBounds(814, 71, 92, 65);
		frame.getContentPane().add(btnNewButton_5);
	}

	private void crearBotonGrafoOp4()  
	{
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setIcon(new javax.swing.ImageIcon("icono4.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				crearGrafo("aristasEj4.JSON");
			} 
		});
		btnNewButton_7.setBounds(942, 81, 105, 55);
		frame.getContentPane().add(btnNewButton_7);
	}
	

	private void crearGrafo(String archivo) 
	{
		controlador.crearListaDeNumeros();
		controlador.crearGrafo();
		controlador.agregaAristas(archivo);
		actualizarTablaDeAristas();
		actualizarTablaVertices();
	}
	
	private void crearBotonEliminarArista() 
	{
		JButton btnNewButton_2 = new JButton("Eliminar Arista");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String origen=textField_Origen_eliminar.getText();
				String destino=textField_Destino_eliminar.getText();
				Vertice vOrigen=controlador.buscarVertice(Integer.parseInt(origen));
				Vertice vDestino=controlador.buscarVertice(Integer.parseInt(destino));
				Arista arista=new Arista(vOrigen ,vDestino);
				controlador.eliminar(arista);
				actualizarTablaDeAristas();
			}
		});
		btnNewButton_2.setBounds(698, 244, 136, 25);
		frame.getContentPane().add(btnNewButton_2);
	}

	private void crearBotonAgregarArista() 
	{
		JButton btnNewButton = new JButton("Agregar Arista");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String origen=textField_Origen.getText();
				String destino=textField_Destino.getText();
				Vertice vOrigen=controlador.buscarVertice(Integer.parseInt(origen));
				Vertice vDestino=controlador.buscarVertice(Integer.parseInt(destino));

				if(controlador.hayLoops(vOrigen, vDestino)) 
				{
					loop.setVisible(true);
					textField_Origen.setText(null);
					textField_Destino.setText(null);
				}
				else 
				{
					loop.setVisible(false);
					Arista arista =new Arista(vOrigen, vDestino);
					controlador.agregarArista(arista);
					actualizarTablaDeAristas();
				}
			}
		});
		btnNewButton.setBounds(698, 172, 136, 23);
		frame.getContentPane().add(btnNewButton);
	}

	
//-------- LANZA INTERFAZ CDM ----------
	
	private void lanzarNuevaInterfaz() 
	{
		try{
			InterfazCdm window = new InterfazCdm();
			window.frame.setVisible(true);
			frame.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//-------- ACTUALIZA TABLA DE VERTICES -----------

	private void actualizarTablaVertices() 
	{
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(1, 2,3)));
		table_1.setBackground(Color.LIGHT_GRAY);
		tablaVertices=controlador.llenarTablaVertices();
		encabezadoVertices=controlador.llenarEncabezadoVertices();
		scroll=new JScrollPane();
		scroll.setBounds(400, 350, 350, 280);
		frame.getContentPane().add(scroll);
		table_1.setVisible(true);	
		frame.getContentPane().add(scroll);
		scroll.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(tablaVertices,encabezadoVertices));
	}
	
//-------- ACTUALIZA TABLA DE ARISTAS -------------	
	
	private void actualizarTablaDeAristas() 
	{
		table = new JTable();
		table.setBorder(new LineBorder(new Color(1, 2,3)));
		table.setBackground(Color.LIGHT_GRAY);
		tablaAristas= controlador.llenarTablaDeAristas();
		encabezadoAristas=new String[] {"Origen", "Destino"};
		
		scroll2=new JScrollPane();
		scroll2.setBounds(50, 350, 300, 280);
		frame.getContentPane().add(scroll2);
		scroll2.setViewportView(table);
		table.setVisible(true);
		table.setModel(new DefaultTableModel(tablaAristas,encabezadoAristas));
	}

//----- CREA FRAME ---------------
	private void crearFrame() 
	{
		frame = new JFrame();
		frame.setBackground(new Color(173, 216, 230));
		frame.setIconImage(new javax.swing.ImageIcon("testigos.png").getImage());
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(200, 70, 1152, 677);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Testigos de Java");
	}

//----- METODOS DE ETIQUETAS ---------------
	private void creaELoop() 
	{
		loop = new JLabel("Hay un loop  (arista con origen = destino no esta permitido en grafo)");
		loop.setForeground(Color.RED);
		loop.setFont(new Font("Tahoma", Font.BOLD, 20));
		loop.setBounds(224, 198, 706, 38);
		frame.getContentPane().add(loop);
		loop.setVisible(false);
	}

	private void creaEOrigen2() 
	{
		JLabel EOrigen2 = new JLabel("Origen:");
		EOrigen2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EOrigen2.setBounds(262, 241, 80, 22);
		frame.getContentPane().add(EOrigen2);
	}

	private void creaEDestino2() 
	{
		JLabel EDestino2 = new JLabel("Destino:");
		EDestino2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EDestino2.setBounds(480, 242, 97, 21);
		frame.getContentPane().add(EDestino2);
	}

	private void creaEGrafo() 
	{
		JLabel EGrafos = new JLabel("Grafos");
		EGrafos.setForeground(new Color(30, 144, 255));
		EGrafos.setFont(new Font("Times New Roman", Font.BOLD, 70));
		EGrafos.setHorizontalAlignment(SwingConstants.CENTER);
		EGrafos.setHorizontalTextPosition(SwingConstants.CENTER);
		EGrafos.setBounds(10, 0, 248, 118);
		frame.getContentPane().add(EGrafos);
	}

	private void creaEOpciones() 
	{
		JLabel EOpciones = new JLabel("Opciones:");
		EOpciones.setFont(new Font("Tahoma", Font.PLAIN, 24));
		EOpciones.setBounds(531, 18, 191, 55);
		frame.getContentPane().add(EOpciones);
	}

	private void creaEVertices2() 
	{
		JLabel EVertices2 = new JLabel("Vertices:");
		EVertices2.setFont(new Font("Tahoma", Font.BOLD, 20));
		EVertices2.setBounds(407, 319, 91, 23);
		frame.getContentPane().add(EVertices2);
	}

	private void creaEAristas2() 
	{
		JLabel EAristas2  = new JLabel("Aristas:");
		EAristas2.setFont(new Font("Tahoma", Font.BOLD, 20));
		EAristas2.setBounds(130, 319, 86, 23);
		frame.getContentPane().add(EAristas2);
	}

	private void creaEDestino() 
	{
		JLabel EDestino = new JLabel("Destino");
		EDestino.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EDestino.setBounds(480, 170, 97, 19);
		frame.getContentPane().add(EDestino);
	}

	private void creaEOrigen() 
	{
		JLabel EOrigen = new JLabel("Origen:");
		EOrigen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		EOrigen.setBounds(262, 168, 92, 23);
		frame.getContentPane().add(EOrigen);
	}

	private void creaEAristas() 
	{
		JLabel EAristas = new JLabel("Agregar o Eiminar \r\n:");
		EAristas.setFont(new Font("Tahoma", Font.PLAIN, 23));
		EAristas.setBounds(25, 160, 215, 113);
		frame.getContentPane().add(EAristas);
	}

	private void creaEVertices() 
	{
		JLabel EGrafos2 = new JLabel("Grafos: ");
		EGrafos2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		EGrafos2.setBounds(379, 85, 105, 33);
		frame.getContentPane().add(EGrafos2);
	}

	private void creaEVertice() 
	{
		JLabel EVertice = new JLabel("Vertice:");
		EVertice.setFont(new Font("Tahoma", Font.PLAIN, 21));
		EVertice.setBounds(932, 172, 84, 23);
		frame.getContentPane().add(EVertice);
	}
	


	
//----- METODOS DE CAJAS DE TEXTO ---------------
	private void creaCDestinoEliminar() 
	{
		textField_Destino_eliminar = new JTextField();
		textField_Destino_eliminar.setBounds(564, 246, 86, 19);
		frame.getContentPane().add(textField_Destino_eliminar);
		textField_Destino_eliminar.setColumns(10);
	}

	private void creaCOrigenEliminar() 
	{
		textField_Origen_eliminar = new JTextField();
		textField_Origen_eliminar.setText("");
		textField_Origen_eliminar.setBounds(344, 246, 86, 19);
		frame.getContentPane().add(textField_Origen_eliminar);
		textField_Origen_eliminar.setColumns(10);
	}
	
	private void crearCVertice() 
	{
		CVertice = new JTextField();
		CVertice.setBounds(1006, 173, 86, 20);
		frame.getContentPane().add(CVertice);
		CVertice.setColumns(10);
	}
	
	private void creaCDestino()  
	{
		textField_Destino = new JTextField();
		textField_Destino.setBounds(564, 173, 86, 20);
		frame.getContentPane().add(textField_Destino);
		textField_Destino.setColumns(10);
	}

	private void creaCOrigen() 
	{
		textField_Origen = new JTextField();
		textField_Origen.setBounds(344, 173, 86, 20);
		frame.getContentPane().add(textField_Origen);
		textField_Origen.setColumns(10);
	}
	

}
