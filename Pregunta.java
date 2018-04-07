public class Pregunta 
{
	private String[] preguntasMate;
  	private String[] preguntasHisto;
  	private String[] preguntasLite;
  	private String[] preguntasProgra;
	
  	public void getPreguntasMate(String[] preguntasMate)
  	{

		preguntasMate = new preguntasMate[3];
		preguntasMate[0] = "¿Que es un polinomio?"
		preguntasMate[1] = "¿Que es el numero pi?"
		preguntasMate[2] = "El area de una circunferencia es igual a ...";
	}

	public void getPreguntasHisto(String[] preguntasHisto)
	{

		preguntasHisto = new preguntasHisto[3];
		preguntasHisto[0] = "¿Que cultura recibe el nombre de CULTURA MADRE?";
		preguntasHisto[1] = "¿Que ciudad fundaron los Mexicas";
		preguntasHisto[2] = "Mexico ha sido un imperio en dos ocasiones. ¿Que pais Europeo goberno la segunda ocasion?";
	}

	public void getPreguntasLite(String[] preguntasLite)
	{

		preguntasLite = new preguntasLite[3];
		preguntasLite[0] = "¿Quien es el autor del libro Alicia en el pais de las Maravillas?";
		preguntasLite[1] = "¿Quien creo al personaje de Sherlock Holmes?";
		preguntasLite[2] = "¿Que autores Mexicanos han obtenido el premio Cervantes?";
	}

	public void getPreguntasProgra(String[] preguntasProgra)
	{

		preguntasProgra = new preguntasProgra[3];
		preguntasProgra[0] = "Una declaracion if, ¿Cuantos else puede tener?";
		preguntasProgra[1] = "¿Cual es la diferencia entre un while loop y do while loop";
		preguntasProgra[2] = "¿Cual es la palabra reservada para el uso de una interfaz en otra clase?";
	}
	
	
	
}
