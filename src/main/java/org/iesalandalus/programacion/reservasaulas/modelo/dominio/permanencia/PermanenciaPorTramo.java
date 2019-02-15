package org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa un tramo de reservas Reserva
 * @author Juan Antonio Manzano Plaza
 * @version 2
 *
 */
public class PermanenciaPorTramo extends Permanencia {

	private static final int PUNTOS = 10;
	private Tramo tramo;

	/**
	 * Constructor de la clase
	 * @param dia el día que es reservada el aula
	 * @param tramo el tramo para el que es reservada el aula
	 */
	public PermanenciaPorTramo(LocalDate dia, Tramo tramo) {
		super(dia);
		setTramo(tramo);
	}

	/**
	 * Constructor de la clase
	 * @param dia el día que es reservada el aula
	 * @param tramo el tramo para el que es reservada el aula
	 */
	public PermanenciaPorTramo(String dia, Tramo tramo) {
		super(dia);
		setTramo(tramo);
	}

	/**
	 * Constructor copia
	 * @param otra la permanencia a copiar
	 */
	public PermanenciaPorTramo(PermanenciaPorTramo otra) {
		if(otra==null)
			throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
		setDia(otra.getDia());
		setTramo(otra.getTramo());
	}

	/**
	 * Método get para el tramo de la reserva
	 * @return el tramo para el que es reservada el aula
	 */
	public Tramo getTramo() {
		return tramo;
	}

	/**
	 * Método set para el tramo de la reserva
	 * @param tramo el tramo para el que es reservada el aula
	 */
	private void setTramo(Tramo tramo) {
		if(tramo==null)
			throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
		this.tramo = tramo;
	}

	/**
	 * Método get para el número de puntos que cuesta reservar esta Permanencia
	 * @return el número de puntos que cuesta reservar esta Permanencia
	 */
	public int getPuntos() {
		return PUNTOS;
	}

	/**
	 * Método hashCode para la clase. Sirve para diferenciar objetos.
	 * @return el código hash correspondiente al objeto
	 */
	public int hashCode() {
		return Objects.hash(dia, tramo, PUNTOS);
	}

	/**
	 * Método equals para la clase. Compara dos PermanenciaPorTramo
	 * @return true si son iguales, false si no lo son
	 */
	public boolean equals(Object o) {
		if(!(o instanceof PermanenciaPorTramo))
			return false;
		PermanenciaPorTramo otra = (PermanenciaPorTramo) o;
		if(this.getDia().equals(otra.getDia()) && this.getTramo().equals(otra.getTramo()))
			return true;
		return false;
	}

	/**
	 * Método toString de la clase. Define como debe mostrarse una PermanenciaPorTramo
	 * @return la representación en forma de texto de la permanencia
	 */
	public String toString() {
		return "[dia=" + getDia().format(FORMATO_DIA) + ", tramo=" + tramo + "]";
	}

}
