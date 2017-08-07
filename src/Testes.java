import java.util.Arrays;
import java.util.List;

public class Testes {

	public boolean testROYALFLASH(int[] valor, char[] naipe) {

		int v = 0;
		char naipev = naipe[0];

		for (int i = 0; i < 5; i++) {
			if (naipe[i] == naipev) {
				v++;
			}
		}

		int[] aux2 = valor.clone();

		Arrays.sort(aux2);
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
			// sequencia
		} else {
			return false;
		}

	}

	public boolean testQUADRA(int[] valor) {

		// List<int[]> listav = (Arrays.asList(valor));

		int[] aux2 = valor.clone();

		Arrays.sort(aux2);

		byte cont = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (valor[i] == valor[j]) {
					cont++;
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

}
