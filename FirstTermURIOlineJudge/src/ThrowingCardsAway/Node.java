package ThrowingCardsAway;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Node {

    // Attributes:
    public int number;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node() {
        this.number = -1;
    }

    //nodo:
    public Node(int number) {
        this.number = number;
    }

    // metodo to string
    public String toString() {
        if(this.next == null)
            return ""+this.number;
        return this.number + ", ";
    }

    public Node clone() {
        Node clone = new Node(this.number);
        return clone;
    }
    
}
