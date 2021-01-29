package niuke;

public class A_MaxSumOfSubArray {
    /**
     * dp
     * @param arr
     * @return
     */
    public int maxsumofSubarray (int[] arr) {
        int max = 0;
        if(arr.length==1)
            return Math.max(0,arr[0]);
        for(int i=1;i<arr.length;i++){
            arr[i] = Math.max(arr[i],arr[i]+arr[i-1]);
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}
