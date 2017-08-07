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

		// singleton

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
			// m1 tem royalflash m2 não
			venc1++;

		} else if ((Testes.getInstace().testSTRAIGHTFLUSH(ordValH1, naipeHAND1))
				&& !(Testes.getInstace().testSTRAIGHTFLUSH(ordValH2, naipeHAND2))
				&& !(Testes.getInstace().testROYALFLASH(ordValH2, naipeHAND2))) {
			// m1 tem straight flush e m2 não e nem royal flash
			venc1++;

		} else {

			if ((Testes.getInstace().testSTRAIGHTFLUSH(ordValH1, naipeHAND1))
					&& (Testes.getInstace().testSTRAIGHTFLUSH(ordValH2, naipeHAND2))) {
				// desempata straight flush e m1 tem carta calta
				int result = Testes.getInstace().testCARTAALTA(ordValH1, ordValH2);
				if (result == 1) {
					venc1++;
				}
			} else {

				int quadra1 = Testes.getInstace().testQUADRA(ordValH1);
				int quadra2 = Testes.getInstace().testQUADRA(valorHAND2);

				// verifica quadra e o valor da mesma

				if ((quadra1 > 0) && (quadra2 >= 0)) {

					if (quadra1 > quadra2) {
						venc1++;
					}

				} else {

					if ((Testes.getInstace().testFULLHOUSE(ordValH1))
							&& !(Testes.getInstace().testFULLHOUSE(ordValH2))) {
						// mão1 tem fullhouse e mão2 não
						venc1++;
					} else if ((Testes.getInstace().testFULLHOUSE(ordValH1))
							&& (Testes.getInstace().testFULLHOUSE(ordValH2))) {
						// desempata fullhouse
						int rFULLHOUSE = Testes.getInstace().testDESEMPATAFULLHOUSE(ordValH1, ordValH2);

						if (rFULLHOUSE == 1) {
							venc1++;
						}

					} else {

						if ((Testes.getInstace().testFLUSH(naipeHAND1))
								&& !(Testes.getInstace().testFLUSH(naipeHAND2))) {
							// m1 tem flush e m2 não
							venc1++;
						} else if ((Testes.getInstace().testFLUSH(naipeHAND1))
								&& (Testes.getInstace().testFLUSH(naipeHAND2))) {
							// desempata flush
							int rFLUSH = Testes.getInstace().testCARTAALTA(ordValH1, ordValH2);
							if (rFLUSH == 1) {
								venc1++;
							}
						} else {

							if ((Testes.getInstace().testSEQUENCIA(ordValH1))
									&& !(Testes.getInstace().testSEQUENCIA(ordValH2))) {
								// m1 tem sequencia e m2 não
								venc1++;
							} else if ((Testes.getInstace().testSEQUENCIA(ordValH1))
									&& (Testes.getInstace().testSEQUENCIA(ordValH2))) {
								// desempata sequencia
								int rSEQUENCIA = Testes.getInstace().testCARTAALTA(ordValH1, ordValH2);
								if (rSEQUENCIA == 1) {
									venc1++;
								}
							} else {
								// m1 tem trica m2 não
								int trinca1 = Testes.getInstace().testTRINCA(ordValH1);
								int trinca2 = Testes.getInstace().testTRINCA(ordValH2);

								if (trinca1 > 0 && trinca2 >= 0) {
									if (trinca1 > trinca2) {
										venc1++;
									}
								} else {
									// m1 tem dois pares
									int dPARES1 = Testes.getInstace().testDOISPARES(ordValH1);
									int dPARES2 = Testes.getInstace().testDOISPARES(ordValH2);

									if (dPARES1 > dPARES2) {
										venc1++;
									} else if (dPARES1 == dPARES2) {
										// desempata dois pares
										int dsPARES1 = Testes.getInstace().testDESEMPATADOISPARES(ordValH1);
										int dsPARES2 = Testes.getInstace().testDESEMPATADOISPARES(ordValH2);

										if (dsPARES1 > dsPARES2) {
											venc1++;
										}

									} else {
										// pares
										int par1 = Testes.getInstace().testUMPAR(ordValH1);
										int par2 = Testes.getInstace().testUMPAR(ordValH2);

										if (par1 > par2) {
											venc1++;
										} else {
											// carta alta
											int cALTA = Testes.getInstace().testCARTAALTA(ordValH1, ordValH2);
											if (cALTA == 1) {
												venc1++;
											}
										}

									}
								}
							}

						}

					}

				}

			}

		}

	}

	public void getVENCEDOR() {
		System.out.println("O jogador 1 venceu " + this.venc1 + " vezes.");
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

}
