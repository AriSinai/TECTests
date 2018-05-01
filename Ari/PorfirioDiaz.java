public class PorfirioDiaz extends Profesor{
	private String imagenCompleta = "PorfirioDiaz.png";
	private String imagenCara = "caraPorfirioDiaz.png";

	public PorfirioDiaz (int ataque,int vida){
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