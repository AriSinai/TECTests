import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

	private JLabel label1,label2,label3,label4, labelVillano, labelVida,labelAtaque,lavelNombre, labelPelea, labelPeleaHeroe, labelPeleaVillano, labelHistoria;
	private JButton boton1,boton2, botonAtacar;
	private JPanel panel1,panel2,panel3,panel4,panelContenedor, panelIntroduccion, panelPrincipal, panelPelea; 
	private Mapa mapa;
	private Heroe heroe;
	private Villano villanoActual;
	private JScrollPane scrollPane;
	private String historiaString;

	public Ventana(){
		super("Mi primera ventana");
		mapa= new Mapa(10,10);
		heroe= new Heroe();
		heroe.nombre="El Prof";
		historiaString="Bienvenido al juego Bla <br/>";
		llenarCasillas();
		initComponents();
		setLayout(new GridLayout(2,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}
	public void initComponents(){
			panelIntroduccion= new JPanel();
			panelIntroduccion.setLayout(new GridLayout(1,2));
			panelIntroduccion.add (new JLabel ("Bienvenido"));
			botonSiguiente=new JButton ("Siguiente");
			botonSiguiente.addActionListener(new BotonSiguienteListener);
			panelIntroduccion.add(botonSiguiente);
			add(panelIntroduccion);
		}

	public void initComponentsPelea(){
		panelPelea=new JPanel();
		panelPelea.setLayout(new GridLayout(2,2));
		labelPelea=new JLabel;
		labelPeleaVillano= new JLabel;
		labelPeleaHeroe=new JLabel;
		botonAtacar = new JButton;
		labelVillano=new JLabel();

		panelPelea.add(labelPelea);
		panelPelea.add(botonAtacar);
		botonAtaca.addActionListener(new BotonAtacatListener());
		panelPelea.add(labelPeleaHeroe);
		panelPelea.add(labelPeleaVillano);
		add(panelPelea);
	}
	public void initComponentsPrincipal(){
		panelPrincipal=new JPanel();
		panelPrincipal.setLayout(new GridLayout(2,2));
		panel1= new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		boton1= new JButton("Push me");
		boton1.addActionListener(new Boton1Listener());
		panel1.add(boton1);
		label1= new JLabel("Hello World!!!");
		panel1.add(label1);
		label2= new JLabel("Hello World 2!!!");
		panel1.add(label2);
		panelPrincipal.add(panel1);


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
	}

	public void llenarCasillas(){
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				mapa.casillas[i][j]= new Casilla();
				if(Math.random()>=0.5){
					Double ataqueDouble = Math.random()*99+1;
					Double vidaDouble=(Math.random()*99+1);
					mapa.casillas [i][j]=new Villano();

				}
			}
		}
		mapa.casillas[0][0].heroe=heroe;
	}

	public void pintarMapa(){
		
		panel3= new JPanel();
		panel3.setLayout(new GridLayout(mapa.casillas.length,mapa.casillas[0].length));
		for(int i=0;i<mapa.casillas.length;i++){
			for(int j=0;j<mapa.casillas[i].length;j++){
				if(mapa.casillas[i][j].heroe==null){
					panel3.add(new JLabel("Vacio"));
				}else{
					panel3.add(new JLabel("Heroe"));
				}
			}
		}
		
		panelContenedor.add(panel3);
		panelContenedor.revalidate();
		panelContenedor.repaint();		
	}

	public class Boton1Listener implements ActionListener{

		public void actionPerformed(ActionEvent e){
			System.out.println("Entra boton");
			System.out.println("Actual x:"+heroe.x+" y: "+heroe.y);

			mapa.casillas[heroe.x][heroe.y].heroe=null;
			heroe.y= heroe.y+1;
			System.out.println("Nueva x:"+heroe.x+" y: "+heroe.y);

			mapa.casillas[heroe.x][heroe.y].heroe=heroe;
			if (mapa.casillas[heroe.x][heroe.y].villano!= null){

				historiaString=historiaString+"Apareció un villano con ataque: " + mapa.casillas[heroe.x][heroe.y].villano.ataque+"<br/>";
				remove (panelPrincipal);
				initComponentsPelea();
				villanoActual=mapa.casillas[heroe.x][heroe.y];
				
				imprimeStatsPelea(villanoActual, heroe);
				revalidate();
				repaint();

			}else{
				
				pintarMapa();

			}
			

		}

		public class BotonAtacatListener implements ActionListener{
			public void actionPerformed (ActionEvent e){
					heroe.atacar(villanoActual);
					villanoActual.atacar(heroe);
					imprimeStatsPelea(villanoActual,heroe)
					if(heroe.vida<=0){
						//Gameover

					}
					if(villano.vida<=0){
						labelPelea.setText("Has matado al villano");
						historiaString=historiaString+"matar <br/>"
						remove(panelPelea);
						add(panelPrincipal);
						revalidate();
						repaint();
						imprimeStats();
						panelContenedor.remove(panel3);
						panelContenedor.revalidate();
						panelContenedor.repaint();
						pintarMapa();
						imprimeHistoria();

					}
			}

		}

		public class BotonSiguienteListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				remove (panelIntroduccion);
				initComponentsPrincipal();
				revalidate();
				repaint();
			}
		}

		public void imprimeStats(){
			labelVida.setText("Vida:"+heroe.vida);
			labelAtaque.setText("Ataque:"+heroe.ataque);
			labelNombre.setText("nombre:"+heroe.nombre);

		}

		public void imprimeStatsPelea(Villano v, Heroe h){

			labelPeleaHeroe.setText("Stats del heroe: "+h.vida+" vida"+h.ataque+" ataque");
			labelPeleaHeroe.setText("Stats del villano: "+v.vida+" vida"+v.ataque+" ataque");

		}
		
		public void imprimeHistoria(){
			labelHistoria.setText("<htmal>"+historiaString+"</html>");
		}
	}

}
