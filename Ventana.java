import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Ventana extends JFrame{

	private JLabel labelPersonaje, tituloEscoge,labelHistoria, labelVida,labelAtaque,labelNombre,labelPregunta,labelEst,labelMaestro,labelRespuesta,labelVacio,labelStats,labelRecompensa;
	private JButton botonFer, botonMercy,botonAri, flechaArriba,flechaAbajo,flechaDerecha,flechaIzquierda, botonSiguiente,bSubmit;
	private JPanel panelPersonajes, panelPrincipal, panelHistoria, panelFlechas, panelMapa, panelOtro, panel3, panelIntroduccion,panelQuiz, panelImagen,panelPreguntas,panelSubmit,panelStats; 
	private ImageIcon Fer,Ari,Mercy, Escoge, Personajes, estudianteActual;
	private int width, lenght, personaje, contador=0, respuestaSubmit;
	private Campus mapa;
	private JTextField tRespuesta;
	private Estudiante estudiante;
	private Profesor profesor;
	private JScrollPane scrollPane;
	private JTextArea areaDeHistoria;
	private String historia,p,respuestaCorrecta;
	private String[] r;
	private Random random=new Random();
	private Pregunta pregunta;




	public Ventana(){
		super("Test Fest in TEC");
		mapa= new Campus(10,10);
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
		panelPrincipal.add(panelMapa);
		pintarMapa();
		

		//2
		panelHistoria= new JPanel();
		panelHistoria.setLayout(null);
		labelHistoria= new JLabel("Historia");
		labelHistoria.setBounds(120,20,180,23);
		historia= "sjhdjshdjshdhshjdhsjhdjshdjsjhdhs";

		areaDeHistoria=new JTextArea();
		areaDeHistoria.setText(historia);
		areaDeHistoria.setBounds(20,50,340,100);

		panelHistoria.setPreferredSize(new Dimension(350,250));

		panelHistoria.add(labelHistoria);
		panelHistoria.add(areaDeHistoria);

		scrollPane= new JScrollPane();
		scrollPane.setBounds(2,2,380,150);
		scrollPane.setViewportView(panelHistoria);
		panelPrincipal.add(scrollPane);


		// 3
		panelFlechas= new JPanel();
		panelFlechas.setLayout(new GridLayout(3,3));
	
		flechaIzquierda = new JButton("Izquierda");
		flechaDerecha= new JButton("Derecha");
		flechaArriba= new JButton("Arriba");
		flechaAbajo= new JButton("Abajo");
		flechaIzquierda.addActionListener(new BIzquierdaListener());
		flechaDerecha.addActionListener(new BDerechaListener());
		flechaArriba.addActionListener(new BArribaListener());
		flechaAbajo.addActionListener(new BAbajoListener());


		panelFlechas.add(new JLabel());
		panelFlechas.add(flechaArriba);
		panelFlechas.add(new JLabel());
		panelFlechas.add(flechaIzquierda);
		panelFlechas.add(new JLabel());
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
				if(mapa.casillas[i][j].estudiante==null){
					panel3.add(new JLabel("[  ]"));
				}else{
					panel3.add(new JLabel(estudiante.getClass().getSimpleName()));
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

						mapa.casillas [i][j].profesor=new Draculator(100,100);

					}
					if(numeroAleatorio ==1){
						mapa.casillas [i][j].profesor=new PorfirioDiaz(100,100);

					}
						if(numeroAleatorio ==2){

						mapa.casillas [i][j].profesor=new CaptainLoop(100,100);

					}
						if(numeroAleatorio ==3){
	
						mapa.casillas [i][j].profesor=new HannibalLecturas(100,100);

					}

				}
				
			}
		}
		mapa.casillas[0][0].estudiante=estudiante;
	}

	public void iniciarQuizz(){
		panelQuiz = new JPanel();
		panelQuiz.setLayout(new GridLayout(2,2));
		panelImagen = new JPanel();
		panelImagen.setLayout(new FlowLayout());

		Fer = new ImageIcon("Fer.jpeg");
		Ari = new ImageIcon("Ari.jpeg");
		labelEst = new JLabel(Fer);
		labelEst.setBounds(new Rectangle (0,0,0,0));
		panelImagen.add(labelEst);
		labelVacio = new JLabel("vs");
		panelImagen.add(labelVacio);
		labelMaestro = new JLabel(Ari);
		labelMaestro.setBounds(new Rectangle (0,0,0,0));
		panelImagen.add(labelMaestro);
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
		panelSubmit.add(labelRespuesta);
		tRespuesta = new JTextField();
		panelSubmit.add(tRespuesta);
		bSubmit = new JButton("Submit");
		bSubmit.addActionListener(new BotonSubmitListener());
		panelSubmit.add(bSubmit);
		panelQuiz.add(panelSubmit);


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
	public class BotonSiguienteFERListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Fer(100,200,100);
			//estudianteActual= new ImageIcon(estudiante.getRuta());

			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();
			
			

		}
	}
			
	public class BotonSiguienteARIListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Ari(100,200,100);
			//estudianteActual= new ImageIcon(estudiante.getRuta());
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





	public class BIzquierdaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			mapa.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.y= estudiante.y-1;
			try{
				mapa.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			}catch(ArrayIndexOutOfBoundsException ex){
			}	
			if (mapa.casillas[estudiante.x][estudiante.y].profesor!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();

			}else{
				
				panelMapa.remove(panel3);
				pintarMapa();

			}

		}
	}

	public class BDerechaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			mapa.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.y= estudiante.y+1;
			try{
				mapa.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			}catch(ArrayIndexOutOfBoundsException ex){
			}	
			if (mapa.casillas[estudiante.x][estudiante.y].profesor!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();

			}else{
				
				panelMapa.remove(panel3);
				pintarMapa();

			}

		}
	}

	public class BArribaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mapa.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.x= estudiante.x-1;

			try{
				mapa.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			}catch(ArrayIndexOutOfBoundsException ex){
			}	
			if (mapa.casillas[estudiante.x][estudiante.y].profesor!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();

			}else{
				
				panelMapa.remove(panel3);
				pintarMapa();

			}

		}
	}

	public class BAbajoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			mapa.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.x= estudiante.x+1;
			try{
				mapa.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			}catch(ArrayIndexOutOfBoundsException ex){
			}	
			if (mapa.casillas[estudiante.x][estudiante.y].profesor!= null){

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();

			}else{
				
				panelMapa.remove(panel3);
				pintarMapa();

			}


		}
	}

	public void imprimirPreguntas(){
		// Aqui se van a imprimir las preguntas segun el contador, para que no se repitan
		String imprime = "<html>";
		if(contador == 0){
			 p = "¿Que es un polinomio?";
			 r = new String[3];
			r[0]="Una ecuacion irracional";
			r[1]="Es la suma-resta de un conjunto de monomios";
			r[2]="Una ecuacion canonica";
			respuestaCorrecta = 1;
			imprime += p+"<br/>";
			imprime +="1 - "+r[0]+"<br/>";
			imprime+="2 - "+r[1]+"<br/>";
			imprime+="3 - "+r[2]+"<br/>";
			contador=1;
		}else if(contador ==1){
			p = "¿Que cultura recibe el nombre de CULTURA MADRE?";
			r = new String[3];
			r[0]="Olmeca";
			r[1]="Azteca";
			r[2]="Mexica";
			respuestaCorrecta = 0;
			imprime += p+"<br/>";
			imprime +="1 - "+r[0]+"<br/>";
			imprime+="2 - "+r[1]+"<br/>";
			imprime+="3 - "+r[2]+"<br/>";
			contador=2;
		}else if(contador ==2){
			p = "¿Quien creo al personaje de Sherlock Holmes?";
			r = new String[3];
			r[0]="Arthur Conan Doyle";
			r[1]="Agatha Christie";
			r[2]="Rudyard Kipling";
			respuestaCorrecta = 0;
			imprime += p+"<br/>";
			imprime +="1 - "+r[0]+"<br/>";
			imprime+="2 - "+r[1]+"<br/>";
			imprime+="3 - "+r[2]+"<br/>";
			contador=2;
		}else if(contador ==3){
			p = "¿Cual es la palabra reservada para el uso de una interfaz en otra clase?";
			r = new String[3];
			r[0]="Abstract";
			r[1]="Static";
			r[2]="Implements";
			respuestaCorrecta = r[2];
			imprime += p+"<br/>";
			imprime +="1 - "+r[0]+"<br/>";
			imprime+="2 - "+r[1]+"<br/>";
			imprime+="3 - "+r[2]+"<br/>";
			contador=0;
		}
		imprime+="</html>";
		labelPregunta.setText(imprime);
	} 


	public class BotonSubmitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			respuestaSubmit = Integer.parseInt(tRespuesta.getText());
			tRespuesta.setText("");
			//aqui se va a tener que poner una exepcion ya que si pica otra cosa que no sea 1,2,3 aparece una excepcion NullPointerException
			pregunta.respuestaCorrecta(r,respuestaSubmit,respuestaCorrecta);


		}
	}

}