/*
 * URI online judge data structure problem 1110
 */
package ThrowingCardsAway;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Camilo Camargo
 */
public class ThrowingCardsAway {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 1,number = 1;
        
        while ((input = Integer.parseInt(br.readLine())) != 0){
            List deck = new List();
            List discardedCards = new List();
            for(int i = 0; i < input; i++){
                deck.insertAtEnd(new Node(number++));
            }
            while(deck.head.next != null){
                discardedCards.insertAtEnd(deck.head.clone());
                deck.deleteAtBegin();
                deck.insertAtEnd(deck.head.clone());
                deck.deleteAtBegin();
            }
            bw.write("Discarded cards: ");
            bw.flush();
            discardedCards.printList();
            bw.write("\nRemaining card: ");
            bw.flush();
            deck.printList();
            bw.newLine();
            bw.flush();
            deck.head = null;
            discardedCards.head = null;
            number = 1;
        }
    }
}
