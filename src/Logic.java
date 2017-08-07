import java.util.Arrays;

public class Logic {

	// VARIÁVEIS BASE

	String hand1;
	String hand2;
	int[] valorHAND1 = new int[5];
	char[] naipeHAND1 = new char[5];
	int[] valorHAND2 = new int[5];
	char[] naipeHAND2 = new char[5];
	int[] ordValH1 = new int[5];
	int[] ordValH2 = new int[5];

	public void logicHANDS(String text) {
		dividirMAOS(text);

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

		this.ordValH1 = this.valorHAND1.clone();

		Arrays.sort(this.ordValH1);

		this.ordValH2 = this.valorHAND2.clone();

		Arrays.sort(this.ordValH2);

	}

	public static boolean testa(int[] valor) {

		Arrays.sort(valor);

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
					return true;
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		int[] DOISparesHAND1 = { 1, 2, 1, 2, 1 };
		
		

		System.out.println(Testes.getInstace().testFULLHOUSE(DOISparesHAND1));
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
