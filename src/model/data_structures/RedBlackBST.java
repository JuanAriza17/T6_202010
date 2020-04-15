package model.data_structures;

import java.util.Iterator;

public class RedBlackBST<K extends Comparable<K>, V extends Comparable<V>> implements IRedBlackBST<K,V>
{

	/**
	 * M�todo que retorna el n�mero de parejas [Llave, Valor] del �rbol.
	 * @return N�meros de parejas.
	 */
	public int size() 
	{
		return 0;
	}

	/**
	 * Informa si el �rbol es vacio
	 * @return True en caso de que sea vacio. False en caso contrario.
	 */
	public boolean isEmpty() 
	{
		return false;
	}

	/**
	 * M�todo que retorna  la altura del camino desde la ra�z para llegar a la llave key (si existe).
	 * @param Llave de cual ser� buscada el camino.
	 * @return Altura del camino. En caso de que no exista la llave retorna -1.
	 */
	public V get(K key) 
	{
		return null;
	}

	/**
	 * M�todo que indica si la llave ingresada por par�metro se encuentra en el �rbol.
	 * @param key  Llave que ser� buscada.
	 * @return
	 */
	public boolean contains(K key) 
	{
		return false;
	}

	/**
	 * M�todo que inserta una pareja [key, valor] en el �rbol respetando el balanceo RedBlack. 
	 * Si la llave ya existe se reemplaza el valor. 
	 * Si la llave key o el valor es null se debe lanzar una Exception.
	 * @param key
	 * @param val
	 */
	public void put(K key, V val) 
	{
		
	}

	/**
	 * M�todo que retorna la altura del �rbol (longitud de la rama m�s alta).
	 * @return Altura del �rbol.
	 */
	public int heigh() 
	{
		return 0;
	}

	/**
	 * M�todo que retorna la llave m�s peque�a del �rbol.
	 * @return Llave m�s peque�a del �rbol. Retorna null si el �rbol est� vac�o.
	 */
	public K min() 
	{
		return null;
	}

	/**
	 * M�todo que retorna la llave m�s grande del �rbol.
	 * @return Llave m�s grande del �rbol. Retorna null si el �rbol est� vac�o.
	 */
	public K max() 
	{
		return null;
	}

	/**
	 * M�todo que retorna todas las llaves del �rbol como un iterador.
	 * @return Llaves del �rbol.
	 */
	public Iterator<K> keys() 
	{
		return null;
	}

	/**
	 * M�todo que retorna los valores V en el �rbol que est�n asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el �rbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna valores V en el rango establecido.
	 */
	public Iterator<V> valuesInRange(K init, K end) 
	{
		return null;
	}

	/**
	 * M�todo que retorna las llaves K en el �rbol que est�n asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el �rbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna las llaves K en el rango establecido.
	 */
	public Iterator<K> keysInRange(K init, K end) 
	{
		return null;
	}

}
