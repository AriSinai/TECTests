public class Estudiante extends Personaje
{


	public Estudiante(int vida, int ataque, int defensa)
	{
		super(vida,ataque,defensa);
	}
	
	public void atacar(Personaje estudiante)
	{
		estudiante.setVida(estudiante.getVida()-get.ataque());
	}
	


}
