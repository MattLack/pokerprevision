import java.util.Arrays;

public class Logic {

	// VARIÁVEIS BASE

	String hand1;
	String hand2;

	// RETORNOS
	int M1cartaAlta; // Mão 1 carta alta
	int M2cartaAlta; // Mão 2 carta alta
	int[] paresHAND1 = new int[5]; // Array de valores ordenados para mão 1 -
									// verificação de pares
	int[] paresHAND2 = new int[5]; // Array de valores ordenados para mão 2 -
									// verificação de pares

	public void dividirMAOS(String text) {

		// divide as duas mãos
		this.hand1 = text.substring(0, 15);
		this.hand2 = text.substring(15);

	}

	// ================================= GETS
	// ==================================//

	public byte getCARTAALTA() {

		// retorna qual das mãos possui a maior carta
		if (this.M1cartaAlta > this.M2cartaAlta) { // m1 > m2
			return 1;
		} else if (this.M1cartaAlta < this.M2cartaAlta) { // m1 < m2
			return 2;
		} else { // m1 == m2
			return 0;
		}
	}

	public byte getPAR() {

		// retorna qual das mãos possui o maior número de pares
		if (this.paresHAND1.length > this.paresHAND2.length) {// m1 > m2
			return 1;
		} else if (this.paresHAND1.length < this.paresHAND2.length) {// m1 < m2
			return 2;
		} else { // m1 == m2
			return 0;
		}

	}

	/*
	 * public static void main(String[]args){ dividirMAOS(""); }
	 */

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
				this.M1cartaAlta = 14;
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'A') {
				this.M2cartaAlta = 14;
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'K') {
				this.M1cartaAlta = 13;
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'K') {
				this.M2cartaAlta = 13;
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'Q') {
				this.M1cartaAlta = 12;
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'Q') {
				this.M2cartaAlta = 12;
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'J') {
				this.M1cartaAlta = 11;
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'J') {
				this.M2cartaAlta = 11;
				k2 = 1;
			}
			if (hand1.charAt(v1) == 'T') {
				this.M1cartaAlta = 10;
				k1 = 1;
			}
			if (hand2.charAt(v1) == 'T') {
				this.M2cartaAlta = 10;
				k2 = 1;
			} else if (k1 == 0) {
				this.M1cartaAlta = Character.getNumericValue(hand1.charAt(v1));
			} else if (k2 == 0) {
				this.M2cartaAlta = Character.getNumericValue(hand2.charAt(v1));
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
					this.paresHAND1[cont] = paresh1[i];
					cont++;
					cont1++;
				}
			}
		}

		cont = 0;
		cont1 = 0;

		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if ((paresh2[x] == paresh2[y]) && (cont1 < 2)) {
					this.paresHAND2[cont] = paresh2[x];
					cont++;
					cont1++;
				}
			}
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
