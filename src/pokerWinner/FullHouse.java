package pokerWinner;

public class FullHouse {
	public boolean testaFullHouse(String mao){
		int flagPar=0;
		int flagTrinca=0;
		char flagTrincaChar='0';
		for(int i=0; i<mao.length();i+=2){
			int j=i+2;
			int cont=0;
			while(j<mao.length()){
				if(mao.charAt(i)==mao.charAt(j)){
					cont+=1;
				}
				j+=2;
			}
			if (cont>2){
				return false;
			}
			if(cont==1 && (mao.charAt(i)!=flagTrincaChar)){
				flagPar+=1;
			}
			if(cont==2){
				flagTrinca+=1;
				flagTrincaChar=mao.charAt(i);
			}
		}
		if(flagTrinca==1 && flagPar==1){
			return true;
		}else{
			return false;
		}	
	}
	
	public boolean desempata(String mao1, String mao2){
		int flagt1=0;
		int flagt2=0;
		for(int i=0; i< mao1.length(); i+=2){
			int cont =0;
			int j=i+2;
			while(j<mao1.length()){
				if (mao1.charAt(i)==mao1.charAt(j)){
					cont+=1;
				}
				if (cont==2){
					if (mao1.charAt(j)=='A'){
						flagt1=14;
					}
					if (mao1.charAt(j)=='K'){
						flagt1=13;
					}
					if (mao1.charAt(j)=='Q'){
						flagt1=12;
					}
					if (mao1.charAt(j)=='J'){
						flagt1=11;
					}
					if (mao1.charAt(j)=='T'){
						flagt1=10;
					}
					if(Character.isDigit(mao2.charAt(j))){
						flagt1=Character.getNumericValue(mao1.charAt(j));
					}
					break;
				}j+=2;
			}
		}
		for(int i=0; i< mao2.length(); i+=2){
			int cont =0;
			int j=i+2;
			while(j<mao2.length()){
				if (mao2.charAt(i)==mao2.charAt(j)){
					cont+=1;
				}
				if (cont==2){
					if (mao2.charAt(j)=='A'){
						flagt2=14;
					}
					if (mao2.charAt(j)=='K'){
						flagt2=13;
					}
					if (mao2.charAt(j)=='Q'){
						flagt2=12;
					}
					if (mao2.charAt(j)=='J'){
						flagt2=11;
					}
					if (mao2.charAt(j)=='T'){
						flagt2=10;
					}
					if(Character.isDigit(mao2.charAt(j))){
						flagt2=Character.getNumericValue(mao2.charAt(j));
					}
					break;
				}j+=2;
			}
		}
		if(flagt1>flagt2){
			return true;
		}
		else{
			return false;
		}
	}
}
