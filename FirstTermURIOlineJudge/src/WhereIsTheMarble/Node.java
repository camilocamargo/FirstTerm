package WhereIsTheMarble;
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
    public int index;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node() {
        this.number = -1;
    }

    //nodo:
    public Node(int number,int index) {
        this.number = number;
        this.index = index;
    }

    // metodo to string
    public String toString() {
        return "Number: " + this.number + "\n";
    }

    public Node clone() {
        Node clone = new Node(this.number,this.index);
        return clone;
    }
    
}
