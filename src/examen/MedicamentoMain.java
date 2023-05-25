package examen;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class MedicamentoMain {

	/**
	 * Creamos una variable tipo Scanner y la inicializamos a null
	 * Con ella leeremos los datos nuevos y cargará los datos del fichero
	 */
	static Scanner read = null;
	/**
	 * Creamos una variable tipo BufferedWriter y la inicializamos a null
	 * Con ella escribiremos en el fichero
	 */
	static BufferedWriter bw = null;
	/**
	 * Se guardara el código del medicamento
	 */
	static int codigo = 0;
	/**
	 * Se guardara el nombre del medicamento
	 */
	static String nombre = "";
	/**
	 * Se guardara la descripcion del medicamento
	 */
	static String descripcion = "";
	/**
	 * Se guardara el precio del medicamento
	 */
	static double precio = 0;
	/**
	 * Se guardara la posología del medicamento
	 */
	static String posologia = "";
	/**
	 * Se guardarán los medicamentos 
	 * Es tipo TreeSet porque queremos que no haya repetidos y queremos ordenarlos
	 */
	static TreeSet<Medicamento> listaMedicamento = new TreeSet<Medicamento>();
	/**
	 * Se guardara el medicamento
	 */
	static Medicamento med;

	public static void main(String[] args) {

		int opcion = 0; //Se guardara la opcion del usuario
	
		System.out.println("Bienvenido al sistema");
		
		//Cargamos los datos del fichero
		cargarDatos();

		//En un bloque try-catch
		try {

			//Creamos el objeto BufferedWriter para escribir en el fichero
			bw = new BufferedWriter(new FileWriter("src\\examen\\medicamentos.txt", true));
			//Creamos el objeto Scanner para leer datos de nuevos medicamentos o eliminarlos
			read = new Scanner(System.in);

			//Ordenamos que haga
			do {
				//Muestre el menú
				MedicamentoMain.menu();
				//Leemos la opcion
				opcion = read.nextInt();

				//Creamos el switch con la opcion como condicion
				switch (opcion) {
				//En el caso 1, añadir un medicamento
				case 1:
					//Solicitamos los datos
					solicitarDatos();

					//Creamos un objeto con las informaciones dadas
					med = new Medicamento(codigo, nombre, descripcion, precio, posologia);
					
					//Lo añadimos en la collection
					listaMedicamento.add(med);
					break;
					
				//En el caso 2, mostrar los medicamentos	
				case 2:
					System.out.println("LISTA MEDICAMENTOS");
					System.out.println("___________________________________");

					//Mostramos cada medicamento, recorriendo la lista
					for (Medicamento values : listaMedicamento) {
						System.out.println(values);
						System.out.println("===================================");
					}
					break;
				
					//En el caso 3, eliminación del un medicamento
				case 3:
					//Solicitamos el codigo del medicamento
					System.out.println("Introduzca el codigo del medicamento a eliminar: ");
					codigo = read.nextInt();
					read.nextLine();

					//Creamos un objeto con el codigo
					med = new Medicamento(codigo);
					
					//Si la lista contiene ese medicamento
					if (listaMedicamento.contains(med)) {
						//Lo eliminamos
						listaMedicamento.remove(med);
						
					//De lo contrario	
					} else {
						//Mostramos un mensaje de que no existe el medicamento indicado
						System.err.println("El código introducido no coincide con ningun medicamento");
					}
					break;
					
				//En el caso 4, guardado de los medicamentos en el fichero	
				case 4:

					//Recorremos la lista
					for (Medicamento values : listaMedicamento) {
						//Escribimos los valores en el flujo de salida
						bw.write(codigo + ";" + nombre + ";" + descripcion + ";" + precio + ";" + posologia);
						//Añadimos una línea
						bw.newLine();
					}

					break;
				//En el caso 0, salimos del programa	
				case 0:
					System.out.println("Saliendo del programa...");
					break;
				//En el default,	
				default:
					//Mostramos mensaje de error
					System.err.println("ERROR, introduzca un número válido");
				}

			//Mientras que la opcion sea distinta de 0	
			} while (opcion != 0);

		//Capturamos las exceptions
		} catch (FileNotFoundException e) {
			//Mensaje de error
			System.err.println("No se ha encontrado el fichero");
			System.err.println(e.getMessage());
		} catch (IOException e) {
			//Mensaje de error
			System.err.println("No se ha podido abrir el fichero");
			System.err.println(e.getMessage());
			
		//Finalmente	
		} finally {
			//En un bloque try-catch 
			try {
				bw.flush(); //Vaciamos el flujo 
				bw.close(); //Cerramos el flujo
				read.close(); //Cerramos el Scanner 
			//Capturamos la exception 
			} catch (IOException e) {
				//Mensaje de error
				System.out.println("No se ha podido acceder al fichero");
				System.out.println(e.getMessage());
			}
		}

	}

	/**
	 * Método que muestra un menú
	 */
	static public void menu() {
		System.out.println();
		System.out.println("1. Añadir medicamento");
		System.out.println("2. Listar medicamentos");
		System.out.println("3. Eliminar medicamento");
		System.out.println("4. Guardar medicamentos");
		System.out.println("0. Salir");
		System.out.println();
	}

	/**
	 * Método que solicita los datos al usuario de un medicamento
	 */
	static public void solicitarDatos() {

		System.out.println("Introduzca el código del medicamento:");
		codigo = read.nextInt();
		read.nextLine();

		System.out.println("Introduzca el nombre del medicamento: ");
		nombre = read.next();
		read.nextLine();

		System.out.println("Introduzca la descripcion del medicamento: ");
		descripcion = read.nextLine();

		System.out.println("Introduzca el precio del medicamento: ");
		precio = read.nextDouble();
		read.nextLine();

		System.out.println("Introduzca la posologia del medicamento: ");
		posologia = read.nextLine();

	}

	public static void cargarDatos() {
		//En un bloque try-catch
		try {

			read = new Scanner(new FileReader("src\\examen\\medicamentos.txt"));
			// Mientras que haya una línea que leer
			while (read.hasNextLine()) {

				// Creamos un array
				String[] medicamento;
				// Guardamos los datos separados de un ;
				medicamento = read.nextLine().split(";");
				// Guardamos cada dato en una variable independiente
				codigo = Integer.valueOf(medicamento[0]);
				nombre = medicamento[1];
				descripcion = medicamento[2];
				precio = Double.valueOf(medicamento[3]);
				posologia = medicamento[4];

				// Creamos un objeto con los datos
				med = new Medicamento(codigo, nombre, descripcion, precio, posologia);

				// Añadimos el medicamento a la collection
				listaMedicamento.add(med);

			}
		//Capturamos la exception
		} catch (IOException e) {
			//Mensaje de error
			System.err.println("No se pudo abrir el fichero");
			System.err.println(e.getMessage());
		}
	}

}
