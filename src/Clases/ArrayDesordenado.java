package Clases;

public class ArrayDesordenado {
	private int array [];
	private int primeraVacia;
	final private int nulo = -9;
	
	//Método constructor que inicializa el array en 1
	public ArrayDesordenado () {
		this.array = new int [1];
		
		for (int i = 0 ; i < this.array.length ; i++) {
			this.array[i] = this.nulo;
		}
	}
	
	//Método get del array
	public int [] getArray () {
		return this.array;
	}
	
	//método para aumentar el tamaño del array si está lleno
	/**
	 * este método lo que hace es insertar un valor en el array creado, comprueba si está lleno el array
	 * y si lo está crea otro array con 4 posiciones más
	 * @param int valor
	 */
	public void insertar (int valor) {
		boolean lleno = true;
		int array;
		int arraynuevo [];
		int i = 0;
		
		//lo primero que hacemos es ver si el array está lleno
		for (i = 0 ; i < this.array.length && lleno ; i++) {
			if (this.array[i] == -9) {
				this.array[i] = valor;
				lleno = false;
			}
		}
		
		/**
		 * si está lleno lo que hacemos es crear un array nuevo con el tamaño
		 * del anterior, le pasamos los datos del anterior array al nuevo.
		 * para después crear otro nuevo array con 4 posiciones más y volver a pasar
		 * los datos de un array a otro
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
			this.array[i] = valor;
			
			for (i = i + 1 ; i < this.array.length ; i++) {
				this.array[i] = nulo;
			}
		}
		
	}
	
	/**
	 * este método recibe un valor, revisa si está ese valor en el array y si está lo borra.
	 * solo borra el primer número que sea igual que el valor
	 * @param int valor
	 * @return booleano
	 * sí el valor está y se ha borrado se devuelve true, sí no está devulve false
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
	 * este método lo que hace es recibir un valor y si ese valor está en el array 
	 * borra todas las veces que este ese valor en el array
	 * @param int valor
	 * @return int
	 * devulve cúantas posiciones se han borrado del aray
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
