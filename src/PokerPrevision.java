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
	private static final String txtSaida = "saida/poker";
	private BufferedWriter escritor = null;

	public void PokerHands(String FILENAME) {

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
					// chamar método previsionline aqui
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
	
	public void PrevisionLine(){
		
		//lógica da previsão
		//escrever no arquivo
		
	}

	public void arquivoSaida(String texto, String arquivo) {

		/**
		 * Método responsável por escrever os dados no arquivo de saída
		 */

		try {
			if ((new File(arquivo + ".txt").exists() == false)) {

				new File(arquivo + ".txt").createNewFile();
				escritor = new BufferedWriter(new FileWriter(arquivo + ".txt"));
			}

			escritor.append(texto + "\r\n");
			escritor.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite uma das opções disponíveis para número de entradas: ");
		System.out.println("K - 1000    entradas");
		System.out.println("M = 1000000 entradas");

		String texto = teclado.nextLine();

	}

}
