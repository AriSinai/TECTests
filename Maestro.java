public class Maestro extends Personaje
{
	private int x,y;
	private Estudiante estudiante;
	
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
	
	
	public void atacar(Personaje estudiante)
	{
		estudiante.setVida(estudiante.getVida()-get.ataque());
	}

	

}
