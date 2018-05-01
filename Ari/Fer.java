public class Fer extends Estudiante{
	private String imagenCompleta = "Fer.png";
	private String imagenCara= "caraFer.png";


	public Fer (int ataque,int defensa, int vida){
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