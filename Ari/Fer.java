public class Fer extends Estudiante{
	private String ruta = "Fer.png";
	private int ataque= 60;

	public Fer (int ataque,int defensa, int vida){
		super(ataque, defensa,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}
		
	
	public void setAtaque(int ataque){
		this.ataque=ataque;
	}
	
	public int getAtaque(){
		return ataque;
		
	}

}
