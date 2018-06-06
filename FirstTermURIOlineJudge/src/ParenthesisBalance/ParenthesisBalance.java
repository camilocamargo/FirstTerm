/*
 * problema 1068 de URI online judge 
 */
package ParenthesisBalance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Camilo
 */
public class ParenthesisBalance {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = " ";
        List list;
        List parenthesis;
        int cont = 0, i;
        boolean opened = false,correct = false;
        
        while(!(input = br.readLine()).equals("")){
            list = new List();
            parenthesis = new List();
            for (i = 0; i < input.length(); i++) {
                list.insertAtEnd(new Node(input.charAt(i)));
            }
            for (i = 0; i < list.size(); i++) {
                if(list.getInfo(i).character == '(' || list.getInfo(i).character == ')')
                    parenthesis.insertAtEnd(new Node(list.getInfo(i).character));
            }
            cont = 0;
            for(i = 0; i < parenthesis.size(); i++){
                if(parenthesis.getInfo(i).character == '('){
                    cont++;
                }
                if(parenthesis.getInfo(i).character == ')' && cont > 0){
                    cont--;
                }else if(parenthesis.getInfo(i).character == ')' && cont == 0){
                    cont = -1;
                    break;
                }
            }
            if(cont == 0){
                bw.write("correct\n");
                bw.flush();
            }else{
                bw.write("incorrect\n");
                bw.flush();
            }
        }
    }
}
