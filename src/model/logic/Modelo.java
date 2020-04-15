package model.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.IListaEncadenada;
import model.data_structures.IRedBlackBST;
import model.data_structures.ListaEncadenada;
import model.data_structures.RedBlackBST;
import model.data_structures.RedBlackBST.Node;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo { 
	
	/**
	 * Árbol RedBlackBST.
	 */
	private IRedBlackBST<Integer, Comparendo> redBlackBST;
	
	/**
	 * Lista de comparendos
	 */
	private IListaEncadenada<Comparendo> listaComparendos;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida.
	 * @post: Inicializa la lista de comparendos vacía.
	 */
	public Modelo()
	{
		redBlackBST= new RedBlackBST<Integer, Comparendo>();
		listaComparendos = new ListaEncadenada<Comparendo>();
	}

	public int darTamano()
	{
		return redBlackBST.size();
	}
	
	public int darAlturaArbol()
	{
		return redBlackBST.height();
	}
	
	public double darPromedioHojas()
	{
		Iterator<RedBlackBST<Integer, Comparendo>.Node> it= redBlackBST.darHojas();
		
		int hojas = 0;
		int altura = 0;
		while(it.hasNext())
		{
			++hojas;
			RedBlackBST<Integer, Comparendo>.Node x = it.next();
			altura += redBlackBST.getHeight(x.key);
		}
		
		double prom = (double)altura/hojas;
		return prom;
	}
	
	/**
	 * Da el mayor comparendo del árbol
	 * @return primer dato
	 */
	public Comparendo darMayorComparendo()
	{
		return redBlackBST.get(redBlackBST.max());
	}
	
	/**
	 * Da el menor comparendo del árbol
	 * @return ultimo dato
	 */
	public Comparendo darMenorComparendo()
	{
		return redBlackBST.get(redBlackBST.min());
	}
	
	/**
	 * Método que retorna el comparendo por el ID ingresado por parámetro. Se implemente el RedBlackBST.
	 * @param ID OBJECT_ID del Comparendo buscado.
	 * @return Comparendo buscado.
	 */
	public Comparendo consultarComparendoID(int ID)
	{
		return redBlackBST.get(ID);
	}
	
	/**
	 * Método que retorna un iterador de comparendos por el rango de ID dado. Se implementa el RedBlackBST.
	 * @param inf Rango inferior de ID.
	 * @param sup Rango superior de ID.
	 * @return Comparendo buscado.
	 */
	public Iterator<Comparendo> comparendosIDRango(int inf, int sup)
	{
		return redBlackBST.valuesInRange(inf, sup);
	}
	
	/**
	 * Método que retorna el árbol.
	 * @return Retorna el árbol rojo-negro.
	 */
	public IRedBlackBST<Integer, Comparendo> darArbol()
	{
		return redBlackBST;
	}
	
	/**
	 * Método que retorna la lista de comparendos.
	 * @return Lista de comaparendos.
	 */
	public IListaEncadenada<Comparendo> darLista()
	{
		return listaComparendos;
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo .
	 * @return numero de elementos presentes en el modelo.
	 */
	public int darLongitud()
	{
		return listaComparendos.darLongitud();
	}
	
	/**
	 * Agregar dato al final.
	 * @param dato Comparendo que llega por parámetro.
	 */
	public void agregarFinal(Comparendo dato)
	{
		listaComparendos.agregarFinal(dato);
	}
	
	/**
	 * Requerimiento de agregar dato.
	 * @param dato Comparendo que llega por parámetro.
	 */
	public void agregar(Comparendo dato)
	{
		listaComparendos.agregar(dato);
	}
	
	
	/**
	 * Requerimiento buscar dato.
	 * @param dato Dato a buscar.
	 * @return dato Comparendo encontrado.
	 */
	public Comparendo buscar(Comparendo dato)
	{
		return listaComparendos.buscar(dato);
	}
	
	/**
	 * Elimina un dato.
	 * @param dato Dato a eliminar.
	 * @return dato Comparendo eliminado.
	 */
	public Comparendo eliminar(Comparendo dato)
	{
		return listaComparendos.eliminar(dato);
	}
	
	/**
	 * Método que carga los comparendos
	 * @param ruta Rita archivo con los comparendos
	 * @throws FileNotFoundException si no encuentra el archivo
	 */
	public void cargarComparendos(String ruta) throws FileNotFoundException, ParseException 
	{
		 File archivo = new File(ruta);
		 
		 redBlackBST = new RedBlackBST<Integer, Comparendo>();
		 listaComparendos = new ListaEncadenada<Comparendo>();
		 
		 JsonReader lector = new JsonReader(new FileReader(archivo));
		 JsonObject obj = JsonParser.parseReader(lector).getAsJsonObject();
		 
		 JsonArray arregloComparendos = obj.get("features").getAsJsonArray();  
		 		 
		 SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		 		
		 
		 for (JsonElement e: arregloComparendos) 	
		 {
			
			JsonObject propiedades = e.getAsJsonObject().get("properties").getAsJsonObject();
			
			int id = propiedades.get("OBJECTID").getAsInt();
			String f = propiedades.get("FECHA_HORA").getAsString();
			Date fecha = parser.parse(f);
			String vehiculo = propiedades.get("CLASE_VEHICULO").getAsString();
			String servicio = propiedades.get("TIPO_SERVICIO").getAsString();
			String infraccion = propiedades.get("INFRACCION").getAsString();
			String descripcion = propiedades.get("DES_INFRACCION").getAsString();
			String localidad = propiedades.get("LOCALIDAD").getAsString();

			JsonObject geometria = e.getAsJsonObject().get("geometry").getAsJsonObject();
			JsonArray coords = geometria.get("coordinates").getAsJsonArray();
			double[] coordenadas = new double[2];
			
			for (int j = 0; j < coordenadas.length; j++) 
			{
				coordenadas[j]=coords.get(j).getAsDouble();
			}
						
			Comparendo comparendo = new Comparendo(id, fecha, vehiculo, servicio, infraccion, descripcion, localidad,coordenadas);
			
			redBlackBST.put(id, comparendo);
		 }
	}
	
	/**
	 * Método que carga los comparendos
	 * @param ruta Rita archivo con los comparendos
	 * @throws FileNotFoundException si no encuentra el archivo
	 */
	public void cargarComparendosTest(String ruta) throws FileNotFoundException, ParseException 
	{
		 File archivo = new File(ruta);
		 
		 listaComparendos = new ListaEncadenada<Comparendo>();
		 
		 JsonReader lector = new JsonReader(new FileReader(archivo));
		 JsonObject obj = JsonParser.parseReader(lector).getAsJsonObject();
		 
		 JsonArray arregloComparendos = obj.get("features").getAsJsonArray();  
		 		 
		 SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		 		
		 
		 for (JsonElement e: arregloComparendos) 	
		 {
			
			JsonObject propiedades = e.getAsJsonObject().get("properties").getAsJsonObject();
			
			int id = propiedades.get("OBJECTID").getAsInt();
			String f = propiedades.get("FECHA_HORA").getAsString();
			Date fecha = parser.parse(f);
			String vehiculo = propiedades.get("CLASE_VEHICULO").getAsString();
			String servicio = propiedades.get("TIPO_SERVICIO").getAsString();
			String infraccion = propiedades.get("INFRACCION").getAsString();
			String descripcion = propiedades.get("DES_INFRACCION").getAsString();
			String localidad = propiedades.get("LOCALIDAD").getAsString();

			JsonObject geometria = e.getAsJsonObject().get("geometry").getAsJsonObject();
			JsonArray coords = geometria.get("coordinates").getAsJsonArray();
			double[] coordenadas = new double[2];
			
			for (int j = 0; j < coordenadas.length; j++) 
			{
				coordenadas[j]=coords.get(j).getAsDouble();
			}
						
			Comparendo comparendo = new Comparendo(id, fecha, vehiculo, servicio, infraccion, descripcion, localidad,coordenadas);
			
			agregarFinal(comparendo);
		 }
	}
}
