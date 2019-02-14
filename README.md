# Tarea Reservas de Aulas
## Profesor: Andr�s Rubio del R�o
## Alumno: Juan Antonio Manzano Plaza

El cliente nos comenta que debemos tener en cuenta los siguientes aspectos:

- Las aulas se pueden reservar para una permanencia por tramo (de ma�ana o de tarde) o para una permanencia por horas. La permanencia por horas se har� por horas en punto y no ser�n anteriores a las 8:00h ni posteriores a las 22:00h.
- Si para un d�a se realiza una reserva con permanencia por tramo, para ese d�a no se podr�n hacer reservas por horas y viceversa.
- Las aulas deben tener informaci�n sobre el n�mero de puestos de cada una.
- Las reservas no se pueden realizar para el mes en curso (s�lo para el mes que viene o posteriores).
- En el centro se lleva un sistema de puntos que cada profesor gasta al hacer una reserva:
  - Una permanencia por tramo restar� 10 puntos.
  - Una permanencia por hora restar� 3 puntos.
  - Un aula restar� 0,5 puntos por el n�mero de puestos del aula.
  - Una reserva restar� la suma del n�mero de puntos de la permanencia m�s el n�mero de puntos del aula.
  - Un profesor tiene disponibles cada mes 200 puntos por lo que si cuando va a realizar una reserva el n�mero de puntos gastados ese mes m�s el n�mero de puntos de la reserva que quiere realizar supera ese l�mite no dejar� realizar la reserva.

Adem�s queremos aprovechar para implementar el patr�n Modelo Vista Controlador a nuestra aplicaci�n.

El diagrama de clases que nos queda es el siguiente:

![Diagrama de clases para reservasaulas](src/main/resources/reservasAulas.png)

He subido a GitHub un esqueleto de proyecto gradle que ya lleva incluidos todos los test necesarios que el programa debe pasar. Dichos test est�n todos comentados y deber�s ir descoment�ndolos conforme vayas avanzando con la tarea. La URL del repositorio es en la que te encuentras.

Por tanto, tu tarea va a consistir en completar los siguientes apartados:

1. Lo primero que debes hacer es realizar un fork del repositorio donde he colocado el proyecto gradle con la estructura del proyecto y todos los test necesarios.
2. Clona tu repositorio remoto reci�n copiado en github a un repositorio local que ser� donde ir�s realizando lo que a continuaci�n se te pide. A�ade tu nombre al fichero `README.md` en el apartado "Alumno". Haz tu primer commit.
3. Haz las modificaciones necesarias en la clase `Aula` para incluir el atributo puestos e implementar el m�todo `getPuntos. Haz un commit.
4. Haz la clase `Permanencia` una clase abstracta y haz que el m�todo `getPuntos` sea abstracto. Esta clase s�lo tendr� como atributo el d�a de la permanencia. Haz un commit.
5. Crea la clase `PermanenciaPorTramo` que herede de `Permanencia`, que implemente el m�todo `getPuntos` y que posea el atributo `tramo`. Haz un commit.
6. Crea la clase `PermanenciaPorHora` que herede de `Permanencia`, que implemento el m�todo `getPuntos` y que posea el atributo `hora`. Esta clase debe contemplar los requisitos para las horas expuestos en el enunciado. Haz un commit.
7. Haz las modificaciones necesarias en la clase `Reserva` para que un aula se pueda reservar por un profesor para una permanencia por tramo o por horas y que implemente el m�todo `getPuntos`. Haz un commit.
8. Haz las modificaciones necesarias en la clase dao `Reservas` para que se tengan en cuenta las restricciones comentadas en el enunciado sobre no poder reservar aulas para el mes en curso y que no se sobrepase el l�mite de puntos de un profesor para el mes en el que quiere realizar la reserva. Haz un commit.
9. Crea la clase `ControladorReservasAulas` que haga de puente entre el modelo y la vista. Haz un commit.
10. Crea las interfaces para el controlador, la vista y el modelo y haz que se utilicen desde la aplicaci�n principal. Haz un commit.



###### Se valorar�:
- La nomenclatura del repositorio de GitHub y del archivo entregado sigue las indicaciones de entrega.
- La indentaci�n debe ser correcta en cada uno de los apartados.
- El nombre de las variables debe ser adecuado.
- Se debe utilizar la clase `Entrada` para realizar la entrada por teclado.
- El proyecto debe pasar todas las pruebas que van en el esqueleto del mismo y toda entrada del programa ser� validada para evitar que el programa termine abruptamente debido a una excepci�n.
- Se deben utilizar los comentarios adecuados.
- Se valorar� la correcci�n ortogr�fica tanto en los comentarios como en los mensajes que se muestren al usuario.

