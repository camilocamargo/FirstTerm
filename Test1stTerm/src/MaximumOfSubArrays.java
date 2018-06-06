
import DataStructures.List;
import DataStructures.Node;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Camilo Camargo
 */
public class MaximumOfSubArrays {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List list = new List();
        String input;
        //int[] array;
        int N, K, bigger = 0, lower = 0, higher;
        //String[] temp;

        input = br.readLine();

        //temp = input.split(" ");
        N = Integer.parseInt(input.split(" ")[0]);
        K = Integer.parseInt(input.split(" ")[1]);

        higher = K;

        //array = new int [N];
        input = br.readLine();

        //temp = input.split(" ");
        for (int j = 0; j < N; j++) {
            list.insertAtEnd(new Node(Integer.parseInt(input.split(" ")[j])));
            //array[j] = Integer.parseInt(temp[j]);
        }

        while (higher <= N) {
            bigger = 0;
            for (int i = lower; i < higher; i++) {
                if (list.getInfo(i).number > bigger) {
                    bigger = list.getInfo(i).number;
                }
            }
            lower++;
            higher++;
            bw.write(bigger + " ");
            bw.flush();
        }

    }
}
