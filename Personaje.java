public abstract class Personaje implements AccionesP
{
	private int ataque;
	private int vida;
	private int defensa;
	
	public abstract void atacar(Personaje personaje);
	
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
