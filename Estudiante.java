public class Estudiante extends Personaje{
	private int x,y;
	
	public Estudiante (int ataque,int defensa, int vida){
		super(ataque, defensa,vida);
	}
	
	public void setX(int x){
		this.x=x;
	}

	public int getX(){
		return x;
	}

	public void setY(int y){
		this.y=y;
	}

	public int getY(){
		return y;
	}

	
}
