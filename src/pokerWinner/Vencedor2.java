package pokerWinner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Vencedor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Arquivo final. As classes foram feitas para reconhecer cada caso, exceto
		 * as sequencias flush e o RSF, que são combinações de sequencia e de flush.
		 * Para testar o programa, basta apontar para o arquivo de entrada. Caso ele
		 * esteja indisponível ou não seja apontado, o programa avisará.
		 * 
		 */

		double tInicio = System.currentTimeMillis();//inicia marcação de tempo
		//dec. variáveis
		String maos = "";
		int jogador1 = 0;
		//Variaveis para contagem

		int eCA=0;
		int eparAlto=0;
		int edoispares=0;
		int etrinca=0;
		int esequencia=0; 
		int eflush=0;
		int efullhouse=0;
		int equadra=0;
		int esequenciaFlush=0;
		int parAlto=0;
		int doispares=0;
		int trinca=0;
		int sequencia=0; 
		int flush=0;
		int fullhouse=0;
		int quadra=0;
		int sequenciaFlush=0;

		//instancia classes
		CartaAlta cA= new CartaAlta();
		Par p= new Par();
		DoisPares dP= new DoisPares();
		Trinca t = new Trinca();
		Sequencia s= new Sequencia();
		Flush f= new Flush();
		FullHouse fH= new FullHouse();
		Quadra q= new Quadra();

		//System.out.println(dP.testaSequencia("JC6S5H2H2D"));
		//System.out.println(dP.desempata("6H6H9C9HQH", "6S6HQSQSKS"));

		//lê o arquivo
		//monta a string gigante
		try (Scanner dados= new Scanner(new File("D:\\Paradigmas\\pokerWinner\\src\\pokerWinner\\pokerm.txt"))){
			//Itera sobre os dados
			while(dados.hasNextLine()){
				String linha = dados.nextLine();
				maos+=linha.replace(" ","");
			}
		}catch(FileNotFoundException e){
			System.out.println("Aponte corretamente para o arquivo, seu Tolo!!!");
		}

		int cont=0;
		//mapeando as mãos
		while(cont<maos.length()){
			String mao1=maos.substring(cont, cont+10);
			String mao2=maos.substring(cont+10, cont+20);
			cont+=20;
			//Trecho de desempates 
			//CartaAlta
			if(cA.testa(mao1)&&!s.testaSequencia(mao1)&&!f.testaFlush(mao1)&&cA.testa(mao2)&&!s.testaSequencia(mao2)&&!f.testaFlush(mao2)){
				if(cA.desempata(mao1, mao2)){
					jogador1+=1;
					eCA+=1;
				}
			}
			//empate par
			if(p.testaPar(mao1)&&p.testaPar(mao2)){
				if(p.desempata(mao1, mao2)){
					jogador1+=1;
					eparAlto+=1;
				}
			}
			//empate dois pares
			if(dP.testaDoisPares(mao1)&&dP.testaDoisPares(mao2)){
				if(dP.desempata(mao1, mao2)){
					jogador1+=1;
					edoispares+=1;
				}
			}
			//empate trinca
			if(t.testaTrinca(mao1)&&t.testaTrinca(mao2)){
				if(t.desempata(mao1, mao2)){
					jogador1+=1;
					etrinca+=1;
				}
			}
			//empate sequencia
			if(s.testaSequencia(mao1) && !f.testaFlush(mao1) && s.testaSequencia(mao2) && !f.testaFlush(mao2)){
				if(s.desempata(mao1, mao2)){
					jogador1+=1;
					esequencia+=1;
				}

			}
			//empate flush 
			if(!s.testaSequencia(mao1)&&f.testaFlush(mao1) &&!s.testaSequencia(mao2) && f.testaFlush(mao2)){
				if(f.desempata(mao1, mao2)){
					jogador1+=1;
					eflush+=1;
				}
			}
			//empate full house
			if(fH.testaFullHouse(mao1)&&fH.testaFullHouse(mao1)){
				if(fH.desempata(mao1, mao2)){
					jogador1+=1;
					efullhouse+=1;
				}
			}
			//empate quadra
			if(q.testaQuadra(mao1)&&q.testaQuadra(mao1)){
				if(q.desempata(mao1, mao2)){
					jogador1+=1;
					equadra+=1;
				}
			}
			//empate sequencia flush incluindo royal
			if(f.testaFlush(mao1) && f.testaFlush(mao2) && s.testaSequencia(mao1) && s.testaSequencia(mao2)){
				if(s.desempata(mao1, mao2)){
					jogador1+=1;
					esequenciaFlush+=1;
				}
			}
			//trechos de vitória clara do player 1
			//sequencia flush incluindo RSF vs all - sequenciaflush
			if(f.testaFlush(mao1) && !f.testaFlush(mao2) && s.testaSequencia(mao1) && !s.testaSequencia(mao2)){
				jogador1+=1;
				sequenciaFlush+=1;
			}
			//quadra vs All - sequenciaflush e quadra
			if(q.testaQuadra(mao1) && !q.testaQuadra(mao2) && !f.testaFlush(mao2) && !s.testaSequencia(mao2)){
				jogador1+=1;
				quadra+=1;
			}
			//fullhouse vs All - sequenciaFlush, quadra e fullhouse
			if(fH.testaFullHouse(mao1)&&!q.testaQuadra(mao2) && !fH.testaFullHouse(mao2) && !f.testaFlush(mao2)&& !s.testaSequencia(mao2)){
				jogador1+=1;
				fullhouse+=1;
			}
			//flush vs All - sequenciaFlush, quadra, fullhouse e flush
			if(f.testaFlush(mao1)&& !s.testaSequencia(mao1)&&!q.testaQuadra(mao2) && !fH.testaFullHouse(mao2) && !f.testaFlush(mao2)&& !s.testaSequencia(mao2)){
				jogador1+=1;
				flush+=1;
			}
			//sequencia vs All - sequenciaFlush, quadra, fullhouse, flush e sequencia
			if(s.testaSequencia(mao1)&&!f.testaFlush(mao1) &&!q.testaQuadra(mao2) && !fH.testaFullHouse(mao2) && !f.testaFlush(mao2)&& !s.testaSequencia(mao2)){
				jogador1+=1;
				sequencia+=1;
				//System.out.println(mao1+"  "+mao2);
			}
			//Trinca vs All - sequenciaFlush, quadra, fullhouse, flush, sequencia e trinca
			if(t.testaTrinca(mao1)&&!q.testaQuadra(mao2)&& !fH.testaFullHouse(mao2)&& !f.testaFlush(mao2)&&!s.testaSequencia(mao2)&&!t.testaTrinca(mao2)){
				jogador1+=1;
				trinca+=1;
			}
			//Dois pares vs All - sequenciaFlush, quadra, fullhouse, flush, sequencia, trinca e 2 pares
			if(dP.testaDoisPares(mao1)&&!q.testaQuadra(mao2)&&!fH.testaFullHouse(mao2)&&!t.testaTrinca(mao2)&&!f.testaFlush(mao2)&&!s.testaSequencia(mao2)&&!dP.testaDoisPares(mao2)){
				jogador1+=1;
				doispares+=1;
			}
			//par vs All - sequenciaFlush, quadra, fullhouse, flush, sequencia, trinca, 2 pares e par
			if(p.testaPar(mao1)&&!q.testaQuadra(mao2)&& !fH.testaFullHouse(mao2)&& !t.testaTrinca(mao2)&& !dP.testaDoisPares(mao2)&&!s.testaSequencia(mao2)&&!f.testaFlush(mao2) &&!p.testaPar(mao2)){
				jogador1+=1;
				parAlto+=1;
			}

		}
		double tFim = System.currentTimeMillis();
		System.out.println("Tempo Gasto em segundos= "+((tFim-tInicio)/1000));
		System.out.println("O jogador 1 venceu "+jogador1+" vezes.");

		/*
				System.out.println("Desempate Carta Alta - "+eCA);
				System.out.println("Desempate Par Alto - "+eparAlto);
				System.out.println("Desempate Dois Pares -"+edoispares);
				System.out.println("Desempate Trinca - "+etrinca);
				System.out.println("Desempate Flush - "+eflush);
				System.out.println("Desempate Sequencia -"+esequencia);
				System.out.println("Desempate FullHouse - "+efullhouse);
				System.out.println("Desempate Quadra - "+equadra);
				System.out.println("Desempate Sequencia Flush -"+esequenciaFlush);
				System.out.println("Vitoria Par Alto - "+parAlto);
				System.out.println("Vitoria dois pares -"+doispares);
				System.out.println("Vitoria trinca -"+trinca);
				System.out.println("Vitoria sequencia - "+sequencia);
				System.out.println("Vitoria flush - "+flush);
				System.out.println("Vitoria fullhouse -"+fullhouse);
				System.out.println("Vitoria quadra - "+quadra);
				System.out.println("Vitoria Sequencia Flush - "+sequenciaFlush);
				//*/
	}
}



