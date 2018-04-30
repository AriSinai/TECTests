

public class Pregunta{
	private String pregunta,respuestaCorrecta;
	private String[] respuestas;
	private int indexRespuesta;
	//private Estudiante estudiante;

	public Pregunta(){
		this.pregunta = pregunta;
		respuestas = new String[3];
		this.indexRespuesta = indexRespuesta;
		this.respuestaCorrecta=respuestaCorrecta;
	}

	public String getPregunta(){
		return pregunta;
	}

	public void respuestaCorrecta(String[] r,int indexrespuesta, String respuestaCorrecta){
		indexrespuesta-=1;
		try{
			if(r[indexrespuesta].equals(respuestaCorrecta)){
				//estudiante.setVida(estudiante.getVida()+20);
				System.out.println("Bien");
			}else{
				System.out.println("Mal");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Inserta 1, 2 o 3, porfavor");
		}
	}

}
