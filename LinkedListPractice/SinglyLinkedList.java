public class SinglyLinkedList {
    private Node head;
    private int iCount;

    SinglyLinkedList() {
        head = null;
        iCount = 0;
    }

    public void display() {
        Node temp = head;
        for (int i = 0; i < iCount; i++) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public boolean insertfirst(int data) {
        Node newn = new Node(data);

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

        if (head == null) {
            head = newn;
        } else {
            Node temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newn);
        }
        iCount++;
        return true;
    }

    public boolean insertAtPos(int data, int iPos) {
        if (iPos == 1) {
            return insertfirst(data);
        } else if (iPos == iCount + 1) {
            return insertLast(data);
        } else {
            Node temp = head;
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
        } else if (head.getNext() == null) {
            head = null;
            iCount--;
            return true;
        } else {
            head = head.getNext();
            iCount--;
            return true;
        }
    }

    public boolean deletelast() {
        if (head == null) {
            return false;
        } else if (head.getNext() == null) {
            head = null;
            iCount--;
            return true;
        } else {
            Node temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            iCount--;
            return true;
        }
    }

    public boolean deleteAtPos(int iPos) {
        if (iPos < 1 && iPos > iCount) {
            return false;
        }
        if (iPos == 1) {
            return deletefirst();
        } else if (iPos == iCount) {
            return deletelast();
        } else {
            Node temp = head;
            for (int i = 1; i < iPos - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            iCount--;
            return true;
        }
    }

    public boolean deleteduplicates() {
        Node check = head;
        Node trav = head.getNext();
        Node parent = head;

        while (check.getNext().getNext() != null) {
            while (trav.getNext() != null) {
                if (check.getData() == trav.getData()) {
                    parent.setNext(trav.getNext());
                    iCount--;
                }

                parent = trav;
                trav = trav.getNext();

            }
            if (trav.getData() == check.getData()) {
                parent.setNext(trav.getNext());
                System.out.println("IN");
                iCount--;
            }
            check = check.getNext();
            trav = check.getNext();
            parent = check;
        }

        return true;
    }
}
