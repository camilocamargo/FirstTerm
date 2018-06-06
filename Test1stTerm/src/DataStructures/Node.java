package DataStructures;

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
    public String name;
    public int age;
    public int number;

    //int* ponter = &a; en c/c++
    public Node next;// <--- point to the next element
    public Node previous;//<--point to the previous element

    public Node() {}
    
    public Node(int number) {
        this.number = number;
    }
    
    public Node(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    /*public String toString() {
        return "Name: " + this.name + "\tAge:" + this.age + "\tId: " + this.id + "\n";
    }*/
    
    public String toString(){
        return "ID: " + this.number + "\n"; 
    }

    public Node clone() {
        Node clone = new Node(this.name, this.age, this.number);
        return clone;
    }
    
}
