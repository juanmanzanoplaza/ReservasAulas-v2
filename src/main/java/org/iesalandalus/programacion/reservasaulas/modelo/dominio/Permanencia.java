package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un tramo de reservas Reserva
 * @author Juan Antonio Manzano Plaza
 * @version 1
 *
 */
public abstract class Permanencia {

	protected LocalDate dia;
	protected static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/uuuu");

	/**
	 * ??
	 */
	protected Permanencia() {
		setDia(LocalDate.now().plusMonths(1));
	}

	/**
	 * Constructor de la clase
	 * @param dia el d�a de la reserva
	 */
	protected Permanencia(LocalDate dia) throws IllegalArgumentException {
		setDia(dia);
	}

	/**
	 *
	 */
	protected Permanencia(String dia) throws IllegalArgumentException {
		setDia(dia);
	}

	/**
	 * M�todo get para el d�a de la reserva
	 * @return el d�a de la reserva
	 */
	public LocalDate getDia() {
		return LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	}

	/**
	 * M�todo set para el d�a de la reserva
	 * @param dia la fecha de la reserva
	 * @throws IllegalArgumentException si el d�a es nulo
	 */
	protected void setDia(LocalDate dia) throws IllegalArgumentException {
		if(dia==null)
			throw new IllegalArgumentException("El d�a de una permanencia no puede ser nulo.");
		this.dia = LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	}

	/**
	 * M�todo set para el d�a de la reserva
	 * @param dia la fecha de la reserva
	 * @throws IllegalArgumentException si el d�a es nulo
	 */
	protected void setDia(String dia) throws IllegalArgumentException {
		if(dia==null)
			throw new IllegalArgumentException("??");
		if(dia.equals(""))
			throw new IllegalArgumentException("??");
		this.dia = LocalDate.parse(dia, FORMATO_DIA);
	}

	/**
	 * Obtiene la cantidad de puntos que cuesta reservar un aula durante una permanencia determinada.
	 * @return la cantidad de puntos que cuesta la permanencia
	 */
	public abstract int getPuntos();

	/**
	 * Representa una permanencia como una cadena de caracteres
	 * @return la representaci�n de la permanencia
	 */
	public abstract String toString();

	/**
	 * M�todo hashCode de la clase. Sirve para diferenciar objetos
	 * @return el c�digo hash del objeto
	 */
	public abstract int hashCode();

	/**
	 * M�todo equals de la clase
	 * @return True si son iguales, False si no
	 */
	public abstract boolean equals(Object o);
}
