import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame{

	private JLabel labelPersonaje, tituloEscoge, vacio1,vacio2,vacio3,vacio4,vacio5;
	private JButton botonFer, botonMercy, botonAri, flechaArriba,flechaAbajo,flechaDerecha,flechaIzquierda, botonSiguiente;
	private JPanel panelPersonajes, panelPrincipal, panelHistoria, panelFlechas, panelMapa, panelOtro, panel3, panelIntroduccion; 
	private ImageIcon Fer,Ari,Mercy, Escoge, Personajes;
	private int width, lenght, personaje;
	private Campus mapa;
	private Estudiante estudiante;
	private Profesor profesor;


	public Ventana(){
		super("Test Fest in TEC");
		mapa= new Campus(10,10);
		estudiante= new Estudiante(100,200,100);
		llenarCasillas();
		width=700;
		lenght=500;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,lenght);
		initComponents();
		
		setVisible(true);
	}

	public void initComponents(){
			panelIntroduccion= new JPanel();
			panelIntroduccion.setLayout(new GridLayout(1,2));
			panelIntroduccion.add (new JLabel ("Bienvenido"));
			botonSiguiente=new JButton ("Siguiente");
			botonSiguiente.addActionListener(new BotonSiguienteListener());
			panelIntroduccion.add(botonSiguiente);
			add(panelIntroduccion);
		}

	public void elegirPersonaje(){
		// botones para elegir personajes de personajes
		// Se defienen los botones para cada personaje
		panelPersonajes = new JPanel();
		panelPersonajes.setLayout( new BorderLayout());
		//panelPersonajes.setLayout( new GridBagLayout());
		//GridBagConstraints c = new GridBagConstraints();
			

		Ari=new ImageIcon( "Ari.jpeg");
		Fer=new ImageIcon( "Fer.jpeg");
		Mercy=new ImageIcon( "Mercy.jpeg");
		Escoge=new ImageIcon("EscogePersonaje.png");
		Personajes=new ImageIcon("Personajes.png");

		botonFer=new JButton (Fer);
		botonAri= new JButton(Ari);
		botonMercy = new JButton(Mercy);
		botonFer.addActionListener(new BotonSiguienteFERListener());
		botonAri.addActionListener(new BotonSiguienteARIListener());
		botonMercy.addActionListener(new BotonSiguienteMERCYListener());
		botonAri.setBounds(new Rectangle (0,0,300,300));
		botonFer.setBounds(new Rectangle (0,0,300,300));
		botonMercy.setBounds(new Rectangle (0,0,300,300));

		tituloEscoge=new JLabel(Escoge);
		labelPersonaje=new JLabel(Personajes);


		panelPersonajes.add(labelPersonaje, BorderLayout.PAGE_END);
		panelPersonajes.add(tituloEscoge, BorderLayout.PAGE_START);

		panelPersonajes.add(botonAri, BorderLayout.LINE_START);
		panelPersonajes.add(botonFer, BorderLayout.CENTER);
		panelPersonajes.add(botonMercy, BorderLayout.LINE_END);
		add(panelPersonajes);
	}
	public void mapaPrincipal(){
		panelPrincipal=new JPanel();
		panelPrincipal.setLayout(new GridLayout(2,2));
		

		//1
		panelMapa= new JPanel();
		add(panelMapa);
		pintarMapa();
		

		//2
		panelHistoria= new JPanel();
		panelHistoria.setLayout(new FlowLayout());
		panelPrincipal.add(panelHistoria);


		// 3
		panelFlechas= new JPanel();
		panelFlechas.setLayout(new GridLayout(3,3));
		
		vacio1 = new JLabel("  ");
		vacio2 = new JLabel("  ");
		vacio3 = new JLabel("  ");
		vacio4 = new JLabel("  ");
		vacio5 = new JLabel("  ");
		flechaIzquierda = new JButton("Izquierda");
		flechaDerecha= new JButton("Derecha");
		flechaArriba= new JButton("Arriba");
		flechaAbajo= new JButton("Abajo");
		panelFlechas.add(vacio1);
		panelFlechas.add(flechaArriba);
		panelFlechas.add(vacio2);
		panelFlechas.add(flechaIzquierda);
		panelFlechas.add(vacio3);
		panelFlechas.add(flechaDerecha);
		panelFlechas.add(vacio4);
		panelFlechas.add(flechaAbajo);
		panelFlechas.add(vacio5);
		panelPrincipal.add(panelFlechas);

		//4

		/*
		panel2= new JPanel();
		labelHistoria=new JLabel();
		scrollPane.add(labelHistoria);
		scrollPane=new JScrollPane();
		panel2.add(scrollPane);
		panel2.setLayout(new FlowLayout());
		label3= new JLabel("Hello World 3!!!");
		label4= new JLabel("Hello World 4!!!");
		boton2= new JButton("Push me harder");
		panel2.add(label3);
		panel2.add(label4);
		panel2.add(boton2);
		panelPrincipal.add(panel2);



		panelContenedor= new JPanel();
		add(panelContenedor);
		pintarMapa();
		panel4= new JPanel();
		labelVida=new JLabel();
		labelAtaque=new JLabel();
		labelNombre=new JLabel();
		labelVida.setText("Vida: "+heroe.vida);
		labelAtaque.setText("ataque: "+heroe.ataque);
		labelNombre.setText("nombre: "+heroe.nombre);
		panel4.add(labelNombre);
		panel4.add(labelVida);
		panel4.add(labelAtaque);
		panelPrincipal.add(panel4);	
		add(panelPrincipal)	;
		*/
		add(panelPrincipal);
	}

	public void pintarMapa(){
		
		panel3= new JPanel();
		panel3.setLayout(new GridLayout(mapa.casillas.length,mapa.casillas[0].length));
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				if(mapa.casillas[i][j].estudiante==null){
					panel3.add(new JLabel("Vacio"));
				}else{
					panel3.add(new JLabel("Heroe"));
				}
			}
		}
		
		panelPrincipal.add(panel3);
		panelPrincipal.revalidate();
		panelPrincipal.repaint();		
	}

	public void llenarCasillas(){
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				mapa.casillas[i][j]= new Casilla();
				if(Math.random()>=0.5){
					Double ataqueDouble = Math.random()*99+1;
					Double vidaDouble=(Math.random()*99+1);
					//mapa.casillas [i][j]=new Profesor(100,100);

				}
			}
		}
		mapa.casillas[0][0].estudiante=estudiante;
	}

	public class BotonSiguienteFERListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();
			personaje= 1;

		}
	}
			
	public class BotonSiguienteARIListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();
			personaje= 2;
				
		}
	}
	public class BotonSiguienteMERCYListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();
			personaje= 3;
				
		}
			

	}
	
	public class BotonSiguienteListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				remove (panelIntroduccion);
				elegirPersonaje();
				revalidate();
				repaint();
			}
		}	

}