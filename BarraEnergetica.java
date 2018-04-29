public class BarraEnergetica extends Item{
	public BarraEnergetica(int aumento){
		super(aumento);
		estudiante.setAtaque(estudiante.getAtaque()+aumento);
	}
}