package pokerWinner;

import java.util.Arrays;

public class CartaAlta {
	public  boolean testa(String mao){
		for (int i=0; i<mao.length(); i+=2){
			int j=2;
			while(j<mao.length()){
				if (j>i && mao.charAt(i)==(mao.charAt(j))){
					return false;
				}
				j+=2;
			}
		}
		return true;
	}
	public boolean desempata(String mao1, String mao2){
		int []flag1=new int [5];
		int []flag2=new int[5];
		for(int i=0; i<mao1.length();i+=2){
			if(mao1.charAt(i)=='A'){
				flag1[0]=14;
				Arrays.sort(flag1);
				}
			if(mao1.charAt(i)=='K'){
				flag1[0]=13;
				Arrays.sort(flag1);
				}
			if(mao1.charAt(i)=='Q'){
				flag1[0]=12;
				Arrays.sort(flag1);
				}
			if(mao1.charAt(i)=='J'){
				flag1[0]=11;
				Arrays.sort(flag1);
				}
			if(mao1.charAt(i)=='T'){
				flag1[0]=10;
				Arrays.sort(flag1);
				}
			if(Character.isDigit(mao1.charAt(i))){
				flag1[0]=Character.getNumericValue(mao1.charAt(i));
				Arrays.sort(flag1);
			}
		}
		for(int i=0; i<mao2.length();i+=2){
			if(mao2.charAt(i)=='A'){
				flag2[0]=14;
				Arrays.sort(flag2);
				}
			if(mao2.charAt(i)=='K'){
				flag2[0]=13;
				Arrays.sort(flag2);
				}
			if(mao2.charAt(i)=='Q'){
				flag2[0]=12;
				Arrays.sort(flag2);
				}
			if(mao2.charAt(i)=='J'){
				flag2[0]=11;
				Arrays.sort(flag2);
				}
			if(mao2.charAt(i)=='T'){
				flag2[0]=10;
				Arrays.sort(flag2);
				}
			if(Character.isDigit(mao2.charAt(i))){
				flag2[0]=Character.getNumericValue(mao2.charAt(i));
				Arrays.sort(flag2);
			}
		}
		Arrays.sort(flag1);
		Arrays.sort(flag2);
		for(int i=flag1.length-1;i>0;i--){
			if(flag1[i]<flag2[i]){
				return false;
			}
			if(flag1[i]>flag2[i]){
				//System.out.println("i="+i+" "+mao1+"  "+mao2+" kicker 1= "+flag1[i]+" kicker 2 ="+flag2[i]+" "+Arrays.toString(flag1)+Arrays.toString(flag2));
				return true;

			}
		}

		return false;
	}
}



