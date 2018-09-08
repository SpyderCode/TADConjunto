package tadConjunto;


import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

public class UsaTADConjunto {

	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		Conjunto a, b;
		a = new Conjunto();
		b = new Conjunto();
		int input = 0;
		
		do {
			try {
				input = Integer.parseInt(
						JOptionPane.showInputDialog("Con cual conjunto quieres trabajar?\n1.-A\n2.-B\n3.-Salir"));

				switch (input) {
				case 1:
					menuConjunto(a, b);
					break;
				case 2:
					menuConjunto(b, a);
					break;
				case 3:
					System.exit(0);

				default:
					JOptionPane.showMessageDialog(null, "No hubo entrada", "ERROR", JOptionPane.ERROR_MESSAGE);
					break;
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage());
			}
		} while (input != 3);
	}

	private static void menuConjunto(Conjunto w, Conjunto e) {
		int num;
		
		String message = "0.-Imprime\n1.-Añadir num\n2.-Borra num\n3.-Pertenece\n4.-ConjuntoVacio\n5.-Union\n"
				+ "6.-Interseccion\n7.-Diferencia\n8.-DiferenciaSimetrica\n9.-Es vacio\n"
				+ "10.-Igual\n11.-Incluido\n12.-Cardinal\n13.-Regresar";
		int input = 0;
		
		try {
			Conjunto c = new Conjunto();
			Conjunto x = new Conjunto();
			Conjunto y = new Conjunto();
			x = w;
			y = e;// Estaba intentando cosas pero creo que no cambio nada
			
			input = Integer.parseInt(JOptionPane.showInputDialog(message));
			
			switch (input) {
			case 0:
				JOptionPane.showMessageDialog(null, x.imprimir(), "Conjunto", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				num = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte un numero: ", "Agregar",
						JOptionPane.DEFAULT_OPTION));
				x.agregar(num);
				break;
			case 2:
				num = Integer.parseInt(
						JOptionPane.showInputDialog(null, "Inserte un numero: ", "Borrar", JOptionPane.DEFAULT_OPTION));
				x.borra(num);
				break;
			case 3:
				num = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte un numero: ", "Pertenece",
						JOptionPane.DEFAULT_OPTION));
				JOptionPane.showMessageDialog(null, x.pertenece(num), "Conjunto", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 4:
				x.conjuntoVacio();
				JOptionPane.showMessageDialog(null, "Conjunto A esta vacio", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 5:
				c = x.union(y);
				JOptionPane.showMessageDialog(null, c.imprimir(), "Success", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 6:
				c = x.inter(y);
				JOptionPane.showMessageDialog(null, c.imprimir(), "Interseccion exitoso",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 7:
				c = x.diferencia(y);
				JOptionPane.showMessageDialog(null, c.imprimir(), "Diferencia entre conjuntos",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 8:
				c = x.diferenciaSim(y);
				JOptionPane.showMessageDialog(null, c.imprimir(), "Diferencia Simetrica entre conjuntos",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 9:
				JOptionPane.showMessageDialog(null, x.esVacio(), "Conjunto Vacio true/false",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 10:
				JOptionPane.showMessageDialog(null, x.igual(y), "Igual", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 11:
				JOptionPane.showMessageDialog(null, x.incluidoen(y), "Incluido en", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 12:
				JOptionPane.showMessageDialog(null, x.cardinal(), "Tamaño", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 13:
				menu();
				break;

			default:JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

		}
	}
}