public class HannibalLecturas extends Profesor{
	private String ruta = "HannibalLecturas.png";

	public HannibalLecturas (int ataque,int vida){
		super(ataque,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}