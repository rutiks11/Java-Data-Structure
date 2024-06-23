public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertfirst(121);
        sl.insertfirst(51);
        sl.insertfirst(21);
        sl.display();
        sl.insertLast(151);
        sl.insertLast(201);
        sl.insertLast(221);
        sl.display();
        System.out.println("Number of Nodes "+sl.count());
        sl.insertAtPos(101,3);
        sl.display();
        sl.deletefirst();
        sl.deletefirst();
        sl.display();
        sl.deleteLast();
        sl.display();
        sl.deleteLast();
        sl.deleteLast();
        sl.display();
        sl.insertfirst(11);
        sl.insertfirst(21);
        sl.display();
        sl.deleteAtPos( 3);
        sl.display();
        System.out.println("Number of Nodes "+sl.count());
    }
}
