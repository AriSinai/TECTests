public class Redbull extends Item{
	private String ruta= "Redbull.png";

	public Redbull(String nombre){
		super(nombre);

		
	}
	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}
}