public class Casilla{

	private Profesor profesor;
	private Estudiante estudiante;
	private Item item;
	private Quiz quiz;
	private String nombreCasilla;





	public void setProfesor(Profesor profesor){

		this.profesor=profesor;
	}

	public void setEstudiante(Estudiante estudiante){

		this.estudiante=estudiante;
	}

	public Profesor getProfesor(){
		return profesor;
	}

	public Estudiante getEstudiante(){
		return estudiante;
	}

	public void setItem(Item item){

		this.item=item;
	}

	public Item getItem(){
		return item;
	}
	public void setQuiz(Quiz quiz){

		this.quiz=quiz;
	}

	public Quiz getQuiz(){
		return quiz;
	}
	public void setNombreCasilla(String nombreCasilla){

		this.nombreCasilla=nombreCasilla;
	}

	public String getNombreCasilla(){
		return nombreCasilla;
	}

}