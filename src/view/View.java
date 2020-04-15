package view;

import java.util.Iterator;

import model.data_structures.IListaEncadenada;
import model.logic.Comparendo;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
	    /**
	     * Menú de presentación para el usuario.
	     */
		public void printMenu()
		{
			System.out.println("1. (Requerimiento 01) Cargar Comparendos en la Lista.");
			System.out.println("2. (Requerimiento 02) Consultar comparendo por ID.");
			System.out.println("3. (Requerimiento 03) Consultar los comparendos con un id en un rango específico.");
			System.out.println("4. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		/**
		 * Método que imprime un mensaje genérico
		 * @param mensaje Mensaje ingresado.
		 */
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		/**
		 * Método que imprime el toString() de la lista de comparendos ingresada por parámetro.
		 * @param lista Lista de comparendos.
		 */
		public void printLista(IListaEncadenada<Comparendo> lista)
		{
			while(lista.darLongitud()>0)
			{
				System.out.println(lista.eliminarPrimero().toString());
			}	
		}
		
		/**
		 * Método que imprime el toString() del iterator de comparendos ingresado por parámetro.
		 * @param lista Lista de comparendos.
		 */
		public void printIterator(Iterator<Comparendo> iterator)
		{
			while(iterator.hasNext())
			{
				System.out.println(iterator.next().toString());
			}
			System.out.println("\n");
		}
		
		
}
