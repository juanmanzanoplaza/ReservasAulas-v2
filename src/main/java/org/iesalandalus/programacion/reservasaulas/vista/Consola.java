package org.iesalandalus.programacion.reservasaulas.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * Clase dedicada a la interacci�n con el usuario. Pide y valida los datos por teclado.
 * @see IUTextual
 * @see Opcion
 * @author Juan Antonio Manzano Plaza
 * @version 0
 *
 */
public class Consola {

	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/uuuu");

	/**
	 * Constructor privado para evitar que se instancien objetos de la clase.
	 */
	private Consola() {
	}

	/**
	 * M�todo est�tico encargado de mostrar por pantalla todas las opciones de Opcion
	 */
	public static void mostrarMenu() {
		System.out.println("*************************************************************");
		System.out.println("*           RESERVAS DE AULAS DEL IES AL-�NDALUS            *");
		System.out.println("*************************************************************");
		int i = 0;
		for (Opcion o: Opcion.values()) {
			System.out.printf("* %-2d- %-54s*\n", i, o.getMensaje());
			i++;
		}
		System.out.println("*************************************************************");
	}

	/**
	 * Imprime por pantalla el t�tulo de la opci�n seleccionada.
	 * @param cabecera el t�tulo de la opci�n
	 */
	public static void mostrarCabecera(String cabecera) {
		System.out.println(cabecera);
	}

	/**
	 * Lee por consola el valor ordinal de la opci�n que desea realizarse.
	 * @return el valor ordinal de la opci�n a realizar
	 */
	public static int elegirOpcion() {
		int opcion;
		do {
			System.out.println("�Qu� opci�n desea elegir?");
			opcion = Entrada.entero();
		} while(!Opcion.esOrdinalValido(opcion));
		return opcion;
	}

	/**
	 * Lee por consola el nombre de un aula y la crea.
	 * @return el aula le�da
	 */
	public static Aula leerAula() {
		Aula leida = null;
		do {
			try {
				leida = new Aula(leerNombreAula());
				System.out.println("Aula le�da correctamente.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while(leida==null);
		return leida;
	}

	/**
	 * Lee por consola el nombre de un aula.
	 * @return el nombre le�do
	 */
	public static String leerNombreAula() {
		String nombre;
		do {
			System.out.println("Introduzca el nombre del aula.");
			nombre = Entrada.cadena();
		}while(nombre.equals(""));
		return nombre;
	}

	/**
	 * Lee por consola todos los atributos de un profesor y lo crea.
	 * @return el profesor le�do
	 */
	public static Profesor leerProfesor() {
		Profesor leido = null;
		do {
			try {
				String nombre = leerNombreProfesor();
				System.out.println("Introduzca el correo electr�nico del profesor.");
				String correo = Entrada.cadena();
				System.out.println("Introduzca el tel�fono del profesor. (Puede dejarse vac�o)");
				String telefono = Entrada.cadena();
				if(telefono.equals(""))
					leido = new Profesor(nombre, correo);
				else
					leido = new Profesor(nombre, correo, telefono);
				System.out.println("Profesor le�do correctamente.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while(leido==null);
		return leido;
	}

	/**
	 * Lee por consola el nombre de un profesor.
	 * @return el nombre le�do
	 */
	public static String leerNombreProfesor() {
		String nombre;
		do {
			System.out.println("Introduzca el nombre del profesor.");
			nombre = Entrada.cadena();
		} while(nombre.equals(""));
		return nombre;
	}

	/**
	 * Lee por consola un tramo. En esta versi�n s�lo est�n las opciones de ma�ana (0) y de tarde (1)
	 * Si a�adimos m�s opciones a Tramo
	 * ser� necesario cambiar la salida por pantalla, pero no el bucle ni el return.
	 * @return el tramo horario le�do
	 */
	public static Tramo leerTramo() {
		int opcion;
		do {
			System.out.println("�Tramo de ma�ana(0) o de tarde(1)?");
			opcion = Entrada.entero();
		} while(opcion<0 || opcion>Tramo.values().length);
		return Tramo.values()[opcion];

	}

	/**
	 * Lee una fecha con un formato espec�fico.
	 * @return la fecha le�da
	 */
	public static LocalDate leerDia() {
		LocalDate leido = null;
		do {
			System.out.println("Introduzca una fecha en el formato \"dd/mm/aaaa\".");
			try {
				leido = LocalDate.parse(Entrada.cadena(), FORMATO_DIA);
			} catch (DateTimeParseException e) {
				System.out.println("La fecha introducida no est� en el formato correcto o no es v�lida.");
			}
		} while (leido == null);
		return leido;
	}

}
