package GoingToTheMarket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * List class
 */
/**
 *
 * @author Camilo Camargo
 */
public class List {

    public Node head = null;//Empty List

    public boolean isEmpty() {
        // operador ternario.
        return head == null ? true : false;
    }

    public void insertAtEnd(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void insertAtIndex(Node newNode, int Index) {
        Node temp;
        Node pre = head;
        for (int i = 0; i < Index - 1; i++) {
            pre.next = pre;
        }
        temp = pre.next;
        newNode.next = temp;
        pre.next = newNode;
    }

    public void insertAtBegin(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    public void deleteAtBegin() {
        Node temp = head;
        head = head.next;
        temp = null;
        System.gc();
    }

    public void deleteAtEnd() {
        Node temp;
        Node pre = head;
        while (pre.next.next != null) {
            pre = pre.next;
        }
        temp = pre.next;
        pre.next = null;
        temp = null;
        System.gc();
    }

    public Node getInfo(int index) {
        if (size() < index) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp;
        }
    }

    public void printList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        while (temp != null) {
            bw.write(temp.toString());
            temp = temp.next;
        }
        bw.flush();

    }
//
//    public void reverse() {
//        Stack tempList = new Stack();
//        Node temp = head;
//
//        while (temp != null) {
//
//            tempList.push(temp.clone());
//            temp = temp.next;
//        }
//        head = tempList.head;
//    }

    public int size() {
        int size = 0;
        Node temp = head;
        if (isEmpty()) {
            return size = 0;
        }
        while (temp.next != null) {
            size += 1;
            temp = temp.next;
        }

        return ++size;
    }

    public void deleteIndex(int index) {
        Node pre = head;
        Node temp = pre.next;
        for (int i = 0; i < index - 2; i++) {
            pre = pre.next;
            temp = pre.next;
        }
        pre.next = temp.next;
        temp.next = null;
        temp = null;
        System.gc();
    }

    
    public void searchForNumber(String number) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        while (!String.valueOf(temp.number).equals(number) && temp.next != null) {
            temp = temp.next;
        }
        if (String.valueOf(temp.number).equals(number)) {
            bw.write("Number: " + temp.number+ "\n");
            bw.flush();
        } else {
            bw.write("node not found\n");
            bw.flush();
        }
    }
    
    public void quickSort() {
        if (!isEmpty()) {
            List leftList = new List();
            List rightList = new List();
            //List sorted = new List();
            Node pivot = head;
            Node temp = head.next;

            while (temp != null) {
                if (temp.product.compareTo(pivot.product) < 0) {
                    leftList.insertAtEnd(temp.clone());
                } else {
                    rightList.insertAtEnd(temp.clone());
                }
                temp = temp.next;
            }
            leftList.quickSort();
            rightList.quickSort();
            pivot.next = rightList.head;
            leftList.insertAtEnd(pivot);
            head = leftList.head;
        }
    }
    
    public Node binarySearch(int number){ //falta arreglar cuando el dato a buscar no existe
        Node temp = head;
        int lower = 0, higher = size(), middle = (higher - lower)/2;
        
        while(middle != lower){
            for(int i = lower; i < middle; i++){
                temp = temp.next;
            }
            if(temp.number == number){
                return temp;
            }
            else if(number > temp.number){
                lower = middle;
            }else{
                higher = middle;
                temp = head;
            }
            middle = lower + ((higher - lower)/2);
        }
        
        if(middle == 0){
           if(temp.number == number){
                return temp;
            } 
        }
        
        if(lower == middle){
                System.out.println(number+" not found.");
                temp = new Node();
                return temp;
        }
        return temp;
    }

}