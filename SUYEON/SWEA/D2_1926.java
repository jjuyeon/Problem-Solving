package SWEA;

import java.util.Scanner;

public class D2_1926 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        N=sc.nextInt();

        for(int i=1; i<=N; i++){
            String itos = Integer.toString(i);

            if(itos.contains("3") || itos.contains("6") || itos.contains("9")){
                for(int j=0; j<itos.length(); j++){
                    if(itos.charAt(j) == '3' || itos.charAt(j) == '6' || itos.charAt(j) == '9'){
                        System.out.print("-");
                    }
                }
            }else{
                System.out.print(itos);
            }
            System.out.print(" ");
        }
    }
}
