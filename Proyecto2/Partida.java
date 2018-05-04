import java.io.Serializable;
public class Partida implements Serializable{
	private Estudiante estudiante;
	private Campus campus;
	

	public Partida(Estudiante estudiante, Campus campus){
		this.estudiante= estudiante;
		this.campus=campus;
		
	}

	public void setEstudiante(Estudiante estudiante){
		this.estudiante= estudiante;
	}

	public Estudiante getEstudiante(){
		return estudiante;
	}
	public void setCampus(Campus campus){
		this.campus= campus;
	}

	public Campus getCampus(){
		return campus;
	}

}
