package pokerWinner;

public class DoisPares {
	public boolean testaDoisPares(String mao){
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
		if(flagPar==2){
			return true;
		}
		else{
			return false;
		}		
	}

	public boolean desempata(String mao1, String mao2){
		int flagp11=0;
		int flagp12=0;
		int flagp21=0;
		int flagp22=0;
		int flagk1=0;
		int	flagk2=0;
		//Pega flag do par1
		for(int i=0; i<mao1.length();i+=2){
			int j=i+2;
			int cont=0;
			while(j<mao1.length()){
				if(mao1.charAt(i)==mao1.charAt(j)){
					cont+=1;
					if(mao1.charAt(i)=='A'){
						if(flagp11==0){
							flagp11=14;
						}
						else{
							flagp12=14;
						}
					}
					if(mao1.charAt(i)=='K'){
						if(flagp11==0){
							flagp11=13;
						}
						else{
							flagp12=13;
						}
					}
					if(mao1.charAt(i)=='Q'){
						if(flagp11==0){
							flagp11=12;
						}
						else{
							flagp12=12;
						}
					}
					if(mao1.charAt(i)=='J'){
						if(flagp11==0){
							flagp11=11;
						}
						else{
							flagp12=11;
						}
					}
					if(mao1.charAt(i)=='T'){
						if(flagp11==0){
							flagp11=10;
						}
						else{
							flagp12=10;
						}
					}
					if(Character.isDigit(mao1.charAt(i))){
						if(flagp11==0){
							flagp11=Character.getNumericValue(mao1.charAt(i));
						}
						else{
							flagp12=Character.getNumericValue(mao1.charAt(i));
						}
					}

				}
				j+=2;
			}
			if (cont>1){
				break;
			}
		}
		//pega flag do kicker
		for(int i=0;i<mao1.length();i+=2){
			if(mao1.charAt(i)=='A' && flagp11<14 && flagp12<14){	
				flagk1=14;
			}
			if(mao1.charAt(i)=='K' && flagp11<13 && flagp12<13){
				flagk1=13;
			}
			if(mao1.charAt(i)=='Q' && flagp11<12 && flagp12<12){
				flagk1=12;
			}
			if(mao1.charAt(i)=='J' && flagp11<11 && flagp12<11){
				flagk1=11;
			}
			if(mao1.charAt(i)=='T' && flagp11<10 && flagp12<10){
				flagk1=10;
			}
			if(Character.isDigit(mao1.charAt(i))&& flagk1<Character.getNumericValue(mao1.charAt(i))){
				flagk1=Character.getNumericValue(mao1.charAt(i));
			}
		}

		//Pega flag do par11 12
		for(int i=0; i<mao2.length();i+=2){
			int j=i+2;
			int cont=0;
			while(j<mao2.length()){
				if(mao2.charAt(i)==mao2.charAt(j)){
					cont+=1;
					if(mao2.charAt(i)=='A'){
						if(flagp21==0){
							flagp21=14;
						}
						else{
							flagp22=14;
						}
					}
					if(mao2.charAt(i)=='K'){
						if(flagp21==0){
							flagp21=13;
						}
						else{
							flagp22=13;
						}
					}
					if(mao2.charAt(i)=='Q'){
						if(flagp21==0){
							flagp21=12;
						}
						else{
							flagp22=12;
						}
					}
					if(mao2.charAt(i)=='J'){
						if(flagp21==0){
							flagp21=11;
						}
						else{
							flagp22=11;
						}
					}
					if(mao2.charAt(i)=='T'){
						if(flagp21==0){
							flagp21=10;
						}
						else{
							flagp22=10;
						}
					}
					if(Character.isDigit(mao2.charAt(i))){
						if(flagp21==0){
							flagp21=Character.getNumericValue(mao2.charAt(i));
						}
						else{
							flagp22=Character.getNumericValue(mao2.charAt(i));
						}
					}

				}
				j+=2;
			}
			if (cont>1){
				break;
			}
		}
		//pega flag do kicker p21 p22
		for(int i=0;i<mao2.length();i+=2){
			if(mao2.charAt(i)=='A' && flagp21<14 && flagp22<14){	
				flagk2=14;
			}
			if(mao2.charAt(i)=='K' && flagp21<13 && flagp22<13){
				flagk2=13;
			}
			if(mao2.charAt(i)=='Q' && flagp21<12 && flagp22<12){
				flagk2=12;
			}
			if(mao2.charAt(i)=='J' && flagp21<11 && flagp22<11){
				flagk2=11;
			}
			if(mao2.charAt(i)=='T' && flagp21<10 && flagp22<10){
				flagk2=10;
			}
			if(Character.isDigit(mao2.charAt(i))&& flagk2<Character.getNumericValue(mao2.charAt(i))){
				flagk2=Character.getNumericValue(mao2.charAt(i));
			}
		}		
		//System.out.println(mao1+" "+mao2+" flags -11 12- "+flagp11+" "+flagp12+" Flags -21 22- "+flagp21+" "+flagp22+ " kickers "+flagk1+" "+flagk2);
		if(flagp11>flagp21 && flagp11>flagp22 || flagp12>flagp21 && flagp12>flagp22){
			return true;
		}if(flagp11==flagp21 && flagp12==flagp22 || flagp11==flagp22 && flagp12==flagp21){
			return(flagk1>flagk2); 
		}
		else{
			return false;
		}
	}

}
