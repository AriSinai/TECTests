public class Estudiante extends Personaje
{
	private int x;
	private int y;
	private Maestro maestro;

	public Estudiante(int vida, int ataque, int defensa)
	{
		super(vida,ataque,defensa);
	}
	
	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	

}
