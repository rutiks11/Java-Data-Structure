package Queue;

class CircularQueue {
    private int arr[];
    private int iSize;
    private int front, rear;

    // initialize the variables
    CircularQueue(int iSize) {
        this.iSize = iSize;
        arr = new int[iSize];
        front = rear = -1;
    }

    public boolean isFull()
    {
        return (((front==-1) && (rear == iSize-1)) || ((rear+1)%iSize == front));
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean insert(int data) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % iSize;
        arr[rear] = data;

        return true;
    }

    public int dalete() {
        if (isEmpty()) {
            return -1;
        }

        front = (front + 1) % iSize;
        return arr[front];

    }
}