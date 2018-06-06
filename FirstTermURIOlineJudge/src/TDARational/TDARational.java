package TDARational;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * problema 1022 de estructura de datos de URIonlinejudge 
 */

/**
 *
 * @author Camilo Camargo Convers
 * @dateo 12-02-2018
 */
public class TDARational {
    
    
    public static int[] simplify(int numerator,int denominator)
    {
        int i;
        int array[]= new int [2];
        for (i=100; i>0; i--)
        {
            if (numerator%i==0 && denominator%i==0)
            {
                numerator/=i;
                denominator/=i;
            }
            array[0]=numerator;
            array[1]=denominator;
        }
        return array;
    }
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n1, n2, d1, d2, numerator = 0, denominator = 0, cases, simplified[];
        String input;
        char operation;
        List operationList;

        try {

            do {
                cases = Integer.parseInt(br.readLine());
            } while (cases < 0 || cases > 10000);

            for (int i = 0; i < cases; i++) {
                input = br.readLine();
                operationList = new List();
                for (int j = 0; j < input.length(); j += 2) {
                    operationList.insertAtEnd(new Node(input.charAt(j)));
                }
                n1 = operationList.getInfo(0).character - 48;
                d1 = operationList.getInfo(2).character - 48;
                operation = operationList.getInfo(3).character;
                n2 = operationList.getInfo(4).character - 48;
                d2 = operationList.getInfo(6).character - 48;

                switch (operation) {
                    case '+' ://Suma: (N1*D2 + N2*D1) / (D1*D2)
                        numerator = (n1 * d2) + (n2 * d1);
                        denominator = d1 * d2;
                        break;
                    case '-' ://Resta: (N1*D2 - N2*D1) / (D1*D2)
                        numerator = (n1 * d2) - (n2 * d1);
                        denominator = d1 * d2;
                        break;
                    case '*' ://Multiplicación: (N1*N2) / (D1*D2)
                        numerator = n1 * n2;
                        denominator = d1 * d2;
                        break;
                    case '/' ://División: (N1/D1) / (N2/D2), esto es (N1*D2)/(N2*D1)
                        numerator = n1 * d2;
                        denominator = n2 * d1;
                        break;
                }
                simplified = simplify(numerator, denominator);
                bw.write(numerator + "/" + denominator + " = " + simplified[0] + "/" + simplified[1]);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException ex) {

        }

    }
}
