import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{
	private JPanel panelQuiz,panelImagen,panelPreguntas,panelStats,panelSubmit;
	private JButton bRespuesta1,bRespuesta2,bRespuesta3,bSubmit;
	private JTextField tRespuesta;
	private JLabel labelPregunta,labelEst,labelMaestro,labelRespuesta,labelVacio,labelStats,labelVida,labelRecompensa;
	private ImageIcon fer,ari;


	public Ventana(){
		super("Panel Quiz");
		initComponents();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
	}

	public void initComponents()
	{
		panelQuiz = new JPanel();
		panelQuiz.setLayout(new GridLayout(2,2));
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
		panelSubmit = new JPanel();
		panelSubmit.setLayout(new GridLayout(3,1));
		labelRespuesta = new JLabel("Pon la respuesta");
		panelSubmit.add(labelRespuesta);
		tRespuesta = new JTextField();
		panelSubmit.add(tRespuesta);
		bSubmit = new JButton("Submit");
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

}
