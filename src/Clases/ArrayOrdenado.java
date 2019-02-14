package Clases;

public class ArrayOrdenado {

	private int array [];
	private int primeraVacia;
	private int últimaVacia;
	
	
	final private int nulo = -9;
	
	//Constructor inicializa un array de una posición
	public ArrayOrdenado () {
		this.array = new int [1];
		for (int i = 0 ; i <this.array.length ; i++) {
			this.array[i] = nulo;
		}
	}
	
	//Método get para mostar el array
	public int [] getArray () {
		return this.array;
	}
	
	public String toString () {
		String cadena;
		cadena = "El tamaño del array es de " + this.array.length + " posiciones";
		return cadena;
	}
	
	
	 /**
	  * método que comprueba si el array esta lleno, si está lleno hacemos más grande el array 4 posciones
	  * el array se ordena de menor a mayor
	  * @param int valor
	  * recibe el valor que se va a meter en el array
	  */
	
	public void insertar (int valor) {
		boolean lleno = true , metido = true;
		int array;
		int arraynuevo [];
		int i = 0;
		int posicionArray = 0;
		int totalDelArray = 0;
	
		//lo primero que hacemos es ver si el array está lleno
		for (i = 0 ; i < this.array.length && lleno ; i++) {
			if (this.array[i] == -9) {
				lleno = false;
			}
		}
	
		/**
		 * si está lleno lo que hacemos es crear un array nuevo con el tamaño
		 * del anterior, le pasamos los datos del this.array al nuevo array
		 * para crear un nuevo array sumando el valor que le metemos en el método
		 * y luego volvemos a pasar del array creado en el método a this.array
		 */
		if (lleno) {
			array = this.array.length;
			arraynuevo = new int [array];
		
			for (i = 0 ; i < this.array.length ; i++) {
				arraynuevo[i] = this.array[i];
			}
		
			this.array = new int [array + 4];
		
			for (i = 0 ; i < arraynuevo.length ; i++) { 
				this.array[i] = arraynuevo[i];
			}
		
			while ( i < this.array.length ) {
				this.array[i] = nulo;
				i++;
			}
		}
		
		/**
		 * miramos primero si algun valor que ya está en el array es mayor que el valor que queremos meter
		 * y guardamos la posición
		 */
		for (i = 0 ; i < this.array.length ; i++) {
			if (valor < this.array[i] && metido) {
				metido = false;
				posicionArray = i;
			}
		}
		
		/**
		 * si encontramos un valor del array mayor 
		 */
		if (!metido) {
			//vemos el tamaño del array de los que tienen valor
			for (i = 0 ; i < this.array.length && totalDelArray == 0; i++) {
				if (this.array[i] == -9) {
					totalDelArray = i;
				}
			}
			
			//desde la última posición del array hasta donde la posición que tenemos que meter el valor vamos pasando el valor a una posición adelantada
			for (i = totalDelArray ; i > posicionArray ; i--) {
				this.array[i] = this.array[i - 1];
			}
			
			//metemos el valor en su posición
			this.array[posicionArray] = valor;
		}else {
			lleno = true;
			/**
			 * si no encontramos un número mayor lo que hacemos es irnos a la última posición del array y meter el valor
			 */
			for (i = 0 ; i < this.array.length && lleno ; i++) {
				if (this.array[i] == -9) {
					this.array[i] = valor;
					lleno = false;
				}
			}
		}
			
		}
	
		/**
		 * Método que recibe un valor y lo que hace es buscar ese valor en el array y borrarlo, solo borra 
		 * el primer número igual al valor recibido
		 * @param int valor
		 * @return booleano
		 * si borramos devulve true y si no encontramos el valor devulve un false
		 */
		public boolean borrarValor (int valor) {
			boolean borrar = false , salir = true , lleno = true;
			int i , j , tamaño = 0;
			
			//miramos si el array está lleno
			for (i = 0 ; i < this.array.length && lleno; i++) {
				if(this.array[i] == -9) {
					lleno = false;
					tamaño = i;
				}
			}
			
			/**
			 * si el array está lleno, búscamos si se encuentra coincidencia entre dos valores, desde la posición que se encuentra el valor hasta el final del array
			 * vamos pasando el valor del array a una posición menos
			 */
			if (lleno) {
					/*
					 * Aquí búscamos la posición donde queremos borrar
					 */
					for (i = 0 ; i < this.array.length && salir ; i++) {
						if (this.array[i] == valor) {
							salir = false;
						}
					}
					
					/*
					 * sí la posición es más menor que el tamaño del array vamos pasando desde la posición que queremos borrar una posición más del array
					 * y la última posición la borramos
					 */
					if (i < this.array.length) {
						for(j = i ; j < this.array.length ; j++) {
							this.array[j -1] = this.array[j];
						}
						this.array[this.array.length -1] = nulo;
						borrar = true;
					}
					
					/*
					 * si la posición es la última del tamaño del array lo que hacemos es borrar la última posición
					 */
					if (i == this.array.length) {
						this.array[i -1] = nulo;
						borrar = true;
					}
					
					//si el array no esta lleno de valores no vamos aqui
				}else {	
					
					/*
					 * búscamos la posición del valor que queremos borrar
					 */
					for (i = 0 ; i < this.array.length && salir ; i++) {
						if (this.array[i] == valor) {
							salir = false;
						}
					}
					
					/*
					 * aqui ponemos las diferentes opciones que tenemos si el array no esta lleno y la posición que queramos borrar
					 */
					//si el array no esta lleno y solo hay un número
					 if (i -1 == 0 && tamaño == 1) {
						this.array[0] = nulo;	
						borrar = true;
					 }else {
						 //si la posición que queremos borrar es la del tamaño del array
						 if (i == tamaño) {
							 this.array[i -1] = nulo;
							 borrar = true;
						 }else {
							 //si la posición que queremos borrar está en medio del array
							 if (i > 0) {
								for(j = i ; j < this.array.length ; j++) {
									this.array[j -1] = this.array[j];
								}
								borrar = true;
							} 
						 }
					 }
			}
			
			return borrar;
			
		}
		
		
		/**
		 * recibe un valor y busca todos los valores iguales en el array y los borra
		 * @param int valor
		 * @return int valoresBorrados
		 * devulve la cantidad de valores que hemos borrado del array
		 */
		public int borrarTodosValor (int valor) {
			int totalBorrados = 0;
			boolean  salir = true , lleno = true , terminar = true;
			int i , j , tamaño = 0;
			
			
			
			while (terminar) {
		
				//miramos si el array está lleno
				for (i = 0 ; i < this.array.length && lleno; i++) {
					if(this.array[i] == -9) {
						lleno = false;
						tamaño = i;
					}
				}
			
				/**
				 * si el array está lleno, búscamos si se encuentra coincidencia entre dos valores, desde la posición que se encuentra el valor hasta el final del array
				 * vamos pasando el valor del array a una posición menos
				 */
				if (lleno) {
						/*
						 * Aquí búscamos la posición donde queremos borrar
						 */
						for (i = 0 ; i < this.array.length && salir ; i++) {
							if (this.array[i] == valor) {
								salir = false;
							}
						}
						
						if (salir) {
							terminar = false;
						}
					
						/*
						 * sí la posición es más menor que el tamaño del array vamos pasando desde la posición que queremos borrar una posición más del array
						 * y la última posición la borramos
						 */
						if (i < this.array.length && terminar) {
							for(j = i ; j < this.array.length ; j++) {
								this.array[j -1] = this.array[j];
							}
							this.array[this.array.length -1] = nulo;
							totalBorrados ++;
						}
					
						/*
						 * si la posición es la última del tamaño del array lo que hacemos es borrar la última posición
						 */
						if (i == this.array.length && terminar) {
							this.array[i -1] = nulo;
							totalBorrados ++;
						}
					
						//si el array no esta lleno de valores no vamos aqui
					}else {	
					
						/*
						 * búscamos la posición del valor que queremos borrar
						 */
						for (i = 0 ; i < this.array.length && salir ; i++) {
							if (this.array[i] == valor) {
								salir = false;
							}
						}
						
						if (salir) { 
							terminar = false;
						}
					
						/*
						 * aqui ponemos las diferentes opciones que tenemos si el array no esta lleno y la posición que queramos borrar
						 */
						//si el array no esta lleno y solo hay un número
						if (i -1 == 0 && tamaño == 1 && terminar) {
							this.array[0] = nulo;
							totalBorrados ++;
							}else {
								//si la posición que queremos borrar es la del tamaño del array
								if (i == tamaño && terminar) {
									this.array[i -1] = nulo;
									totalBorrados ++;
									}else {
										//si la posición que queremos borrar está en medio del array
										if (i > 0 && terminar) {
											for(j = i ; j < this.array.length ; j++) {
												this.array[j -1] = this.array[j];
											}
											totalBorrados ++;
										} 
									}
							}
					}
				salir = true;
				lleno = true;
			}
			
			return totalBorrados;
			
		}
		
		

}
