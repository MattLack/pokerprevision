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

			int[] aux = valor.clone();
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

		byte cont = 0;
		boolean ok = false;
		int value = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (valor[i] == valor[j] && i != j) {
					cont++;
					value = valor[j];
					ok = true;
				} else {
					break;
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

		int[] aux = valor.clone();
		int[] doispares = new int[2];
		byte cont = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (aux[i] == aux[j] && i != j) {
					doispares[cont] = aux[i];
					aux[i] = 0;
					i = j;
					j = j + 1;
					cont++;
				}
			}

			if (cont == 2) {
				if (doispares[0] != doispares[1]) {
					return doispares[1];
				}
			}
		}
		return -1;

	}

	public int testDESEMPATADOISPARES(int[] valor) {

		// precisa estar ordenado

		int[] aux = valor.clone();
		int[] doispares = new int[2];
		byte cont = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (aux[i] == aux[j] && i != j) {
					doispares[cont] = aux[i];
					aux[i] = 0;
					i = j;
					j = j + 1;
					cont++;
				}
			}

			if (cont == 2) {
				if (doispares[0] != doispares[1]) {
					return doispares[0];
				}
			}
		}
		return -1;

	}

	public int testUMPAR(int[] aux) {
		// precisa estar ordenado

		byte cont = 0;
		boolean ok = false;
		int value = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (aux[i] == aux[j] && i != j && aux[i] != 0 && aux[j] != 0) {
					cont++;
					value = aux[j];
					ok = true;
					break;
				}
			}

			if (ok) {
				if (cont == 1) {
					return value;
				} else {
					return -1;
				}

			}
		}
		return -1;

	}

	public byte testCARTAALTA(int[] valor1, int[] valor2) {
		// precisa estar ordenado

		for (int i = 4; 0 <= i; i--) {

			if (valor1[i] > valor2[i]) {
				return 1;
			} else if (valor2[i] > valor1[i]) {
				return 2;
			}

		}

		return 0;

	}

}
