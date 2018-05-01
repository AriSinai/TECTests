public class Pregunta{
	private String pregunta;
	private Respuesta[] respuestas;
	private Respuesta r,respuestaCorrecta;
	private Estudiante estudiante;

	public Pregunta(String pregunta){
		this.pregunta = pregunta;
		this.respuestaCorrecta = respuestaCorrecta;
		respuestas = new Respuesta[3];
	}

	public String getPregunta(){
		return pregunta;
	}

	public void setPregunta(String pregunta){
		this.pregunta = pregunta;
	}

	public void addRespuesta(Respuesta r, int indexRespuesta){
		respuestas[indexRespuesta] = r;

	}

	public Respuesta getRespuestas1(int indexRespuesta){
		return respuestas[indexRespuesta];
	}

	public Respuesta[] getRespuestas(){
		return respuestas;
	}

	public void setRespuestaCorrecta(Respuesta respuestaCorrecta){
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public Respuesta getRespuestaCorrecta(){
		return respuestaCorrecta;
	}

	public void submit(Respuesta[] respuestas, int indexRespuesta, Respuesta respuestaCorrecta){
		indexRespuesta-=1;
		try{
			if(respuestas[indexRespuesta].getRespuesta().equals(respuestaCorrecta.getRespuesta())){
				estudiante.setVida(estudiante.getVida()+20);
				System.out.println("Bien");
				
			}else{
				System.out.println("Mal");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Inserta 1, 2 o 3, porfavor");
		}
	}

}
