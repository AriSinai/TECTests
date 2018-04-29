public class PorfirioDiaz extends Profesor{
	private String ruta = "PorfirioDiaz.png";

	public PorfirioDiaz (int ataque,int vida){
		super(ataque,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}