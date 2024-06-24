package DoublyCircularLL;

public class Main {
    public static void main(String args[])
    {
        DoublyCircular dcl = new DoublyCircular();
        dcl.insertfirst(121);
        dcl.insertfirst(51);
        dcl.insertfirst(21);
        dcl.insertfirst(11);
        dcl.display();
        dcl.insertLast(151);
        dcl.insertLast(201);
        dcl.display();
        dcl.insertAtPos(+221, 7);
        dcl.display();
        dcl.insertAtPos(101, 4);
        dcl.display();
        dcl.deleteFirst();
        dcl.deleteFirst();
        dcl.display();
        dcl.deleteLast();
        dcl.deleteLast();
        dcl.display();
        dcl.deleteAtPos(3);
        dcl.display();
        dcl.deleteAtPos(5);
        dcl.deleteAtPos(3);
        dcl.display();
    }
}
