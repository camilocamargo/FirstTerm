package WhereIsTheMarble;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * URI online judge data structure problem 1025
 */

/**
 *
 * @author Camilo Camargo
 */

public class WhereIsTheMarble {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        List marbles = new List();
        int n, q, index = 1,cases = 1;
        
        while (!input.equals("0 0")){
            input = br.readLine();
            n = Integer.parseInt(input.split(" ")[0]);
            q = Integer.parseInt(input.split(" ")[1]);
            for (int i = 0; i < n; i++) {
                input = br.readLine();
                marbles.insertAtEnd(new Node(Integer.parseInt(input),++index));
            }
            for (int i = 0; i < q; i++) {
                input = br.readLine();
                bw.write("CASE# "+cases+++":\n");
                bw.flush();
                marbles.quickSort();
                Node temp = marbles.binarySearch(Integer.parseInt(input));
                if(temp.number!=-1){
                    bw.write(temp.number+" found at "+temp.index+"\n");
                    bw.flush();
                }
            }
            marbles.head = null;
            index = 1;
        }
    }
}
