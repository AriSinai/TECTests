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
	
	
	
	
}
