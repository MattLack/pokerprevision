import java.util.Arrays;

public class Testes {

	private static Testes instance = null;

	private Testes() {

	}

	public static Testes getInstace() {
		if (instance == null) {
			instance = new Testes();
		}
		return instance;
	}

	public boolean testROYALFLASH(int[] aux2, char[] naipe) {

		boolean v = testFLUSH(naipe);

		// precisa estar ordenado

		int valort = 0;
		int base = 10;

		for (int j = 0; j < 5; j++) {
			if (aux2[j] == base) {
				valort++;
				base++;
			}
		}

		if (v == true && valort == 5) {
			return true;
		} else {
			return false;
		}

	}

	public boolean testSTRAIGHTFLUSH(int[] valor, char[] naipe) {

		if (testFLUSH(naipe)) {
			if (testSEQUENCIA(valor)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public int testQUADRA(int[] valor) {

		// List<int[]> listav = (Arrays.asList(valor));

		// precisa estar ordenado
		// retornando erro -1 casos de quadra

		byte cont = 0;
		boolean ok = false;
		int value = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (valor[i] == valor[j]) {
					cont++;
					value = valor[j];
					ok = true;
				} else {
					break;
				}
			}
			if (ok) {
				if (cont == 4) {
					return value;
				} else {
					return -1;
				}
			}
		}

		if (cont == 4) {
			return value;
		} else {
			return -1;
		}

	}

	public boolean testFULLHOUSE(int[] valor) {

		// precisa estar ordenado

		if (testTRINCA(valor) != -1) {

			int[] aux = (int[]) valor.clone();
			byte cont = 0;
			boolean ok = false;

			for (int i = 0; i < 5; i++) {
				for (int j = 1; j < 5; j++) {
					if (aux[i] == aux[j] && i != j) {
						aux[i] = 0;
						cont++;
						ok = true;
					} else {
						break;
					}
				}
				if (ok) {
					if (cont == 2) {
						Arrays.sort(aux);
						if (testUMPAR(aux) != -1) {
							return true;
						} else {
							return false;
						}
					}
				}

			}

		} else {
			return false;
		}
		return false;

		// trinca e par
	}

	public int testDESEMPATAFULLHOUSE(int[] valor1, int[] valor2) {

		// precisa estar ordenado

		if (testTRINCA(valor1) > testTRINCA(valor2)) {
			return 1;
		} else if (testTRINCA(valor1) < testTRINCA(valor2)) {
			return -1;
		} else if (testTRINCA(valor1) == testTRINCA(valor2)) {
			if (testUMPAR(valor1) > testUMPAR(valor2)) {
				return 1;
			} else if (testUMPAR(valor1) == testUMPAR(valor2)) {
				return testCARTAALTA(valor1, valor2);
			} else {
				return -1;
			}
		} else {
			// trinca e par
			return -1;
		}
	}

	public boolean testFLUSH(char[] naipe) {

		int v = 0;
		char naipev = naipe[0];

		for (int i = 0; i < 5; i++) {
			if (naipe[i] == naipev) {
				v++;
			}
		}

		if (v == 5) {
			return true;
		} else {
			return false;
		}

	}

	public boolean testSEQUENCIA(int[] aux) {

		// precisa estar ordenado
		// retestado

		int dif = 0;
		int contDIF = 0;
		int cont = 1;
		for (int i = 0; i < 5; i++) {
			if (cont != 5) {
				dif = aux[cont] - aux[i];
				if (dif == 1) {
					contDIF++;
					cont++;
				} else {
					return false;
				}
			}

		}

		if (contDIF == 4) {
			return true;
		} else {
			return false;
		}

	}

	public int testTRINCA(int[] valor) {

		// precisa estar ordenado
		// retestado

		byte cont = 0;
		boolean ok = false;
		int value = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (valor[i] == valor[j] && i != j) {
					cont++;
					value = valor[j];
					ok = true;
				}
			}
			if (ok) {
				if (cont == 2) {
					return value;
				} else {
					return -1;
				}
			}
		}

		if (cont == 2) {
			return value;
		} else {
			return -1;
		}

	}

	public int testDOISPARES(int[] valor) {

		// precisa estar ordenado
		// retestado

		int[] aux = (int[]) valor.clone();
		int pares = 0;

		for (int i = 1; i < 5; i++) {
			if ((aux[i] == aux[i - 1]) && (aux[i] != pares)) {

				if (pares > 0)
					pares = aux[i];
				else if (pares == 0) {
					pares = aux[i];
				}

			}
		}
		if (pares == 0) {
			return -1;
		} else
			return pares;

	}

	public int testDESEMPATADOISPARES(int[] valor1, int[] valor2) {

		// precisa estar ordenado
		// retestado

		int dpar1 = testDOISPARES(valor1);
		int dpar2 = testDOISPARES(valor2);
		// verifica o par mais alto
		if (dpar1 > dpar2) {
			return 1;
		} else if (dpar1 == dpar2) {
			// caso empate verifica o segundo maior par
			int parM1 = -1;
			int parM2 = -1;
			// procura o segundo par da primeira mão, o algorítmo confia que o
			// segundo par existe
			for (int i = 1; i < valor1.length; i++) {
				if ((valor1[i] == valor1[i - 1]) && (valor1[i] != dpar1)) {
					parM1 = valor1[i];
				}
			}
			// procura o segundo par da segunda mão, o algorítmo confia que o
			// segundo par existe
			for (int i = 1; i < valor2.length; i++) {
				if ((valor2[i] == valor2[i - 1]) && (valor2[i] != dpar2)) {
					parM2 = valor1[i];
				}
			}
			if (parM1 > parM2)
				return 1;
			else
				return this.testCARTAALTA(valor1, valor2);

		} else {
			// caso o par da mão 2 seja maior que o da mão 1 retorna -1;
			return -1;
		}
	}

	public int testUMPAR(int[] aux) {
		// precisa estar ordenado
		// retestado

		for (int i = 1; i < aux.length; i++) {
			if (aux[i] == aux[i - 1]) {
				return aux[i];
			}
		}

		return -1;

	}

	public byte testCARTAALTA(int[] valor1, int[] valor2) {
		// precisa estar ordenado
		// restestado

		for (int i = 4; 0 <= i; i--) {

			if (valor1[i] > valor2[i]) {
				return 1;
			} else if (valor2[i] > valor1[i]) {
				return 2;
			}

		}

		return 0;

	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 3, 3, 5, 6 };
		int[] c = new int[] { 2, 2, 3, 3, 4 };
		int b = Testes.getInstace().testTRINCA(a);
		System.out.println(b);
	}

}
