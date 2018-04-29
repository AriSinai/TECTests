public class Redbull extends Item{

	public Redbull(int aumento){
		super(aumento);
		estudiante.setVida(estudiante.getVida()+aumento);
	}
}