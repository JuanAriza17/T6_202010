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
	public final static String RUTA = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";


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
		String fecha = "";
		String vehiculo = "";
		String infraccion = "";
		boolean fin = false;
		int id = 0;
		int valor = 0;


		while( !fin ){
			view.printMenu();
			try
			{
				int option = Integer.parseInt(lector.next());				
				switch(option){
				case 1:
					view.printMessage("--------- \nCargando lista de comparendos");
					try
					{
						modelo.cargarComparendos(RUTA);
						view.printMessage("Lista de comparendos creada");
						view.printMessage("Número de comparendos guardados: "+modelo.darLongitud());
						view.printMessage("PRIMERO: \n"+modelo.darPrimerComparendo().toString());
						view.printMessage("ÚLTIMO: \n"+modelo.darUltimoComparendo().toString()+"\n");
						
						double num1 = (double)modelo.numeroTuplasLinear()/modelo.tamanoLinear();
						double num2= (double)modelo.numeroTuplasSeparate()/modelo.tamanoSeparate();
						DecimalFormat formato = new DecimalFormat("0.00");
						
						view.printMessage("                                  Linear Probing          Separate Chaining");
						view.printMessage("Número de tuplas                  "+modelo.numeroTuplasLinear()+"                   "+modelo.numeroTuplasSeparate());
						view.printMessage("Tamaño inicial del arreglo        5                       5");
						view.printMessage("Tamaño final del arreglo          "+modelo.tamanoLinear()+"                   "+modelo.tamanoSeparate());
						view.printMessage("Factor de carga final (N/M)       "+formato.format(num1)+"                    "+formato.format(num2));
						view.printMessage("Número de rehashes realizados     "+modelo.numeroRehashesLinear()+"                       "+modelo.numeroRehashesSeparate());
						view.printMessage("\n");
						
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
								view.printMessage("No se encontró un comparendo con el ID dado.\n");
							}
							else
							{
								view.printMessage(buscado.toString()+"\n");
							}
						}
						catch(Exception e)
						{
							view.printMessage("Por favor ingrese un número.\n");
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
							view.printMessage("Por favor ingrese el límite inferior (ID inferior):\n");
							int inf=Integer.parseInt(lector.next());
							view.printMessage("Por favor ingrese el límite superior (ID superior):\n");
							int sup=Integer.parseInt(lector.next());
							Iterator<Comparendo> buscado=modelo.comparendosIDRango(inf,sup);
							if(!buscado.hasNext())
							{
								view.printMessage("Rango inválido.\n");
							}
							else
							{
								view.printIterator(buscado);
							}
						}
						catch(Exception e)
						{
							view.printMessage("Por favor ingrese un número.\n");
						}
					}
					
					break;

				case 4: 
					if(modelo.darLongitud()==0)
					{
						view.printMessage("Aún no ha inicializado las tablas de hash");
					}
					else
					{
						view.printMessage(modelo.pruebaDesempeño());
					}
					break;

				default: 
					view.printMessage("--------- \n Opción Invalida !! \n---------");
					fin=true;
					break;
				}
			}
			catch(NumberFormatException e)
			{
				view.printMessage("Por favor ingrese un número.\n");
			}


		}
		view.printMessage("--------- \nGracias! Vuelva pronto!");
	}	
}
