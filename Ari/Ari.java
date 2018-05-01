public class Ari extends Estudiante{
	private String ruta = "Ari.png";
	private int ataque = 60;

	public Ari (int ataque,int defensa, int vida){
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
