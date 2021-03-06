package controller;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.IListaEncadenada;
import model.data_structures.IMaxColaCP;
import model.data_structures.IQueue;
import model.data_structures.MaxColaCP;
import model.data_structures.NodoLista;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/**
	 * Atributo del modelo.
	 */
	private Modelo modelo;

	/**
	 * Atributo de la vista.
	 */
	private View view;

	/**
	 * Constante con la ruta del archivo que guarda los comparnedos.
	 */
	public final static String RUTA = "./data/Comparendos_DEI_2018_Bogot�_D.C.geojson";


	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;


		while( !fin ){
			view.printMenu();
			try
			{
				int option = Integer.parseInt(lector.next());				
				switch(option){
				case 1:
					view.printMessage("--------- \nCargando lista de comparendos\n");
					try
					{
						modelo.cargarComparendos(RUTA);
						view.printMessage("�rbol de comparendos creado\n");
						view.printMessage("N�mero de comparendos guardados (n�mero de nodos del �rbol): "+modelo.darTamano());
						view.printMessage("Altura del �rbol: "+modelo.darAlturaArbol());
						
						DecimalFormat df= new DecimalFormat("0.00");
						
						view.printMessage("Altura promedio de cada rama: "+df.format(modelo.darPromedioHojas())+"\n");
						view.printMessage("MENOR: \n"+modelo.darMenorComparendo().toString());
						view.printMessage("MAYOR: \n"+modelo.darMayorComparendo().toString()+"\n");
						
					}
					catch(FileNotFoundException e)
					{
						view.printMessage("No se pudo crear la lista porque no existe el archivo de comparendos");
					}
					catch(ParseException e)
					{
						view.printMessage(e.getMessage());
					}

					break;
					
				case 2: 
					
					if(modelo.darArbol().isEmpty())
					{
						view.printMessage("Por favor inicialice los comparendos.\n");
					}
					else
					{
						try
						{
							view.printMessage("Por favor ingrese el ID del comparendo que desea buscar:\n");
							int comparendoID=Integer.parseInt(lector.next());
							Comparendo buscado=modelo.consultarComparendoID(comparendoID);
							if(buscado==null)
							{
								view.printMessage("No se encontr� un comparendo con el ID dado.\n");
							}
							else
							{
								view.printMessage(buscado.toString()+"\n");
							}
						}
						catch(Exception e)
						{
							view.printMessage("Por favor ingrese un n�mero.\n");
						}
					}
					
					break;

				case 3:
					
					if(modelo.darArbol().isEmpty())
					{
						view.printMessage("Por favor inicialice los comparendos.\n");
					}
					else
					{
						try
						{
							view.printMessage("Por favor ingrese el l�mite inferior (ID inferior):\n");
							int inf=Integer.parseInt(lector.next());
							view.printMessage("Por favor ingrese el l�mite superior (ID superior):\n");
							int sup=Integer.parseInt(lector.next());
							Iterator<Comparendo> buscado=modelo.comparendosIDRango(inf,sup);
							if(!buscado.hasNext())
							{
								view.printMessage("Rango inv�lido.\n");
							}
							else
							{
								view.printIterator(buscado);
							}
						}
						catch(Exception e)
						{
							view.printMessage("Por favor ingrese un n�mero.\n");
						}
					}
					
					break;
 
				case 4: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;

				default: 
					view.printMessage("--------- \n Opci�n Invalida !! \n---------");
					fin=true;
					break;
				}
			}
			catch(NumberFormatException e)
			{
				view.printMessage("Por favor ingrese un n�mero.\n");
			}


		}
		view.printMessage("--------- \nGracias! Vuelva pronto!");
	}	
}
