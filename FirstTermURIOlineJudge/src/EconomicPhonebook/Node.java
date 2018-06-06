package EconomicPhonebook;

import GoingToTheMarket.*;

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
    public char character;
    public String product;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node(){}
    
    public Node (char character){
        this.character = character;
    }

    // metodo to string
    public String toString() {
        if(this.next == null)
            return ""+this.character;
        return this.character + ", ";
    }

    public Node clone() {
        Node clone = new Node(this.character);
        return clone;
    }
    
}
