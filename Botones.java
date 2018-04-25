	public class BIzquierdaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.y= estudiante.y-1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			panelPrincipal.remove(panelMapa);
			pPrincipal.revalidate();
			pPrincipal.repaint();
			pintarMapa();


		}
	}

	public class BDerechaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.y= estudiante.y+1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			panelPrincipal.remove(panelMapa);
			pPrincipal.revalidate();
			pPrincipal.repaint();
			pintarMapa();


		}
	}

	public class BArribaListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.x= estudiante.x-1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			panelPrincipal.remove(panelMapa);
			panelPrincipal.revalidate();
			panelPrincipal.repaint();
			pintarMapa();


		}
	}

	public class BAbajoListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			campus.casillas[estudiante.x][estudiante.y].estudiante= null;
			estudiante.x= estudiante.x+1;
			campus.casillas[estudiante.x][estudiante.y].estudiante= estudiante;
			panelPrincipal.remove(panelMapa);
			panelPrincipal.revalidate();
			panelPrincipal.repaint();
			pintarMapa();


		}
	}