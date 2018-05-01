public class Ari extends Estudiante{
	private String imagenCompleta = "Ari.png";
	private String imagenCara= "caraAri.png";

	public Ari (int ataque,int defensa, int vida){
		super(ataque, defensa,vida);
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