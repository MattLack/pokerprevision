import java.util.Arrays;

public class Logic {

	// VARIÁVEIS BASE

	String hand1;
	String hand2;
	int[] valorHAND1 = new int[5];
	char[] naipeHAND1 = new char[5];
	int[] valorHAND2 = new int[5];
	char[] naipeHAND2 = new char[5];

	// RETORNOS
	int[] UMparHAND1 = new int[5]; // Array de valores ordenados para mão 1 -
									// verificação de pares
	int[] UMparHAND2 = new int[5]; // Array de valores ordenados para mão 2 -
									// verificação de pares
	int[] DOISparesHAND1 = new int[2];
	int[] DOISparesHAND2 = new int[2];
	int[] trincaHAND1 = new int[1];
	int[] trincaHAND2 = new int[1];
	int[] quadraHAND1 = new int[1];
	int[] quadraHAND2 = new int[1];

	public void logicHANDS(String text) {
		dividirMAOS(text);

		byte cartaAlta = testaCARTAALTA(4);
		byte umpar = UMPAR();
		byte desempataumpar;

		if (umpar == -2) {
			desempataumpar = desempataUMPAR();
		} else if (umpar == -3) {
			// dois pares
		}

	}

	public void dividirMAOS(String text) {

		// divide as duas mãos
		this.hand1 = text.substring(0, 15);
		this.hand2 = text.substring(15);

		int carta1;
		int carta2;
		int cont1 = 0;
		int cont2 = 0;

		for (int v1 = 0; v1 <= 14; v1 += 3) {

			if (this.hand1.charAt(v1) == 'A') {
				carta1 = 14;
			}
			if (this.hand1.charAt(v1) == 'K') {
				carta1 = 13;
			}
			if (this.hand1.charAt(v1) == 'Q') {
				carta1 = 12;
			}
			if (this.hand1.charAt(v1) == 'J') {
				carta1 = 11;
			}
			if (this.hand1.charAt(v1) == 'T') {
				carta1 = 10;
			} else {
				carta1 = Character.getNumericValue(this.hand1.charAt(v1));
			}

			this.valorHAND1[cont1] = carta1;
			cont1++;

		}

		for (int v2 = 0; v2 <= 14; v2 += 3) {

			if (this.hand2.charAt(v2) == 'A') {
				carta2 = 14;
			}
			if (this.hand2.charAt(v2) == 'K') {
				carta2 = 13;
			}
			if (this.hand2.charAt(v2) == 'Q') {
				carta2 = 12;
			}
			if (this.hand2.charAt(v2) == 'J') {
				carta2 = 11;
			}
			if (this.hand2.charAt(v2) == 'T') {
				carta2 = 10;
			} else {
				carta2 = Character.getNumericValue(this.hand2.charAt(v2));
			}

			this.valorHAND2[cont2] = carta2;
			cont2++;

		}

		cont1 = 0;

		for (int n1 = 1; n1 <= 14; n1 += 3) {
			this.naipeHAND1[cont1] = this.hand1.charAt(n1);
			this.naipeHAND2[cont1] = this.hand2.charAt(n1);
			cont1++;
		}

	}

	public byte testaCARTAALTA(int ordem) {

		int[] aux1 = this.valorHAND1.clone();
		int[] aux2 = this.valorHAND2.clone();

		Arrays.sort(aux1);

		Arrays.sort(aux2);

		int n1 = aux1[ordem];
		int n2 = aux2[ordem];

		if (n1 > n2) {
			return 1;
		} else if (n2 > n1) {
			return 2;
		} else {
			return 0;
		}

	}

	public byte UMPAR() {

		int cont = 0;

		int[] aux1 = this.valorHAND1.clone();
		int[] aux2 = this.valorHAND2.clone();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if ((i != j) && (aux1[j] != 0)) {
					if ((aux1[i] == aux1[j])) {
						this.UMparHAND1[cont] = aux1[i];
						aux1[i] = 0;
						aux1[j] = 0;
						cont++;
					}
				}
			}
		}

		cont = 0;

		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if ((x != y) && (aux2[y] != 0)) {
					if ((aux2[x] == aux2[y])) {
						this.UMparHAND2[cont] = aux1[y];
						aux2[x] = 0;
						aux2[y] = 0;
						cont++;
					}
				}
			}
		}

		int contA = 0;
		int contB = 0;

		for (int k = 0; k < 5; k++) {

			if (this.UMparHAND1[k] != 0) {
				contA++;
			}

			if (this.UMparHAND2[k] != 0) {
				contB++;
			}

		}

		if (contA == 1 && contB == 0) { // mão1 tem par, mão 2 não
			return 1;
		} else if (contA == 0 && contB == 1) { // mão2 tem par, mão1 não
			return 2;
		} else if (contA == 0 && contB == 0) { // não tem par
			return -1;
		} else if (contA == 1 && contB == 1) { // empata
			return -2;
		} else if (contA > 1 || contB > 1) { // mais de um par
			return -3;
		} else {
			return 10; // erro
		}

	}

	public byte desempataUMPAR() {

		int a = this.UMparHAND1[0];
		int b = this.UMparHAND2[0];

		if (a > b) { // mão1 > mão2
			return 1;
		} else if (a < b) { // mão2 > mão1
			return 2;
		} else if (a == b) { // mão1 = mão2
			return 0;
		}

		return 10; // erro
	}

	public byte getDOISPARES(byte num) {

		byte key1 = -1;
		byte key2 = -1;

		if (num == -1) { // -1 se mão1 tem dois pares e mão2 não
			if (this.DOISparesHAND1[0] == this.DOISparesHAND1[1]) {
				return -1; // pares iguais
			} else {
				return 1; // pares diferentes
			}
		} else if (num == -2) { // -2 se mão2 tem dois pares e mão1 não
			if (this.DOISparesHAND2[0] == this.DOISparesHAND2[1]) {
				return -2; // pares iguais
			} else {
				return 2; // pares diferentes
			}
		} else if (num == -3) { // -3 se os dois tiverem dois pares
			if (this.DOISparesHAND1[0] == this.DOISparesHAND1[1]) {
				key1 = 0; // pares iguais
			} else {
				key1 = 1; // pares diferentes
			}
			if (this.DOISparesHAND2[0] == this.DOISparesHAND2[1]) {
				key2 = 3; // pares iguais
			} else {
				key2 = 4; // pares diferentes
			}

			if (key1 == 1 && key2 == 3) { // m1 pares diferentes m2 pares iguais
				return 10;
			} else if (key1 == 0 && key2 == 4) { // m1 pares iguais m2 pares
													// diferentes
				return 11;
			} else if (key1 == 1 && key2 == 4) { // m1 m2 pares diferentes
				return 12;
			} else if (key1 == 0 && key2 == 3) { // m1 m2 pares iguais
				return 13;
			}
		}

		return -10;

	}

	public static boolean testa(int[] valor) {

		Arrays.sort(valor);

		// precisa estar ordenado

		byte cont = 0;
		boolean ok = false;

		for (int i = 0; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				if (valor[i] == valor[j]) {
					cont++;
					ok = true;
				} else {
					break;
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

	public static void main(String[] args) {
		int[] DOISparesHAND1 = { 4, 4, 3, 3, 4 };

		System.out.println(testa(DOISparesHAND1));
	}

	// =========================================================================//

	/**
	 * 
	 * –Carta alta: Carta com maior valor. –Um par: duas cartas com o mesmo
	 * valor. –Dois pares: dois pares diferentes. –Trinca: três cartas com o
	 * mesmo valor. –Seqüencia (Straight): Todas as cinco cartas com valor
	 * consecutivo. –Flush: Todas as cartas do mesmo naipe. –Full House: uma
	 * trinca e um par –Quadra: quatro cartas do mesmo valor –Straight Flush:
	 * uma sequência com o mesmo naipe. –Royal Flash: 10, Valete, Dama, Rei e Ás
	 * do mesmo naipe.
	 */

}
