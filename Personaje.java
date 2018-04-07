public abstract class Personaje implements AccionesP
{
	private int ataque;
	private int vida;
	private int defensa;
	
	public Personaje(int ataque,int vida){ //constructor para cada profesor
		this.ataque=ataque;
		this.vida=vida;
	}
	
	public Personaje(int ataque, int defensa,int vida){ // constructor para cada estudiante
		this.ataque=ataque;
		this.defensa=defensa;
		this.vida=vida;
		
	}
	
	public void setDefensa(int defensa)
	{
		this.defensa = defensa;
	}
	
	public int getDefensa()
	{
		return defensa;
	}
	
	public int getVida()
	{
		return vida;
	}

	public void setVida(int vida)
	{
		this.vida = vida;
	}

	public int getAtaque()
	{
		return ataque;
	}

	public void setAtaque(int ataque)
	{
		this.ataque = ataque;
	}
	
	public void atacar(Personaje personaje){

		personaje.setVida(personaje.getVida()-(ataque-personaje.getDefensa()));
	}
	
}
