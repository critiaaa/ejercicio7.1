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
	 * Método borrarValor, que dado un valor como parámetro, borrará su primera aparición en el
	 * array y reorganizará dicho array para que todos los valores NULO(-9), estén al final del
	 * mismo, nos devolverá un booleano siendo true si borra algún valor o false si no encuentra ningún
	 * valor igual al dado por parámetro.
	 * 
	 * @param valor
	 * @return booleano true si borra algún valor y false si no encuentra ese valor en el array.
	 * @author Gonzalo Vicente Cepeda
	 */
		public boolean borrarValor (int valor) {
			boolean sw = false;
			int i, j, aux;
			for (i = 0; i < this.array.length && sw == false; i++) {
				if (this.array[i] == valor) {
					this.array[i] = this.NULO;
					sw = true;
					for (j = i; j < this.array.length - 1; j ++) {
						aux = this.array[j];
						this.array[j] = this.array[j + 1];
						this.array[j + 1] = aux;
					}
				}
			}
			return sw;
		}
		
		
		/**
		 * Método borrarTodosValor que dado un valor por parámetro, borrará todos los valores coincidentes
		 * en el array, devolviendo el numero de valores borrados.
		 * 
		 * @param valor
		 * @return Número entero haciendo referencia al número de valores borrados.
		 * @author Gonzalo Vicente Cepeda
		 */
		public int borrarTodosValor (int valor) {
			int cantidad = 0, i, cont, j, aux;
			for (i = 0; i < this.array.length; i++) {
				if (this.array[i] == valor) {
					this.array[i] = this.NULO;
					cantidad ++;
				}
			}
			for (cont = cantidad; cont > 0; cont--) {
				for (i = 0; i < this.array.length; i++) {
					if (this.array[i] == this.NULO) {
						for (j = i; j < this.array.length - 1; j ++) {
							aux = this.array[j];
							this.array[j] = this.array[j + 1];
							this.array[j + 1] = aux;
						}
					}
				}
			}
			return cantidad;
		}
		
		

}
