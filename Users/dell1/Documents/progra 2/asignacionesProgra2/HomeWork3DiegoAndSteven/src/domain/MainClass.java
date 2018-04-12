package  domain;



class MainClass
{
	static final int X_MAPA = 50;
	static final int Y_MAPA = 50;
	static final int ANCHO_MAPA = 1280;					
	static final int ALTO_MAPA = 720;					
	static final int TIEMPO_ESPERA = 1200;				

	public static void main(String[] args) throws InterruptedException
        {
		DisplayFrame myFrame = new DisplayFrame(X_MAPA, Y_MAPA, ANCHO_MAPA, ALTO_MAPA);
		Simulator mySimulator = new Simulator(myFrame);
	

		myFrame.setVisible(true);
		mySimulator.startSimulation(TIEMPO_ESPERA);
	}

}
