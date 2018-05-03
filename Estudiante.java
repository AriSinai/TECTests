public class Estudiante extends Personaje{
	private int x;
	private int y;
	private String imagenCompleta ;
	private String imagenCara;


	//COntructor NUEVO
	public Estudiante (int ataque,int defensa, int vida, String imagenCompleta, String imagenCara){
		super(ataque, defensa,vida);
		this.imagenCompleta=imagenCompleta;
		this.imagenCara=imagenCara;
	}
	

	public void setX(int x){

		this.x=x;

	}

	public int getX(){
		return x;

	}
	public void setY(int y){

		this.y=y;

	}

	public int getY(){
		return y;

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