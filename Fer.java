public class Fer extends Estudiante{
	private String ruta = "Fer.png";

	public Fer (int ataque,int defensa, int vida){
		super(ataque, defensa,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}