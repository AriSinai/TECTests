public class Pregunta 
{
	
	private PreguntasMate[] preguntasMate;
  private PreguntasHisto[] preguntasHisto;
  private PreguntasLite[] preguntasLite;
  private PreguntasProgra[] preguntasProgra;
	
  public void preguntarMate(Personaje personaje){

		personaje.setVida(personaje.getVida()-(ataque-personaje.getDefensa()));
	}
  
  
	
	public Campus(int row, int col)
	{
		casillas = new Casilla[][];
  }
	
	public Personaje(int ataque,int vida){ //constructor para cada profesor
		this.ataque=ataque;
		this.vida=vida;
	}
	
	public Personaje(int ataque, int defensa,int vida, String nombre){ // constructor para cada estudiante
		this.ataque=ataque;
		this.defensa=defensa;
		this.vida=vida;
		this.nombre=nombre;
	}
	
	//Ari plis checa esto !!!!!
	private String[] preguntasMate;
  	private String[] preguntasHisto;
  	private String[] preguntasLite;
  	private String[] preguntasProgra;
	
  	public void getPreguntasMate(String[] preguntasMate)
  	{

		preguntasMate = new preguntasMate[3];
		preguntasMate[0] = "¿Qué es un polinomio?"
		preguntasMate[1] = "¿Qué es el número pi?"
		preguntasMate[2] = "El área de una circunferencia es igual a ...";
	}

	public void getPreguntasHisto(String[] preguntasHisto)
	{

		preguntasHisto = new preguntasHisto[3];
		preguntasHisto[0] = "¿Qué cultura recibe el nombre de CULTURA MADRE?";
		preguntasHisto[1] = "¿Qué ciudad fundaron los Mexicas";
		preguntasHisto[2] = "México ha sido un imperio en dos ocasiones. ¿Qué país Europeo gobernó la segunda ocasión?";
	}

	public void getPreguntasLite(String[] preguntasLite)
	{

		preguntasLite = new preguntasLite[3];
		preguntasLite[0] = "¿Quién es el autor del libro Alicia en el país de las Maravillas?";
		preguntasLite[1] = "¿Quién creó al personaje de Sherlock Holmes?";
		preguntasLite[2] = "¿Qué autores Mexicanos han obtenido el premio Cervantes?";
	}

	public void getPreguntasProgra(String[] preguntasProgra)
	{

		preguntasProgra = new preguntasProgra[3];
		preguntasProgra[0] = "Una declaracioón if, ¿Cuántos else puede tener?";
		preguntasProgra[1] = "¿Cuál es la diferencia entre un while loop y do while loop";
		preguntasProgra[2] = "¿Cuál es la palabra reservada para el uso de una interfaz en otra clase?";
	}
	
	
	
}
