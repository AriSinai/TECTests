public class Profesor extends Personaje{
	private String imagenCompleta ;
	private String imagenCara;
	
	public Profesor (int ataque, int vida, String imagenCompleta, String imagenCara){
		super(ataque,vida);
		this.imagenCompleta=imagenCompleta;
		this.imagenCara=imagenCara;
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