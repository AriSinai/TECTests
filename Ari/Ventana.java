import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Ventana extends JFrame{

	private JLabel labelPersonaje, tituloEscoge,labelHistoria, labelVida,labelAtaque,labelNombre,labelPregunta,labelEst,labelMaestro,labelRespuesta,labelVacio,labelStats,labelRecompensa,labelDuelo,labelHistoriaHTML,labelStudentStats,labelTeacherStats,labelMochila, labelItems;
	private JButton botonFer, botonMercy,botonAri, flechaArriba,flechaAbajo,flechaDerecha,flechaIzquierda, botonSiguiente,bSubmit,botonCargar,botonRedbull,botonCalcetin,botonMegafono,botonAtacar, botonGuardarPartida;
	private JPanel panelPersonajes, panelPrincipal, panelHistoria, panelFlechas, panelMapa, panelOtro, panel3, panelIntroduccion,panelQuiz, panelImagen,panelPreguntas,panelSubmit,panelStats,panelBotonesInicio, panelImagenDos, panelContenedorPelea, panelItems, panelPelea, panelStatsPelea; 

	private ImageIcon Fer,Ari,Mercy, Escoge, Personajes, estudianteActual, tituloPrincipalIcon, atacarIcon,logoIcon ,mochilaIcon,statsIcon,statsEstudianteIcon,statsProfesorIcon, ItemsIcon,cargarPartidoIcon,iniciarIcon,flechaDerechaIcon,flechaArribaIcon,flechaIzquierdaIcon,flechaAbajoIcon,historiaIcon, calificarIcon, dueloIcon, vsIcon;


	private int width, lenght, personaje, contador=0, respuestaSubmit;
	private Campus mapa;
	private JTextField tRespuesta;
	private Estudiante estudiante;
	private Profesor profesor;
	private JScrollPane scrollPane;
	private JTextArea areaDeHistoria;
	private String historia,p,historiaPersonaje;
	private Random random=new Random();
	private Pregunta pregunta;
	private Respuesta r1,r2,r3,respuestaCorrecta;




	public Ventana(){
		super("Test Fest in TEC");
		mapa= new Campus(10,10);
		//llenarCasillas();
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
			logoIcon= new ImageIcon("Monster.png");
			panelIntroduccion.add (new JLabel (logoIcon));



			iniciarIcon=new ImageIcon("Iniciar.png");
			cargarPartidoIcon=new ImageIcon("CargarPartida.png");
			panelBotonesInicio= new JPanel();
			panelBotonesInicio.setLayout(new GridLayout(2,1));
			botonSiguiente=new JButton (iniciarIcon);
			botonSiguiente.addActionListener(new BotonSiguienteListener());
			botonCargar= new JButton(cargarPartidoIcon);
			panelBotonesInicio.add(botonSiguiente);
			panelBotonesInicio.add(botonCargar);


			panelIntroduccion.add(panelBotonesInicio);
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

		
		setSize(1000,1800);
		panelPrincipal=new JPanel();
		panelPrincipal.setLayout(new GridLayout(2,2));
		

		//1
		panelMapa= new JPanel();
		panelPrincipal.add(panelMapa);
		pintarMapa();
		

		//2
		panelHistoria= new JPanel();
		panelHistoria.setLayout(new GridLayout(2,1));
		historiaIcon=new ImageIcon("Historia.png");
		labelHistoria= new JLabel(historiaIcon);
		labelHistoria.setBounds(120,5,260,50);
		panelHistoria.setPreferredSize(new Dimension(350,250));
		labelHistoriaHTML=new JLabel();
		panelHistoria.add(labelHistoria);
		panelHistoria.add(labelHistoriaHTML);
		imprimirHistoria();
		scrollPane= new JScrollPane();
		scrollPane.setBounds(2,2,380,150);
		scrollPane.setViewportView(panelHistoria);
		panelPrincipal.add(scrollPane);


		// 3
		panelFlechas= new JPanel();
		panelFlechas.setLayout(new GridLayout(3,3));
	
		
		flechaIzquierdaIcon = new ImageIcon("flechaIzquierda.png");
		flechaDerechaIcon = new ImageIcon("flechaDerecha.png");
		flechaArribaIcon = new ImageIcon("flechaArriba.png");
		flechaAbajoIcon = new ImageIcon("flechaAbajo.png");

		flechaIzquierda = new JButton(flechaIzquierdaIcon);
		flechaDerecha = new JButton(flechaDerechaIcon);
		botonGuardarPartida=new JButton("Guardar Partida");
		flechaAbajo = new JButton(flechaAbajoIcon);
		flechaArriba = new JButton(flechaArribaIcon);
		
		flechaIzquierda.addActionListener(new BIzquierdaListener());
		flechaDerecha.addActionListener(new BDerechaListener());
		flechaArriba.addActionListener(new BArribaListener());
		flechaAbajo.addActionListener(new BAbajoListener());


		panelFlechas.add(new JLabel());
		panelFlechas.add(flechaArriba);
		panelFlechas.add(new JLabel());
		panelFlechas.add(flechaIzquierda);
		panelFlechas.add(botonGuardarPartida);
		panelFlechas.add(flechaDerecha);
		panelFlechas.add(new JLabel());
		panelFlechas.add(flechaAbajo);
		panelFlechas.add(new JLabel());
		panelPrincipal.add(panelFlechas);

		//4

		panelOtro= new JPanel();		
		panelOtro.setLayout(new FlowLayout());
		labelVida=new JLabel();
		labelAtaque=new JLabel();
		labelNombre=new JLabel();
		labelVida.setText("Vida: "+estudiante.getVida());
		labelAtaque.setText("ataque: "+estudiante.getAtaque());
		panelOtro.add(labelVida);
		panelOtro.add(labelAtaque);
		panelPrincipal.add(panelOtro);


		add(panelPrincipal);
	}

	public void pintarMapa(){
		
		panel3=new JPanel();
		panel3.setLayout(new GridLayout(mapa.casillas.length,mapa.casillas[0].length));
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				if(mapa.casillas[i][j].getEstudiante()==null){
					panel3.add(new JLabel("[ V ]"));
				}else if(mapa.casillas[i][j].getEstudiante()==estudiante){
					panel3.add(new JLabel(estudiante.getClass().getSimpleName()));
				}else{
					panel3.add(new JLabel("[ P ]"));
				}
			}
		}
		
		panelMapa.add(panel3);
		panelMapa.revalidate();
		panelMapa.repaint();		
	}

	public void llenarCasillas(){

		int limiteInferior = 0;
		int limiteSuperior = 3;
		int limiteSuperiorAbierto = limiteSuperior + 1;
		int numeroAleatorio = limiteInferior + random.nextInt(limiteSuperiorAbierto - limiteInferior);
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				mapa.casillas[i][j]= new Casilla();
				if(Math.random()>=0.5){

					if(numeroAleatorio ==0){
						
						mapa.casillas [i][j].setProfesor(new Draculator(10,100));
						

						
					}

					
					else if(numeroAleatorio ==1){
						mapa.casillas [i][j].setProfesor(new PorfirioDiaz(10,100));
					}
					/*
						if(numeroAleatorio ==2){
						mapa.casillas [i][j].profesor=new CaptainLoop(10,100);
					}
						if(numeroAleatorio ==3){
						mapa.casillas [i][j].profesor=new HannibalLecturas(10,100);
					}
					*/

				}
				
			}
		}
		mapa.casillas[0][0].setEstudiante(estudiante);
	}

	public void imprimirHistoria(){

		String imprimeHistoria = "<html>";
		imprimeHistoria+= "Llegó la recta final de clases, la estudiante tendrá que pasar todos los exámenes para poder salir del campus ¡Cuidado! Hay profesores a lo largo del Campus que te atacarán con exámenes sorpresa," 
		+"recuerda que cinco exámenes reprobados y habrás reprobado." +
			"Recuerda que puedes recoger items que te ayudarán a lo largo de tu travesía ¡Que el juego comience!";

		if(estudiante.getClass().equals("Ari")){
			imprimeHistoria+="Ari es una chica deportista, pasa su día entrenando y haciendo ejercicio."
			+"Como item puedes encontrar una pesa voladora. Le encanta ir a competencias de todos los deportes e incluso olimpiadas matemáticas. Tendrás suerte cuando te encuentres al malvado Draculator.";
			

		}else if(estudiante.getClass().equals("Mercy")){
			imprimeHistoria+= "Mercy es una chica intelectual, que le encanta leer y aprender constantemente. Como item puedes encontrar reseñas literarias."
				+"Ha leído muchísimos libros y ni siquiera en fines de semana deja de hacerlo. Tendrás suerte cuando te encuentres al malvado Hannibal Lecturas.";


			
		}else if(estudiante.getClass().equals("Fer")){
			imprimeHistoria+= "Fer es una chica bromista, pero su verdadera pasión es la historia. Le encanta hacer memes históricos."
				 +"Como item podrás encontrar cupones de fast food. Tendrás suerte cuando te encuentres al malvado PorfirioGuiaz.";
		}
		imprimeHistoria+="</html>";
		labelHistoriaHTML.setText(imprimeHistoria);

	}

	public void iniciarQuizz(){
		//ESTO TAMBIEN ES MIENTRAS
		Draculator = new ImageIcon("Draculator.jpeg");
		PorfirioGuiaz = new ImageIcon("PorfirioGuiaz.jpeg");
		HannibalLecturas = new ImageIcon("HannibalLecturas.jpeg");
		CaptainLoop = new ImageIcon("CaptainLoop.jpeg");
		Ari=new ImageIcon( "Ari.jpeg");
		Fer=new ImageIcon( "Fer.jpeg");
		Mercy=new ImageIcon( "Mercy.jpeg");
		
		pregunta=new Pregunta();
		panelQuiz = new JPanel();
		panelQuiz.setLayout(new GridLayout(2,2));
		panelImagen = new JPanel();
		panelImagen.setLayout(new GridLayout(2,1));
		
		dueloIcon=new ImageIcon("Duelo.png");
		labelDuelo=new JLabel(dueloIcon);
		panelImagen.add(labelDuelo);
		panelImagenDos=new JPanel();
		panelImagenDos.setLayout(new GridLayout(1,3));
		//ESTO SE VA A CAMBIAR PERO MIENTRAS
		if(estudiante.getClass().getSimpleName().equals("Fer")){
			labelEst = new JLabel(Fer);
		}else if(estudiante.getClass().getSimpleName().equals("Ari")){
			labelEst = new JLabel(Ari);
		}else if(estudiante.getClass().getSimpleName().equals("Mercy")){
			labelEst = new JLabel(Mercy);
		}
		//
		
		panelImagenDos.add(labelEst);
		vsIcon=new ImageIcon("vs.png");
		labelVacio = new JLabel(vsIcon);
		panelImagenDos.add(labelVacio);
		//
		if(contador ==0){
			labelMaestro = new JLabel(Draculator);
		}else if(contador == 1){
			labelMaestro = new JLabel(PorfirioGuiaz);
		}else if(contador == 2){
			labelMaestro = new JLabel(HannibalLecturas);
		}else if(contador == 3){
			labelMaestro = new JLabel(CaptainLoop);
		}
		//
		
		panelImagenDos.add(labelMaestro);
		panelImagen.add(panelImagenDos);
		panelQuiz.add(panelImagen);



		panelPreguntas = new JPanel();
		panelPreguntas.setLayout(new GridLayout(4,1));
		labelPregunta = new JLabel("Pregunta ...");
		panelPreguntas.add(labelPregunta);
		imprimirPreguntas();
		panelQuiz.add(panelPreguntas);


		panelSubmit = new JPanel();
		panelSubmit.setLayout(new GridLayout(3,1));
		labelRespuesta = new JLabel("Pon 1,2 o 3 según la respuesta");
		calificarIcon=new ImageIcon("Calificar.png");
		panelSubmit.add(labelRespuesta);
		tRespuesta = new JTextField();
		panelSubmit.add(tRespuesta);
		bSubmit = new JButton(calificarIcon);
		bSubmit.addActionListener(new BotonSubmitListener());
		panelSubmit.add(bSubmit);
		panelQuiz.add(panelSubmit);


		panelStats = new JPanel();
		panelStats.setLayout(new GridLayout(3,1));
		statsIcon=new ImageIcon("Stats.png");
		labelStats = new JLabel(statsIcon);
		panelStats.add(labelStats, SwingConstants.CENTER);
		labelVida = new JLabel("Vida");
		panelStats.add(labelVida);
		labelRecompensa = new JLabel("Recompensa");
		imprimeStatsQuiz();
		panelStats.add(labelRecompensa);
		panelQuiz.add(panelStats);
		add(panelQuiz);

	}


	public void iniciarPelea(){
		panelContenedorPelea= new JPanel();
		panelContenedorPelea.setLayout(new GridLayout(2,2));
		
		//1 Imagenes del duelo

		panelImagen = new JPanel();
		panelImagen.setLayout(new GridLayout(2,1));
		Fer = new ImageIcon("Fer.jpeg");
		Ari = new ImageIcon("Ari.jpeg");
		dueloIcon=new ImageIcon("Duelo.png");
		labelDuelo=new JLabel(dueloIcon);
		panelImagen.add(labelDuelo);
		panelImagenDos=new JPanel();
		panelImagenDos.setLayout(new GridLayout(1,3));
		labelEst = new JLabel(Fer);
		panelImagenDos.add(labelEst);
		vsIcon=new ImageIcon("vs.png");
		labelVacio = new JLabel(vsIcon);
		panelImagenDos.add(labelVacio);
		labelMaestro = new JLabel(Ari);
		panelImagenDos.add(labelMaestro);
		panelImagen.add(panelImagenDos);
		panelContenedorPelea.add(panelImagen);

 
		// 2 
	    panelItems= new JPanel();
	    panelItems.setLayout(new BorderLayout());
	    ItemsIcon= new ImageIcon("Items.png");
	    mochilaIcon= new ImageIcon("Mochila.png");
	    
	    botonCalcetin= new JButton(" Calcetin Apestoso ");
	    botonMegafono= new JButton("Súper Megafono");
	    botonRedbull= new JButton("         Redbull         ");

	    //hacer los listeners
	    //botonItem1.addActionListener(new botonItem1Listener());
	    //botonItem2.addActionListener(new botonItem2Listener());
	    //botonItem3.addActionListener(new botonItem3Listener());
	    //botonItem1.setBounds(new Rectangle(0,0,50,50));
	    //botonItem2.setBounds(new Rectangle(0,0,50,50));//* revisar dimension
	    //botonItem3.setBounds(new Rectangle(0,0,50,50));

	    labelMochila= new JLabel(mochilaIcon);
	    labelItems= new JLabel(ItemsIcon);
	    panelItems.add(labelMochila, BorderLayout.PAGE_START);
	    panelItems.add(labelItems, BorderLayout.PAGE_END);
	    panelItems.add(botonCalcetin, BorderLayout.LINE_START);
	    panelItems.add(botonMegafono, BorderLayout.CENTER);
	    panelItems.add(botonRedbull, BorderLayout.LINE_END);
	    panelContenedorPelea.add(panelItems);

	    //3
	    panelPelea= new JPanel();
	    panelPelea.setLayout(new BorderLayout());
	    atacarIcon= new ImageIcon("Atacar.png");

	    botonAtacar= new JButton(atacarIcon);
	    botonAtacar.addActionListener(new atacarActionListener());
	    //botonAtacar.setBounds(new Rectangle(5,5,60,60));
	    panelPelea.add(botonAtacar, BorderLayout.CENTER);
	    panelContenedorPelea.add(panelPelea);

	    //4
	    panelStatsPelea= new JPanel();
	    panelStatsPelea.setLayout(new GridLayout(3,2));
	    statsEstudianteIcon= new ImageIcon("StudentStats.png");
	    statsProfesorIcon= new ImageIcon("TeacherStats.png");
	    labelStudentStats= new JLabel(statsEstudianteIcon);
	    labelTeacherStats= new JLabel(statsProfesorIcon);
	    panelStatsPelea.add(labelStudentStats);
	    panelStatsPelea.add(labelTeacherStats);
	    panelStatsPelea.add(new JLabel());
	    panelStatsPelea.add(new JLabel());
	    panelStatsPelea.add(new JLabel());
	    panelStatsPelea.add(new JLabel());
	    panelContenedorPelea.add(panelStatsPelea);

	    add(panelContenedorPelea);

	}


	public class BotonSiguienteFERListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Fer(100,200,100);
			//estudianteActual= new ImageIcon(estudiante.getRuta());
			llenarCasillas();
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();
			
			

		}
	}
			
	public class BotonSiguienteARIListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Ari(100,200,100);
			//estudianteActual= new ImageIcon(estudiante.getImagenCompleta());
			llenarCasillas();
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();				
		}
	}
	public class BotonSiguienteMERCYListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Mercy(100,200,100);
			//estudianteActual= new ImageIcon(estudiante.getRuta());
			llenarCasillas();
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();	
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

	public class atacarActionListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
        	System.out.println(profesor.getClass());
  			//estudiante.atacar(profesor); //profesor
            //profesor.atacar(estudiante);

            //imprimirStatsEstudiante();
            //imprimirStatsProfesor();
            /*
            if(estudiante.getVida()<=0){
                 //Gameover

            }
            if(profesor.getVida()<=0){
            	System.out.println("Mataste a "+ profesor.getClass().getSimpleName());
                //labelVidaProfesor.setText("Has derrotado al Profesor");
                //historiaString=historiaString+"matar <br/>"
             }
             */
		}
	}


	public class BIzquierdaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(null);
			
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			
			estudiante.setY(estudiante.getY()-1);
			
				
			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(estudiante);
			if (mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			try{
			if(mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()== null){
				
				panelMapa.remove(panel3);
				pintarMapa();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
		}
	}

	
	public class BDerechaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(null);
			}
			catch(ArrayIndexOutOfBoundsException ex){

			}

			estudiante.setY(estudiante.getY()+1);
			
			
			
			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(estudiante);

			if (mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			try{
			if(mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()== null){
				
				panelMapa.remove(panel3);
				pintarMapa();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}

		}
	}

	public class BArribaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(null);
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			estudiante.setX(estudiante.getX()-1);

			
			
			
			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(estudiante);
			if (mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			try{
			if(mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()== null){
				
				panelMapa.remove(panel3);
				pintarMapa();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}	
		}
	}

	public class BAbajoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(null);
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			estudiante.setX(estudiante.getX()+1);
			
			
			
			try{
			mapa.casillas[estudiante.getX()][estudiante.getY()].setEstudiante(estudiante);
			if (mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				profesor=mapa.casillas.getProfesor();
				//iniciarQuizz();
				revalidate();
				repaint();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}
			try{
			if(mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()== null){
				
				panelMapa.remove(panel3);
				pintarMapa();

			}
			}
			catch(ArrayIndexOutOfBoundsException ex){
			}

		}
	}


	public void imprimirPreguntas(){
		// Aqui se van a imprimir las preguntas segun el contador, para que no se repitan
		String imprime = "<html>";
		if(contador == 0){
			pregunta= new Pregunta("¿Que es un polinomio?");
			r1=new Respuesta("Una ecuacion irracional");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Es la suma-resta de un conjunto de monomios");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Una ecuacion canonica");
			pregunta.addRespuesta(r3,2);
			contador=1;
			pregunta.setRespuestaCorrecta(new Respuesta("Es la suma-resta de un conjunto de monomios"));
			
		}else if(contador ==1){
			pregunta= new Pregunta("¿Que cultura recibe el nombre de CULTURA MADRE?");
			r1=new Respuesta("Olmeca");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Azteca");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Mexica");
			pregunta.addRespuesta(r3,2);
			pregunta.setRespuestaCorrecta(new Respuesta("Olmeca"));
	
			contador=2;
		}else if(contador ==2){
			pregunta= new Pregunta("¿Quien creo al personaje de Sherlock Holmes?");
			r1=new Respuesta("Arthur Conan Doyle");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Agatha Christie");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Rudyard Kipling");
			pregunta.addRespuesta(r3,2);
			pregunta.setRespuestaCorrecta(new Respuesta("Arthur Conan Doyle"));
			
			contador=1;
		}else if(contador ==3){
			pregunta= new Pregunta("¿Cual es la palabra reservada para el uso de una interfaz en otra clase?");
			r1=new Respuesta("Abstract");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Static");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Implements");
			pregunta.addRespuesta(r3,2);
			pregunta.setRespuestaCorrecta(new Respuesta("Implements"));
			contador =1;
		}
		imprime += pregunta.getPregunta()+"<br/>";
		imprime +="1 - "+r1.getRespuesta()+"<br/>";
		imprime+="2 - "+r2.getRespuesta()+"<br/>";			
		imprime+="3 - "+r3.getRespuesta()+"<br/>";
		imprime+="</html>";
		labelPregunta.setText(imprime);
	} 

	//ESTE METODO TAMBIEN LO CAMBIE YA QUE LAS VARIABLES DE ARRIBA NO SON LAS MISMAS
	public class BotonSubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//nuevo
			try{
				respuestaSubmit = Integer.parseInt(tRespuesta.getText());
			}catch(NumberFormatException ex){
				labelRespuesta.setText("Porfavor inserta un numero valido 1, 2 o 3");
			}

			tRespuesta.setText("");

			
			pregunta.submit(pregunta.getRespuestas(),respuestaSubmit,pregunta.getRespuestaCorrecta(),estudiante);
			
			//AQUI NECESITO AYUDA PARA SABER QUE QUITAR
			/*remove(panelQuiz);
			pintarMapa();
			mapaPrincipal();
			revalidate();
			repaint();*/

		}
	}
	//ESTE TAMBIEN ES NUEVO E IMPRIME LOS STATS EN EL PANEL Y TE DICE CUANTO TE VAN A DAR 
	public void imprimeStatsQuiz(){
		String imprimeStats = "<html>";
		imprimeStats += "Vida: <br/>";
		imprimeStats += estudiante.getVida();
		labelVida.setText(imprimeStats);
		labelRecompensa.setText("La Recompensa por este Quiz es de +20 en vida");
	}

}
