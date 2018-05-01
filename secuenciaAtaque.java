//secuencia de ataque en ventana


     if(estudiante.getClass().equals("Ari")){
        estudianteActual= "Ari";
    }else if(estudiante.getClass().equals("Mercy")){
        estudianteActual= "Mercy";
    }else if(estudiante.getClass().equals("Fer")){
        estudianteActual= "Fer";
    }


    if(profesor.getClass().equals("CaptainLoop")){
        profesorActual= "CaptainLoop";
    }else if(profesor.getClass().equals("HannibalLecturas")){
        profesorActual= "HannibalLecturas";
    }else if(profesor.getClass().equals("Draculator")){
        profesorActual= "Draculator";

    }else if(profesor.getClass().equals("PorfirioGuiaz")){
        profesorActual="PorfirioGuiaz";
    }




        public class atacarActionListener implements ActionListener{
            public void actionPerformed (ActionEvent e){
                    estudianteActual.atacar(profesorActual);
                    profesorActual.atacar(estudianteActual);
                    imprimirStatsEstudiante();
                    imprimirStatsProfesor();
                    if(estudianteActual.getVida()<=0){
                        //Gameover

                    }
                    if(profesorActual.getVida<=0){
                        labelVidaProfesor.setText("Has derrotado al Profesor");
                        historiaString=historiaString+"matar <br/>"
                    }
            }

        }
