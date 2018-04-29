public class Cupones extends Item{
	public Cupones(int aumento){
		super(aumento);
		estudiante.setDefensa(estudiante.getDefensa()+aumento);
	}
}