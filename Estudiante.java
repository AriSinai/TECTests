public class Estudiante extends Personaje
{

	private Item[] items;
	private int posX;
	private int posY;
	private String nombre;

	public Estudiante(int ataque, int defensa,int vida)
	{
		super(ataque,defensa,vida);
		ataque = 15;
		defensa = 60;
		vida=100;
		this.nombre=nombre;
	}
	public void setNombre (String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void addItem(Item item,int index){
		items[index]=item;
	}
	public void removeItem(int index){
		items[index]=null;
	}
	public Item[] getItems(){
		return items;
	}
	
	public void setPosX(int posX){
		this.posX=posX;
	}

	public int getPosX(){
		return posX;
	}
	public void setPosY(int posY){
		this.posY=posY;
	}

	public int getPosY(){
		return posY;
	}
	
	
	public int aumentarVida(Estudiante estudiante){
		estudiante.setVida(estudiante.getVida()+50);
	
	}
	public int aumentarDefensa(Estudiante estudiante){
		estudiante.setDefensa(estudiante.getDefensa()+15);
	
	}
	public int aumentarAtaque(Estudiante estudiante){
		estudiante.setAtaque(estudiante.getAtaque()+10);
	
	}
	
	public void atacar (Personaje p){

		Maestro m= (Maestro) p;

		m.vida=m.vida - ataque;
	}
	
	
	
	
	


}
