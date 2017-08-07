import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PokerPrevision {

	private static final String txtEntrada = "entrada/poker";

	public static void PokerHands(String FILENAME) {

		FILENAME = txtEntrada + FILENAME + ".txt";

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				if (!sCurrentLine.equals("\n") && !sCurrentLine.equals("") && !sCurrentLine.equals(" ")) {
					Logic.getInstance().logicHANDS(sCurrentLine);
				}
			}

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {

		double tInicio = System.currentTimeMillis();// inicia marcação de tempo

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite uma das opções disponíveis para número de entradas: ");
		System.out.println("K - 1000    entradas");
		System.out.println("M = 1000000 entradas");

		String texto = teclado.nextLine();
		PokerHands(texto);

		double tFim = System.currentTimeMillis(); // encerra marcação do tempo
		System.out.println("Tempo Gasto em segundos= " + ((tFim - tInicio) / 1000));

	}

}
