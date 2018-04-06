public class Item
{
  
  private Estudiante estudiante;
  private int valorItem1, valorItem2, valorItem3;
  
  public int getValorItem1(Estudiante estudiante)
  {
    retrun estudiante.getVida() + 50;
  }
   
  public int getValorItem2(Estudiante estudiante)
  {
    retrun estudiante.getVida() + 30;
  }
  
  public int getValorItem1(Estudiante estudiante)
  {
    retrun estudiante.getAtaque() + 15;
  }
}
