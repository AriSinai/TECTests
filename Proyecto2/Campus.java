import java.io.Serializable;
public class Campus implements Serializable{
	
	public Casilla [][] casillas;

	public Campus(int rows, int cols){
		casillas= new Casilla[rows][cols];
	}
}
