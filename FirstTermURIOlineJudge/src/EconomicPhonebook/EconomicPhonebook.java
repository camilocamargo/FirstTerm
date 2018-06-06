/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EconomicPhonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Camilo Camargo
 */
public class EconomicPhonebook {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List phoneNumber;
        List phone_number;
        int i, j, k, cases, counter;
        try {
            String input;
            
            while (!(input = br.readLine()).equals("")) {
                cases = Integer.parseInt(input);
                counter = 0;
                phone_number = new List();
                input = br.readLine();
                
                for (i = 0; i < input.length(); i++) {
                    phone_number.insertAtEnd(new Node(input.charAt(i)));
                }

                for (i = 1; i < cases; i++) {
                    input = br.readLine();
                    phoneNumber = new List();
                    for (k = 0; k < input.length(); k++) {
                        phoneNumber.insertAtEnd(new Node(input.charAt(k)));
                    }
                    
                    for(j = 0; j < phoneNumber.size(); j++){
                        if (phone_number.getInfo(j).character == phoneNumber.getInfo(j).character) {
                            counter++;
                        }else{
                            break;
                        }
                    }
                }
                bw.write(counter + "\n");
                bw.flush();
            }
        } catch (Exception es) {
        }

    }
}
