public class Megafono extends Item{
	private String ruta= "Megafono.png";

	public Megafono(String nombre){
		super(nombre);	
	}
	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}
}