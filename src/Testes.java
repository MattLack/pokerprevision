import java.util.Arrays;
import java.util.List;

public class Testes {

	public boolean testROYALFLASH(int[] aux2, char[] naipe) {

		int v = 0;
		char naipev = naipe[0];

		for (int i = 0; i < 5; i++) {
			if (naipe[i] == naipev) {
				v++;
			}
		}

		// precisa estar ordenado
		
		int valort = 0;
		int base = 10;

		for (int j = 0; j < 5; j++) {
			if (aux2[j] == base) {
				valort++;
				base++;
			}
		}

		if (v == 5 && valort == 5) {
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

	public boolean testQUADRA(int[] valor) {

		// List<int[]> listav = (Arrays.asList(valor));

		// precisa estar ordenado

		byte cont = 0;
		boolean ok = false;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (valor[i] == valor[j]) {
					cont++;
					ok = true;
				}
			}
			if (ok) {
				if (cont == 4) {
					return true;
				} else {
					return false;
				}
			}
		}

		if (cont == 4) {
			return true;
		} else {
			return false;
		}

	}

	public boolean testFULLHOUSE(int[] valor) {
		// trinca e par
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

	public boolean testTRINCA(int[] valor) {

		// precisa estar ordenado

		byte cont = 0;
		boolean ok = false;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (valor[i] == valor[j]) {
					cont++;
					ok = true;
				}
			}
			if (ok) {
				if (cont == 3) {
					return true;
				} else {
					return false;
				}
			}
		}

		if (cont == 3) {
			return true;
		} else {
			return false;
		}

	}

	public boolean testDOISPARES(int[] valor) {

	}

}
