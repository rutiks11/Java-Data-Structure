package BinarySearch;

public class Main {
    
        public static void main(String[] args) {
            int arr[] = new int[5];
            arr[0] = 111;
            arr[1] = 122;
            arr[2] = 51;
            arr[3] = 101;
            arr[4] = 201;
    
            BinarySearch bs =new BinarySearch();
            
            System.out.println(bs.BinarySearching(arr, 51));
            System.out.println(bs.BinarySearching(arr, 555));
            
            System.out.println(bs.BinarySearching(arr, 101));

         
    }
}

