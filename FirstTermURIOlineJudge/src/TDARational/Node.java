package TDARational;

import ParenthesisBalance.*;
import SandAndDiamonds.*;

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
    public int index;

    //int* ponter = &a; en c/c++
    public Node next;// <--- Este es el puntero

    public Node(){}
    //nodo:
    public Node(char character,int index) {
        this.character = character;
        this.index = index;
    }
    
    public Node(char character){
        this.character = character;
    }

    
    public Node clone() {
        Node clone = new Node(this.character,this.index);
        return clone;
    }
    
}
