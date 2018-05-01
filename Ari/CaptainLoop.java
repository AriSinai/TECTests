public class CaptainLoop extends Profesor{
	private String imagenCompleta = "CaptainLoop.png";
	private String imagenCara = "caraCaptainLoop.png";


	public CaptainLoop (int ataque,int vida){
		super(ataque,vida);
	}

	public void setImagenCompleta(String imagenCompleta){

		this.imagenCompleta=imagenCompleta;

	}

	public String getImagenCompleta(){
		return imagenCompleta;

	}
	public void setImagenCara(String imagenCara){

		this.imagenCara=imagenCara;

	}

	public String getImagenCara(){
		return imagenCara;

	}

}