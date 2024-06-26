package SelectionSort;

public class Main {
    
        public static void main(String[] args) {
            int arr[] = new int[5];
            arr[0] = 111;
            arr[1] = 122;
            arr[2] = 51;
            arr[3] = 101;
            arr[4] = 201;
    
            SelectionSort ss =new SelectionSort();
            
            ss.Selection(arr);

            for(int a : arr)
            {
                System.out.print(a + " ");
            }
         
    }
}

