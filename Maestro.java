public class Maestro extends Personaje
{
	private int posX,posY;
	
	public int ataque;
	public int vida;
	public Villano(int ataque, vida){
		this.ataque=ataque;
		this.vida=vida;
	}

	
	public Maestro(int vida, int ataque)
	{
		this.vida = vida;
		this.ataque = ataque;
	}
	
	public void setPosX(int posX){
		this.posX=posX;
	}

	public int getPosX(){
		return posX;
	}
	public void setPosY(int posY){
		this.posY=posY;
	}

	public int getPosY(){
		return posY;
	}
	
	
	public void atacar(Estudiante estudiante)
	{
		estudiante.setVida(estudiante.getVida()-get.ataque());
	}

	

}
