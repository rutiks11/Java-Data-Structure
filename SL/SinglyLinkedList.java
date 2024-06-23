public class SinglyLinkedList {
    Node head;
    int iCount;

    SinglyLinkedList() {
        head = null;
    }

    // InsertFirst
    public boolean insertfirst(int data) {
        // Creating the new Node
        Node newn = new Node(data);

        // Checking if head is null then insert new node into head
        if (head == null) {
            head = newn;
        } else {
            newn.setNext(head);
            head = newn;
        }
        iCount++;
        return true;
    }

    public boolean insertLast(int data) {
        Node newn = new Node(data);
        Node temp = head;

        if (head == null) {
            head = newn;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newn);
        }
        iCount++;
        return true;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getData() + "-->");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    public int count() {
        return iCount;
    }

    public boolean insertAtPos(int data, int iPos) {
        Node temp = head;

        // return if iPosition is wrong
        if ((iPos < 0) && (iPos > iCount + 1)) {
            return false;
        }

        if (iPos == 1) {
            insertfirst(data);
            return true;
        } else if (iPos == iCount + 1) {
            insertLast(data);
            return true;
        } else {
            // Create a new Node
            Node newn = new Node(data);
            for (int i = 1; i < iPos - 1; i++) {
                temp = temp.getNext();
            }
            newn.setNext(temp.getNext());
            temp.setNext(newn);

            iCount++;
            return true;
        }
    }

    public boolean deletefirst() {
        if (head == null) {
            return false;
        } else { // LL contains only one Node
            head = head.getNext();
            iCount--;
            return true;
        }
    }

    public boolean deleteLast() {
        Node temp = head;
        if (temp == null) {
            return false;
        } else if (temp.getNext() == null) {
            temp = temp.getNext();
            iCount--;
            return true;
        } else {
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            iCount--;
            return true;
        }
    }

    public boolean deleteAtPos(int iPos) {
        if (iPos == 1) {
            return deletefirst();
        } else if (iPos == iCount + 1) {
            return deleteLast();
        } else {
            Node temp = head;

            for(int iCnt = 1; iCnt < iPos -1 ; iCnt++)
            {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            iCount--;
            return true;
        }
    }
}
