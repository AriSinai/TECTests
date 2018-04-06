public class Mercy extends Estudiante
{

	public Mercy(int vida, int ataque)
	{
		this.vida = vida;
		this.ataque = ataque;
	}

	public void atacar(Maestro maestro)
	{
		super(maestro);
		maestro.getVida() = maestro.getVida() - ataque;
	}
	
}
