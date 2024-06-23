package ThreadedBinaryTree;

public class Node {
    private int data;
    private Node right;
    private Node left;
    private char lflag;
    private char rflag;

    Node(int data)
    {
        this.data = data;
        right = left = null;
        lflag = rflag = 'T';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public char getLflag() {
        return lflag;
    }

    public void setLflag(char lflag) {
        this.lflag = lflag;
    }

    public char getRflag() {
        return rflag;
    }

    public void setRflag(char rflag) {
        this.rflag = rflag;
    }

    
}
