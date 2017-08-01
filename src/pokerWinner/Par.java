package pokerWinner;

public class Par {
	public boolean testaPar(String mao){
		int flagPar= 0;
		for(int i=0; i<mao.length();i+=2){
			int j=i+2;
			int cont=0;
			while(j<mao.length()){
				if(mao.charAt(i)==mao.charAt(j)){
					cont+=1;
				}
				j+=2;
			}
			if (cont>1){
				return false;
			}
			if(cont==1){
				flagPar+=cont;
			}

		}
		if(flagPar==1){
			return true;
		}
		else{
			return false;
		}

	}
	public boolean desempata(String mao1, String mao2){
		int flagp1=0;
		int flagp2=0;
		int flagk1=0;
		int	flagk2=0;
		//Pega flag do par
		for(int i=0; i<mao1.length();i+=2){
			int j=i+2;
			int cont=0;
			while(j<mao1.length()){
				if(mao1.charAt(i)==mao1.charAt(j)){
					cont+=1;
					if(mao1.charAt(i)=='A'){
						flagp1=14;
					}
					if(mao1.charAt(i)=='K'){
						flagp1=13;
					}
					if(mao1.charAt(i)=='Q'){
						flagp1=12;
					}
					if(mao1.charAt(i)=='J'){
						flagp1=11;
					}
					if(mao1.charAt(i)=='T'){
						flagp1=10;
					}
					if(Character.isDigit(mao1.charAt(i))){
						flagp1=Character.getNumericValue(mao1.charAt(i));
					}

				}
				j+=2;
			}
			if (cont>0){
				break;
			}
		}
		//pega flag do kicker
		for(int i=0;i<mao1.length();i+=2){
			if(mao1.charAt(i)=='A' && flagp1<14){	
				flagk1=14;
			}
			if(mao1.charAt(i)=='K' && flagp1<13){
				flagk1=13;
			}
			if(mao1.charAt(i)=='Q' && flagp1<12){
				flagk1=12;
			}
			if(mao1.charAt(i)=='J' && flagp1<11){
				flagk1=11;
			}
			if(mao1.charAt(i)=='T' && flagp1<10){
				flagk1=10;
			}
			if(Character.isDigit(mao1.charAt(i) )&& flagk1<Character.getNumericValue(mao1.charAt(i))){
				flagk1=Character.getNumericValue(mao1.charAt(i));
			}
		}
		//
		//Pega flag do par
				for(int i=0; i<mao1.length();i+=2){
					int j=i+2;
					int cont=0;
					while(j<mao2.length()){
						if(mao2.charAt(i)==mao2.charAt(j)){
							cont+=1;
							if(mao2.charAt(i)=='A'){
								flagp2=14;
							}
							if(mao2.charAt(i)=='K'){
								flagp2=13;
							}
							if(mao2.charAt(i)=='Q'){
								flagp2=12;
							}
							if(mao2.charAt(i)=='J'){
								flagp2=11;
							}
							if(mao2.charAt(i)=='T'){
								flagp2=10;
							}
							if(Character.isDigit(mao2.charAt(i))){
								flagp2=Character.getNumericValue(mao2.charAt(i));
							}

						}
						j+=2;
					}
					if (cont>0){
						break;
					}
				}
				//pega flag do kicker
				for(int i=0;i<mao2.length();i+=2){
					if(mao2.charAt(i)=='A' && flagp2<14){	
						flagk2=14;
					}
					if(mao2.charAt(i)=='K' && flagp2<13){
						flagk2=13;
					}
					if(mao2.charAt(i)=='Q' && flagp2<12){
						flagk2=12;
					}
					if(mao2.charAt(i)=='J' && flagp2<11){
						flagk2=11;
					}
					if(mao2.charAt(i)=='T' && flagp2<10){
						flagk2=10;
					}
					if(Character.isDigit(mao2.charAt(i) )&& flagk2<Character.getNumericValue(mao2.charAt(i))){
						flagk2=Character.getNumericValue(mao2.charAt(i));
					}
				}
				
		if(flagp1>flagp2){
			return true;
		}if(flagp1==flagp2){
			return(flagk1>flagk2); 
		}
		else{
			return false;
		}
	}
}
