package ThreadedBinaryTree;

public class Main {
    public static void main(String[] args) {
        ThreadedBinaryTree t1 = new ThreadedBinaryTree();
        t1.insert(50);
        t1.insert(10);
        t1.insert(20);
        t1.insert(30);
        t1.insert(60);
        t1.insert(55);
        t1.insert(75);
        t1.insert(90);
        System.out.println(t1.insert(60));
        t1.inOrder();
        t1.preOrder();
        t1.postOrder();
        t1.delete(50);
        t1.inOrder();
        t1.delete(20);
        t1.inOrder();
    }
}
