package Arrays.Array;

public class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if(n==1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            if(arr[mid] > arr[mid-1]) low = mid+1;
            else high = mid-1;
        }
    return -1;
    }
    public static void main(String[] args) {
        int[] arr= {2,3,6,2,9,1};
        System.out.println(findPeakElement(arr));
    }
}
