import java.util.Arrays;

public class Logic {
	
	// VARIÁVEIS BASE
	
	String hand1;
	String hand2;
	
	// RETORNOS
	int M1cartaAlta; //Mão 1 carta alta
	int M2cartaAlta; //Mão 2 carta alta
	
	
	
	public void dividirMAOS(String text) {

		// divide as duas mãos
		this.hand1 = text.substring(0, 15);
		this.hand2 = text.substring(15);

	}
	
	
	//================================= GETS ==================================//
	
	public byte getCARTAALTA(){
		if(this.M1cartaAlta > this.M2cartaAlta){
			return 1;
		}else{
			return 2;
		}
	}

	

	/*
	 * public static void main(String[]args){ dividirMAOS(""); }
	 */
	
	
	//=========================================================================//

	public void CartaAlta(String hand1, String hand2) {

		// objetivo - verificar a carta com maior valor na mão
		// fazendo as duas mãos em sequencia

		int v1 = 0;
		byte k1;
		byte k2;

		while (v1 <= 14) {

			k1 = 0;
			k2 = 0;

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
