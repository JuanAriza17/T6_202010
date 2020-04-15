package model.data_structures;
import java.util.Iterator;

public interface IRedBlackBST<K extends Comparable<K>, V extends Comparable<V>>
{
	/**
	 * Método que retorna el número de parejas [Llave, Valor] del árbol.
	 * @return Números de parejas.
	 */
	int size();
	
	/**
	 * Informa si el árbol es vacio
	 * @return True en caso de que sea vacio. False en caso contrario.
	 */
	boolean isEmpty();
	
	/**
	 * Método que retorna  la altura del camino desde la raíz para llegar a la llave key (si existe).
	 * @param Llave de cual será buscada el camino.
	 * @return Altura del camino. En caso de que no exista la llave retorna -1.
	 */
	V get(K key);

	/**
	 * Método que indica si la llave ingresada por parámetro se encuentra en el árbol.
	 * @param key  Llave que será buscada.
	 * @return
	 */
	boolean contains(K key);
	
	/**
	 * Método que inserta una pareja [key, valor] en el árbol respetando el balanceo RedBlack. 
	 * Si la llave ya existe se reemplaza el valor. 
	 * Si la llave key o el valor es null se debe lanzar una Exception.
	 * @param key
	 * @param val
	 */
	void put(K key, V val);
	
	/**
	 * Método que retorna la altura del árbol (longitud de la rama más alta).
	 * @return Altura del árbol.
	 */
	int heigh();
	
	/**
	 * Método que retorna la llave más pequeña del árbol.
	 * @return Llave más pequeña del árbol. Retorna null si el árbol está vacío.
	 */
	K min();
	
	/**
	 * Método que retorna la llave más grande del árbol.
	 * @return Llave más grande del árbol. Retorna null si el árbol está vacío.
	 */
	K max();
	
	/**
	 * Método que retorna todas las llaves del árbol como un iterador.
	 * @return Llaves del árbol.
	 */
	Iterator<K>keys();
	
	/**
	 * Método que retorna los valores V en el árbol que estén asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el árbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna valores V en el rango establecido.
	 */
	Iterator<V>valuesInRange(K init, K end);
	
	/**
	 * Método que retorna las llaves K en el árbol que estén asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el árbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna las llaves K en el rango establecido.
	 */
	Iterator<K>keysInRange(K init, K end);
		
}
