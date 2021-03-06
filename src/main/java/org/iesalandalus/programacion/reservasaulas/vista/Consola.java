package org.iesalandalus.programacion.reservasaulas.vista;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * Clase dedicada a la interacci�n con el usuario. Pide y lee los datos por
 * teclado
 * 
 * @see VistaReservasAulas
 * @see Opcion
 * @author Juan Antonio Manzano Plaza
 * @version 2
 *
 */
public class Consola {

	/**
	 * Constructor privado para evitar que se instancien objetos de la clase.
	 */
	private Consola() {
	}

	/**
	 * M�todo est�tico encargado de mostrar por pantalla todas las opciones de
	 * Opcion
	 */
	public static void mostrarMenu() {
		System.out.println("*************************************************************");
		System.out.println("*           RESERVAS DE AULAS DEL IES AL-�NDALUS            *");
		System.out.println("*************************************************************");
		int i = 0;
		for (Opcion o : Opcion.values()) {
			System.out.printf("* %-2d- %-54s*\n", i, o.getMensaje());
			i++;
		}
		System.out.println("*************************************************************");
	}

	/**
	 * Imprime por pantalla el t�tulo de la opci�n seleccionada.
	 * 
	 * @param cabecera
	 *            el t�tulo de la opci�n
	 */
	public static void mostrarCabecera(String cabecera) {
		System.out.println(cabecera);
	}

	/**
	 * Lee por consola el valor ordinal de la opci�n que desea realizarse.
	 * 
	 * @return el valor ordinal de la opci�n a realizar
	 */
	public static int elegirOpcion() {
		int opcion;
		System.out.println("�Qu� opci�n desea elegir?");
		opcion = Entrada.entero();
		return opcion;
	}

	/**
	 * Lee por consola el nombre de un aula y la crea.
	 * 
	 * @return el aula le�da
	 */
	public static Aula leerAula() {
		Aula leida = null;
		String nombre = leerNombreAula();
		System.out.println("Introduzca el n�mero de puestos del aula.");
		int puestos = Entrada.entero();
		leida = new Aula(nombre, puestos);
		System.out.println("Aula le�da correctamente.");
		return leida;
	}

	/**
	 * Lee por consola el nombre de un aula.
	 * 
	 * @return el nombre le�do
	 */
	public static String leerNombreAula() {
		String nombre;
		System.out.println("Introduzca el nombre del aula.");
		nombre = Entrada.cadena();
		return nombre;
	}

	/**
	 * Lee por consola todos los atributos de un profesor y lo crea.
	 * 
	 * @return el profesor le�do
	 */
	public static Profesor leerProfesor() {
		Profesor leido = null;
		String nombre = leerNombreProfesor();
		System.out.println("Introduzca el correo electr�nico del profesor.");
		String correo = Entrada.cadena();
		System.out.println("Introduzca el tel�fono del profesor. (Puede dejarse vac�o)");
		String telefono = Entrada.cadena();
		if (telefono.equals(""))
			leido = new Profesor(nombre, correo);
		else
			leido = new Profesor(nombre, correo, telefono);
		System.out.println("Profesor le�do correctamente.");
		return leido;
	}

	/**
	 * Lee por consola el nombre de un profesor.
	 * 
	 * @return el nombre le�do
	 */
	public static String leerNombreProfesor() {
		String nombre;
		System.out.println("Introduzca el nombre del profesor.");
		nombre = Entrada.cadena();
		return nombre;
	}

	/**
	 * Lee por consola un tramo. En esta versi�n s�lo est�n las opciones de ma�ana
	 * (0) y de tarde (1) Si a�adimos m�s opciones a Tramo ser� necesario cambiar la
	 * salida por pantalla, pero no el bucle ni el return.
	 * 
	 * @return el tramo horario le�do
	 */
	public static Tramo leerTramo() {
		int opcion;
		do {
			System.out.println("�Tramo de ma�ana (0) o de tarde (1)?");
			opcion = Entrada.entero();
		} while (opcion < 0 || opcion > Tramo.values().length - 1);
		return Tramo.values()[opcion];

	}

	/**
	 * Lee por consola el d�a para una permanencia
	 * 
	 * @return la fecha le�da
	 */
	public static String leerDia() {
		String dia = "";
		System.out.println("Introduzca una fecha en el formato \"dd/mm/aaaa\".");
		dia = Entrada.cadena();
		return dia;
	}

	/**
	 * Lee por consola la hora para una permanencia por hora
	 * 
	 * @return la hora le�da
	 */
	public static String leerHora() {
		String hora = "";
		System.out.println("Introduzca una hora en el formato hh:mm");
		hora = Entrada.cadena();
		return hora;
	}

	/**
	 * Lee por consola el tipo de permanencia que se desea leer
	 * 
	 * @return el tipo de permanencia elegido
	 */
	public static int elegirPermanencia() {
		int permanencia = -1;
		do {
			System.out.println("�Por horas (0) o por tramo (1)?");
			permanencia = Entrada.entero();
		} while (permanencia < 0 || permanencia > 1);
		return permanencia;
	}

}
