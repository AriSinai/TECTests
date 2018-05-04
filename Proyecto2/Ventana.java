import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.InputMismatchException;
import javax.swing.JFileChooser;
import java.io.*;
public class Ventana extends JFrame{

	private JLabel labelPersonaje, tituloEscoge,labelHistoria, labelVida,labelAtaque,labelNombre,labelPregunta,labelEstudiante,labelEstudianteCara,labelMaestro,labelMaestroCara,labelRespuesta,labelVacio,labelStats,labelRecompensa,labelDuelo,labelHistoriaHTML,labelStudentStats,labelTeacherStats,labelMochila, labelItems, labelStatsPrincipal,labelStatsEstudiante,labelStatsProfesor,labelAtaqueEstudiante, labelAtaqueProfesor,labelGameOver,labelAprobaste,labelPerdiste,labelCalificacion;


	private JButton botonFer, botonMercy,botonAri, flechaArriba,flechaAbajo,flechaDerecha,flechaIzquierda, botonSiguiente,bSubmit,botonCargar,botonRedbull,botonCalcetin,botonMegafono,botonAtacar, botonGuardarPartida,botonCargarPartida,botonOkQuiz,botonContinuar;

	private JPanel panelPersonajes, panelPrincipal, panelHistoria, panelFlechas, panelMapa, panelStats, panel3, panelIntroduccion,panelQuiz, panelImagen,panelPreguntas,panelSubmit,panelBotonesInicio, panelImagenDos, panelContenedorPelea, panelItems, panelPelea, panelStatsPelea,panelStatsEstudiante,panelStatsPrincipal,panelStatsEstudiantePrincipal,panelHTMLHistoria,panelGameOver,panelCalificacion, panelCalificacionDos; 

	private ImageIcon iconFer,iconAri,iconMercy, iconEscoge, iconPersonajes, iconEstudianteActualCompleto, iconEstudianteActualCara, iconProfesorActualCompleto,iconProfesorActualCara,tituloPrincipalIcon, atacarIcon,logoIcon ,mochilaIcon,statsIcon,statsEstudianteIcon,statsProfesorIcon, itemsIcon,cargarPartidoIcon,iniciarIcon,flechaDerechaIcon,flechaArribaIcon,flechaIzquierdaIcon,flechaAbajoIcon,historiaIcon, calificarIcon, dueloIcon, vsIcon, iconStatsPrincipal,iconAprobaste,iconPerdiste;

	private int width, lenght, personaje, contador=0, respuestaSubmit, profesorLoop,quizzes,items,quizHisto,quizMate,quizEspa,quizLoop,itemCalcetin,itemRedbull,itemMegafono,diferencia;
	private Campus mapa;
	private JTextField tRespuesta;
	private Estudiante estudiante;
	private Profesor profesor;
	private JScrollPane scrollPane;
	private JTextArea areaDeHistoria;
	private String historia,p,historiaPersonaje,imprimeHistoria,historiaString;
	private Random random=new Random();
	private Pregunta pregunta;
	private Respuesta r1,r2,r3,respuestaCorrecta;
	private Item item;
	private Quiz quiz;
	private JFileChooser fileChooser;
	private Partida partida;
	
	/*private CalcetinSudado[] calcetinSudados;
	private Megafono[] megafonos;
	private Redbull[] redbulls;*/


	public Ventana(){
		super("Monster TEC");
		mapa= new Campus(11,11);
		int items=0;
		int profesores=0;
		int quizzes=0;
		int itemMegafono=0;
		int itemCalcetin=0;
		int itemRedbull=0;
		int profesorLoop=0;
		historiaString="Llegó la recta final de clases, la estudiante tendrá que pasar todos <br/> los exámenes para poder salir del campus ¡Cuidado! Hay profesores a lo <br/> largo del Campus que te atacarán con exámenes sorpresa, <br/> recuerda que cinco exámenes reprobados y habrás reprobado. <br/> Recuerda que puedes recoger items que te ayudarán a lo largo <br/> de tu travesía ¡Que el juego comience! <br/> ";
		width=700;
		lenght=500;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width,lenght);
		initComponents();
		setVisible(true);
	}

	public void initComponents(){
			//Menú de inicio
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
			
			panelBotonesInicio.add(botonSiguiente);
			//cargar --------------------------------------------------
		        botonCargarPartida= new JButton(cargarPartidoIcon);
			botonCargarPartida.addActionListener(new BotonCargarPartidaListener());
			panelBotonesInicio.add(botonCargarPartida);

			
		
		
			
	}
	public class BotonCargarPartidaListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
			fileChooser= new JFileChooser();
			fileChooser.showOpenDialog(null);
			try {

				File selectedFile = fileChooser.getSelectedFile();
				FileInputStream fileInputS = new FileInputStream(selectedFile);
				ObjectInputStream objectInputS = new ObjectInputStream(fileInputS);
				partida=(Partida)objectInputS.readObject();


			}catch(FileNotFoundException ex){
				System.out.println("Aun no hay partida");

			}catch(IOException ex){
				ex.printStackTrace();

			}catch(ClassNotFoundException ex){
				ex.printStackTrace();

			}
			

			
			}
		
			panelIntroduccion.add(panelBotonesInicio);
			add(panelIntroduccion);
		}

	}

	public void elegirPersonaje(){
		// botones para elegir personajes de personajes
		// Se defienen los botones para cada personaje
		panelPersonajes = new JPanel();
		panelPersonajes.setLayout( new BorderLayout());
			

		iconAri=new ImageIcon( "Ari.jpeg");
		iconFer=new ImageIcon( "Fer.jpeg");
		iconMercy=new ImageIcon( "Mercy.jpeg");
		iconEscoge=new ImageIcon("EscogePersonaje.png");
		iconPersonajes=new ImageIcon("Personajes.png");

		botonFer=new JButton (iconFer);
		botonAri= new JButton(iconAri);
		botonMercy = new JButton(iconMercy);
		botonFer.addActionListener(new BotonSiguienteFERListener());
		botonAri.addActionListener(new BotonSiguienteARIListener());
		botonMercy.addActionListener(new BotonSiguienteMERCYListener());
		botonAri.setBounds(new Rectangle (0,0,300,300));
		botonFer.setBounds(new Rectangle (0,0,300,300));
		botonMercy.setBounds(new Rectangle (0,0,300,300));

		tituloEscoge=new JLabel(iconEscoge);
		labelPersonaje=new JLabel(iconPersonajes);


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
		

		//1 Mapa
		panelMapa= new JPanel();
		panelPrincipal.add(panelMapa);
		pintarMapa();
		

		//2 historia
		panelHistoria= new JPanel();
		panelHistoria.setLayout(new BorderLayout());
		historiaIcon=new ImageIcon("Historia.png");
		labelHistoria= new JLabel(historiaIcon);
		labelHistoria.setBounds(120,5,260,50);
		panelHistoria.setPreferredSize(new Dimension(350,250));
		panelHistoria.add(labelHistoria,BorderLayout.PAGE_START);

		panelHTMLHistoria=new JPanel();
		panelHTMLHistoria.setLayout(new FlowLayout());

		labelHistoriaHTML=new JLabel();
		panelHTMLHistoria.add(labelHistoriaHTML);
		imprimirHistoria();
		scrollPane= new JScrollPane();
		scrollPane.setBounds(2,2,380,150);
		scrollPane.setViewportView(panelHTMLHistoria);
		panelHistoria.add(new JLabel("             "),BorderLayout.LINE_START);
		panelHistoria.add(new JLabel("             "),BorderLayout.LINE_END);
		panelHistoria.add(scrollPane,BorderLayout.CENTER);
		panelPrincipal.add(panelHistoria);


		// 3 Flechas
		panelFlechas= new JPanel();
		panelFlechas.setLayout(new GridLayout(3,3));
	
		
		flechaIzquierdaIcon = new ImageIcon("flechaIzquierda.png");
		flechaDerechaIcon = new ImageIcon("flechaDerecha.png");
		flechaArribaIcon = new ImageIcon("flechaArriba.png");
		flechaAbajoIcon = new ImageIcon("flechaAbajo.png");

		flechaIzquierda = new JButton(flechaIzquierdaIcon);
		flechaDerecha = new JButton(flechaDerechaIcon);
		botonGuardarPartida=new JButton("Guardar Partida");
		botonGuardarPartida.addActionListener(new BotonGuardarPartidaListener());	
		flechaAbajo = new JButton(flechaAbajoIcon);
		flechaArriba = new JButton(flechaArribaIcon);

		//ACTIONLISTENER-->


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

		//4 Stats

		panelStatsPrincipal= new JPanel();		
		panelStatsPrincipal.setLayout(new BorderLayout());


		panelStatsEstudiantePrincipal=new JPanel();
		panelStatsEstudiantePrincipal.setLayout(new GridLayout(3,1));

		panelStatsPrincipal.add(labelEstudianteCara, BorderLayout.LINE_START);

		iconStatsPrincipal=new ImageIcon("StatsPrincipal.png");
		labelStatsPrincipal=new JLabel(iconStatsPrincipal);

		panelStatsPrincipal.add(labelStatsPrincipal, BorderLayout.PAGE_START);

		labelVida=new JLabel();
		labelAtaque=new JLabel(); 
		labelNombre=new JLabel();
		labelNombre.setText("Eres la estudiante: "+estudiante.getClass().getSimpleName());
		panelStatsEstudiantePrincipal.add(labelNombre);
		panelStatsEstudiantePrincipal.add(labelVida);
		imprimirStatsPanelPrincipal();
		panelStatsEstudiantePrincipal.add(labelAtaque);
		imprimirCantidadItems();
		panelStatsPrincipal.add(panelStatsEstudiantePrincipal,BorderLayout.CENTER);

		panelPrincipal.add(panelStatsPrincipal);


		add(panelPrincipal);
	}

	public void pintarMapa(){
		
		panel3=new JPanel();
		panel3.setLayout(new GridLayout(mapa.casillas.length,mapa.casillas[0].length));
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				if(mapa.casillas[i][j].getEstudiante()==null  && mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
					panel3.add(new JLabel("[ V ]"));


				} if(mapa.casillas[i][j].getEstudiante()==estudiante){
					panel3.add(new JLabel(estudiante.getClass().getSimpleName()));
				}
				if (mapa.casillas[i][j].getEstudiante()==null && mapa.casillas[i][j].getProfesor()!=null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
					panel3.add(new JLabel("[ P ]"));
				}
				if (mapa.casillas[i][j].getEstudiante()==null  && mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()!=null && mapa.casillas[i][j].getQuiz()==null){
					panel3.add(new JLabel("[  I  ]"));

				}
				if (mapa.casillas[i][j].getEstudiante()==null && mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()!=null){
					panel3.add(new JLabel("[ Q ]"));

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
		


		
		
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				mapa.casillas[i][j]= new Casilla();
				int numeroAleatorio = limiteInferior + random.nextInt(limiteSuperiorAbierto - limiteInferior);
				if(profesor.getCount()<10){
					if(numeroAleatorio ==1 && Math.random()>0.8 && (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setProfesor(new Draculator(10,100));
						profesor.incrementarContador();
					}
		
					if(numeroAleatorio ==2 && Math.random()<0.1&&(mapa.casillas[i][j]!=mapa.casillas[0][0]) && mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setProfesor(new PorfirioGuiaz(10,100));
						profesor.incrementarContador();
					}
					
					
					if(numeroAleatorio ==3 && Math.random()>0.9&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setProfesor(new HannibalLecturas(10,100));
						profesor.incrementarContador();


					}
	

					
				}	
				if(items<8){
					if(numeroAleatorio ==0 && Math.random()>0.7&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setItem(new CalcetinSudado());

					
						items++;

					}
		
					if(numeroAleatorio ==1 && Math.random()>0.7&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setItem(new Redbull());

					
						items++;
					}
					
					if(numeroAleatorio ==2 && Math.random()>0.7&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setItem(new Megafono());

						
						items++;
		


					}

					
				}	

				if(quizzes<4){
					if(numeroAleatorio ==3 && Math.random()>=0.6 && quizMate<1&&(mapa.casillas[i][j]!=mapa.casillas[0][0]) && mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setQuiz(new QuizMate());
						quizzes++;
						quizMate++;

					}
					if(numeroAleatorio ==2 && Math.random()>=0.8 && quizLoop<1&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setQuiz(new QuizLoop());
						quizzes++;
						quizLoop++;

					}
					if(numeroAleatorio ==1 && Math.random()>=0.7 && quizHisto<1&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setQuiz(new QuizHisto());
						quizzes++;
						quizHisto++;

					}
					if(numeroAleatorio ==0 && Math.random()>=0.9 && quizEspa<1&& (mapa.casillas[i][j]!=mapa.casillas[0][0]) &&mapa.casillas[i][j].getProfesor()==null && mapa.casillas[i][j].getItem()==null && mapa.casillas[i][j].getQuiz()==null){
						mapa.casillas [i][j].setQuiz(new QuizEspa());
						quizzes++;
						quizEspa++;

					}

					
				}
				
				

				

			}
		}

		


		mapa.casillas[0][0].setEstudiante(estudiante);	

	}

	public void imprimirStatsPanelPrincipal(){
		//labelVida=new JLabel();
		System.out.println("Aqui llega: "+estudiante.getVida());
		String imprimeStatsStudiante="<html>";
		imprimeStatsStudiante+="STATS PERSONAJE <br/> Vida: " + estudiante.getVida()+"<br/> Defensa: "+ estudiante.getDefensa()+"<br/> Ataque: "+estudiante.getAtaque();
		

		imprimeStatsStudiante += "</html>";
		
		labelVida.setText(imprimeStatsStudiante);

	}

	public void imprimirCantidadItems(){
		//labelAtaque=new JLabel();
		String imprimeItems="<html>";
		imprimeItems+="OBJETOS EN LA MOCHILA <br/> Calcetines Sudados:"+ itemCalcetin+"<br/> Megafonos:"+itemMegafono+" <br/> Redbulls: "+itemRedbull;
		imprimeItems += "</html>";
		labelAtaque.setText(imprimeItems);
	}

	public void imprimirHistoria(){

		String imprimeHistoria = "<html>";
		imprimeHistoria=imprimeHistoria+historiaString;

		imprimeHistoria+="</html>";
		labelHistoriaHTML.setText(imprimeHistoria);

	}

	public void iniciarQuizz(){

		
		panelQuiz = new JPanel();
		panelQuiz.setLayout(new GridLayout(2,2));
		panelImagen = new JPanel();
		panelImagen.setLayout(new GridLayout(2,1));
		
		dueloIcon=new ImageIcon("Duelo.png");
		labelDuelo=new JLabel(dueloIcon);
		panelImagen.add(labelDuelo);
		panelImagenDos=new JPanel();

		panelImagenDos.setLayout(new GridLayout(1,3));

		
		panelImagenDos.add(labelEstudianteCara);
		vsIcon=new ImageIcon("vs.png");
		labelVacio = new JLabel(vsIcon);
		panelImagenDos.add(labelVacio);
		labelMaestro=new JLabel(iconProfesorActualCara);
		panelImagenDos.add(labelMaestroCara);
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
		calificarIcon=new ImageIcon("CalificarQuiz.png");
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
		dueloIcon=new ImageIcon("Duelo.png");
		labelDuelo=new JLabel(dueloIcon);
		panelImagen.add(labelDuelo);
		panelImagenDos=new JPanel();
		panelImagenDos.setLayout(new GridLayout(1,3));
		labelEstudiante = new JLabel(iconEstudianteActualCara);
		panelImagenDos.add(labelEstudiante);
		vsIcon=new ImageIcon("vs.png");
		labelVacio = new JLabel(vsIcon);
		panelImagenDos.add(labelVacio);
		labelMaestro = new JLabel(iconProfesorActualCara);
		panelImagenDos.add(labelMaestro);
		panelImagen.add(panelImagenDos);
		panelContenedorPelea.add(panelImagen);

 
		// 2 
	    panelItems= new JPanel();
	    panelItems.setLayout(new BorderLayout());
	    itemsIcon= new ImageIcon("Items.png");
	    mochilaIcon= new ImageIcon("Mochila.png");
	    
	    botonCalcetin= new JButton("Calcetin +10 Ataque");
	    botonCalcetin.addActionListener(new BotonCalcetinListener());
	    botonMegafono= new JButton("Megafono +4 Defensa");
	    botonMegafono.addActionListener(new BotonMegafonoListener());
	    botonRedbull= new JButton(" Redbull  +20 Vida ");
	    botonRedbull.addActionListener(new BotonRedbullListener());


	    labelMochila= new JLabel(mochilaIcon);
	    labelItems= new JLabel(itemsIcon);
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
	    labelAtaqueProfesor=new JLabel();
	    labelAtaqueEstudiante=new JLabel();
	    labelStatsEstudiante=new JLabel();
	    labelStatsProfesor=new JLabel();

	    panelStatsPelea.add(labelStudentStats);
	    panelStatsPelea.add(labelTeacherStats);

	    panelStatsPelea.add(labelStatsEstudiante);
	   	imprimirStatsEstudiante();

	    panelStatsPelea.add(labelStatsProfesor);
	    imprimirStatsProfesor();

	    panelStatsPelea.add(labelAtaqueEstudiante);


	    panelStatsPelea.add(labelAtaqueProfesor);
	    imprimirCantidadItemsDos();

	    
	    panelContenedorPelea.add(panelStatsPelea);

	    add(panelContenedorPelea);

	}
	//PELE
	public void imprimirStatsEstudiante(){
		String StatsHTML="<html>";
		StatsHTML+="Vida: " + estudiante.getVida()+"<br/> Defensa: "+ estudiante.getDefensa()+"<br/> Ataque: "+estudiante.getAtaque();
		

		StatsHTML += "</html>";
		
		labelStatsEstudiante.setText(StatsHTML);

	}

	public void imprimirStatsProfesor(){
		String StatsProfeHTML="<html>";
		StatsProfeHTML+="Vida: " + profesor.getVida()+"<br/> Ataque: "+profesor.getAtaque();
		

		StatsProfeHTML += "</html>";
		
		labelStatsProfesor.setText(StatsProfeHTML);

	}
	
	public void imprimirCantidadItemsDos(){
		//labelAtaque=new JLabel();
		String imprimeItems="<html>";
		imprimeItems+="OBJETOS EN LA MOCHILA <br/> Calcetines Sudados:"+ itemCalcetin+"<br/> Megafonos:"+itemMegafono+" <br/> Redbulls: "+itemRedbull;
		imprimeItems += "</html>";
		labelAtaqueProfesor.setText(imprimeItems);
	}
	

	public class BotonSiguienteFERListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Fer(10,8,100);
			iconEstudianteActualCompleto= new ImageIcon(estudiante.getImagenCompleta());
			iconEstudianteActualCara=new ImageIcon(estudiante.getImagenCara());
			labelEstudiante=new JLabel(iconEstudianteActualCompleto);
			labelEstudianteCara=new JLabel(iconEstudianteActualCara);
			historiaString=historiaString+"<br/> Fer es una chica bromista, pero su verdadera pasión es la historia. <br/> Le encanta hacer memes históricos. <br/> Como item podrás encontrar un megafono que le ayuda a hacer bromas.  <br/> Tendrás suerte cuando te encuentres al malvado Porfirio Guiaz.<br/>";

			llenarCasillas();
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();
			
			

		}
	}
			
	public class BotonSiguienteARIListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Ari(10,8,100);
			iconEstudianteActualCompleto= new ImageIcon(estudiante.getImagenCompleta());
			iconEstudianteActualCara=new ImageIcon(estudiante.getImagenCara());
			labelEstudiante=new JLabel(iconEstudianteActualCompleto);
			labelEstudianteCara=new JLabel(iconEstudianteActualCara);
			historiaString=historiaString+"<br/> Ari es una chica deportista, pasa su día entrenando y haciendo ejercicio. <br/>Como item puedes encontrar un calcetín sudado.  <br/> Le encanta ir a competencias de todos los deportes e incluso olimpiadas matemáticas. <br/> Tendrás suerte cuando te encuentres al malvado Draculator.<br/>";
			llenarCasillas();
			remove(panelPersonajes);
			mapaPrincipal();
			revalidate();
			repaint();				
		}
	}

	public class BotonSiguienteMERCYListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			estudiante= new Mercy(10,8,100);
			iconEstudianteActualCompleto= new ImageIcon(estudiante.getImagenCompleta());
			iconEstudianteActualCara=new ImageIcon(estudiante.getImagenCara());
			labelEstudiante=new JLabel(iconEstudianteActualCompleto);
			labelEstudianteCara=new JLabel(iconEstudianteActualCara);
			historiaString=historiaString+"<br/> Mercy es una chica intelectual, que le encanta leer y aprender constantemente. <br/>Continuamente bebe muchas bebidas con mucha cafeína y taurina! <br/> Como item puedes encontrar un Redbull para que le dé alas. <br/> Ha leído muchísimos libros y ni siquiera en fines de semana deja de hacerlo. <br/> Tendrás suerte cuando te encuentres al malvado Hannibal Lecturas.<br/>";

			
			llenarCasillas();
			remove(panelPersonajes);
			mapaPrincipal();

			revalidate();
			repaint();	
		}		
	}
	
	//INICIAR o CARGAR
	public class BotonSiguienteListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			remove (panelIntroduccion);
			elegirPersonaje();
			revalidate();
			repaint();
		}
	}	
	//PANEL PELEA
	public class atacarActionListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
        	
  			estudiante.atacar(profesor); //profesor
 

            profesor.atacar(estudiante);
  	

            imprimirStatsEstudiante();
            imprimirStatsProfesor();

			try{
            	gameOver(estudiante.getVida());
            }catch(GameOverException go){
				remove(panelContenedorPelea);          	
				pFinal();
				revalidate();
				repaint();
            }
		
            if(profesor.getVida()<=0){
            	historiaString=historiaString+"<br/> Mataste a "+ profesor.getClass().getSimpleName();
            	mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(null);
            	profesor.disminuirContador();
            	System.out.println(profesor.getCount());
  
                remove(panelContenedorPelea);
				add(panelPrincipal);
				panelMapa.remove(panel3);
				imprimirStatsPanelPrincipal();
				imprimirCantidadItems();
				pintarMapa();
				revalidate();
				repaint();
             }
             
		}
	}

	public void aprobasteQuiz(){

		panelCalificacion = new JPanel();
		panelCalificacion.setLayout(new GridLayout(1,2));
		panelCalificacionDos=new JPanel();
		panelCalificacionDos.setLayout(new GridLayout(2,1));
		iconAprobaste=new ImageIcon(profesor.getImagenAprobado());
		labelAprobaste=new JLabel(iconAprobaste);
		panelCalificacion.add(labelAprobaste);
		labelCalificacion=new JLabel("Aprobaste el quiz de "+profesor.getClass().getSimpleName());
		botonContinuar=new JButton("Continuar");
		botonContinuar.addActionListener(new botonContinuarListener());
		panelCalificacionDos.add(labelCalificacion);
		panelCalificacionDos.add(botonContinuar);
		panelCalificacion.add(panelCalificacionDos);
		historiaString=historiaString+"<br/> El profesor " + profesor.getClass().getSimpleName()+" te aplicó un examen y aprobaste, aumentó tu vida 20 puntos";
		mapa.casillas[estudiante.getX()][estudiante.getY()].setQuiz(null);
		add(panelCalificacion);
		
	}
	public void fallasteQuiz(){
		panelCalificacion = new JPanel();
		panelCalificacion.setLayout(new GridLayout(1,2));
		panelCalificacionDos=new JPanel();
		panelCalificacionDos.setLayout(new GridLayout(2,1));
		iconPerdiste=new ImageIcon(profesor.getImagenPerdiste());
		labelPerdiste=new JLabel(iconPerdiste);
		panelCalificacion.add(labelPerdiste);
		labelCalificacion=new JLabel("Reprobaste el quiz de "+profesor.getClass().getSimpleName());
		botonContinuar=new JButton("Continuar");
		botonContinuar.addActionListener(new botonContinuarListener());
		panelCalificacionDos.add(labelCalificacion);
		panelCalificacionDos.add(botonContinuar);
		panelCalificacion.add(panelCalificacionDos);
		historiaString=historiaString+"<br/> El profesor " + profesor.getClass().getSimpleName()+" te aplicó un examen y reprobaste";
		mapa.casillas[estudiante.getX()][estudiante.getY()].setQuiz(null);
		add(panelCalificacion);
		

	}
	
	public void gameOver(int vida) throws GameOverException{
            if(estudiante.getVida()<=0){
                //Gameover
            	throw new GameOverException();
            }else{
        
        	//System.out.println("Nadie ha muerto");
        	}
        
	}

	public void pFinal(){
		
		panelGameOver = new JPanel();
		panelGameOver.setLayout(new BorderLayout());
		labelGameOver = new JLabel(new ImageIcon("GameOver.png"));
		panelGameOver.add(labelGameOver,BorderLayout.CENTER);
		add(panelGameOver);
	}
	//APORBASTE REPROBASTE
	public class botonContinuarListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

				remove(panelCalificacion);
				add(panelPrincipal);
				panelMapa.remove(panel3);
				imprimirStatsPanelPrincipal();
				imprimirCantidadItems();
				pintarMapa();
				revalidate();
				repaint();

		}
	}

	public class BotonGuardarPartidaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		try{
		JOptionPane pane= new JOptionPane();
		String partidaSeleccion=pane.showInputDialog("Selecciona la partida");
		FileOutputStream fout = new FileOutputStream(partidaSeleccion);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(partida);
		out.close();				
		}catch(FileNotFoundException ex){
		ex.printStackTrace();
		}catch(IOException ex){
		ex.printStackTrace();
		}


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
			if (profesor.getCount() >1&&mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){
				
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);


				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				//profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz()!= null){
				quiz=mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz();	
				System.out.println(quiz.getClass());

				if (quiz.getClass().getSimpleName().equals("QuizMate")){
					profesor=new Draculator(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizHisto")){
					profesor=new PorfirioGuiaz(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizEspa")){
					profesor=new HannibalLecturas(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizLoop")){
					profesor=new CaptainLoop(10,100);
					
					System.out.println(profesor.getClass());
				}
				
				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);
				
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();
				

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getItem()!= null){
				item=mapa.casillas[estudiante.getX()][estudiante.getY()].getItem();	
				System.out.println(item.getClass());

				if (item.getClass().getSimpleName().equals("CalcetinSudado")){
					itemCalcetin++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);

				
					imprimirHistoria();
				}
				if (item.getClass().getSimpleName().equals("Megafono")){
					itemMegafono++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
					System.out.println(item.getClass());
					
				}
				if (item.getClass().getSimpleName().equals("Redbull")){
					itemRedbull++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
				}
				
				
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				
			}
			if (profesor.getCount()==1 && mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(null);
				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(new CaptainLoop(30,200));

				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
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

			if (profesor.getCount() >1&&mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){
				
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);


				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				//profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz()!= null){
				quiz=mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz();	
				System.out.println(quiz.getClass());

				if (quiz.getClass().getSimpleName().equals("QuizMate")){
					profesor=new Draculator(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizHisto")){
					profesor=new PorfirioGuiaz(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizEspa")){
					profesor=new HannibalLecturas(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizLoop")){
					profesor=new CaptainLoop(10,100);
					
					System.out.println(profesor.getClass());
				}
				
				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();
				

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getItem()!= null){
				item=mapa.casillas[estudiante.getX()][estudiante.getY()].getItem();	
				System.out.println(item.getClass());

				if (item.getClass().getSimpleName().equals("CalcetinSudado")){
					itemCalcetin++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);

				
					imprimirHistoria();
				}
				if (item.getClass().getSimpleName().equals("Megafono")){
					itemMegafono++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
					System.out.println(item.getClass());
					
				}
				if (item.getClass().getSimpleName().equals("Redbull")){
					itemRedbull++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
				}
				
				
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				
			}
			if (profesor.getCount()==1 && mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(null);
				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(new CaptainLoop(50,300));

				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
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
			if (profesor.getCount() >1&&mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){
				
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);


				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				//profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz()!= null){
				quiz=mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz();	
				System.out.println(quiz.getClass());

				if (quiz.getClass().getSimpleName().equals("QuizMate")){
					profesor=new Draculator(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizHisto")){
					profesor=new PorfirioGuiaz(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizEspa")){
					profesor=new HannibalLecturas(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizLoop")){
					profesor=new CaptainLoop(10,100);
					
					System.out.println(profesor.getClass());
				}
				
				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();
				

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getItem()!= null){
				item=mapa.casillas[estudiante.getX()][estudiante.getY()].getItem();	
				System.out.println(item.getClass());

				if (item.getClass().getSimpleName().equals("CalcetinSudado")){
					itemCalcetin++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);

				
					imprimirHistoria();
				}
				if (item.getClass().getSimpleName().equals("Megafono")){
					itemMegafono++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
					System.out.println(item.getClass());
					
				}
				if (item.getClass().getSimpleName().equals("Redbull")){
					itemRedbull++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
				}
				
				
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				
			}
			if (profesor.getCount()==1 && mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(null);
				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(new CaptainLoop(50,300));

				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
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
			if (profesor.getCount() >1&&mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){
				
				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);


				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
				//profesor=mapa.casillas[estudiante.getX()][estudiante.getY()];
				//iniciarQuizz();
				revalidate();
				repaint();

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz()!= null){
				quiz=mapa.casillas[estudiante.getX()][estudiante.getY()].getQuiz();	
				System.out.println(quiz.getClass());

				if (quiz.getClass().getSimpleName().equals("QuizMate")){
					profesor=new Draculator(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizHisto")){
					profesor=new PorfirioGuiaz(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizEspa")){
					profesor=new HannibalLecturas(10,100);
					
					System.out.println(profesor.getClass());
				}
				if (quiz.getClass().getSimpleName().equals("QuizLoop")){
					profesor=new CaptainLoop(10,100);
					
					System.out.println(profesor.getClass());
				}
				
				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarQuizz();
				revalidate();
				repaint();
				

			}else if (mapa.casillas[estudiante.getX()][estudiante.getY()].getItem()!= null){
				item=mapa.casillas[estudiante.getX()][estudiante.getY()].getItem();	
				System.out.println(item.getClass());

				if (item.getClass().getSimpleName().equals("CalcetinSudado")){
					itemCalcetin++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);

				
					imprimirHistoria();
				}
				if (item.getClass().getSimpleName().equals("Megafono")){
					itemMegafono++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
					System.out.println(item.getClass());
					
				}
				if (item.getClass().getSimpleName().equals("Redbull")){
					itemRedbull++;
					historiaString=historiaString+"<br/> Recogiste un " + item.getClass().getSimpleName();
					System.out.println(item.getClass());
					imprimirCantidadItems();
					mapa.casillas[estudiante.getX()][estudiante.getY()].setItem(null);
					
					imprimirHistoria();
				}
				
				
				
				
				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				
			}
			if (profesor.getCount()==1 && mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor()!= null){

				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(null);
				mapa.casillas[estudiante.getX()][estudiante.getY()].setProfesor(new CaptainLoop(50,300));

				profesor=mapa.casillas[estudiante.getX()][estudiante.getY()].getProfesor();

				iconProfesorActualCompleto=new ImageIcon(profesor.getImagenCompleta());
				iconProfesorActualCara= new ImageIcon(profesor.getImagenCara());
				labelMaestro=new JLabel(iconProfesorActualCompleto);
				labelMaestroCara= new JLabel(iconProfesorActualCara);

				//historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[estudiante.x][estudiante.y].profesor.ataque+"<br/>";
				remove (panelPrincipal);
				iniciarPelea();
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
		if(profesor.getClass().getSimpleName().equals("Draculator")){
			pregunta= new Pregunta("¿Que es un polinomio?");
			r1=new Respuesta("Una ecuacion irracional");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Es la suma-resta de un conjunto de monomios");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Una ecuacion canonica");
			pregunta.addRespuesta(r3,2);
			contador=1;
			pregunta.setRespuestaCorrecta(new Respuesta("Es la suma-resta de un conjunto de monomios"));
			
		}else if(profesor.getClass().getSimpleName().equals("PorfirioGuiaz")){
			pregunta= new Pregunta("¿Que cultura recibe el nombre de CULTURA MADRE?");
			r1=new Respuesta("Olmeca");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Azteca");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Mexica");
			pregunta.addRespuesta(r3,2);
			pregunta.setRespuestaCorrecta(new Respuesta("Olmeca"));
	
			contador=2;
		}else if(profesor.getClass().getSimpleName().equals("HannibalLecturas")){
			pregunta= new Pregunta("¿Quien creo al personaje de Sherlock Holmes?");
			r1=new Respuesta("Arthur Conan Doyle");
			pregunta.addRespuesta(r1,0);
			r2=new Respuesta("Agatha Christie");
			pregunta.addRespuesta(r2,1);
			r3=new Respuesta("Rudyard Kipling");
			pregunta.addRespuesta(r3,2);
			pregunta.setRespuestaCorrecta(new Respuesta("Arthur Conan Doyle"));
			
			contador=1;
		}else if(profesor.getClass().getSimpleName().equals("CaptainLoop")){
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
	//QUIZ

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
			
			if (pregunta.getEstado()==2){
				remove(panelQuiz);
				aprobasteQuiz();
				revalidate();
				repaint();




			}else if (pregunta.getEstado()==3){
				remove(panelQuiz);
				fallasteQuiz();
				revalidate();
				repaint();
			}
			

			

		}
	}

	public void imprimeStatsQuiz(){
		String imprimeStats = "<html>";
		imprimeStats += "Vida: " + estudiante.getVida();
		labelVida.setText(imprimeStats);
		labelRecompensa.setText("La Recompensa por este Quiz es de +20 en vida");
		imprimeStats+="</html>";
	}

	public class BotonCalcetinListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			if (itemCalcetin >0){
				estudiante.aumentarAtaque();
				imprimirStatsEstudiante();
				
				itemCalcetin--;
				imprimirCantidadItemsDos();
				

			}

		}
	}
	public class BotonMegafonoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (itemMegafono >0){
				estudiante.aumentarDefensa();
				imprimirStatsEstudiante();
				

				itemMegafono--;
				imprimirCantidadItemsDos();
			}
			
		}
	}
	public class BotonRedbullListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (itemRedbull >0){
				estudiante.aumentarVida();
				imprimirStatsEstudiante();
				
				itemRedbull--;
				imprimirCantidadItemsDos();
				
			}
			
		}
	}

}

