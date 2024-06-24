package DoublyCircularLL;

public class DoublyCircular {
    private Node head;
    private Node tail;
    private int iCount;

    DoublyCircular()
    {
        head = tail = null;
    }


    // Insert First
    public boolean insertfirst(int data)
    {
        Node newn = new Node(data);
        if(head == null && tail == null)
        {
            head = newn;
            tail = newn;
        }else{
            newn.setNext(head);
            head.setPrev(newn);

            head = newn;
        }
        tail.setNext(head);
        head.setPrev(tail);
        iCount++;
        return true;
    }

    public void display()
    {
        Node temp = head;
        do{
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }while(temp != tail.getNext());
        System.out.println();
    }

    // to insert node at last
    public boolean insertLast(int data)
    {
        // Create a Node
        Node newn = new Node(data);
        
        if(head == null && tail == null){
            head = newn;
            tail = newn;
        }else{
            newn.setPrev(tail);
            tail.setNext(newn);
            tail = newn;
        }
        tail.setNext(head);
        head.setPrev(tail);
        iCount++;
        return true;
    }

    public boolean insertAtPos(int data, int iPos)
    {
        // filter
        if(iPos < 1 || iPos > iCount+1)
        {
            System.out.println("Please Enter Valid Position.");
            return false;
        }
        // create a new node
        if(iPos == 1){
            return insertfirst(data);
        }else if(iPos == iCount+1)
        {
            return insertLast(data);
        }else{
            Node temp = head;
            Node newn = new Node(data);
            for(int i= 1; i < iPos-1;i++)
            {
                temp = temp.getNext();
            }
            newn.setNext(temp.getNext());
            temp.getNext().setPrev(newn);
            newn.setPrev(temp);
            temp.setNext(newn);
            iCount++;
            return true;
        }
    }

    public boolean deleteFirst()
    {
        if(head == null){
            System.out.println("Linked List is already Empty.");
            return false;
        }
        else if(head == tail){
            head = null;
            tail = null;
            iCount--;
            return true;
        }else{
            head = head.getNext();
            tail.setNext(head);
            head.setPrev(tail);
            iCount--;
            return true;
        }
    }

    public boolean deleteLast()
    {
        if(head == null && tail == null)
        {
            System.out.println("Linked List is already empty.");
            return false;
        }

        if(head == tail){
            head = null;
            tail = null;
            iCount--;
            return true;
        }else{
            tail = tail.getPrev();
            tail.setNext(head);
            head.setPrev(tail);
            iCount--;
            return true;
        }
    }

    public boolean deleteAtPos(int iPos)
    {
        if(iPos < 0 || iPos > iCount)
        {
            System.out.println("Invalid Position.");
            return false;
        }

        if(iPos == 1){
            return deleteFirst();
        }else if(iPos == iCount){
            return deleteLast();
        }else{
            Node temp = head;
            for(int i=1; i<iPos-1; i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
            temp.getNext().setPrev(temp);
            iCount--;
            return false;
        }
    }
}
