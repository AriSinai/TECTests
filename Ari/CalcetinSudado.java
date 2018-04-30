public class CalcetinSudado extends Item{

	private String ruta= "CalcetinSudado.png";

	public CalcetinSudado(String nombre){
		super(nombre);

		
	}
	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}
}