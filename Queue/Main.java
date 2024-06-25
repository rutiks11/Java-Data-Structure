package Queue;

public class Main {
    public static void main(String[] args) {
        
        CircularQueue cl = new CircularQueue(5);
        cl.insert(11);
        cl.insert(21);
        cl.insert(51);
        System.out.println(cl.insert(101));
        System.out.println(cl.insert(151));
        System.out.println(cl.insert(151));
        System.out.println(cl.dalete());
        System.out.println(cl.dalete());
        System.out.println(cl.dalete());
        System.out.println(cl.dalete());
        System.out.println(cl.dalete());
        System.out.println(cl.isEmpty());
        System.out.println(cl.isFull());


    }
}
