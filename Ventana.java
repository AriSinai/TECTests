import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame{

	private JLabel labelPersonaje, tituloEscoge, vacio1,vacio2,vacio3,vacio4,vacio5, labelHistoria,labelPregunta,labelEst,labelMaestro,labelRespuesta,labelVacio,labelStats,labelVida,labelRecompensa;
	private JButton botonFer, botonMercy, botonAri, flechaArriba,flechaAbajo,flechaDerecha,flechaIzquierda, botonSiguiente,bRespuesta1,bRespuesta2,bRespuesta3,bSubmit;
	private JPanel panelPersonajes, panelPrincipal, panelHistoria, panelFlechas, panelMapa, panelOtro, panel3, panelIntroduccion,panelQuiz,panelImagen,panelPreguntas,panelStats,panelSubmit; 
	private ImageIcon Fer,Ari,Mercy, Escoge, Personajes,fer,ari,mercy;
	private int width, length, personaje;
	private Campus mapa;
	private Estudiante estudiante;
	private Profesor profesor;
	private JTextField tRespuesta;
	//
	private JScrollPane scrrollPane;
	private String stringStory;
	//


	public Ventana(){
		super("Test Fest in TEC");
		mapa= new Campus(10,10);
		estudiante= new Estudiante(100,200,100);
		llenarCasillas();
		width=700;
		length=500;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,length);
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
		labelHistoria= new JLabel();
		scrollPane.add(labelHistoria);
		scrollPane= new JScrollPane();
		panelHistoria.add(scrollPane);
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
	public void Pelea(){

	public JPanel panelContenedorPelea, panelItems,panelPelea,panelPeleaImagenes,panelStatsPelea;
	public JLabel labelAri,labelFer,labelMercy,labelMochila,labelItems,labelStats,labelPorfirioGuiaz,labelCaptainLoop,labelHannibalLecturas,labelDarthCalculater,labelStatsStudents;
	public ImageIcon Ari,Fer,Mercy,StudentStats, TeacherStats, atacar;
	public JButton botonItem1,botonItem2,botonItem3,botonPelea;

	panelContenedorPelea= new JPanel();
	panelContenedorPelea.setLayout(new GridLayout(2,2));




	//1
	panelPeleaImagenes = new JPanel();
	panelPeleaImagenes.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
	Ari=new ImageIcon( "Ari.jpeg");
	Fer=new ImageIcon( "Fer.jpeg");
	Mercy=new ImageIcon( "Mercy.jpeg");
	PorfirioGuiaz= new ImageIcon("Pg.jpeg");
	CaptainLoop= new ImageIcon("Cl.jpeg");
	HannibalLecturas= new ImageIcon("Hl.jpeg");
	DarthCalculater= new ImageIcon("Dc.jpeg");
	labelAri= new JLabel(Ari);
	labelFer= new JLabel(Fer);
	labelMercy= new JLabel(Mercy);
	labelPorfirioGuiaz= new JLabel(Pg);
	labelCaptainLoop= new JLabel(Cl);
	labelHannibalLecturas= new JLabel(Hl);
	labelDarthCalculater= new JLabel(Dc);


    
    //labelAri.setBounds(new)PIOSICION Y DIENSION


    panelPeleaImagenes.add(labelAri);
    /*panelPeleaImagenes.add(labelFer);
    panelPeleaImagenes.add(labelMercy);*/
    panelPeleaImagenes.add(labelCaptainLoop);
    /*panelPeleaImagenes.add(labelPorfirioGuiaz);
    panelPeleaImagenes.add(labelDarthCalculater);
    panelPeleaImagenes.add(labelHannibalLecturas);*/
    panelContenedorPelea.add(panelPeleaImagenes);

    //RUTA DE IMAGEN STRING EN C/ UNA DE NOSOTRAS 


// 2
    panelItems= new JPanel();
    panelItems.setLayout(new BorderLayout());
    items= new ImageIcon("items.png");
    Mochila= new ImageIcon("mochila.png");
    
    botonItem1= new JButton("1");
    botonItem2= new JButton("2");
    botonItem3= new JButton("3");
    //hacer los listeners
    //botonItem1.addActionListener(new botonItem1Listener());
    //botonItem2.addActionListener(new botonItem2Listener());
    //botonItem3.addActionListener(new botonItem3Listener());
    //botonItem1.setBounds(new Rectangle(0,0,50,50));
    //botonItem2.setBounds(new Rectangle(0,0,50,50));//* revisar dimension
    //botonItem3.setBounds(new Rectangle(0,0,50,50));

    labelMochila= new JLabel(Mochila);
    labelItems= new JLabel(items);


    panelItems.add(labelMochila, BorderLayout.PAGE_START);
    panelItems.add(labelItems, BorderLayout.PAGE_END);
    panelItems.add(botonItem1, BorderLayout.LINE_START);
    panelItems.add(botonItem2, BorderLayout.CENTER);
    panelItems.add(botonItem3, BorderLayout.LINE_END);
    panelContenedorPelea.add(panelItems);

    //3
    panelPelea= new JPanel();
    panelPelea.setLayout(new BorderLayout());
    atacar= new ImageIcon("atacar.png");
    botonAtacar= new JButton(atacar);
    botonAtacar.addActionListener(new atacarActionListener());
    botonAtacar.setBounds(new Rectangle(5,5,60,60));

    panelPelea.add(botonPelea, BorderLayout.CENTER);
    panelContenedorPelea.add(panelPelea);


    //4
    panelStatsPelea= new JPanel();
    panelStatsPelea.setLayout(GridLayout(3,2));
    studentStats= new ImageIcon("StudentStats.png");
    teacherStats= new ImageIcon("TeacherStats.png");
    labelStudentStats= new JLabel(StudentStats);
    labelTeacherStats= new JLabel(TeacherStats);
    panelContenedorPelea.add(panelContenedorPelea);

}
	public void panelQuiz(){
		//Panel Quiz es el panel principal de quiz y se divide en 4
		panelQuiz = new JPanel();
		panelQuiz.setLayout(new GridLayout(2,2));
		// 1 van las imagenes de estudiante vs maestro
		panelImagen = new JPanel();
		panelImagen.setLayout(new FlowLayout());
		fer = new ImageIcon("Fer.jpeg");
		ari = new ImageIcon("Ari.jpeg");
		labelEst = new JLabel(fer);
		labelEst.setBounds(new Rectangle (0,0,0,0));
		panelImagen.add(labelEst);
		labelVacio = new JLabel("vs");
		panelImagen.add(labelVacio);
		labelMaestro = new JLabel(ari);
		labelMaestro.setBounds(new Rectangle (0,0,0,0));
		panelImagen.add(labelMaestro);
		panelQuiz.add(panelImagen);
		//2 aqui las preguntas van a ir como un label y va a haber 3 botones de respuesta
		panelPreguntas = new JPanel();
		panelPreguntas.setLayout(new GridLayout(4,1));
		labelPregunta = new JLabel("Pregunta ...");
		panelPreguntas.add(labelPregunta);
		bRespuesta1 = new JButton("Respuesta1");
		panelPreguntas.add(bRespuesta1);
		bRespuesta2 = new JButton("Respuesta2");
		panelPreguntas.add(bRespuesta2);
		bRespuesta3 = new JButton("Respuesta3");
		panelPreguntas.add(bRespuesta3);
		panelQuiz.add(panelPreguntas);
		//3 En este panel vas a meter en el JText a,b o c y vas a picar el boton submit
		panelSubmit = new JPanel();
		panelSubmit.setLayout(new GridLayout(3,1));
		labelRespuesta = new JLabel("Pon la respuesta");
		panelSubmit.add(labelRespuesta);
		tRespuesta = new JTextField();
		panelSubmit.add(tRespuesta);
		bSubmit = new JButton("Submit");
		panelSubmit.add(bSubmit);
		panelQuiz.add(panelSubmit);
		//4 van a aparecer los stats de el personaje en el panel
		panelStats = new JPanel();
		panelStats.setLayout(new GridLayout(3,1));
		labelStats = new JLabel("Stats");
		panelStats.add(labelStats, SwingConstants.CENTER);
		labelVida = new JLabel("Vida");
		panelStats.add(labelVida);
		labelRecompensa = new JLabel("Recompensa");
		panelStats.add(labelRecompensa);
		panelQuiz.add(panelStats);
		add(panelQuiz);
		
	
	}
	
	

}
