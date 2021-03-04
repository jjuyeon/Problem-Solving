package BOJ;

import java.util.*;
import java.io.*;

public class BOJ16506 {
    static String[] op = {"ADD", "SUB", "MOV", "AND", "OR", "NOT", "MULT", "LSFTL", "LSFTR", "ASFTR", "RL", "RR"};
    static String[] op_to_as = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            printAssembly(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
        }
    }

    private static void printAssembly(String opcode, String rd, String ra, String rb_c){
        StringBuilder sb = new StringBuilder();
        // opcode 처리
        String code = setOpcode(opcode);
        sb.append(code);
        // 사용하지 않는 bit 처리
        sb.append("0");
        // rD 처리
        sb.append(setRegister(rd,3));
        // rA 처리
        sb.append(setRegister(ra,3));

        if(code.charAt(4) == '1'){ // #C 처리
            sb.append(setRegister(rb_c, 4));
        }
        else if(code.charAt(4) == '0'){ // rB 처리
            sb.append(setRegister(rb_c, 3));
            sb.append("0");
        }

        System.out.println(sb.toString());
    }

    private static String setRegister(String register, int len){
        int num = Integer.parseInt(register);
        StringBuilder result = new StringBuilder();
        while(len>0){
            result.append(num % 2);
            num /= 2;
            --len;
        }
        return result.reverse().toString();
    }

    private static String setOpcode(String opcode){
        for(int i=0; i<op.length; i++){
            if(opcode.contains(op[i])){
                if(opcode.equals(op[i]+"C")){
                    return op_to_as[i]+"1";
                }
                else{
                    return op_to_as[i]+"0";
                }
            }
        }
        return "";
    }
}
