package model.data_structures;
import java.util.Iterator;

public interface IRedBlackBST<K extends Comparable<K>, V extends Comparable<V>>
{
	/**
	 * M�todo que retorna el n�mero de parejas [Llave, Valor] del �rbol.
	 * @return N�meros de parejas.
	 */
	int size();
	
	/**
	 * Informa si el �rbol es vacio
	 * @return True en caso de que sea vacio. False en caso contrario.
	 */
	boolean isEmpty();
	
	/**
	 * M�todo que retorna  la altura del camino desde la ra�z para llegar a la llave key (si existe).
	 * @param Llave de cual ser� buscada el camino.
	 * @return Altura del camino. En caso de que no exista la llave retorna -1.
	 */
	V get(K key);

	/**
	 * M�todo que indica si la llave ingresada por par�metro se encuentra en el �rbol.
	 * @param key  Llave que ser� buscada.
	 * @return
	 */
	boolean contains(K key);
	
	/**
	 * M�todo que inserta una pareja [key, valor] en el �rbol respetando el balanceo RedBlack. 
	 * Si la llave ya existe se reemplaza el valor. 
	 * Si la llave key o el valor es null se debe lanzar una Exception.
	 * @param key
	 * @param val
	 */
	void put(K key, V val);
	
	/**
	 * M�todo que retorna la altura del �rbol (longitud de la rama m�s alta).
	 * @return Altura del �rbol.
	 */
	int heigh();
	
	/**
	 * M�todo que retorna la llave m�s peque�a del �rbol.
	 * @return Llave m�s peque�a del �rbol. Retorna null si el �rbol est� vac�o.
	 */
	K min();
	
	/**
	 * M�todo que retorna la llave m�s grande del �rbol.
	 * @return Llave m�s grande del �rbol. Retorna null si el �rbol est� vac�o.
	 */
	K max();
	
	/**
	 * M�todo que retorna todas las llaves del �rbol como un iterador.
	 * @return Llaves del �rbol.
	 */
	Iterator<K>keys();
	
	/**
	 * M�todo que retorna los valores V en el �rbol que est�n asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el �rbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna valores V en el rango establecido.
	 */
	Iterator<V>valuesInRange(K init, K end);
	
	/**
	 * M�todo que retorna las llaves K en el �rbol que est�n asociados al rango de llaves dado. 
	 * Debe intentarse NO recorrer el �rbol.
	 * @param init Llave inicial donde empieza el rango.
	 * @param end Llave final del rango.
	 * @return Retorna las llaves K en el rango establecido.
	 */
	Iterator<K>keysInRange(K init, K end);
		
}
