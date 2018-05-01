public class HannibalLecturas extends Profesor{
	private String imagenCompleta = "HannibalLecturas.png";
	private String imagenCara = "caraHannibalLecturas.png";

	public HannibalLecturas (int ataque,int vida){
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