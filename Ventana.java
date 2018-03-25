import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame
{
	private JPanel pCampus,pStats,pBotones,pHistoria,pInicio,pPreguntas,pSelect,pAri,pFer,pMercy,pPrincipal;
	private JButton bAri,bFer,bMercy,bIzquierda,bDerecha,bArriba,bAbajo;
	private JLabel lInicio;
	private Maestro maestro;
	private Estudiante estudiante;

	public Ventana()
	{
		super("Test Fest in Tec");
		initComponentsPrincipal();
		setLayout(new GridLayout(2,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setVisible(true);
	}


	public void initComponentsIntro()
	{
		pInicio = new JPanel();
		pInicio.setLayout(/*Pend*/);
		pSelect = new JPanel();
		lInicio = new JLabel("Seleccione a una estudiante.");
		pSelect.add(lInicio); 
		pInicio.add(pSelect);
		pAri = new JPanel();
		bAri = new JButton();
		bAri.addActionListener(new BAriListener());
		pAri.add(bAri);
		pInicio.add(pAri);
		pFer = new JPanel();
		bFer = new JButton();
		bFer.addActionListener(new BFerListener());
		pFer.add(bFer);
		pInicio.add(pFer);
		pMercy = new JPanel();
		bMercy = new JButton();
		bMercy.addActionListener(new BMercyListener());
		pMercy.add(bMercy);
		pInicio.add(pMercy);
		add(pInicio);

	}
	

	public void initComponentsPrincipal()
	{
		pPrincipal= new JPanel();
		pPrincipal.setLayout(new GridLayout(2,2));
		pStats = new JPanel();
		pPrincipal.add(pStats);
		pBotones = new JPanel();
		bIzquierda = new JButton();
		bIzquierda.addActionListener(new BIzquierdaListener());
		pBotones.add(bIzquierda);
		bDerecha = new JButton();
		bDerecha.addActionListener(new BDerechaListener());
		pBotones.add(bDerecha);
		bArriba = new JButton();
		bArriba.addActionListener(new BArribaListener());
		pBotones.add(bArriba);
		bAbajo = new JButton();
		bAbajo.addActionListener(new BAbajoListener());
		pBotones.add(bAbajo);
		pPrincipal.add(pBotones);
		pHistoria = new JPanel();
		pPrincipal.add(pHistoria);
		add(pPrincipal);

	}

	public void pintarCampus(){
		pCampus= new JPanel();
		pCampus.setLayout(new GridLayout(campus.casillas.length,campus.casillas[0].length));
		for(int i=0;i<campus.casillas.length;i++){
			for(int j=0;j<campus.casillas[i].length;j++){
				if(mapa.casillas[i][j].estudiante==null){
					pCampus.add(new JLabel("Vacio"));
				}
				else
				{
					pCampus.add(new JLabel("Estudiante"));
				}
			}
		}
		
		pPrincipal.add(pCampus);
		pPrincipal.revalidate();
		pPrincipal.repaint();		
	}

	public void llenarCasillas()
	{
		for(int i =0; i<campus.casillas.length;i++)
		{
			for(int j =0; j<campus.casillas[i];j++)
			{
				campus.casillas[i][j] = new Casilla();
			}
		}
		campus.casillas[0][0].estudiante = estudiante;
	}

	public void initComponentsPreguntas()
	{
		
	}

	public class BAriListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//al final tiene que haber un remove pInicio
		}
	}

	public class BFerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//al final tiene que haber un remove pInicio
		}
	}

	public class BMercyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//al final tiene que haber un remove pInicio
		}
	}

	public class BIzquierdaListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(y >0)
			{
			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.y= estudiante.y-1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			pPrincipal.remove(pCampus);
			pPrincipal.revalidate(pCampus);
			pPrincipal.repaint(pCampus);
			pintarCampus();

			}
			else
			{
				//Preguntar
				pintarCampus();
			}

		}
	}

	public class BDerechaListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(y < y.length)
			{
			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.y= estudiante.y+1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			pPrincipal.remove(pCampus);
			pPrincipal.revalidate(pCampus);
			pPrincipal.repaint(pCampus);
			pintarCampus();

			}
			else
			{
				//Preguntar
				pintarCampus();
			}

		}
	}

	public class BArribaListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(x < x.length)
			{
			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.x= estudiante.x-1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			pPrincipal.remove(pCampus);
			pPrincipal.revalidate(pCampus);
			pPrincipal.repaint(pCampus);
			pintarCampus();

			}
			else
			{
				//Preguntar
				pintarCampus();
			}

		}
	}

	public class BAbajoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(x > 0)
			{
			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.x= estudiante.x+1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			pPrincipal.remove(pCampus);
			pPrincipal.revalidate(pCampus);
			pPrincipal.repaint(pCampus);
			pintarCampus();

			}
			else
			{
				//Preguntar
				pintarCampus();
			}

		}
	}






}