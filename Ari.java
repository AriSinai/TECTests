public class Ari extends Estudiante
{
	private int vida;
	private int ataque;
	private String nombre;

	public Ari(int vida, int ataque)
	{
		this.vida = vida;
		this.ataque = ataque;
	}

	public String getNombre()
	{
		nombre = Ari;
		return nombre;
	}

	public void atacar(Maestro maestro)
	{
		super(maestro);
		maestro.getVida() = maestro.getVida() - ataque;
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

	public void setAtaque(int vida)
	{
		this.ataque = ataque;
	}
	
}