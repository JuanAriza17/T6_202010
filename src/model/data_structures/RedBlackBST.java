package model.data_structures;

import java.util.Iterator;

public class RedBlackBST<K extends Comparable<K>, V extends Comparable<V>> implements IRedBlackBST<K,V>
{

	/**
	 * Método que retorna el número de parejas [Llave, Valor] del árbol.
	 * @return Números de parejas.
	 */
	public int size() 
	{
		return 0;
	}

	/**
	 * Informa si el árbol es vacio
	 * @return True en caso de que sea vacio. False en caso contrario.
	 */
	public boolean isEmpty() 
	{
		return false;
	}

	/**
	 * Método que retorna  la altura del camino desde la raíz para llegar a la llave key (si existe).
	 * @param Llave de cual será buscada el camino.
	 * @return Altura del camino. En caso de que no exista la llave retorna -1.
	 */
	public V get(K key) 
	{
		return null;
	}

	/**
	 * Método que indica si la llave ingresada por parámetro se encuentra en el árbol.
	 * @param key  Llave que será buscada.
	 * @return
	 */
	public boolean contains(K key) 
	{
		return false;
	}

	/**
	 * Método que inserta una pareja [key, valor] en el árbol respetando el balanceo RedBlack. 
	 * Si la llave ya existe se reemplaza el valor. 
	 * Si la llave key o el valor es null se debe lanzar una Exception.
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) 
	{
		
	}

	/**
	 * Método que retorna la altura del árbol (longitud de la rama más alta).
	 * @return Altura del árbol.
	 */
	public int heigh() 
	{
		return 0;
	}

	/**
	 * Método que retorna la llave más pequeña del árbol.
	 * @return Llave más pequeña del árbol. Retorna null si el árbol está vacío.
	 */
	public K min() 
	{
		return null;
	}

	/**
	 * Método que retorna la llave más grande del árbol.
	 * @return Llave más grande del árbol. Retorna null si el árbol está vacío.
	 */
	public K max() 
	{
		return null;
	}

	/**
	 * Método que retorna todas las llaves del árbol como un iterador.
	 * @return Llaves del árbol.
	 */
	public Iterator<K> keys() 
	{
		return null;
	}

	/**
	 * Método que retorna los valores V en el árbol que estén asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el árbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna valores V en el rango establecido.
	 */
	public Iterator<V> valuesInRange(K init, K end) 
	{
		return null;
	}

	/**
	 * Método que retorna las llaves K en el árbol que estén asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el árbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna las llaves K en el rango establecido.
	 */
	public Iterator<K> keysInRange(K init, K end) 
	{
		return null;
	}

}
