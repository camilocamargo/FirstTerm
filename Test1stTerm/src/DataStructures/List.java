package DataStructures;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/*
 * List class
 */
/**
 *
 * @author Camilo Camargo
 */
public class List {

    Node head = null;//Empty List

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

    public void updateAge(int index, int newAge) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.age = newAge;
    }

    public void searchForName(String name) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        name = name.toLowerCase();
        while (!temp.name.toLowerCase().equals(name) && temp.next != null) {
            temp = temp.next;
        }
        if (temp.name.toLowerCase().equals(name)) {
            bw.write("Name: " + temp.name + "\tAge: " + temp.age + "\tID: " + temp.number + "\n");
            bw.flush();
        } else {
            bw.write("node not found\n");
            bw.flush();
        }
    }

    public void searchForId(String id) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        while (!String.valueOf(temp.number).equals(id) && temp.next != null) {
            temp = temp.next;
        }
        if (String.valueOf(temp.number).equals(id)) {
            bw.write("Name: " + temp.name + "\tAge: " + temp.age + "\tID: " + temp.number + "\n");
            bw.flush();
        } else {
            bw.write("node not found\n");
            bw.flush();
        }
    }

    public void searchForAge(int age) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node temp = head;
        Node temp2;
        ArrayList<Node> matches = new ArrayList();
        do {
            if (temp.age == age) {
                matches.add(temp);
            }
            temp = temp.next;
        } while (temp.next != null);
        if (temp.age == age) {
            matches.add(temp);//ask one more time
        }
        if (matches.isEmpty()) {
            bw.write("no matches.\n");
            bw.flush();
        }

        for (int i = 0; i < matches.size(); i++) {
            temp2 = matches.get(i);
            bw.write("Name: " + temp2.name + "\tAge: " + temp2.age + "\tID: " + temp2.number + "\n");
            bw.flush();
        }
    }

    public void searchFor() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int option;

        bw.write("1.Name\n2.age\n3.ID\nOption: ");
        bw.flush();
        option = Integer.parseInt(br.readLine());

        switch (option) {
            case 1:
                bw.write("Name: ");
                bw.flush();
                String name = br.readLine();
                searchForName(name);
                break;
            case 2:
                bw.write("Age: ");
                bw.flush();
                int age = Integer.parseInt(br.readLine());
                searchForAge(age);
                break;
            case 3:
                bw.write("ID: ");
                bw.flush();
                String id = br.readLine();
                searchForId(id);
                break;
            default:
                break;
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
                if (temp.number < pivot.number) {
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
    
    public Node binarySearch(int id){ //falta arreglar cuando el dato a buscar no existe
        Node temp = head;
        int lower = 0, higher = size(), middle = (higher - lower)/2;
        
        while(middle != lower){
            for(int i = lower; i < middle - 1; i++){
                temp = temp.next;
            }
            if(temp.number == id){
                return temp;
            }
            else if(id > temp.number){
                lower = middle;
            }else{
                higher = middle;
                temp = head;
            }
            middle = lower + ((higher - lower)/2);
        }
        
         if(middle == lower){
                System.out.println("not found ID: "+id);
                temp = new Node();
                return temp;
         }
        return temp;
    }

}