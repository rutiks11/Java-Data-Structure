package BubbleSort;

public class BubbleSort {

    public int[] BubbleSorting(int [] arr)
    {
        int temp =0;
        for(int i=0;i<arr.length-1 ;i++)
        {
            for(int j= i+1; j < arr.length-i ;j++)
            {
                if(arr[i] > arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
