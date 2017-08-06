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
	int M1cartaAlta; // Mão 1 carta alta
	int M2cartaAlta; // Mão 2 carta alta
	int[] UMparHAND1 = new int[2]; // Array de valores ordenados para mão 1 -
									// verificação de pares
	int[] UMparHAND2 = new int[2]; // Array de valores ordenados para mão 2 -
									// verificação de pares
	int[] DOISparesHAND1 = new int[2];
	int[] DOISparesHAND2 = new int[2];

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

	// ================================= GETS
	// ==================================//

	public byte testaCARTAALTA(int[] hand1, int[] hand2, int ordem) {

		int[] aux1 = this.valorHAND1.clone();
		int[] aux2 = this.valorHAND2.clone();

		Arrays.sort(aux1);
		Arrays.sort(aux2);

		int n1 = this.valorHAND1[ordem];
		int n2 = this.valorHAND2[ordem];

		if (n1 > n2) {
			return 1;
		} else if (n2 > n1) {
			return 2;
		} else {
			return 0;
		}

	}

	public byte getUMPAR() {
		byte key = 0;
		// retorna qual das mãos possui o maior número de pares
		// atualiza casos 2 pares

		if (this.UMparHAND1.length > this.UMparHAND2.length) {// m1 > m2
			if (this.UMparHAND1.length > 1) { // se existir mais de um par na
												// mão 1
				this.DOISparesHAND1 = this.UMparHAND1; // repassa array
				key = 1;
			}
			if (key == 1) { // retorna -1 se mão1 tem dois pares e mão2 não
				return -1;
			} else if (key == 0) { // retorna 1 se mão1 não tem dois pares e é
									// maior que mão2
				return 1;
			}

		} else if (this.UMparHAND1.length < this.UMparHAND2.length) {// m1 < m2

			if (this.UMparHAND2.length > 1) { // se existir mais de um par na
												// mão2
				this.DOISparesHAND2 = this.UMparHAND2; // repassa array
				key = 2;
			}
			if (key == 2) { // retorna -2 se mão2 tem dois pares e mão1 não
				return -2;
			} else if (key == 0) { // retorna 2 se mão2 não tem dois pares e é
									// maior que mão1
				return 2;
			}
		} else { // m1 == m2
			if ((this.UMparHAND1.length > 1) && (this.UMparHAND2.length > 1)) {
				this.DOISparesHAND1 = this.UMparHAND1;
				this.DOISparesHAND2 = this.UMparHAND2;
				return -3; // retorna -3 se os dois tiverem dois pares
			} else {
				return 0; // retorna 0 mão1 e mão2 tiverem 1 par
			}

		}

		return -10; // erro

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

	
	  public static void main(String[]args){ int[] DOISparesHAND1 = new int[2]; System.out.println(DOISparesHAND1[0]); }
	 

	// =========================================================================//

	public void CartaAlta(String hand1, String hand2) {

		// objetivo - verificar a carta com maior valor na mão
		// fazendo as duas mãos em sequencia

		int v1 = 0;
		byte k1;
		byte k2;

		while (v1 <= 14) {

			k1 = 0;
			k2 = 0;

			// atualizando valor de cartas
			if (hand1.charAt(v1) == 'A') {
				if (this.M1cartaAlta < 14) {
					this.M1cartaAlta = 14;
				}
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'A') {
				if (this.M2cartaAlta < 14) {
					this.M2cartaAlta = 14;
				}
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'K') {
				if (this.M1cartaAlta < 13) {
					this.M1cartaAlta = 13;
				}
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'K') {
				if (this.M2cartaAlta < 13) {
					this.M2cartaAlta = 13;
				}
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'Q') {
				if (this.M1cartaAlta < 12) {
					this.M1cartaAlta = 12;
				}
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'Q') {
				if (this.M2cartaAlta < 12) {
					this.M2cartaAlta = 12;
				}
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'J') {
				if (this.M1cartaAlta < 11) {
					this.M1cartaAlta = 11;
				}
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'J') {
				if (this.M2cartaAlta < 11) {
					this.M2cartaAlta = 11;
				}
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'T') {
				if (this.M1cartaAlta < 10) {
					this.M1cartaAlta = 10;
				}
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'T') {
				if (this.M2cartaAlta < 10) {
					this.M2cartaAlta = 10;
				}
				k2 = 1;
			} else if (k1 == 0) {
				if (this.M1cartaAlta < Character.getNumericValue(hand1
						.charAt(v1))) {
					this.M1cartaAlta = Character.getNumericValue(hand1
							.charAt(v1));
				}
			} else if (k2 == 0) {
				if (this.M2cartaAlta < Character.getNumericValue(hand2
						.charAt(v1))) {
					this.M2cartaAlta = Character.getNumericValue(hand2
							.charAt(v1));
				}
			}

			v1 = v1 + 3;

		}

	}

	public void Par(String hand1, String hand2) {

		// par de duas cartas com mesmo valor - não considera naipe

		int carta1;
		int carta2;
		int cont = 0;
		int[] paresh1 = new int[5];
		int[] paresh2 = new int[5];

		for (int v1 = 0; v1 <= 14; v1 += 3) {

			if (hand1.charAt(v1) == 'A') {
				carta1 = 14;
			}
			if (hand1.charAt(v1) == 'K') {
				carta1 = 13;
			}
			if (hand1.charAt(v1) == 'Q') {
				carta1 = 12;
			}
			if (hand1.charAt(v1) == 'J') {
				carta1 = 11;
			}
			if (hand1.charAt(v1) == 'T') {
				carta1 = 10;
			} else {
				carta1 = Character.getNumericValue(hand1.charAt(v1));
			}

			paresh1[cont] = carta1;
			cont++;

		}

		cont = 0; // reseta cont
		Arrays.sort(paresh1); // ordena array de valores

		for (int v2 = 0; v2 <= 14; v2 += 3) {

			if (hand2.charAt(v2) == 'A') {
				carta2 = 14;
			}
			if (hand2.charAt(v2) == 'K') {
				carta2 = 13;
			}
			if (hand2.charAt(v2) == 'Q') {
				carta2 = 12;
			}
			if (hand2.charAt(v2) == 'J') {
				carta2 = 11;
			}
			if (hand2.charAt(v2) == 'T') {
				carta2 = 10;
			} else {
				carta2 = Character.getNumericValue(hand2.charAt(v2));
			}

			paresh2[cont] = carta2;
			cont++;

		}

		Arrays.sort(paresh2); // ordena array de valores
		cont = 0;
		int cont1 = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if ((paresh1[i] == paresh1[j]) && (cont1 < 2)) {
					this.UMparHAND1[cont] = paresh1[i];
					cont++;
					cont1++;
				}
			}
			cont1 = 0;
		}

		cont = 0;
		cont1 = 0;

		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if ((paresh2[x] == paresh2[y]) && (cont1 < 2)) {
					this.UMparHAND2[cont] = paresh2[x];
					cont++;
					cont1++;
				}
			}
			cont1 = 0;
		}

	}
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
