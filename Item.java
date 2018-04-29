public class Item
{
  private String nombre;
  private int aumento;
  private ImageIcon imagen;
  
  	public Item(String nombre, int aumento){
		this.nombre=nombre;
		this.aumento=aumento;
	}
	public void addImagen(ImageIcon imagen){
	}

	public ImageIcon removeImagen(){
	}
	
	//En la ventana determinamos el nombre del item y llamamos al metodo que nos importe (platano,100)
	public void itemVida(String nombre,int aumento){
		estudiante.setVida(estudiante.getVida()+aumento);
	}
	
	public void itemAtaque(String nombre,int aumento){
		estudiante.setAtaque(estudiante.setAtaque()+aumento);
	}
}
