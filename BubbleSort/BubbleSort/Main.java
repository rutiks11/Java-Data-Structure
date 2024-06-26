package BubbleSort;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[5];
        arr[0] = 101;
        arr[1] = 122;
        arr[2] = 51;
        arr[3] = 101;
        arr[4] = 201;

        BubbleSort bs = new BubbleSort();
        arr = bs.BubbleSorting(arr);

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("Arr[" + i + "] = " + arr[i]);
        }
    }    
}