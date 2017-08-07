import java.math.BigInteger;
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

	// Vencedor 1
	long venc1;

	private static Logic instance = null;

	private Logic() {

	}
	

	public static Logic getInstance() {

		if (instance == null) {
			instance = new Logic();
		}
		return instance;

	}

	public void logicHANDS(String text) {

		this.venc1 = 0;

		dividirMAOS(text);

		if ((Testes.getInstace().testROYALFLASH(ordValH1, naipeHAND1))
				&& !(Testes.getInstace().testROYALFLASH(ordValH2, naipeHAND2))) {
			//m1 tem royalflash m2 não
			venc1++;
			break;
		} else if ((Testes.getInstace().testROYALFLASH(ordValH1, naipeHAND1))
				&& (Testes.getInstace().testROYALFLASH(ordValH2, naipeHAND2)) && (Testes.getInstace().testCARTAALTA(ordValH1, ordValH2)==1)) {
			//m1 e m2 tem royalflash - m1 tem carta alta
			venc1++;
			break;
		}else if ((Testes.getInstace().testSTRAIGHTFLUSH(ordValH1, naipeHAND1))
				&& !(Testes.getInstace().testSTRAIGHTFLUSH(ordValH2, naipeHAND2))
				&& !(Testes.getInstace().testROYALFLASH(ordValH2, naipeHAND2))) {
			//m1 tem straight flush e m2 não e nem royal flash
			venc1++;
			break;
		} else if ((Testes.getInstace().testQUADRA(ordValH1)) && !(Testes.getInstace().testQUADRA(ordValH2))
				&& !(Testes.getInstace().testSTRAIGHTFLUSH(ordValH2, naipeHAND2))
				&& !(Testes.getInstace().testROYALFLASH(ordValH2, naipeHAND2))) {
			// m1 tem quadra e m2 não, e nem strayight flush nem royal flash
			venc1++;
			break;
		} else if ((Testes.getInstace().testQUADRA(ordValH1))
				&& (Testes.getInstace().testCARTAALTA(ordValH1, ordValH2) == 1)
				&& (Testes.getInstace().testQUADRA(ordValH2)) && !(Testes.getInstace().testSTRAIGHTFLUSH(ordValH2, naipeHAND2))
				&& !(Testes.getInstace().testROYALFLASH(ordValH2, naipeHAND2))) {
			// m1 e m2 tem quadra - m1 tem carta alta - m2 não tem straight flush e nem royalflash
			venc1++;
			break;
		} else if (){
			
			venc1++;
			break;
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

		this.ordValH1 = this.valorHAND1.clone();

		Arrays.sort(this.ordValH1);

		this.ordValH2 = this.valorHAND2.clone();

		Arrays.sort(this.ordValH2);

	}

	// =========================================================================//

	/**
	 * 
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
