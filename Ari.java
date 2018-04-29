public class Ari extends Estudiante{
	private String ruta = "Ari.png";

	public Ari (int ataque,int defensa, int vida){
		super(ataque, defensa,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}