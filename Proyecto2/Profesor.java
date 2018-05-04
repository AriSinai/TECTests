import java.io.Serializable;
public class Profesor extends Personaje{
	private String imagenCompleta ;
	private String imagenCara;
	private String imagenAprobado;
	private String imagenPerdiste;
	private static int count=0;

	
	public Profesor (int ataque, int vida, String imagenCompleta, String imagenCara,String imagenAprobado,String imagenPerdiste){
		super(ataque,vida);
		this.imagenCompleta=imagenCompleta;
		this.imagenCara=imagenCara;
		this.imagenAprobado=imagenAprobado;
		this.imagenPerdiste=imagenPerdiste;

	}

	/*
	public Profesor (String imagenCompleta, String imagenCara,String imagenAprobado,String imagenPerdiste){
		
		this.imagenCompleta=imagenCompleta;
		this.imagenCara=imagenCara;
		this.imagenAprobado=imagenAprobado;
		this.imagenPerdiste=imagenPerdiste;

	}
	*/
	

	public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Profesor.count = count;
    }
    public static void incrementarContador(){
        count++;
    }
    public static void disminuirContador(){
        count--;
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
