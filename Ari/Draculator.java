public class Draculator extends Profesor{
	private String imagenCompleta = "Draculator.png";
	private String imagenCara = "caraDraculator.png";

	public Draculator (int ataque,int vida){
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