public class CaptainLoop extends Profesor{
	private String ruta = "CaptainLoop.png";


	public CaptainLoop (int ataque,int vida){
		super(ataque,vida);
	}

	public void setRuta(String ruta){

		this.ruta=ruta;

	}

	public String getRuta(){
		return ruta;

	}

}