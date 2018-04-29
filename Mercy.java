public class Mercy extends Estudiante{
	private String ruta = "Mercy.png";

	public Mercy (int ataque,int defensa, int vida){
		super(ataque, defensa,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}