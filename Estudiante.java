public class Estudiante extends Personaje
{


	public Estudiante(int ataque, int defensa,int vida, String nombre)
	{
		super(ataque,defensa,vida,nombre);
	}
	
	public void atacar(Personaje estudiante)
	{
		estudiante.setVida(estudiante.getVida()-get.ataque());
	}
	


}
