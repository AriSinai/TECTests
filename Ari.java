public class Ari extends Estudiante
{

	public void atacar(Maestro maestro)
	{
		super(maestro);
		maestro.getVida() = maestro.getVida() - ataque;
	}

	
	
}
