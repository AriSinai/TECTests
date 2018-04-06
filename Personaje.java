public abstract class Personaje implements AccionesP
{
	private int ataque;
	private int vida;
	private int x;
	private int y;
	
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

	public void setAtaque(int ataque)
	{
		this.ataque = ataque;
	}
}
