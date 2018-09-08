package tadConjunto;

//Implementa un TAD Conjunto
public class Conjunto {
	private int numelem;
	private int lista[] = new int[100];
	public int errorx;

	public void conjuntoVacio() {
		errorx = 0;
		numelem = -1;
	}

	// Recorre el arreglo buscando un elemento
	// Si lo encuentra regresa la posicion, y si no regresa -1
	public int buscar(int n) {
		int pos = -1;
		for (int i = 0; i < numelem; i++) {
			if (lista[i] >= n) {
				pos = i;
				break;
			}
		}
		return pos;
	}// Fin de buscar();

	public void agregar(int n) {
		int pos = buscar(n);
		if (pos == -1) {// El elemento no existia
			this.numelem++;
			lista[numelem - 1] = n;
		} else if (lista[pos] != n) {// elemento no existia
			this.numelem++;
			// recorrer a la derecha
			for (int i = numelem - 1; i > pos; i--)
				lista[i] = lista[i - 1];
			lista[pos] = n;
		}

	}// Fin de agregar();

	public String imprimir() {
		String output="";
		output+="{";
		for (int i = 0; i < numelem; i++)
			output+=(lista[i]+",");
		return(output+"}");
		
//		System.out.print("{");
//		for (int i = 0; i < numelem; i++)
//			System.out.print(lista[i] + ",");
//		System.out.println("}");
	}

	public Conjunto union(Conjunto x) {
		Conjunto resultante = new Conjunto();
		for (int i = 0; i < x.numelem; i++)
			resultante.agregar(x.lista[i]);
		// Elementos del conjunto actual
		for (int i = 0; i < this.numelem; i++)
			resultante.agregar(this.lista[i]);
		return resultante;

	}

	public Conjunto inter(Conjunto x) {
		Conjunto resultante = new Conjunto();
		int aux;
		// Recorrer conjunto actual
		for (int i = 0; i < this.numelem; i++) {
			aux = lista[i];
			for (int b = 0; b < x.numelem; b++) {
				if (x.lista[b] == aux) {
					resultante.agregar(aux);
					break;
				}
			}
		}
		return resultante;
	}// Fin del inter

	public boolean esVacio() {
		return this.numelem <= 0;
	}

	public int cardinal() {
		return this.numelem;
	}

	public boolean pertenece(int n) {
		return (buscar(n) >= 0);
	}

	public void borra(int n) {
		int pos = buscar(n);
		if (pos >= 0) {
			// Desplaza todo para un lado
			for (int i = pos; i < this.numelem - 1; i++) {
				lista[i] = lista[i + 1];
			}
			this.numelem--;
		}
	}

	public Conjunto diferencia(Conjunto x) {
		Conjunto resultante = new Conjunto();
		Conjunto inter = new Conjunto();
		inter = this.inter(x);
		for (int i = 0; i <= this.numelem; i++) {
			resultante.agregar(lista[i]);
		}
		for (int i = 0; i <= inter.numelem; i++) {
			resultante.borra(inter.lista[i]);
		}

		return resultante;
	}// PORFIN ME SALIO :v
	//Tarde como 2 horas ;-;

	public Conjunto diferenciaSim(Conjunto x) {
		Conjunto resultante = new Conjunto();
		Conjunto despacito1 = new Conjunto();
		Conjunto despacito2 = new Conjunto();

		despacito1 = this.union(x);
		despacito2 = this.inter(x);
		resultante = despacito1.diferencia(despacito2);

		return resultante;

	}
	public boolean incluidoen(Conjunto x) {
		Conjunto resultante = new Conjunto();
		resultante=this.diferencia(x);
		return resultante.esVacio();
	}
	public boolean igual(Conjunto x) {
		Conjunto resultante = new Conjunto();
		Conjunto despacito1 = new Conjunto();
		Conjunto despacito2 = new Conjunto();
		
		despacito1=this.diferencia(x);
		despacito2=x.diferencia(this);
		resultante=despacito1.union(despacito2);
		return resultante.esVacio();
	}
}