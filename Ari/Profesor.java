public class Profesor extends Personaje{
	private String imagenCompleta ;
	private String imagenCara;
	private String imagenAprobado;
	private String imagenPerdiste;

	
	public Profesor (int ataque, int vida, String imagenCompleta, String imagenCara,String imagenAprobado,String imagenPerdiste){
		super(ataque,vida);
		this.imagenCompleta=imagenCompleta;
		this.imagenCara=imagenCara;
		this.imagenAprobado=imagenAprobado;
		this.imagenPerdiste=imagenPerdiste;

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
	public void setImagenAprobado(String imagenAprobado){

		this.imagenAprobado=imagenAprobado;

	}

	public String getImagenAprobado(){
		return imagenAprobado;

	}
	public void setImagenPerdiste(String imagenPerdiste){

		this.imagenPerdiste=imagenPerdiste;

	}

	public String getImagenPerdiste(){
		return imagenPerdiste;

	}
}