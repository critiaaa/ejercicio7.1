package Main;

import java.util.Scanner;

import Clases.ArrayDesordenado;
import Clases.ArrayOrdenado;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayDesordenado array = new ArrayDesordenado ();
		ArrayOrdenado  array1 = new ArrayOrdenado ();
		
		int op = 0 , num , juego;
		
		System.out.println("¿Como quieres el array?");
		System.out.println("1. Desordenado");
		System.out.println("2. Ordenado");
		juego = sc.nextInt();
		while (juego != 1 && juego != 2) {
			System.out.println("Número mal metido");
			System.out.println("¿Como quieres el array?");
			System.out.println("1. Ordenado");
			System.out.println("2. Desordenado");
			juego = sc.nextInt();
		}
		
		while (op != 4) {
			System.out.println("---------------------------------------------");
			System.out.println("0. Mostrar los elementos no nulos del array");
			System.out.println("1. Insertar un valor");
			System.out.println("2. Borrar elemento dado su valor");
			System.out.println("3. Borrar todos los elementos dado su valor");
			System.out.println("4. FIN");
			System.out.println("---------------------------------------------");
			espacios (2);
			
			System.out.println("¿Qué quieres hacer?");
			op = sc.nextInt();
			System.out.println("---------------------------------------------");
		
			switch (op) {
		
				case 0 :
					
					if (juego == 1) {
						espacios (1);
						for (int i = 0 ; i < array.getArray().length ; i++) {
							if (array.getArray()[i] != -9) {
								System.out.println(array.getArray()[i]);
							}
						}
					}else {
						espacios(1);
						for (int i = 0 ; i < array1.getArray().length ; i++) {
							if (array1.getArray()[i] != -9) {
							System.out.println(array1.getArray()[i]);	
							}	
						}
					}
					
					break;
			
				case 1 :
					
					if(juego == 1) {
						espacios (1);
						System.out.println("¿Qué valor quieres meter?");
						num = sc.nextInt();
							while (num < 0) {
								System.out.println("Número mal metido");
								System.out.println("¿Qué valor quieres meter?");
								num = sc.nextInt();
							}
							array.insertar(num);
					}else {
						espacios (1);
						System.out.println("¿Qué valor quieres meter?");
						num = sc.nextInt();
							while (num < 0) {
								System.out.println("Número mal metido");
								System.out.println("¿Qué valor quieres meter?");
								num = sc.nextInt();
							}
							array1.insertar(num);								
					}
					
					break;
			
				case 2 :
					
					if (juego == 1) {
						espacios (1);
						System.out.println("¿Qué elemento quieres borrar");
						num = sc.nextInt();
						if (array.borrarValor(num)) {
							System.out.println("Elemento borrado correctamente");
						}else {
							System.out.println("Elemento no existente, no se pudo borrar");
						}
					}else {
						espacios (1);
						System.out.println("¿Qué elemento quieres borrar");
						num = sc.nextInt();
						if (array1.borrarValor(num)) {
							System.out.println("Elemento borrado correctamente");
						}else {
							System.out.println("Elemento no existente, no se pudo borrar");
						}
					}
					break;
		
		
				case 3 : 
					
					if(juego == 1) {
						espacios (1);
						System.out.println("¿Qué elemento quieres borrar");
						num = sc.nextInt();
						int contador;
						contador = array.borrarTodosValor(num);
							if (contador == 0) { 
								System.out.println("Elementos no encontrados, no se pudo borrar");
							}else {
								System.out.println("Has borrado " + contador + " números iguales");
					}
						
					}else {
						espacios (1);
						System.out.println("¿Qué elemento quieres borrar");
						num = sc.nextInt();
						int contador;
						contador = array1.borrarTodosValor(num);
							if (contador == 0) { 
								System.out.println("Elementos no encontrados, no se pudo borrar");
							}else {
								System.out.println("Has borrado " + contador + " números iguales");
							}
					}
					break;
			
				case 4 :
					break;
				default : 
					espacios (1);
					System.out.println("Número mal introducido intentelo otra vez");
					break;
			}
		}
		
		sc.close();
	}
	
	private static void espacios (int num) {
		int contEspacios;
		for (contEspacios = 0; contEspacios < num; contEspacios++) {
			System.out.println();
		}
		
		
	}

}
