
import SandAndDiamonds.List;
import SandAndDiamonds.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 *problem 1069 uri online judge
 */
/**
 *
 * @author Camilo Camargo
 */
public class SandAndDiamond {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        List signs;//to save only the < , > in the temp array.
        List list;
        int cases = 0, cont = 0, diamonds = 0, i;

        cases = Integer.parseInt(br.readLine());
        while(cases-- > 0) {
            diamonds = 0;
            list = new List();
            signs = new List();
            input = br.readLine();

            for (i = 0; i < input.length(); i++) {
                list.insertAtEnd(new Node(input.charAt(i)));
            }

            for (i = 0; i < list.size(); i++) { //save the <,> in the signs array
                if (list.getInfo(i).character == '>' || list.getInfo(i).character == '<') {
                    signs.insertAtEnd(new Node(list.getInfo(i).character));
                }
            }

            for (int j = 0; j < signs.size(); j++) {
                if (signs.getInfo(j).character == '<') {
                    cont++;
                }
                if (signs.getInfo(j).character == '>' && cont > 0) {
                    cont--;
                    diamonds++;
                }
            }
            bw.write(diamonds + "\n");
            bw.flush();
        }

    }
}
