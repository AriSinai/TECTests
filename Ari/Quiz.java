public abstract class Quiz{
	private String nombre;

	public Quiz(String nombre){
		this.nombre=nombre;

	}

	public void setNombre(String nombre){

		this.nombre=nombre;

	}

	public String getNombre(){
		return nombre;

	}
	
}