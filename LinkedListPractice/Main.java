public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sl =new SinglyLinkedList();
        sl.insertfirst(11);
        sl.insertfirst(11);
 
        sl.insertfirst(21);
        sl.insertfirst(111);
        sl.display();
        // sl.insertLast(121);
        // sl.insertLast(221);
        sl.display();
        sl.deletefirst();
        sl.display();
        sl.deleteAtPos(2);
        sl.display();
        sl.insertAtPos(151, 3);
        sl.display();
        sl.insertfirst(11);
        sl.insertLast(11);
        sl.display();
        sl.deleteduplicates();
        sl.display();
    }
}
