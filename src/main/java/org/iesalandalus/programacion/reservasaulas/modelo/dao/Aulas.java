package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

/**
 * Clase que guarda y define las operaciones que se pueden realizar sobre un conjunto de aulas.
 * @see Aula
 * @author Juan Antonio Manzano Plaza
 * @version 2
 *
 */
public class Aulas {

	private List<Aula> coleccionAulas;

	/**
	 * Constructor por defecto. Inicializa la colecci�n.
	 */
	public Aulas() {
		coleccionAulas = new ArrayList<Aula>();
	}

	/**
	 * Constructor copia. Realiza copia profunda para evitar aliasing
	 * @param aulas el objeto del que obtener los datos para inicializar
	 * @throws IllegalArgumentException si recibe un objeto Aulas nulo
	 */
	public Aulas(Aulas aulas) throws IllegalArgumentException {
		setAulas(aulas);
	}

	/**
	 * Guarda en la colecci�n actual de aulas los que hay en la recibida como par�metro
	 * @param aulas la colecci�n a copiar
	 * @throws IllegalArgumentException si se intenta copiar un conjunto de aulas nulas
	 */
	private void setAulas(Aulas aulas) throws IllegalArgumentException {
		if(aulas==null)
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		this.coleccionAulas = copiaProfundaAulas(aulas.getAulas());
	}

	/**
	 * Realiza la copia en profundidad de cada profesor para evitar aliasing
	 * @param coleccionAulas la colecci�n de aulas a copiar
	 * @return una copia de la colecci�n
	 */
	private List<Aula> copiaProfundaAulas(List<Aula> aulas) {
		List<Aula> copia = new ArrayList<Aula>();
		for(Aula a: aulas)
			copia.add(new Aula(a));
		return copia;
	}

	/**
	 * Obtiene todas las aulas de la colecci�n actual
	 * @return una copia de la colecci�n
	 */
	public List<Aula> getAulas() {
		return copiaProfundaAulas(this.coleccionAulas);
	}

	/**
	 * Obtiene el n�mero de aulas que existen en la colecci�n actual
	 * @return el n�mero de aulas
	 */
	public int getNumAulas() {
		return this.coleccionAulas.size();
	}

	/**
	 * Guarda un aula en la colecci�n
	 * @param aula el aula a guardar
	 * @throws IllegalArgumentException si el aula es nula
	 * @throws OperationNotSupportedException si el aula ya existe
	 */
	public void insertar(Aula aula) throws OperationNotSupportedException, IllegalArgumentException {
		if(aula==null)
			throw new IllegalArgumentException("No se puede insertar un aula nula.");
		if(this.coleccionAulas.contains(aula))
			throw new OperationNotSupportedException("El aula ya existe.");
		coleccionAulas.add(aula);
	}

	/**
	 * Busca un aula en la colecci�n
	 * @param aula el aula a buscar
	 * @return el aula buscada o null si no la encuentra
	 */
	public Aula buscar(Aula aula) {
		if(aula==null)
			return null;
		if(this.coleccionAulas.indexOf(aula) == -1)
			return null;
		return this.coleccionAulas.get(this.coleccionAulas.indexOf(aula));
	}

	/**
	 * Borra un aula de la colecci�n
	 * @param aula el aula a borrar
	 * @throws IllegalArgumentException si el aula es nula
	 * @throws OperationNotSupportedException si el aula no existe
	 */
	public void borrar(Aula aula) throws OperationNotSupportedException, IllegalArgumentException {
		if(aula==null)
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		if(!this.coleccionAulas.remove(aula))
			throw new OperationNotSupportedException("El aula a borrar no existe.");
	}

	/**
	 * Obtiene las salidas de todas las aulas de la colecci�n
	 * @return la salida de las aulas
	 */
	public List<String> representar() {
		List<String> representar = new ArrayList<String>();
		for (Aula a : this.coleccionAulas)
			representar.add(a.toString());
		return representar;
	}

}
