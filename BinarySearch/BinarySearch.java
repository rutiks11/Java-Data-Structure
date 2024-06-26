package BinarySearch;

public class BinarySearch {
    public int BinarySearching(int arr[], int iNo) {
        int iStart = 0;
        int iEnd = arr.length - 1;
        int iMid = (iEnd + iStart) / 2;

        while (iStart <= iEnd) {

            if (arr[iStart] == iNo) {
                return iStart;
            }
            if (arr[iEnd] == iNo) {
                return iEnd;
            }
            if (arr[iMid] == iNo) {
                return iMid;
            }

            if (iNo < iMid) {
                iEnd = iMid - 1;
                iMid = (iEnd + iStart) / 2;
            } else {
                iStart = iMid + 1;
                iMid = (iEnd + iStart) / 2;
            }
        }
        
        return -1;
    }
}
