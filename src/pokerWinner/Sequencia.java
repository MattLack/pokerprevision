package pokerWinner;

import java.util.Arrays;

public class Sequencia {

	public boolean testaSequencia(String mao){
		int [] cartas=new int[5]; 
		for(int i =0; i<mao.length();i+=2){
			if(mao.charAt(i)=='A'){
				for(int i1=0; i1<cartas.length; i1+=1){
					if(cartas[i1] ==0){
						cartas[i1] = 14;
						break;
					}       
				}   
			}
			if(mao.charAt(i)=='K'){
				for(int i1=0; i1 < cartas.length; i1+=1){
					if(cartas[i1] == 0){
						cartas[i1] = 13;
						break;
					}   
				}  
			}
			if(mao.charAt(i)=='Q'){
				for(int i1=0; i1 < cartas.length; i1+=1){
					if(cartas[i1] == 0){
						cartas[i1] = 12;
						break;
					}  
				}   
			}
			if(mao.charAt(i)=='J'){
				for(int i1=0; i1 < cartas.length; i1+=1){
					if(cartas[i1] == 0){
						cartas[i1] = 11;
						break;
					}    
				}    
			}
			if(mao.charAt(i)=='T'){
				for(int i1=0; i1 < cartas.length; i1+=1){
					if(cartas[i1] == 0){
						cartas[i1] = 10;
						break;
					}   
				}
			}
			if(Character.isDigit(mao.charAt(i))){
				for(int i1=0; i1 < cartas.length; i1+=1){
					if(cartas[i1] == 0){
						cartas[i1] = Character.getNumericValue(mao.charAt(i));
						break;
					} 
				}   
			}
		}
		Arrays.sort(cartas);
		if(cartas[4]==14 && cartas[0]==2){
			int []cartas1=cartas.clone();
			cartas1[4]=1;
			Arrays.sort(cartas1);
			for (int j1=0;j1<cartas1.length-1;j1+=1){
				if(cartas1[j1+1]-cartas1[j1]!=1){
					return false;
				}
			}return true;
		}
		if(cartas[4]<=14 && cartas[0]>=2){
			for (int j1=0;j1<cartas.length-1;j1+=1){
				if(cartas[j1+1]-cartas[j1]!=1){
					return false;
				}
			}
		}return true;
	}
	public boolean desempata(String mao1, String mao2){
		int [] cartas1=new int[5]; 
		int [] cartas2=new int[5];
		for(int i =0; i<mao1.length();i+=2){
			if(mao1.charAt(i)=='A'){
				for(int i1=0; i1 < cartas1.length; i1+=1){
					if(cartas1[i1] == 0){
						cartas1[i1] = 14;
						break;
					}
				}	
			}
			if(mao1.charAt(i)=='K'){
				for(int i1=0; i1 < cartas1.length; i1++){
					if(cartas1[i1] == 0){
						cartas1[i1] = 13;
						break;
					}
				}	
			}
			if(mao1.charAt(i)=='Q'){
				for(int i1=0; i1 < cartas1.length; i1++){
					if(cartas1[i1] == 0){
						cartas1[i1] = 12;
						break;
					}
				}	
			}
			if(mao1.charAt(i)=='J'){
				for(int i1=0; i1 < cartas1.length; i1++){
					if(cartas1[i1] == 0){
						cartas1[i1] = 11;
						break;
					}
				}	
			}
			if(mao1.charAt(i)=='T'){
				for(int i1=0; i1 < cartas1.length; i1++){
					if(cartas1[i1] == 0){
						cartas1[i1] = 10;
						break;
					}
				}	
			}
			if(Character.isDigit(mao1.charAt(i))){
				for(int i1=0; i1 < cartas1.length; i1++){
					if(cartas1[i1] == 0){
						cartas1[i1] = Character.getNumericValue(mao1.charAt(i));
						break;
					}	
				}		
			}
		}
		for(int i =0; i<mao2.length();i+=2){
			if(mao2.charAt(i)=='A'){
				for(int i1=0; i1 < cartas2.length; i1++){
					if(cartas2[i1] == 0){
						cartas2[i1] = 14;
						break;
					}
				}	
			}
			if(mao2.charAt(i)=='K'){
				for(int i1=0; i1 < cartas2.length; i1++){
					if(cartas2[i1] == 0){
						cartas2[i1] = 13;
						break;
					}
				}	
			}
			if(mao2.charAt(i)=='Q'){
				for(int i1=0; i1 < cartas2.length; i1++){
					if(cartas2[i1] == 0){
						cartas2[i1] = 12;
						break;
					}
				}	
			}
			if(mao2.charAt(i)=='J'){
				for(int i1=0; i1 < cartas2.length; i1++){
					if(cartas2[i1] == 0){
						cartas2[i1] = 11;
						break;
					}
				}	
			}
			if(mao2.charAt(i)=='T'){
				for(int i1=0; i1 < cartas2.length; i1++){
					if(cartas2[i1] == 0){
						cartas2[i1] = 10;
						break;
					}
				}	
			}
			if(Character.isDigit(mao2.charAt(i))){
				for(int i1=0; i1 < cartas2.length; i1++){
					if(cartas2[i1] == 0){
						cartas2[i1] = Character.getNumericValue(mao2.charAt(i));
						break;
					}	
				}		
			}
		}
		Arrays.sort(cartas1);
		Arrays.sort(cartas2);
		if(cartas1[4]==14 && cartas1[0]==2){
			if(cartas1[3]<cartas2[4]){
				return false;
			}
		}
		if(cartas1[4]>cartas2[4]){
			return true;
		}
		else{
			return false;
		}
	}
}

