public class Mercy extends Estudiante{
	private String imagenCompleta = "Mercy.png";
	private String imagenCara= "caraMercy.png";


	public Mercy (int ataque,int defensa, int vida){
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