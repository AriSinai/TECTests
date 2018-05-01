public class Campus{
	
	private Casilla [][] casillas;

	public Campus(int rows, int cols){
		casillas= new Casilla[rows][cols];
	}
	
	
	public void setCasillas(Casilla[][] casillas){
		this.casillas=casillas;
		
	public Casilla[][] getCasillas(){
		return casillas;
	}
	
	
}
