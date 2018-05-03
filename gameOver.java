import java.util.InputMismatchException;


public class atacarActionListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
        	
  			estudiante.atacar(profesor); //profesor
  			System.out.println("Atacaste a un profe");
            profesor.atacar(estudiante);
  			System.out.println("Te atacaron");

            //imprimirStatsEstudiante();
            //imprimirStatsProfesor();
            try{
            	gameOver(estudiante.getVida());
            }catch(GameOverException go){
            	System.out.println("gameOver");
            }
            
           if(profesor.getVida()<=0){
            	System.out.println("Mataste a "+ profesor.getClass().getSimpleName());
                //labelVidaProfesor.setText("Has derrotado al Profesor");
                //historiaString=historiaString+"matar <br/>"
             }
            }
	}

	public void gameOver(int vida) throws GameOverException{
            if(estudiante.getVida()<=0){
                //Gameover
            	throw new GameOverException();
            }else{
        
        	System.out.println("Blabla");
        }
        
	}
