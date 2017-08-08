package v2;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

public class PokerPrevision {

	private static final String txtEntrada = "entrada/poker";

	public static void PokerHands(String FILENAME) {

		//FILENAME = txtEntrada + FILENAME + ".txt";

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			int n = 0;

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			for (;((sCurrentLine = br.readLine()) != null);) {
				if (!sCurrentLine.equals("\n") & !sCurrentLine.equals("") & !sCurrentLine.equals(" ")) {
					Logic.getInstance().logicHANDS(sCurrentLine);
					
					//System.out.println(n);
					n++;
				}
			}

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		} catch (IOException e) {
			System.out.println("ERRO AO APONTAR ARQUIVO!");
		}

	}

	public static void main(String[] args) {

		double tInicio = System.currentTimeMillis();// inicia marcação de tempo

		PokerHands("entradas/pokerM.txt");
		
		Logic.getInstance().getVENCEDOR();
		
		double tFim = System.currentTimeMillis(); // encerra marcação do tempo

		System.out.println("Tempo Gasto em segundos= " + ((tFim - tInicio) / 1000));

	}

}
