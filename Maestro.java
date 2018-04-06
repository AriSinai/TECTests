public class Maestro extends Personaje
{
	private Estudiante estudiante;
	
	public Maestro(int vida, int ataque)
	{
		this.vida = vida;
		this.ataque = ataque;
	}
	
	
	public void atacar(Personaje estudiante)
	{
		estudiante.setVida(estudiante.getVida()-get.ataque());
	}

	

}
