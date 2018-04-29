public class Draculator extends Profesor{
	private String ruta = "Draculator.png";

	public Draculator (int ataque,int vida){
		super(ataque,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}