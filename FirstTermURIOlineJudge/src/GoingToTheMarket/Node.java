package GoingToTheMarket;

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
    public double number;
    public String product;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node() {
        this.number = -1;
    }

    //nodo:
    public Node(String product, double number) {
        this.product = product;
        this.number = number;
    }

    // metodo to string
    public String toString() {
        if(this.next == null)
            return ""+this.number;
        return this.number + ", ";
    }

    public Node clone() {
        Node clone = new Node(this.product, this.number);
        return clone;
    }
    
}
