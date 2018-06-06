
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
public class LongATMQueue {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List ATMQueue = new List();
        int N ,groups = 0, index = 0;
        boolean increasing = false, decreasing = false;
        
        
        N = Integer.parseInt(br.readLine());
        
        input = br.readLine();
        for (int i = 0; i < N; i++){
            ATMQueue.insertAtEnd(new Node(Integer.parseInt(input.split(" ")[i])));
        }
        
        
        for (int j = 0; j < N; j++){
            if(ATMQueue.getInfo(j).number < ATMQueue.getInfo(j + 1).number){
                increasing = true;
                while(increasing && j < ATMQueue.size() - 1){
                    if (ATMQueue.getInfo(j).number > ATMQueue.getInfo(j + 1).number)
                        increasing = false;
                    j++;
                }
                groups++;
            }else{
                if(ATMQueue.getInfo(j).number > ATMQueue.getInfo(j + 1).number){
                    decreasing = true;
                    while (decreasing && j < (ATMQueue.size() - 1)){
                        if(ATMQueue.getInfo(j).number < ATMQueue.getInfo(j + 1).number)
                            decreasing = false;
                        j++;
                    }
                    groups++;
                }
            }
            
        }
        
        
        bw.write(groups+" ");
        bw.flush();  
    }
    
}
