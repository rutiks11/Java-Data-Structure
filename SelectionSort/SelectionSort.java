package SelectionSort;

public class SelectionSort {

    public int[] Selection(int arr[]) {
        int iMindex = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            iMindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[iMindex] > arr[j]) {
                    iMindex = j;
                }

            }
            temp = arr[iMindex];
            arr[iMindex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}
