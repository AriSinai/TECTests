

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextAREA;

import java.lang.reflect.Field;// agregar a ventana

panelHistoria= new JPanel(){
		panelHistoria.setLayout(null);
		labelHistoria= new JLabel("Historia");
		labelHistoria.setBounds(120,20,180,23);
		historia= "Llegó la recta final de clases, la estudiante tendrá que pasar todos los exámenes para poder salir del campus ¡Cuidado! Hay profesores a lo largo del Campus que te atacarán con exámenes sorpresa," 
		+"recuerda que cinco exámenes reprobados y habrás reprobado." +
			"Recuerda que puedes recoger items que te ayudarán a lo largo de tu travesía ¡Que el juego comience!";

		areaDeHistoria=new JTextArea();
		areaDeHistoria.setText(historia);
		areaDeHistoria.setBounds(20,50,340,100);

		panelHistoria.setPreferredSize(new Dimension(350,250));

		panelHistoria.add(labelHistoria);
		panelHistoria.add(areaDeHistoria);

		scrollPane= new JScrollPane();
		scrollPane.setBounds(2,2,380,150);
		scrollPane.setViewportView(panelHistoria);
		


		if(estudianteActual.getClass()== Ari){
			historiaPersonaje="Ari es una chica deportista, pasa su día entrenando y haciendo ejercicio."
			+"Como item puedes encontrar una pesa voladora. Le encanta ir a competencias de todos los deportes e incluso olimpiadas matemáticas. Tendrás suerte cuando te encuentres al malvado Draculator.";
			

			else if(estudianteActual.getClass()== Mercy){
				historiaPersonaje= "Mercy es una chica intelectual, que le encanta leer y aprender constantemente. Como item puedes encontrar reseñas literarias."
				+"Ha leído muchísimos libros y ni siquiera en fines de semana deja de hacerlo. Tendrás suerte cuando te encuentres al malvado Hannibal Lecturas.";


			
			else if(estudianteActual.getClass()==Fer){
				historiaPersonaje= "Fer es una chica bromista, pero su verdadera pasión es la historia. Le encanta hacer memes históricos."
				 +"Como item podrás encontrar cupones de fast food. Tendrás suerte cuando te encuentres al malvado PorfirioGuiaz.";
				}

			}
	
		}
		panelHistoria.add(historiaPersonaje);
    panelPrincipal.add(scrollPane);

	}






