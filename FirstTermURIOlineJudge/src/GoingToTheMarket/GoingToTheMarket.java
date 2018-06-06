/*
 * URI online judge 1281
 */
package GoingToTheMarket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

/**
 *
 * @author Camilo Camargo
 */
public class GoingToTheMarket {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat df = new DecimalFormat("#.00");

        int cases, m, p, product; //number of products with price and p number of products with quantity
        double amount = 0;
        String[] input;

        cases = Integer.parseInt(br.readLine());

        while (cases-- > 0) {
            List price = new List();
            List quantity = new List();
            m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                input = br.readLine().split(" ");
                price.insertAtEnd(new Node(input[0], Double.parseDouble(input[1])));
            }
            price.quickSort();
            p = Integer.parseInt(br.readLine());
            while (p-- > 0) {
                input = br.readLine().split(" ");
                quantity.insertAtEnd(new Node(input[0], Double.parseDouble(input[1])));
            }
            quantity.quickSort();
            Node temp = price.head;
            Node temp2 = quantity.head;
            while (true) {
                while (true) {
                    if (temp.product.equals(temp2.product)) {
                        amount += (temp.number * temp2.number);
                        break;
                    }
                    temp2 = temp2.next;
                    if (temp2.next == null) {
                        if (temp.product.equals(temp2.product)) {
                            amount += (temp.number * temp2.number);
                        }
                        break;
                    }
                }
                if(temp.next == null && temp2.next == null)
                    break;
                temp = temp.next;
                temp2 = quantity.head;
                
            }
            bw.write("R$ " + df.format(amount) + "\n");
            bw.flush();
            amount = 0;
        }
    }
}
